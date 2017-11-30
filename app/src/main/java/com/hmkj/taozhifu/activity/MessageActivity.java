package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.fragment.MessageFragment;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MessageActivity extends BaseActivity {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    String[] strings = CommonUtil.getStringArray(R.array.my_message);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
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
            MessageFragment fragment = MessageFragment.newInstance();//牛逼用一个fragment管理,根据标识请求对应数据
            fragment.setTitle(string);//根据标题判断是哪个fragment
            fragments.add(fragment);
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab.setupWithViewPager(viewPager);
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("消息");
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.tab, R.id.view_pager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab:
                break;
            case R.id.view_pager:
                break;
        }
    }
}
