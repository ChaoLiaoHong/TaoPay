package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyStoreAccountPaidAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.MyStoreAccountPaidBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.ui.SpacesItemDecoration;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStoreAccountPaidActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private long shopId;
    private MyStoreAccountPaidAdapter myStoreAccountPaidAdapter;
    int pageNum = 1;
    private MyStoreAccountPaidBean myStoreAccountPaidBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_account_paid);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        loadData(pageNum = 1);

    }

    private void loadData(int pageNum) {
        OkGo.<String>get(String.format(HttpConfig.selectOrderByMemberId, shopId))
                .params("memberId", getMemberId())
                .params("orderStatus", 2)
                .params("pageNum", pageNum)
                .params("pageSize", 30)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("已收款订单 -- " + response.body());
                        if (myStoreAccountPaidAdapter.isLoading())
                            myStoreAccountPaidAdapter.loadMoreComplete();
                        if (checkHttpCode(response.body())) {
                            myStoreAccountPaidBean = GsonUtil.GsonToBean(response.body(), MyStoreAccountPaidBean.class);
                            if (myStoreAccountPaidBean != null && myStoreAccountPaidBean.orderList != null && myStoreAccountPaidBean.orderList.records != null) {
                                if (myStoreAccountPaidBean.orderList.records.size() > 0) {
                                    setInfo(getArrayList(myStoreAccountPaidBean.orderList.records));
                                } else {
                                    myStoreAccountPaidAdapter.setFooterView(getFootView((ViewGroup) recyclerView.getParent()));
                                    myStoreAccountPaidAdapter.setEnableLoadMore(false);
                                }
                            }
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        ToastUtil.showToast(getHttpMsg(response.body()));
                        if (myStoreAccountPaidAdapter.isLoading())
                            myStoreAccountPaidAdapter.loadMoreFail();
                    }
                });
    }

    private ArrayList<MyStoreAccountPaidBean.OrderListBean.RecordsBean> getArrayList(List<MyStoreAccountPaidBean.OrderListBean.RecordsBean> records) {
        ArrayList<MyStoreAccountPaidBean.OrderListBean.RecordsBean> record = new ArrayList<>();
        for (MyStoreAccountPaidBean.OrderListBean.RecordsBean recordsBean : records) {
            if (!AppUtils.checkId(recordsBean.orderCode))record.add(recordsBean);
        }
        return record;
    }

    private void setInfo(List<MyStoreAccountPaidBean.OrderListBean.RecordsBean> records) {
        if (pageNum == 1)
            myStoreAccountPaidAdapter.setNewData(records);
        else
            myStoreAccountPaidAdapter.addData(records);
    }

    @Override
    public void initView() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, "", 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setText("收款订单");
        toolbarTitle.setTextColor(Color.BLACK);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        shopId = getIntent().getLongExtra("shopId", 0l);
        setAdapter();
    }

    private void setAdapter() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpacesItemDecoration(CommonUtil.dp2px(this, 10), 1));
        myStoreAccountPaidAdapter = new MyStoreAccountPaidAdapter(null, this);
        myStoreAccountPaidAdapter.setOnLoadMoreListener(this, recyclerView);
        myStoreAccountPaidAdapter = (MyStoreAccountPaidAdapter) setBaseAdapter(myStoreAccountPaidAdapter, true);
        myStoreAccountPaidAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(myStoreAccountPaidAdapter);
    }

    @Override
    public void onLoadMoreRequested() {
        loadData(pageNum = pageNum + 1);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
