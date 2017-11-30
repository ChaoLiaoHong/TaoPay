package com.hmkj.taozhifu.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.hmkj.taozhifu.R;


/**
 * Created by Administrator on 2016/12/28.
 */

public class SelectPicPopupWindow2 extends PopupWindow {
    private LinearLayout btn_1, btn_2;
    private View mMenuView;
    private Button quxiao;

    public SelectPicPopupWindow2(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.paymentselect2, null);
        btn_1 = (LinearLayout) mMenuView.findViewById(R.id.ly_man);
        btn_2 = (LinearLayout) mMenuView.findViewById(R.id.ly_woman);
        quxiao = (Button) mMenuView.findViewById(R.id.quxiao);
        //取消按钮
        //btn_3.setOnClickListener(itemsOnClick);
        //设置按钮监听
        btn_2.setOnClickListener(itemsOnClick);
        btn_1.setOnClickListener(itemsOnClick);
        //设置View
        this.setContentView(mMenuView);
        //设置弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置弹出窗体可点击
        this.setFocusable(true);
        //设置弹出窗体动画效果
        this.setAnimationStyle(R.style.ACPLDialog);
        //实例化一个颜色为半透明
        final ColorDrawable dw = new ColorDrawable(0xb0000000);
        dw.setAlpha(50);
        //设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
