package com.hmkj.taozhifu.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.TaoDianInfoEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyWalletAdapter extends BaseQuickAdapter<TaoDianInfoEntity.PageBean.RecordsBean, BaseViewHolder> {

    public MyWalletAdapter(List<TaoDianInfoEntity.PageBean.RecordsBean> data) {
        super(R.layout.item_my_taodian, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TaoDianInfoEntity.PageBean.RecordsBean item) {
        helper.setText(R.id.tv_name, item.getInfo())
                .setText(R.id.tv_time, TimeUtil.getTime2String(item.getCreateTime(), ""));//时间是long型的转一下
        //1.现金交易2.代金券3.商超卷4.贷款5.积分
        switch (item.getTradeType()) {
            case 1:
                helper.setText(R.id.tv_des, "现金交易");
                break;
            case 2:
                helper.setText(R.id.tv_des, "抵用券");
                break;
            case 3:
                helper.setText(R.id.tv_des, "商超券");
                break;
            case 4:
                helper.setText(R.id.tv_des, "货款");
                break;
            case 5:
                helper.setText(R.id.tv_des, "积分");
                break;
            default:
                break;
        }
        if (item.getType() == 2) {//收入
            helper.setText(R.id.tv_price, "+" + String.valueOf(CommonUtil.Double2position(item.getAmount())));
        } else {
            helper.setText(R.id.tv_price, "-" + String.valueOf(CommonUtil.Double2position(item.getAmount())));
        }
    }


}
