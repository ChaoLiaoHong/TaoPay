package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.fragment.MyOrderFragment;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.view.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
//    @BindView(R.id.fab)
//    FloatingActionButton fab;
    String[] strings = CommonUtil.getStringArray(R.array.order_title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    @Override
    public void initView() {
        initToolbar();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        for (String string : strings) {
            MyOrderFragment fragment = MyOrderFragment.newInstance();
            fragment.setTitle(string);
            fragments.add(fragment);

        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab.setupWithViewPager(viewPager);
    }

    private void initToolbar() {
        initToolBar(toolbar, true, true, "我的订单", Color.BLACK, R.drawable.ic_arrow_back_dark_24dp);
        appbar.setBackgroundColor(Color.WHITE);
        toolbar.setBackgroundColor(Color.WHITE);
        tab.setBackgroundColor(Color.WHITE);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, appbar);
    }

    @Override
    public void initData() {

    }

//    @OnClick(R.id.fab)
//    public void fab(View view) {
//        SnackBarUtil.showLongSnackbar(tab, "点我试试", Color.WHITE, Color.BLACK, "跳网页", Color.WHITE, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WebActivity.runActivity(MyOrderActivity.this, "ithub", "http://www.github.com/");
//            }
//        });
//    }
}
