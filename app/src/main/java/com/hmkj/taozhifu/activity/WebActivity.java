package com.hmkj.taozhifu.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {

    public final static String URL = "url";
    public final static String TITLE = "title";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.button)
    Button button;
    //音频管理
    private AudioManager mAudioManager;
    private boolean isPause = false;


    public static void runActivity(Context context, String title, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(URL, url);
        intent.putExtra(TITLE, title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);//网页音频管理
        String url = getIntent().getStringExtra(URL);
        String title = getIntent().getStringExtra(TITLE);
        initToolBar(toolbar, true, true, title, Color.WHITE, R.drawable.ic_arrow_back_light_24dp);

        pb.setMax(100);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setProgress(newProgress);
                if (newProgress >= 100) {
                    pb.setVisibility(View.GONE);
                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(et.getText().toString().trim());
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        webView.reload();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
        mAudioManager.abandonAudioFocus(audioFocusChangeListener);
    }

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            LogUtil.LogLong("focusChange: " + focusChange);
            if (isPause && focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                requestAudioFocus();
            }
        }
    };
    //音频控件获取焦点

    private void requestAudioFocus() {
        int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            LogUtil.LogLong("audio focus been granted");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) { // 点击返回健返回上一个页面
            if (webView != null) {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                if (webView != null && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }else{
                    WebActivity.this.finish();
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

