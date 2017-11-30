package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.CommodityDetailedEntity;
import com.hmkj.taozhifu.bean.UserEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.StringUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.PopupPayInputPwd;
import com.hmkj.taozhifu.view.PopupTruePay;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubmitOrderActivity extends BaseActivity {

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
    @BindView(R.id.iv_order_img)
    ImageView ivOrderImg;
    @BindView(R.id.tv_submit_commodity_name)
    TextView tvSubmitCommodityName;
    @BindView(R.id.tv_submit_commodity_money)
    TextView tvSubmitCommodityMoney;
    @BindView(R.id.tv_commodity_use_rule)
    TextView tvCommodityUseRule;
    @BindView(R.id.tv_commodity_convert)
    TextView tvCommodityConvert;
    @BindView(R.id.tv_commodity_sale)
    TextView tvCommoditySale;
    @BindView(R.id.tv_square)
    TextView tvNumber;
    @BindView(R.id.tv_gross)
    TextView tvGross;
    @BindView(R.id.tv_true_pay)
    TextView tvTruePay;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_submit_order)
    TextView tvSubmitOrder;
    @BindView(R.id.tv_reduce)
    ImageView tvReduce;
    @BindView(R.id.tv_add)
    ImageView tvAdd;
    private Intent intent;
    private CommodityDetailedEntity.MapBean.ProShopBean proShopBean;
    private CommodityDetailedEntity.MapBean.ProCommodityBean proCommodityBean;
    private int number;
    private PopupTruePay mPopupTruePay;
    private PopupPayInputPwd mPopupPayInputPwd;
    private InputMethodManager imm;
    private String orderNo;
    private String money;
    private long createTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        proCommodityBean = (CommodityDetailedEntity.MapBean.ProCommodityBean) intent.getSerializableExtra("proCommodityBean");
        proShopBean = (CommodityDetailedEntity.MapBean.ProShopBean) intent.getSerializableExtra("proShopBean");
        GlideUtils.loadImage(this, proCommodityBean.getCommodityImg(), ivOrderImg);
