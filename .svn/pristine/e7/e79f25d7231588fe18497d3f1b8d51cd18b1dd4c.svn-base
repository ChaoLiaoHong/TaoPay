package com.hmkj.taozhifu.utils;

import android.content.Context;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.platform.comapi.location.CoordinateType;

/**
 * 位置管理工具类 计算距离或经纬度的工具类
 *
 * @author summer
 */
public class LocationUtil {


    private final static double EARTH_RADIUS = 6378.137; // 地球半径

    private LocationClient mLocationClient;
    private BDLocationListener mlistener;

    public LocationUtil(Context context) {
        mLocationClient = new LocationClient(context);
        LocationClientOption option = initLocationOption();
        mLocationClient.setLocOption(option);
    }

    public LocationClient getmLocationClient() {
        return mLocationClient;
    }

    private LocationClientOption initLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 设置定位模式
        option.setCoorType(CoordinateType.BD09LL);// 返回的定位结果是百度经纬度,默认值gcj02
        option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
        option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        return option;
    }

    /**
     * 注册定位回调
     *
     * @param listener
     */
    public void registerLocationListener(BDLocationListener listener) {
        mlistener = listener;
        if (mlistener != null)
            mLocationClient.registerLocationListener(mlistener);
    }

    /**
     * 启动定位
     */
    public void start() {
        if (mLocationClient != null && !mLocationClient.isStarted())
            mLocationClient.start();
    }

    /**
     * 停止定位
     */
    public void stop() {
        if (mLocationClient != null && mLocationClient.isStarted()) {
            mLocationClient.stop();
        }
    }

    /**
     * 销毁定位
     */
    public void destroy() {
        if (mLocationClient != null) {
            mLocationClient.unRegisterLocationListener(mlistener);
            mLocationClient.stop();
            mLocationClient = null;
        }
    }


    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算距离 返回单位km
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        LogUtil.LogLong("LocationUtil", "lat1:" + lat1 + "lng1:" + lng1 + "lat2:" + lat2 + "lng2:" + lng2);
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        if (radLat1 == 0 || radLat2 == 0) {// 如果有一方等于零，直接返回0
            return 0;
        }
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;

    }

    /**
     * 距离格式化
     *
     * @param distance 以千米为单位
     * @return
     */
    public static String distanceKMFromart(double distance) {
        return distance > 1 ? (distance + "KM") : (distance * 1000 + "M");
    }

    /**
     * 距离格式化
     *
     * @param distance 以米为单位
     * @return
     */
    public static String distanceMFromart(double distance) {
        return distance >= 1000 ? (distance / 1000 + "KM") : (distance + "M");
    }

    public static String distanceFromart(double distance) {
        String str;
        double value = distance;
        if (distance >= 1000) {
            value = value / 1000;
            str = "KM";
        } else {
            str = "M";
        }
        return StringUtil.formatTwoDecimal(value) + str;
    }

}
