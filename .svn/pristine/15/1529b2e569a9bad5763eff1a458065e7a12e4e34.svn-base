package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ShopCommentAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShopCommentEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SnackBarUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserCommentsActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.rv_comments_info)
    RecyclerView rvCommentsInfo;
    @BindView(R.id.refresh)
    SwipeRefreshView refreshView;
    private Intent intent;
    private ShopCommentEntity mShopCommentEntity;
    private List<ShopCommentEntity.DataBean.RecordsBean> mRecordsBean = new ArrayList<>();
    private ShopCommentAdapter mShopCommentAdapter;
    int current = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comments);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        rvCommentsInfo.setItemAnimator(new DefaultItemAnimator());
        rvCommentsInfo.setLayoutManager(new LinearLayoutManager(this));
        mShopCommentAdapter = new ShopCommentAdapter(this, null);
        rvCommentsInfo.setAdapter(mShopCommentAdapter);
        mShopCommentAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mShopCommentAdapter.isFirstOnly(false);
        mShopCommentAdapter.setLoadMoreView(new CustomLoadMoreView());
        mShopCommentAdapter.setOnLoadMoreListener(this, rvCommentsInfo);
        mShopCommentAdapter.disableLoadMoreIfNotFullPage();
        refreshView.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        loadData();
    }

    private void loadData() {
        refreshView.setRefreshing(true);
        OkGo.<String>post(HttpConfig.getShopCommentByShop)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .params("current", current)
                .params("size", 10)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        refreshView.setRefreshing(false);
                        LogUtil.LogLong("所有评论", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCommentEntity = GsonUtil.GsonToBean(response.body(), ShopCommentEntity.class);
                                if (mShopCommentEntity != null && mShopCommentEntity.getData().getRecords() != null) {
                                    if (mShopCommentEntity.getData().getRecords().size() != 0) {
                                        current++;
                                        mShopCommentAdapter.setNewData(mShopCommentEntity.getData().getRecords());
                                    }
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        showToast(response.getException().getMessage());
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mShopCommentAdapter.removeAllFooterView();
                        refreshView.setRefreshing(false);
                    }
                });
    }

    @Override
    public void initView() {
        intent = getIntent();
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(R.string.tv_user_comments);
        LogUtil.LogLong("商品Id", intent.getStringExtra("shopId"));
    }

    @OnClick(R.id.top_btn_left)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onRefresh() {
        current = 1;
        loadData();
    }

    @Override
    public void onLoadMoreRequested() {
        OkGo.<String>post(HttpConfig.getShopCommentByShop)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .params("current", current)
                .params("size", 10)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        mShopCommentAdapter.loadMoreComplete();
                        mShopCommentAdapter.setEnableLoadMore(false);
                        LogUtil.LogLong("所有评论loadMore", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCommentEntity = GsonUtil.GsonToBean(response.body(), ShopCommentEntity.class);
                                if (mShopCommentEntity != null && mShopCommentEntity.getData().getRecords() != null) {
                                    if (mShopCommentEntity.getData().getRecords().size() != 0) {
                                        current++;
                                        mShopCommentAdapter.addData(mShopCommentEntity.getData().getRecords());
                                    } else {
                                        //显示没有更多数据
                                        View noDataView = LayoutInflater.from(UserCommentsActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rvCommentsInfo.getParent(), false);
                                        mShopCommentAdapter.setFooterView(noDataView);
                                        mShopCommentAdapter.setEnableLoadMore(false);
                                    }
                                }

                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mShopCommentAdapter.loadMoreFail();
                    }
                });
    }


    public void showToast(String msg) {
        SnackBarUtil.showShortSnackbar(rvCommentsInfo, msg);
    }
}