//        Glide.with(this).load(proCommodityBean.getCommodityImg()).into(ivOrderImg);
        tvSubmitCommodityName.setText(proCommodityBean.getCommodityName());
        tvSubmitCommodityMoney.setText(String.format(CommonUtil.getString(R.string.tv_money), proCommodityBean.getCommodityPrice()));
        tvCommodityUseRule.setVisibility(View.GONE);
        tvCommodityUseRule.setText("24小时通用");
        //1、支持退款    2、不支持退款
        if (proCommodityBean.getIsReturn() == 1) {
            tvCommodityConvert.setText("支持退款");
        } else {
            tvCommodityConvert.setText("不支持退款");
        }
        tvGross.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
        tvTruePay.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
        if (proShopBean.getShopDiscount() == 100) {
            tvCommoditySale.setVisibility(View.GONE);
            tvCommoditySale.setText("目前没有赠送");
        } else {
            tvCommoditySale.setVisibility(View.VISIBLE);
            int presents = (100 - proShopBean.getShopDiscount()) * proShopBean.getRebateIntegralMember();
            tvCommoditySale.setText("消费100元赠送" + presents + "积分");
        }
        queryUserInfo();

    }

    public void queryUserInfo() {
        final long memberId = (long) SharedPreferencesUtil.get(this, "memberId", (long) 0);//默认为O
        String token = (String) SharedPreferencesUtil.get(this, "token", "");
        LogUtil.LogLong("获取本地存储的用户id", memberId + "");
        LogUtil.LogLong("获取本地存储的用户token", token);
        OkGo.<String>post(HttpConfig.QUERY_USER_INFO)
                .cacheMode(CacheMode.NO_CACHE)
                .params("memberId", memberId)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("用户信息", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                UserEntity userEntity = GsonUtil.GsonToBean(response.body(), UserEntity.class);
                                if (userEntity.getData() == null) {
                                    return;
                                }
                                String phone = userEntity.getData().getPhone();
                                tvPhone.setText(StringUtil.getUserPhone(phone));
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });

    }

    @Override
    public void initView() {
        intent = getIntent();
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(R.string.tv_submit_order);
        number = Integer.parseInt(tvNumber.getText().toString());
        proShopBean = (CommodityDetailedEntity.MapBean.ProShopBean) intent.getSerializableExtra("proShopBean");
    }

    @OnClick({R.id.top_btn_left, R.id.tv_submit_order, R.id.tv_add, R.id.tv_reduce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            case R.id.tv_submit_order:
                //生成订单
                if (!isNetConnect()) {
                    return;
                }
                if (AppUtils.isFastClick()) {
                    pay();
                }
                break;
            case R.id.tv_add:
                if (number >= proCommodityBean.getQuantity()) {
                    tvAdd.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_add_quantity_disabled));
                    tvReduce.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_minus_normal));
                    tvNumber.setText(String.valueOf(proCommodityBean.getQuantity()));
                    tvGross.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                    tvTruePay.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                } else {
                    number = number + 1;
                    tvNumber.setText(String.valueOf(number));
                    tvGross.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                    tvTruePay.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                    tvAdd.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_add_quantity_normal));
                    tvReduce.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_minus_normal));

                }
                break;
            case R.id.tv_reduce:
                if (number <= 1) {
                    tvAdd.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_add_quantity_normal));
                    tvReduce.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_minus_disabled));
                    tvNumber.setText(String.valueOf(1));
                    tvGross.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) 1 * proCommodityBean.getCommodityPrice())));
                    tvTruePay.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) 1 * proCommodityBean.getCommodityPrice())));
                } else {
                    number = number - 1;
                    tvNumber.setText(String.valueOf(number));
                    tvGross.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                    tvTruePay.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position((double) number * proCommodityBean.getCommodityPrice())));
                    tvAdd.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_add_quantity_normal));
                    tvReduce.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_minus_normal));
                }
                break;
            default:
                break;
        }
    }

    /**
     * 添加生成订单
     */
    private void pay() {
        OkGo.<String>post(HttpConfig.addOrder)
                .params("memberId", getMemberId())
                .params("commodityId", proCommodityBean.getCommodityId())
                .params("cashCoupon", (double) number * proCommodityBean.getCommodityPrice())
                .params("clientType", 1)
                .params("quantity", number)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("生成商品订单", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                money = String.valueOf((double) number * proCommodityBean.getCommodityPrice());
                                JSONObject map = jsonObject.getJSONObject("map");
                                orderNo = map.getString("orderNo");
                                createTime = map.getLong("createTime");
                                initPopup();
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    private void initPopup() {
        mPopupTruePay = new PopupTruePay(this, (double) number * proCommodityBean.getCommodityPrice(), proCommodityBean, new PopupTruePay.OnSendListener() {
            @Override
            public void onPayClick() {
                mPopupTruePay.dismiss();
                payInputPwd();
            }

            @Override
            public void onCancelClick() {
                mPopupTruePay.dismiss();
            }
        });
        mPopupTruePay.show();
    }

    private void payInputPwd() {
        mPopupPayInputPwd = new PopupPayInputPwd(this, (double) number * proCommodityBean.getCommodityPrice(), proCommodityBean, new PopupPayInputPwd.OnSendListener() {
            @Override
            public void onSuccess(String str) {
                sureDJPay(orderNo, money, str);
            }

            @Override
            public void onCancelClick() {
                mPopupPayInputPwd.dismiss();
            }
        });
        mPopupPayInputPwd.show();
    }

    //抵用券支付
    private void sureDJPay(String orderNo, final String money1, String str) {
        String pass = "";
        try {
            pass = MD5Builder.getMD5(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogUtil.LogLong("钱钱", money1);
        LogUtil.LogLong("订单", orderNo);
        OkGo.<String>post(HttpConfig.initPay)
                .params("memberId", getMemberId())
                .params("orderNo", orderNo)
                .params("amount", money1)
                .params("productInfo", "APP支付")
                .params("payWay", "DJPAY")
                .params("payType", "APP")
                .params("shopId", proShopBean.getShopId())
                .params("pass", pass)
                .execute(new CustomCallback(this, false, false) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong(response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                onComplete(Double.parseDouble(money1), proShopBean.getShopName());
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void onComplete(double price, String name) {
        Intent intent = new Intent(this, PaySuccessActivity.class);
        intent.putExtra("type", "commodity");
        intent.putExtra("price", String.valueOf(price));
        intent.putExtra("shopName", name);
        intent.putExtra("orderNo", orderNo);
        intent.putExtra("createTime", createTime);
        intent.putExtra("payWay", "抵用券");
        startActivity(intent);
        mPopupPayInputPwd.dismiss();
        finish();
    }
}
