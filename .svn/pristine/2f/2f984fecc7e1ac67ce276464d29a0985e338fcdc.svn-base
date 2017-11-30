package com.hmkj.taozhifu.mpresenter;

import android.content.Context;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.ForgetPwdView;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/5.
 */

public class ForgetPwdPresenter {
    Context mContext;
    ForgetPwdView forgetPwdView;

    public ForgetPwdPresenter(Context mContext, ForgetPwdView forgetPwdView) {
        this.mContext = mContext;
        this.forgetPwdView = forgetPwdView;
    }

    public void isCode(final String phone, String code) {
        if (!isCheckNull(phone, code)) {
            return;
        }
        OkGo.<String>post(HttpConfig.ISTRUE_CODE_FORGET)
                .cacheMode(CacheMode.NO_CACHE)
                .params("phone", phone)
                .params("code", code)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                forgetPwdView.isTrueCode(phone);
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    public boolean isCheckNull(String mphone, String mcode) {
        boolean result = true;
        if (TextUtils.isEmpty(mphone) || TextUtils.isEmpty(mcode)) {
            ToastUtil.showToast("请完善信息!");
            return false;
        }
        return result;
    }

}
