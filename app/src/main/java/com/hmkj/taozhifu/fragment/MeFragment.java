package com.hmkj.taozhifu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.CollectionActivity;
import com.hmkj.taozhifu.activity.LoginActivity;
import com.hmkj.taozhifu.activity.MyOrderActivity;
import com.hmkj.taozhifu.activity.MyStoreActivity;
import com.hmkj.taozhifu.activity.MyWalletActivity;
import com.hmkj.taozhifu.activity.PersonInfoActivity;
import com.hmkj.taozhifu.activity.SettingActivity;
import com.hmkj.taozhifu.activity.ShareZXcodeActivity;
import com.hmkj.taozhifu.activity.TDTicketActivity;
import com.hmkj.taozhifu.adapter.MyAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.bean.myEntity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.APpresenter;
import com.hmkj.taozhifu.mpresenter.LoginPresenter;
import com.hmkj.taozhifu.mpresenter.QueryUPresenter;
import com.hmkj.taozhifu.mview.AmoyPointView;
import com.hmkj.taozhifu.mview.QueryView;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.StringUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.utils.webviewUtils.WebviewVideoActivity;
import com.hmkj.taozhifu.view.ProtocolDialog;
import com.hmkj.taozhifu.view.SwipeRefreshView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MeFragment extends BaseFragment implements QueryView, AmoyPointView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mClick_Upgrade)
    TextView mClickUpgrade;
    @BindView(R.id.mHead)
    ImageView mHead;
    @BindView(R.id.mInvite)
    TextView mInvite;
    @BindView(R.id.mPhone)
    TextView mPhone;
    @BindView(R.id.mVoucher)
    TextView mVoucher;
    @BindView(R.id.shopVoucher)
    TextView shopVoucher;
    @BindView(R.id.mCash)
    TextView mCash;
    @BindView(R.id.mContent_RC)
    RecyclerView mContentRC;
    @BindView(R.id.my_recommend)
    TextView myRecommend;
    @BindView(R.id.mVoucher_ly)
    LinearLayout mVoucher_ly;
    @BindView(R.id.mShopTicket_ly)
    LinearLayout mShopTicket_ly;
    @BindView(R.id.mCash_ly)
    LinearLayout mCash_ly;
    @BindView(R.id.mRefresh)
    SwipeRefreshView mRefresh;
    @BindView(R.id.vip_Grade)
    TextView vip_Grade;


    MyAdapter adapter;
    private List<myEntity> data = new ArrayList<>();
    int[] ImageId = {R.drawable.ico_order_me, R.drawable.ico_wallet_me,
            R.drawable.ico_train_me, R.drawable.ico_favorite_me, R.drawable.ico_store_me
    };
    /**
     */
    int[] StringId = {R.string.myOrder, R.string.myWallet,
            R.string.myTrain, R.string.myCollect, R.string.myStore};
    /**
     * 收货地址
     */
    QueryUPresenter queryUPresenter;
    APpresenter aPpresenter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {//→顶部换成ToolBar比较合理  放不进来！ 后期优化
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        queryUPresenter = new QueryUPresenter(getActivity(), this);
        aPpresenter = new APpresenter(getActivity(), this);
        initViews();
        return view;
    }

    private void initViews() {
        initToolBar(true);
        mRefresh.setOnRefreshListener(this);
        toolbarTitle.setText("我的");
        mContentRC.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyAdapter(getActivity(), data);
        mContentRC.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (!LoginPresenter.checkLogin(context) && position != 2) {
                    mPhone.setText("点击登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    return;
                }
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), MyOrderActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), MyWalletActivity.class));
                        break;
                    case 2:
