package com.hmkj.taozhifu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.fragment.TaoDFragment;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/29.
 */

public class TDTicketActivity extends BaseActivity {
    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    String[] strings = CommonUtil.getStringArray(R.array.tao_dian);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        LogUtil.LogLong("获取到的类型", this.getIntent().getStringExtra("type"));
        if (TextUtils.isEmpty(this.getIntent().getStringExtra("type"))) {
            return;
        }
        if (this.getIntent().getStringExtra("type").equals("1")) {//现金
            topTitle.setText(R.string.cash_s);
        }
        if (this.getIntent().getStringExtra("type").equals("2")) {//抵用券
            topTitle.setText(R.string.voucher_s);
        }
        if (this.getIntent().getStringExtra("type").equals("3")) {//商超卷
            topTitle.setText(R.string.shop_ticket_s);
        }
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        for (String string : strings) {
            TaoDFragment fragment = TaoDFragment.newInstance();//牛逼用一个fragment管理,根据标识请求对应数据
            fragment.setTitle(string);//根据标题判断是哪个fragment
            Bundle bundle = new Bundle();//根据bundle数据判断是哪一个类型
            bundle.putString("type", this.getIntent().getStringExtra("type"));
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab.setupWithViewPager(viewPager);

    }

    @Override
    public void initData() {


    }

    @OnClick(R.id.top_btn_left)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            default:
                break;
        }
    }
}
