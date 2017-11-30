package com.hmkj.taozhifu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.CommodityDetailedInformationActivity;
import com.hmkj.taozhifu.activity.NoticeDetailsActivity;
import com.hmkj.taozhifu.activity.NoticeListActivity;
import com.hmkj.taozhifu.activity.SearchShoppingActivity;
import com.hmkj.taozhifu.activity.ShopDetailedInformationActivity;
import com.hmkj.taozhifu.activity.ShopListActivity;
import com.hmkj.taozhifu.activity.WebActivity;
import com.hmkj.taozhifu.adapter.HomeGridViewAdapter;
import com.hmkj.taozhifu.adapter.ProCommodityAdapter;
import com.hmkj.taozhifu.adapter.ShopListAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.bean.HomeFragmenBannerBean;
import com.hmkj.taozhifu.bean.HomeFragmentButtonBean;
import com.hmkj.taozhifu.bean.HomeNoticeEntity;
import com.hmkj.taozhifu.bean.QueryProCommodityBean;
import com.hmkj.taozhifu.bean.ShopListEntity;
import com.hmkj.taozhifu.holder.BannerHolder;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.ui.SpacesItemDecoration;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.NoScrollGridView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.hmkj.taozhifu.view.UpDownTextView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/8/16.
 */

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R.id.ll_home_title)
    LinearLayout llHomeTitle;
    @BindView(R.id.scroll_view)
    NestedScrollView scrollView;
    @BindView(R.id.category)
    NoScrollGridView category;
    HomeGridViewAdapter homeGridViewAdapter;
    @BindView(R.id.rv_recommended_products)
    RecyclerView rvRecommendedProducts;
    @BindView(R.id.refresh)
    SwipeRefreshView refresh;
    @BindView(R.id.tv_notice)
    UpDownTextView tvNotice;
    @BindView(R.id.fragment_home_title_search)
    TextView fragment_home_title_search;
    @BindView(R.id.tv_notice_more)
    TextView tvNoticeMore;
    @BindView(R.id.rv_nearby_merchants)
    RecyclerView rvNearbyMerchants;
    @BindView(R.id.tv_title_address)
    TextView tvTitleAddress;
    @BindView(R.id.iv_notice)
    ImageView ivNotice;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.ll_notice)
    RelativeLayout llNotice;
    @BindView(R.id.tv_more_store)
    TextView tvMoreStore;
    @BindView(R.id.ll_recommended_products)
    LinearLayout llRecommendedProducts;
    @BindView(R.id.ll_nearby_merchants)
    LinearLayout llNearbyMerchants;
    Unbinder unbinder;
    private HomeNoticeEntity homeNoticeEntity;
    private List<HomeNoticeEntity.DataBean.RecordsBean> listNotice = new ArrayList<>();
    private HomeFragmentButtonBean homeFragmentButtonBean;
    private List<HomeFragmentButtonBean.DataBean> categoryData = new ArrayList<>();
    private List<QueryProCommodityBean.ProCommodityPageBean.RecordsBean> recordsBean = new ArrayList<>();
    private List<ShopListEntity.DataBean.ContentsBean> nearbyMerchants = new ArrayList<>();
    private ArrayList<String> bannerImgList;
    private HomeFragmenBannerBean homeFragmenBannerBean;
    private QueryProCommodityBean queryProCommodityBean;
    private ProCommodityAdapter proCommodityAdapter;
    private ShopListEntity shopListEntity;
    private ShopListAdapter shopListAdapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initViews();
        return view;
    }

    private void initViews() {
        initConvenientBanner();
        refresh.setOnRefreshListener(this);
        homeGridViewAdapter = new HomeGridViewAdapter(context, categoryData);
        category.setAdapter(homeGridViewAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvRecommendedProducts.addItemDecoration(new SpacesItemDecoration(CommonUtil.dp2px(context, 10), 2));
        rvRecommendedProducts.setLayoutManager(layoutManager);
        proCommodityAdapter = new ProCommodityAdapter(recordsBean, context);
        proCommodityAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(context, CommodityDetailedInformationActivity.class);
                intent.putExtra("commodityId", recordsBean.get(position).commodityId);
                startActivity(intent);
            }
        });
        rvRecommendedProducts.setAdapter(proCommodityAdapter);
        //附近商家
        rvNearbyMerchants.setLayoutManager(new LinearLayoutManager(context));
        shopListAdapter = new ShopListAdapter(context, nearbyMerchants);
        shopListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.LogLong("shopId", nearbyMerchants.get(position).getShopId() + "");
                Intent intent = new Intent(context, ShopDetailedInformationActivity.class);
                intent.putExtra("title", nearbyMerchants.get(position).getShopName());
                intent.putExtra("shopId", nearbyMerchants.get(position).getShopId());
                startActivity(intent);
            }
        });
        rvNearbyMerchants.setAdapter(shopListAdapter);
    }

    private void initConvenientBanner() {
        convenientBanner.getLayoutParams().height = Math.round(AppUtils.getScreenHW(activity)[0] / 2.5f);
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner
                .startTurning(4000)//自动轮播
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.convenitent_banner_check, R.drawable.convenitent_banner_uncheck})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        bannerClick(position);
                    }
                })
        ;
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer); //集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
        //convenientBanner.setManualPageable(false);//设置不能手动影响
    }

    private void bannerClick(int position) {
        for (HomeFragmenBannerBean.DataBean dataBean : homeFragmenBannerBean.data) {
            if (TextUtils.equals(dataBean.adverUrl, bannerImgList.get(position))) {
                //1.商品连接2.网址连接
                switch (dataBean.contentType) {
                    case 1:
                        Intent intent1 = new Intent(context, CommodityDetailedInformationActivity.class);
                        intent1.putExtra("commodityId", dataBean.proAdverId);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, WebActivity.class);
                        intent2.putExtra(WebActivity.URL, dataBean.adverKeyId);
                        startActivity(intent2);
                        break;
                        default:
                            break;
                }
            }
        }
    }

    @Override
    protected void refreshOnVisible() {
        StatusBarUtil.darkMode(activity, false);
    }

    @Override
    protected void initData() {
        initToolBar();
        initDatas();
    }

    private void initToolBar() {
        StatusBarUtil.setPaddingSmart(activity, llHomeTitle);
        StatusBarUtil.immersive(activity);
    }

    private void initDatas() {
        if (AppUtils.checkId((String) SharedPreferencesUtil.get(context, "location_name", "")))
        {
            tvTitleAddress.setText((String) SharedPreferencesUtil.get(context, "location_name", ""));
        }
        //轮播图
        getAdver();
        //公告数据
        querySysNotice();
        //按钮
        indexButton();
        //推荐商品
        queryProCommodity();
        //附近商家
        if (AppUtils.checkId((String) SharedPreferencesUtil.get(context, "longitude", "")))
            getShopPoiGeoSearchByNear();
    }

    private void getAdver() {
        OkGo.<String>post(HttpConfig.getAdver)
                .params("keyWord", "Banner")
                .execute(new CustomCallback(context) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()) refresh.setRefreshing(false);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("首页轮播 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            homeFragmenBannerBean = GsonUtil.GsonToBean(response.body(), HomeFragmenBannerBean.class);
                            bannerImgList = new ArrayList<>();
                            if (homeFragmenBannerBean != null && homeFragmenBannerBean.data.size() > 0) {
                                bannerImgList.clear();
                                for (HomeFragmenBannerBean.DataBean dataBean : homeFragmenBannerBean.data) {
                                    bannerImgList.add(dataBean.adverUrl);
                                }
                                convenientBanner.setPages(new CBViewHolderCreator<BannerHolder>() {
                                    @Override
                                    public BannerHolder createHolder() {
                                        return new BannerHolder();
                                    }
                                }, bannerImgList);
                            }
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    private void querySysNotice() {
        OkGo.<String>post(HttpConfig.querySysNotice)
                .params("page", String.valueOf(1))
                .params("size", String.valueOf(5))
                .params("type", String.valueOf(1))
                .execute(new CustomCallback(context) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()) refresh.setRefreshing(false);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("首页公告", response.body());
                        if (checkHttpCode(response.body())) {
                            homeNoticeEntity = GsonUtil.GsonToBean(response.body(), HomeNoticeEntity.class);
                            //公告头条
                            listNotice.clear();
                            listNotice.addAll(homeNoticeEntity.getData().getRecords());
                            mHandler.sendEmptyMessage(1);
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    private void indexButton() {
        OkGo.<String>get(HttpConfig.indexButton)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()){
                            refresh.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("首页按钮 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            homeFragmentButtonBean = GsonUtil.GsonToBean(response.body(), HomeFragmentButtonBean.class);
                            if (homeFragmentButtonBean != null && homeFragmentButtonBean.data.size() > 0) {
                                categoryData.clear();
                                categoryData.addAll(homeFragmentButtonBean.data);
                                homeGridViewAdapter.notifyDataSetChanged();
                            }
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    //滚动头条开始
    private int TIME = 3000; //没执行一次所需要的时间
    private int index = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    //index是全局的，判断小于list长度，防止数组越界异常
                    if (listNotice.size() == 1) {
                        index = 0;
                        tvNotice.setText(listNotice.get(index).getNoticeName());
                    } else if (index < listNotice.size()) {
                        index++;
                        if (index == listNotice.size()) {
                            index = 0;
                        }
                        tvNotice.setText(listNotice.get(index).getNoticeName());
                        //自己调自己
                        mHandler.sendEmptyMessageDelayed(1, TIME);
                    } else if (listNotice.size() == 0) {
                        tvNotice.setText("暂无公告");
                    }
                    break;
                default:
                    break;
            }

        }
    };

    private void queryProCommodity() {
        OkGo.<String>get(HttpConfig.queryProCommodity)
                .params("pageNum", 1)
                .params("pageSize", 10)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()){
                            refresh.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("推荐商品 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            queryProCommodityBean = GsonUtil.GsonToBean(response.body(), QueryProCommodityBean.class);
                            if (queryProCommodityBean != null && queryProCommodityBean.proCommodityPage != null && queryProCommodityBean.proCommodityPage.records != null && queryProCommodityBean.proCommodityPage.records.size() > 0) {
                                llRecommendedProducts.setVisibility(View.VISIBLE);
                                recordsBean.clear();
                                recordsBean.addAll(queryProCommodityBean.proCommodityPage.records);
                                proCommodityAdapter.notifyDataSetChanged();
                            } else {
                                llRecommendedProducts.setVisibility(View.GONE);
                            }
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                            llRecommendedProducts.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void getShopPoiGeoSearchByNear() {
        double longitude = Double.parseDouble((String) SharedPreferencesUtil.get(getActivity(), "longitude", "104.046667"));
        double latitude = Double.parseDouble((String) SharedPreferencesUtil.get(getActivity(), "latitude", "30.691953"));
        if (longitude == 4.9E-324) {
            longitude = 104.046667;
        }
        if (latitude == 4.9E-324) {
            latitude = 30.691953;
        }
        LogUtil.LogLong("定位", longitude + "");
        OkGo.<String>post(HttpConfig.getShopPoiGeoSearchByNear)
                .params("longitude", longitude)
                .params("latitude", latitude)
                .params("radius", 100000)
                .params("pageSize", 100)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        if (refresh.isRefreshing()) refresh.setRefreshing(false);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("附近商家 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            shopListEntity = GsonUtil.GsonToBean(response.body(), ShopListEntity.class);
                            if (shopListEntity != null && shopListEntity.getData() != null && shopListEntity.getData().getContents() != null && shopListEntity.getData().getContents().size() > 0) {
                                llNearbyMerchants.setVisibility(View.VISIBLE);
                                nearbyMerchants.clear();
                                nearbyMerchants.addAll(shopListEntity.getData().getContents());
                                shopListAdapter.notifyDataSetChanged();
                            } else {
                                llNearbyMerchants.setVisibility(View.GONE);
                            }
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                            llNearbyMerchants.setVisibility(View.GONE);
                        }
                    }
                });
    }

    //滚动头条结束
    @Override
    public void onRefresh() {
        initDatas();
    }

    @OnClick({R.id.tv_more_store, R.id.fragment_home_title_search, R.id.tv_notice_more, R.id.tv_notice, R.id.tv_title_address, R.id.iv_notice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_home_title_search:
                startActivity(new Intent(getActivity(), SearchShoppingActivity.class));
                break;
            case R.id.tv_notice_more:
                startActivity(new Intent(getActivity(), NoticeListActivity.class));
                break;
            case R.id.tv_notice:
                if (homeNoticeEntity != null && listNotice.size() != 0) {
                    Intent intent = new Intent(getActivity(), NoticeDetailsActivity.class);
                    intent.putExtra("NOTICE", listNotice.get(index));
                    startActivity(intent);
                }
                break;
            case R.id.tv_title_address:
//                startActivity(new Intent(activity, MyStoreApplyActivity.class));
//                startActivity(new Intent(activity, TestExamineAndVerifyActivity.class));
                break;
            case R.id.tv_more_store:
                Intent intent = new Intent(context, ShopListActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    //接收到定位成功的广播
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
        switch (event.getMsg()) {
            case 10:
                if (AppUtils.checkId((String) SharedPreferencesUtil.get(context, "location_name", ""))) {
                    tvTitleAddress.setText((String) SharedPreferencesUtil.get(context, "location_name", ""));
                }
                if (AppUtils.checkId((String) SharedPreferencesUtil.get(context, "longitude", ""))) {
                    getShopPoiGeoSearchByNear();
                }
                break;
            default:
                break;
        }
    }
}
