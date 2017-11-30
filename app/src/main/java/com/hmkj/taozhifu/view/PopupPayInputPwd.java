package com.hmkj.taozhifu.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.CommodityDetailedEntity;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class PopupPayInputPwd extends PopupWindow implements View.OnClickListener {

    Context context;
    View layout;
    PayPwdEditText tvPayPrice;
    Button tvCancel;
    OnSendListener onSendListener;

    public PopupPayInputPwd(Context context, double price, CommodityDetailedEntity.MapBean.ProCommodityBean proCommodityBean, final OnSendListener onSendListener) {
        super(context);
        this.context = context;
        this.onSendListener = onSendListener;
        initView();
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

    }

    void initView() {
        layout = LayoutInflater.from(context).inflate(R.layout.popup_pay_input_pwd, null);
        tvCancel = (Button) layout.findViewById(R.id.tv_cancel);
        tvPayPrice = (PayPwdEditText) layout.findViewById(R.id.tv_pay_pwd);
        tvPayPrice.initStyle(R.drawable.edit_num_bg, 6, 0.33f, R.color.e6e6e6, R.color.j_999999, 24);
        tvPayPrice.setOnTextFinishListener(new PayPwdEditText.OnTextFinishListener() {
            @Override
            public void onFinish(String str) {//密码输入完后的回调
                if (onSendListener != null) {
                    onSendListener.onSuccess(str);
                }
            }
        });
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
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
        tvPayPrice.showKeyBord();
//            }
//        }, 50);

    }

    @Override
    public void dismiss() {
        super.dismiss();
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 1f;
        ((Activity) context).getWindow().setAttributes(lp);
        tvPayPrice.hideKeyBord();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                onSendListener.onCancelClick();
                break;
        }
    }

    public interface OnSendListener {
        void onSuccess(String str);

        void onCancelClick();
    }


}
