package com.hmkj.taozhifu.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hmkj.taozhifu.MyApp;

/**
 * 开源图片框架Gilde工具类
 */
public class GlideUtils {
    /**
     * 加载图片
     *
     * @param url
     * @param context
     * @param imageView
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        if (imageView == null) return;
//        if (context == null) context = MyApp.mContext;
        Glide.with(MyApp.mContext).load(url).crossFade().into(imageView);
    }

    public static void loadImage(Context context, Drawable drawable, ImageView imageView) {
        if (imageView == null) return;
//        if (context == null) context = MyApp.mContext;
        Glide.with(MyApp.mContext).load(drawable).crossFade().into(imageView);
    }
    public static void loadImage(Context context, Integer resourceId, ImageView imageView) {
        if (imageView == null) return;
//        if (context == null) context = MyApp.mContext;
        Glide.with(MyApp.mContext).load(resourceId).crossFade().into(imageView);
    }
    public static void loadImage(Context context, String url, ImageView imageView, Drawable drawable) {
        if (imageView == null) return;
        context = MyApp.mContext;
        Glide.with(context).load(url).crossFade().placeholder(drawable).into(imageView);
    }

    /**
     * 是否禁止磁盘缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param type      缓存的类型
     *                  <li>磁盘缓存全部 DiskCacheStrategy.ALL</li>
     *                  <li>磁盘禁止缓存DiskCacheStrategy.NONE</li>
     */
    public static void loadImage(String url, Context context, ImageView imageView, DiskCacheStrategy type) {
        if (imageView == null) return;
        context = MyApp.mContext;
        Glide.with(context).load(url).diskCacheStrategy(type).into(imageView);
    }

    /**
     * 是否禁止内存缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param skipMemoryCache 禁止内存缓存 true为禁止
     */
    public static void loadImage(String url, Context context, ImageView imageView, boolean skipMemoryCache) {
        if (imageView == null) return;
        context = MyApp.mContext;
        Glide.with(context).load(url).skipMemoryCache(skipMemoryCache).into(imageView);
    }

    /**
     * 是否禁止内存/磁盘缓存加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param type            缓存的类型
     *                        <li>磁盘缓存全部 DiskCacheStrategy.ALL</li>
     *                        <li>磁盘禁止缓存DiskCacheStrategy.NONE</li>
     * @param skipMemoryCache 禁止内存缓存 true为禁止
     */
    public static void loadImage(String url, Context context, ImageView imageView, DiskCacheStrategy type,
                                 boolean skipMemoryCache) {
        if (imageView == null) return;
        context = MyApp.mContext;
        Glide.with(context).load(url).skipMemoryCache(skipMemoryCache).diskCacheStrategy(type).into(imageView);
    }

    /**
     * 清除内存中的缓存 必须在UI线程中调用
     *
     * @param context
     */
    public static void clearMemory(Context context) {
        if (context == null) context = MyApp.mContext;
        Glide.get(context).clearMemory();
    }

    /**
     * 清除磁盘中的缓存 必须在后台线程中调用，建议同时clearMemory()
     *
     * @param context
     */
    public static void clearDiskCache(Context context) {
        if (context == null) context = MyApp.mContext;
        Glide.get(context).clearDiskCache();
    }

    /**
     * 优先级加载图片
     *
     * @param url
     * @param context
     * @param imageView
     * @param priority  优先级  Priority.LOW/Priority.HIGH
     */
    public static void loadImageWithPriority(String url, Context context, ImageView imageView, Priority priority) {
        context = MyApp.mContext;
        Glide.with(context).load(url).priority(priority).into(imageView);
    }
}
