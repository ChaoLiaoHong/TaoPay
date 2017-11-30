package com.hmkj.taozhifu.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.hmkj.taozhifu.utils.NetUtil;

/**
 * Created by Administrator on 2017/8/16.
 * 自定义检查手机网络状态是否切换的广播接受器
 */

public class NetBroadCastReceiver extends BroadcastReceiver {

    private static NetEvevt evevt;

    public static NetEvevt getNetEvevt() {
        return evevt;
    }

    public static void setNetEvevt(NetEvevt netEvevt) {
        evevt = netEvevt;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 如果相等的话就说明网络状态发生了变化
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetUtil.getNetWorkState(context);
            // 接口回调传过去状态的类型
            if (evevt != null) {
                evevt.onNetChange(netWorkState);
            }
        }
    }

    // 自定义接口
    public interface NetEvevt {
        public void onNetChange(int netMobile);
    }
}
