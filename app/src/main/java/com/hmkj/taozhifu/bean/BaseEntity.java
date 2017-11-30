package com.hmkj.taozhifu.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/23.
 */

public class BaseEntity implements Serializable {
    private long timestamp;
    private String msg;
    private int code;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setHttpCode(int httpCode) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public int getHttpCode() {
        return code;
    }
}
