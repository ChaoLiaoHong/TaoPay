package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/25
 */

public class ShopDetailedEntity extends BaseEntity {

    /**
     * data : {"shopCommentStart":0,"remark":"","state":2,"businessStopTime":"23:59","shopSignage":"http://upimg.ahmkj.cn/appdata/1504593680516main.png","shopCommentNum":0,"shopId":25013466826752,"shopIntroduce":"还不来？","longitude":104.07234043,"havaShop":true,"referrerPhone":"YHNXCM","auditState":2,"shopDiscount":85,"classId":7,"businessStartTime":"00:00","shopAddress":"成都天府广场","shopCollectionNum":0,"refuseReason":"","shopName":"兰州拉面","shopEnvironmentImgs":[],"shopServices":"","latitude":30.66353451,"avgSpend":0,"shopPhone":"18181987001","shopCommentSum":0}
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
         * shopCommentStart : 0.0
         * remark :
         * state : 2
         * businessStopTime : 23:59
         * shopSignage : http://upimg.ahmkj.cn/appdata/1504593680516main.png
         * shopCommentNum : 0
         * shopId : 25013466826752
         * shopIntroduce : 还不来？
         * longitude : 104.07234043
         * havaShop : true
         * referrerPhone : YHNXCM
         * auditState : 2
         * shopDiscount : 85
         * classId : 7
         * businessStartTime : 00:00
         * shopAddress : 成都天府广场
         * shopCollectionNum : 0
         * refuseReason :
         * shopName : 兰州拉面
         * shopEnvironmentImgs : []
         * shopServices :
         * latitude : 30.66353451
         * avgSpend : 0.0
         * shopPhone : 18181987001
         * shopCommentSum : 0.0
         */

        private double shopCommentStart;
        private String remark;
        private int state;
        private String businessStopTime;
        private String shopSignage;
        private int shopCommentNum;
        private long shopId;
        private String shopIntroduce;
        private double longitude;
        private boolean havaShop;
        private String referrerPhone;
        private int auditState;
        private int shopDiscount;
        private long classId;
        private String businessStartTime;
        private String shopAddress;
        private int shopCollectionNum;
        private String refuseReason;
        private String shopName;
        private String shopServices;
        private double latitude;
        private double avgSpend;
        private String shopPhone;
        private double shopCommentSum;
        private int rebateIntegralMember;

        private List<String> shopEnvironmentImgs;

        public int getRebateIntegralMember() {
            return rebateIntegralMember;
        }

        public void setRebateIntegralMember(int rebateIntegralMember) {
            this.rebateIntegralMember = rebateIntegralMember;
        }

        public double getShopCommentStart() {
            return shopCommentStart;
        }

        public void setShopCommentStart(double shopCommentStart) {
            this.shopCommentStart = shopCommentStart;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getBusinessStopTime() {
            return businessStopTime;
        }

        public void setBusinessStopTime(String businessStopTime) {
            this.businessStopTime = businessStopTime;
        }

        public String getShopSignage() {
            return shopSignage;
        }

        public void setShopSignage(String shopSignage) {
            this.shopSignage = shopSignage;
        }

        public int getShopCommentNum() {
            return shopCommentNum;
        }

        public void setShopCommentNum(int shopCommentNum) {
            this.shopCommentNum = shopCommentNum;
        }

        public long getShopId() {
            return shopId;
        }

        public void setShopId(long shopId) {
            this.shopId = shopId;
        }

        public String getShopIntroduce() {
            return shopIntroduce;
        }

        public void setShopIntroduce(String shopIntroduce) {
            this.shopIntroduce = shopIntroduce;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public boolean isHavaShop() {
            return havaShop;
        }

        public void setHavaShop(boolean havaShop) {
            this.havaShop = havaShop;
        }

        public String getReferrerPhone() {
            return referrerPhone;
        }

        public void setReferrerPhone(String referrerPhone) {
            this.referrerPhone = referrerPhone;
        }

        public int getAuditState() {
            return auditState;
        }

        public void setAuditState(int auditState) {
            this.auditState = auditState;
        }

        public int getShopDiscount() {
            return shopDiscount;
        }

        public void setShopDiscount(int shopDiscount) {
            this.shopDiscount = shopDiscount;
        }

        public long getClassId() {
            return classId;
        }

        public void setClassId(long classId) {
            this.classId = classId;
        }

        public String getBusinessStartTime() {
            return businessStartTime;
        }

        public void setBusinessStartTime(String businessStartTime) {
            this.businessStartTime = businessStartTime;
        }

        public String getShopAddress() {
            return shopAddress;
        }

        public void setShopAddress(String shopAddress) {
            this.shopAddress = shopAddress;
        }

        public int getShopCollectionNum() {
            return shopCollectionNum;
        }

        public void setShopCollectionNum(int shopCollectionNum) {
            this.shopCollectionNum = shopCollectionNum;
        }

        public String getRefuseReason() {
            return refuseReason;
        }

        public void setRefuseReason(String refuseReason) {
            this.refuseReason = refuseReason;
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
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

        public double getShopCommentSum() {
            return shopCommentSum;
        }

        public void setShopCommentSum(double shopCommentSum) {
            this.shopCommentSum = shopCommentSum;
        }

        public List<String> getShopEnvironmentImgs() {
            return shopEnvironmentImgs;
        }

        public void setShopEnvironmentImgs(List<String> shopEnvironmentImgs) {
            this.shopEnvironmentImgs = shopEnvironmentImgs;
        }
    }
}
