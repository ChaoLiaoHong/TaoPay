package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/29
 */

public class ShopCommodityEntity extends BaseEntity {

    /**
     * proCommodityPage : {"asc":true,"condition":null,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":1,"records":[{"brandName":"测试水果","checkState":2,"classId":2,"commodityDescr":"随意测试商品介绍","commodityId":897768924593307648,"commodityImg":"http://","commodityName":"葡萄","commodityPrice":10,"createBy":"lk","createTime":1502932333000,"endTime":1502932331000,"isReturn":2,"quantity":199,"ruleDescr":"测试","shopId":900236357702713344,"startTime":1502932328000,"totalNum":200,"type":1,"upState":1,"updateBy":"lk","updateTime":1502932342000},{"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":897768881954013184,"commodityImg":"http://","commodityName":"甘蔗","commodityPrice":3,"createBy":"lk","createTime":1502932217000,"endTime":1502932214000,"isReturn":2,"quantity":99,"ruleDescr":"测试","shopId":900236357702713344,"startTime":1502932210000,"totalNum":200,"type":1,"upState":1,"updateBy":"lk","updateTime":1502932222000},{"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":1,"commodityImg":"http://","commodityName":"红薯","commodityPrice":5,"createBy":"lk","createTime":1502874511000,"endTime":1502874494000,"isReturn":1,"quantity":30,"ruleDescr":"随意","shopId":900236357702713344,"startTime":1502874490000,"totalNum":200,"type":1,"upState":2,"updateBy":"lk","updateTime":1502874521000}],"searchCount":true,"size":3,"total":3}
     */

    public ProCommodityPageBean proCommodityPage;

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
         * records : [{"brandName":"测试水果","checkState":2,"classId":2,"commodityDescr":"随意测试商品介绍","commodityId":897768924593307648,"commodityImg":"http://","commodityName":"葡萄","commodityPrice":10,"createBy":"lk","createTime":1502932333000,"endTime":1502932331000,"isReturn":2,"quantity":199,"ruleDescr":"测试","shopId":900236357702713344,"startTime":1502932328000,"totalNum":200,"type":1,"upState":1,"updateBy":"lk","updateTime":1502932342000},{"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":897768881954013184,"commodityImg":"http://","commodityName":"甘蔗","commodityPrice":3,"createBy":"lk","createTime":1502932217000,"endTime":1502932214000,"isReturn":2,"quantity":99,"ruleDescr":"测试","shopId":900236357702713344,"startTime":1502932210000,"totalNum":200,"type":1,"upState":1,"updateBy":"lk","updateTime":1502932222000},{"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":1,"commodityImg":"http://","commodityName":"红薯","commodityPrice":5,"createBy":"lk","createTime":1502874511000,"endTime":1502874494000,"isReturn":1,"quantity":30,"ruleDescr":"随意","shopId":900236357702713344,"startTime":1502874490000,"totalNum":200,"type":1,"upState":2,"updateBy":"lk","updateTime":1502874521000}]
         * searchCount : true
         * size : 3
         * total : 3
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

        public static class RecordsBean {
            /**
             * brandName : 测试水果
             * checkState : 2
             * classId : 2
             * commodityDescr : 随意测试商品介绍
             * commodityId : 897768924593307648
             * commodityImg : http://
             * commodityName : 葡萄
             * commodityPrice : 10
             * createBy : lk
             * createTime : 1502932333000
             * endTime : 1502932331000
             * isReturn : 2
             * quantity : 199
             * ruleDescr : 测试
             * shopId : 900236357702713344
             * startTime : 1502932328000
             * totalNum : 200
             * type : 1
             * upState : 1
             * updateBy : lk
             * updateTime : 1502932342000
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
        }
    }
}
