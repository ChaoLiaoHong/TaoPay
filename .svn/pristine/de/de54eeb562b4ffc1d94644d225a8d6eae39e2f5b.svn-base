package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShareEntity;
import com.hmkj.taozhifu.utils.CommonUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public class ShareAdapter extends BaseQuickAdapter<ShareEntity, BaseViewHolder> {
    private Context context;

    public ShareAdapter(Context context, @Nullable List<ShareEntity> shareEntities) {
        super(R.layout.item_share, shareEntities);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShareEntity item) {
//        Glide.with(context).load(item.getImg()).into((ImageView) helper.getView(R.id.share_logo));
//        GlideUtils.loadImage(context,item.getImg(),(ImageView) helper.getView(R.id.share_logo));
        ((ImageView) helper.getView(R.id.share_logo)).setImageDrawable(CommonUtil.getDrawable(item.getImg()));
    }
}
