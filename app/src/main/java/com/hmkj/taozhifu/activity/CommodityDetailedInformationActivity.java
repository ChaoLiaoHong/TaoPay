package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.CommodityDetailedEntity;
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
import com.hmkj.taozhifu.utils.TimeUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommodityDetailedInformationActivity extends BaseActivity {

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
    @BindView(R.id.tv_convert)
    TextView tvConvert;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_commodity_name)
    TextView tvCommodityName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_commodityJia)
    TextView tvCommodityJia;
    @BindView(R.id.tv_commodityDescr)
    TextView rvCommodityIntroduce;
    @BindView(R.id.tv_valid_date)
    TextView tvValidDate;
    @BindView(R.id.tv_convert_way)
    TextView tvConvertWay;
    @BindView(R.id.tv_use_rule)
    TextView tvUseRule;
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
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_convert_onclick)
    TextView tvConvertOnclick;
    @BindView(R.id.tv_show_convert)
    TextView tvShowConvert;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.v_lian)
    View vLian;
    @BindView(R.id.rl_no_null)
    RelativeLayout rlNoNull;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    private Intent intent;
    private CommodityDetailedEntity mCommodityDetailedEntity;
    private CommodityDetailedEntity.MapBean.ProCommodityBean proCommodityBean;
    private CommodityDetailedEntity.MapBean.ProShopBean proShopBean;
    private ArrayList<String> dataImg = new ArrayList<>();
    private int flag = 0;
    private BaiduUtil baiduUtil;
    private long commodityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_detailed_information);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        getCollectionState();
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

    private void loadData() {
        OkGo.<String>get(String.format(HttpConfig.getProCommodityById, commodityId))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商品详情", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mCommodityDetailedEntity = GsonUtil.GsonToBean(response.body(), CommodityDetailedEntity.class);
                                if (mCommodityDetailedEntity == null)
                                    return;
                                if (mCommodityDetailedEntity.getMap() == null)
                                    return;
                                rlNoNull.setVisibility(View.VISIBLE);
                                llNullState.setVisibility(View.GONE);
                                proCommodityBean = mCommodityDetailedEntity.getMap().getProCommodity();
                                proShopBean = mCommodityDetailedEntity.getMap().getProShop();
                                dataImg.clear();
                                if (mCommodityDetailedEntity.getMap().getImgList().size() == 0) {
                                    dataImg.add(proCommodityBean.getCommodityImg());
                                } else {
                                    for (int i = 0; i < mCommodityDetailedEntity.getMap().getImgList().size(); i++) {
                                        dataImg.add(mCommodityDetailedEntity.getMap().getImgList().get(i).getImgUrl());
                                    }
                                }
                                //设置广告轮播
                                if (proCommodityBean.getCommodityImg() != null || mCommodityDetailedEntity.getMap().getImgList().size() != 0) {
                                    convenientBanner.setPages(new CBViewHolderCreator<BannerHolder>() {
                                        @Override
                                        public BannerHolder createHolder() {
                                            return new BannerHolder();
                                        }
                                    }, dataImg);
                                }
                                //名称
                                tvCommodityTitle.setText(proCommodityBean.getCommodityName());
                                tvConvert.setText(proCommodityBean.getQuantity() + "/" + proCommodityBean.getTotalNum());
                                //1、支持退款    2、不支持退款
                                if (proCommodityBean.getIsReturn() == 1) {
                                    tvShowConvert.setText("支持退款");
                                } else {
                                    tvShowConvert.setText("不支持退款");
                                }
                                //关注数量
                                LogUtil.LogLong("收藏的数量", String.valueOf(mCommodityDetailedEntity.getMap().getCount()));
                                tvNum.setText(String.valueOf(mCommodityDetailedEntity.getMap().getCount()));
                                //价格
                                tvPrice.setText(String.format(CommonUtil.getString(R.string.tv_money), String.valueOf(CommonUtil.Double2position(proCommodityBean.getCommodityPrice()))));
                                //店铺名字
                                tvCommodityName.setText(proShopBean.getShopName());
                                //店铺地址
                                tvAddress.setText(proShopBean.getShopAddress());
                                //商品介绍
                                rvCommodityIntroduce.setText(proCommodityBean.getCommodityDescr());
                                //有效时间
                                tvValidDate.setText(TimeUtil.getTime3String(proCommodityBean.getStartTime(), "") + "至" + TimeUtil.getTime3String(proCommodityBean.getEndTime(), ""));
                                //兑换方式
                                tvConvertWay.setText("现场兑换");
                                //使用规则
                                tvUseRule.setText(proCommodityBean.getRuleDescr());
                            } else {
                                if (msg.contains("没有此商品")) {
                                    rlNoNull.setVisibility(View.GONE);
                                    llNullState.setVisibility(View.VISIBLE);
                                }
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void getCollectionState() {
        if (getMemberId() == 0l) {
            return;
        }
        OkGo.<String>put(HttpConfig.proCommodityCollection)
                .params("memberId", (long) SharedPreferencesUtil.get(this, "memberId", 0l))
                .params("commodityId", intent.getLongExtra("commodityId", 0l))
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

    @Override
    public void initView() {
        intent = getIntent();
        commodityId = intent.getLongExtra("commodityId", 0l);
        baiduUtil = new BaiduUtil(this);
        initBar();
        initConvenientBanner();
        tvNullStateContent.setText("没有查询到此商品的详情");
        tvNullStateOnClick.setText("逛逛首页吧");
    }

    private void initBar() {
        topTitle.setText(R.string.tv_commodity_particulars);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
    }

    @OnClick({R.id.top_btn_left, R.id.tv_convert_onclick, R.id.iv_collect, R.id.tv_phone, R.id.tv_commodityJia, R.id.tv_address, R.id.tv_null_state_onClick})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            case R.id.tv_convert_onclick:
                if (getMemberId() == 0l) {
                    startActivity(new Intent(this, LoginActivity.class));
                    return;
                }
                if (mCommodityDetailedEntity != null && proCommodityBean != null && proShopBean != null) {
                    if ((long) SharedPreferencesUtil.get(this, "shopId", 0l) == proShopBean.getShopId()) {
                        ToastUtil.showToast("不能购买自己店铺的商品");
                        return;
                    }
                    if (proCommodityBean.getEndTime() < System.currentTimeMillis()) {
                        ToastUtil.showToast("商品已经过有效日期，不能购买");
                        return;
                    }
                    Intent intent = new Intent(CommodityDetailedInformationActivity.this, SubmitOrderActivity.class);
                    intent.putExtra("proCommodityBean", proCommodityBean);
                    intent.putExtra("proShopBean", proShopBean);
                    startActivity(intent);
                }
                break;
            case R.id.iv_collect:
                if (flag == 0) {
                    //添加收藏
                    if (getMemberId() == 0l) {
                        startActivity(new Intent(this, LoginActivity.class));
                        return;
                    }
                    if (mCommodityDetailedEntity == null && mCommodityDetailedEntity.getMap() == null)
                        return;
                    commodityCollection();
                } else {
                    //取消收藏
                    if (getMemberId() == 0l) {
                        startActivity(new Intent(this, LoginActivity.class));
                        return;
                    }
                    if (mCommodityDetailedEntity == null && mCommodityDetailedEntity.getMap() == null)
                        return;
                    cancelCommodityCollection();
                }
                break;
            case R.id.tv_phone:
                if (mCommodityDetailedEntity != null && proShopBean != null) {
                    new DialogPlayPhone(CommodityDetailedInformationActivity.this, proShopBean.getShopPhone());
                }
                break;
            case R.id.tv_commodityJia:
                if (mCommodityDetailedEntity != null && proShopBean != null) {
                    Intent intent1 = new Intent(CommodityDetailedInformationActivity.this, ShopDetailedInformationActivity.class);
                    intent1.putExtra("title", proShopBean.getShopName());
                    intent1.putExtra("shopId", String.valueOf(proShopBean.getShopId()));
                    startActivity(intent1);
                }
                break;
            //导航
            case R.id.tv_address:
                if (mCommodityDetailedEntity != null && proShopBean != null) {
                    mapData();
                }
                break;
            case R.id.tv_null_state_onClick:
                startActivity(new Intent(CommodityDetailedInformationActivity.this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    //调用地图
    private void mapData() {
        baiduUtil.startNavi(
                new LatLng(Double.parseDouble((String) SharedPreferencesUtil.get(this, "latitude", "0.0")),
                        Double.parseDouble((String) SharedPreferencesUtil.get(this, "longitude", "0.0"))),
                new LatLng(proShopBean.getLatitude(),
                        proShopBean.getLongitude()));
    }

    //商品添加收藏
    private void commodityCollection() {
        if (intent.getLongExtra("commodityId", 0l) == 0) {
            return;
        }
        if (mCommodityDetailedEntity == null && mCommodityDetailedEntity.getMap() == null)
            return;
        OkGo.<String>post(HttpConfig.addroCommodityCollection)
                .params("memberId", getMemberId())
                .params("commodityId", intent.getLongExtra("commodityId", 0l))
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
                                flag = 1;
                                ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_selected));
                                mCommodityDetailedEntity.getMap().setCount(mCommodityDetailedEntity.getMap().getCount() + 1);
                                tvNum.setText(String.valueOf(mCommodityDetailedEntity.getMap().getCount()));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //取消收藏
    private void cancelCommodityCollection() {
        if (intent.getLongExtra("commodityId", 0l) == 0) {
            return;
        }
        if (mCommodityDetailedEntity == null && mCommodityDetailedEntity.getMap() == null)
            return;
        OkGo.<String>put(HttpConfig.deleteProCommodityCollection)
                .params("memberId", getMemberId())
                .params("commodityId", intent.getLongExtra("commodityId", 0l))
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
                                flag = 0;
                                ivCollect.setImageDrawable(CommonUtil.getDrawable(R.drawable.ico_favorite_normal));
                                ToastUtil.showToast("已取消收藏");
                                mCommodityDetailedEntity.getMap().setCount(mCommodityDetailedEntity.getMap().getCount() - 1);
                                tvNum.setText(String.valueOf(mCommodityDetailedEntity.getMap().getCount()));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (commodityId != 0l)
            loadData();
    }
}
