package com.hmkj.taozhifu.mpresenter;

import android.content.Context;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.RealNameView;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/4.
 */

public class FIUserPresenter {
    Context mContext;
    RealNameView realNameView;

    public FIUserPresenter(Context mContext, RealNameView realNameView) {
        this.mContext = mContext;
        this.realNameView = realNameView;
    }

    public void fiInUser(final String realName) {//这里可以登录的时候吧id 和token存为系统变量  方便使用
        LogUtil.LogLong("传过来的姓名" + realName);
        if (!checkInput(realName)) {
            return;
        }
        long memberId = (long) SharedPreferencesUtil.get(mContext, "memberId", (long) 0);//默认为O
        String token = (String) SharedPreferencesUtil.get(mContext, "token", "");
        OkGo.<String>post(HttpConfig.FILL_IN_INFO)
                .params("memberId", memberId)
                .params("realName", realName)
                .headers("token", token)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("完善用户信息成功" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int HttpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (HttpCode == 200) {
                                realNameView.UserInfoSuccess();
                                SharedPreferencesUtil.put(mContext, "realName", realName);
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    // 检查输入的合法性
    public static boolean checkInput(String realName) {
        boolean result = true;
        // 1.检查为空
        if (TextUtils.isEmpty(realName)) {
            ToastUtil.showToast("真实姓名不能为空!");
            result = false;
        }
        return result;

    }
}
