package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.CheckPay;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.APpresenter;
import com.hmkj.taozhifu.mview.AmoyPointView;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.NumberDecimalUtils;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.StringUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.PopupPayInputPwd;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/25.
 */

public class WithdrawDepositActivity extends BaseActivity implements AmoyPointView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wxAnumber)
    RadioButton wxAnumber;
    @BindView(R.id.zfbAnumber)
    RadioButton zfbAnumber;
    @BindView(R.id.tixian_money)
    EditText tixianMoney;
    @BindView(R.id.balance_money)
    TextView balanceMoney;
    @BindView(R.id.all_withdraw)
    TextView allWithdraw;
    @BindView(R.id.sure_withdraw)
    Button sureWithdraw;
    @BindView(R.id.payWay)
    RadioGroup payWay;
    @BindView(R.id.alipay_ly)
    LinearLayout alipay_ly;
    APpresenter aPpresenter;
    int payType = -1;//1微信2支付宝
    double allMoney1, allMoney2;
    @BindView(R.id.edt_account_number)
    EditText edtAccountNumber;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.top_btn_right)
    Button topBtnRight;
    private String aliAccount = "";//支付宝
    private String openid;//微信
    private CheckPay checkPayBean;
    private PopupPayInputPwd mPopupPayInputPwd;
    private boolean hasPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_deposit);
        ButterKnife.bind(this);
        //授权使用
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(WithdrawDepositActivity.this).setShareConfig(config);
        /**
         *  设置小数位数控制
         */
        NumberDecimalUtils.editText(tixianMoney);
    }

    @Override
    public void initData() {
        LogUtil.LogLong("填充数据");
        aPpresenter = new APpresenter(WithdrawDepositActivity.this, this);
        aPpresenter.queryAP();
    }

    private void checkPay() {
        OkGo.<String>get(String.format(HttpConfig.payWithdrawalAccount, getMemberId()))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("查看是否绑定了微信和支付宝", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            if (code == 200) {
                                checkPayBean = new Gson().fromJson(response.body(), CheckPay.class);
                                if (checkPayBean != null) {
                                    hasPass = checkPayBean.isHasPass();
                                }
                                if (checkPayBean != null && checkPayBean.getAliAccount() != null) {
                                    aliAccount = checkPayBean.getAliAccount().getPayeeAccount();
                                }
                                if (checkPayBean != null && checkPayBean.getWeixAccount() != null) {
                                    openid = checkPayBean.getWeixAccount().getOpenId();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void initView() {
        initToolbar();
        payWay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //微信
                if (checkedId == R.id.wxAnumber) {
                    alipay_ly.setVisibility(View.VISIBLE);
                    edtAccountNumber.setClickable(false);
                    edtAccountNumber.setFocusable(false);
                    edtAccountNumber.setFocusableInTouchMode(false);
                    payType = 1;
                    if (TextUtils.isEmpty(openid)) {
                        edtAccountNumber.setText("微信未授权，请授权");
                        sureWithdraw.setText("确认授权");
                        ToastUtil.showToast("请点击确认授权");
                    } else {
                        sureWithdraw.setText("确认提现");
                        edtAccountNumber.setText(openid);
                    }
                    //支付宝
                } else if (checkedId == R.id.zfbAnumber) {
                    edtAccountNumber.setClickable(true);
                    edtAccountNumber.setFocusable(true);
                    edtAccountNumber.setFocusableInTouchMode(true);
                    payType = 2;
                    alipay_ly.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(aliAccount)) {
                        edtAccountNumber.setText(aliAccount);
                        sureWithdraw.setText("确认提现");
                    } else {
                        sureWithdraw.setText("确认授权");
                        edtAccountNumber.setText("");
                        ToastUtil.showToast("请点击确认授权");
                    }
                }
            }
        });
    }

    private void initToolbar() {
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText("提现");
        topBtnRight.setText("提现记录");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        UMShareAPI.get(this).release();
    }

    @Override
    public void queryAPSuccess(int dot, int integral, double cashCoupon, double businessCoupon, double amount, int level, double goodMoney, int mlevel) {
        balanceMoney.setText(String.format(CommonUtil.getString(R.string.tv_balance_s), String.valueOf(CommonUtil.Double2position(amount)) + "+货款" + String.valueOf(CommonUtil.Double2position(goodMoney))));
        allMoney1 = amount;
        allMoney2 = goodMoney;
    }

    @OnClick({R.id.all_withdraw, R.id.sure_withdraw, R.id.top_btn_left, R.id.top_btn_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.all_withdraw:
                if (allMoney1 == 0.00 || allMoney2 == 0.00) {
                    ToastUtil.showToast("没有可提现的金额!");
                    return;
                }
                tixianMoney.setText(String.valueOf(CommonUtil.Double2position(allMoney1 + allMoney2)));
                tixianMoney.setSelection(tixianMoney.getText().length());
                break;
            case R.id.sure_withdraw:
                //提现
                if (payType == -1) {
                    ToastUtil.showToast("请选择提现方式");
                    return;
                }
                if (payType == 1) {
                    if (TextUtils.isEmpty(openid)) {
                        UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
                    } else {
                        isHasPassword();
                    }
                } else if (payType == 2) {
                    if (aliAccount.equals("") && TextUtils.isEmpty(aliAccount)) {
                        syncAli();
                    } else {
                        isHasPassword();
                    }
                }

                break;
            case R.id.top_btn_left:
                finish();
                break;
            case R.id.top_btn_right:
                startActivity(new Intent(WithdrawDepositActivity.this, WithdrawDepositRecordActivity.class));
                break;
            default:
                break;
        }
    }

    //判断是否设置了支付密码
    private void isHasPassword() {
        if (hasPass) {
            pwdInput();
        } else {
            ToastUtil.showToast("您还未设置支付密码，请设置密码");
            startActivity(new Intent(WithdrawDepositActivity.this, PayPwdActivity.class));
        }
    }

    private void pwdInput() {
        final String amount = tixianMoney.getText().toString().trim();
        if (TextUtils.isEmpty(amount)) {
            ToastUtil.showToast("请输入提现金额");
            return;
        }
        mPopupPayInputPwd = new PopupPayInputPwd(this, Double.parseDouble(amount), null, new PopupPayInputPwd.OnSendListener() {
            @Override
            public void onSuccess(String str) {
                if (Double.parseDouble(amount) == 0) {
                    ToastUtil.showToast("请输入提现金额");
                    return;
                }
                withdrawDeposit(Double.parseDouble(amount), str);
            }

            @Override
            public void onCancelClick() {
                mPopupPayInputPwd.dismiss();
            }
        });
        mPopupPayInputPwd.show();
    }

    /**
     * 提现接口
     */
    private void withdrawDeposit(final double amount, final String password) {
        int type = 2;
        if (allMoney2 >= 50 && allMoney2 >= amount) {
            type = 2;
        } else if (allMoney1 >= 100) {
            type = 1;
        } else {
            ToastUtil.showToast("余额不足");
            return;
        }
        //密码加密
        String pass = "";
        try {
            pass = MD5Builder.getMD5(password);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        OkGo.<String>post(HttpConfig.payWithdrawal)
                .params("memberId", getMemberId())
                .params("amount", amount)
                .params("type", type)
                .params("withdrawalWay", payType)
                .params("pass", pass)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("提现申请", response.body());
                        try {
                            JSONObject jSONObject = new JSONObject(response.body());
                            int code = jSONObject.getInt("code");
                            String msg = jSONObject.getString("msg");
                            if (code == 200) {
                                ToastUtil.showToast(msg);
                                tixianMoney.setText(null);
                                mPopupPayInputPwd.dismiss();
                                //重新获余额
                                EventBus.getDefault().post(new EventBusEntity(4));
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 同步ali
     */
    private void syncAli() {
        final String number = edtAccountNumber.getText().toString().trim();
        final String name = edtName.getText().toString().trim();
        if (TextUtils.isEmpty(number) || !StringUtil.checkAccount(number)) {
            ToastUtil.showToast("请输入正确支付宝账号");
            return;
        }
        OkGo.<String>post(HttpConfig.syncAliAccount)
                .params("memberId", getMemberId())
                .params("payeeAccount", number)
                .params("payeeRealName", name)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("同步ali", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                ToastUtil.showToast("授权完成");
                                sureWithdraw.setText("确认提现");
                                aliAccount = number;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 授权回调
     */
    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            ToastUtil.showToast("授权成功了");
            LogUtil.LogLong("获取用户的信息" + data.get("openid"));
            openid = data.get("openid");
            edtAccountNumber.setText(openid);
            syncWeiXin(openid);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            ToastUtil.showToast("授权失败了");
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            ToastUtil.showLongToast("授权取消了");
        }
    };

    /**
     * 同步微信
     *
     * @param openid
     */
    private void syncWeiXin(String openid) {
        String number = edtAccountNumber.getText().toString().trim();
        String name = edtName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast("正是姓名不能为空，请设置正确的姓名");
            return;
        }
        OkGo.<String>post(HttpConfig.syncWeiXiAccount)
                .params("memberId", getMemberId())
                .params("openId", openid)
                .params("reUserName", name)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("同步微信", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                ToastUtil.showToast("授权完成");
                                sureWithdraw.setText("确认提现");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPay();
        String name = (String) SharedPreferencesUtil.get(WithdrawDepositActivity.this, "realName", "");
        if (!TextUtils.isEmpty(name)) {
            edtName.setText(name);
        }
    }
}
