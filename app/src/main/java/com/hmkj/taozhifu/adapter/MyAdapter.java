package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.myEntity;
import com.hmkj.taozhifu.utils.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */

public class MyAdapter extends BaseQuickAdapter<myEntity,BaseViewHolder> {
    private Context context;
    public MyAdapter(Context context, @Nullable List<myEntity> myEntityList) {
        super(R.layout.item_my, myEntityList);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, myEntity item) {
         helper.setText(R.id.mTitle,item.getTitle());
//        Glide.with(context).load(item.getImageView()).into((ImageView) helper.getView(R.id.mImage));
        GlideUtils.loadImage(context,item.getImageView(),(ImageView) helper.getView(R.id.mImage));
    }
}
