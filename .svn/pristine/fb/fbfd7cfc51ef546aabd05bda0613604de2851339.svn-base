package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.MyStoreBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.BoderCircleImageView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStoreActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.civ_store_img)
    BoderCircleImageView civStoreImg;
    @BindView(R.id.tv_focus)
    TextView tvFocus;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.ll_focus)
    LinearLayout llFocus;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_store_address)
    TextView tvStoreAddress;
    @BindView(R.id.rl_my_product)
    RelativeLayout rlMyProduct;
    @BindView(R.id.rl_store_discount)
    RelativeLayout rlStoreDiscount;
    @BindView(R.id.rl_store_setup)
    RelativeLayout rlStoreSetup;
    @BindView(R.id.rl_make_collections_scanning)
    RelativeLayout rlMakeCollectionsScanning;
    @BindView(R.id.fl_bg)
    LinearLayout flBg;
    @BindView(R.id.bt_store_logoff)
    Button btStoreLogoff;
    @BindView(R.id.tv_write_off_exchange)
    TextView tvWriteOffExchange;
    @BindView(R.id.tv_exchange_order)
    TextView tvExchangeOrder;
    @BindView(R.id.tv_account_paid)
    TextView tvAccountPaid;
    @BindView(R.id.bt_store_logoff2)
    TextView btStoreLogoff2;
    @BindView(R.id.tv_center_text)
    TextView tvCenterText;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    RelativeLayout ll2;
    private MyStoreBean myStoreBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        OkGo.<String>get(String.format(HttpConfig.shopDetailByMemberId, getMemberId()))
                .params("memberId", getMemberId())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("自己店铺 - " + response.body());
                        if (checkHttpCode(response.body())) {
                            ll1.setVisibility(View.VISIBLE);
                            ll2.setVisibility(View.GONE);
                            myStoreBean = GsonUtil.GsonToBean(response.body(), MyStoreBean.class);
                            if (myStoreBean != null && myStoreBean.data != null)
                                setInfo();
                        } else if (response.body().contains("尚未申请")) {//400
                            ll1.setVisibility(View.GONE);
                            ll2.setVisibility(View.VISIBLE);
                            ToastUtil.showToast(getHttpMsg(response.body()));
                            state = 1;
                        }
                    }
                });
    }

    Long shopId;
    int state;
    int callState;

    private void setInfo() {
        GlideUtils.loadImage(this, myStoreBean.data.shopSignage, civStoreImg);
        tvStoreName.setText(myStoreBean.data.shopName);
        tvStoreAddress.setText(myStoreBean.data.shopAddress);
        tvFocus.setText(myStoreBean.data.shopCollectionNum + "");
        tvFollow.setText("关注");
        shopId = myStoreBean.data.shopId;
        //申请审核中
        if (myStoreBean.data.state == 1 && myStoreBean.data.auditState == 1) {
            tvStoreName.setText(getText(tvStoreName) + "(申请审核中)");
            state = 2;
        }
        //店铺正常状态
        if (myStoreBean.data.state == 2 && myStoreBean.data.auditState == 2) state = 1;
        //店铺申请拒绝了  重新申请
        if (myStoreBean.data.state == 1 && myStoreBean.data.auditState == 3) {
            tvCenterText.setText("店铺申请被拒绝，请重新申请" + (AppUtils.checkId(myStoreBean.data.refuseReason) ? "\n\n拒绝原因：" + myStoreBean.data.refuseReason : ""));
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.VISIBLE);
            state = 1;
            btStoreLogoff2.setText("拨打查询：" + CommonUtil.getString(R.string.connect_us));
            callState = 1;
        }
        //注销了
        if (myStoreBean.data.state == 3 && myStoreBean.data.auditState == 2) {
            tvStoreName.setText(getText(tvStoreName) + "(已注销)");
            state = 0;
        }
    }

    @Override
    public void initView() {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setBackgroundDrawable(CommonUtil.getDrawable(R.drawable.gradual_change));
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_light_24dp);
        toolbarTitle.setTextColor(Color.WHITE);
        toolbarTitle.setText("我的店铺");
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.bt_store_logoff2, R.id.tv_write_off_exchange, R.id.tv_exchange_order, R.id.tv_account_paid, R.id.rl_make_collections_scanning, R.id.rl_my_product, R.id.rl_store_discount, R.id.rl_store_setup, R.id.bt_store_logoff})
    public void onViewClicked(View view) {
        if (state == 2) ToastUtil.showToast("店铺还在审核中");
        if (state != 1) return;
        switch (view.getId()) {
            case R.id.rl_my_product:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, MyStoreProductActivity.class);
                    intent.putExtra("shopId", shopId);
                    startActivity(intent);
                }
                break;
            case R.id.rl_store_discount:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, MyStoreDiscountActivity.class);
                    intent.putExtra("shopId", shopId);
                    startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                }
                break;
            case R.id.rl_store_setup:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, MyStoreSetupActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("myStoreBean", myStoreBean.data);
                    intent.putExtra("bundle", bundle);
                    intent.putExtra("shopId", shopId);
                    startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                }
                break;
            case R.id.bt_store_logoff:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, MyStoreLogoffActivity.class);
                    intent.putExtra("shopId", shopId);
                    startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                }
                break;
            case R.id.rl_make_collections_scanning:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, ShareZXcodeActivity.class);
                    intent.putExtra("bgColor", 2);
                    intent.putExtra("store_code", shopId);
                    intent.putExtra("shopName", myStoreBean.data.shopName);
                    startActivity(intent);
                }
                break;
            case R.id.tv_write_off_exchange://核销兑换
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(MyStoreActivity.this, CaptureActivity.class);
                    intent.putExtra("type", 1);
                    intent.putExtra("shopId", shopId);
                    startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                }
                break;
            case R.id.tv_exchange_order:
                startActivity(new Intent(this, MyStoreExchangeOrderActivity.class));
                break;
            case R.id.tv_account_paid:
                if (shopId != null && shopId != 0) {
                    Intent intent = new Intent(this, MyStoreAccountPaidActivity.class);
                    intent.putExtra("shopId", shopId);
                    startActivity(intent);
                }
                break;
            case R.id.bt_store_logoff2:
                if (callState == 1) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + CommonUtil.getString(R.string.connect_us)));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else
                    startActivityForResult(new Intent(this, MyStoreApplyActivity.class), CommonStatu.REQUEST_CODE1);
                break;
            default:
                break;
        }
    }

    String orderCode = "";  //扫一扫核销兑换

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CommonStatu.REQUEST_CODE1 && resultCode == CommonStatu.OK) {
            initData();
        }
        if (requestCode == CommonStatu.REQUEST_CODE1 && resultCode == CommonStatu.REQUEST_CODE1) {
            if (data == null) return;
            orderCode = data.getExtras().getString(CodeUtils.RESULT_STRING);
            if (AppUtils.checkId(orderCode))
                updateOrder(orderCode);
            else ToastUtil.showToast("兑换码错误，兑换失败");
        }
    }

    private void updateOrder(String orderCode) {
        OkGo.<String>post(String.format(HttpConfig.updateOrder, shopId))
                .params("code", orderCode)
                .params("shopId", shopId)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        if (checkHttpCode(response.body())) {
                            ToastUtil.showLongToast("兑换成功");
                            Intent intent = new Intent(MyStoreActivity.this, MyStoreExchangeOrderActivity.class);
                            intent.putExtra("page", 2);
                            startActivity(intent);
                        } else {
                            ToastUtil.showLongToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
