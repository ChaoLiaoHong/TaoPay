package com.hmkj.taozhifu.mview;

/**
 * Created by Administrator on 2017/8/23.
 */

public interface RegistView {
    /**
     * 获取验证码
     */
    void showSuccess();//成功

    /**
     * 获取验证码后下一步
     */
    void showPhoneCodeNoNull();//验证码手机号码是否为空

    void startTime();//开始倒计时

    void shoewIsCheck();//是否同意用户协议

    void showTrueCode();//验证码正确


}
