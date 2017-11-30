package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ShopClassifyAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShopClassifyEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductClassifyActivity extends BaseActivity implements ShopClassifyAdapter.OnItemClickListener, View.OnClickListener {
    ShopClassifyEntity mShopClassifyEntity;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_menu)
    TextView toolbarMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_selected_categories)
    TextView tvSelectedCategories;
    @BindView(R.id.ll_selected_categories)
    LinearLayout llSelectedCategories;
    @BindView(R.id.rv_product_classify)
    RecyclerView rvProductClassify;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    private List<ShopClassifyEntity.DataBean> data = new ArrayList<>();
    ShopClassifyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_classify);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        OkGo.<String>get(HttpConfig.getLayeredClassAll)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商品分类", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                llNullState.setVisibility(View.GONE);
                                mShopClassifyEntity = GsonUtil.GsonToBean(response.body(), ShopClassifyEntity.class);
                                data.addAll(mShopClassifyEntity.getData());
                                adapter.notifyDataSetChanged();
                            } else {
                                ToastUtil.showToast(msg);
                                llNullState.setVisibility(View.VISIBLE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        llNullState.setVisibility(View.VISIBLE);
                    }
                });
    }

    @Override
    public void initView() {
        initToolbar();
        rvProductClassify.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopClassifyAdapter(this, data, 2, this);
        rvProductClassify.setAdapter(adapter);
    }

    private void initToolbar() {
        initToolBar(toolbar, true, false, "", Color.BLACK, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setText("选择商品分类");
        toolbarTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        toolbarMenu.setOnClickListener(this);
        tvNullStateOnClick.setText("点击刷新");
        tvNullStateOnClick.setOnClickListener(this);
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        if (item.getItemId() == R.id.menu_product_classity_item) {
//            if (AppUtils.checkId(tvSelectedCategories.getText().toString())) {
//                Intent intent = new Intent();
//                intent.putExtra("name",tvSelectedCategories.getText().toString());
//                setResult(11,intent);
//                finish();
//            } else {
//                ToastUtil.showToast("请选择分类");
//            }
//        }
//        return true;
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //加载menu文件到布局
//        getMenuInflater().inflate(R.menu.activity_product_classify, menu);
//        return true;
//    }

    String classId = "";
    @Override
    public void onItemClick(String name, String des,String classId) {
        llSelectedCategories.setVisibility(View.VISIBLE);
        tvSelectedCategories.setText(name + "-" + des);
        this.classId = classId;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_menu:
                if (AppUtils.checkId(tvSelectedCategories.getText().toString())) {
                    Intent intent = new Intent();
                    intent.putExtra("name", tvSelectedCategories.getText().toString());
                    intent.putExtra("classId", classId);
                    setResult(CommonStatu.OK, intent);
                    finish();
                } else {
                    ToastUtil.showToast("请选择分类");
                }
                break;
            case R.id.tv_null_state_onClick:
                llNullState.setVisibility(View.GONE);
                initData();
                break;
        }
    }
}
