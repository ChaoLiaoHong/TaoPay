package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ExchengeOrderBean;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyStoreExchengeOrderAdapter extends BaseQuickAdapter<ExchengeOrderBean.OrdersPageBean.RecordsBean, BaseViewHolder> {
    private Context context;

    public MyStoreExchengeOrderAdapter(Context context, List<ExchengeOrderBean.OrdersPageBean.RecordsBean> data) {
        super(R.layout.item_my_store_exchange_order, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ExchengeOrderBean.OrdersPageBean.RecordsBean item) {
        GlideUtils.loadImage(context, item.headUrl, (ImageView) helper.getView(R.id.iv_head));
        GlideUtils.loadImage(context, item.imgUrl, (ImageView) helper.getView(R.id.iv_product_img));
        helper.setText(R.id.tv_name, item.consigneePhone)
                .setText(R.id.tv_order_number, "订单编号：" + item.orderNo)
                .setText(R.id.tv_product_name, item.name)
                .setText(R.id.tv_product_nub, "x" + item.quantity)
                .setText(R.id.tv_product_price, "消费金额：" + CommonUtil.getString(R.string.RMB) + item.cashCoupon)
                .setText(R.id.tv_time, StringUtils.longToString(item.createTime, "yyyy-MM-dd HH:mm:ss"))
        ;
        TextView TvStatu = (TextView) helper.getView(R.id.tv_statu);
        TextView tvIsAppraise = (TextView) helper.getView(R.id.tv_is_appraise);
        switch (item.orderStatus) {
            case 1:
                TvStatu.setText("待付款");
                tvIsAppraise.setText("");
                break;
            case 2:
                TvStatu.setText("待使用");
                tvIsAppraise.setText("未评价");
                break;
            case 3:
                TvStatu.setText("已使用");
                tvIsAppraise.setText("待评价");
                break;
            case 4:
                TvStatu.setText("已完成");
                tvIsAppraise.setText("已评价");
                break;
            case 5:
                TvStatu.setText("已取消");
                tvIsAppraise.setText("");
                break;
            case 6:
                TvStatu.setText("已删除");
                tvIsAppraise.setText("");
                break;
            default:
                TvStatu.setText("");
                tvIsAppraise.setText("");
                break;
        }
    }
}
