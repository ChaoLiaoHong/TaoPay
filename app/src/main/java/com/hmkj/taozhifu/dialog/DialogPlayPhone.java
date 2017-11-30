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

public class DialogPlayPhone implements View.OnClickListener {
    private AlertDialog dialog;
    private final TextView tvPhone;
    private final Button btn_cancel;
    private final Button btn_sure;
    private String phone;
    private Context context;
    private final AlertDialog.Builder builder;

    public DialogPlayPhone(Context context, String phone) {
        this.phone = phone;
        this.context = context;
        builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.item_play_phone, null);
        builder.setView(view);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_sure = (Button) view.findViewById(R.id.btn_sure);
        tvPhone.setText("确定要拨打电话：" + phone);
        dialog = builder.show();
        initEvent();
    }

    private void initData() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));  //ACTION_DIAL是跳转到拨号界面，ACTION_CALL是直接拨号
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
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
                sendMessageToPeople();
                dialog.dismiss();
                break;

        }
    }

    void sendMessageToPeople() {
        initData();
    }
}
