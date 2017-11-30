package com.hmkj.taozhifu.mpresenter;

import android.content.Context;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mmodel.AmoyPointEntity;
import com.hmkj.taozhifu.mview.AmoyPointView;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28.
 */

public class APpresenter {
    Context mContext;
    AmoyPointView amoyPoint;


    public APpresenter(Context mContext, AmoyPointView amoyPoint) {
        this.mContext = mContext;
        this.amoyPoint = amoyPoint;
    }

    public void queryAP() {
        long memberId = (long) SharedPreferencesUtil.get(mContext, "memberId", 0l);//默认为O
        OkGo.<String>get(HttpConfig.QUERY_TAODIAN_INFO + "/" + memberId)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.e("获取到的淘点信息", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                AmoyPointEntity amoyPointEntity = GsonUtil.GsonToBean(response.body(), AmoyPointEntity.class);
                                if (amoyPointEntity.getMemberAcount() == null) {
                                    return;
                                }
                                int mDot = amoyPointEntity.getMemberAcount().getDot();//淘点
                                int mIntegral = amoyPointEntity.getMemberAcount().getIntegral();//积分
                                double mcashCoupon = amoyPointEntity.getMemberAcount().getCashCoupon();//抵用卷
                                double mbusinessCoupon = amoyPointEntity.getMemberAcount().getBusinessCoupon();//商超卷
                                double mAmount = amoyPointEntity.getMemberAcount().getAmount();//现金
                                double amountGoods = amoyPointEntity.getMemberAcount().getAmountGoods();//货款
                                int mLevel = amoyPointEntity.getMemberAcount().getCkcomLevel();//创客等级
                                int memberLevel=amoyPointEntity.getMemberAcount().getMemberLevel();
                                amoyPoint.queryAPSuccess(mDot, mIntegral, mcashCoupon, mbusinessCoupon, mAmount, mLevel, amountGoods,memberLevel);
                            } else {
                                ToastUtil.showToast(msg.contains("token不能为空") ? "登录失效" : msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                });

    }
}
