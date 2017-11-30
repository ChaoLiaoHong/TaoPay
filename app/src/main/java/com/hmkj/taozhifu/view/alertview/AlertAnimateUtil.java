package com.hmkj.taozhifu.view.alertview;


import android.view.Gravity;

import com.hmkj.taozhifu.R;


/**
 */
public class AlertAnimateUtil {
    private static final int INVALID = -1;

    /**
     * Get default animation resource when not defined by the user
     *
     * @param gravity       the gravity of the dialog
     * @param isInAnimation determine if is in or out animation. true when is is
     * @return the id of the animation resource
     */
    public static int getAnimationResource(int gravity, boolean isInAnimation) {
        switch (gravity) {
            case Gravity.BOTTOM:
                return isInAnimation ? R.anim.slide_in_bottom : R.anim.slide_out_bottom;
            case Gravity.CENTER:
              return isInAnimation ? R.anim.fade_in_center : R.anim.fade_out_center;
          case Gravity.LEFT:
            return isInAnimation ? R.anim.slide_in_left : R.anim.slide_out_left;
        }
        return INVALID;
    }

}
