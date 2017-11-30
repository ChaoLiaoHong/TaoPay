package com.hmkj.taozhifu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyStoreProductAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.MyStoreProductBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.ui.SpacesItemDecoration;
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
import butterknife.OnClick;

public class MyStoreProductActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_my_store_product)
    RecyclerView rvMyStoreProduct;
    @BindView(R.id.tv_add_product)
    TextView tvAddProduct;
    private MyStoreProductAdapter myStoreProductAdapter;
    long shopId;
    private MyStoreProductBean myStoreProductBean;
    int pageNum = 1;
    List<MyStoreProductBean.ProCommodityPageBean.RecordsBean> data = new ArrayList<>();
    private View footView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_product);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        getStoreProduct(1);
    }

    private void getStoreProduct(final int pageNum) {
        OkGo.<String>get(String.format(HttpConfig.selectByMemberId, getMemberId()) + "?")
                .params("pageSize", "20")
                .params("memberId", getMemberId())
                .params("pageNum", pageNum)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("我的商品 -- " + response.body());
                        if (myStoreProductAdapter.isLoading())
                            myStoreProductAdapter.loadMoreComplete();
                        if (checkHttpCode(response.body())) {
                            myStoreProductBean = GsonUtil.GsonToBean(response.body(), MyStoreProductBean.class);
                            if (myStoreProductBean != null && myStoreProductBean.proCommodityPage != null) {
                                if (myStoreProductBean.proCommodityPage.records.size() > 0) {
                                    if (pageNum == 1) {
                                        data.clear();
                                        data.addAll(myStoreProductBean.proCommodityPage.records);
                                        myStoreProductAdapter.setNewData(myStoreProductBean.proCommodityPage.records);
                                    } else {
                                        data.addAll(myStoreProductBean.proCommodityPage.records);
                                        myStoreProductAdapter.addData(myStoreProductBean.proCommodityPage.records);
                                    }
                                } else {
                                    //没有商品
                                    myStoreProductAdapter.setEnableLoadMore(false);
                                    footView = getFootView((ViewGroup) rvMyStoreProduct.getParent());
                                    myStoreProductAdapter.setFooterView(footView);
                                }
                            }
                        }else{
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        if (myStoreProductAdapter.isLoading())
                            myStoreProductAdapter.loadMoreFail();
                    }
                });
    }

    @Override
    public void initView() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, "", 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setText("我的商品");
        toolbarTitle.setTextColor(Color.BLACK);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        shopId = getIntent().getLongExtra("shopId", 0l);
        setAdapter();
    }

    private void setAdapter() {
        rvMyStoreProduct.setItemAnimator(new DefaultItemAnimator());
        rvMyStoreProduct.setLayoutManager(new LinearLayoutManager(this));
        rvMyStoreProduct.addItemDecoration(new SpacesItemDecoration(CommonUtil.dp2px(this, 10),1));
        myStoreProductAdapter = new MyStoreProductAdapter(null, this);
        myStoreProductAdapter.setOnLoadMoreListener(this, rvMyStoreProduct);
        myStoreProductAdapter = (MyStoreProductAdapter) setBaseAdapter(myStoreProductAdapter, true);
        myStoreProductAdapter.setOnItemChildClickListener(this);
        rvMyStoreProduct.setAdapter(myStoreProductAdapter);
    }

    @OnClick(R.id.tv_add_product)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add_product:
                if (shopId != 0l) {
                    Intent intent = new Intent(this, MyStorePublishProductActivity.class);
                    intent.putExtra("shopId", shopId);
                    startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CommonStatu.REQUEST_CODE1 && resultCode == CommonStatu.OK) {
            getStoreProduct(1);
        }
    }

    @Override
    public void onLoadMoreRequested() {
        getStoreProduct(pageNum = pageNum + 1);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.ll_product_edit:
                //编辑
                Intent intent = new Intent(this, MyStorePublishProductActivity.class);
                intent.putExtra("shopId", shopId);
                intent.putExtra("commodityId", data.get(position).commodityId);
                startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                break;
            case R.id.ll_product_undercarriage:
                //下架
                if (TextUtils.equals("下架", ((TextView) ((LinearLayout) view).getChildAt(0)).getText()))
                    showDialog(2, position);
                else showDialog(1, position);
                break;
            case R.id.ll_content:
                //内容
                break;
        }
    }

    void showDialog(final int upState, final int position) {
        new AlertDialog.Builder(this)
                .setMessage("是否" + (upState == 1 ? "上架" : "下架") + "该商品")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        undercarriage(upState, position);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    private void undercarriage(final int upState, final int position) {
        //上架就传1，下架就传2
        OkGo.<String>put(HttpConfig.updateProCommodityByUpState)
                .params("memberId", getMemberId())
                .params("commodityId", data.get(position).commodityId)
                .params("upState", upState)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong(upState == 1 ? "上架 -- " : "下架 -- " + response.body());
                        if (checkHttpCode(response.body())) {
//                            myStoreProductAdapter.remove(position);
//                            data.remove(position);
                            getStoreProduct(1);
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }
}
