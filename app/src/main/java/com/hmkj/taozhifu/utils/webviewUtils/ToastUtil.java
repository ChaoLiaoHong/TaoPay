package com.hmkj.taozhifu.utils.webviewUtils;

import android.view.Gravity;
import android.widget.Toast;

import com.hmkj.taozhifu.MyApp;


/**
 * Created by llbt on 2016/4/25.
 */
public class ToastUtil {

    public static void show(Object object) {
        Toast toast = Toast.makeText(MyApp.getInstance(), object + "", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
