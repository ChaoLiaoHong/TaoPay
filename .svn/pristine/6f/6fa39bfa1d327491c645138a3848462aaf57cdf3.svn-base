package com.hmkj.taozhifu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestExamineAndVerifyActivity extends BaseActivity {

    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_examine_and_verify);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        OkGo.<String>post(HttpConfig.WIP + "api/pro/proShop/adminAuditShop")
                .params("memberId", getMemberId())
                .params("shopId", 25525899669504l)
                .params("auditState", 2)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("审核", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int code = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (code == 200) {
                                ToastUtil.showToast(msg);
                            } else {
                                ToastUtil.showToast(msg);
                            }
                        } catch (JSONException e) {
                        }
                    }
                });
    }
}
