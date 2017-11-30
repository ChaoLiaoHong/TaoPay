package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.mpresenter.RspPresenter;
import com.hmkj.taozhifu.mview.RspView;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/23.
 */

public class SettiingPwdActivity extends BaseActivity implements RspView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mPwd)
    NOPasteEditText mPwd;
    @BindView(R.id.mPwds)
    NOPasteEditText mPwds;
    @BindView(R.id.mRegist)
    Button mRegist;
    private RspPresenter rspPresenter;
    String phone;
    String inviCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pwd);
        ButterKnife.bind(this);
        rspPresenter = new RspPresenter(SettiingPwdActivity.this, this);
        if (!TextUtils.isEmpty(this.getIntent().getStringExtra("phone"))) {//手机号码
            phone = this.getIntent().getStringExtra("phone");
        }
        if (!TextUtils.isEmpty(this.getIntent().getStringExtra("inviCode"))) {//邀请码
            inviCode = this.getIntent().getStringExtra("inviCode");
        }

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
        toolbarTitle.setText(R.string.setting_pwd);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.mRegist})
    public void onClick(View view) {
        String pwd = mPwd.getText().toString();
        String pwds = mPwds.getText().toString();
        switch (view.getId()) {
            case R.id.mRegist:
                rspPresenter.registFinal(phone, inviCode, pwd, pwds);
                break;
        }
    }

    @Override
    public void registFinalSuccess() {
        startActivity(new Intent(SettiingPwdActivity.this, MainActivity.class));
        EventBus.getDefault().post(new EventBusEntity(110));
        finish();
    }

}
