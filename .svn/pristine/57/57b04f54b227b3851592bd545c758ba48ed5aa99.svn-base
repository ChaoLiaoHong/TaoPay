package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ShareAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.ShareEntity;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.CommonUtil;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.utils.LoadUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/30.
 */

public class ShareZXcodeActivity extends BaseActivity {
    @BindView(R.id.ll_bg)
    LinearLayout LlBg;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mZXcode)
    ImageView mZXcode;
    @BindView(R.id.saveCode)
    TextView saveCode;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.textCK)
    TextView textCK;
    @BindView(R.id.textCK1)
    TextView textCK1;
    @BindView(R.id.rv_payInfo)
    RecyclerView rvPayInfo;
    @BindView(R.id.tv_shopName)
    TextView tvShopName;
    Bitmap mBitmap;
    ShareAdapter shareAdapter;
    ShareAdapter shareAdapter1;
    int imgLogo[] = {R.drawable.ico_wechat_share, R.drawable.ico_friends_share, R.drawable.ico_weibo_share,
            R.drawable.ico_qq_share, R.drawable.ico_qzone_share
    };
    int pay_ico[] = {R.drawable.pay_weixin, R.drawable.pay_alip, R.drawable.pay_qq, R.drawable.pay_baidu, R.drawable.pay_jd, R.drawable.pay_union, R.drawable.pay_gxtzf};
    private List<ShareEntity> shareEntities = new ArrayList<>();
    private List<ShareEntity> shareEntities1 = new ArrayList<>();
    private int bgColor;
    private long storeCode;
    private String shopName;
    private String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ButterKnife.bind(this);
    }

    private void initViews() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(gridLayoutManager);
        for (int i = 0; i < imgLogo.length; i++) {
            shareEntities.add(new ShareEntity(imgLogo[i]));
        }
        shareAdapter = new ShareAdapter(ShareZXcodeActivity.this, shareEntities);
        recyclerView.setAdapter(shareAdapter);

        shareAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //分享图片
                UMImage image = null;
                if (bgColor == 1) {
                    image = new UMImage(ShareZXcodeActivity.this, mBitmap);//网络图片
                } else if (bgColor == 2) {
                    image = new UMImage(ShareZXcodeActivity.this, mUrl);//网络图片
                }
                image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩
                //分享链接
                UMWeb web = null;
                if (!TextUtils.isEmpty(getMemberId() + "")) {
                    if (bgColor == 1) {
                        web = new UMWeb(HttpConfig.shareURL + getMemberId());
                        web.setTitle(CommonUtil.getString(R.string.share_title));
                        web.setDescription(CommonUtil.getString(R.string.share_description));
                    } else if (bgColor == 2) {
                        image = new UMImage(ShareZXcodeActivity.this, mUrl);//网络图片
                    }
                }
                ShareAction shareAction = new ShareAction(ShareZXcodeActivity.this);
                switch (position) {
                    case 0:
                        shareAction.setPlatform(SHARE_MEDIA.WEIXIN);
                        addDescription(image, web, shareAction);
                        break;
                    case 1:
                        shareAction.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE);
                        addDescription(image, web, shareAction);
                        break;
                    case 2:
                        shareAction.setPlatform(SHARE_MEDIA.SINA);
                        addDescription(image, web, shareAction);
                        break;
                    case 3:
                        shareAction.setPlatform(SHARE_MEDIA.QQ);
                        addDescription(image, web, shareAction);
                        break;
                    case 4:
                        shareAction.setPlatform(SHARE_MEDIA.QZONE);
                        addDescription(image, web, shareAction);
                        break;
                    default:
                        break;

                }
            }
        });

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 7);
        rvPayInfo.setLayoutManager(gridLayoutManager1);
        for (int i = 0; i < pay_ico.length; i++) {
            shareEntities1.add(new ShareEntity(pay_ico[i]));
        }
        shareAdapter1 = new ShareAdapter(ShareZXcodeActivity.this, shareEntities1);
        rvPayInfo.setAdapter(shareAdapter1);
    }
    @Override
    public void initData() {
        String textContent = getIntent().getStringExtra("ZX_code");
        String url = getIntent().getStringExtra("url");
        //邀请二维码
        if (bgColor == 1) {
            //顶部二维码
            if (TextUtils.isEmpty(textContent)) {
                return;
            }
            textCK1.setVisibility(View.INVISIBLE);
            tvShopName.setVisibility(View.GONE);
            saveCode.setText("邀请码:\t" + textContent);
            mBitmap = CodeUtils.createImage(url, 400, 400, null);
            mZXcode.setImageBitmap(mBitmap);
            //店铺二维码
        } else if (bgColor == 2) {
            storeCode = getIntent().getLongExtra("store_code", 0);
            shopName = getIntent().getStringExtra("shopName");
            tvShopName.setText(shopName);
            if (storeCode == 0) {
                return;
            }
            saveCode.setVisibility(View.GONE);
            textCK.setText("我们扫码支持");
            int wh[] = AppUtils.getScreenHW(this);
            ViewGroup.LayoutParams layoutParams = mZXcode.getLayoutParams();
            layoutParams.width = (int) Math.round(wh[0] / 2.3);
            layoutParams.height = (int) Math.round(wh[0] / 2.3);
            mUrl = String.format(HttpConfig.getCode, storeCode);
            GlideUtils.loadImage(this, mUrl, mZXcode);
        }
    }

    @Override
    public void initView() {
        initToolbar();
        initViews();
        bgColor = getIntent().getIntExtra("bgColor", 0);
        LlBg.setBackgroundColor(bgColor == 1 ? CommonUtil.getColor(R.color.j_ffd800) : CommonUtil.getColor(R.color.j_0088cd));
        toolbarTitle.setText(bgColor == 1 ? "邀请二维码" : "二维码收账");
        if (bgColor != 1) {
            textCK.setVisibility(View.VISIBLE);
            rvPayInfo.setVisibility(View.VISIBLE);
        } else {
            textCK.setVisibility(View.VISIBLE);
            rvPayInfo.setVisibility(View.GONE);
        }
    }

    private void initToolbar() {
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        initToolBar(toolbar, true, false, null, 0, R.drawable.ic_arrow_back_light_24dp);
        toolbarTitle.setTextColor(Color.WHITE);
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @OnClick({R.id.toolbar_title, R.id.saveCode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_title:
                break;
            case R.id.saveCode://保存二维码
//                if (mBitmap == null) return;
//                CommonUtil.saveImageToGallery(this, mBitmap);
                break;
            default:
                break;
        }
    }

    private void addDescription(UMImage image, UMWeb web, ShareAction shareAction) {
        shareAction.setCallback(umShareListener);
        if (image != null) {
            shareAction.withMedia(image);
        }
        if (web != null) {
            shareAction.withMedia(web);
        }
        shareAction.share();
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.e("plat", "platform" + platform);
            Toast.makeText(ShareZXcodeActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
            ShareZXcodeActivity.this.finish();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShareZXcodeActivity.this, "分享失败", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.e("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShareZXcodeActivity.this, "分享取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        Log.d("result", "onActivityResult");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();//防止内存泄漏
    }
}
