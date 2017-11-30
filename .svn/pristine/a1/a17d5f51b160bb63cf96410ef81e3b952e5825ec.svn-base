package com.hmkj.taozhifu.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.TaoDianInfoEntity;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class TaoDianAdapter extends BaseQuickAdapter<TaoDianInfoEntity.PageBean.RecordsBean, BaseViewHolder> {
    public TaoDianAdapter(List<TaoDianInfoEntity.PageBean.RecordsBean> data) {
        super(R.layout.item_my_taodian, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TaoDianInfoEntity.PageBean.RecordsBean item) {
        int tradeType = item.getTradeType();
        String trade = null;
        switch (tradeType) {
            case 1:
                trade = "现金交易";
                break;
            case 2:
                trade = "抵用券";
                break;
            case 3:
                trade = "商超卷";
                break;
            case 4:
                trade = "贷款";
                break;
            case 5:
                trade = "积分";
                break;
            default:
                break;
        }
        helper.setText(R.id.tv_name, item.getInfo())
                .setText(R.id.tv_time, TimeUtil.getTime3String(item.getCreateTime(), ""))//时间是long型的转一下
                .setText(R.id.tv_des, trade);//1.现金交易2.代金券3.商超卷4.贷款5.积分
        if (item.getType() == 2) {//收入
            helper.setText(R.id.tv_price, "+" + String.valueOf(CommonUtil.Double2position(item.getAmount())));
        } else {//1支出
            helper.setText(R.id.tv_price, "-" + String.valueOf(CommonUtil.Double2position(item.getAmount())));
        }
    }
}
