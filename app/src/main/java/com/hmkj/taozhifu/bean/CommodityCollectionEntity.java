package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/9/6
 */

public class CommodityCollectionEntity extends BaseEntity {

    /**
     * data : {"asc":true,"condition":null,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":1,"records":[{"createTime":1504683810000,"proComId":25105760461824,"proCommodity":[{"commodityImg":"http://","shopName":"小区商店","shopServices":"WIFI，免费停车，茶水，糕点，聚会，其他","commodityPrice":5,"longitude":104.072276,"latitude":30.66614,"commodityName":"红薯"}],"state":1,"memberId":32,"commodityId":1}],"searchCount":true,"size":10,"total":1}
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
         * records : [{"createTime":1504683810000,"proComId":25105760461824,"proCommodity":[{"commodityImg":"http://","shopName":"小区商店","shopServices":"WIFI，免费停车，茶水，糕点，聚会，其他","commodityPrice":5,"longitude":104.072276,"latitude":30.66614,"commodityName":"红薯"}],"state":1,"memberId":32,"commodityId":1}]
         * searchCount : true
         * size : 10
         * total : 1
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
             * createTime : 1504683810000
             * proComId : 25105760461824
             * proCommodity : [{"commodityImg":"http://","shopName":"小区商店","shopServices":"WIFI，免费停车，茶水，糕点，聚会，其他","commodityPrice":5,"longitude":104.072276,"latitude":30.66614,"commodityName":"红薯"}]
             * state : 1
             * memberId : 32
             * commodityId : 1
             */

            private long createTime;
            private long proComId;
            private int state;
            private long memberId;
            private long commodityId;
            private List<ProCommodityBean> proCommodity;

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getProComId() {
                return proComId;
            }

            public void setProComId(long proComId) {
                this.proComId = proComId;
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

            public long getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(long commodityId) {
                this.commodityId = commodityId;
            }

            public List<ProCommodityBean> getProCommodity() {
                return proCommodity;
            }

            public void setProCommodity(List<ProCommodityBean> proCommodity) {
                this.proCommodity = proCommodity;
            }

            public static class ProCommodityBean {
                /**
                 * commodityImg : http://
                 * shopName : 小区商店
                 * shopServices : WIFI，免费停车，茶水，糕点，聚会，其他
                 * commodityPrice : 5
                 * longitude : 104.072276
                 * latitude : 30.66614
                 * commodityName : 红薯
                 */

                private String commodityImg;
                private String shopName;
                private String shopServices;
                private double commodityPrice;
                private double longitude;
                private double latitude;
                private String commodityName;

                public String getCommodityImg() {
                    return commodityImg;
                }

                public void setCommodityImg(String commodityImg) {
                    this.commodityImg = commodityImg;
                }

                public String getShopName() {
                    return shopName;
                }

                public void setShopName(String shopName) {
                    this.shopName = shopName;
                }

                public String getShopServices() {
                    return shopServices;
                }

                public void setShopServices(String shopServices) {
                    this.shopServices = shopServices;
                }

                public double getCommodityPrice() {
                    return commodityPrice;
                }

                public void setCommodityPrice(double commodityPrice) {
                    this.commodityPrice = commodityPrice;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public String getCommodityName() {
                    return commodityName;
                }

                public void setCommodityName(String commodityName) {
                    this.commodityName = commodityName;
                }
            }
        }
    }
}
