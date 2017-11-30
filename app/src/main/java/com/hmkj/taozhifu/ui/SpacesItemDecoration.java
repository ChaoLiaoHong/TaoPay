package com.hmkj.taozhifu.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/8/30.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int type;

    public SpacesItemDecoration(int space, int type) {
        this.space = space;
        this.type = type;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildPosition(view);
        int psotionCount = parent.getChildCount();
//        outRect.right = space;
//        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        switch (type) {
            case 1:
                if (position > 0) {
                    outRect.top = space;
                }
                break;
            case 2:
//                if (position == 0) {
//                    outRect.left = space;
//                } else if (position > 0 && position < psotionCount) {
//                    outRect.right = space / 2;
//                    outRect.left = space / 2;
//                } else {
//
//                }
                outRect.right = space;
                break;
            case 3:
                if (parent.getChildPosition(view) == 0) {
                    outRect.top = space;
                }
                break;
            default:
                break;
        }
    }
}
