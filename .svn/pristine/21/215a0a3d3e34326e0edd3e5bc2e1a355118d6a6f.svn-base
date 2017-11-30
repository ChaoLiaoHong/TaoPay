package com.hmkj.taozhifu.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.CommodityDetailedEntity;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;

public class PopupTruePay extends PopupWindow implements View.OnClickListener {

    Context context;
    View layout;
    TextView tvCancel, tvPayOnClick, tvOrder, tvUseTicket, tvPayPrice;
    OnSendListener onSendListener;
    double price;

    public PopupTruePay(Context context, double price, CommodityDetailedEntity.MapBean.ProCommodityBean proCommodityBean, final OnSendListener onSendListener) {
        super(context);
        this.context = context;
        this.onSendListener = onSendListener;
        initView();
        setData(price, proCommodityBean);
        initEvent();
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //this.setHeight((int) (AppUtils.getScreenHW((Activity) context)[1] / 2));
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable());// 这样设置才能点击屏幕外dismiss窗口
        this.setContentView(layout);
    }

    private void initEvent() {
        tvCancel.setOnClickListener(this);
        tvPayOnClick.setOnClickListener(this);
    }

    void initView() {
        layout = LayoutInflater.from(context).inflate(R.layout.popup_true_pay, null);
        tvCancel = (TextView) layout.findViewById(R.id.tv_cancel);
        tvPayPrice = (TextView) layout.findViewById(R.id.tv_pay_price);
        tvOrder = (TextView) layout.findViewById(R.id.tv_order_info);
        tvUseTicket = (TextView) layout.findViewById(R.id.tv_use_ticket);
        tvPayOnClick = (TextView) layout.findViewById(R.id.tv_pay_onClick);
    }

    private void setData(double price, CommodityDetailedEntity.MapBean.ProCommodityBean proCommodityBean) {
        if (proCommodityBean != null) {
            tvPayPrice.setText(String.format(CommonUtil.getString(R.string.tv_money), CommonUtil.Double2position(price)));
            tvOrder.setText(proCommodityBean.getCommodityName());
            tvUseTicket.setText("抵用券");

        }
    }


    public void show() {
        this.setAnimationStyle(R.style.Animation);
        //防止部分手机底部状态栏与popupWindow重叠
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //popupWindow底部显示
        this.showAtLocation(((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 0.5f;
        if (lp.alpha == 1) {
            ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        ((Activity) context).getWindow().setAttributes(lp);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 1f;
        ((Activity) context).getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_pay_onClick:
                if (!AppUtils.isFastClick()) return;
                onSendListener.onPayClick();
                break;
            case R.id.tv_cancel:
                onSendListener.onCancelClick();
                break;
        }
    }

    public interface OnSendListener {
        void onPayClick();

        void onCancelClick();
    }
}
