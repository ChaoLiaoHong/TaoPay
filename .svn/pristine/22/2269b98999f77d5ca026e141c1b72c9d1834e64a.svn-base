package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.fragment.MyStoreExchangeOrderFragment;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyStoreExchangeOrderActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    String[] strings = CommonUtil.getStringArray(R.array.exchange_order);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_exchange_order);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolbar();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        for (String string : strings) {
            MyStoreExchangeOrderFragment fragment = MyStoreExchangeOrderFragment.newInstance();
            fragment.setTitle(string);
            fragments.add(fragment);
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab.setupWithViewPager(viewPager);
        if (getIntent().getIntExtra("page", 0) != 0) {
            viewPager.setCurrentItem(getIntent().getIntExtra("page", 0));
        }
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("兑换订单");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }
}
