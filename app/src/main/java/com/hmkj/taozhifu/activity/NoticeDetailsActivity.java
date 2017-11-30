package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.HomeNoticeEntity;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.TimeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeDetailsActivity extends BaseActivity {

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
    @BindView(R.id.tv_notice_name)
    TextView tvNoticeName;
    @BindView(R.id.tv_notice_date)
    TextView tvNoticeDate;
    @BindView(R.id.tv_notice_content)
    WebView tvNoticeContent;
    private Intent intent;
    private HomeNoticeEntity.DataBean.RecordsBean recordsBean;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_details);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        intent = getIntent();
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        recordsBean = (HomeNoticeEntity.DataBean.RecordsBean) intent.getSerializableExtra("NOTICE");
    }

    @Override
    public void initData() {
        tvNoticeName.setText(recordsBean.getNoticeName());
        tvNoticeDate.setText(TimeUtil.getTime2String(recordsBean.getCreateTime(), ""));
        data = "<meta charset=\"utf-8\"/><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />" +
                recordsBean.getNoticeContent();
        data += "<style type='text/css'> img{width:100%}</style>";
        tvNoticeContent.loadData(data, "text/html; charset=UTF-8", null);
    }


    @OnClick(R.id.top_btn_left)
    public void onViewClicked() {
        finish();
    }
}
