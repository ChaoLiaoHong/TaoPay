package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShopCommentEntity;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.TimeUtil;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/26
 */

public class ShopCommentAdapter extends BaseQuickAdapter<ShopCommentEntity.DataBean.RecordsBean, BaseViewHolder> {
    private Context context;

    public ShopCommentAdapter(Context context, @Nullable List<ShopCommentEntity.DataBean.RecordsBean> data) {
        super(R.layout.item_shop_comments_info, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopCommentEntity.DataBean.RecordsBean item) {
        helper.setText(R.id.tv_person_name, item.getMemberNickName())
                .setText(R.id.tv_date, TimeUtil.converFromSecondTime(item.getCreateTime() / 1000))
                .setText(R.id.tv_comments, item.getComments())
                .setRating(R.id.rb_comments, item.getStarLevel());
//        Glide.with(context).load(R.drawable.img_head_default).into((ImageView) helper.getView(R.id.img_head));
        GlideUtils.loadImage(context,R.drawable.img_head_default,(ImageView) helper.getView(R.id.img_head));
        NineGridView nineGrid = helper.getView(R.id.nineGrid);
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
        if (item.getCommentImgs() != null) {
            for (String image : item.getCommentImgs()) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image);
                info.setBigImageUrl(image);
                imageInfo.add(info);
            }
            nineGrid.setAdapter(new NineGridViewClickAdapter(context, imageInfo));
        } else {
            helper.getView(R.id.nineGrid).setVisibility(View.GONE);
        }

    }
}
