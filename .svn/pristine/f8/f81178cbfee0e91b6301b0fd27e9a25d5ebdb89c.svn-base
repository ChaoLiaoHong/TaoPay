package com.hmkj.taozhifu.mpresenter;

import android.content.Context;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.ZfCodeView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/13.
 */

public class ZfCodePresenter {
    ZfCodeView zfCodeView;
    Context mContext;

    public ZfCodePresenter(ZfCodeView zfCodeView, Context mContext) {
        this.zfCodeView = zfCodeView;
        this.mContext = mContext;
    }

    public void getCode(String mphone) {
        LogUtil.LogLong("设置支付密码获取的手机号码" + mphone);
        OkGo.<String>post(HttpConfig.GET_ZFCODE)
                .cacheMode(CacheMode.NO_CACHE)
                .params("phone", mphone)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("获取到的验证码" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                zfCodeView.startTime();//开始倒计时
                                zfCodeView.getzfCodeSuccess();
                            } else {
                                ToastUtil.showToast(msg);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

    }
}
