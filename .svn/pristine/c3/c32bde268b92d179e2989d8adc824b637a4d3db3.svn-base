package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.MyStoreAccountPaidBean;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.SpannableStringUtils;
import com.hmkj.taozhifu.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public class MyStoreAccountPaidAdapter extends BaseQuickAdapter<MyStoreAccountPaidBean.OrderListBean.RecordsBean, BaseViewHolder> {

    Context context;

    public MyStoreAccountPaidAdapter(@Nullable List<MyStoreAccountPaidBean.OrderListBean.RecordsBean> data, Context context) {
        super(R.layout.item_my_store_account_paid, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyStoreAccountPaidBean.OrderListBean.RecordsBean item) {
        GlideUtils.loadImage(context,item.headUrl,(ImageView)helper.getView(R.id.iv_head));
        helper.setText(R.id.tv_name, item.consigneePhone)
                .setText(R.id.tv_time, StringUtils.longToString(item.createTime, "yyyy-MM-dd HH:mm:ss"))
                .setText(R.id.tv_order_number, "订单编号：" + item.orderNo);
        String msg = "消费金额：";
        ((TextView) helper.getView(R.id.tv_consume_money)).setText(
                SpannableStringUtils.getBuilder(msg).append(CommonUtil.getString(R.string.RMB) + item.totalAmount).setClickSpan(clickableSpan).create());
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(CommonUtil.getColor(R.color.j_0088cd));
        }
    };
}
