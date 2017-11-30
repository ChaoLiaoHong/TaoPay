package com.hmkj.taozhifu.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class CustomTextAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public CustomTextAdapter(@Nullable List<String> data) {
        super(R.layout.item_recyc_text, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final String item) {
        helper.setText(R.id.tv_item, item).addOnClickListener(R.id.tv_item);
    }
}
