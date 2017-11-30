package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.TimeUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySuccessActivity extends BaseActivity {

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
    @BindView(R.id.tv_return)
    TextView tvReturn;
    @BindView(R.id.tv_check_order)
    TextView tvCheckOrder;
    @BindView(R.id.tv_ticket)
    TextView tvTicket;
    @BindView(R.id.tv_receipt_shop)
    TextView tvReceiptShop;
    @BindView(R.id.order_number)
    TextView orderNumber;
    @BindView(R.id.tv_pay_date)
    TextView tvPayDate;
    private Intent intent;
    @BindView(R.id.ll_order_num)
    LinearLayout llOrderNum;
    @BindView(R.id.ll_check)
    LinearLayout llCheck;
    @BindView(R.id.rl_return)
    RelativeLayout rlReturn;
    @BindView(R.id.tv_return2)
    TextView tvReturn2;
    @BindView(R.id.tv_success_money)
    TextView tvSuccessMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        tvSuccessMoney.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position(Double.parseDouble(intent.getStringExtra("price")))));
        LogUtil.LogLong("拿到店铺名字", intent.getStringExtra("shopName"));
        tvReceiptShop.setText(intent.getStringExtra("shopName"));
        orderNumber.setText(intent.getStringExtra("orderNo"));
        tvPayDate.setText(TimeUtil.getTime2String(intent.getLongExtra("createTime", 0l), ""));
        tvTicket.setText(intent.getStringExtra("payWay"));
    }

    @Override
    public void initView() {
        intent = getIntent();
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topBtnRight.setText(R.string.tv_complete);
        topTitle.setText(R.string.tv_pay_success);
        topBtnRight.setTextColor(CommonUtil.getColor(R.color.accent));
        topBtnLeft.setVisibility(View.INVISIBLE);
        if (intent.getStringExtra("type").equals("shop")) {
            llOrderNum.setVisibility(View.VISIBLE);
            tvCheckOrder.setVisibility(View.VISIBLE);
            llCheck.setVisibility(View.GONE);
            rlReturn.setVisibility(View.VISIBLE);
        } else {
            llOrderNum.setVisibility(View.VISIBLE);
            tvCheckOrder.setVisibility(View.VISIBLE);
            llCheck.setVisibility(View.VISIBLE);
            rlReturn.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.top_btn_right, R.id.tv_return, R.id.tv_check_order, R.id.tv_return2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_btn_right:
                EventBus.getDefault().post(new EventBusEntity(CommonStatu.OK));
                finish();
                break;
            case R.id.tv_return:
                startActivity(new Intent(PaySuccessActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_return2:
                startActivity(new Intent(PaySuccessActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_check_order:
                startActivity(new Intent(PaySuccessActivity.this, MyOrderActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        EventBus.getDefault().post(new EventBusEntity(CommonStatu.OK));
        super.onBackPressed();
    }
}
