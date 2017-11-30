package com.hmkj.taozhifu.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.ZfCodePresenter;
import com.hmkj.taozhifu.mview.ZfCodeView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.PswInputView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/31.
 */

public class PayPwdActivity extends BaseActivity implements ZfCodeView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.psw_input)
    PswInputView pswInput;
    @BindView(R.id.code_EditText)
    EditText codeEditText;
    @BindView(R.id.mGain_Code)
    TextView mGainCode;
    @BindView(R.id.mSave)
    Button mSave;
    String pwd_zf;
    ZfCodePresenter zfCodePresenter;
    int i = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        zfCodePresenter = new ZfCodePresenter(this, this);
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void initData() {
        pswInput.setInputCallBack(new PswInputView.InputCallBack() {
            @Override
            public void onInputFinish(final String result) {
                if (TextUtils.isEmpty(result)) {
                    return;
                }
                pwd_zf = result;
                LogUtil.LogLong("输入完毕后的支付密码" + pwd_zf);
            }

        });
    }

    @Override
    public void initView() {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("设置支付密码");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);

    }

    @OnClick({R.id.mGain_Code, R.id.mSave})
    public void onClick(View view) {
        String phone = (String) SharedPreferencesUtil.get(this, "phone", "");
        String code = codeEditText.getText().toString();
        switch (view.getId()) {
            case R.id.mGain_Code:
                zfCodePresenter.getCode(phone);
                break;
            case R.id.mSave:
                if (TextUtils.isEmpty(pwd_zf) || pwd_zf.length() < 6) {
                    ToastUtil.showToast("请输入6位数支付密码！");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    ToastUtil.showToast("请输入验证码！");
                    return;
                }
                try {
                    LogUtil.LogLong("输入的支付密码" + pwd_zf);
                    OkGo.<String>patch(HttpConfig.SETTING_ZF_PWD + getMemberId())
                            .params("passWord", MD5Builder.getMD5(pwd_zf))
                            .params("code", code)
                            .params("phone", phone)
                            .execute(new CustomCallback(this) {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    super.onSuccess(response);
                                    LogUtil.LogLong("请求的结果" + response.body());
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.body());
                                        int httpcode = jsonObject.getInt("code");
                                        String msg = jsonObject.getString("msg");
                                        if (httpcode == 200) {
                                            ToastUtil.showToast("支付密码设置成功!");
                                            finish();
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

                break;
        }
    }

    @Override
    public void getzfCodeSuccess() {//成功获取验证码→进行倒计时

    }

    @Override
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
        public void handleMessage(Message msg) {
            if (msg.what == -9) {
                mGainCode.setClickable(false);
                mGainCode.setText("重新发送" + i + "s");
                mGainCode.setEnabled(false);
            } else if (msg.what == -8) {
                mGainCode.setText("获取验证码");
                mGainCode.setEnabled(true);
                mGainCode.setClickable(true);
                i = 60;
            }
        }
    };
}
