package com.hmkj.taozhifu.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hmkj.taozhifu.MyApp;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.permission.PermissionsActivity;
import com.hmkj.taozhifu.permission.PermissionsChecker;
import com.hmkj.taozhifu.receiver.NetBroadCastReceiver;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.LoadUtil;
import com.hmkj.taozhifu.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;

import static com.hmkj.taozhifu.utils.ToastUtil.showToast;

/**
 * Created by Administrator on 2017/8/15.
 */

public abstract class BaseFragmentActivity extends FragmentActivity implements NetBroadCastReceiver.NetEvevt {
    public static int[] screenWH;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBroadCastReceiver();//静态注册不顶用，只有动态注册了
        getScreenWH();
    }

    private void registerBroadCastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(new NetBroadCastReceiver(), filter);
        NetBroadCastReceiver.setNetEvevt(this);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void getReadPhoneState() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {//6.0以上系统
                //缺少权限时,进入权限配置页面
                if (new PermissionsChecker(this).lacksPermissions(new String[]{Manifest.permission.READ_PHONE_STATE})) {
                    PermissionsActivity.startActivityForResult(this, 0, new String[]{Manifest.permission.READ_PHONE_STATE});
                }
            }
        } catch (Exception e) {

        }
    }

    //退出app
    long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showToast("再按一次退出程序！");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;

    @TargetApi(23)
    public void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            /*
             * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
             */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }
            // 相机权限
            if (addPermission(permissions, Manifest.permission.CAMERA)) {
                permissionInfo += "Manifest.permission.CAMERA Deny \n";
            }
            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)) {
                return true;
            } else {
                permissionsList.add(permission);
                return false;
            }

        } else {
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public abstract void initData();

    public abstract void initView();

    private ProgressDialog dialog;
    public LoadUtil loadUtil;

    public void showLoading() {
        if (dialog != null && dialog.isShowing()) return;
        dialog = new ProgressDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("载入中...");
        dialog.show();
    }

    public void dismissLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void show() {
        show(true, true);
    }

    public void show(boolean touchOutside, boolean cancelable) {
        if (loadUtil == null) {
            loadUtil = new LoadUtil(this);
        }
        loadUtil.setCanceledOnTouchOutside(touchOutside);
        loadUtil.setCancelable(cancelable);
        loadUtil.show();
    }

    public void diss() {
        if (loadUtil != null && loadUtil.isShowing()) {
            loadUtil.dismiss();
        }
    }

    /**
     * 展示图片
     *
     * @param url
     * @param imageView
     */
    public void displayImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)//
                .load(url)//
                .error(R.drawable.img_error)
                .into(imageView);
    }

    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
        isNetConnect();
    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            ToastUtil.showToast("当前没有网络连接");
            return false;

        }
        ToastUtil.showToast("网络错误，请检查");
        return false;
    }

    public void getScreenWH() {
        screenWH = AppUtils.getScreenHW(this);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(Util.isOnMainThread()&&!this.isFinishing())
//        {
//            Glide.with(this).pauseRequests();
//        }
//    }
}
