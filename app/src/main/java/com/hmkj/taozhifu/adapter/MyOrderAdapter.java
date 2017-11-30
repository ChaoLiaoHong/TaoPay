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
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.MyOrderDetailActivity;
import com.hmkj.taozhifu.bean.MyOrderBean;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StringUtils;

import java.util.List;

public class MyOrderAdapter extends BaseQuickAdapter<MyOrderBean.OrderListBean.RecordsBean, BaseViewHolder> {
    private Context context;
    OnClickListener onClickListener;

    public MyOrderAdapter(List<MyOrderBean.OrderListBean.RecordsBean> data, Context context, OnClickListener onClickListener) {
        super(R.layout.item_my_order, data);
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MyOrderBean.OrderListBean.RecordsBean item) {
        LinearLayout llButtons = helper.getView(R.id.ll_buttons);
        llButtons.setDividerDrawable(CommonUtil.getDrawable(R.drawable.trans));
        llButtons.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        helper.setText(R.id.tv_product_name, item.shopName).setText(R.id.tv_order_time, StringUtils.longToString(item.createTime, "yyyy-MM-dd HH:mm"));
        TextView orderPrice = helper.getView(R.id.tv_order_price);
        if (item.cashCoupon != 0) {
            //不为0就是用的券
            orderPrice.setText(CommonUtil.getString(R.string.RMB) + item.cashCoupon + " (抵用券)");
        } else {
            orderPrice.setText(CommonUtil.getString(R.string.RMB) + item.totalAmount + "");
        }
        GlideUtils.loadImage(context, item.shopSignage, (ImageView) helper.getView(R.id.iv_product_img));
        TextView tvOrderStatu = helper.getView(R.id.tv_order_statu);
        llButtons.removeAllViews();
//        LogUtil.LogLong(((TextView) helper.getView(R.id.tv_product_name)).getText().toString() + " --- " + item.orderStatus);
        switch (item.orderStatus) {
            case 1:
                //待支付
                tvOrderStatu.setText("待付款");
                llButtons.setVisibility(View.VISIBLE);
                addMenu(item, llButtons, new String[]{"去付款", " 取消 "});
                break;
            case 2:
                //待使用
                if (AppUtils.checkId(item.orderCode)) {
                    tvOrderStatu.setText("待使用");
                    llButtons.setVisibility(View.GONE);
                } else {
                    tvOrderStatu.setText("已完成");
                    llButtons.setVisibility(View.VISIBLE);
                    addMenu(item, llButtons, new String[]{" 删除 "});
                }
                break;
            case 3:
                //待评价
                tvOrderStatu.setText("待评价");
                llButtons.setVisibility(View.VISIBLE);
                addMenu(item, llButtons, new String[]{" 评价 "});
                break;
            case 4:
                tvOrderStatu.setText("已评价");
                llButtons.setVisibility(View.GONE);
                break;
            case 5:
                tvOrderStatu.setText("已取消");
                llButtons.setVisibility(View.VISIBLE);
                addMenu(item, llButtons, new String[]{" 删除 "});
                break;
            case 6:
                tvOrderStatu.setText("已删除");
                llButtons.setVisibility(View.GONE);
                break;
            default:
                tvOrderStatu.setText("");
                llButtons.setVisibility(View.GONE);
                break;
        }
        View view = helper.getConvertView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyOrderDetailActivity.class);
                intent.putExtra("orderId", item.orderId);
                context.startActivity(intent);
            }
        });
//        NineGridView nineGrid = baseViewHolder.getView(R.id.nineGrid);
//        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
//        if (model.images != null) {
//            for (String image : model.images) {
//                ImageInfo info = new ImageInfo();
//                info.setThumbnailUrl(image);
//                info.setBigImageUrl(image);
//                imageInfo.add(info);
//            }
//        }
//        nineGrid.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
    }

    private void addMenu(final MyOrderBean.OrderListBean.RecordsBean item, LinearLayout llButtons, String[] strings) {
        for (String string : strings) {
            if (TextUtils.equals(" 取消 ", string)) {
                final TextView tv = new TextView(context);
                tv.setBackgroundResource(R.drawable.bg_text_order_gray);
                setPadding(tv);
                tv.setTag(4);
                tv.setText(string);
                tv.setTextColor(CommonUtil.getColor(R.color.j_999999));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onButtonClick(item, (Integer) tv.getTag());
                    }
                });
                llButtons.addView(tv);
            }
            if (TextUtils.equals(" 删除 ", string)) {
                final TextView tv = new TextView(context);
                tv.setBackgroundResource(R.drawable.bg_text_order_gray);
                setPadding(tv);
                tv.setTag(2);
                tv.setText(string);
                tv.setTextColor(CommonUtil.getColor(R.color.j_999999));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onButtonClick(item, (Integer) tv.getTag());
                    }
                });
                llButtons.addView(tv);
            }
            if (TextUtils.equals("去付款", string)) {
                final TextView tv = new TextView(context);
                tv.setBackgroundResource(R.drawable.bg_text_order_blue);
                setPadding(tv);
                tv.setTag(1);
                tv.setText(string);
                tv.setTextColor(CommonUtil.getColor(R.color.j_0088cd));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onButtonClick(item, (Integer) tv.getTag());
                    }
                });
                llButtons.addView(tv);
            }
            if (TextUtils.equals(" 评价 ", string)) {
                final TextView tv = new TextView(context);
                tv.setBackgroundResource(R.drawable.bg_text_order_blue);
                setPadding(tv);
                tv.setTag(3);
                tv.setText(string);
                tv.setTextColor(CommonUtil.getColor(R.color.j_0088cd));
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onButtonClick(item, (Integer) tv.getTag());
                    }
                });
                llButtons.addView(tv);
            }
        }
    }

    private void setPadding(TextView textView) {
        textView.setPadding(CommonUtil.getDimens(R.dimen.dp10), CommonUtil.getDimens(R.dimen.dp3), CommonUtil.getDimens(R.dimen.dp10), CommonUtil.getDimens(R.dimen.dp3));
    }

    public interface OnClickListener {
        void onButtonClick(MyOrderBean.OrderListBean.RecordsBean dataBean, int tag);
    }
}
