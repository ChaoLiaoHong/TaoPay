package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SpannableStringUtils;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStoreLogoffActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.npet_reason)
    NOPasteEditText npetReason;
    @BindView(R.id.tv_kindly_reminder)
    TextView tvKindlyReminder;
    private Long shopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_logoff);
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
        toolbarTitle.setText("注销店铺");
        toolbarTitle.setTextColor(Color.BLACK);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        tvKindlyReminder.setText(R.string.tvKindlyReminder);
        tvKindlyReminder.setText(
                SpannableStringUtils.getBuilder(CommonUtil.getString(R.string.tvKindlyReminder)).append(CommonUtil.getString(R.string.connect_us)).setClickSpan(clickableSpan).create());
        tvKindlyReminder.setMovementMethod(LinkMovementMethod.getInstance());

    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            call();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(CommonUtil.getColor(R.color.j_0088cd));
            ds.setUnderlineText(true);
        }
    };

    private void call() {
        //用intent启动拨打电话
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + CommonUtil.getString(R.string.connect_us)));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.toolbar_menu)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_menu:
                if (!AppUtils.checkId(npetReason.getText().toString().trim())) {
                    ToastUtil.showToast("请输入注销原因");
                    return;
                }
                logoffStore();
                break;
        }
    }

    private void logoffStore() {
        OkGo.<String>put(HttpConfig.logoutShop).params("memberId", getMemberId())
                .params("shopId", shopId).params("disableReason", npetReason.getText().toString().trim())
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("注销返回 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            ToastUtil.showToast("注销成功");
                            setResult(CommonStatu.OK);
                            MyStoreLogoffActivity.this.finish();
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }
}
