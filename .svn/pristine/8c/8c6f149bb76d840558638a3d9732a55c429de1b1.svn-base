package com.hmkj.taozhifu.mpresenter;

import android.content.Context;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.LoginView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.MD5Builder;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StringUtils;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/8/24.
 *
 * @author
 */

public class LoginPresenter {
    LoginView loginView;
    Context mContext;

    public LoginPresenter(LoginView loginView, Context mContext) {
        this.loginView = loginView;
        this.mContext = mContext;
    }

    public void login(final String phone, String pwd) {
        //检查电话号码
        if (!StringUtils.checkInput(phone)) {
            return;
        }
        //检查密码
        if (!StringUtils.checkPwd(pwd)) {
            return;
        }
        try {
            LogUtil.LogLong("MD5_PASSWORD -- " + MD5Builder.getMD5(pwd));
            OkGo.<String>post(HttpConfig.LOGIN)
                    .cacheMode(CacheMode.NO_CACHE)
                    .params("phone", phone)
                    //加密处理
                    .params("password", MD5Builder.getMD5(pwd))
                    .execute(new CustomCallback(mContext) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            LogUtil.e("登录成功后返回的数据", response.body());
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int httpCode = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                if (httpCode == 200) {
                                    String token = jsonObject.getString("token");
                                    String expire = jsonObject.getString("expire");
                                    //用户id
                                    long memberId = jsonObject.getLong("memberId");
                                    //店铺id
                                    long shopId = jsonObject.getLong("shopId");
                                    OkGo.getInstance().addCommonHeaders(new HttpHeaders("token", token));
                                    //登录成功返回的Token
                                    SharedPreferencesUtil.put(mContext, "token", token);
                                    //登录成功返回的Expire
                                    SharedPreferencesUtil.put(mContext, "expire", expire);
                                    //登录成功返回的memberId
                                    SharedPreferencesUtil.put(mContext, "memberId", memberId);
                                    //登录成功手机号码
                                    SharedPreferencesUtil.put(mContext, "phone", phone);
                                    //登录成功店铺id
                                    SharedPreferencesUtil.put(mContext, "shopId", shopId);
                                    loginView.loginSuccess();
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

    public void codeLogin(final String phone, String code) {
        //检查电话号码
        if (!StringUtils.checkInput(phone)) {
            return;
        }
        if (TextUtils.isEmpty(code)) {
            ToastUtil.showToast("请输入验证码!");
            return;
        }
        OkGo.<String>post(HttpConfig.codeLogin)
                .cacheMode(CacheMode.NO_CACHE)
                .params("phone", phone)
                .params("code", code)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("验证码登录返回+" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                String token = jsonObject.getString("token");
                                String expire = jsonObject.getString("expire");
                                //用户id
                                long memberId = jsonObject.getLong("memberId");
                                //店铺id
                                long shopId = jsonObject.getLong("shopId");
                                OkGo.getInstance().addCommonHeaders(new HttpHeaders("token", token));
                                //登录成功返回的Token
                                SharedPreferencesUtil.put(mContext, "token", token);
                                //登录成功返回的Expire
                                SharedPreferencesUtil.put(mContext, "expire", expire);
                                //登录成功返回的memberId
                                SharedPreferencesUtil.put(mContext, "memberId", memberId);
                                //登录成功手机号码
                                SharedPreferencesUtil.put(mContext, "phone", phone);
                                //登录成功店铺id
                                SharedPreferencesUtil.put(mContext, "shopId", shopId);
                                loginView.loginSuccess();
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 检查是否登录
     *
     * @return true 登录|false非登录
     */
    public static boolean checkLogin(Context context) {
        return !TextUtils.isEmpty((String) SharedPreferencesUtil.get(context, "token", ""));
    }
}
