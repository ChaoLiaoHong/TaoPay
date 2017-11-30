package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.dialog.DialogPlayPhone;
import com.hmkj.taozhifu.utils.DataCleanManager;
import com.hmkj.taozhifu.utils.GetFileSizeUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.utils.VersionUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/1.
 * @author
 */

public class SettingActivity extends BaseActivity {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.versin_update)
    LinearLayout versinUpdate;
    @BindView(R.id.contact_our)
    LinearLayout contactOur;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.cacheSize)
    TextView cacheSize;
    @BindView(R.id.clearCache_ly)
    LinearLayout clearCacheLy;
    @BindView(R.id.about_our)
    TextView aboutOur;
    @BindView(R.id.mExit)
    Button mExit;
    @BindView(R.id.versionCode)
    TextView versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        PackageManager pm = SettingActivity.this.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = pm.getPackageInfo(this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //版本标识
        String versionName = packageInfo.versionName;
        versionCode.setText("V " + versionName);
    }

    @Override
    public void initData() {
        //缓存
        try {
            LogUtil.LogLong("缓存大小", DataCleanManager.getTotalCacheSize(this));
            cacheSize.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText(R.string.settings);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @Override
    public void initView() {
        initToolbar();
        tvPhone.setText(R.string.connect_us);
    }

    @OnClick({R.id.versin_update, R.id.contact_our, R.id.clearCache_ly, R.id.about_our, R.id.mExit})
    public void onClick(View view) {
        switch (view.getId()) {
            //版本更新
            case R.id.versin_update:
                VersionUtils.judgeVersion(this);
                break;
            //联系我们
            case R.id.contact_our:
                new DialogPlayPhone(SettingActivity.this, tvPhone.getText().toString());
                break;
            //清楚缓存
            case R.id.clearCache_ly:
                DataCleanManager.clearAllCache(SettingActivity.this);
                System.gc();
                ToastUtil.showToast("清理成功");
                try {
                    LogUtil.LogLong("hc", GetFileSizeUtil.getInstance().FormetFileSize(DataCleanManager.getFolderSize(new File(String.valueOf(getCacheDir())))));
                    cacheSize.setText(DataCleanManager.getTotalCacheSize(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            //关于我们
            case R.id.about_our:
                startActivity(new Intent(SettingActivity.this, AboutOurActivity.class));
                break;
            //退出登录
            case R.id.mExit:
                SharedPreferencesUtil.clear(this);
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                EventBus.getDefault().post(new EventBusEntity(2));
                finish();
                break;
            default:
                break;
        }
    }
}
