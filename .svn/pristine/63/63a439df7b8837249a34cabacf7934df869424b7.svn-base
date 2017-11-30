package com.hmkj.taozhifu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.base.BaseFragmentActivity;
import com.hmkj.taozhifu.fragment.AmoyPointFragment;
import com.hmkj.taozhifu.fragment.HomeFragment;
import com.hmkj.taozhifu.fragment.MeFragment;
import com.hmkj.taozhifu.fragment.ShopFragment;
import com.hmkj.taozhifu.myListener.LocationService;
import com.hmkj.taozhifu.myListener.MyLocationListener;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.view.ButtomNavigationViewHelper;
import com.hmkj.taozhifu.view.NoScrollViewPager;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseFragmentActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.vp_home)
    NoScrollViewPager vpHome;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//禁止横屏
        MobclickAgent.enableEncrypt(true); //友盟统计日志加密→防止网络攻击，提高数据安全性
        MobclickAgent.setDebugMode(true);//友盟调试模式开关
        MobclickAgent.setScenarioType(mContext, MobclickAgent.EScenarioType.E_UM_NORMAL);// 设置统计场景类型为普通统计
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setNavigationViewColor();
        ButtomNavigationViewHelper.disableShiftMode(navigation);//去除有4个的别扭动画
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_home);
        //初始化vpHome
        initViewPager();
        //权限申请
//        getReadPhoneState();
        getPersimmions();
        setUpLocation();
    }

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    private void setUpLocation() {
        //权限申请
        getPersimmions();
        //声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.setLocOption(new LocationService(this).getDefaultLocationClientOption());
        //注册监听函数
        mLocationClient.registerLocationListener(myListener);
        //开始定位
        mLocationClient.start();
    }

    private void setNavigationViewColor() {
//        int[][] states = new int[][]{
//                new int[]{-android.R.attr.state_checked},
//                new int[]{android.R.attr.state_checked}
//        };
//        int[] colors = new int[]{
//                getResources().getColor(R.color.j_a9a9a9),
//                getResources().getColor(R.color.colorAccent)
//        };
//        ColorStateList csl = new ColorStateList(states, colors);
        ColorStateList csl = getResources().getColorStateList(R.color.navigation_menu_item_color);
        ColorStateList csl1 = getResources().getColorStateList(R.color.navigation_menu_item_img_color);
        navigation.setItemTextColor(csl);
        navigation.setItemIconTintList(csl1);
        /**设置MenuItem默认选中项**/
        navigation.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        long memberId = (long) SharedPreferencesUtil.get(MainActivity.this, "memberId", (long) 0);
        switch (item.getItemId()) {
            case R.id.navigation_home:
                vpHome.setCurrentItem(0);
                break;
            case R.id.navigation_shop:
                vpHome.setCurrentItem(1);
                break;
            case R.id.navigation_circle:
                if (memberId != (long) 0) {//没有要用户id默认为0
                    vpHome.setCurrentItem(2);
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
            case R.id.navigation_me:
                if (memberId != (long) 0) {//没有要用户id默认为0
                    vpHome.setCurrentItem(3);
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
                break;
            default:
                break;
        }
        return true;
    }

    private ArrayList<BaseFragment> fragmentList;

    private void initViewPager() {
        HomeFragment homeFragment = new HomeFragment();
        ShopFragment contactsFragment = new ShopFragment();
        AmoyPointFragment amoyPointFragment = new AmoyPointFragment();
        MeFragment meFragment = new MeFragment();
        fragmentList = new ArrayList<>();
        fragmentList.add(homeFragment);
        fragmentList.add(contactsFragment);
        fragmentList.add(amoyPointFragment);
        fragmentList.add(meFragment);
        //vpHome设置适配器
        vpHome.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));

        vpHome.setOffscreenPageLimit(fragmentList.size());
        //vpHome显示第一个Fragment
        vpHome.setCurrentItem(0);
        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (navigation != null)
                {
                    navigation.getMenu().getItem(position).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        super.onDestroy();
    }

    public void clickClassify() {
        vpHome.setCurrentItem(1);
    }
}
