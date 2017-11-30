package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.CommodityCollectionEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.LocationUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;

import java.util.List;

import static com.hmkj.taozhifu.utils.CommonUtil.getString;

/**
 * Created by LiaoDuanHong  on 2017/9/6
 */

public class CommodityCollectionAdapter extends BaseQuickAdapter<CommodityCollectionEntity.DataBean.RecordsBean, BaseViewHolder> {
    private Context context;
    private OnCommodityItemListener onCommodityItemListener;

    public void setOnCommodityItemListener(OnCommodityItemListener onCommodityItemListener) {
        this.onCommodityItemListener = onCommodityItemListener;
    }

    public CommodityCollectionAdapter(Context context, @Nullable List<CommodityCollectionEntity.DataBean.RecordsBean> data) {
        super(R.layout.item_commodity_collection_info, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final CommodityCollectionEntity.DataBean.RecordsBean item) {
        final CommodityCollectionEntity.DataBean.RecordsBean.ProCommodityBean proCommodityBean = item.getProCommodity().get(0);
        double km = LocationUtil.getDistance(
                Double.parseDouble((String) SharedPreferencesUtil.get(context, "latitude", "0.0")),
                Double.parseDouble((String) SharedPreferencesUtil.get(context, "longitude", "0.0")),
                proCommodityBean.getLatitude(),
                proCommodityBean.getLongitude());
        helper.setText(R.id.tv_name, proCommodityBean.getShopName())
                .setText(R.id.tv_set_meal, proCommodityBean.getCommodityName())
                .setText(R.id.tv_distance, km < 1d ? String.format(getString(R.string.tv_distanceM), String.valueOf(km * 100))
                        : String.format(getString(R.string.tv_distanceK), String.valueOf(km)))
                .setText(R.id.tv_sale_money, String.format(CommonUtil.getString(R.string.tv_money), proCommodityBean.getCommodityPrice()));
//        TextView textView = helper.getView(R.id.tv_former_money);
//        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
        GlideUtils.loadImage(context,proCommodityBean.getCommodityImg(),(ImageView) helper.getView(R.id.iv_collection_pic));
//        Glide.with(context).load(proCommodityBean.getCommodityImg()).into((ImageView) helper.getView(R.id.iv_collection_pic));
        helper.getView(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCommodityItemListener != null) {
                    onCommodityItemListener.onItemDeleteClick(helper.getAdapterPosition(), item);
                }
            }
        });
        helper.getView(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCommodityItemListener != null) {
                    onCommodityItemListener.onNavigationClick(helper.getAdapterPosition(), item);
                }
            }
        });
    }

    public interface OnCommodityItemListener {
        void onItemDeleteClick(int position, CommodityCollectionEntity.DataBean.RecordsBean itemProCommodityBean);

        void onNavigationClick(int position, CommodityCollectionEntity.DataBean.RecordsBean itemProCommodityBean);
    }
}
