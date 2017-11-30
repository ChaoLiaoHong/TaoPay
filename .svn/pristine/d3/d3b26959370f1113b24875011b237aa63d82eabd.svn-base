package com.hmkj.taozhifu.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;

public class Alipay extends PayMoney {
    private Handler handler;

    public Alipay(Handler handler) {
        this.handler = handler;
    }

    @Override
    <T extends Activity> void pay(final T context, final String paySign) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(context);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(paySign, true);
                // 回调
                PayResult payResult = new PayResult(result);
                /**
                 * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                 * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                 * docType=1) 建议商户依赖异步通知
                 */
                // String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                String resultStatus = payResult.getResultStatus();
                String resMsg;
                // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                if (resultStatus.trim().equals("9000")) {
                    resMsg = "支付成功";
                } else {
                    // 判断resultStatus 为非"9000"则代表可能支付失败
                    // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                    if (resultStatus.trim().equals("8000")) {
                        resMsg = "支付结果待确认中";
                    } else {
                        // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                        resMsg = "支付失败";
                    }
                }
                Message msg = new Message();
                msg.obj = resMsg;
                msg.what = 100;
                handler.sendMessage(msg);

            }
        }).start();
    }


}
