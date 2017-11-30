package com.hmkj.taozhifu.mpresenter;

import android.content.Context;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.RegistView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StringUtils;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/23.
 */

public class RegistPresenter {
    RegistView registView;
    Context mContext;

    public RegistPresenter(Context context, RegistView registView) {
        this.mContext = context;
        this.registView = registView;
    }

    /**
     * 获取验证码
     */
    public void takeCode(String phone, String type) {
        if (!StringUtils.checkInput(phone)) {
            LogUtil.e("电话号码不正确", "false" + phone + "这是值");
            return;
        }
        OkGo.<String>post(HttpConfig.GET_REGIST_CODE)
                .cacheMode(CacheMode.NO_CACHE)
                .params("phone", phone)
                //1是注册 2是身份认证 3. 修改
                .params("type", type)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.e("验证码返回", response.body() + "");
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpcode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpcode == 200) {
                                registView.startTime();//开始倒计时
                                registView.showSuccess();
                            } else {
                                ToastUtil.showToast(msg);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    //判断验证码是否正确
    public void isCode(String phone, String code) {
        LogUtil.e("客户端输入的验证码", code);
        OkGo.<String>post(HttpConfig.ISTRUE_CODE)
                .cacheMode(CacheMode.NO_CACHE)
                .params("phone", phone)
                .params("code", code)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.e("判断验证码是否一致返回", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpcode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpcode == 200) {
                                registView.showTrueCode();
                            } else {//验证码正确以外的问题
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    //点击下一步操作
    public boolean next(String phone, String invitercode, String code, boolean isCheck) {
        boolean result = true;
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code) || TextUtils.isEmpty(invitercode)) {
            registView.showPhoneCodeNoNull();
            return false;
        }
        if (invitercode.length() != 6) {
            ToastUtil.showToast("请输入6位邀请码!");
            return false;
        }
        if (!isCheck) {
            registView.shoewIsCheck();
            return false;
        }
        return result;
    }
}
