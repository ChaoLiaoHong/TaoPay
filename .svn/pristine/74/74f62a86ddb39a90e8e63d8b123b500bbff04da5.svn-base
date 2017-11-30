package com.hmkj.taozhifu.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.dialog.DialogPlayRemind;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutOurActivity extends BaseActivity {
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
    @BindView(R.id.wb_about_our)
    WebView wbAboutOur;
    @BindView(R.id.tv_about_our)
    TextView tvAboutOur;
    private String data;
    DialogPlayRemind dialogPlayRemind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_our);
    }

    @Override
    public void initData() {
        tvAboutOur.setText(data);
//        data = "<meta charset=\"utf-8\"/><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />" +
//                data;
//        data += "<style type='text/css'> img{width:100%}</style>";
//        wbAboutOur.loadData(data, "text/html; charset=UTF-8", null);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(R.string.aboutOur);
        data = CommonUtil.getString(R.string.about_us);
    }

    @OnClick(R.id.top_btn_left)
    public void onViewClicked() {
        finish();
    }
}
