package com.hmkj.taozhifu;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDexApplication;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.baidu.mapapi.SDKInitializer;
import com.hmkj.taozhifu.utils.AppUtils;
import com.hmkj.taozhifu.utils.GlideImageLoader;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.utils.SharedPreferencesUtil;
import com.hmkj.taozhifu.utils.webviewUtils.APIWebviewTBS;
import com.lzy.ninegrid.NineGridView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.SPCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;


/**
 * Created by Administrator on 2017/8/15.
 */

public class MyApp extends MultiDexApplication {
    public static Handler mHandler;
    public static Context mContext;
    public static MyApp myApp;
    public static File MyPictureTempDir;
    APIWebviewTBS mAPIWebviewTBS;

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        mContext = getApplicationContext();
        myApp = this;
        initOkGo();
        initImageLoader();
        initOSS();
        ZXingLibrary.initDisplayOpinion(this);
        SDKInitializer.initialize(this);
        UMShareAPI.get(this);
        //个人封装，针对升级----开始
        mAPIWebviewTBS = APIWebviewTBS.getAPIWebview();
        mAPIWebviewTBS.initTbs(getApplicationContext());
        //个人封装，针对升级----结束
        MyPictureTempDir = getFilesDir();

    }

    private void initImageLoader() {
        NineGridView.setImageLoader(new GlideImageLoader());
    }

    /**wx0f00bea5768d53e9  ///0e98765d5efceff48f05cd26a5f73dc6
     * 友盟分享平台wxc299b121dea640c4  //74deb3945046e3898543aa77d5e3da5b
     */ {
        PlatformConfig.setWeixin("wxc299b121dea640c4", "74deb3945046e3898543aa77d5e3da5b");
        PlatformConfig.setQQZone("1106359685", "Nrfwk5xSSxwWsisY");
        PlatformConfig.setSinaWeibo("1419561156", "72e02acb624f840e461fcd3f96f09452", "http://sns.whalecloud.com");
    }

    public static MyApp getInstance() {
        return myApp;
    }

    private void initOkGo() {
        HttpHeaders headers = new HttpHeaders();//header.put("","") 不支持中文，不允许有特殊字符
        String token = (String) SharedPreferencesUtil.get(this, "token", "");
        LogUtil.LogLong("token -- " + token);
        if (AppUtils.checkId(token)) {
            headers.put("token", token);
        }
        HttpParams params = new HttpParams();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));
        OkGo.getInstance().setOkHttpClient(builder.build());
        //log相关
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);        //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setColorLevel(Level.WARNING);                               //log颜色级别，决定了log在控制台显示的颜色
        builder.addInterceptor(loggingInterceptor);                                 //添加OkGo默认debug日志
        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);   //全局的连接超时时间
        //https相关设置，以下几种方案根据需要自己设置
        //方法一：信任所有证书,不安全有风险
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        //方法二：自定义信任规则，校验服务端证书
//        HttpsUtils.SSLParams sslParams2 = HttpsUtils.getSslSocketFactory(new SafeTrustManager());
        //方法三：使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams3 = HttpsUtils.getSslSocketFactory(getAssets().open("srca.cer"));
        //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams4 = HttpsUtils.getSslSocketFactory(getAssets().open("xxx.bks"), "123456", getAssets().open("yyy.cer"));
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers);                     //全局公共头
//                .addCommonParams(params);                       //全局公共参数
    }

    //阿里云图片存储服务器
    public static final String testBucket = "hmkjpublicimg";
    public static OSS oss;
    private String endpoint = "http://upimg.ahmkj.cn";
    private String accessKeyId = "LTAIveMr8nLjAomt";
    private String accessKeySecret = "p4MfZNsxyeFbEqBcdHYwkANDBM99Pf";

    public void initOSS() {
        /**
         *上传到oss
         */
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(9); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSSLog.enableLog();
        oss = new OSSClient(MyApp.mContext, endpoint, credentialProvider, conf);
    }
}
