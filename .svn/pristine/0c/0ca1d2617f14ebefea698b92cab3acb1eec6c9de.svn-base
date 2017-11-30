package com.hmkj.taozhifu.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.hmkj.taozhifu.utils.GlideUtils;

/**
 * Created by Administrator on 2017/3/24.
 */

public class BannerHolder implements Holder<String> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        GlideUtils.loadImage(context,data,imageView);
    }
}
