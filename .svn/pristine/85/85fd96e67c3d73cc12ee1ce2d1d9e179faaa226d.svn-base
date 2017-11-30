package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.FIUserPresenter;
import com.hmkj.taozhifu.mview.RealNameView;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/31.
 */

public class AutonymActivity extends BaseActivity implements RealNameView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.real_Name)
    EditText real_Name;
    @BindView(R.id.mSave)
    Button mSave;
    FIUserPresenter fiUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonym);
        ButterKnife.bind(this);
        fiUserPresenter = new FIUserPresenter(AutonymActivity.this, this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("实名认证");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick(R.id.mSave)
    public void onClick() {
        String realName = real_Name.getText().toString();
        fiUserPresenter.fiInUser(realName);
    }

    @Override
    public void UserInfoSuccess() {//真实姓名完善成功
        Intent mIntent = new Intent();
        mIntent.putExtra("realName", real_Name.getText().toString());
        // 设置结果，并进行传送
        this.setResult(HttpConfig.REQUEST_CODE_MY, mIntent);
        finish();
    }
}
