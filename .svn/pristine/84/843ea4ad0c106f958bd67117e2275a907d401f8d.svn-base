package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/31.
 */

public class LoginPwdActivity extends BaseActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.new_pwd)
    EditText newPwd;
    @BindView(R.id.hide)
    ImageView hide;
    @BindView(R.id.new_pwds)
    EditText newPwds;
    @BindView(R.id.show)
    ImageView show;
    @BindView(R.id.mSave)
    Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pay);
        ButterKnife.bind(this);

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
        toolbarTitle.setText("设置登录密码");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }


    @OnClick({R.id.hide, R.id.show, R.id.mSave})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hide:
                break;
            case R.id.show:
                break;
            case R.id.mSave:
                break;
        }
    }
}
