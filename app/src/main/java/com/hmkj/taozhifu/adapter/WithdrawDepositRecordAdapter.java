package com.hmkj.taozhifu.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.WithdrawDepositRecordEntity.PageBean.RecordsBean;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.TimeUtil;


/**
 * Created by LiaoDuanHong  on 2017/10/23
 */

public class WithdrawDepositRecordAdapter extends BaseQuickAdapter<RecordsBean, BaseViewHolder> {
    private final int weixin = 1, ali = 2;

    public WithdrawDepositRecordAdapter() {
        super(R.layout.item_my_taodian);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecordsBean item) {
        switch (item.getWithdrawalWay()) {
            case weixin:
                helper.setText(R.id.tv_name, "微信提现");
                break;
            case ali:
                helper.setText(R.id.tv_name, "支付宝提现");
                break;
            default:
                break;
        }
        //时间是long型的转一下
        helper.setText(R.id.tv_time, TimeUtil.getTime2String(item.getCreateTime(), ""));
        if (item.getType() == 1) {
            helper.setText(R.id.tv_price, String.valueOf(CommonUtil.Double2position(item.getAmount())) + "(普通余额)");
        } else {
            helper.setText(R.id.tv_price, String.valueOf(CommonUtil.Double2position(item.getAmount())) + "(货款余额)");
        }
        switch (item.getState()) {
            case 1:
                helper.setText(R.id.tv_des, "审核中");
                break;
            case 2:
                helper.setText(R.id.tv_des, "审核通过");
                break;
            case 3:
                helper.setText(R.id.tv_des, "审核未通过");
                break;
            default:
                break;
        }
    }
}
