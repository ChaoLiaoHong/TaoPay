package com.hmkj.taozhifu.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.hmkj.taozhifu.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Administrator on 2017/5/26.
 */

public class LoadUtil extends Dialog {
    protected AVLoadingIndicatorView avi;


    public LoadUtil(@NonNull Context context) {
        this(context, R.style.CustomDialog);
    }

    public LoadUtil(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        initView();
    }


    private void initView() {
        setContentView(R.layout.avloading);
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
    }

    public void setDissOnTouchOutsides(boolean IsCancle) {
        setCanceledOnTouchOutside(IsCancle);
    }

    public void setCancelableOnBack(boolean IsCancle) {
        setCancelable(IsCancle);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
//            "BallPulseIndicator",
//            "BallGridPulseIndicator",
//            "BallClipRotateIndicator",
//            "BallClipRotatePulseIndicator",
//            "SquareSpinIndicator",
//            "BallClipRotateMultipleIndicator",
//            "BallPulseRiseIndicator",
//            "BallRotateIndicator",
//            "CubeTransitionIndicator",
//            "BallZigZagIndicator",
//            "BallZigZagDeflectIndicator",
//            "BallTrianglePathIndicator",
//            "BallScaleIndicator",
//            "LineScaleIndicator",
//            "LineScalePartyIndicator",
//            "BallScaleMultipleIndicator",
//            "BallPulseSyncIndicator",
//            "BallBeatIndicator",
//            "LineScalePulseOutIndicator",
//            "LineScalePulseOutRapidIndicator",
//            "BallScaleRippleIndicator",
//            "BallScaleRippleMultipleIndicator",
//            "BallSpinFadeLoaderIndicator",
//            "LineSpinFadeLoaderIndicator",
//            "TriangleSkewSpinIndicator",
//            "PacmanIndicator",
//            "BallGridBeatIndicator",
//            "SemiCircleSpinIndicator",
//            "com.wang.avi.sample.MyCustomIndicator"
}
