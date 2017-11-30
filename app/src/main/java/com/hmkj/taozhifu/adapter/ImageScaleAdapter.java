package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.utils.GlideUtils;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;


/**
 * Created by Administrator on 2017/5/2.
 */

public class ImageScaleAdapter extends PagerAdapter {
    public ArrayList<String> list;
    private Context context;

    public ImageScaleAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(context);
        GlideUtils.loadImage(context,list.get(position),photoView);
//        Glide.with(context).load(list.get(position)).crossFade().into(photoView);
        container.addView(photoView);
        return photoView;
    }
}
