package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.CommodityCollectionAdapter;
import com.hmkj.taozhifu.adapter.ShopCollectionAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.CommodityCollectionEntity;
import com.hmkj.taozhifu.bean.ShopCollectionEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.top_btn_right)
    Button topBtnRight;
    @BindView(R.id.top_iv_right)
    ImageView topIvRight;
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.tv_shop_collection)
    TextView tvShopCollection;
    @BindView(R.id.shop_lien)
    View shopLien;
    @BindView(R.id.ll_shop_collection)
    LinearLayout llShopCollection;
    @BindView(R.id.tv_commodity_collection)
    TextView tvCommodityCollection;
    @BindView(R.id.commodity_lian)
    View commodityLian;
    @BindView(R.id.ll_commodity_collection)
    LinearLayout llCommodityCollection;
    @BindView(R.id.rv_shop_collection_info)
    RecyclerView rvShopCollectionInfo;
    @BindView(R.id.rv_commodity_collection_info)
    RecyclerView rvCommodityCollectionInfo;
    @BindView(R.id.ll_have_content)
    LinearLayout llHaveContent;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    //店铺
    private ShopCollectionEntity mShopCollectionEntity;
    private ShopCollectionAdapter mShopCollectionAdapter;
    private List<ShopCollectionEntity.DataBean.RecordsBean> mProShopBean = new ArrayList<>();
    private int shopPage = 1;
    //商品
    private CommodityCollectionEntity mCommodityCollectionEntity;
    private CommodityCollectionAdapter mCommodityCollectionAdapter;
    private List<CommodityCollectionEntity.DataBean.RecordsBean> mProCommodityBean = new ArrayList<>();
    private int commodityPage = 1;
    private int flag = 1, c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        //商家
        mShopCollectionAdapter.setOnItemDeleteListener(new ShopCollectionAdapter.OnItemListener() {
            // 左滑动删除
            @Override
            public void onItemDeleteClick(int position, ShopCollectionEntity.DataBean.RecordsBean itemProShopBean) {
                LogUtil.LogLong("点击的position", String.valueOf(position));
                shopDelete(position, itemProShopBean.getShopId());
            }

            //跳转
            @Override
            public void onNavigationClick(int position, ShopCollectionEntity.DataBean.RecordsBean itemProShopBean) {
                Intent intent = new Intent(CollectionActivity.this, ShopDetailedInformationActivity.class);
                intent.putExtra("shopId", String.valueOf(itemProShopBean.getShopId()));
                intent.putExtra("title", itemProShopBean.getProShop().get(0).getShopName());
                startActivity(intent);
            }
        });
        //商品
        mCommodityCollectionAdapter.setOnCommodityItemListener(new CommodityCollectionAdapter.OnCommodityItemListener() {
            @Override
            public void onItemDeleteClick(int position, CommodityCollectionEntity.DataBean.RecordsBean itemProCommodityBean) {
                CommodityDelete(position, itemProCommodityBean.getCommodityId());
            }

            @Override
            public void onNavigationClick(int position, CommodityCollectionEntity.DataBean.RecordsBean itemProCommodityBean) {
                Intent intent = new Intent(CollectionActivity.this, CommodityDetailedInformationActivity.class);
                intent.putExtra("commodityId", itemProCommodityBean.getCommodityId());
                startActivity(intent);
            }
        });
    }

    /**
     * 删除商品收藏
     *
     * @param position
     * @param commodityId
     */
    private void CommodityDelete(final int position, long commodityId) {
        OkGo.<String>put(HttpConfig.deleteProCommodityCollection)
                .params("memberId", getMemberId())
                .params("commodityId", commodityId)
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
                                mCommodityCollectionAdapter.remove(position);
                                mCommodityCollectionEntity.getData().setTotal(mCommodityCollectionEntity.getData().getTotal() - 1);
                                tvCommodityCollection.setText(String.format(CommonUtil.getString(R.string.tv_commodity_collection), mCommodityCollectionEntity.getData().getTotal()));
                                mCommodityCollectionAdapter.notifyDataSetChanged();
                                if (mCommodityCollectionEntity.getData().getTotal() == 0) {
                                    rvCommodityCollectionInfo.setVisibility(View.GONE);
                                    llNullState.setVisibility(View.VISIBLE);
                                } else {
                                    rvCommodityCollectionInfo.setVisibility(View.VISIBLE);
                                    llNullState.setVisibility(View.GONE);
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

    /**
     * 删除商家收藏
     *
     * @param position
     * @param shopId
     */
    private void shopDelete(final int position, long shopId) {
        OkGo.<String>put(HttpConfig.deleteShopCollection)
                .params("memberId", getMemberId())
                .params("shopId", shopId)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCollectionAdapter.remove(position);
                                mShopCollectionEntity.getData().setTotal(mShopCollectionEntity.getData().getTotal() - 1);
                                tvShopCollection.setText(String.format(CommonUtil.getString(R.string.tv_shop_collection), mShopCollectionEntity.getData().getTotal()));
                                mShopCollectionAdapter.notifyDataSetChanged();
                                if (mShopCollectionEntity.getData().getTotal() == 0) {
                                    rvShopCollectionInfo.setVisibility(View.GONE);
                                    llNullState.setVisibility(View.VISIBLE);
                                } else {
                                    rvShopCollectionInfo.setVisibility(View.VISIBLE);
                                    llNullState.setVisibility(View.GONE);
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
    public void initData() {
        initShopLoad();
        initCommodityData();
    }

    /**
     * 商家收藏
     */
    private void initShopLoad() {
        OkGo.<String>post(HttpConfig.queryShopCollection)
                .params("page", shopPage)
                .params("size", 10)
                .params("memberId", getMemberId())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商家收藏", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCollectionEntity = GsonUtil.GsonToBean(response.body(), ShopCollectionEntity.class);
                                if (mShopCollectionEntity != null && mShopCollectionEntity.getData() != null) {
                                    tvShopCollection.setText(String.format(CommonUtil.getString(R.string.tv_shop_collection), mShopCollectionEntity.getData().getTotal()));
                                    if (c == 0)
                                        initShopData();
                                } else {
                                    tvShopCollection.setText(String.format(CommonUtil.getString(R.string.tv_shop_collection), 0));
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mShopCollectionAdapter.loadMoreFail();
                    }
                });
    }

    private void initShopData() {
        if (mShopCollectionEntity.getData().getRecords() != null && mShopCollectionEntity.getData().getRecords().size() != 0) {
            rvShopCollectionInfo.setVisibility(View.VISIBLE);
            llNullState.setVisibility(View.GONE);
            mProShopBean.clear();
            shopPage++;
            for (int i = 0; i < mShopCollectionEntity.getData().getRecords().size(); i++) {
                mProShopBean.add(mShopCollectionEntity.getData().getRecords().get(i));
            }
            mShopCollectionAdapter.setNewData(mProShopBean);
        } else {
            rvShopCollectionInfo.setVisibility(View.GONE);
            llNullState.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void initView() {
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, topView);
        topTitle.setText(R.string.myCollect);
        tvNullStateContent.setText(R.string.tv_no_attention_shop);
        tvNullStateOnClick.setText(R.string.tv_go_home);
        //商家
        rvShopCollectionInfo.setItemAnimator(new DefaultItemAnimator());
        rvShopCollectionInfo.setLayoutManager(new LinearLayoutManager(this));
        rvShopCollectionInfo.setVisibility(View.VISIBLE);
        mShopCollectionAdapter = new ShopCollectionAdapter(this, null);
        rvShopCollectionInfo.setAdapter(mShopCollectionAdapter);
        mShopCollectionAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mShopCollectionAdapter.isFirstOnly(false);
        mShopCollectionAdapter.setLoadMoreView(new CustomLoadMoreView());
        mShopCollectionAdapter.setOnLoadMoreListener(this, rvShopCollectionInfo);
        mShopCollectionAdapter.disableLoadMoreIfNotFullPage();
        //商品
        rvCommodityCollectionInfo.setItemAnimator(new DefaultItemAnimator());
        rvCommodityCollectionInfo.setLayoutManager(new LinearLayoutManager(this));
        rvCommodityCollectionInfo.setVisibility(View.GONE);
        mCommodityCollectionAdapter = new CommodityCollectionAdapter(this, null);
        rvCommodityCollectionInfo.setAdapter(mCommodityCollectionAdapter);
        mCommodityCollectionAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mCommodityCollectionAdapter.isFirstOnly(false);
        mCommodityCollectionAdapter.setLoadMoreView(new CustomLoadMoreView());
        mCommodityCollectionAdapter.setOnLoadMoreListener(this, rvShopCollectionInfo);
        mCommodityCollectionAdapter.disableLoadMoreIfNotFullPage();

    }

    @OnClick({R.id.top_btn_left, R.id.ll_shop_collection, R.id.ll_commodity_collection, R.id.tv_null_state_onClick})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_btn_left:
                finish();
                break;
            //商家收藏
            case R.id.ll_shop_collection:
                llNullState.setVisibility(View.GONE);
                flag = 1;
                c = 1;
                tvShopCollection.setTextColor(CommonUtil.getColor(R.color.accent));
                shopLien.setBackgroundColor(CommonUtil.getColor(R.color.accent));
                tvCommodityCollection.setTextColor(CommonUtil.getColor(R.color.j_333333));
                commodityLian.setVisibility(View.GONE);
                shopLien.setVisibility(View.VISIBLE);
                rvCommodityCollectionInfo.setVisibility(View.GONE);
                rvShopCollectionInfo.setVisibility(View.VISIBLE);
                if (mShopCollectionEntity != null && mShopCollectionEntity.getData() != null)
                    initShopData();
                commodityPage = 1;
                initCommodityData();
                llShopCollection.setEnabled(false);
                llCommodityCollection.setEnabled(true);
                break;
            //商品收藏
            case R.id.ll_commodity_collection:
                llNullState.setVisibility(View.GONE);
                flag = 2;
                c = 1;
                tvCommodityCollection.setTextColor(CommonUtil.getColor(R.color.accent));
                commodityLian.setBackgroundColor(CommonUtil.getColor(R.color.accent));
                tvShopCollection.setTextColor(CommonUtil.getColor(R.color.j_333333));
                shopLien.setVisibility(View.GONE);
                commodityLian.setVisibility(View.VISIBLE);
                rvCommodityCollectionInfo.setVisibility(View.VISIBLE);
                rvShopCollectionInfo.setVisibility(View.GONE);
                if (mCommodityCollectionEntity != null && mCommodityCollectionEntity.getData() != null)
                    initCommodityDataLoad();
                shopPage = 1;
                initShopLoad();
                llShopCollection.setEnabled(true);
                llCommodityCollection.setEnabled(false);
                break;
            case R.id.tv_null_state_onClick:
                startActivity(new Intent(CollectionActivity.this, MainActivity.class));
                finish();
                break;
                default:
                    break;
        }
    }

    //商品收藏
    private void initCommodityData() {
        OkGo.<String>post(HttpConfig.queryCommodityCollection)
                .params("page", commodityPage)
                .params("size", 10)
                .params("memberId", getMemberId())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商品收藏", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mCommodityCollectionEntity = GsonUtil.GsonToBean(response.body(), CommodityCollectionEntity.class);
                                if (mCommodityCollectionEntity != null && mCommodityCollectionEntity.getData() != null) {
                                    tvCommodityCollection.setText(String.format(CommonUtil.getString(R.string.tv_commodity_collection), mCommodityCollectionEntity.getData().getTotal()));
                                } else {
                                    tvCommodityCollection.setText(String.format(CommonUtil.getString(R.string.tv_commodity_collection), 0));
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

    private void initCommodityDataLoad() {
        if (mCommodityCollectionEntity.getData().getRecords() != null && mCommodityCollectionEntity.getData().getRecords().size() != 0) {
            rvCommodityCollectionInfo.setVisibility(View.VISIBLE);
            llNullState.setVisibility(View.GONE);
            mProCommodityBean.clear();
            commodityPage++;
            for (int i = 0; i < mCommodityCollectionEntity.getData().getRecords().size(); i++) {
                mProCommodityBean.add(mCommodityCollectionEntity.getData().getRecords().get(i));
            }
            mCommodityCollectionAdapter.setNewData(mProCommodityBean);
        } else {
            rvCommodityCollectionInfo.setVisibility(View.GONE);
            llNullState.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onLoadMoreRequested() {
        if (flag == 1)
            ShopLoadMore();
        else
            CommodityLoadMore();
    }

    //商家加载更多
    private void ShopLoadMore() {
        OkGo.<String>post(HttpConfig.queryShopCollection)
                .params("page", shopPage)
                .params("size", 10)
                .params("memberId", getMemberId())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mShopCollectionAdapter.removeAllFooterView();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        mShopCollectionAdapter.loadMoreComplete();
                        LogUtil.LogLong("商家收藏更多", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopCollectionEntity = GsonUtil.GsonToBean(response.body(), ShopCollectionEntity.class);
                                if (mShopCollectionEntity.getData().getRecords() != null && mShopCollectionEntity.getData().getRecords().size() != 0) {
                                    shopPage++;
                                    for (int i = 0; i < mShopCollectionEntity.getData().getRecords().size(); i++) {
                                        mShopCollectionAdapter.addData(mShopCollectionEntity.getData().getRecords().get(i));
                                    }
                                } else {
                                    //显示没有更多数据
                                    View noDataView = LayoutInflater.from(CollectionActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rvShopCollectionInfo.getParent(), false);
                                    mShopCollectionAdapter.setFooterView(noDataView);
                                    mShopCollectionAdapter.setEnableLoadMore(false);
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mShopCollectionAdapter.loadMoreFail();

                    }
                });
    }

    //商品加载更多
    private void CommodityLoadMore() {
        OkGo.<String>post(HttpConfig.queryCommodityCollection)
                .params("page", commodityPage)
                .params("size", 10)
                .params("memberId", getMemberId())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mCommodityCollectionAdapter.removeAllFooterView();
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        mCommodityCollectionAdapter.loadMoreComplete();
                        LogUtil.LogLong("商品收藏更多", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mCommodityCollectionEntity = GsonUtil.GsonToBean(response.body(), CommodityCollectionEntity.class);
                                if (mCommodityCollectionEntity.getData().getRecords() != null && mCommodityCollectionEntity.getData().getRecords().size() != 0) {
                                    commodityPage++;
                                    for (int i = 0; i < mCommodityCollectionEntity.getData().getRecords().size(); i++) {
                                        mCommodityCollectionAdapter.addData(mCommodityCollectionEntity.getData().getRecords().get(i));
                                    }
                                } else {
                                    //显示没有更多数据
                                    View noDataView = LayoutInflater.from(CollectionActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rvCommodityCollectionInfo.getParent(), false);
                                    mCommodityCollectionAdapter.setFooterView(noDataView);
                                    mCommodityCollectionAdapter.setEnableLoadMore(false);
                                }
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        mCommodityCollectionAdapter.loadMoreFail();
                    }
                });
    }
}
