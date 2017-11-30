package com.hmkj.taozhifu.utils;

import android.text.TextUtils;

import com.hmkj.taozhifu.mview.RegistView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/25.
 */

public class StringUtils {
    private RegistView registView;

    public StringUtils(RegistView registView) {
        this.registView = registView;
    }

    // 检查手机号码输入的合法性
    public static boolean checkInput(String phone) {
        boolean result = true;
        LogUtil.LogLong("手机号码", phone);
        // 1.检查为空
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showToast("请输入手机号码!");
            result = false;
        }
        // 2.检查长度
        if (phone.length() != 11) {
            ToastUtil.showToast("手机号码长度不正确!");
            result = false;
        }
        //3.检查手机格式
        String telRegex = "[1][3578]\\d{9}";
        if (TextUtils.isEmpty(phone)) {
            result = false;
        } else if (phone.matches(telRegex)) {//正确格式
            return true;
        } else if (!phone.matches(telRegex)) {
            ToastUtil.showToast("手机号码格式不正确!");
            return false;
        }

        return result;
    }

    //检查密码输入的合法性
    public static boolean checkPwd(String passWord) {
        boolean result = true;
        //检查为空
        if (TextUtils.isEmpty(passWord)) {
            ToastUtil.showToast("密码不能为空!");
            result = false;
        }
        //检查长度
        if (passWord.length() < 6) {
            ToastUtil.showToast("请输入6-11位密码!");
            result = false;
        }
        return result;
    }


    // yyyy-MM-dd HH:mm:ss
    public static String longToString(long currentTime, String formatType) {
        String sDateTime = "";
        try {
            Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
            sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sDateTime;
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType) {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            date = formatter.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
