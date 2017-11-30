package com.hmkj.taozhifu.http;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.text.TextUtils;

import com.hmkj.taozhifu.activity.LoginActivity;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.LoadUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/24.
 */

public abstract class CustomCallback extends AbsCallback<String> {
    private LoadUtil loadUtil;
    private Context context;
    private String TAG = "CustomCallback";
    private StringConvert convert;

    public CustomCallback(Context context) {
        this(context, true, true);
    }

    public CustomCallback(Context context, boolean isCanceledOnTouchOut, boolean IsCancleable) {
        convert = new StringConvert();
        loadUtil = new LoadUtil(context);
        loadUtil.setCanceledOnTouchOutside(isCanceledOnTouchOut);
        loadUtil.setCancelable(IsCancleable);
        this.context = context;
    }

    @Override
    public String convertResponse(okhttp3.Response response) throws Throwable {
        String s = convert.convertResponse(response);
        response.close();
        return s;
    }

    @CallSuper
    @Override
    public void onStart(Request<String, ? extends Request> request) {
        LogUtil.LogLong(TAG, "onStart");
        if (loadUtil != null && !loadUtil.isShowing()) {
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing()) {
                    loadUtil.show();
                }
            } else {
                loadUtil.show();
            }
        }
    }

    @CallSuper
    @Override
    public void onSuccess(Response<String> response) {
        if (!TextUtils.isEmpty(response.body().toString()) && response.body().toString().contains("code")) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response.body());
                int httpCode = jsonObject.getInt("code");
                if (httpCode != 200) {
                    LogUtil.LogLong(TAG, response.body());
                    String msg = jsonObject.getString("msg");
                    if (AppUtils.checkId(msg)) {
                        if (msg.contains("token失效")) {
                            SharedPreferencesUtil.clear(context);
                            context.startActivity(new Intent(context, LoginActivity.class));
                            OkGo.getInstance().cancelAll();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @CallSuper
    @Override
    public void onFinish() {
        if (loadUtil != null && loadUtil.isShowing()) {
            loadUtil.dismiss();
        }
    }

    @CallSuper
    @Override
    public void onError(Response<String> response) {
        LogUtil.LogLong("CustomCallback-onError -- " + response.body());
        LogUtil.LogLong("CustomCallback-onError-getException -- " + response.getException());
        ToastUtil.showToast(AppUtils.Err(response.getException()));
    }
}
