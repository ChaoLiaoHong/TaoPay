package com.hmkj.taozhifu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/30
 */

public class CommodityDetailedEntity extends BaseEntity implements Serializable {

    /**
     * map : {"proShop":{"shopCommentStart":0,"auditState":2,"shopDiscount":100,"remark":"","classId":1,"state":2,"businessStartTime":"00:00","businessStopTime":"23:59","shopSignage":"sfs","shopAddress":"成都市天府广场四川科技馆","shopCollectionNum":0,"shopCommentNum":0,"licenseNo":"1234","businessLicense":"1234","refuseReason":"","shopId":900236357702713344,"shopName":"小区商店","shopEnvironmentImgs":[],"shopIntroduce":"","shopServices":"WIFI，免费停车，茶水，糕点，聚会，其他","longitude":104.072276,"latitude":30.66614,"avgSpend":50,"shopPhone":"13340745296","shopCommentSum":0},"proCommodity":{"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":1,"commodityImg":"http://","commodityName":"红薯","commodityPrice":5,"createBy":"lk","createTime":1502874511000,"endTime":1502874494000,"quantity":30,"ruleDescr":"随意","shopId":900236357702713344,"startTime":1502874490000,"totalNum":200,"type":1,"upState":2,"updateBy":"lk","updateTime":1502874521000}}
     */

