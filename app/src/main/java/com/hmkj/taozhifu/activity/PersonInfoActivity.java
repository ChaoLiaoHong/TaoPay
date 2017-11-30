package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.hmkj.taozhifu.MyApp;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.EventBusEntity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.mpresenter.ChSexPresenter;
import com.hmkj.taozhifu.mpresenter.QueryUPresenter;
import com.hmkj.taozhifu.mview.QueryView;
import com.hmkj.taozhifu.mview.SexView;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.SelectPicPopupWindow;
import com.hmkj.taozhifu.view.SelectPicPopupWindow2;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.model.TakePhotoOptions;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.PermissionManager.TPermissionType;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/31.
 *
 * @author
 */

public class PersonInfoActivity extends BaseActivity implements QueryView, SexView, TakePhoto.TakeResultListener, InvokeListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.head_ly)
    LinearLayout headLy;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.sex_ly)
    LinearLayout sexLy;
    @BindView(R.id.real_name)
    TextView realName;
    @BindView(R.id.realName_ly)
    LinearLayout realNameLy;
    @BindView(R.id.loginPwd_ly)
    LinearLayout loginPwdLy;
    @BindView(R.id.payPwd_ly)
    LinearLayout payPwdLy;
    @BindView(R.id.mHead)
    ImageView mHead;
    QueryUPresenter queryUPresenter;
    /**
     * 自定义的弹出框类
     */
    SelectPicPopupWindow menuWindow;
    SelectPicPopupWindow2 menuWindow2;
    ChSexPresenter chSexPresenter;
    /**
     * 图片名字
     */
    String imgFile;
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        ButterKnife.bind(this);
        getTakePhoto().onCreate(savedInstanceState);
        chSexPresenter = new ChSexPresenter(PersonInfoActivity.this, this);
        //图片命名格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date curDate = new Date(System.currentTimeMillis());
        imgFile = formatter.format(curDate);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void initView() {
        queryUPresenter = new QueryUPresenter(PersonInfoActivity.this, this);
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.WHITE);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbarTitle.setText("个人信息");
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventBusEntity(CommonStatu.OK));
                finish();
            }
        });
    }

    public void submitAliyun(byte[] bytes) {//上传到阿里云
        // 构造上传请求
        //命名   后面是哪一张图片
        PutObjectRequest put = new PutObjectRequest(MyApp.testBucket, "appdata/" + imgFile + ".png", bytes);
        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
            }
        });

        OSSAsyncTask task = MyApp.oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                LogUtil.LogLong("上传到阿里云成功的结果" + result);
                submitServer();
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    LogUtil.LogLong("ErrorCode" + serviceException.getErrorCode());
                    LogUtil.LogLong("RequestId" + serviceException.getRequestId());
                    LogUtil.LogLong("HostId" + serviceException.getHostId());
                    LogUtil.LogLong("RawMessage" + serviceException.getRawMessage());
                }
            }
        });
    }

    public void submitServer() {//提交到服务器
        final String str = MyApp.oss.presignPublicObjectURL(MyApp.testBucket, "appdata/" + imgFile + ".png");
        LogUtil.LogLong("头像地址" + str);
        LogUtil.LogLong("用户id" + getMemberId());
        OkGo.<String>put(HttpConfig.HEAD_UPDATE)
                .params("imgUrl", str)
                .params("memberId", getMemberId())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.LogLong("头像上传到服务器的结果" + response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            //上传到后台服务器→不想返回的时候拉去信息
                            int code = 200;
                            if (httpCode == code) {
                                ToastUtil.showToast(msg);
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
        queryUPresenter.queryUserInfo();
    }

    @OnClick({R.id.head_ly, R.id.sex_ly, R.id.realName_ly, R.id.loginPwd_ly, R.id.payPwd_ly})
    public void onClick(View view) {
        switch (view.getId()) {
            //头像
            case R.id.head_ly:
                menuWindow2 = new SelectPicPopupWindow2(PersonInfoActivity.this, itemsOnClick2);
                menuWindow2.showAtLocation(PersonInfoActivity.this.findViewById(R.id.sex_ly),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            //性别
            case R.id.sex_ly:
                menuWindow = new SelectPicPopupWindow(PersonInfoActivity.this, itemsOnClick);
                menuWindow.showAtLocation(PersonInfoActivity.this.findViewById(R.id.sex_ly),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            //真实姓名
            case R.id.realName_ly:
                Intent intent = new Intent(PersonInfoActivity.this, AutonymActivity.class);
                startActivityForResult(intent, HttpConfig.REQUEST_CODE_MY);
                break;
            //登录密码
            case R.id.loginPwd_ly:
                startActivity(new Intent(PersonInfoActivity.this, LoginPwdActivity.class));
                break;
            //支付密码
            case R.id.payPwd_ly:
                startActivity(new Intent(PersonInfoActivity.this, PayPwdActivity.class));
                break;
            default:
                break;
        }
    }

    /**
     * 为性别弹出窗口实现监听类
     */
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                //男
                case R.id.ly_man:
                    chSexPresenter.perfectSex("1");
                    break;
                //女
                case R.id.ly_woman:
                    chSexPresenter.perfectSex("2");
                    break;
                default:
                    break;

            }
        }
    };
    /**
     * 为头像弹出窗口实现监听类
     */
    private View.OnClickListener itemsOnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            Uri imageUri = Uri.fromFile(file);
            configCompress(takePhoto);
            configTakePhotoOption(takePhoto);
            menuWindow2.dismiss();
            switch (v.getId()) {
                //拍照
                case R.id.ly_man:
                    getTakePhoto().onPickFromCaptureWithCrop(imageUri, getCropOptions());
                    break;
                //相册
                case R.id.ly_woman:
                    getTakePhoto().onPickFromGalleryWithCrop(imageUri, getCropOptions());
                    break;
                default:
                    break;
            }
        }
    };

    private void configCompress(TakePhoto takePhoto) {
        int maxSize = Integer.parseInt("102400");
        int width = Integer.parseInt("200");
        int height = Integer.parseInt("200");
        boolean showProgressBar = false;
        //保存原图
        boolean enableRawFile = true;
        CompressConfig config;
        config = new CompressConfig.Builder()
                .setMaxSize(maxSize)
                .setMaxPixel(width >= height ? width : height)
                .enableReserveRaw(enableRawFile)
                .create();
        takePhoto.onEnableCompress(config, showProgressBar);
    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);
        builder.setCorrectImage(true);
        takePhoto.setTakePhotoOptions(builder.create());

    }

    @Override
    public void queryUserSuccess(String headUrl, String my_recommend, String phone, int mlevel) {//获取用户信息成功
        LogUtil.LogLong("获取到的用户头像" + headUrl);
        if (TextUtils.isEmpty(headUrl)) {
            GlideUtils.loadImage(PersonInfoActivity.this, R.drawable.img_head_default, mHead);
        } else {
            GlideUtils.loadImage(PersonInfoActivity.this, headUrl, mHead);
        }

    }

    private CropOptions getCropOptions() {
        boolean withWonCrop = true;
        int height = Integer.parseInt("200");
        int width = Integer.parseInt("200");
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setOutputX(width).setOutputY(height);
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }

    @Override
    public void queryUserInfoSuccess(String headUrl, int mSex, String real_Name) {
        if (!TextUtils.equals(headUrl, "")) {
            GlideUtils.loadImage(this, headUrl, mHead);
        }
        if (!TextUtils.equals(real_Name, "")) {
            realName.setText(real_Name);
        }
        if (mSex == 0) {
            sex.setText("未知");
        } else if (mSex == 1) {
            sex.setText("男士");
        } else {
            sex.setText("女士");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 真实姓名返回码
         */
        if (resultCode == HttpConfig.REQUEST_CODE_MY) {
            realName.setText(data.getStringExtra("realName"));
        }

        super.onActivityResult(requestCode, resultCode, data);
        getTakePhoto().onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //以下代码为处理Android6.0、7.0动态权限所需
        TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    @Override
    public void chooseSexSuccess(String sexInfo) {//修改性别成功
        if (sexInfo.equals("1")) {
            sex.setText("男士");
        } else if (sexInfo.equals("2")) {
            sex.setText("女士");
        }
    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(TResult result) {
        String headImgUrl = result.getImage().getCompressPath();
        LogUtil.LogLong("获取图片的路径" + result.getImage().getCompressPath());
        GlideUtils.loadImage(PersonInfoActivity.this, headImgUrl, mHead);
        //上传上去
        submitAliyun(CommonUtil.bitmap2Bytes(BitmapFactory.decodeFile(headImgUrl)));
    }

    @Override
    public void takeFail(TResult result, String msg) {
    }

    @Override
    public void takeCancel() {
    }

    @Override
    public TPermissionType invoke(InvokeParam invokeParam) {
        TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    public void onBackPressed() {
        EventBus.getDefault().post(new EventBusEntity(CommonStatu.OK));
        super.onBackPressed();
    }
}
