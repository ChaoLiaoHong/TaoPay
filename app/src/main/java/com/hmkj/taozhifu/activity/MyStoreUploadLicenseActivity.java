package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.nanchen.compresshelper.CompressHelper;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumListener;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hmkj.taozhifu.MyApp.oss;
import static com.hmkj.taozhifu.MyApp.testBucket;

public class MyStoreUploadLicenseActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_menu)
    TextView toolbarMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_store_name)
    NOPasteEditText etStoreName;
    @BindView(R.id.iv_delete_store_name)
    ImageView ivDeleteStoreName;
    @BindView(R.id.iv_select_main_pic)
    ImageView ivSelectMainPic;
    @BindView(R.id.iv_product_main_img)
    ImageView ivProductMainImg;
    @BindView(R.id.rl_select_product_main_img)
    RelativeLayout rlSelectProductMainImg;
    String imgPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_upload_license);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbar.setBackgroundColor(Color.WHITE);
        toolbarTitle.setText("执照上传");
        toolbarTitle.setTextColor(Color.BLACK);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.toolbar_menu, R.id.iv_delete_store_name, R.id.rl_select_product_main_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_menu:
                if (check()) {
                    upLoad();
                }
                break;
            case R.id.iv_delete_store_name:
                etStoreName.setText("");
                break;
            case R.id.rl_select_product_main_img:
                selectMainPic();
                break;
            default:
                break;
        }
    }

    private void upLoad() {
        show(false, false);
        String licenseImgName = System.currentTimeMillis() + "license";
//        String licenseImgName = "1504591608287main";
        File file = new File(imgPath);
        //压缩
        Bitmap bitmap = CompressHelper.getDefault(this).compressToBitmap(file);
        beginupload(licenseImgName, CommonUtil.bitmap2Bytes(bitmap));
    }

    public void beginupload(final String name, byte[] bytes) {
        // 构造上传请求
        PutObjectRequest put = new PutObjectRequest(testBucket, "appdata/" + name + ".png", bytes);

        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, final long currentSize, final long totalSize) {
                Log.e("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
                CommonUtil.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        toolbarMenu.setText(currentSize / totalSize * 100 + "%");
                    }
                });
            }
        });

        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                String licenseImgPath = oss.presignPublicObjectURL(testBucket, "appdata/" + name + ".png");
                Intent intent = new Intent();
                intent.putExtra("licenseImgPath", licenseImgPath);
                intent.putExtra("licenseNo", etStoreName.getText().toString().trim());
                setResult(CommonStatu.OK, intent);
                loadUtil.dismiss();
                MyStoreUploadLicenseActivity.this.finish();
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                toolbarMenu.setText("上传");
                loadUtil.dismiss();
            }
        });
    }

    ArrayList<AlbumFile> mainImgList = new ArrayList<>();

    private void selectMainPic() {
        // 选择图片
        Album.image(this)
                .multipleChoice()
                .requestCode(200)
                .camera(true)
                .columnCount(3)
                .selectCount(1)
                .checkedList(mainImgList)
                .listener(new AlbumListener<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAlbumResult(int requestCode, @NonNull ArrayList<AlbumFile> result) {
                        if (result != null && result.size() > 0) {
//                            Glide.with(MyStoreUploadLicenseActivity.this).load(result.get(0).getPath()).crossFade().into(ivProductMainImg);
                            GlideUtils.loadImage(MyStoreUploadLicenseActivity.this, result.get(0).getPath(), ivProductMainImg);
                            imgPath = result.get(0).getPath();
                        }
                    }

                    @Override
                    public void onAlbumCancel(int requestCode) {

                    }
                }).start();
    }

    private boolean check() {
        if (!AppUtils.checkId(etStoreName.getText().toString())) {
            ToastUtil.showToast("请输入营业执照号或手机号");
            return false;
        }
        if (ivProductMainImg.getDrawable().getCurrent().getConstantState() == getResources().getDrawable(R.drawable.img_upload).getConstantState()) {
            ToastUtil.showToast("请选择图片");
            return false;
        }
        if (!isNetConnect()) {
            return false;
        }
        if (!AppUtils.isFastClick()) {
            return false;
        }
        return true;
    }

}
