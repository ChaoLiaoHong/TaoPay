package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ShopCommentAdapter;
import com.hmkj.taozhifu.adapter.ShopCommodityAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShopCommentEntity;
import com.hmkj.taozhifu.bean.ShopCommodityEntity;
import com.hmkj.taozhifu.bean.ShopDetailedEntity;
import com.hmkj.taozhifu.dialog.DialogPlayPhone;
import com.hmkj.taozhifu.holder.BannerHolder;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.BaiduUtil;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hmkj.taozhifu.http.HttpConfig.getShopDetailByShopId;

public class ShopDetailedInformationActivity extends BaseActivity {

    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R.id.tv_commodity_title)
    TextView tvCommodityTitle;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    @BindView(R.id.rb_person)
    RatingBar rbPerson;
    @BindView(R.id.tv_money_person)
    TextView tvMoneyPerson;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.tv_shop_notice)
    TextView tvShopNotice;
    @BindView(R.id.rv_commodity_introduce)
    RecyclerView rvCommodityIntroduce;
    @BindView(R.id.tv_do_business_data)
    TextView tvDoBusinessData;
    @BindView(R.id.tv_master_rule)
    TextView tvMasterRule;
    @BindView(R.id.rb)
    RatingBar rb;
    @BindView(R.id.tv_assess)
    TextView tvAssess;
    @BindView(R.id.tv_num_assess)
    TextView tvNumAssess;
    @BindView(R.id.rv_assess)
    RecyclerView rvAssess;
    @BindView(R.id.tv_show_all_assess)
    TextView tvShowAllAssess;
    @BindView(R.id.tv_immediately_sale)
    TextView tvImmediatelySale;
    @BindView(R.id.ll_hot_commodity)
    RelativeLayout ll_hot_commodity;
    @BindView(R.id.ll_assess)
    LinearLayout llAssess;
    private Intent intent;
    private ShopDetailedEntity shopDetailedEntity;
    private ArrayList<String> dataImg = new ArrayList<>();
    private ShopCommentAdapter mShopCommentAdapter;//店铺评论
    private List<ShopCommentEntity.DataBean.RecordsBean> mRecordsBean = new ArrayList<>();
    private ShopCommentEntity mShopCommentEntity;
    private ShopDetailedEntity.DataBean dataBean;
    private ShopCommodityEntity mShopCommodityEntity;
    private List<ShopCommodityEntity.ProCommodityPageBean.RecordsBean> listBeen = new ArrayList<>();
    private ShopCommodityAdapter mShopCommodityAdapter;
    private int flag = 0;
    private int pageNum = 1;
    private BaiduUtil baiduUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detailed_information);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        mShopCommodityAdapter.setOnItemClick(new ShopCommodityAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position, ShopCommodityEntity.ProCommodityPageBean.RecordsBean item) {
                Intent intent = new Intent(ShopDetailedInformationActivity.this, CommodityDetailedInformationActivity.class);
                intent.putExtra("title", item.commodityName);
                intent.putExtra("commodityId", item.commodityId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        loadData();
        loadContent();
        getCollectionState();
        shopCommodity();
    }

    /**
     * 会员查询店铺积分让利倍数
     */
    private void initDiscount() {
        if (getMemberId() == 0l) {
            if (dataBean.getShopDiscount() == 100) {
                tvIntegral.setVisibility(View.GONE);
                tvIntegral.setText("目前没有赠送");
            } else {
                tvIntegral.setVisibility(View.VISIBLE);
                int presents = (100 - dataBean.getShopDiscount()) * dataBean.getRebateIntegralMember();
                tvIntegral.setText("消费100元赠送" + presents + "积分");
            }
        } else {
            OkGo.<String>get(String.format(HttpConfig.getMemberRebateIntegral, getMemberId()))
                    .execute(new CustomCallback(this) {
                        @Override
                        public void onSuccess(Response<String> response) {
                            super.onSuccess(response);
                            LogUtil.LogLong("会员查询店铺积分让利倍数", response.body());
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                int code = jsonObject.getInt("code");
                                String msg = jsonObject.getString("msg");
                                if (code == 200) {
                                    int rebateIntegralMember = jsonObject.getInt("data");
                                    //赠送说明
                                    if (dataBean.getShopDiscount() == 100) {
                                        tvIntegral.setVisibility(View.GONE);
                                        tvIntegral.setText("目前没有赠送");
                                    } else {
                                        tvIntegral.setVisibility(View.VISIBLE);
                                        int presents = (100 - dataBean.getShopDiscount()) * rebateIntegralMember;
                                        tvIntegral.setText("消费100元赠送" + presents + "积分");
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
    }

    /**
     * 店铺商品查询    审核状态：1.待审核2.审核通过3.审核不通过
     * 900236357702713344
     */

    private void shopCommodity() {
        OkGo.<String>get(HttpConfig.selectByShopId + intent.getStringExtra("shopId"))
                .params("pageNum", pageNum)
                .params("pageSize", 3)
                .params("checkState", 2)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("店铺商品查询", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCommodityEntity = GsonUtil.GsonToBean(response.body(), ShopCommodityEntity.class);
                                if (mShopCommodityEntity != null && mShopCommodityEntity.proCommodityPage.records != null) {
                                    listBeen.clear();
                                    listBeen.addAll(mShopCommodityEntity.proCommodityPage.records);
                                    mShopCommodityAdapter.setNewData(listBeen);
                                    mShopCommodityAdapter.notifyDataSetChanged();
                                    if (listBeen.size() == 0) {
                                        ll_hot_commodity.setVisibility(View.GONE);
                                    } else {
                                        ll_hot_commodity.setVisibility(View.VISIBLE);
                                    }
                                    if (pageNum < mShopCommodityEntity.proCommodityPage.pages) {
                                        pageNum += 1;
                                        showMoreView();
                                    } else {
                                        mShopCommodityAdapter.removeAllFooterView();
                                    }
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //显示加载更多的布局
    private void showMoreView() {
        //显示更多按钮
        View view = LayoutInflater.from(ShopDetailedInformationActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rvCommodityIntroduce.getParent(), false);
        mShopCommodityAdapter.setFooterView(view);
        TextView tv = (TextView) view.findViewById(R.id.tv_show_more);
        View v_lian = (View) view.findViewById(R.id.v_lian);
        v_lian.setVisibility(View.VISIBLE);
        tv.setText("查看更多");
        tv.setTextColor(CommonUtil.getColor(R.color.accent));
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoadMore();
            }
        });
    }

    //店铺商品查询更多
    public void onLoadMore() {
        OkGo.<String>get(HttpConfig.selectByShopId + intent.getStringExtra("shopId"))
                .params("pageNum", pageNum)
                .params("pageSize", 3)
                .params("checkState", 2)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("店铺商品查询更多", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCommodityEntity = GsonUtil.GsonToBean(response.body(), ShopCommodityEntity.class);
                                if (mShopCommodityEntity != null && mShopCommodityEntity.proCommodityPage != null && mShopCommodityEntity.proCommodityPage.records != null) {
                                    ll_hot_commodity.setVisibility(View.VISIBLE);
                                    listBeen.addAll(mShopCommodityEntity.proCommodityPage.records);
                                    mShopCommodityAdapter.notifyDataSetChanged();
                                    if (pageNum < mShopCommodityEntity.proCommodityPage.pages) {
                                        pageNum += 1;
                                        showMoreView();
                                    } else {
                                        mShopCommodityAdapter.removeAllFooterView();
                                    }
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }

    //店铺查询
    private void loadData() {
        LogUtil.LogLong("店铺Id", intent.getStringExtra("shopId"));
        this.show();
        OkGo.<String>get(getShopDetailByShopId + intent.getStringExtra("shopId")).execute(new CustomCallback(this) {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                ShopDetailedInformationActivity.this.diss();
                LogUtil.LogLong("店铺详情", response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    int code = jsonObject.getInt("code");
                    String msg = jsonObject.getString("msg");
                    if (code == 200) {
                        shopDetailedEntity = GsonUtil.GsonToBean(response.body(), ShopDetailedEntity.class);
                        if (shopDetailedEntity == null && shopDetailedEntity.getData() == null) {
                            return;
                        }
                        dataBean = shopDetailedEntity.getData();
                        if (dataBean.getShopEnvironmentImgs().size() == 0) {
                            dataImg.add(dataBean.getShopSignage());
                        } else {
                            dataImg.addAll(dataBean.getShopEnvironmentImgs());
                        }
                        initDiscount();
                        //设置广告轮播
                        if (dataBean.getShopSignage() != null || dataBean.getShopEnvironmentImgs().size() != 0) {
                            convenientBanner.setPages(new CBViewHolderCreator<BannerHolder>() {
                                @Override
                                public BannerHolder createHolder() {
                                    return new BannerHolder();
                                }
                            }, dataImg);
                        }
                        //店名
                        tvCommodityTitle.setText(dataBean.getShopName());
                        tvAddress.setText(dataBean.getShopAddress());
                        //日期
                        tvDoBusinessData.setText(dataBean.getBusinessStartTime() + "-" + dataBean.getBusinessStopTime());
                        //公告
                        tvShopNotice.setText(TextUtils.isEmpty(dataBean.getRemark()) ? "暂无店铺公告" : dataBean.getRemark());
                        //等级
                        rbPerson.setRating((float) (dataBean.getShopCommentSum() / dataBean.getShopCommentNum()));
                        //收藏数量
                        tvNum.setText(String.valueOf(dataBean.getShopCollectionNum()));
                        //平论数量
                        tvNumAssess.setText(String.valueOf(dataBean.getShopCommentNum()));
                        //评级
                        rb.setRating((float) dataBean.getShopCommentSum() / dataBean.getShopCommentNum());
                        //人均消费
                        tvMoneyPerson.setText(String.format(getString(R.string.tv_money_person), String.valueOf(CommonUtil.Double2position(dataBean.getAvgSpend()))));
                        if (TextUtils.isEmpty(dataBean.getShopServices())) {
                            tvMasterRule.setText(dataBean.getShopIntroduce());
                        } else {
                            tvMasterRule.setText(dataBean.getShopIntroduce() + "\n" + dataBean.getShopServices());
                        }


                    } else {
                        ToastUtil.showToast(msg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void initView() {
        intent = getIntent();
        baiduUtil = new BaiduUtil(this);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(intent.getStringExtra("title"));
        initConvenientBanner();
        rvAssess.setLayoutManager(new LinearLayoutManager(this));
        mShopCommentAdapter = new ShopCommentAdapter(this, mRecordsBean);
        rvAssess.setAdapter(mShopCommentAdapter);
        //商铺商品
        rvCommodityIntroduce.setItemAnimator(new DefaultItemAnimator());
        rvCommodityIntroduce.setNestedScrollingEnabled(false);//禁止rcyc嵌套滑动
        rvCommodityIntroduce.setLayoutManager(new LinearLayoutManager(this));
        mShopCommodityAdapter = new ShopCommodityAdapter(this, null);
        rvCommodityIntroduce.setAdapter(mShopCommodityAdapter);
        mShopCommodityAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mShopCommodityAdapter.isFirstOnly(false);
        mShopCommodityAdapter.setLoadMoreView(new CustomLoadMoreView());
        //mShopCommodityAdapter.setOnLoadMoreListener(this, rvCommodityIntroduce);
//        mShopCommodityAdapter.disableLoadMoreIfNotFullPage();
    }

    private void initConvenientBanner() {
        convenientBanner.getLayoutParams().height = Math.round(AppUtils.getScreenHW(this)[0] / 2.5f);
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
                        clickPhoto(position);
                    }
                })
        ;
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer); //集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
        //convenientBanner.setManualPageable(false);//设置不能手动影响
    }

    private void clickPhoto(int position) {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra("position", position);
        intent.putStringArrayListExtra("list", dataImg);
        startActivity(intent);
    }


    //查询收藏状态
    private void getCollectionState() {
        if (getMemberId() == 0l) {
            return;
        }
        OkGo.<String>put(HttpConfig.getShopCollection)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("查询状态", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                JSONObject jsonArray = jsonObject.getJSONObject("data");
                                if (jsonArray != null) {
                                    int state = jsonArray.getInt("state");
                                    if (state == 1) {
                                        flag = 1;
                                        ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_selected));
                                    } else {
                                        flag = 0;
                                        ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_normal));
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //店铺添加收藏
    private void shopCollection() {
        if (getMemberId() == 0l) {
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }
        if (shopDetailedEntity == null && dataBean == null)
            return;
        OkGo.<String>post(HttpConfig.shopCollection)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("收藏", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                ToastUtil.showToast("已收藏");
                                dataBean.setShopCollectionNum(dataBean.getShopCollectionNum() + 1);
                                tvNum.setText(String.valueOf(dataBean.getShopCollectionNum()));
                                flag = 1;
                                ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_selected));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //取消收藏
    private void cancelShopCollection() {
        if (getMemberId() == 0l) {
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }
        if (shopDetailedEntity == null && dataBean == null)
            return;
        OkGo.<String>put(HttpConfig.deleteShopCollection)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("取消收藏", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                dataBean.setShopCollectionNum(dataBean.getShopCollectionNum() - 1);
                                tvNum.setText(String.valueOf(dataBean.getShopCollectionNum()));
                                flag = 0;
                                ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_normal));
                                ToastUtil.showToast("已取消收藏");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 评价
     */
    private void loadContent() {
        OkGo.<String>post(HttpConfig.getShopCommentByShop)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .params("memberId", getMemberId())
                .params("shopId", intent.getStringExtra("shopId"))
                .params("current", 1)
                .params("size", 3)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("店铺评论", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCommentEntity = GsonUtil.GsonToBean(response.body(), ShopCommentEntity.class);
                                mRecordsBean.clear();
                                mRecordsBean.addAll(mShopCommentEntity.getData().getRecords());
                                mShopCommentAdapter.notifyDataSetChanged();
                                if (mRecordsBean.size() == 0) {
                                    llAssess.setVisibility(View.GONE);
                                } else {
                                    llAssess.setVisibility(View.VISIBLE);
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                        }
                    }
                });

    }

    @OnClick({R.id.top_btn_left, R.id.iv_phone, R.id.tv_show_all_assess, R.id.tv_immediately_sale, R.id.iv_collect, R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            //打电话
            case R.id.iv_phone:
                if (mShopCommentEntity != null && dataBean != null) {
                    new DialogPlayPhone(ShopDetailedInformationActivity.this, dataBean.getShopPhone());
                }
                break;
            //查看更多平论
            case R.id.tv_show_all_assess:
                if (mShopCommentEntity != null && dataBean != null && mRecordsBean.size() != 0) {
                    Intent intent = new Intent(ShopDetailedInformationActivity.this, UserCommentsActivity.class);
                    intent.putExtra("shopId", dataBean.getShopId());
                    startActivity(intent);
                }
                break;
            //立即购买
            case R.id.tv_immediately_sale:
                if (getMemberId() == 0l) {
                    startActivity(new Intent(this, LoginActivity.class));
                    return;
                }
                if (mShopCommentEntity != null && dataBean != null) {
                    if ((long) SharedPreferencesUtil.get(this, "shopId", 0l) == dataBean.getShopId()) {
                        ToastUtil.showToast("不能购买自己店铺的商品");
                        return;
                    }
                    Intent intent = new Intent(ShopDetailedInformationActivity.this, PayActivity.class);
                    intent.putExtra("title", "title");
                    intent.putExtra("shopId", String.valueOf(dataBean.getShopId()));
                    intent.putExtra("shopName", dataBean.getShopName());
                    startActivity(intent);
                }
                break;
            //收藏
            case R.id.iv_collect:
                if (flag == 0) {
                    //添加收藏
                    shopCollection();
                } else {
                    //取消收藏
                    cancelShopCollection();
                }
                break;
            //导航
            case R.id.tv_address:
                if (mShopCommodityEntity != null && dataBean != null) {
                    mapData();
                }
                break;
        }
    }

    //调用地图
    private void mapData() {
        baiduUtil.startNavi(
                new LatLng(Double.parseDouble((String) SharedPreferencesUtil.get(this, "latitude", "0.0")),
                        Double.parseDouble((String) SharedPreferencesUtil.get(this, "longitude", "0.0"))),
                new LatLng(dataBean.getLatitude(),
                        dataBean.getLongitude()));
    }

}
