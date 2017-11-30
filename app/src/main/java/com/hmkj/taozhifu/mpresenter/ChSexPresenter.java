package com.hmkj.taozhifu.mpresenter;

import android.content.Context;

import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.SexView;
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

public class ChSexPresenter {
    Context mContext;
    SexView sexView;

    public ChSexPresenter(Context mContext, SexView sexView) {
        this.mContext = mContext;
        this.sexView = sexView;
    }

    public void perfectSex(final String sex) {
        long memberId = (long) SharedPreferencesUtil.get(mContext, "memberId", (long) 0);//默认为O
        String token = (String) SharedPreferencesUtil.get(mContext, "token", "");
        OkGo.<String>put(HttpConfig.SEX_INFO)
                .headers("token", token)
                .params("memberId", memberId)
                .params("sex", sex)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("修改性别的返回", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                sexView.chooseSexSuccess(sex);
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
