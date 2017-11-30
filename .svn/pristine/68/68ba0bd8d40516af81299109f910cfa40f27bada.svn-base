package com.hmkj.taozhifu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ShopListAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShopListEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
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

public class ShopListActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, TextView.OnEditorActionListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.topView)
    LinearLayout topView;
    @BindView(R.id.top_btn_left)
    Button topBtnLeft;
    @BindView(R.id.top_title)
    TextView topTitle;
    @BindView(R.id.rv_commodity_list_info)
    RecyclerView rv_commodity_list_info;
    @BindView(R.id.search_btn_left)
    Button searchBtnLeft;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.edt_input)
    NOPasteEditText edtInput;
    @BindView(R.id.topSearchVIew)
    LinearLayout topSearchVIew;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    @BindView(R.id.srv)
    SwipeRefreshView srv;
    private Intent intent;
    private ShopListAdapter adapter;
    private List<ShopListEntity.DataBean.ContentsBean> data = new ArrayList<>();
    private int pageNum = 1;
    private ShopListEntity commodityListEntity;
    private String name, classPId, classId, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        ButterKnife.bind(this);
        initListener();
        initEvent();
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ShopListActivity.this, ShopDetailedInformationActivity.class);
                intent.putExtra("title", data.get(position).getShopName());
                intent.putExtra("shopId", data.get(position).getShopId());
                startActivity(intent);
            }
        });
        srv.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        loadData();
    }

    private void loadData() {
        srv.setRefreshing(true);
        LogUtil.LogLong("classId", classId);
        LogUtil.LogLong("精度", (String) SharedPreferencesUtil.get(this, "longitude", "没有拿到"));
        LogUtil.LogLong("纬度", (String) SharedPreferencesUtil.get(this, "latitude", "没有拿到"));
        LogUtil.LogLong("shopName", name);
        double longitude = Double.parseDouble((String) SharedPreferencesUtil.get(this, "longitude", "0.0"));
        double latitude = Double.parseDouble((String) SharedPreferencesUtil.get(this, "latitude", "0.0"));
        if (longitude == 4.9E-324 || longitude == 0.0) {
            longitude = 104.046667;
        }
        if (latitude == 4.9E-324 || latitude == 0.0) {
            latitude = 30.691953;
        }
        OkGo.<String>post(HttpConfig.getShopPoiGeoSearchByNear)
                .params("longitude", longitude)
                .params("latitude", latitude)
                .params("radius", 2000000)
                .params("pageNum", pageNum)
                .params("pageSize", 10)
                .params("classId", intent.getStringExtra("type").equals("3") ? classId : "")
                .params("shopName", intent.getStringExtra("type").equals("1") ? name : "")
                .params("classPId", intent.getStringExtra("type").equals("2") ? classPId : "")
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        srv.setRefreshing(false);
                        LogUtil.LogLong(response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                pageNum++;
                                commodityListEntity = GsonUtil.GsonToBean(response.body(), ShopListEntity.class);
                                data.clear();
                                data.addAll(commodityListEntity.getData().getContents());
                                adapter.setNewData(data);
                                if (commodityListEntity.getData().getSize() == 0) {
                                    srv.setVisibility(View.GONE);
                                    llNullState.setVisibility(View.VISIBLE);
                                } else {
                                    srv.setVisibility(View.VISIBLE);
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
    public void initView() {
        intent = getIntent();
        classId = TextUtils.isEmpty(intent.getStringExtra("classId")) ? "" : intent.getStringExtra("classId");
        name = TextUtils.isEmpty(intent.getStringExtra("title")) ? "" : intent.getStringExtra("title");
        classPId = TextUtils.isEmpty(intent.getStringExtra("classPId")) ? "" : intent.getStringExtra("classPId");
        type = TextUtils.isEmpty(intent.getStringExtra("type")) ? "" : intent.getStringExtra("type");
        initBar();
        if (type.equals("1")) {
            topSearchVIew.setVisibility(View.VISIBLE);
            topView.setVisibility(View.GONE);
            edtInput.setText(name);
        } else if (type.equals("2")) {
            topSearchVIew.setVisibility(View.GONE);
            topView.setVisibility(View.VISIBLE);
            topTitle.setText(name);
        } else if (type.equals("3")) {
            topSearchVIew.setVisibility(View.GONE);
            topView.setVisibility(View.VISIBLE);
            topTitle.setText(name);
        }
        tvNullStateContent.setText(R.string.tv_shop_classify_content);
        tvNullStateOnClick.setVisibility(View.GONE);
        rv_commodity_list_info.setItemAnimator(new DefaultItemAnimator());
        rv_commodity_list_info.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopListAdapter(this, null);
        rv_commodity_list_info.setAdapter(adapter);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.isFirstOnly(false);
        adapter.setLoadMoreView(new CustomLoadMoreView());
        adapter.setOnLoadMoreListener(this, rv_commodity_list_info);
        adapter.disableLoadMoreIfNotFullPage();
    }

    private void initBar() {
        StatusBarUtil.darkMode(this);
        if (type.equals("1")) {
            StatusBarUtil.setPaddingSmart(this, topSearchVIew);
        } else {
            StatusBarUtil.setPaddingSmart(this, topView);
        }
    }


    @OnClick({R.id.search_btn_left, R.id.iv_search, R.id.top_btn_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_btn_left:
                finish();
                break;
            case R.id.iv_search:
                search();
                break;
            case R.id.top_btn_left:
                finish();
                break;
            default:
                break;
        }
    }

    private void search() {
        pageNum = 1;
        name = TextUtils.isEmpty(edtInput.getText().toString().trim()) ? "" : edtInput.getText().toString().trim();
        LogUtil.LogLong("输入的字符：", edtInput.getText().toString().trim());
        initData();
    }

    @Override
    public void onLoadMoreRequested() {
        double longitude = Double.parseDouble((String) SharedPreferencesUtil.get(this, "longitude", "0.0"));
        double latitude = Double.parseDouble((String) SharedPreferencesUtil.get(this, "latitude", "0.0"));
        if (longitude == 4.9E-324 || longitude == 0.0) {
            longitude = 104.046667;
        }
        if (latitude == 4.9E-324 || latitude == 0.0) {
            latitude = 30.691953;
        }
        OkGo.<String>post(HttpConfig.getShopPoiGeoSearchByNear)
                .params("longitude", longitude)
                .params("latitude", latitude)
                .params("radius", 2000000)
                .params("pageNum", pageNum)
                .params("pageSize", 10)
                .params("classId", type.equals("3") ? classId : "")
                .params("shopName", type.equals("1") ? name : "")
                .params("classPId", type.equals("2") ? classPId : "")
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("加载更多", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                commodityListEntity = GsonUtil.GsonToBean(response.body(), ShopListEntity.class);
                                if (commodityListEntity != null && commodityListEntity.getData().getContents() != null) {
                                    pageNum++;
                                    if (commodityListEntity.getData().getContents().size() != 0) {
                                        adapter.loadMoreComplete();
                                        adapter.addData(commodityListEntity.getData().getContents());
                                    } else {
                                        //显示没有更多数据
                                        View noDataView = LayoutInflater.from(ShopListActivity.this).inflate(R.layout.item_no_data, (ViewGroup) rv_commodity_list_info.getParent(), false);
                                        adapter.setFooterView(noDataView);
                                        adapter.loadMoreComplete();
                                        adapter.setEnableLoadMore(false);
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
                    public void onError(Response<String> response) {
                        super.onError(response);
                        adapter.loadMoreFail();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        adapter.removeAllFooterView();
                    }
                });
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        edtInput.setOnEditorActionListener(this);
    }

    /**
     * 监听
     */
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            ((InputMethodManager) edtInput.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    ShopListActivity.this.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            search();
            return true;
        }
        return false;
    }

    @Override
    public void onRefresh() {
        pageNum = 1;
        loadData();
    }
}
