package com.hmkj.taozhifu.wxapi;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.weixin.callback.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity implements IWXAPIEventHandler {//extends  {
    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, HttpConfig.APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.LogLong("WXEntryActivity -- " + baseResp.errCode);
        if (TextUtils.equals("1", (String) SharedPreferencesUtil.get(this, "isWxShare", "1")))
            finish();
    }
}
