package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.HomeNoticeEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.TimeUtil;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/31
 * 公告adapter
 */

public class NoticeAdapter extends BaseQuickAdapter<HomeNoticeEntity.DataBean.RecordsBean, BaseViewHolder> {
    private Context context;

    public NoticeAdapter(Context context, @Nullable List<HomeNoticeEntity.DataBean.RecordsBean> data) {
        super(R.layout.item_notice_info, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNoticeEntity.DataBean.RecordsBean item) {
        helper.setText(R.id.tv_notice_name, item.getNoticeName())
                .setText(R.id.tv_notice_date, TimeUtil.getTime2String(item.getCreateTime(), ""));
        GlideUtils.loadImage(context,item.getImg(),(ImageView) helper.getView(R.id.iv_notice_img), CommonUtil.getDrawable(R.drawable.img_error));
    }
}
