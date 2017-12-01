package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.LoginPresenter;
import com.hmkj.taozhifu.mview.LoginView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author LuaKuangwi
 */

public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.top_btn_left)
    Button mBack;
    @BindView(R.id.mPhone)
    EditText mPhone;
    @BindView(R.id.mPwd)
    NOPasteEditText mPwd;
    @BindView(R.id.mForgetPwd)
    TextView mForgetPwd;
    @BindView(R.id.mLogin)
    Button mLogin;
    @BindView(R.id.mRegist)
    TextView mRegist;
    @BindView(R.id.mPwdHide)
    ImageView mPwdHide;
    @BindView(R.id.mCodeLogin)
    Button mCodeLogin;
    @BindView(R.id.code_EditText)
    EditText code_EditText;
    @BindView(R.id.mGain_Code)
    TextView mGainCode;
    @BindView(R.id.codeLy)
    LinearLayout codeLy;
    @BindView(R.id.pwdLy)
    LinearLayout pwdLy;
    @BindView(R.id.mTime)
    TextView mTime;
    LoginPresenter loginPresenter;
    private boolean isShow = true;
    int i = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        loginPresenter = new LoginPresenter(LoginActivity.this, this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.top_btn_left, R.id.mForgetPwd, R.id.mLogin, R.id.mRegist, R.id.mPwdHide, R.id.mCodeLogin, R.id.mGain_Code})
    public void onClick(View view) {
        String phone = mPhone.getText().toString();
        String pwd = mPwd.getText().toString();
        String code = code_EditText.getText().toString();
        switch (view.getId()) {
            //验证码登录
            case R.id.mCodeLogin:
                codeLy.setVisibility(View.VISIBLE);
                pwdLy.setVisibility(View.GONE);
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(getString(R.string.input_phone));
                    return;
                }
                loginPresenter.codeLogin(phone, code);
                break;
            //获取验证码
            case R.id.mGain_Code:
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(getString(R.string.input_phone));
                    return;
                }
                OkGo.<String>post(HttpConfig.GETSMS)
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
            case R.id.mPwdHide:
                if (isShow) {
                    mPwd.setSelection(pwd.length());
                    mPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPwdHide.setImageResource(R.drawable.ico_displayl_password);
                    isShow = false;
                } else {
                    mPwd.setSelection(pwd.length());
                    mPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mPwdHide.setImageResource(R.drawable.ico_conceal_password);
                    isShow = true;
                }
                break;
            case R.id.top_btn_left:
                finish();
                break;
            case R.id.mForgetPwd:
                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
                break;
            case R.id.mLogin:
                codeLy.setVisibility(View.GONE);
                pwdLy.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(getString(R.string.input_phone));
                    return;
                }
                loginPresenter.login(phone, pwd);
                break;
            case R.id.mRegist:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
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

    @Override
    public void loginSuccess() {
        finish();//发送广播
        EventBus.getDefault().post(new EventBusEntity(101));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case 110:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
