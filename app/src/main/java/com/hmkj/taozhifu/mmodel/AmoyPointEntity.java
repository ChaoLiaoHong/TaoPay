package com.hmkj.taozhifu.mmodel;


import com.hmkj.taozhifu.bean.BaseEntity;

/**
 * Created by Administrator on 2017/8/28.
 */

public class AmoyPointEntity extends BaseEntity {
    /**
     * MemberAcount : {"amount":1,"amountGoods":0,"businessCoupon":1,"cashCoupon":1,"ckcomLevel":0,"dot":1,"idCard":"1","integral":1,"memberAccountId":24,"memberId":24,"memberLevel":1,"payPassWord":"1","phone":"1","state":1,"validation":1}
     */

    private MemberAcountBean MemberAcount;

    public MemberAcountBean getMemberAcount() {
        return MemberAcount;
    }

    public void setMemberAcount(MemberAcountBean MemberAcount) {
        this.MemberAcount = MemberAcount;
    }

    public static class MemberAcountBean {
        /**
         * amount : 1.0
         * amountGoods : 0
         * businessCoupon : 1.0
         * cashCoupon : 1.0
         * ckcomLevel : 0
         * dot : 1
         * idCard : 1
         * integral : 1
         * memberAccountId : 24
         * memberId : 24
         * memberLevel : 1
         * payPassWord : 1
         * phone : 1
         * state : 1
         * validation : 1
         */

        private double amount;
        private double amountGoods;
        private double businessCoupon;
        private double cashCoupon;
        private int ckcomLevel;
        private int dot;
        private String idCard;
        private int integral;
        private Long memberAccountId;
        private Long memberId;
        private int memberLevel;
        private String payPassWord;
        private String phone;
        private int state;
        private int validation;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getAmountGoods() {
            return amountGoods;
        }

        public void setAmountGoods(double amountGoods) {
            this.amountGoods = amountGoods;
        }

        public double getBusinessCoupon() {
            return businessCoupon;
        }

        public void setBusinessCoupon(double businessCoupon) {
            this.businessCoupon = businessCoupon;
        }

        public double getCashCoupon() {
            return cashCoupon;
        }

        public void setCashCoupon(double cashCoupon) {
            this.cashCoupon = cashCoupon;
        }

        public int getCkcomLevel() {
            return ckcomLevel;
        }

        public void setCkcomLevel(int ckcomLevel) {
            this.ckcomLevel = ckcomLevel;
        }

        public int getDot() {
            return dot;
        }

        public void setDot(int dot) {
            this.dot = dot;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public Long getMemberAccountId() {
            return memberAccountId;
        }

        public void setMemberAccountId(Long memberAccountId) {
            this.memberAccountId = memberAccountId;
        }

        public Long getMemberId() {
            return memberId;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }

        public int getMemberLevel() {
            return memberLevel;
        }

        public void setMemberLevel(int memberLevel) {
            this.memberLevel = memberLevel;
        }

        public String getPayPassWord() {
            return payPassWord;
        }

        public void setPayPassWord(String payPassWord) {
            this.payPassWord = payPassWord;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getValidation() {
            return validation;
        }

        public void setValidation(int validation) {
            this.validation = validation;
        }
    }
}