    private MapBean map;

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public static class MapBean implements Serializable {
        /**
         * proShop : {"shopCommentStart":0,"auditState":2,"shopDiscount":100,"remark":"","classId":1,"state":2,"businessStartTime":"00:00","businessStopTime":"23:59","shopSignage":"sfs","shopAddress":"成都市天府广场四川科技馆","shopCollectionNum":0,"shopCommentNum":0,"licenseNo":"1234","businessLicense":"1234","refuseReason":"","shopId":900236357702713344,"shopName":"小区商店","shopEnvironmentImgs":[],"shopIntroduce":"","shopServices":"WIFI，免费停车，茶水，糕点，聚会，其他","longitude":104.072276,"latitude":30.66614,"avgSpend":50,"shopPhone":"13340745296","shopCommentSum":0}
         * proCommodity : {"brandName":"农产品","checkState":2,"classId":1,"commodityDescr":"随意测试商品介绍","commodityId":1,"commodityImg":"http://","commodityName":"红薯","commodityPrice":5,"createBy":"lk","createTime":1502874511000,"endTime":1502874494000,"quantity":30,"ruleDescr":"随意","shopId":900236357702713344,"startTime":1502874490000,"totalNum":200,"type":1,"upState":2,"updateBy":"lk","updateTime":1502874521000}
         */

        private ProShopBean proShop;
        private List<ImgListBean> imgList;
        private int count;
        private ProCommodityBean proCommodity;

        public List<ImgListBean> getImgList() {
            return imgList;
        }

        public void setImgList(List<ImgListBean> imgList) {
            this.imgList = imgList;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public ProShopBean getProShop() {
            return proShop;
        }

        public void setProShop(ProShopBean proShop) {
            this.proShop = proShop;
        }

        public ProCommodityBean getProCommodity() {
            return proCommodity;
        }

        public void setProCommodity(ProCommodityBean proCommodity) {
            this.proCommodity = proCommodity;
        }

        public static class ImgListBean implements Serializable {
            private long commodityId;
            private long commodityImgId;
            private String imgUrl;

            public long getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(long commodityId) {
                this.commodityId = commodityId;
            }

            public long getCommodityImgId() {
                return commodityImgId;
            }

            public void setCommodityImgId(long commodityImgId) {
                this.commodityImgId = commodityImgId;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class ProShopBean implements Serializable {
            /**
             * shopCommentStart : 0
             * auditState : 2
             * shopDiscount : 100
             * remark :
             * classId : 1
             * state : 2
             * businessStartTime : 00:00
             * businessStopTime : 23:59
             * shopSignage : sfs
             * shopAddress : 成都市天府广场四川科技馆
             * shopCollectionNum : 0
             * shopCommentNum : 0
             * licenseNo : 1234
             * businessLicense : 1234
             * refuseReason :
             * shopId : 900236357702713344
             * shopName : 小区商店
             * shopEnvironmentImgs : []
             * shopIntroduce :
             * shopServices : WIFI，免费停车，茶水，糕点，聚会，其他
             * longitude : 104.072276
             * latitude : 30.66614
             * avgSpend : 50
             * shopPhone : 13340745296
             * shopCommentSum : 0
             */

            private int shopCommentStart;
            private int auditState;
            private int shopDiscount;
            private String remark;
            private long classId;
            private int state;
            private String businessStartTime;
            private String businessStopTime;
            private String shopSignage;
            private String shopAddress;
            private int shopCollectionNum;
            private int shopCommentNum;
            private String licenseNo;
            private String businessLicense;
            private String refuseReason;
            private long shopId;
            private String shopName;
            private String shopIntroduce;
            private String shopServices;
            private double longitude;
            private double latitude;
            private double avgSpend;
            private String shopPhone;
            private int shopCommentSum;
            private List<?> shopEnvironmentImgs;
            private int rebateIntegralMember;

            public int getRebateIntegralMember() {
                return rebateIntegralMember;
            }

            public void setRebateIntegralMember(int rebateIntegralMember) {
                this.rebateIntegralMember = rebateIntegralMember;
            }

            public int getShopCommentStart() {
                return shopCommentStart;
            }

            public void setShopCommentStart(int shopCommentStart) {
                this.shopCommentStart = shopCommentStart;
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public long getClassId() {
                return classId;
            }

            public void setClassId(long classId) {
                this.classId = classId;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getBusinessStartTime() {
                return businessStartTime;
            }

            public void setBusinessStartTime(String businessStartTime) {
                this.businessStartTime = businessStartTime;
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

            public int getShopCommentNum() {
                return shopCommentNum;
            }

            public void setShopCommentNum(int shopCommentNum) {
                this.shopCommentNum = shopCommentNum;
            }

            public String getLicenseNo() {
                return licenseNo;
            }

            public void setLicenseNo(String licenseNo) {
                this.licenseNo = licenseNo;
            }

            public String getBusinessLicense() {
                return businessLicense;
            }

            public void setBusinessLicense(String businessLicense) {
                this.businessLicense = businessLicense;
            }

            public String getRefuseReason() {
                return refuseReason;
            }

            public void setRefuseReason(String refuseReason) {
                this.refuseReason = refuseReason;
            }

            public long getShopId() {
                return shopId;
            }

            public void setShopId(long shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopIntroduce() {
                return shopIntroduce;
            }

            public void setShopIntroduce(String shopIntroduce) {
                this.shopIntroduce = shopIntroduce;
            }

            public String getShopServices() {
                return shopServices;
            }

            public void setShopServices(String shopServices) {
                this.shopServices = shopServices;
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

            public int getShopCommentSum() {
                return shopCommentSum;
            }

            public void setShopCommentSum(int shopCommentSum) {
                this.shopCommentSum = shopCommentSum;
            }

            public List<?> getShopEnvironmentImgs() {
                return shopEnvironmentImgs;
            }

            public void setShopEnvironmentImgs(List<?> shopEnvironmentImgs) {
                this.shopEnvironmentImgs = shopEnvironmentImgs;
            }
        }

        public static class ProCommodityBean implements Serializable {
            /**
             * brandName : 农产品
             * checkState : 2
             * classId : 1
             * commodityDescr : 随意测试商品介绍
             * commodityId : 1
             * commodityImg : http://
             * commodityName : 红薯
             * commodityPrice : 5
             * createBy : lk
             * createTime : 1502874511000
             * endTime : 1502874494000
             * quantity : 30
             * ruleDescr : 随意
             * shopId : 900236357702713344
             * startTime : 1502874490000
             * totalNum : 200
             * type : 1
             * upState : 2
             * updateBy : lk
             * updateTime : 1502874521000
             */

            private String brandName;
            private int checkState;
            private long classId;
            private String commodityDescr;
            private long commodityId;
            private String commodityImg;
            private String commodityName;
            private double commodityPrice;
            private String createBy;
            private long createTime;
            private long endTime;
            private int quantity;
            private String ruleDescr;
            private long shopId;
            private long startTime;
            private int totalNum;
            private int type;
            private int upState;
            private String updateBy;
            private long updateTime;
            private int isReturn;

            public int getIsReturn() {
                return isReturn;
            }

            public void setIsReturn(int isReturn) {
                this.isReturn = isReturn;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getCheckState() {
                return checkState;
            }

            public void setCheckState(int checkState) {
                this.checkState = checkState;
            }

            public long getClassId() {
                return classId;
            }

            public void setClassId(long classId) {
                this.classId = classId;
            }

            public String getCommodityDescr() {
                return commodityDescr;
            }

            public void setCommodityDescr(String commodityDescr) {
                this.commodityDescr = commodityDescr;
            }

            public long getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(long commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityImg() {
                return commodityImg;
            }

            public void setCommodityImg(String commodityImg) {
                this.commodityImg = commodityImg;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public double getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(double commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getRuleDescr() {
                return ruleDescr;
            }

            public void setRuleDescr(String ruleDescr) {
                this.ruleDescr = ruleDescr;
            }

            public long getShopId() {
                return shopId;
            }

            public void setShopId(long shopId) {
                this.shopId = shopId;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public int getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(int totalNum) {
                this.totalNum = totalNum;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUpState() {
                return upState;
            }

            public void setUpState(int upState) {
                this.upState = upState;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
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
