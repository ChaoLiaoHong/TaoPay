package com.hmkj.taozhifu.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/12/26.
 */

public class WxZfEntity {

    /**
     * timestamp : 1505118963
     * partnerid : 1421708002
     * noncestr : Z43DBY8JqatewluR
     * prepayid : wx201709111636028c38fd4eb00497370167
     * package : Sign=WXPay
     * appid : wxfb183125d3f57b8e
     * code : 200
     * msg : ok
     */

    public String timestamp;
    public String partnerid;
    public String noncestr;
    public String prepayid;
    @SerializedName("package")
    public String packageX;
    public String appid;
    public int code;
    public String msg;
    public String sign;
}
