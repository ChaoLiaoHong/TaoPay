package com.hmkj.taozhifu.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.bean.MyStoreWriteOffBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.ImageUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.yanzhenjie.album.util.PermissionUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/9/12.
 */

public class CaptureActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.photoImg)
    TextView photoImg;
    private CaptureFragment captureFragment;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        requestPermission(CommonStatu.REQUEST_CODE1);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        type = getIntent().getIntExtra("type", 0);
        int zxtype = getIntent().getIntExtra("zxType", 0);
        if (zxtype == HttpConfig.REQUEST_CODE) {
            photoImg.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            if (type == 1) {
                if (!isNetConnect()) {
                    ToastUtil.showToast("无网络链接");
                    return;
                }
                //核销兑换，查商品信息
                updateOrderByOrderCode(result);
            } else {
                Intent resultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
                bundle.putString(CodeUtils.RESULT_STRING, result);
                resultIntent.putExtras(bundle);
                setResult(CommonStatu.REQUEST_CODE1, resultIntent);
                finish();
            }
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            setResult(CommonStatu.REQUEST_CODE1, resultIntent);
            finish();
        }
    };


    @OnClick({R.id.back, R.id.photoImg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            //从相册里面选择
            case R.id.photoImg:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, HttpConfig.REQUEST_IMAGE);
                break;
            default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusEntity event) {
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == HttpConfig.REQUEST_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                try {
                    CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            //相册选二维码
                            SharedPreferencesUtil.put(CaptureActivity.this, "type_sao", "2");
                            SharedPreferencesUtil.put(CaptureActivity.this, "imgZxCode", result);
                            EventBus.getDefault().post(new EventBusEntity(88));
                            finish();
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            ToastUtil.showToast("解析二维码失败,请重新选择");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void requestPermission(int requestCode) {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] permissions = new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA,
            };
            String[] deniedPermissions = PermissionUtils.getDeniedPermissions(this, permissions);
            if (deniedPermissions.length == 0) {
                dispatchGrantedPermission();
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        deniedPermissions,
                        requestCode);
            }
        } else {
            dispatchGrantedPermission();
        }
    }

    /**
     * Dispatch granted permission. 都允许了
     */
    private void dispatchGrantedPermission() {
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PermissionUtils.isGrantedResult(grantResults)) {
            dispatchGrantedPermission();
        } else {
            albumPermissionDenied();
        }
    }

    private void albumPermissionDenied() {
        int messageRes = R.string.album_permission_camera_image_failed_hint;
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.album_title_permission_failed)
                .setMessage(messageRes)
                .setPositiveButton(R.string.album_dialog_sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CaptureActivity.this.finish();
                    }
                })
                .show();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        CaptureActivity.this.finish();
    }

    private void updateOrderByOrderCode(final String result) {
        OkGo.<String>post(HttpConfig.updateOrderByOrderCode).params("code", result)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("核销 -- ", response.body());
                        if (checkHttpCode(response.body())) {
                            MyStoreWriteOffBean myStoreWriteOffBean = GsonUtil.GsonToBean(response.body(), MyStoreWriteOffBean.class);
                            if (myStoreWriteOffBean != null && myStoreWriteOffBean.map != null) {
                                showDialog(myStoreWriteOffBean, result);
                            }
                        } else {
                            ToastUtil.showLongToast(getHttpMsg(response.body()));
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }

    private Dialog dialog;

    private void showDialog(MyStoreWriteOffBean myStoreWriteOffBean, final String result) {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_write_off, null);
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tv_pay_onClick = (TextView) view.findViewById(R.id.tv_pay_onClick);
        TextView tv_product_num = (TextView) view.findViewById(R.id.tv_product_num);
        TextView tv_product_name = (TextView) view.findViewById(R.id.tv_product_name);
        TextView tv_product_use_time = (TextView) view.findViewById(R.id.tv_product_use_time);
        TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
        ImageView iv_product_img = (ImageView) view.findViewById(R.id.iv_product_img);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_pay_onClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sureExchange(result);
            }
        });
        GlideUtils.loadImage(this, myStoreWriteOffBean.map.commodityImg, iv_product_img);
        tv_product_name.setText(myStoreWriteOffBean.map.commodityName);
        tv_product_num.setText("x" + myStoreWriteOffBean.map.quantity);
        tv_price.setText(CommonUtil.getString(R.string.RMB) + myStoreWriteOffBean.map.orders.cashCoupon + "抵用券");
        //初始化控件
        //将布局设置给Dialog
        dialog.setContentView(view);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.height = AppUtils.getScreenHW(this)[1] / 11 * 5;
        lp.width = AppUtils.getScreenHW(this)[0];
//        lp.y = 10;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    private void sureExchange(String result) {
        OkGo.<String>post(String.format(HttpConfig.updateOrder, getIntent().getLongExtra("shopId", 0l)))
                .params("code", result)
                .params("shopId", getIntent().getLongExtra("shopId", 0l))
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        if (checkHttpCode(response.body())) {
                            ToastUtil.showLongToast("兑换成功");
                            Intent intent = new Intent(CaptureActivity.this, MyStoreExchangeOrderActivity.class);
                            intent.putExtra("page", 2);
                            startActivity(intent);
                            dialog.dismiss();
                            CaptureActivity.this.finish();
                        } else {
                            ToastUtil.showLongToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
