package com.hmkj.taozhifu.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hmkj.taozhifu.R;


/**
 * Created by LiaoDuanHong  on 2017/5/2
 */

public class DialogPlayRemind implements View.OnClickListener {
    private static DialogPlayRemind dialogPlayRemind = null;
    private AlertDialog dialog;
    private final TextView tvPhone;
    private final Button btn_cancel;
    private final Button btn_sure;
    private final AlertDialog.Builder builder;

    private OnClickListener onClickListener;

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static DialogPlayRemind getInstance(Context context, String content) {
        return new DialogPlayRemind(context, content);
    }

    private DialogPlayRemind(Context context, String content) {
        builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.item_play_phone, null);
        builder.setView(view);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_sure = (Button) view.findViewById(R.id.btn_sure);
        btn_sure.setText("确定");
        tvPhone.setText(content);
        dialog = builder.show();
        initEvent();
    }


    private void initEvent() {
        //关闭Dialog
        btn_cancel.setOnClickListener(this);
        btn_sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
            case R.id.btn_sure:
                if (onClickListener != null) {
                    onClickListener.onSendListener();
                }
                dialog.dismiss();
                break;
            default:
                break;

        }
    }

    public interface OnClickListener {
        void onSendListener();
    }
}
