package com.hmkj.taozhifu.bean;

/**
 * Created by Administrator on 2017/8/25.
 */

public class myEntity {
    int imageView;
    int title;

    public myEntity(int imageView, int title) {
        this.imageView = imageView;
        this.title = title;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }
}
