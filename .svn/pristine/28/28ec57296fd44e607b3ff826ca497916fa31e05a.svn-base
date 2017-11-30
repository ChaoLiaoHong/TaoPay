package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShopCommodityEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/29
 */

public class ShopCommodityAdapter extends BaseQuickAdapter<ShopCommodityEntity.ProCommodityPageBean.RecordsBean, BaseViewHolder> {
    private Context context;
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ShopCommodityAdapter(Context context, @Nullable List<ShopCommodityEntity.ProCommodityPageBean.RecordsBean> data) {
        super(R.layout.item_shop_commodity_info, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ShopCommodityEntity.ProCommodityPageBean.RecordsBean item) {
        //1、支持退款    2、不支持退款
        String string = null;
        if (item.isReturn == 1) {
            string = "支持退款";
        } else {
            string = "不支持退款";
        }
//        Glide.with(context).load(item.commodityImg).into((ImageView) helper.getView(R.id.iv_pic_commodity));
        GlideUtils.loadImage(context,item.commodityImg,(ImageView) helper.getView(R.id.iv_pic_commodity));
        helper.setText(R.id.tv_commodity_name, item.commodityName)
                .setText(R.id.tv_use_rule, string)
                .setText(R.id.tv_use_num, item.quantity + "/" + item.totalNum)
                .setText(R.id.tv_money, String.format(CommonUtil.getString(R.string.tv_money), String.valueOf(CommonUtil.Double2position(item.commodityPrice))));
        helper.getView(R.id.tv_ticket).setVisibility(View.GONE);
        helper.getView(R.id.ll_commodity_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(helper.getAdapterPosition(), item);
                }
            }
        });
    }

    public interface OnItemClick {
        void onItemClick(int position, ShopCommodityEntity.ProCommodityPageBean.RecordsBean item);
    }
}
