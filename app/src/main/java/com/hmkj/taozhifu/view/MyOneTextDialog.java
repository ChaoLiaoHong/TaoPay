package com.hmkj.taozhifu.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.CustomTextAdapter;
import com.hmkj.taozhifu.base.BaseFragmentActivity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/4.
 */

public class MyOneTextDialog extends Dialog implements BaseQuickAdapter.OnItemChildClickListener {

    private CustomTextAdapter customTextAdapter;
    DLonItemClickListener dLonItemClickListener;

    public MyOneTextDialog(@NonNull Context context, ArrayList<String> data, DLonItemClickListener dLonItemClickListener) {
        this(context, R.style.ActionSheetDialogStyle, data, dLonItemClickListener);
    }

    public MyOneTextDialog(@NonNull Context context, @StyleRes int themeResId, ArrayList<String> data, DLonItemClickListener dLonItemClickListener) {
        super(context, themeResId);
        if (data == null) {
            return;
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        View view = getLayoutInflater().inflate(R.layout.dialog_one_text, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialog_one_text);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        customTextAdapter = new CustomTextAdapter(data);
        this.dLonItemClickListener = dLonItemClickListener;
        customTextAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(customTextAdapter);
        this.setContentView(view);
        Window dialogWindow = this.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = BaseFragmentActivity.screenWH[0];
        lp.height = BaseFragmentActivity.screenWH[1] / 2;
        dialogWindow.setAttributes(lp);
        this.show();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (dLonItemClickListener != null) {
            dLonItemClickListener.DLonItemClick(adapter, view, position);
            MyOneTextDialog.this.dismiss();
        }
    }

    public interface DLonItemClickListener {
        void DLonItemClick(BaseQuickAdapter adapter, View view, int position);
    }
}
