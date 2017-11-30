package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.ShopListActivity;
import com.hmkj.taozhifu.bean.ShopClassifyEntity;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/18
 */

public class ShopClassifyAdapter extends BaseQuickAdapter<ShopClassifyEntity.DataBean, BaseViewHolder> {
    private ShopSmallClassifyAdapter adapter;
    private Context context;
    private int type;
    OnItemClickListener onItemClickListener;

    public ShopClassifyAdapter(Context context, @Nullable List<ShopClassifyEntity.DataBean> data, int type, OnItemClickListener onItemClickListener) {
        super(R.layout.item_shop_classify_info, data);
        this.context = context;
        this.type = type;
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    protected void convert(BaseViewHolder helper, final ShopClassifyEntity.DataBean item) {
        helper.setText(R.id.classify_name, item.getClassName()).addOnClickListener(R.id.tv_all);
        adapter = new ShopSmallClassifyAdapter(context, item.getUnderClass(), type);
        helper.setAdapter(R.id.small_classify_gv, adapter);
        adapter.setOnItemClick(new ShopSmallClassifyAdapter.OnItemClick() {
            @Override
            public void onItemClick(ShopClassifyEntity.DataBean.UnderClassBean itemData) {
                if (type == 1) {
                    Intent intent = new Intent(context, ShopListActivity.class);
                    intent.putExtra("title", itemData.getClassName());
                    intent.putExtra("classId", String.valueOf(itemData.getClassId()));
                    intent.putExtra("type", "3");
                    context.startActivity(intent);
                } else if (type == 2 && onItemClickListener != null) {
                    onItemClickListener.onItemClick(item.getClassName(), itemData.getClassName(),String.valueOf(itemData.getClassId()));
                }
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(String name, String des,String classId);
    }
}
