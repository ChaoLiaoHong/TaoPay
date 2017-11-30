package com.hmkj.taozhifu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShopDiscointListBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.MyOneTextDialog;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hmkj.taozhifu.http.HttpConfig.getShopDiscountList;

public class MyStoreDiscountActivity extends BaseActivity implements MyOneTextDialog.DLonItemClickListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_menu)
    TextView toolbarMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_store_discount)
    TextView tvStoreDiscount;
    @BindView(R.id.et_notice_des)
    NOPasteEditText etNoticeDes;
    private Long shopId;
    private ShopDiscointListBean shopDiscointListBean;
    private int discountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_discount);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        shopId = getIntent().getLongExtra("shopId", 0l);
    }

    @Override
    public void initView() {
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbar.setBackgroundColor(Color.WHITE);
        toolbarTitle.setText("店铺折扣");
        toolbarTitle.setTextColor(Color.BLACK);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    private void getShopDiscountList() {
        OkGo.<String>get(getShopDiscountList).execute(new CustomCallback(this) {
            @Override
            public void onSuccess(Response<String> response) {
                super.onSuccess(response);
                if (checkHttpCode(response.body())) {
                    shopDiscointListBean = GsonUtil.GsonToBean(response.body(), ShopDiscointListBean.class);
                    if (shopDiscointListBean != null && shopDiscointListBean.data != null) {
                        ArrayList<String> data = new ArrayList<String>();
                        for (ShopDiscointListBean.DataBean dataBean : shopDiscointListBean.data) {
                            data.add(dataBean.discountName);
                        }
                        new MyOneTextDialog(MyStoreDiscountActivity.this, data, MyStoreDiscountActivity.this);
                    }
                }
            }
        });
    }

    @Override
    public void DLonItemClick(BaseQuickAdapter adapter, View view, int position) {
        for (ShopDiscointListBean.DataBean dataBean : shopDiscointListBean.data) {
            if (TextUtils.equals(((TextView) view).getText().toString(), dataBean.discountName)) {
                ToastUtil.showToast(dataBean.discountName);
                tvStoreDiscount.setText(dataBean.discountName);
                discountValue = dataBean.discountValue;
            }
        }
    }

    @OnClick({R.id.toolbar_menu, R.id.tv_store_discount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_menu:
//                if (!AppUtils.checkId(tvStoreDiscount.getText().toString())) {
//                    ToastUtil.showToast("请选择折扣");
//                    return;
//                }
                upSava();
                break;
            case R.id.tv_store_discount:
                getShopDiscountList();
                break;
        }
    }

    private void upSava() {
        OkGo.<String>put(HttpConfig.proShop)
                .params("shopId", shopId)
                .params("shopDiscount", String.valueOf(discountValue == 0 ? "" : discountValue))
                .params("remark", TextUtils.isEmpty(etNoticeDes.getText().toString()) ? "" : etNoticeDes.getText().toString())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("折扣返回 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            ToastUtil.showToast("设置成功");
                            setResult(CommonStatu.OK);
                            MyStoreDiscountActivity.this.finish();
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }
}
