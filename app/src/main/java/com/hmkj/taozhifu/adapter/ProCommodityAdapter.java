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
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.QueryProCommodityBean;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;

import java.util.List;

public class ProCommodityAdapter extends BaseQuickAdapter<QueryProCommodityBean.ProCommodityPageBean.RecordsBean, BaseViewHolder> {
    Context context;

    public ProCommodityAdapter(List<QueryProCommodityBean.ProCommodityPageBean.RecordsBean> data, Context context) {
        super(R.layout.item_home_recommended_products, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, QueryProCommodityBean.ProCommodityPageBean.RecordsBean item) {
        helper.setText(R.id.tv_pro_name, item.commodityName).setText(R.id.tv_pro_price, CommonUtil.getString(R.string.RMB) + item.commodityPrice)
        .addOnClickListener(R.id.ll_content);
        GlideUtils.loadImage(context, item.commodityImg, (ImageView) helper.getView(R.id.iv_pro_pic));
    }
}
