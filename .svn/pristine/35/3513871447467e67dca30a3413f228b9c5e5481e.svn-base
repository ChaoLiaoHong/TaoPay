package com.hmkj.taozhifu.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.WithdrawDepositRecordAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.WithdrawDepositRecordEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WithdrawDepositRecordActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.top_btn_right)
    Button topBtnRight;
    @BindView(R.id.top_iv_right)
    ImageView topIvRight;
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.record_rv)
    RecyclerView recordRv;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    @BindView(R.id.srv)
    SwipeRefreshView srv;
    private WithdrawDepositRecordEntity withdrawDepositRecordEntity;
    private WithdrawDepositRecordAdapter adapter;
    private LayoutInflater inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_deposit_record);
        ButterKnife.bind(this);
        srv.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        LoadData();

    }

    private void LoadData() {
        srv.setRefreshing(true);
        OkGo.<String>get(String.format(HttpConfig.withdrawalRecord, getMemberId()))
                .params("current", 1)
                .params("size", 10)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        srv.setRefreshing(false);
                        LogUtil.LogLong("提现记录", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            if (code == 200) {
                                withdrawDepositRecordEntity = GsonUtil.GsonToBean(response.body(), WithdrawDepositRecordEntity.class);
                                if (withdrawDepositRecordEntity != null && withdrawDepositRecordEntity.getPage() != null && withdrawDepositRecordEntity.getPage().getRecords() != null) {
                                    if (withdrawDepositRecordEntity.getPage().getRecords().size() != 0) {
                                        srv.setVisibility(View.VISIBLE);
                                        llNullState.setVisibility(View.GONE);
                                        adapter.setNewData(withdrawDepositRecordEntity.getPage().getRecords());
                                    } else {
                                        llNullState.setVisibility(View.VISIBLE);
                                        srv.setVisibility(View.GONE);
                                    }
                                }
                            }
                        } catch (JSONException e) {

                        }
                    }
                });
    }

    @Override
    public void initView() {
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        inflate = LayoutInflater.from(this);
        topTitle.setText("提现记录");
        recordRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WithdrawDepositRecordAdapter();
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.isFirstOnly(false);
        adapter.setLoadMoreView(new CustomLoadMoreView());
        adapter.setOnLoadMoreListener(this, recordRv);
        adapter.disableLoadMoreIfNotFullPage();//默
        recordRv.setAdapter(adapter);
        tvNullStateOnClick.setVisibility(View.GONE);
        tvNullStateContent.setText("您还没有提现的记录");
    }

    @OnClick(R.id.top_btn_left)
    public void onViewClicked() {
        finish();
    }

    int pageNum = 2;

    @Override
    public void onLoadMoreRequested() {
        OkGo.<String>get(String.format(HttpConfig.withdrawalRecord, getMemberId()))
                .params("current", pageNum)
                .params("size", 10)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("提现记录", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            if (code == 200) {
                                withdrawDepositRecordEntity = GsonUtil.GsonToBean(response.body(), WithdrawDepositRecordEntity.class);
                                if (withdrawDepositRecordEntity != null && withdrawDepositRecordEntity.getPage() != null && withdrawDepositRecordEntity.getPage().getRecords() != null) {
                                    pageNum++;
                                    if (withdrawDepositRecordEntity.getPage().getRecords().size() != 0) {
                                        adapter.loadMoreComplete();
                                        adapter.addData(withdrawDepositRecordEntity.getPage().getRecords());
                                    } else {
                                        adapter.loadMoreComplete();
                                        View noDataView = inflate.inflate(R.layout.item_no_data, (ViewGroup) recordRv.getParent(), false);
                                        adapter.setFooterView(noDataView);
                                        adapter.setEnableLoadMore(false);
                                    }
                                }
                            }
                        } catch (JSONException e) {

                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        adapter.removeAllFooterView();
                    }
                });
    }

    @Override
    public void onRefresh() {
        LoadData();
        adapter.removeAllFooterView();
    }
}
