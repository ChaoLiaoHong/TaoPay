package com.hmkj.taozhifu.utils;

import android.content.Context;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.BaiduMapAppNotSupportNaviException;
import com.baidu.mapapi.navi.BaiduMapNavigation;
import com.baidu.mapapi.navi.NaviParaOption;

/**
 * 百度工具类
 * Created by summer on 2016/6/20.
 */
public class BaiduUtil {

    private Context context;

    public BaiduUtil(Context context) {
        this.context = context;
    }

    /**
     * 启动百度地图导航(Native),如果本地没有安装百度地图，调用WEBAPP
     *
     * @param pt1 起点
     * @param pt2 终点
     */
    public void startNavi(LatLng pt1, LatLng pt2) {
        if (pt1 == null || pt2 == null)
            return;
        // 构建 导航参数
        NaviParaOption para = new NaviParaOption()
                .startPoint(pt1).endPoint(pt2);
        try {
            BaiduMapNavigation.openBaiduMapNavi(para, context);
        } catch (BaiduMapAppNotSupportNaviException e) {
            ToastUtil.showToast("请安装百度地图");
            //BaiduMapNavigation.openWebBaiduMapNavi(para, context);
            e.printStackTrace();
        }
    }

    /**
     * 启动百度地图导航(Web)
     *
     * @param pt1
     * @param pt2
     */
    public void startWebNavi(LatLng pt1, LatLng pt2) {
        NaviParaOption para = new NaviParaOption()
                .startPoint(pt1).endPoint(pt2);
        BaiduMapNavigation.openWebBaiduMapNavi(para, context);
    }

}
