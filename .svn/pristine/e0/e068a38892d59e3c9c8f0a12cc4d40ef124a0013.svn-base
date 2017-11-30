package com.hmkj.taozhifu.wxapi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
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
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        LogUtil.LogLong("onWXPayFinish, errCode = " + resp.errCode);
        if (resp.errCode == -1) ToastUtil.showToast("支付失败");
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            //这里就是支付完成后需要做的事，如跳到哪个页面啥的
            if (resp.errCode == 0)
                org.greenrobot.eventbus.EventBus.getDefault().post(new EventBusEntity(100));
            finish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}