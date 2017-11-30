package com.hmkj.taozhifu.mpresenter;

import android.content.Context;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.RspView;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/8/23.
 */

public class RspPresenter {
    RspView rspView;
    private Context mContext;

    public RspPresenter(Context context, RspView rspView) {
        this.mContext = context;
        this.rspView = rspView;
    }

    //设置密码并注册
    public void registFinal(final String phone, String inviCode, final String pwd, String pwds) {
        if (!isSame(pwd, pwds)) {
            return;
        }
        try {
            OkGo.<String>post(HttpConfig.REGIST_FINAL)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("phone", phone)
                    .params("password", MD5Builder.getMD5(pwd))
                    .params("myRecommend", inviCode)
                    .execute(new CustomCallback(mContext) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int httpCode = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                if (httpCode == 200) {
                                    login(phone, pwd);
                                    ToastUtil.showToast(msg);
                                } else {
                                    ToastUtil.showToast(msg);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    //注册成功之后就直接登录
    public void login(String phone, String pwd) {
        try {
            OkGo.<String>post(HttpConfig.LOGIN)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("phone", phone)
                    .params("password", MD5Builder.getMD5(pwd))
                    .execute(new CustomCallback(mContext) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int httpCode = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                String token = jsonObject.getString("token");
                                String expire = jsonObject.getString("expire");
                                long memberId = jsonObject.getLong("memberId");//用户id
                                if (httpCode == 200) {
                                    OkGo.getInstance().addCommonHeaders(new HttpHeaders("token", token));
                                    SharedPreferencesUtil.put(mContext, "token", token);//登录成功返回的Token
                                    SharedPreferencesUtil.put(mContext, "expire", expire);//登录成功返回的Expire
                                    SharedPreferencesUtil.put(mContext, "memberId", memberId);//登录成功返回的memberId
                                    rspView.registFinalSuccess();
                                } else {
                                    ToastUtil.showToast(msg);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    //判断密码是否一致
    public boolean isSame(String pwd, String pwds) {
        boolean result = true;
        if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwds)) {
            ToastUtil.showToast("请输入密码!");
            result = false;
        }
        if (pwd.length() < 6 || pwds.length() < 6) {
            ToastUtil.showToast("请输入6-11位密码!");
            result = false;
        }
        if (!pwd.equals(pwds)) {
            ToastUtil.showToast("请输入相同的密码!");
            result = false;
        }
        return result;
    }

}
