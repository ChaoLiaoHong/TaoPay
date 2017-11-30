package com.hmkj.taozhifu.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.hmkj.taozhifu.MyApp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class AppUtils {
    public static final int uninstall = 10000;// 没有安装

    /**
     * 获取版本名称
     *
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 描述：打开并安装文件.
     *
     * @param context the context
     * @param file    apk文件路径
     */
    public static void installApk(Activity context, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivityForResult(intent, uninstall);
    }

    /**
     * 描述：卸载程序.
     *
     * @param context     the context
     * @param packageName 包名
     */
    public static void uninstallApk(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        Uri packageURI = Uri.parse("package:" + packageName);
        intent.setData(packageURI);
        context.startActivity(intent);
    }

    /**
     * 用来判断服务是否运行.
     *
     * @param ctx       the ctx
     * @param className 判断的服务名字 "com.xxx.xx..XXXService"
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRunning(Context ctx, String className) {
        boolean isRunning = false;
        ActivityManager activityManager =
                (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningServiceInfo> servicesList = activityManager.getRunningServices(Integer.MAX_VALUE);
        Iterator<RunningServiceInfo> l = servicesList.iterator();
        while (l.hasNext()) {
            RunningServiceInfo si = (RunningServiceInfo) l.next();
            if (className.equals(si.service.getClassName())) {
                isRunning = true;
            }
        }
        return isRunning;
    }

    /**
     * 停止服务.
     *
     * @param ctx       the ctx
     * @param className the class name
     * @return true, if successful
     */
    public static boolean stopRunningService(Context ctx, String className) {
        Intent intent_service = null;
        boolean ret = false;
        try {
            intent_service = new Intent(ctx, Class.forName(className));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intent_service != null) {
            ret = ctx.stopService(intent_service);
        }
        return ret;
    }

    /**
     * Gets the number of cores available in this device, across all processors.
     * Requires: Ability to peruse the filesystem at "/sys/devices/system/cpu"
     *
     * @return The number of cores, or 1 if failed to get result
     */
    public static int getNumCores() {
        try {
            // Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            // Filter to only list the devices we care about
            File[] files = dir.listFiles(new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    // Check if filename is "cpu", followed by CheckPay single digit
                    // number
                    if (Pattern.matches("cpu[0-9]", pathname.getName())) {
                        return true;
                    }
                    return false;
                }
            });
            // Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            // Default to return 1 core
            return 1;
        }
    }

    /**
     * 描述：判断网络是否有效.
     *
     * @param context the context
     * @return true, if is network available
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivity =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Gps是否打开 需要<uses-permission
     * android:name="android.permission.ACCESS_FINE_LOCATION" />权限
     *
     * @param context the context
     * @return true, if is gps enabled
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * wifi是否打开.
     *
     * @param context the context
     * @return true, if is wifi enabled
     */
    public static boolean isWifiEnabled(Context context) {
        ConnectivityManager mgrConn =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        TelephonyManager mgrTel =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return ((mgrConn.getActiveNetworkInfo() != null
                && mgrConn.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED)
                || mgrTel.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
    }

    /**
     * 判断当前网络是否是wifi网络.
     *
     * @param context the context
     * @return boolean
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
     * 判断当前网络是否是3G网络.
     *
     * @param context the context
     * @return boolean
     */
    public static boolean is3G(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        }
        return false;
    }

    /**
     * 获取IMEI
     *
     * @param context 上下文
     * @author 范俊
     */
    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 获得id地址
     */
    public static String getIp() {
        Socket socket = null;
        try {
            socket = new Socket("www.baidu.com", 80);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (socket != null) {
            socket.getLocalAddress().toString();
        }
        return "";
    }

    /**
     * 导入数据库
     */
    @SuppressLint("SdCardPath")
    public static boolean importDatabase(Context context, String dbName,
                                         int rawRes) {
        int buffer_size = 1024;
        InputStream is = null;
        FileOutputStream fos = null;
        boolean flag = false;
        try {
            String dbPath = "/data/data/" + context.getPackageName() + "/databases/" + dbName;
            File dbfile = new File(dbPath);
            // 判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
            if (!dbfile.exists()) {
                // 欲导入的数据库
                if (!dbfile.getParentFile().exists()) {
                    dbfile.getParentFile().mkdirs();
                }
                dbfile.createNewFile();
                is = context.getResources().openRawResource(rawRes);
                fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[buffer_size];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.flush();
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }
        return flag;
    }

    /**
     * 设置是否打开Wifi
     */
    public static void openWiFi(Context context, boolean enabled) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(enabled);
    }

    /**
     * 设置是否打开数据网络
     */
    public static void open3G(Context context, boolean enabled) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // ConnectivityManager类
        Class<?> connectivityManagerClass = null;
        // ConnectivityManager类中的字段
        Field connectivityManagerField = null;

        // IConnectivityManager接口
        Class<?> iConnectivityManagerClass = null;
        // IConnectivityManager接口的对象
        Object iConnectivityManagerObject = null;
        // IConnectivityManager接口的对象的方法
        Method setMobileDataEnabledMethod = null;

        try {
            // 取得ConnectivityManager类
            connectivityManagerClass = Class.forName(connectivityManager.getClass().getName());
            // 取得ConnectivityManager类中的字段mService
            connectivityManagerField = connectivityManagerClass.getDeclaredField("mService");
            // 取消访问私有字段的合法性检查
            // 该方法来自java.lang.reflect.AccessibleObject
            connectivityManagerField.setAccessible(true);

            // 实例化mService
            // 该get()方法来自java.lang.reflect.Field
            // 一定要注意该get()方法的参数:
            // 它是mService所属类的对象
            // 完整例子请参见:
            // http://blog.csdn.net/lfdfhl/article/details/13509839
            iConnectivityManagerObject = connectivityManagerField.get(connectivityManager);
            // 得到mService所属接口的Class
            iConnectivityManagerClass = Class.forName(iConnectivityManagerObject.getClass().getName());
            // 取得IConnectivityManager接口中的setMobileDataEnabled(boolean)方法
            // 该方法来自java.lang.Class.getDeclaredMethod
            setMobileDataEnabledMethod =
                    iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
            // 取消访问私有方法的合法性检查
            // 该方法来自java.lang.reflect.AccessibleObject
            setMobileDataEnabledMethod.setAccessible(true);
            // 调用setMobileDataEnabled方法
            setMobileDataEnabledMethod.invoke(iConnectivityManagerObject, enabled);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改文件权限
     */
    public static void chmod(String permission, String path) {
        try {
            String command = "chmod " + permission + " " + path;
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);
            Log.i("修改文件权限", "修改权限成功");
        } catch (IOException e) {
            Log.e("修改文件权限", "修改权限失败");
            e.printStackTrace();
        }
    }

    /**
     * 获得屏幕宽高
     *
     * @return [0]width [1]height
     */
    public static int[] getScreenHW(Activity activity) {
        int[] screenHW = new int[2];
        Display mDisplay = activity.getWindowManager().getDefaultDisplay();
        screenHW[0] = mDisplay.getWidth();
        screenHW[1] = mDisplay.getHeight();
        return screenHW;
    }

    /**
     * 判断app是否在运行中
     */
    public static boolean isAppRunning(Context context, String app_pkg) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        for (RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(app_pkg) || info.baseActivity.getPackageName()
                    .equals(app_pkg)) {
                isAppRunning = true;
                break;
            }
        }
        return isAppRunning;
    }

    /**
     * 判断当前应用程序处于前台还是后台
     */
    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得顶层activity的名字 （com.test.MainActivity）
     */
    public static String getTopActivity(Activity context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);

        if (runningTaskInfos != null) {
            String act = (runningTaskInfos.get(0).topActivity).toString();
            return act.substring(act.indexOf("/") + 1, act.lastIndexOf("}"));
        } else {
            return null;
        }
    }

    /**
     * 获得控件宽高
     *
     * @param view 控件
     * @return 0：w   1:h
     */
    public static int[] getViewWH(View view) {
        int[] wh = new int[2];
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        int width = view.getMeasuredWidth();
        wh[0] = w;
        wh[1] = h;
        return wh;
    }


    /**
     * 获取屏幕尺寸与密度.
     *
     * @param context the context
     * @return mDisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources mResources;
        if (context == null) {
            mResources = Resources.getSystem();
        } else {
            mResources = context.getResources();
        }
        DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
        return mDisplayMetrics;
    }

    /**
     * 禁止字体放大
     */
    public static void fontScaleNormal(Context context) {
        Resources resource = context.getResources();
        Configuration c = resource.getConfiguration();
        c.fontScale = 1.0f;
        resource.updateConfiguration(c, resource.getDisplayMetrics());
    }

    /**
     * 檢查是否有某個權限
     */
    public static boolean checkPermission(String permission, Context context) {
        PackageManager pm = context.getPackageManager();
        boolean per = (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission,
                context.getPackageName()));
        return per;
    }

    /**
     * 判断手机是否有这个应用
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAvilible(Context context, String packageName) {
        // 获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        // 用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        // 从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        // 判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        Log.e("WXisAvilible", packageNames.contains(packageName) + "!!!");
        return packageNames.contains(packageName);
    }

    /**
     * 在主线程执行一段任务
     *
     * @param r
     */
    public static void runOnUIThread(Runnable r) {
        MyApp.mHandler.post(r);
    }

    public static void runOnUIThreadDelayed(Runnable r, long time) {
        MyApp.mHandler.post(r);
        MyApp.mHandler.postDelayed(r, time);
    }

    public static void runInThread(Runnable r) {
        new Thread(r).start();
    }

    /**
     * 粗糙的double , 只保留两位小数
     *
     * @param d
     * @return
     */
    public static double coarseDouble(double d) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String format = df.format(d);
        return Double.parseDouble(format);
    }

    /**
     * 粗糙的double , 只保留两位小数
     *
     * @param d
     * @return
     */
    public static String stringDouble(double d) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String format = df.format(d);
        return format;
    }

    /**
     * 粗糙的float , 返回为double类型
     *
     * @param f
     * @return
     */
    public static float coarsefloat(float f) {
        double d = Double.parseDouble(String.valueOf(f));
        DecimalFormat df = new DecimalFormat("#0.00");
        String format = df.format(d);
        return Float.parseFloat(String.valueOf(Double.parseDouble(format)));
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private static int mYear;
    private static int mMonth;
    private static int mNowDay;
    private static int mNextDay;
    private static String m_month;
    private static String m_day;

    // 设置时间方法
    public static String StringData(int day) {

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        // 这边定义的年月日变量都要int类型 ， 不要问我为什么
        mYear = c.get(Calendar.YEAR); // 获取当前年份
        mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        mNowDay = c.get(Calendar.DAY_OF_MONTH);// 获取当前月份的日期号码

        c.set(Calendar.DAY_OF_MONTH, mNowDay + day); // 延后3天
        mNextDay = c.get(Calendar.DAY_OF_MONTH);
        // 判断延后的日期小于今天的日期，月份加一
        if (mNowDay > mNextDay) {
            mMonth += 1;
        }
        // 判断延后的月份大于本月的月份，月份设置为一月份，年份加一
        if (mMonth > 12) {
            mMonth = 1;
            mYear += 1;
        }
        // 测试今天的日期
        Log.e("今日时间===>", mYear + "年" + mMonth + "月" + mNowDay + "日");
        // 如果 月份为个位数则加个0在前面
        if (mMonth < 10) {
            m_month = "0" + mMonth;
        } else {
            m_month = "" + mMonth;
        }
        // 如果 天数为个位数则加个0在前面
        if (mNextDay < 10) {
            m_day = "0" + mNextDay;
        } else {
            m_day = "" + mNextDay;
        }
        return m_month + "月" + m_day + "日";
    }

    //    LoadingUtil.dismissDialog();
//    LogUtil.LogShitou(e.toString());
//    String err = Err(e);
//    if (err != null) {
//        ToastUtil.showToast(err);
//    }
    public static String Err(Throwable t) {
        if (t instanceof SocketTimeoutException) {
            return "网络连接超时";
        } else if (t instanceof ConnectException) {
            return "网络连接异常";
        } else if (t instanceof RuntimeException) {
            return "服务器错误";
        }
        return "未知错误";
    }

    //后台返回错误的时候data全是"" ,如果解析数组坑定报错,这里可以先判断一下
    public static boolean jsonCheck(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String data = null;
            if (jsonObject.has("data")) {
                if (jsonObject.getString("data").equals("")) {
                    ToastUtil.showToast(jsonObject.getString("msg"));
                    return false;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean jsonCheckHttpCode(String response, Context context) {
        try {
            if (TextUtils.isEmpty(response) | TextUtils.equals("", response))
                return false;
            JSONObject jsonObject = new JSONObject(response);
            String data = null;
            if (jsonObject.has("httpCode")) {
                if (jsonObject.getInt("httpCode") != 200 | !TextUtils.equals(jsonObject.getString("httpCode"), "200")) {
                    if (jsonObject.getInt("httpCode") == 201) {
                        LogUtil.LogLong("在其他地方登录了？ -- " + response);
                        ToastUtil.showToast(jsonObject.getString("msg").contains("ERROR") ? "服务器错误" : jsonObject.getString("msg"));
                        return false;
                    } else {
                        ToastUtil.showToast(jsonObject.getString("msg").contains("ERROR") ? "服务器错误" : jsonObject.getString("msg"));
                    }
                    ToastUtil.showToast(jsonObject.getString("msg").contains("ERROR") ? "服务器错误" : jsonObject.getString("msg"));
                    return false;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String getData(String response) {
        String data = "";
        if (response.length() > 0) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.has("data")) {
                    data = jsonObject.getString("data");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 空返回false , 有值为true
     * @param id
     * @return
     */
    public static boolean checkId(String id) {
        if (TextUtils.isEmpty(id) || TextUtils.equals("", id)) {
            return false;
        }
        return true;
    }

    /**
     * 防止过快多次点击
     */
    public static final int MIN_CLICK_DELAY_TIME = 500;
    private static long lastClickTime = 0;

    /**
     * false 就点快了
     * @return
     */
    public static boolean isFastClick() {
        long currentTime = System.currentTimeMillis();
        LogUtil.LogLong("time ： " + (currentTime - lastClickTime));
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return true;
        }
        LogUtil.LogLong("点那么快干啥");
        return false;
    }
}
