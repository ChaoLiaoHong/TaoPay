package com.hmkj.taozhifu.activity;

import android.content.Intent;
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
import com.hmkj.taozhifu.adapter.NoticeAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.HomeNoticeEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hmkj.taozhifu.http.HttpConfig.querySysNotice;

public class NoticeListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

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
    @BindView(R.id.rv_notice_list)
    RecyclerView rvNoticeList;
    @BindView(R.id.refresh)
    SwipeRefreshView refresh;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    @BindView(R.id.ll_on_null)
    LinearLayout llOnNull;
    private int pageNum = 1;
    private HomeNoticeEntity homeNoticeEntity;
    private List<HomeNoticeEntity.DataBean.RecordsBean> recordsBeen = new ArrayList<>();
    private NoticeAdapter noticeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        refresh.setOnRefreshListener(this);
        noticeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(NoticeListActivity.this, NoticeDetailsActivity.class);
                intent.putExtra("NOTICE", recordsBeen.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        querySysNotice();
    }

    @Override
    public void initView() {
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(R.string.tv_notice);
        rvNoticeList.setLayoutManager(new LinearLayoutManager(this));
        noticeAdapter = new NoticeAdapter(this, null);
        rvNoticeList.setAdapter(noticeAdapter);
        noticeAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        noticeAdapter.isFirstOnly(false);
        noticeAdapter.setLoadMoreView(new CustomLoadMoreView());
        noticeAdapter.setOnLoadMoreListener(this, rvNoticeList);
        noticeAdapter.disableLoadMoreIfNotFullPage();
        tvNullStateContent.setText("目前没有任何公告");
        tvNullStateOnClick.setVisibility(View.GONE);
    }

    private void querySysNotice() {
        refresh.setRefreshing(true);
        OkGo.<String>post(querySysNotice)
                .params("page", String.valueOf(pageNum))
                .params("size", String.valueOf(10))
                .params("type", String.valueOf(1))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()) refresh.setRefreshing(false);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        refresh.setRefreshing(false);
                        LogUtil.LogLong("公告数据", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                homeNoticeEntity = GsonUtil.GsonToBean(response.body(), HomeNoticeEntity.class);
                                if (homeNoticeEntity.getData() != null && homeNoticeEntity.getData().getRecords() != null && homeNoticeEntity.getData().getRecords().size() != 0) {
                                    pageNum++;
                                    recordsBeen.clear();
                                    recordsBeen.addAll(homeNoticeEntity.getData().getRecords());
                                    noticeAdapter.setNewData(recordsBeen);
                                    llOnNull.setVisibility(View.VISIBLE);
                                    llNullState.setVisibility(View.GONE);
                                } else {
                                    llNullState.setVisibility(View.VISIBLE);
                                    llOnNull.setVisibility(View.GONE);
                                }

                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @OnClick(R.id.top_btn_left)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        querySysNotice();
        noticeAdapter.removeAllFooterView();
    }

    @Override
    public void onLoadMoreRequested() {
        OkGo.<String>post(querySysNotice)
                .params("page", String.valueOf(pageNum))
                .params("size", String.valueOf(10))
                .params("type", String.valueOf(1))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        noticeAdapter.removeAllFooterView();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        noticeAdapter.loadMoreComplete();
                        LogUtil.LogLong("公告数据更多", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                homeNoticeEntity = GsonUtil.GsonToBean(response.body(), HomeNoticeEntity.class);
                                if (homeNoticeEntity.getData() != null && homeNoticeEntity.getData().getRecords() != null) {
                                    pageNum++;
                                    if (homeNoticeEntity.getData().getRecords().size() != 0) {
                                        noticeAdapter.addData(homeNoticeEntity.getData().getRecords());
                                    } else {
                                        //显示没有更多数据
                                        View noDataView = LayoutInflater.from(NoticeListActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rvNoticeList.getParent(), false);
                                        noticeAdapter.setFooterView(noDataView);
                                        noticeAdapter.setEnableLoadMore(false);
                                    }
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}
