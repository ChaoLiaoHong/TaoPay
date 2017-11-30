package com.hmkj.taozhifu.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.hmkj.taozhifu.bean.VersionEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.view.alertview.AlertView;
import com.hmkj.taozhifu.view.alertview.OnItemClickListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author LuaKuangWi
 */

public class VersionUtils {
    public static void judgeVersion(final Context context) {//检测版本更新
        OkGo.<String>get(HttpConfig.versionUpdate)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        PackageManager pm = context.getPackageManager();
                        PackageInfo pi = null;
                        try {
                            pi = pm.getPackageInfo(context.getPackageName(), 0);
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            final int backCode = 200;
                            if (httpCode == backCode) {
                                VersionEntity versionEntity = new Gson().fromJson(response.body(), VersionEntity.class);
                                //版本号
                                int verCode = versionEntity.getSysAppVersion().getVersionNum();
                                //下载地址
                                final String downUrl = versionEntity.getSysAppVersion().getDownloadUrl();
                                //有新版本
                                if (pi.versionCode < verCode) {
                                    new AlertView("有新版本需要更新", "要跳转到下载界面吗？", "取消", null, new String[]{"本地下载"}, context, AlertView.Style.ActionSheet, new OnItemClickListener() {
                                        @Override
                                        public void onItemClick(Object o, int position) {
                                            switch (position) {
                                                //网页下载
                                                case 0:
                                                    if (!TextUtils.isEmpty(downUrl)) {
                                                        Uri uri = Uri.parse(downUrl);
                                                        Intent it = new Intent(Intent.ACTION_VIEW, uri);
                                                        context.startActivity(it);
                                                    }
                                                    break;
                                                default:
                                                    break;
                                            }

                                        }
                                    }).show();
                                } else {
                                    ToastUtil.showToast("已经是最新版本!");
                                }

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
