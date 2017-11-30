package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.MyStoreProductBean;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StringUtils;

import java.util.List;

import static com.hmkj.taozhifu.R.id.tv_product_undercarriage;

/**
 * Created by Administrator on 2017/8/30.
 */

public class MyStoreProductAdapter extends BaseQuickAdapter<MyStoreProductBean.ProCommodityPageBean.RecordsBean, BaseViewHolder> {

    Context context;

    public MyStoreProductAdapter(@Nullable List<MyStoreProductBean.ProCommodityPageBean.RecordsBean> data, Context context) {
        super(R.layout.item_my_store_product, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyStoreProductBean.ProCommodityPageBean.RecordsBean item) {
        //审核状态：1.待审核2.审核通过3.审核不通过
        helper.setText(R.id.tv_term_of_validity, item.endTime == 0l ? "未设置有效期" : "有效期至" + (StringUtils.longToString(item.endTime, "yyyy-MM-dd")))
                .setText(R.id.tv_already_grounding, item.checkState == 1 ? "审核中" : (item.checkState == 2 ? (item.upState == 1 ? "已上架" : "已下架") : "审核不通过"))
                .setText(R.id.tv_product_name, item.commodityName)
                .setText(R.id.tv_product_collection, item.collectionNum + "")
                .setText(R.id.tv_e_coupon, CommonUtil.getString(R.string.RMB) + item.commodityPrice)
                .setText(R.id.tv_e_coupon_used, item.quantity + "/" + item.totalNum)
                .addOnClickListener(R.id.ll_product_edit).addOnClickListener(R.id.ll_product_undercarriage)
                .addOnClickListener(R.id.ll_content)
        ;
        if (item.upState == 1) {
            ((TextView) helper.getView(tv_product_undercarriage)).setText("下架");
        } else if (item.upState == 2) {
            ((TextView) helper.getView(tv_product_undercarriage)).setText("上架");
        }
        if (item.checkState == 1)
            ((TextView) helper.getView(tv_product_undercarriage)).setVisibility(View.GONE);
        else ((TextView) helper.getView(tv_product_undercarriage)).setVisibility(View.VISIBLE);
        GlideUtils.loadImage(context, item.commodityImg, (ImageView) helper.getView(R.id.iv_product_img));
    }
}