//                        WebActivity.runActivity(getActivity(), "在线培训", HttpConfig.classroom);
                        Intent intent = new Intent(getActivity(), WebviewVideoActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), CollectionActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), MyStoreActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void refreshOnVisible() {
        initToolBar(false);
        queryUPresenter.queryUserInfo();//获取用户信息→这里不想一进来就加载切换到fragment的时候加载较合理
    }

    //懒加载 如果不要的话初始化内容放到initView即可
    @Override
    protected void initData() {
        for (int i = 0; i < ImageId.length; i++) {
            data.add(new myEntity(ImageId[i], StringId[i]));
        }
        adapter.notifyDataSetChanged();
        toolbar.setNavigationIcon(R.drawable.ico_setting_me_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LoginPresenter.checkLogin(context)) {//未登录
                    mPhone.setText("点击登录");
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    return;
                }
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
    }


    private void initToolBar(boolean b) {
        StatusBarUtil.darkMode(activity, false);
        if (b) {
            StatusBarUtil.setPaddingSmart(activity, toolbar);
            StatusBarUtil.immersive(activity);
        }
    }


    @OnClick({R.id.toolbar_title, R.id.mInvite, R.id.mHead, R.id.mVoucher_ly, R.id.mShopTicket_ly, R.id.mCash_ly, R.id.mClick_Upgrade})
    public void onViewClicked(View view) {
        if (!LoginPresenter.checkLogin(context)) {
            mPhone.setText("点击登录");
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
            return;
        }
        Intent intent_Common = new Intent(getActivity(), TDTicketActivity.class);
        switch (view.getId()) {
            case R.id.mClick_Upgrade:
                new ProtocolDialog(getContext(), CommonUtil.getString(R.string.vip_role), CommonUtil.getString(R.string.vip_protocol));
                break;
            case R.id.mVoucher_ly://抵用券
                intent_Common.putExtra("type", "2");
                startActivity(intent_Common);
                break;
            case R.id.mShopTicket_ly://商超卷
                intent_Common.putExtra("type", "3");
                startActivity(intent_Common);
                break;
            case R.id.mCash_ly://现金
                intent_Common.putExtra("type", "1");
                startActivity(intent_Common);
                break;
            case R.id.toolbar_title://第二个版本完善消息
//                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.mInvite:
                Intent intent = new Intent(getActivity(), ShareZXcodeActivity.class);
                intent.putExtra("ZX_code", myRecommend.getText());
                intent.putExtra("url", HttpConfig.shareURL + getMemberId() + "&code=" + myRecommend.getText());
                intent.putExtra("bgColor", 1);
                startActivity(intent);
                break;
            case R.id.mHead:
                startActivity(new Intent(getActivity(), PersonInfoActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate CheckPay fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void queryUserSuccess(String headUrl, String my_recommend, String phone, int level) {
        aPpresenter.queryAP();//获取淘点一级界面信息
        if (!TextUtils.isEmpty(headUrl) && !TextUtils.equals(headUrl, "")) {
            GlideUtils.loadImage(context, headUrl, mHead);
        }
        if (!TextUtils.isEmpty(my_recommend)) {
            myRecommend.setText(my_recommend);
        }
        //1普通2创客
        if (level == 1) {
            vip_Grade.setText("普通");
        } else if (level == 2) {
            vip_Grade.setText("创客");
        }
        myRecommend.setText(my_recommend);
        mPhone.setText(StringUtil.getUserPhone(phone));
    }


    @Override
    public void queryUserInfoSuccess(String headUrl, int sex, String realName) {//这里是个人信息的不用管
        if (mRefresh.isRefreshing()) {
            mRefresh.setRefreshing(false);
        }
    }

    @Override
    public void queryAPSuccess(int dot, int integral, double cashCoupon, double businessCoupon, double amount, int level, double goodsMoney, int memLevel) {
        if (mRefresh.isRefreshing()) {
        }
        mVoucher.setText(String.valueOf(CommonUtil.Double2position(cashCoupon)));
        shopVoucher.setText(String.valueOf(CommonUtil.Double2position(businessCoupon)));
        mCash.setText(String.valueOf(CommonUtil.Double2position(amount + goodsMoney)));
        if (vip_Grade.getText().equals("普通")) {
        } else {
            if (level > 0) {
                vip_Grade.setText("创客V" + level);
            }
        }
    }

    @Override
    public void onRefresh() {
        if (LoginPresenter.checkLogin(context)) {//登录
            queryUPresenter.queryUserInfo();//获取用户信息→这里不想一进来就加载切换到fragment的时候加载较合理
        } else {//未登录设置→不能刷新
            mRefresh.setRefreshing(false);
            ToastUtil.showToast("请先登录!");
        }
    }

    static class ViewHolder {
        @BindView(R.id.mImage)
        ImageView mImage;
        @BindView(R.id.mTitle)
        TextView mTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case 2://退出登录→发送的广播为2
                mHead.setImageDrawable(CommonUtil.getDrawable(R.drawable.img_head_default));
                mPhone.setText("点击登录");
                mVoucher.setText(0 + "");
                shopVoucher.setText(0 + "");
                mCash.setText(0 + "");
                break;
            case CommonStatu.OK:
            case 101://登录刷新
            case 4://提现刷新
                queryUPresenter.queryUserInfo();//获取用户信息
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
