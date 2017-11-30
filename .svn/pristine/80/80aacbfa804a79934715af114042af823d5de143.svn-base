package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShopCollectionEntity;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.LocationUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;

import java.util.List;

import static com.hmkj.taozhifu.utils.CommonUtil.getString;

/**
 * Created by LiaoDuanHong  on 2017/8/29
 */

public class ShopCollectionAdapter extends BaseQuickAdapter<ShopCollectionEntity.DataBean.RecordsBean, BaseViewHolder> {
    private Context context;
    private OnItemListener onItemListener;

    public void setOnItemDeleteListener(OnItemListener onItemDeleteListener) {
        this.onItemListener = onItemDeleteListener;
    }

    public ShopCollectionAdapter(Context context, @Nullable List<ShopCollectionEntity.DataBean.RecordsBean> data) {
        super(R.layout.item_collection_info, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ShopCollectionEntity.DataBean.RecordsBean item) {
        if (item.getProShop() != null && item.getProShop().size() != 0) {
            double km = LocationUtil.getDistance(
                    Double.parseDouble((String) SharedPreferencesUtil.get(context, "latitude", "0.0")),
                    Double.parseDouble((String) SharedPreferencesUtil.get(context, "longitude", "0.0")),
                    item.getProShop().get(0).getLatitude(),
                    item.getProShop().get(0).getLongitude());
            helper.setText(R.id.tv_name, item.getProShop().get(0).getShopName())
                    .setText(R.id.tv_ange, String.format(getString(R.string.tv_money_person), item.getProShop().get(0).getAvgSpend()))
                    .setText(R.id.tv_distance, km < 1d ? String.format(getString(R.string.tv_distanceM), String.valueOf(km * 100))
                            : String.format(getString(R.string.tv_distanceK), String.valueOf(km)))
                    .setText(R.id.tv_address, item.getProShop().get(0).getShopAddress())
                    .setRating(R.id.rb, (float) item.getProShop().get(0).getShopCommentSum() / item.getProShop().get(0).getShopCommentNum());
//            Glide.with(context).load(item.getProShop().get(0).getShopSignage()).into((ImageView) helper.getView(R.id.iv_collection_pic));
            GlideUtils.loadImage(context, item.getProShop().get(0).getShopSignage(), (ImageView) helper.getView(R.id.iv_collection_pic));
            helper.getView(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemListener != null) {
                        onItemListener.onItemDeleteClick(helper.getAdapterPosition(), item);
                    }
                }
            });
            helper.getView(R.id.content).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemListener != null) {
                        onItemListener.onNavigationClick(helper.getAdapterPosition(), item);
                    }
                }
            });
        }
    }

    public interface OnItemListener {
        void onItemDeleteClick(int position, ShopCollectionEntity.DataBean.RecordsBean itemProShopBean);

        void onNavigationClick(int position, ShopCollectionEntity.DataBean.RecordsBean itemProShopBean);
    }
}
