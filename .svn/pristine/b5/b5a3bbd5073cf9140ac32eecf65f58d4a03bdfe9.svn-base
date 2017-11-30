/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.MyStoreServiceBean;

import java.util.List;

public class DialogMyStoreServiceAdapter extends BaseQuickAdapter<MyStoreServiceBean.DataBean, BaseViewHolder> {
    private Context context;

    public DialogMyStoreServiceAdapter(List<MyStoreServiceBean.DataBean> data, Context context) {
        super(R.layout.item_text_checkbox, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MyStoreServiceBean.DataBean item) {
        helper.setText(R.id.tv_item, item.name);
        final CheckBox checkBox = (CheckBox) helper.getView(R.id.checkbox);
        checkBox.setChecked(item.isCheck);
        ((LinearLayout) helper.getView(R.id.ll_item)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = checkBox.isChecked();
                checkBox.setChecked(!isCheck);
                item.isCheck = !isCheck;
            }
        });
    }
}