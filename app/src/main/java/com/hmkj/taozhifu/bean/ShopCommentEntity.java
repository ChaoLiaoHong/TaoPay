package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/26
 */

public class ShopCommentEntity extends BaseEntity {

    /**
     * data : {"asc":true,"condition":null,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":1,"records":[{"commentImgs":["asdas","sdas"],"starLevel":3.5,"createTime":1503741235000,"shopId":900971094046035968,"memberNickName":"TZF1588885HUD","shopCommentId":98879749538971648,"memberId":25,"comments":"这个商店的商品还可以"}],"searchCount":true,"size":3,"total":3}
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
         * records : [{"commentImgs":["asdas","sdas"],"starLevel":3.5,"createTime":1503741235000,"shopId":900971094046035968,"memberNickName":"TZF1588885HUD","shopCommentId":98879749538971648,"memberId":25,"comments":"这个商店的商品还可以"}]
         * searchCount : true
         * size : 3
         * total : 3
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
             * commentImgs : ["asdas","sdas"]
             * starLevel : 3.5
             * createTime : 1503741235000
             * shopId : 900971094046035968
             * memberNickName : TZF1588885HUD
             * shopCommentId : 98879749538971648
             * memberId : 25
             * comments : 这个商店的商品还可以
             */

            private float starLevel;
            private long createTime;
            private long shopId;
            private String memberNickName;
            private long shopCommentId;
            private long memberId;
            private String comments;
            private List<String> commentImgs;

            public float getStarLevel() {
                return starLevel;
            }

            public void setStarLevel(float starLevel) {
                this.starLevel = starLevel;
            }

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

            public String getMemberNickName() {
                return memberNickName;
            }

            public void setMemberNickName(String memberNickName) {
                this.memberNickName = memberNickName;
            }

            public long getShopCommentId() {
                return shopCommentId;
            }

            public void setShopCommentId(long shopCommentId) {
                this.shopCommentId = shopCommentId;
            }

            public long getMemberId() {
                return memberId;
            }

            public void setMemberId(long memberId) {
                this.memberId = memberId;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public List<String> getCommentImgs() {
                return commentImgs;
            }

            public void setCommentImgs(List<String> commentImgs) {
                this.commentImgs = commentImgs;
            }
        }
    }
}
