package com.hmkj.taozhifu.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.ShopListActivity;
import com.hmkj.taozhifu.adapter.ShopClassifyAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.ShopClassifyEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/16.
 */

public class ShopFragment extends BaseFragment {
    @BindView(R.id.top_title)
    TextView toolbarTitle;
    @BindView(R.id.topView)
    LinearLayout toolbar;
    @BindView(R.id.top_btn_left)
    Button top_btn_left;
    @BindView(R.id.shop_rv)
    RecyclerView shopRv;
    private List<ShopClassifyEntity.DataBean> data = new ArrayList<>();
    ShopClassifyEntity mShopClassifyEntity;
    ShopClassifyAdapter adapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);
        initViews();
        initEvent();
        return view;
    }

    private void initEvent() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ShopListActivity.class);
                intent.putExtra("classPId", String.valueOf(data.get(position).getClassId()));
                intent.putExtra("title", data.get(position).getClassName());
                intent.putExtra("type", "2");
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        top_btn_left.setVisibility(View.INVISIBLE);
        toolbarTitle.setText(R.string.shopClassify);
        toolbarTitle.setTextColor(CommonUtil.getColor(R.color.j_333333));
        shopRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ShopClassifyAdapter(getActivity(), data, 1, null);
        shopRv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        initToolBar(true);
        loadData();
    }

    @Override
    protected void refreshOnVisible() {
        initToolBar(false);
    }

    private void initToolBar(boolean b) {
        StatusBarUtil.darkMode(activity);
        if (b) {
            toolbar.setBackgroundColor(Color.WHITE);
            StatusBarUtil.setPaddingSmart(activity, toolbar);
        }
    }

    private void loadData() {
        OkGo.<String>get(HttpConfig.getLayeredClassAll)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商品分类", response.body());
                        if (TextUtils.isEmpty(response.body())) loadData();
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                mShopClassifyEntity = GsonUtil.GsonToBean(response.body(), ShopClassifyEntity.class);
                                data.addAll(mShopClassifyEntity.getData());
                                adapter.notifyDataSetChanged();
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
