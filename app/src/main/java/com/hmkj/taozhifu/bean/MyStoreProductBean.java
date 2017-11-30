package com.hmkj.taozhifu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class MyStoreProductBean {

    /**
     * proCommodityPage : {"asc":true,"condition":null,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":1,"records":[{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃额额得得得","commodityId":25085767313408,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664286062main.png","commodityName":"小龙虾","commodityPrice":100,"createBy":"TZF181819NH9Q","createTime":1504664289000,"endTime":null,"isReturn":0,"quantity":22,"ruleDescr":"吃","shopId":25011326125056,"startTime":null,"totalNum":22,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃额额得得得","commodityId":25086134029312,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","commodityName":"大龙虾","commodityPrice":999,"createBy":"TZF181819NH9Q","createTime":1504664692000,"endTime":null,"isReturn":0,"quantity":555,"ruleDescr":"吃","shopId":25011326125056,"startTime":null,"totalNum":555,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃","commodityId":25088405059584,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664324311main.png","commodityName":"小龙虾","commodityPrice":211,"createBy":"TZF181819NH9Q","createTime":1504666865000,"endTime":1504627200000,"isReturn":0,"quantity":21,"ruleDescr":"","shopId":25011326125056,"startTime":1504627200000,"totalNum":21,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"好吃","commodityId":25089649275904,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504668068393main.png","commodityName":"大碗杂酱面","commodityPrice":188,"createBy":"TZF181819NH9Q","createTime":1504668080000,"endTime":1504627200000,"isReturn":0,"quantity":5,"ruleDescr":"","shopId":25011326125056,"startTime":1504627200000,"totalNum":5,"type":1,"upState":1,"updateBy":"","updateTime":null}],"searchCount":true,"size":10,"total":4}
     * code : 200
     * msg : ok
     */

    public ProCommodityPageBean proCommodityPage;
    public int code;
    public String msg;

    public static class ProCommodityPageBean {
        /**
         * asc : true
         * condition : null
         * current : 1
         * limit : 2147483647
         * offset : 0
         * offsetCurrent : 0
         * openSort : true
         * optimizeCount : false
         * orderByField :
         * pages : 1
         * records : [{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃额额得得得","commodityId":25085767313408,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664286062main.png","commodityName":"小龙虾","commodityPrice":100,"createBy":"TZF181819NH9Q","createTime":1504664289000,"endTime":null,"isReturn":0,"quantity":22,"ruleDescr":"吃","shopId":25011326125056,"startTime":null,"totalNum":22,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃额额得得得","commodityId":25086134029312,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664644313main.png","commodityName":"大龙虾","commodityPrice":999,"createBy":"TZF181819NH9Q","createTime":1504664692000,"endTime":null,"isReturn":0,"quantity":555,"ruleDescr":"吃","shopId":25011326125056,"startTime":null,"totalNum":555,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"呃呃呃","commodityId":25088405059584,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504664324311main.png","commodityName":"小龙虾","commodityPrice":211,"createBy":"TZF181819NH9Q","createTime":1504666865000,"endTime":1504627200000,"isReturn":0,"quantity":21,"ruleDescr":"","shopId":25011326125056,"startTime":1504627200000,"totalNum":21,"type":1,"upState":1,"updateBy":"","updateTime":null},{"brandName":"","checkState":1,"classId":7,"commodityDescr":"好吃","commodityId":25089649275904,"commodityImg":"http://upimg.ahmkj.cn/appdata/1504668068393main.png","commodityName":"大碗杂酱面","commodityPrice":188,"createBy":"TZF181819NH9Q","createTime":1504668080000,"endTime":1504627200000,"isReturn":0,"quantity":5,"ruleDescr":"","shopId":25011326125056,"startTime":1504627200000,"totalNum":5,"type":1,"upState":1,"updateBy":"","updateTime":null}]
         * searchCount : true
         * size : 10
         * total : 4
         */

        public boolean asc;
        public Object condition;
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

        public static class RecordsBean implements Serializable {
            /**
             * brandName :
             * checkState : 1
             * classId : 7
             * commodityDescr : 呃呃呃额额得得得
             * commodityId : 25085767313408
             * commodityImg : http://upimg.ahmkj.cn/appdata/1504664286062main.png
             * commodityName : 小龙虾
             * commodityPrice : 100
             * createBy : TZF181819NH9Q
             * createTime : 1504664289000
             * endTime : null
             * isReturn : 0
             * quantity : 22
             * ruleDescr : 吃
             * shopId : 25011326125056
             * startTime : null
             * totalNum : 22
             * type : 1
             * upState : 1
             * updateBy :
             * updateTime : null
             */

            public String brandName;
            public int checkState;
            public long classId;
            public String commodityDescr;
            public long commodityId;
            public String commodityImg;
            public String commodityName;
            public double commodityPrice;
            public String createBy;
            public long createTime;
            public long endTime;
            public int isReturn;
            public int quantity;
            public String ruleDescr;
            public long shopId;
            public long startTime;
            public int totalNum;
            public int type;
            public int upState;
            public String updateBy;
            public long updateTime;
            public int collectionNum;
        }
    }
}
