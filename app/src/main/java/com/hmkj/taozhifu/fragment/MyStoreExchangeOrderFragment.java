package com.hmkj.taozhifu.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyStoreExchengeOrderAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.ExchengeOrderBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyStoreExchangeOrderFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MyStoreExchengeOrderAdapter myStoreExchengeOrderAdapter;
    private List<String> list;
    int pageNum = 1;
    private ExchengeOrderBean exchengeOrderBean;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_store_exchange_order, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        myStoreExchengeOrderAdapter = new MyStoreExchengeOrderAdapter(context, null);
        myStoreExchengeOrderAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        myStoreExchengeOrderAdapter.isFirstOnly(false);
        myStoreExchengeOrderAdapter.setLoadMoreView(new CustomLoadMoreView());
        myStoreExchengeOrderAdapter.setOnLoadMoreListener(this, recyclerView);
        myStoreExchengeOrderAdapter.disableLoadMoreIfNotFullPage();//默认第一次加载会进入回调，如果不需要可以配置
        recyclerView.setAdapter(myStoreExchengeOrderAdapter);
        myStoreExchengeOrderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    protected void initData() {
        initDatas(pageNum = 1);
    }

    private void initDatas(int pageNum) {
        LogUtil.LogLong("pageNum -- " + pageNum);
        int orderStatus = 0;
        switch (getTitle()) {
            case "待使用":
                orderStatus = 2;
                break;
            case "已使用":
                orderStatus = 3;
                break;
            case "已完成":
                orderStatus = 4;
                break;
        }
        HttpParams params = new HttpParams();
        params.put("memberId", getMemberId());
        params.put("pageNum", pageNum);
        params.put("pageSize", 20);
        if (orderStatus != 0)
            params.put("orderStatus", orderStatus);
        OkGo.<String>get(String.format(HttpConfig.selectExchangeOrder, getMemberId()))
                .params(params)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        LogUtil.LogLong("MyStoreExchangeOrderFragment - onStart");
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("兑换订单 -- " + response.body());
                        if (myStoreExchengeOrderAdapter.isLoading())
                            myStoreExchengeOrderAdapter.loadMoreComplete();
                        if (checkHttpCode(response.body())) {
                            exchengeOrderBean = GsonUtil.GsonToBean(response.body(), ExchengeOrderBean.class);
                            if (exchengeOrderBean != null && exchengeOrderBean.ordersPage != null && exchengeOrderBean.ordersPage.records != null) {
                                if (exchengeOrderBean.ordersPage.records.size() > 0) {
                                    setInfo(exchengeOrderBean.ordersPage.records);
                                } else {
                                    myStoreExchengeOrderAdapter.setFooterView(inflater.inflate(R.layout.item_no_data, (ViewGroup) recyclerView.getParent(), false));
                                    myStoreExchengeOrderAdapter.setEnableLoadMore(false);
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
                        if (myStoreExchengeOrderAdapter.isLoading())
                            myStoreExchengeOrderAdapter.loadMoreFail();
                    }
                });
    }

    private void setInfo(List<ExchengeOrderBean.OrdersPageBean.RecordsBean> exchengeOrderBean) {
        ArrayList<ExchengeOrderBean.OrdersPageBean.RecordsBean> exchengeOrderBeans = new ArrayList<>();
        for (ExchengeOrderBean.OrdersPageBean.RecordsBean recordsBean : exchengeOrderBean) {
            if (recordsBean.orderStatus != 5 & recordsBean.orderStatus != 6){
                exchengeOrderBeans.add(recordsBean);
            }
        }
        if (pageNum == 1)
            myStoreExchengeOrderAdapter.setNewData(exchengeOrderBeans);
        else
            myStoreExchengeOrderAdapter.addData(exchengeOrderBeans);
    }

    public static MyStoreExchangeOrderFragment newInstance() {
        return new MyStoreExchangeOrderFragment();
    }

    @Override
    public void onLoadMoreRequested() {
        initDatas(pageNum = pageNum + 1);
    }
}
