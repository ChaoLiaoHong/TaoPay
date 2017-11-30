package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */

public class ExchengeOrderBean {

    /**
     * code : 200
     * msg : ok
     * ordersPage : {"asc":true,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":4,"records":[{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271702000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"ZYU4LMNX","orderId":25707761980416,"orderNo":"O2017913927282426824","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271713000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"SKZBFWQM","orderId":25707773532160,"orderNo":"O2017913927282435720","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271740000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"SGRX8EYT","orderId":25707800700928,"orderNo":"O2017913927282448034","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271789000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"LYS2DCVM","orderId":25707851536384,"orderNo":"O2017913927282459459","orderStatus":6,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271818000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"DBTWV8GF","orderId":25707880669184,"orderNo":"O2017913927282466598","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271872000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"5D9436N7","orderId":25707936520192,"orderNo":"O2017913927282471195","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271888000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"QDN5ZL7G","orderId":25707952701440,"orderNo":"O2017913927282482809","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505273009000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"42PW8V3N","orderId":25709100824576,"orderNo":"O2017913927282552664","orderStatus":6,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505282065000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"NGH8PMQ9","orderId":25718373416960,"orderNo":"O2017913927282686312","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505282124000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"K5BHWNG4","orderId":25718434108416,"orderNo":"O2017913927282694176","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505283675000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"5UQ6GXM4","orderId":25720022066176,"orderNo":"O2017913927282947641","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287490000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"DGRH9ZKX","orderId":25723929066496,"orderNo":"O2017913927283247252","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287496000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"K6HBF8GM","orderId":25723935037440,"orderNo":"O2017913927283251491","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287529000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"RT4GZA6L","orderId":25723968914432,"orderNo":"O2017913927283268865","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287537000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"G53X9UC2","orderId":25723977011200,"orderNo":"O2017913927283272189","orderStatus":2,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287552000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"V958T3YK","orderId":25723992894464,"orderNo":"O2017913927283287630","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287576000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"RSZGBH92","orderId":25724017520640,"orderNo":"O2017913927283296929","orderStatus":2,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290586000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"G92QBWZF","orderId":25727099041792,"orderNo":"O20179131553245782716","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290662000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"LDG7EFRV","orderId":25727177204736,"orderNo":"O20179131553245795010","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290678000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"YLWXF59G","orderId":25727193839616,"orderNo":"O20179131553245807976","orderStatus":1,"quantity":1,"shopId":25011326125056}],"searchCount":true,"size":20,"total":64}
     */

    public int code;
    public String msg;
    public OrdersPageBean ordersPage;

    public static class OrdersPageBean {
        /**
         * asc : true
         * current : 1
         * limit : 2147483647
         * offset : 0
         * offsetCurrent : 0
         * openSort : true
         * optimizeCount : false
         * orderByField :
         * pages : 4
         * records : [{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271702000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"ZYU4LMNX","orderId":25707761980416,"orderNo":"O2017913927282426824","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271713000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"SKZBFWQM","orderId":25707773532160,"orderNo":"O2017913927282435720","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271740000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"SGRX8EYT","orderId":25707800700928,"orderNo":"O2017913927282448034","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271789000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"LYS2DCVM","orderId":25707851536384,"orderNo":"O2017913927282459459","orderStatus":6,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271818000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"DBTWV8GF","orderId":25707880669184,"orderNo":"O2017913927282466598","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271872000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"5D9436N7","orderId":25707936520192,"orderNo":"O2017913927282471195","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505271888000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"QDN5ZL7G","orderId":25707952701440,"orderNo":"O2017913927282482809","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":999,"clientType":1,"commodityName":"大龙虾","createTime":1505273009000,"headUrl":"http://upimg.ahmkj.cn/appdata/20170919141143.png","imgUrl":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","memberId":31,"name":"大龙虾","nickName":"TZF181819NH9Q","orderCode":"42PW8V3N","orderId":25709100824576,"orderNo":"O2017913927282552664","orderStatus":6,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505282065000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"NGH8PMQ9","orderId":25718373416960,"orderNo":"O2017913927282686312","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505282124000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"K5BHWNG4","orderId":25718434108416,"orderNo":"O2017913927282694176","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505283675000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"5UQ6GXM4","orderId":25720022066176,"orderNo":"O2017913927282947641","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287490000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"DGRH9ZKX","orderId":25723929066496,"orderNo":"O2017913927283247252","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287496000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"K6HBF8GM","orderId":25723935037440,"orderNo":"O2017913927283251491","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287529000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"RT4GZA6L","orderId":25723968914432,"orderNo":"O2017913927283268865","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287537000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"G53X9UC2","orderId":25723977011200,"orderNo":"O2017913927283272189","orderStatus":2,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287552000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"V958T3YK","orderId":25723992894464,"orderNo":"O2017913927283287630","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505287576000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"RSZGBH92","orderId":25724017520640,"orderNo":"O2017913927283296929","orderStatus":2,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290586000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"G92QBWZF","orderId":25727099041792,"orderNo":"O20179131553245782716","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290662000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"LDG7EFRV","orderId":25727177204736,"orderNo":"O20179131553245795010","orderStatus":1,"quantity":1,"shopId":25011326125056},{"cashCoupon":100,"clientType":1,"commodityName":"绍水","createTime":1505290678000,"headUrl":"","imgUrl":"http://upimg.ahmkj.cn/appdata/1504862476689main.png","memberId":10004,"name":"绍水","nickName":"TZF178888BQL2","orderCode":"YLWXF59G","orderId":25727193839616,"orderNo":"O20179131553245807976","orderStatus":1,"quantity":1,"shopId":25011326125056}]
         * searchCount : true
         * size : 20
         * total : 64
         */

        public boolean asc;
        public int current;
        public int limit;
        public int offset;
        public int offsetCurrent;
        public boolean openSort;
        public boolean optimizeCount;
        public String orderByField;
        public int pages;
        public boolean searchCount;
        public int size;
        public int total;
        public List<RecordsBean> records;

        public static class RecordsBean {
            /**
             * cashCoupon : 999
             * clientType : 1
             * commodityName : 大龙虾
             * createTime : 1505271702000
             * headUrl : http://upimg.ahmkj.cn/appdata/20170919141143.png
             * imgUrl : http://upimg.ahmkj.cn/appdata/1504664644313main.png
             * memberId : 31
             * name : 大龙虾
             * nickName : TZF181819NH9Q
             * orderCode : ZYU4LMNX
             * orderId : 25707761980416
             * orderNo : O2017913927282426824
             * orderStatus : 1
             * quantity : 1
             * shopId : 25011326125056
             */

            public double cashCoupon;
            public int clientType;
            public String commodityName;
            public String consigneePhone;
            public long createTime;
            public String headUrl;
            public String imgUrl;
            public long memberId;
            public String name;
            public String nickName;
            public String orderCode;
            public long orderId;
            public String orderNo;
            public int orderStatus;
            public int quantity;
            public long shopId;
        }
    }
}
