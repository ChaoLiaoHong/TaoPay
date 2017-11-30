package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/29
 */

public class ShopCollectionEntity extends BaseEntity {
    /**
     * data : {"asc":true,"condition":null,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":1,"records":[{"createTime":1503981306000,"proShop":[{"shopAddress":"1234","shopDiscount":100,"shopCommentNum":10,"shopName":"厕所串串香","lbsPoiId":"2298147491","longitude":104.045315,"avgSpend":4,"shopPhone":"13340745296","latitude":31.691448,"shopSignage":"http://upimg.ahmkj.cn/updata/img23665919.png","shopCommentSum":40}],"shopId":900971094046035968,"state":1,"memberId":25,"proShopId":24386396613632},{"createTime":1503976937000,"proShop":[{"shopAddress":"1234","shopDiscount":100,"shopCommentNum":5,"shopName":"火锅一条街","lbsPoiId":"2298147736","longitude":104.045315,"avgSpend":87,"shopPhone":"13340745296","latitude":31.691448,"shopSignage":"http://upimg.ahmkj.cn/updata/img23665919.png","shopCommentSum":16}],"shopId":900971202485571584,"state":1,"memberId":25,"proShopId":24381922805760}],"searchCount":true,"size":10,"total":2}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
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
         * records : [{"createTime":1503981306000,"proShop":[{"shopAddress":"1234","shopDiscount":100,"shopCommentNum":10,"shopName":"厕所串串香","lbsPoiId":"2298147491","longitude":104.045315,"avgSpend":4,"shopPhone":"13340745296","latitude":31.691448,"shopSignage":"http://upimg.ahmkj.cn/updata/img23665919.png","shopCommentSum":40}],"shopId":900971094046035968,"state":1,"memberId":25,"proShopId":24386396613632},{"createTime":1503976937000,"proShop":[{"shopAddress":"1234","shopDiscount":100,"shopCommentNum":5,"shopName":"火锅一条街","lbsPoiId":"2298147736","longitude":104.045315,"avgSpend":87,"shopPhone":"13340745296","latitude":31.691448,"shopSignage":"http://upimg.ahmkj.cn/updata/img23665919.png","shopCommentSum":16}],"shopId":900971202485571584,"state":1,"memberId":25,"proShopId":24381922805760}]
         * searchCount : true
         * size : 10
         * total : 2
         */

        private boolean asc;
        private Object condition;
        private int current;
        private int limit;
        private int offset;
        private int offsetCurrent;
        private boolean openSort;
        private boolean optimizeCount;
        private String orderByField;
        private int pages;
        private boolean searchCount;
        private int size;
        private int total;
        private List<RecordsBean> records;

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }

        public Object getCondition() {
            return condition;
        }

        public void setCondition(Object condition) {
            this.condition = condition;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getOffsetCurrent() {
            return offsetCurrent;
        }

        public void setOffsetCurrent(int offsetCurrent) {
            this.offsetCurrent = offsetCurrent;
        }

        public boolean isOpenSort() {
            return openSort;
        }

        public void setOpenSort(boolean openSort) {
            this.openSort = openSort;
        }

        public boolean isOptimizeCount() {
            return optimizeCount;
        }

        public void setOptimizeCount(boolean optimizeCount) {
            this.optimizeCount = optimizeCount;
        }

        public String getOrderByField() {
            return orderByField;
        }

        public void setOrderByField(String orderByField) {
            this.orderByField = orderByField;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * createTime : 1503981306000
             * proShop : [{"shopAddress":"1234","shopDiscount":100,"shopCommentNum":10,"shopName":"厕所串串香","lbsPoiId":"2298147491","longitude":104.045315,"avgSpend":4,"shopPhone":"13340745296","latitude":31.691448,"shopSignage":"http://upimg.ahmkj.cn/updata/img23665919.png","shopCommentSum":40}]
             * shopId : 900971094046035968
             * state : 1
             * memberId : 25
             * proShopId : 24386396613632
             */

            private long createTime;
            private long shopId;
            private int state;
            private long memberId;
            private long proShopId;
            private List<ProShopBean> proShop;

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getShopId() {
                return shopId;
            }

            public void setShopId(long shopId) {
                this.shopId = shopId;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public long getMemberId() {
                return memberId;
            }

            public void setMemberId(long memberId) {
                this.memberId = memberId;
            }

            public long getProShopId() {
                return proShopId;
            }

            public void setProShopId(long proShopId) {
                this.proShopId = proShopId;
            }

            public List<ProShopBean> getProShop() {
                return proShop;
            }

            public void setProShop(List<ProShopBean> proShop) {
                this.proShop = proShop;
            }

            public static class ProShopBean {
                /**
                 * shopAddress : 1234
                 * shopDiscount : 100
                 * shopCommentNum : 10
                 * shopName : 厕所串串香
                 * lbsPoiId : 2298147491
                 * longitude : 104.045315
                 * avgSpend : 4
                 * shopPhone : 13340745296
                 * latitude : 31.691448
                 * shopSignage : http://upimg.ahmkj.cn/updata/img23665919.png
                 * shopCommentSum : 40
                 */

                private String shopAddress;
                private int shopDiscount;
                private int shopCommentNum;
                private String shopName;
                private String lbsPoiId;
                private double longitude;
                private double avgSpend;
                private String shopPhone;
                private double latitude;
                private String shopSignage;
                private double shopCommentSum;

                public String getShopAddress() {
                    return shopAddress;
                }

                public void setShopAddress(String shopAddress) {
                    this.shopAddress = shopAddress;
                }

                public int getShopDiscount() {
                    return shopDiscount;
                }

                public void setShopDiscount(int shopDiscount) {
                    this.shopDiscount = shopDiscount;
                }

                public int getShopCommentNum() {
                    return shopCommentNum;
                }

                public void setShopCommentNum(int shopCommentNum) {
                    this.shopCommentNum = shopCommentNum;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public String getLbsPoiId() {
                    return lbsPoiId;
                }

                public void setLbsPoiId(String lbsPoiId) {
                    this.lbsPoiId = lbsPoiId;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public double getAvgSpend() {
                    return avgSpend;
                }

                public void setAvgSpend(double avgSpend) {
                    this.avgSpend = avgSpend;
                }

                public String getShopPhone() {
                    return shopPhone;
                }

                public void setShopPhone(String shopPhone) {
                    this.shopPhone = shopPhone;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public String getShopSignage() {
                    return shopSignage;
                }

                public void setShopSignage(String shopSignage) {
                    this.shopSignage = shopSignage;
                }

                public double getShopCommentSum() {
                    return shopCommentSum;
                }

                public void setShopCommentSum(double shopCommentSum) {
                    this.shopCommentSum = shopCommentSum;
                }
            }
        }
    }
}
