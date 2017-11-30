package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/5.
 */

public class SetPwdForgetActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mPwd)
    EditText mPwd;
    @BindView(R.id.mPwds)
    EditText mPwds;
    @BindView(R.id.mRegist)
    Button mRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpwd_forget);
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
        toolbarTitle.setText("设置密码");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick(R.id.mRegist)
    public void onClick() {//忘记密码→设置密码
        final String password = mPwd.getText().toString();
        String passwords = mPwds.getText().toString();
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(passwords)) {
            ToastUtil.showToast("请输入6-11位密码");
            return;
        }
        if (password.length() < 6 || passwords.length() < 6) {
            ToastUtil.showToast("请输入6-11位密码!");
            return;
        }
        if (!password.equals(passwords)) {
            ToastUtil.showToast("请输入相同的密码");
            return;
        }
        try {
            OkGo.<String>post(HttpConfig.FORGET_PWD_SET)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("phone", getIntent().getStringExtra("phone"))
                    .params("password", MD5Builder.getMD5(password))
                    .execute(new CustomCallback(this) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int httpCode = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                if (httpCode == 200) {
                                    login(getIntent().getStringExtra("phone"), password);
                                } else {
                                    ToastUtil.showToast(msg);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //密码设置成功就直接登录
    public void login(String phone, String pwd) {
        try {
            OkGo.<String>post(HttpConfig.LOGIN)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("phone", phone)
                    .params("password", MD5Builder.getMD5(pwd))
                    .execute(new CustomCallback(this) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int httpCode = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                String token = jsonObject.getString("token");
                                String expire = jsonObject.getString("expire");
                                long memberId = jsonObject.getLong("memberId");//用户id
                                if (httpCode == 200) {
                                    OkGo.getInstance().addCommonHeaders(new HttpHeaders("token", token));
                                    SharedPreferencesUtil.put(SetPwdForgetActivity.this, "token", token);//登录成功返回的Token
                                    SharedPreferencesUtil.put(SetPwdForgetActivity.this, "expire", expire);//登录成功返回的Expire
                                    SharedPreferencesUtil.put(SetPwdForgetActivity.this, "memberId", memberId);//登录成功返回的memberId
                                    startActivity(new Intent(SetPwdForgetActivity.this, MainActivity.class));
                                } else {
                                    ToastUtil.showToast(msg);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
