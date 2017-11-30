package com.hmkj.taozhifu.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.OrderDetailBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.StringUtils;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyOrderDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tv_is_used)
    TextView tvIsUsed;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_order_statu)
    TextView tvOrderStatu;
    @BindView(R.id.tv_statu_button)
    TextView tvStatuButton;
    @BindView(R.id.iv_product_img)
    ImageView ivProductImg;
    @BindView(R.id.tv_order_status)
    ImageView tvOrderStatus;
    @BindView(R.id.tv_product_name)
    TextView tvProductName;
    @BindView(R.id.tv_product_time)
    TextView tvProductTime;
    @BindView(R.id.tv_product_num)
    TextView tvProductNum;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.tv_product_price)
    TextView tvProductPrice;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.iv_qr_code)
    ImageView ivQrCode;
    @BindView(R.id.tv_identifying_code)
    TextView tvIdentifyingCode;
    @BindView(R.id.ll_product_info)
    LinearLayout llProductInfo;
    @BindView(R.id.ll_order_info)
    LinearLayout llOrderInfo;
    @BindView(R.id.ll_code)
    LinearLayout llCode;
    @BindView(R.id.tv_product_info)
    TextView tvProductInfo;
    @BindView(R.id.rv_product_info)
    TextView rvProductInfo;
    @BindView(R.id.tv_order_info)
    TextView tvOrderInfo;
    @BindView(R.id.rv_order_info)
    TextView rvOrderInfo;
    private long orderId;
    private OrderDetailBean orderDetailBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_detail);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        OkGo.<String>get(String.format(HttpConfig.selectOrderDetailByOrderId, orderId))
                .params("memberId", getMemberId())
                .params("orderId", orderId)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("订单详情 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            orderDetailBean = GsonUtil.GsonToBean(response.body(), OrderDetailBean.class);
                            if (orderDetailBean != null && orderDetailBean.orders != null)
                                setInfo(orderDetailBean.orders);
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    private void setInfo(OrderDetailBean.OrdersBean ordersBean) {
        switch (ordersBean.orderStatus) {
            case 1:
                //待付款
                tvOrderStatu.setText("订单待付款");
                tvStatuButton.setBackgroundDrawable(CommonUtil.getDrawable(R.drawable.bg_textview_gray));
                tvStatuButton.setText("去付款");
                tvStatuButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                //待使用
                tvOrderStatu.setText(AppUtils.checkId(ordersBean.orderCode) ? "订单待使用" : "订单已完成");
                tvStatuButton.setVisibility(View.GONE);
                if (AppUtils.checkId(ordersBean.orderCode)) {
                    ivQrCode.setImageBitmap(CodeUtils.createImage(ordersBean.orderCode, 400, 400, null));
                    tvIdentifyingCode.setText("验证码：" + ordersBean.orderCode);
                    llCode.setVisibility(View.VISIBLE);
                }
                break;
            case 3:
                //待评价
                tvOrderStatu.setText("订单待评价");
                tvStatuButton.setBackgroundDrawable(CommonUtil.getDrawable(R.drawable.bg_textview_gray));
                tvStatuButton.setText(" 评价 ");
                tvStatuButton.setVisibility(View.VISIBLE);
                if (AppUtils.checkId(ordersBean.orderCode)) {
                    ivQrCode.setImageBitmap(CodeUtils.createImage("该订单已使用", 400, 400, null));
                    tvIdentifyingCode.setText("验证码：" + ordersBean.orderCode);
                    ivQrCode.setAlpha(0.3f);
                    tvIdentifyingCode.setAlpha(0.3f);
                    llCode.setVisibility(View.VISIBLE);
                }
                tvIsUsed.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        String totalAmount = "";
        if (AppUtils.checkId(ordersBean.orderCode)) {
            totalAmount = "总价：" + CommonUtil.getString(R.string.RMB) + " " + ordersBean.cashCoupon + "(抵用券)";
        } else {
            totalAmount = "总价：" + CommonUtil.getString(R.string.RMB) + " " + ordersBean.totalAmount;
        }
        //"购买套餐：" + ordersBean.cyyyyonsigneeName + "\n\n" +
        rvOrderInfo.setText("订单编号：" + ordersBean.orderNo + ""
                + "\n\n" + "购买手机号：" + ordersBean.consigneePhone + "\n\n" + "付款时间：" + StringUtils.longToString(ordersBean.createTime, "yyyy-MM-dd HH:mm:ss")
                + "\n\n" + totalAmount);
        llOrderInfo.setVisibility(View.VISIBLE);
        if (AppUtils.checkId(ordersBean.orderCode)) {
            GlideUtils.loadImage(this, ordersBean.commodityImg, ivProductImg);
            tvProductName.setText(ordersBean.commodityName);
            tvOrderNum.setText("x" + ordersBean.quantity);
            tvProductPrice.setText(CommonUtil.getString(R.string.RMB) + ordersBean.cashCoupon + "(抵用券)");
            llContent.setVisibility(View.VISIBLE);
            if (AppUtils.checkId(ordersBean.commodityDescr)) {
                //商品介绍
                rvProductInfo.setText(ordersBean.commodityDescr);
                llProductInfo.setVisibility(View.VISIBLE);
            }
        }
        tvStatuButton.setVisibility(View.GONE);
    }

    @Override
    public void initView() {
        initToolbar();
        orderId = getIntent().getLongExtra("orderId", 0l);
    }

    private void initToolbar() {
        initToolBar(toolbar, true, false, "", Color.BLACK, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setText("订单详情");
        toolbarTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.tv_statu_button, R.id.ll_content})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_statu_button:
                switch (orderDetailBean.orders.orderStatus) {
                    case 1:
                        ToastUtil.showToast("去支付");
                        break;
                    case 3:
                        ToastUtil.showToast("评价");
                        break;
                }
                break;
            case R.id.ll_content:
                if (orderDetailBean.orders.commodityId != 0l) {
                    Intent intent = new Intent(this, CommodityDetailedInformationActivity.class);
                    intent.putExtra("commodityId", orderDetailBean.orders.commodityId);
                    startActivity(intent);
                }
                break;
        }
    }

    //屏幕亮度控制
    private void setLight(Activity context, int brightness) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.screenBrightness = Float.valueOf(brightness) * (1f / 255f);
        context.getWindow().setAttributes(lp);
    }
}
