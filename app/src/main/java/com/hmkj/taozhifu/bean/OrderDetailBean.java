package com.hmkj.taozhifu.bean;

/**
 * Created by Administrator on 2017/9/18.
 */

public class OrderDetailBean {


    /**
     * code : 200
     * msg : ok
     * orders : {"cashCoupon":999,"clientType":1,"commodityDescr":"呃呃呃额额得得得","commodityId":25086134029312,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","commodityName":"大龙虾","createTime":1505899947000,"memberId":31,"orderCode":"LR3EFYGV","orderId":26351085236224,"orderNo":"O20179151434241056183","orderStatus":2,"quantity":1,"shopId":25011326125056}
     */

    public int code;
    public String msg;
    public OrdersBean orders;

    public static class OrdersBean {
        /**
         * cashCoupon : 999
         * clientType : 1
         * commodityDescr : 呃呃呃额额得得得
         * commodityId : 25086134029312
         * commodityImg : http://upimg.ahmkj.cn/appdata/1504664644313main.png
         * commodityName : 大龙虾
         * createTime : 1505899947000
         * memberId : 31
         * orderCode : LR3EFYGV
         * orderId : 26351085236224
         * orderNo : O20179151434241056183
         * orderStatus : 2
         * quantity : 1
         * shopId : 25011326125056
         */

        public double cashCoupon;
        public int clientType;
        public String commodityDescr;
        public long commodityId;
        public String commodityImg;
        public String commodityName;
        public double commodityPrice;
        public String consigneeName;
        public String consigneePhone;
        public long createTime;
        public long memberId;
        public String orderCode;
        public long orderId;
        public String orderNo;
        public int orderStatus;
        public int quantity;
        public long shopId;
        public double totalAmount;
    }
}
