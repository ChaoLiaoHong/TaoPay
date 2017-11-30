package com.hmkj.taozhifu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5.
 */

public class MyStoreBean {

    /**
     * data : {"shopCommentStart":0,"remark":"","state":1,"businessStopTime":"23:59","shopSignage":"http://upimg.ahmkj.cn/appdata/1504593680516main.png","licenseNo":"18181987001","businessLicense":"http://upimg.ahmkj.cn/appdata/1504593654651license.png","shopCommentNum":0,"shopId":25013466826752,"shopIntroduce":"还不来？","longitude":104.07234043,"havaShop":true,"referrerPhone":"YHNXCM","auditState":1,"shopDiscount":85,"classId":7,"businessStartTime":"00:00","shopAddress":"成都天府广场","shopCollectionNum":0,"refuseReason":"","shopName":"兰州拉面","shopEnvironmentImgs":[],"shopServices":"","memberId":30,"latitude":30.66353451,"avgSpend":0,"shopCommentSum":0}
     * code : 200
     * msg : ok
     */

    public DataBean data;
    public int code;
    public String msg;
    /**
     * data : {"shopCommentStart":0,"remark":"","state":1,"businessStopTime":"23:59","shopSignage":"http://upimg.ahmkj.cn/appdata/1505094101262main.png","businessLicense":"http://upimg.ahmkj.cn/appdata/1505093942078license.png","licenseNo":"17888888888","shopCommentNum":0,"shopId":25525899669504,"shopIntroduce":"东西多多的","longitude":104.00661142,"havaShop":true,"referrerPhone":"123456","auditState":1,"shopDiscount":95,"classId":7,"businessStartTime":"00:00","shopAddress":"沙堰西二街20号","shopCollectionNum":0,"refuseReason":"","shopName":"本地家常菜","shopEnvironmentImgs":["http://upimg.ahmkj.cn/appdata/1505094101309.png","http://upimg.ahmkj.cn/appdata/1505094101369.png"],"shopServices":"","memberId":10004,"avgSpend":0,"shopPhone":"17888888888","latitude":30.65951941,"shopCommentSum":0}
     */

    public static class DataBean implements Serializable {
        /**
         * shopCommentStart : 0
         * remark :
         * state : 1
         * businessStopTime : 23:59
         * shopSignage : http://upimg.ahmkj.cn/appdata/1504593680516main.png
         * licenseNo : 18181987001
         * businessLicense : http://upimg.ahmkj.cn/appdata/1504593654651license.png
         * shopCommentNum : 0
         * shopId : 25013466826752
         * shopIntroduce : 还不来？
         * longitude : 104.07234043
         * havaShop : true
         * referrerPhone : YHNXCM
         * auditState : 1
         * shopDiscount : 85
         * classId : 7
         * businessStartTime : 00:00
         * shopAddress : 成都天府广场
         * shopCollectionNum : 0
         * refuseReason :
         * shopName : 兰州拉面
         * shopEnvironmentImgs : []
         * shopServices :
         * memberId : 30
         * latitude : 30.66353451
         * avgSpend : 0
         * shopCommentSum : 0
         */

        public double shopCommentStart;
        public String remark;
        public int state;
        public String businessStopTime;
        public String shopSignage;
        public String licenseNo;
        public String businessLicense;
        public int shopCommentNum;
        public long shopId;
        public String shopIntroduce;
        public double longitude;
        public boolean havaShop;
        public String referrerPhone;
        public int auditState;
        public int shopDiscount;
        public long classId;
        public String businessStartTime;
        public String shopAddress;
        public int shopCollectionNum;
        public String refuseReason;
        public String shopName;
        public String shopPhone;
        public String shopServices;
        public String rebateIntegralMember;
        public long memberId;
        public double latitude;
        public double avgSpend;
        public double shopCommentSum;
        public List<String> shopEnvironmentImgs;

    }
}
