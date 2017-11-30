package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.ForgetPwdPresenter;
import com.hmkj.taozhifu.mview.ForgetPwdView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ForgetPwdActivity extends BaseActivity implements ForgetPwdView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mPhone)
    EditText mPhone;
    @BindView(R.id.code_EditText)
    EditText codeEditText;
    @BindView(R.id.mGain_Code)
    TextView mGainCode;
    @BindView(R.id.mTime)
    TextView mTime;
    @BindView(R.id.mNext)
    Button mNext;
    private ForgetPwdPresenter forgetPwdPresenter;
    int i = 60;
    String phone;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        ButterKnife.bind(this);
        forgetPwdPresenter = new ForgetPwdPresenter(this, this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("找回密码");
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.mGain_Code, R.id.mNext})
    public void onClick(View view) {
        phone = mPhone.getText().toString();
        code = codeEditText.getText().toString();
        switch (view.getId()) {
            case R.id.mGain_Code:
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(getString(R.string.input_phone));
                    return;
                }
                OkGo.<String>post(HttpConfig.GET_CODE)
                        .cacheMode(CacheMode.NO_CACHE)
                        .params("phone", phone)
                        .params("type", "2")
                        .execute(new CustomCallback(this) {
                            @Override
                            public void onSuccess(Response<String> response) {
                                super.onSuccess(response);
                                LogUtil.LogLong("获取验证码" + response.body());
                                try {
                                    JSONObject jsonObject = new JSONObject(response.body());
                                    int httpcode = jsonObject.getInt("code");
                                    String msg = jsonObject.getString("msg");
                                    if (httpcode == 200) {
                                        startTime();
                                    } else {
                                        ToastUtil.showToast(msg);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                break;
            case R.id.mNext:
                forgetPwdPresenter.isCode(phone, code);
                break;
                default:
                    break;
        }
    }


    public void startTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; i > 0; i--) {
                    handler.sendEmptyMessage(-9);
                    if (i <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(-8);
            }
        }).start();
    }


    @Override
    public void isTrueCode(String mphone) {//验证码正确
        Intent intent = new Intent(ForgetPwdActivity.this, SetPwdForgetActivity.class);
        intent.putExtra("phone", mphone);
        startActivity(intent);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                mPhone.setEnabled(false);
                mGainCode.setClickable(false);
                mGainCode.setText("重新发送");
                mTime.setText(i + "s");
                mTime.setVisibility(View.VISIBLE);
                mGainCode.setEnabled(false);
            } else if (msg.what == -8) {
                mPhone.setEnabled(true);
                mPhone.setClickable(true);
                mGainCode.setText("获取验证码");
                mTime.setVisibility(View.INVISIBLE);
                mGainCode.setEnabled(true);
                mGainCode.setClickable(true);
                i = 60;
            }
        }
    };
}
