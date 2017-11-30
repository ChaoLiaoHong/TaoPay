package com.hmkj.taozhifu.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/3/17.
 */

public class SwipeRefreshView extends SwipeRefreshLayout {
    public SwipeRefreshView(Context context) {
        super(context,null);
    }

    public SwipeRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
//        setProgressBackgroundColor(R.color.refresh_bg);
    }

}
