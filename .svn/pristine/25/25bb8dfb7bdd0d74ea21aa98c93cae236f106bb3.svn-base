package com.hmkj.taozhifu.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.hmkj.taozhifu.R;

/**
 * Created by Administrator on 2017/9/21.
 */

public class ProtocolDialog extends Dialog {

    public ProtocolDialog(@NonNull Context context, String title, String content) {
        this(context, 0, title, content);
    }

    protected ProtocolDialog(@NonNull Context context, @StyleRes int themeResId, String title, String content) {
        super(context, themeResId);
        //将布局设置给Dialog
        View view = View.inflate(context, R.layout.dialog_protcol, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        TextView tvContent = (TextView) view.findViewById(R.id.tv_content);
        TextView tvCancle = (TextView) view.findViewById(R.id.tv_cancle);
        tvTitle.setText(title);
        tvContent.setText(content);
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setContentView(view);
        //获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.height = AppUtils.getScreenHW((Activity) context)[1] / 3 * 2;
//        lp.width = AppUtils.getScreenHW((Activity) context)[0] / 5 * 4;
//        lp.y = 10;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        show();//显示对话框
    }
}
