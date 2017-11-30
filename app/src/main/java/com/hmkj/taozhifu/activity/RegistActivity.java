package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.mpresenter.RegistPresenter;
import com.hmkj.taozhifu.mview.RegistView;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.ClearEditText;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.ProtocolDialog;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/23.
 *
 * @author LuaKuangwi
 */

public class RegistActivity extends BaseActivity implements RegistView {

    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.inviterCode)
    NOPasteEditText inviterCode;
    @BindView(R.id.mPhone)
    ClearEditText mPhone;
    @BindView(R.id.code_EditText)
    EditText codeEditText;
    @BindView(R.id.mGain_Code)
    TextView mGainCode;
    @BindView(R.id.mNext)
    Button mNext;
    @BindView(R.id.mCheck_state)
    CheckBox mCheckState;
    @BindView(R.id.mDeal)
    TextView mDeal;
    @BindView(R.id.mTime)
    TextView mTime;
    @BindView(R.id.sao_sao)
    ImageView sao_sao;
    private RegistPresenter registPresenter;
    int i = 60;
    String phone;
    String inviCode;
    String code;
    /**
     * 1扫一扫，2相册
     */
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        registPresenter = new RegistPresenter(this, this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.top_btn_left, R.id.mGain_Code, R.id.mNext, R.id.mCheck_state, R.id.mDeal, R.id.sao_sao})
    public void onClick(View view) {
        phone = mPhone.getText().toString();
        inviCode = inviterCode.getText().toString();
        code = codeEditText.getText().toString();
        boolean isCheck = mCheckState.isChecked();
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            case R.id.mGain_Code:
                if (TextUtils.isEmpty(phone)) {
                    ToastUtil.showToast(getString(R.string.input_phone));
                    return;
                }
                registPresenter.takeCode(phone, "1");
                break;
            case R.id.mNext:
                //判断三者是否都选择
                if (registPresenter.next(phone, inviCode, code, isCheck)) {
                    //判断验证码是否一致
                    registPresenter.isCode(phone, code);
                }
                break;
            case R.id.mDeal:
                new ProtocolDialog(this, CommonUtil.getString(R.string.user_agreement_title), CommonUtil.getString(R.string.user_agreement_content));
                break;
            case R.id.sao_sao:
                Intent intent = new Intent(RegistActivity.this, CaptureActivity.class);
                startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                break;
            default:
                break;

        }
    }


    @Override
    public void showSuccess() {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.LogLong("请求码" + requestCode);
        LogUtil.LogLong("返回码" + resultCode);
        //扫描返回结果
        if (requestCode == CommonStatu.REQUEST_CODE1) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Uri uri = Uri.parse(result);
                    String code = uri.getQueryParameter("code");
                    inviterCode.setText(code);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(RegistActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void showPhoneCodeNoNull() {
        ToastUtil.showToast("请完整信息!");
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

    @Override
    public void shoewIsCheck() {
        ToastUtil.showToast("请勾选商户协议!");
    }

    @Override
    public void showTrueCode() {
        phone = mPhone.getText().toString();
        inviCode = inviterCode.getText().toString();
        Intent intent = new Intent(RegistActivity.this, SettiingPwdActivity.class);
        intent.putExtra("phone", phone);
        intent.putExtra("inviCode", inviCode);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case 110:
                finish();
                break;
            case 88:
                String type = (String) SharedPreferencesUtil.get(this, "type_sao", "");
                if (type.equals("2")) {
                    String ZXcode = (String) SharedPreferencesUtil.get(this, "imgZxCode", "");
                    if (TextUtils.isEmpty(ZXcode) || TextUtils.equals(ZXcode, "")) {
                        return;
                    }
                    LogUtil.LogLong("二维码" + ZXcode);
                    Uri uri = Uri.parse(ZXcode);
                    String code = uri.getQueryParameter("code");
                    inviterCode.setText(code);
                }
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
