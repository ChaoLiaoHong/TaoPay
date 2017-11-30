package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.GridViewDeleteClickAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.MyProductDetailBean;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.myInterface.CommonStatu;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.ImgCompressUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.StringUtils;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.NoScrollGridView;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumListener;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hmkj.taozhifu.MyApp.oss;
import static com.hmkj.taozhifu.MyApp.testBucket;


/**
 * Created by Administrator on 2017/8/25.
 */

public class MyStorePublishProductActivity extends BaseActivity implements GridViewDeleteClickAdapter.OnRecyclerViewItemClickListener, View.OnClickListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_product_name)
    NOPasteEditText etProductName;
    @BindView(R.id.iv_delete_product_name)
    ImageView ivDeleteProductName;
    @BindView(R.id.tv_product_classify)
    TextView tvProductClassify;
    @BindView(R.id.et_product_price)
    NOPasteEditText etProductPrice;
    @BindView(R.id.et_product_num)
    NOPasteEditText etProductNum;
    @BindView(R.id.tv_is_drawback)
    TextView tvIsDrawback;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.et_product_des)
    NOPasteEditText etProductDes;
    @BindView(R.id.et_product_use_rule)
    NOPasteEditText etProductUseRule;
    @BindView(R.id.iv_select_main_pic)
    ImageView ivSelectMainPic;
    @BindView(R.id.iv_product_main_img)
    ImageView ivProductMainImg;
    @BindView(R.id.rl_select_product_main_img)
    RelativeLayout rlSelectProductMainImg;
    @BindView(R.id.iv_select_pic)
    ImageView ivSelectPic;
    @BindView(R.id.gv_grid_view)
    NoScrollGridView gvGridView;
    @BindView(R.id.tv_publish)
    TextView tvPublish;
    ArrayList<AlbumFile> imgList = new ArrayList<>();
    ArrayList<AlbumFile> mainImgList = new ArrayList<>();
    GridViewDeleteClickAdapter gridViewDeleteClickAdapter;
    PopupWindow pw;
    String classId = ""; //
    String mainImgPath = ""; //主图只有一张，需要单独传，记录下来
    private long shopId; //商铺id
    private long commodityId;
    private int isReturn;
    private MyProductDetailBean myProductDetailBean;

    //修改 记录下 有主图和环境图的情况
    int Mark_Main_Img = 0;
    int Mark_Environment_iMG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store_publish_product);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        shopId = getIntent().getLongExtra("shopId", 0l);
        commodityId = getIntent().getLongExtra("commodityId", 0l);
        toolbarTitle.setText(commodityId == 0l ? "发布商品" : "编辑商品");
        if (commodityId != 0l)
            setData();
    }

    /**
     * 编辑进来的,根据商品id重新请求数据
     */
    private void setData() {
        OkGo.<String>get(String.format(HttpConfig.getProCommodityById, commodityId))
                .params("commodityId", commodityId)
                .execute(new CustomCallback(this) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("商品详情 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            myProductDetailBean = GsonUtil.GsonToBean(response.body(), MyProductDetailBean.class);
                            if (myProductDetailBean != null && myProductDetailBean.map != null)
                                setDetial(myProductDetailBean);
                        } else {
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }
                });
    }

    private void setDetial(MyProductDetailBean myProductDetailBean) {
        if (myProductDetailBean.map.proCommodity != null) {
            etProductName.setText(myProductDetailBean.map.proCommodity.commodityName);
            tvProductClassify.setText(myProductDetailBean.map.proCommodity.classId + "");
            classId = myProductDetailBean.map.proCommodity.classId + "";//
            etProductPrice.setText(myProductDetailBean.map.proCommodity.commodityPrice + "");
            etProductNum.setText(myProductDetailBean.map.proCommodity.totalNum + "");
            tvIsDrawback.setText(myProductDetailBean.map.proCommodity.isReturn == 1 ? "支持" : (myProductDetailBean.map.proCommodity.isReturn == 2 ? "不支持" : ""));
            isReturn = myProductDetailBean.map.proCommodity.isReturn;
            if (myProductDetailBean.map.proCommodity.startTime != 0l)
                tvStartTime.setText(StringUtils.longToString(myProductDetailBean.map.proCommodity.startTime, "yyyy-MM-dd"));
            if (myProductDetailBean.map.proCommodity.endTime != 0l)
                tvEndTime.setText(StringUtils.longToString(myProductDetailBean.map.proCommodity.endTime, "yyyy-MM-dd"));
            if (AppUtils.checkId(myProductDetailBean.map.proCommodity.commodityDescr))
                etProductDes.setText(myProductDetailBean.map.proCommodity.commodityDescr);
            if (AppUtils.checkId(myProductDetailBean.map.proCommodity.ruleDescr))
                etProductUseRule.setText(myProductDetailBean.map.proCommodity.ruleDescr);
            if (AppUtils.checkId(myProductDetailBean.map.proCommodity.commodityImg)) {
                GlideUtils.loadImage(this, myProductDetailBean.map.proCommodity.commodityImg, ivProductMainImg, CommonUtil.getDrawable(R.drawable.img_upload));
                mainImgPath = myProductDetailBean.map.proCommodity.commodityImg;
                mainImgListSize = 1;
                Mark_Main_Img = 1;
            }
        }
        if (myProductDetailBean.map.imgList != null && myProductDetailBean.map.imgList.size() > 0) {
            ArrayList<AlbumFile> carouselFigureList = new ArrayList<>();
            for (MyProductDetailBean.MapBean.imgListBean imgListBean : myProductDetailBean.map.imgList) {
                AlbumFile albumFile = new AlbumFile();
                albumFile.setPath(imgListBean.imgUrl);
                carouselFigureList.add(albumFile);
            }
            environmentListSize = carouselFigureList.size();
            //保持之前的集合不变
            gridViewDeleteClickAdapter.setData(imgList = carouselFigureList);
            environmentListSize = imgList.size();
            Mark_Environment_iMG = 1;
        }
    }

    @Override
    public void initView() {
        initToolbar();
        gridViewDeleteClickAdapter = new GridViewDeleteClickAdapter(this, imgList);
        gridViewDeleteClickAdapter.setOnItemClickListener(this);
        gvGridView.setAdapter(gridViewDeleteClickAdapter);
//        showSoftInputFromWindow(etProductName);
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public void showSoftInputFromWindow(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    private void initToolbar() {
        LogUtil.LogLong("log -- " + tvStartTime.getText().toString().trim());
        initToolBar(toolbar, true, false, "", Color.BLACK, R.drawable.ic_arrow_back_dark_24dp);
        toolbarTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        StatusBarUtil.darkMode(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.iv_delete_product_name, R.id.tv_product_classify, R.id.tv_is_drawback, R.id.tv_start_time, R.id.tv_end_time, R.id.rl_select_product_main_img, R.id.iv_select_pic, R.id.tv_publish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_delete_product_name:
                etProductName.setText("");
                break;
            case R.id.tv_product_classify:
                startActivityForResult(new Intent(this, ProductClassifyActivity.class), CommonStatu.REQUEST_CODE1);
                break;
            case R.id.tv_is_drawback:
                showPopup(tvIsDrawback);
                break;
            case R.id.tv_start_time:
                showDialog(tvStartTime);
                break;
            case R.id.tv_end_time:
                showDialog(tvEndTime);
                break;
            case R.id.rl_select_product_main_img:
                selectMainPic();
                break;
            case R.id.iv_select_pic:
                selectPic();
                break;
            case R.id.tv_publish:
                if (AppUtils.isFastClick()) {
                    checkInput();
                }
                break;
            default:
                break;
        }
    }

    private void showPopup(View view) {
        //把悬浮窗口需要的View打出来
        View contentView = View.inflate(MyStorePublishProductActivity.this, R.layout.item_popup_ischeck, null);
        TextView tvYes = (TextView) contentView.findViewById(R.id.tv_yes);
        TextView tvNo = (TextView) contentView.findViewById(R.id.tv_no);
        tvYes.setOnClickListener(this);
        tvNo.setOnClickListener(this);
        // 检查屏幕上是否已经有了悬浮窗体，有的话就立刻关闭
        checkPopupIsShow();
        pw = new PopupWindow(contentView, -2, -2);//-2
        int[] location = new int[2];
        view.getLocationInWindow(location);
        //☆☆☆☆☆设置popupwindow的背景,透明的 动画才可以播放。
        pw.setBackgroundDrawable(new ColorDrawable());
        pw.setOutsideTouchable(true);
        LogUtil.LogLong(location[1] + "");
        pw.showAsDropDown(view, -10, -10);
        ScaleAnimation sa = new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
        sa.setDuration(100);
        contentView.startAnimation(sa);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CommonStatu.REQUEST_CODE1 && resultCode == CommonStatu.OK) {
            tvProductClassify.setText(data.getStringExtra("name"));
            this.classId = data.getStringExtra("classId");
        }
    }

    private void checkInput() {
        if (!isNetConnect()) {
            return;
        }
        if (!AppUtils.checkId(etProductName.getText().toString().trim())) {
            ToastUtil.showToast("请输入商品名称");
            return;
        }
        if (!AppUtils.checkId(tvProductClassify.getText().toString().trim()) || !AppUtils.checkId(classId)) {
            ToastUtil.showToast("请选择商品分类");
            return;
        }
        if (!AppUtils.checkId(etProductPrice.getText().toString().trim())) {
            ToastUtil.showToast("请输入商品售价");
            return;
        }
        if (Double.parseDouble(getText(etProductPrice)) < 0.01) {
            ToastUtil.showToast("商品单价须大于0.01元");
            return;
        }
        if (!AppUtils.checkId(etProductNum.getText().toString().trim())) {
            ToastUtil.showToast("请输入商品数量");
            return;
        }
        //1支持  2不支持
        if (!AppUtils.checkId(tvIsDrawback.getText().toString().trim()) || isReturn == 0) {
            ToastUtil.showToast("请选择是否支持退款");
            return;
        }
        if (AppUtils.checkId(getText(tvStartTime))) {
            if (!AppUtils.checkId(getText(tvEndTime))) {
                ToastUtil.showToast("请选择结束时间");
                return;
            }
        }
        if (AppUtils.checkId(getText(tvEndTime))) {
            if (!AppUtils.checkId(getText(tvStartTime))) {
                ToastUtil.showToast("请选择开始时间");
                return;
            }
        }
        if (AppUtils.checkId(getText(tvStartTime))) {
            LAST_TIME_LONG = StringUtils.stringToDate(getText(tvStartTime), "yyyy-MM-dd").getTime();
            if (LAST_TIME_LONG > StringUtils.stringToDate(getText(tvEndTime), "yyyy-MM-dd").getTime()) {
                ToastUtil.showToast("开始时间应该小于结束时间");
                return;
            }
        }
        if (ivProductMainImg.getDrawable().getCurrent().getConstantState() == getResources().getDrawable(R.drawable.img_upload).getConstantState()) {
            ToastUtil.showToast("请选择商品主图");
            return;
        }
        if (imgList.size() == 0) {
            ToastUtil.showToast("请选择商品轮播图");
            return;
        }
        uploadImg();
    }

    int mainImgListSize = 0;  // 记录选中主图几张
    int environmentListSize = 0;    //  记录选中的商户轮播图几张
    int uploadSize = 0; //记录上传aliyun 几张
    ArrayList<String> upSuccessImgs; //记录aliyun 上传成功图片路径
    ArrayList<String> names; // 记录选中的图片重新给的名字

    private void uploadImg() {
        show(false, false);
        tvPublish.setClickable(false);
        uploadSize = 0;
        names = new ArrayList<>();
        upSuccessImgs = new ArrayList<>();
        //先上传主图,如果是编辑有主图就不上传
        if (Mark_Main_Img == 1) {
            upSuccessImgs.add(mainImgPath);
            uploadSize = uploadSize + 1;
        } else {
            String mainImgName = System.currentTimeMillis() + "main";
            names.add(mainImgName);
            beginupload(mainImgName, CommonUtil.bitmap2Bytes(ImgCompressUtil.getimage(mainImgPath)));
        }
        //环境图
        for (AlbumFile albumFile : imgList) {
            if (Mark_Environment_iMG == 1) {
                upSuccessImgs.add(albumFile.getPath());
                uploadSize = uploadSize + 1;
            } else {
                String name = System.currentTimeMillis() + "";
                if (!names.contains(name))
                    names.add(name);
                beginupload(name, CommonUtil.bitmap2Bytes(ImgCompressUtil.getimage(albumFile.getPath())));
            }
        }
        //编辑：如果都有图，不上传ali了
        if (Mark_Main_Img == 1 && (Mark_Environment_iMG == 1 || imgList.size() == 0)) checkImg();
    }

    private void checkImg() {
        LogUtil.LogLong(mainImgListSize + environmentListSize + "  --  " + uploadSize);
        if (mainImgListSize + environmentListSize > uploadSize) {
            ToastUtil.showToast("--- 请等待图片上传 ---");
            return;
        }
        diss();
        publish();
    }

    /**
     * 图都传完了，现在传给后台
     */
    private void publish() {
        String mainImgPath = "";
        StringBuilder shopEnvironmentImg = new StringBuilder();
        for (String upSuccessImg : upSuccessImgs) {
            if (upSuccessImg.endsWith("main.png")) mainImgPath = upSuccessImg;
            else shopEnvironmentImg.append(upSuccessImg + ",");
        }
        LogUtil.LogLong("mainImgPath -- " + mainImgPath);
        if (upSuccessImgs.size() > 1 && shopEnvironmentImg.length() > 0)
            LogUtil.LogLong("e_img -- " + shopEnvironmentImg.toString().substring(0, shopEnvironmentImg.length() - 1));
        HttpParams params = new HttpParams();
        params.put("memberId", getMemberId());
        params.put("commodityName", etProductName.getText().toString().trim());
        params.put("classId", classId);
        params.put("shopId", shopId);
        params.put("commodityPrice", etProductPrice.getText().toString().trim());
        params.put("quantity", etProductNum.getText().toString().trim());
        params.put("commodityImg", mainImgPath);
        params.put("type", 1);//暂时固定传1     1.服务商品 2.线上商品
        params.put("isReturn", isReturn);
        if (AppUtils.checkId(getText(tvStartTime))) {
            params.put("startTime", StringUtils.stringToDate(getText(tvStartTime), "yyyy-MM-dd").getTime());
            params.put("endTime", StringUtils.stringToDate(getText(tvEndTime), "yyyy-MM-dd").getTime());
        }
        if (upSuccessImgs.size() > 1 && shopEnvironmentImg.length() > 0)
            params.put("imgUrls", shopEnvironmentImg.toString().substring(0, shopEnvironmentImg.length() - 1));
        if (AppUtils.checkId(getText(etProductDes)))
            params.put("commodityDescr", etProductDes.getText().toString().trim());
        if (AppUtils.checkId(getText(etProductUseRule)))
            params.put("ruleDescr", etProductUseRule.getText().toString().trim());
        if (commodityId != 0l) {
            //如果是编辑进来,多几个参数
            params.put("commodityId", commodityId);
            params.put("upState", myProductDetailBean.map.proCommodity.upState);
            params.put("checkState", myProductDetailBean.map.proCommodity.checkState);
        }
        LogUtil.LogLong(" -- 发布商品传的参数 -- " + params.toString());
        String url = (commodityId == 0l ? HttpConfig.addProCommodity : HttpConfig.updateProCommodity);
        LogUtil.LogLong("url -- " + url);
        OkGo.<String>post(url).params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        show(false, false);
                        tvPublish.setClickable(true);
                    }

                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.LogLong("发布商品 -- " + response.body());
                        if (checkHttpCode(response.body())) {
                            setResult(CommonStatu.OK);
                            ToastUtil.showToast((commodityId == 0l ? "发布" : "编辑") + "成功");
                            MyStorePublishProductActivity.this.finish();
                        } else {
                            deleteAliImgs();
                            ToastUtil.showToast(getHttpMsg(response.body()));
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        deleteAliImgs();
                        ToastUtil.showToast(AppUtils.Err(response.getException()));
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        diss();
                    }
                });
    }

    public void beginupload(final String name, byte[] bytes) {
        // 构造上传请求
        PutObjectRequest put = new PutObjectRequest(testBucket, "appdata/" + name + ".png", bytes);

        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                Log.e("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });

        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                uploadSize = uploadSize + 1;
                Log.e("PutObject", "UploadSuccess");
                Log.e("ETag", result.getETag());
                Log.e("getStatusCode", result.getStatusCode() + "");
                Log.e("RequestId", result.getRequestId());
                if (!upSuccessImgs.contains(oss.presignPublicObjectURL(testBucket, "appdata/" + name + ".png")))
                    upSuccessImgs.add(oss.presignPublicObjectURL(testBucket, "appdata/" + name + ".png"));
                LogUtil.LogLong("ali_path -- " + oss.presignPublicObjectURL(testBucket, "appdata/" + name + ".png"));

                checkImg();
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                uploadSize = uploadSize + 1;
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
                checkImg();
            }
        });
    }

    private void deleteAliImgs() {
        for (String name : names) {
            deleUpImg(name);
        }
    }

    private void deleUpImg(String name) {//如果上传图片到阿里云成功而本地失败
        LogUtil.LogLong(" -- 删除图片进来了 -- ");
        // 创建删除请求
        DeleteObjectRequest delete = new DeleteObjectRequest(testBucket, "appdata/" + name + ".png");
        // 异步删除
        OSSAsyncTask deleteTask = oss.asyncDeleteObject(delete, new OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>() {
            @Override
            public void onSuccess(DeleteObjectRequest request, DeleteObjectResult result) {
                LogUtil.LogLong(" -- 删除图片成功-- ");
            }

            @Override
            public void onFailure(DeleteObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                LogUtil.LogLong(" -- 删除图片失败 -- ");
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }

        });
    }

    private void selectPic() {
        Album.image(this) // 选择图片。
                .multipleChoice()
                .requestCode(200)
                .camera(true)
                .columnCount(3)
                .selectCount(5)
                .checkedList(imgList)
                .listener(new AlbumListener<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAlbumResult(int requestCode, @NonNull ArrayList<AlbumFile> result) {
                        if (result != null && result.size() > 0) {
                            gridViewDeleteClickAdapter.setData(imgList = result);
                            environmentListSize = result.size();
                            Mark_Environment_iMG = 0;
                        }
                    }

                    @Override
                    public void onAlbumCancel(int requestCode) {

                    }
                })
                .start();
    }

    private void selectMainPic() {
        Album.image(this) // 选择图片。
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
                            GlideUtils.loadImage(MyStorePublishProductActivity.this, result.get(0).getPath(), ivProductMainImg);
//                            Glide.with(MyStorePublishProductActivity.this).load(result.get(0).getPath()).crossFade().into(ivProductMainImg);
                            mainImgListSize = result.size();
                            mainImgPath = result.get(0).getPath();
                            Mark_Main_Img = 0;
                        }
                    }

                    @Override
                    public void onAlbumCancel(int requestCode) {

                    }
                })
                .start();
    }

    /**
     * 删除图片
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        imgList.remove(position);
        gridViewDeleteClickAdapter.setData(imgList);
        environmentListSize = imgList.size();//删除了图片,重新计数
        if (upSuccessImgs != null) upSuccessImgs.clear();
    }

    private void showDialog(final TextView textView) {
        initDate();
        View view = View.inflate(this, R.layout.ygz_date_time, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setView(view);
        dialog.show();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        DatePicker datePicker = (DatePicker) view.findViewById(R.id.dp_date);
        datePicker.init(year, month - 1, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MyStorePublishProductActivity.this.year = year;
                MyStorePublishProductActivity.this.month = monthOfYear + 1;
                MyStorePublishProductActivity.this.day = dayOfMonth;
            }
        });
        TextView cancle = (TextView) view.findViewById(R.id.tv_cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        TextView confirm = (TextView) view.findViewById(R.id.tv_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                START_TIME = year + "-" + month + "-" + day;
                LogUtil.LogLong("时间 -- " + START_TIME);
                dialog.dismiss();
                textView.setText(START_TIME);
            }
        });
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    private String START_TIME = "";
    private String END_TIME = "";
    private long LAST_TIME_LONG;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    private void initDate() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_yes:
                tvIsDrawback.setText("支持");
                isReturn = 1;
                pw.dismiss();
                break;
            case R.id.tv_no:
                tvIsDrawback.setText("不支持");
                isReturn = 2;
                pw.dismiss();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        checkPopupIsShow();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                checkPopupIsShow();
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void checkPopupIsShow() {
        if (pw != null) {
            pw.dismiss();
            pw = null;
        }
    }
}
