package com.hmkj.taozhifu.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShopListEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;

import java.util.List;

import static com.hmkj.taozhifu.utils.CommonUtil.getString;

/**
 * Created by LiaoDuanHong  on 2017/8/22
 */

public class ShopListAdapter extends BaseQuickAdapter<ShopListEntity.DataBean.ContentsBean, BaseViewHolder> {
    private Context context;

    public ShopListAdapter(Context context, @Nullable List<ShopListEntity.DataBean.ContentsBean> data) {
        super(R.layout.item_shop_list_info, data);
        this.context = context;
    }

    @SuppressLint("StringFormatMatches")
    @Override
    protected void convert(BaseViewHolder helper, final ShopListEntity.DataBean.ContentsBean item) {
        double distance = item.getDistance();
        String dis = null;
        String present = null;
        if (distance < 1000) {
            dis = String.format(getString(R.string.tv_distanceM), String.valueOf(distance));
        } else {
            dis = String.format(context.getString(R.string.tv_distance), CommonUtil.Double1position(distance / 1000));
        }
        if (item.getShopDiscount() == 100) {
            // present = "目前没有赠送";
            helper.getView(R.id.v_lian).setVisibility(View.GONE);
            helper.getView(R.id.tv_present).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.v_lian).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_present).setVisibility(View.VISIBLE);
            int presents = (100 - item.getShopDiscount()) * item.getRebateIntegralMember();
            present = "消费100元赠送" + presents + "积分";
        }
        helper.setText(R.id.tv_commodity_name, item.getShopName())
                .setText(R.id.tv_money_person, String.format(context.getString(R.string.tv_money_person), String.valueOf(CommonUtil.Double2position(item.getAvgSpend()))))
                .setText(R.id.tv_distance, dis)
                .setText(R.id.tv_address, item.getAddress())
                .setText(R.id.tv_present, present)
                .setRating(R.id.rb, item.getShopStartLevel());
//        Glide.with(context).load(item.getShop_signage().getMid()).into((ImageView) helper.getView(R.id.iv_commodity_pic));
        GlideUtils.loadImage(context,item.getShop_signage().getMid(),(ImageView) helper.getView(R.id.iv_commodity_pic));
    }
}
