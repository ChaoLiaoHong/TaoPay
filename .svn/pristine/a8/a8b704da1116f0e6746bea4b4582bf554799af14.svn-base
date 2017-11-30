/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hmkj.taozhifu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hmkj.taozhifu.MyApp;
import com.hmkj.taozhifu.R;
import com.lzy.ninegrid.NineGridView;

public class GlideImageLoader implements NineGridView.ImageLoader {
    @Override
    public void onDisplayImage(Context context, ImageView imageView, String url) {
        Glide.with(MyApp.mContext).load(url)//
                .placeholder(R.drawable.ic_default_color)// 这行貌似是glide的bug,在部分机型上会导致第一次图片不在中间
                .error(R.drawable.img_error)//
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//
                .into(imageView);
    }

    @Override
    public Bitmap getCacheImage(String url) {
        return null;
    }

}
