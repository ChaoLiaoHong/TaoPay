package com.hmkj.taozhifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LaunchActivity extends BaseActivity {

    @BindView(R.id.welcome_iv)
    ImageView welcomeIv;
//    private int recLen = 3;
//    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        welcomeIv.setBackgroundResource(R.drawable.ico_start);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.image_scale);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        welcomeIv.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                LaunchActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //   timer.schedule(task, 1000, 1000);
    }

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 1) {
//                if (recLen == 0) {
//                    startActivity(new Intent(LaunchActivity.this, MainActivity.class));
//                    LaunchActivity.this.finish();
//                    timer.cancel();
//                }
//            }
//        }
//    };
//
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            recLen--;
//            Message message = new Message();
//            message.what = 1;
//            handler.sendMessage(message);
//        }
//    };
}
