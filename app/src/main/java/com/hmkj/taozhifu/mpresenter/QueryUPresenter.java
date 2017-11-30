package com.hmkj.taozhifu.mpresenter;

import android.content.Context;

import com.hmkj.taozhifu.bean.UserEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mview.QueryView;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/26.
 */

public class QueryUPresenter {
    Context mContext;
    QueryView queryUser;

    public QueryUPresenter(Context mContext, QueryView queryUser) {
        this.mContext = mContext;
        this.queryUser = queryUser;
    }

    public void queryUserInfo() {
        //默认为O
        final long memberId = (long) SharedPreferencesUtil.get(mContext, "memberId", (long) 0);
        String token = (String) SharedPreferencesUtil.get(mContext, "token", "");
        LogUtil.LogLong("获取本地存储的用户id", memberId + "");
        LogUtil.LogLong("获取本地存储的用户token", token);
        OkGo.<String>post(HttpConfig.QUERY_USER_INFO)
                .cacheMode(CacheMode.NO_CACHE)
                .params("memberId", memberId)
                .headers("token", token)
                .execute(new CustomCallback(mContext) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("用户信息", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                UserEntity userEntity = GsonUtil.GsonToBean(response.body(), UserEntity.class);
                                if (userEntity.getData() == null) {
                                    return;
                                }
                                String imgUrl = userEntity.getData().getImgUrl();
                                String myRecommend = userEntity.getData().getMyRecommend();
                                String phone = userEntity.getData().getPhone();
                                int mSex = userEntity.getData().getSex();
                                //店铺id
                                long shopId = userEntity.getData().getShopId();
                                //1普通2创客
                                int level = userEntity.getData().getMemberType();
                                String real_Name = userEntity.getData().getRealName();
                                //登录成功店铺id
                                SharedPreferencesUtil.put(mContext, "shopId", shopId);
                                SharedPreferencesUtil.put(mContext, "realName", real_Name);
                                queryUser.queryUserSuccess(imgUrl, myRecommend, phone, level);
                                queryUser.queryUserInfoSuccess(imgUrl, mSex, real_Name);
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
