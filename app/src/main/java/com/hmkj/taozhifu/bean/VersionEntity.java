package com.hmkj.taozhifu.bean;

/**
 * Created by Administrator on 2017/10/17.
 */

public class VersionEntity {
    /**
     * sysAppVersion : {"descr":"淘支付第二版","downloadUrl":"http","id":"2","upTime":1508222828000,"versionNo":"2.0","versionNum":2}
     * code : 200
     * msg : ok
     */

    private SysAppVersionBean sysAppVersion;
    private int code;
    private String msg;

    public SysAppVersionBean getSysAppVersion() {
        return sysAppVersion;
    }

    public void setSysAppVersion(SysAppVersionBean sysAppVersion) {
        this.sysAppVersion = sysAppVersion;
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

    public static class SysAppVersionBean {
        /**
         * descr : 淘支付第二版
         * downloadUrl : http
         * id : 2
         * upTime : 1508222828000
         * versionNo : 2.0
         * versionNum : 2
         */

        private String descr;
        private String downloadUrl;
        private String id;
        private long upTime;
        private String versionNo;
        private int versionNum;

        public String getDescr() {
            return descr;
        }

        public void setDescr(String descr) {
            this.descr = descr;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getUpTime() {
            return upTime;
        }

        public void setUpTime(long upTime) {
            this.upTime = upTime;
        }

        public String getVersionNo() {
            return versionNo;
        }

        public void setVersionNo(String versionNo) {
            this.versionNo = versionNo;
        }

        public int getVersionNum() {
            return versionNum;
        }

        public void setVersionNum(int versionNum) {
            this.versionNum = versionNum;
        }
    }
}
