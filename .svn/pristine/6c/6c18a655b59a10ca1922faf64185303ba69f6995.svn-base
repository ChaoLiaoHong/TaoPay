package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MyFragmentPagerAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.dialog.DialogPlayRemind;
import com.hmkj.taozhifu.fragment.MyWalletFragment;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.APpresenter;
import com.hmkj.taozhifu.mpresenter.LoginPresenter;
import com.hmkj.taozhifu.mview.AmoyPointView;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyWalletActivity extends BaseActivity implements AmoyPointView {

    @BindView(R.id.tv_withdraw_deposit)
    TextView tvWithdrawDeposit;
    @BindView(R.id.tv_my_money)
    TextView tvMyMoney;
    @BindView(R.id.fl_bg)
    LinearLayout flBg;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    String[] strings = CommonUtil.getStringArray(R.array.my_wallet);
    private APpresenter aPpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        aPpresenter = new APpresenter(this, this);
        aPpresenter.queryAP();//获取淘点信息
}

    @Override
    public void initView() {
        initToolbar();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        for (String string : strings) {
            MyWalletFragment fragment = MyWalletFragment.newInstance();
            fragment.setTitle(string);
            fragments.add(fragment);
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab.setupWithViewPager(viewPager);
    }

    private void initToolbar() {
        toolbar.setBackgroundDrawable(CommonUtil.getDrawable(R.drawable.gradual_change));
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_light_24dp);
        toolbarTitle.setTextColor(Color.WHITE);
        toolbarTitle.setText("我的钱包");
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick(R.id.tv_withdraw_deposit)
    public void onViewClicked(View view) {
        if (!LoginPresenter.checkLogin(this)) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return;
        }
        switch (view.getId()) {
            case R.id.tv_withdraw_deposit:
                playRemind();
                break;
        }
    }

    //判断是否实名认证了
    private void playRemind() {
        String name = (String) SharedPreferencesUtil.get(MyWalletActivity.this, "realName", "");
        if (TextUtils.isEmpty(name)) {
            String content = "您还未实名认证，是否认证";
            DialogPlayRemind.getInstance(this, content).setOnClickListener(new DialogPlayRemind.OnClickListener() {
                @Override
                public void onSendListener() {
                    Intent intent = new Intent(MyWalletActivity.this, AutonymActivity.class);
                    startActivityForResult(intent, HttpConfig.REQUEST_CODE_MY);
                }
            });
        } else {
            startActivity(new Intent(this, WithdrawDepositActivity.class));
        }
    }


    @Override
    public void queryAPSuccess(int dot, int integral, double cashCoupon, double businessCoupon, double amount, int level, double goodsMoney,int mlevel) {
        tvMyMoney.setText(String.valueOf(CommonUtil.Double2position(amount + goodsMoney)));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case 4:
                aPpresenter.queryAP();//获取淘点信息
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
