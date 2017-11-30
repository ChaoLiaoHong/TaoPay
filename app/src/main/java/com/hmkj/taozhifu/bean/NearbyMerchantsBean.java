package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class NearbyMerchantsBean {

    /**
     * code : 200
     * data : {"contents":[{"address":"成都天府广场","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1504591616,"direction":"西北","distance":3992,"district":"青羊区","geotable_id":174608,"location":[104.07234,30.663534],"modify_time":1505182624,"province":"四川省","shopCollectionNum":2,"shopCommentNum":0,"shopCommentStart":0,"shopId":25011326125056,"shopName":"小智杂酱面","shopPhone":"18181987001","shopRemark":"","shopServices":"","shop_signage":{"big":"http://d.imgsrc.baidu.com/lbsapi/pic/item/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","imgid":"47362569806","mid":"http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=22f7870d12d8bc3ec65d0ecbb4bb8a2f/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","sml":"http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=60aba4cb77d98d107681043017138938/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg"},"state":2,"title":"小智杂酱面","type":0,"uid":2311173395,"weight":0},{"address":"成都天府广场","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1504593679,"direction":"西北","distance":3992,"district":"青羊区","geotable_id":174608,"location":[104.07234,30.663534],"modify_time":1504667857,"province":"四川省","shopCollectionNum":0,"shopCommentNum":0,"shopCommentStart":0,"shopId":"","shopName":"兰州拉面","shopPhone":"","shopRemark":"","shopServices":"","shopStartLevel":0,"shop_signage":{"big":"http://d.imgsrc.baidu.com/lbsapi/pic/item/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg","imgid":"47363443887","mid":"http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=a8c43c3f1430e924cff194307a384237/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg","sml":"http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=319d1bb4042442a7ae5bf5a4e76f9c7d/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg"},"state":2,"title":"兰州拉面","type":0,"uid":2311185842,"weight":0},{"address":"沙堰西二街20号","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1505094103,"direction":"东北","distance":5248,"district":"武侯区","geotable_id":174608,"location":[104.006615,30.65952],"modify_time":1505095496,"province":"四川省","shopCollectionNum":3,"shopCommentNum":0,"shopCommentStart":0,"shopId":25525899669504,"shopName":"本地家常菜","shopPhone":"17888888888","shopRemark":"","shopServices":"","shop_signage":{"big":"http://a.imgsrc.baidu.com/lbsapi/pic/item/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg","imgid":"47576886103","mid":"http://a.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=2b7240030ae939015657853f4ddc78d6/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg","sml":"http://a.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=3cc83b3760600c33f02cd6c92c606039/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg"},"state":2,"title":"本地家常菜","type":0,"uid":2318642126,"weight":0}],"size":3,"status":0,"total":4}
     * msg : ok
     */

    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        /**
         * contents : [{"address":"成都天府广场","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1504591616,"direction":"西北","distance":3992,"district":"青羊区","geotable_id":174608,"location":[104.07234,30.663534],"modify_time":1505182624,"province":"四川省","shopCollectionNum":2,"shopCommentNum":0,"shopCommentStart":0,"shopId":25011326125056,"shopName":"小智杂酱面","shopPhone":"18181987001","shopRemark":"","shopServices":"","shop_signage":{"big":"http://d.imgsrc.baidu.com/lbsapi/pic/item/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","imgid":"47362569806","mid":"http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=22f7870d12d8bc3ec65d0ecbb4bb8a2f/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","sml":"http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=60aba4cb77d98d107681043017138938/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg"},"state":2,"title":"小智杂酱面","type":0,"uid":2311173395,"weight":0},{"address":"成都天府广场","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1504593679,"direction":"西北","distance":3992,"district":"青羊区","geotable_id":174608,"location":[104.07234,30.663534],"modify_time":1504667857,"province":"四川省","shopCollectionNum":0,"shopCommentNum":0,"shopCommentStart":0,"shopId":"","shopName":"兰州拉面","shopPhone":"","shopRemark":"","shopServices":"","shopStartLevel":0,"shop_signage":{"big":"http://d.imgsrc.baidu.com/lbsapi/pic/item/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg","imgid":"47363443887","mid":"http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=a8c43c3f1430e924cff194307a384237/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg","sml":"http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=319d1bb4042442a7ae5bf5a4e76f9c7d/c2fdfc039245d6887bf39393afc27d1ed21b2417.jpg"},"state":2,"title":"兰州拉面","type":0,"uid":2311185842,"weight":0},{"address":"沙堰西二街20号","avgSpend":0,"businessStartTime":"00:00","businessStopTime":"23:59","city":"成都市","class_id":7,"class_pid":1,"coord_type":3,"create_time":1505094103,"direction":"东北","distance":5248,"district":"武侯区","geotable_id":174608,"location":[104.006615,30.65952],"modify_time":1505095496,"province":"四川省","shopCollectionNum":3,"shopCommentNum":0,"shopCommentStart":0,"shopId":25525899669504,"shopName":"本地家常菜","shopPhone":"17888888888","shopRemark":"","shopServices":"","shop_signage":{"big":"http://a.imgsrc.baidu.com/lbsapi/pic/item/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg","imgid":"47576886103","mid":"http://a.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=2b7240030ae939015657853f4ddc78d6/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg","sml":"http://a.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=3cc83b3760600c33f02cd6c92c606039/63d0f703918fa0ec5f519c2e2d9759ee3d6ddb7b.jpg"},"state":2,"title":"本地家常菜","type":0,"uid":2318642126,"weight":0}]
         * size : 3
         * status : 0
         * total : 4
         */

        public int size;
        public int status;
        public int total;
        public List<ContentsBean> contents;

        public static class ContentsBean {
            /**
             * address : 成都天府广场
             * avgSpend : 0
             * businessStartTime : 00:00
             * businessStopTime : 23:59
             * city : 成都市
             * class_id : 7
             * class_pid : 1
             * coord_type : 3
             * create_time : 1504591616
             * direction : 西北
             * distance : 3992
             * district : 青羊区
             * geotable_id : 174608
             * location : [104.07234,30.663534]
             * modify_time : 1505182624
             * province : 四川省
             * shopCollectionNum : 2
             * shopCommentNum : 0
             * shopCommentStart : 0.0
             * shopId : 25011326125056
             * shopName : 小智杂酱面
             * shopPhone : 18181987001
             * shopRemark :
             * shopServices :
             * shop_signage : {"big":"http://d.imgsrc.baidu.com/lbsapi/pic/item/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","imgid":"47362569806","mid":"http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=22f7870d12d8bc3ec65d0ecbb4bb8a2f/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg","sml":"http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=60aba4cb77d98d107681043017138938/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg"}
             * state : 2
             * title : 小智杂酱面
             * type : 0
             * uid : 2311173395
             * weight : 0
             * shopStartLevel : 0
             */

            public String address;
            public int avgSpend;
            public String businessStartTime;
            public String businessStopTime;
            public String city;
            public int class_id;
            public int class_pid;
            public int coord_type;
            public int create_time;
            public String direction;
            public int distance;
            public String district;
            public int geotable_id;
            public int modify_time;
            public String province;
            public int shopCollectionNum;
            public int shopCommentNum;
            public double shopCommentStart;
            public long shopId;
            public String shopName;
            public String shopPhone;
            public String shopRemark;
            public String shopServices;
            public ShopSignageBean shop_signage;
            public int state;
            public String title;
            public int type;
            public long uid;
            public int weight;
            public int shopStartLevel;
            public List<Double> location;

            public static class ShopSignageBean {
                /**
                 * big : http://d.imgsrc.baidu.com/lbsapi/pic/item/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg
                 * imgid : 47362569806
                 * mid : http://d.imgsrc.baidu.com/lbsapi/wh%3D160%2C160/sign=22f7870d12d8bc3ec65d0ecbb4bb8a2f/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg
                 * sml : http://d.imgsrc.baidu.com/lbsapi/wh%3D16%2C16/sign=60aba4cb77d98d107681043017138938/3b87e950352ac65c5e4e5444f0f2b21193138ab9.jpg
                 */

                public String big;
                public String imgid;
                public String mid;
                public String sml;
            }
        }
    }
}
