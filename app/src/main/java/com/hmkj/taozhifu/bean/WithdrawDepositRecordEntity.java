package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/10/23
 */

public class WithdrawDepositRecordEntity {

    /**
     * Page : {"asc":true,"current":1,"limit":2147483647,"offset":0,"offsetCurrent":0,"openSort":true,"optimizeCount":false,"orderByField":"","pages":2,"records":[{"amount":1000,"createTime":1508297807000,"memberId":10004,"payWithdrawalRecordId":28806493575168,"poundage":120,"state":1,"transferAmount":880,"type":1,"withdrawalWay":1,"updateTime":1508228350000},{"amount":100,"createTime":1508228232000,"memberId":10004,"payWithdrawalRecordId":28735248921600,"poundage":12,"state":2,"transferAmount":88,"type":1,"updateTime":1508228350000,"withdrawalWay":1},{"amount":100,"createTime":1508228214000,"memberId":10004,"payWithdrawalRecordId":28735230789632,"poundage":12,"state":3,"transferAmount":88,"type":1,"updateTime":1508228382000,"withdrawalWay":1},{"amount":500,"createTime":1508227873000,"memberId":10004,"payWithdrawalRecordId":28734881120256,"poundage":60,"state":1,"transferAmount":440,"type":1,"withdrawalWay":2},{"amount":5000,"createTime":1508119000000,"memberId":10004,"payWithdrawalRecordId":28623394992128,"poundage":600,"state":1,"transferAmount":4400,"type":1,"withdrawalWay":1},{"amount":5000,"createTime":1508118514000,"memberId":10004,"payWithdrawalRecordId":28622897778688,"poundage":600,"state":1,"transferAmount":4400,"type":1,"withdrawalWay":1},{"amount":1800,"createTime":1507861687000,"memberId":10004,"payWithdrawalRecordId":28359906620416,"poundage":216,"state":3,"transferAmount":1584,"type":1,"updateTime":1508146874000,"withdrawalWay":1},{"amount":1000,"createTime":1507792859000,"memberId":10004,"payWithdrawalRecordId":28289426666496,"poundage":60,"state":3,"transferAmount":940,"type":1,"updateTime":1508146813000,"withdrawalWay":2},{"amount":100,"createTime":1507791965000,"memberId":10004,"payWithdrawalRecordId":28288511362048,"poundage":6,"state":3,"transferAmount":94,"type":1,"updateTime":1508146813000,"withdrawalWay":1},{"amount":500,"createTime":1507791815000,"memberId":10004,"payWithdrawalRecordId":28288357600256,"poundage":30,"state":3,"transferAmount":470,"type":1,"updateTime":1508146812000,"withdrawalWay":2}],"searchCount":true,"size":10,"total":15}
     * code : 200
     * msg : ok
     */

    private PageBean Page;
    private int code;
    private String msg;

    public PageBean getPage() {
        return Page;
    }

    public void setPage(PageBean Page) {
        this.Page = Page;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class PageBean {
        /**
         * asc : true
         * current : 1
         * limit : 2147483647
         * offset : 0
         * offsetCurrent : 0
         * openSort : true
         * optimizeCount : false
         * orderByField :
         * pages : 2
         * records : [{"amount":1000,"createTime":1508297807000,"memberId":10004,"payWithdrawalRecordId":28806493575168,"poundage":120,"state":1,"transferAmount":880,"type":1,"withdrawalWay":1},{"amount":100,"createTime":1508228232000,"memberId":10004,"payWithdrawalRecordId":28735248921600,"poundage":12,"state":2,"transferAmount":88,"type":1,"updateTime":1508228350000,"withdrawalWay":1},{"amount":100,"createTime":1508228214000,"memberId":10004,"payWithdrawalRecordId":28735230789632,"poundage":12,"state":3,"transferAmount":88,"type":1,"updateTime":1508228382000,"withdrawalWay":1},{"amount":500,"createTime":1508227873000,"memberId":10004,"payWithdrawalRecordId":28734881120256,"poundage":60,"state":1,"transferAmount":440,"type":1,"withdrawalWay":2},{"amount":5000,"createTime":1508119000000,"memberId":10004,"payWithdrawalRecordId":28623394992128,"poundage":600,"state":1,"transferAmount":4400,"type":1,"withdrawalWay":1},{"amount":5000,"createTime":1508118514000,"memberId":10004,"payWithdrawalRecordId":28622897778688,"poundage":600,"state":1,"transferAmount":4400,"type":1,"withdrawalWay":1},{"amount":1800,"createTime":1507861687000,"memberId":10004,"payWithdrawalRecordId":28359906620416,"poundage":216,"state":3,"transferAmount":1584,"type":1,"updateTime":1508146874000,"withdrawalWay":1},{"amount":1000,"createTime":1507792859000,"memberId":10004,"payWithdrawalRecordId":28289426666496,"poundage":60,"state":3,"transferAmount":940,"type":1,"updateTime":1508146813000,"withdrawalWay":2},{"amount":100,"createTime":1507791965000,"memberId":10004,"payWithdrawalRecordId":28288511362048,"poundage":6,"state":3,"transferAmount":94,"type":1,"updateTime":1508146813000,"withdrawalWay":1},{"amount":500,"createTime":1507791815000,"memberId":10004,"payWithdrawalRecordId":28288357600256,"poundage":30,"state":3,"transferAmount":470,"type":1,"updateTime":1508146812000,"withdrawalWay":2}]
         * searchCount : true
         * size : 10
         * total : 15
         */

        private boolean asc;
        private int current;
        private long limit;
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

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public long getLimit() {
            return limit;
        }

        public void setLimit(long limit) {
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
             * amount : 1000
             * createTime : 1508297807000
             * memberId : 10004
             * payWithdrawalRecordId : 28806493575168
             * poundage : 120
             * state : 1
             * transferAmount : 880
             * type : 1
             * withdrawalWay : 1
             * updateTime : 1508228350000
             */

            private double amount;
            private long createTime;
            private long memberId;
            private long payWithdrawalRecordId;
            private double poundage;
            private int state;
            private double transferAmount;
            private int type;
            private int withdrawalWay;
            private long updateTime;

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getMemberId() {
                return memberId;
            }

            public void setMemberId(long memberId) {
                this.memberId = memberId;
            }

            public long getPayWithdrawalRecordId() {
                return payWithdrawalRecordId;
            }

            public void setPayWithdrawalRecordId(long payWithdrawalRecordId) {
                this.payWithdrawalRecordId = payWithdrawalRecordId;
            }

            public double getPoundage() {
                return poundage;
            }

            public void setPoundage(double poundage) {
                this.poundage = poundage;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public double getTransferAmount() {
                return transferAmount;
            }

            public void setTransferAmount(double transferAmount) {
                this.transferAmount = transferAmount;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getWithdrawalWay() {
                return withdrawalWay;
            }

            public void setWithdrawalWay(int withdrawalWay) {
                this.withdrawalWay = withdrawalWay;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
