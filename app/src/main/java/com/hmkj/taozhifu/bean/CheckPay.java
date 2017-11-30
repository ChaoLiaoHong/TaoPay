package com.hmkj.taozhifu.bean;

/**
 * Created by LiaoDuanHong  on 2017/10/11
 */

public class CheckPay {

    /**
     * aliAccount : {"createTime":1507712180000,"memberId":10004,"payWithdrawalAliId":28206811735040,"payeeAccount":"457751921","payeeRealName":"廖端洪"}
     * hasPass : true
     * code : 200
     * weixAccount : {"createTime":1507713701000,"memberId":10004,"openId":"os5IIxGLILHa75gzeESfepvEblhQ","payWithdrawalWxId":28208368984064,"reUserName":"廖端洪"}
     * msg : ok
     */

    private AliAccountBean aliAccount;
    private boolean hasPass;
    private int code;
    private WeixAccountBean weixAccount;
    private String msg;

    public AliAccountBean getAliAccount() {
        return aliAccount;
    }

    public void setAliAccount(AliAccountBean aliAccount) {
        this.aliAccount = aliAccount;
    }

    public boolean isHasPass() {
        return hasPass;
    }

    public void setHasPass(boolean hasPass) {
        this.hasPass = hasPass;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public WeixAccountBean getWeixAccount() {
        return weixAccount;
    }

    public void setWeixAccount(WeixAccountBean weixAccount) {
        this.weixAccount = weixAccount;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class AliAccountBean {
        /**
         * createTime : 1507712180000
         * memberId : 10004
         * payWithdrawalAliId : 28206811735040
         * payeeAccount : 457751921
         * payeeRealName : 廖端洪
         */

        private long createTime;
        private long memberId;
        private long payWithdrawalAliId;
        private String payeeAccount;
        private String payeeRealName;

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

        public long getPayWithdrawalAliId() {
            return payWithdrawalAliId;
        }

        public void setPayWithdrawalAliId(long payWithdrawalAliId) {
            this.payWithdrawalAliId = payWithdrawalAliId;
        }

        public String getPayeeAccount() {
            return payeeAccount;
        }

        public void setPayeeAccount(String payeeAccount) {
            this.payeeAccount = payeeAccount;
        }

        public String getPayeeRealName() {
            return payeeRealName;
        }

        public void setPayeeRealName(String payeeRealName) {
            this.payeeRealName = payeeRealName;
        }
    }

    public static class WeixAccountBean {
        /**
         * createTime : 1507713701000
         * memberId : 10004
         * openId : os5IIxGLILHa75gzeESfepvEblhQ
         * payWithdrawalWxId : 28208368984064
         * reUserName : 廖端洪
         */

        private long createTime;
        private long memberId;
        private String openId;
        private long payWithdrawalWxId;
        private String reUserName;

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

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public long getPayWithdrawalWxId() {
            return payWithdrawalWxId;
        }

        public void setPayWithdrawalWxId(long payWithdrawalWxId) {
            this.payWithdrawalWxId = payWithdrawalWxId;
        }

        public String getReUserName() {
            return reUserName;
        }

        public void setReUserName(String reUserName) {
            this.reUserName = reUserName;
        }
    }
}
