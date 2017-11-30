package com.hmkj.taozhifu.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.MyApp;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.receiver.NetBroadCastReceiver;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.LoadUtil;
import com.hmkj.taozhifu.utils.NetUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.umeng.analytics.MobclickAgent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15.
 */

public abstract class BaseActivity<T> extends AppCompatActivity implements NetBroadCastReceiver.NetEvevt {

    public LoadUtil loadUtil;
    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 有全局的异常捕获，则需要自己查看文档进行相应操作
         */
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //开启错误统计功能
        MobclickAgent.setCatchUncaughtExceptions(true);
        loadUtil = new LoadUtil(this);
        NetBroadCastReceiver.setNetEvevt(this);
        inspectNet();
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
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);// 友盟统计[统计时长]
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);// 友盟统计[统计时长]
    }

    public long getMemberId() {
        return (Long) SharedPreferencesUtil.get(this, "memberId", 0l);
    }

    public String getText(TextView textView) {
        return textView.getText().toString().trim();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    /**
     * 获取主题色
     */
    public int getColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /**
     * 获取深主题色
     */
    public int getDarkColorPrimary() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        return typedValue.data;
    }

    /**
     * 初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, boolean showTitleEnabled, String title, int titleColor, int navigationIcon) {
        if (AppUtils.checkId(title)) {
            toolbar.setTitle(title);
            toolbar.setTitleTextColor(titleColor);
        }
        toolbar.setNavigationIcon(navigationIcon);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
        getSupportActionBar().setDisplayShowTitleEnabled(showTitleEnabled);
        getSupportActionBar().setElevation(0);
    }

    /**
     * 初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, boolean showTitleEnabled, String title) {
        initToolBar(toolbar, homeAsUpEnabled, showTitleEnabled, title, R.color.j_666666, R.drawable.ic_arrow_back_dark_24dp);
    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, boolean showTitleEnabled, int resTitle) {
        initToolBar(toolbar, homeAsUpEnabled, showTitleEnabled, getString(resTitle), R.color.j_666666, R.drawable.ic_arrow_back_dark_24dp);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private ProgressDialog dialog;

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

    public void displayImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext)//
                .load(url)//
                .placeholder(R.drawable.ic_default_color)
                .error(R.drawable.img_error)
                .into(imageView);
    }

    public abstract void initData();

    public abstract void initView();

    /**
     * 初始化时判断有没有网络
     */
    public boolean inspectNet() {
        this.netMobile = NetUtil.getNetWorkState(this);
        return isNetConnect();
    }

    /**
     * 网络变化之后的类型
     * * @return 0:流量 , 1:wifi , -1:没网
     */
    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
        isNetConnect();

    }

    /**
     * 判断有无网络 。
     *
     * @return 0:流量 , 1:wifi , -1:没网
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

    /**
     * @param t 必须继承BaseQuickAdapter
     * @return
     */
    public T setBaseAdapter(T t, boolean b) {
        if (t instanceof BaseQuickAdapter) {
            ((BaseQuickAdapter) t).openLoadAnimation(BaseQuickAdapter.ALPHAIN);
            ((BaseQuickAdapter) t).isFirstOnly(false);
            ((BaseQuickAdapter) t).setLoadMoreView(new CustomLoadMoreView());
            //默认第一次加载会进入回调，如果不需要可以配置
            ((BaseQuickAdapter) t).disableLoadMoreIfNotFullPage();
        }
        return t;
    }

    public View getFootView(@Nullable ViewGroup root) {
        return getLayoutInflater().inflate(R.layout.item_no_data, root, false);
    }

    public boolean checkHttpCode(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            int code = jsonObject.getInt("code");
            if (code == 200) {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getHttpMsg(String response) {
        if (!AppUtils.checkId(response)) {
            return "";
        }
        String msg = "";
        try {
            msg = new JSONObject(response).getString("msg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return msg;
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

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (Util.isOnMainThread() && !this.isFinishing()) {
//            Glide.with(this).pauseRequests();
//        }
//    }
}
