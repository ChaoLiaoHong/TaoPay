package com.hmkj.taozhifu.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.CaptureActivity;
import com.hmkj.taozhifu.activity.LoginActivity;
import com.hmkj.taozhifu.activity.PayActivity;
import com.hmkj.taozhifu.activity.TDTicketActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.APpresenter;
import com.hmkj.taozhifu.mpresenter.LoginPresenter;
import com.hmkj.taozhifu.mview.AmoyPointView;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/16.
 */

public class AmoyPointFragment extends BaseFragment implements AmoyPointView {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scanCode)
    ImageView scanCode;
    @BindView(R.id.mVoucher)
    LinearLayout mVoucher;
    @BindView(R.id.mShopTicket)
    LinearLayout mShopTicket;
    @BindView(R.id.myBalance)
    LinearLayout myBalance;
    @BindView(R.id.mDot)
    TextView mdot;
    @BindView(R.id.mIntegral)
    TextView mIntegral;
    @BindView(R.id.mmcashCoupon)
    TextView mMcashCoupon;
    @BindView(R.id.mbusinessCoupon)
    TextView mBusinessCoupon;
    @BindView(R.id.mAmount)
    TextView mAmount;
    APpresenter aPpresenter;
    Unbinder unbinder;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amoypoint, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        aPpresenter = new APpresenter(getActivity(), this);
        return view;
    }

    @Override
    protected void refreshOnVisible() {
        initToolBar(false);
        aPpresenter.queryAP();//获取淘点信息
    }

    private void initToolBar(boolean b) {
        StatusBarUtil.darkMode(activity, false);
        if (b) {
            StatusBarUtil.setPaddingSmart(activity, toolbar);
            StatusBarUtil.immersive(activity);
        }
    }

    /**
     * ------------------------------------------------------
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case CommonStatu.OK:
                aPpresenter.queryAP();//获取淘点信息
                break;
            case 4:
                aPpresenter.queryAP();//提现成功的广播
                break;
            default:
                break;
        }
    }

    @Override
    protected void initData() {
        toolbarTitle.setText("淘点");
        initToolBar(true);
    }


    @OnClick({R.id.scanCode, R.id.mVoucher, R.id.mShopTicket, R.id.myBalance})
    public void onClick(View view) {
        Intent intent_Common = new Intent(getActivity(), TDTicketActivity.class);
        if (!LoginPresenter.checkLogin(context)) {
            mdot.setText("0");
            mIntegral.setText("0");
            mMcashCoupon.setText("余额¥0.00");
            mBusinessCoupon.setText("余额¥0.00");
            mAmount.setText("余额¥0.00");
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
            return;

        }
        switch (view.getId()) {
            case R.id.scanCode:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                intent.putExtra("zxType", HttpConfig.REQUEST_CODE);
                startActivityForResult(intent, CommonStatu.REQUEST_CODE1);
                break;
            case R.id.mVoucher://抵用劵
                intent_Common.putExtra("type", "2");
                startActivity(intent_Common);
                break;
            case R.id.mShopTicket://商超卷
                intent_Common.putExtra("type", "3");
                startActivity(intent_Common);
                break;
            case R.id.myBalance://现金
                intent_Common.putExtra("type", "1");
                startActivity(intent_Common);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //返回结果
        if (requestCode == CommonStatu.REQUEST_CODE1) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Intent intent = new Intent(getActivity(), PayActivity.class);
                    Uri uri = Uri.parse(result);
                    intent.putExtra("shopId", uri.getQueryParameter("shopId"));
                    startActivity(intent);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void queryAPSuccess(int dot, int integral, double cashCoupon, double businessCoupon, double amount, int level, double goodsMoney, int mlevel) {
        mdot.setText(dot + "");
        mIntegral.setText(integral + "");
        mMcashCoupon.setText(String.format(CommonUtil.getString(R.string.tv_balance_s), String.valueOf(CommonUtil.Double2position(cashCoupon))));
        mBusinessCoupon.setText(String.format(CommonUtil.getString(R.string.tv_balance_s), String.valueOf(CommonUtil.Double2position(businessCoupon))));
        mAmount.setText(String.format(CommonUtil.getString(R.string.tv_balance_s), String.valueOf(CommonUtil.Double2position(amount + goodsMoney))));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);

    }
}
