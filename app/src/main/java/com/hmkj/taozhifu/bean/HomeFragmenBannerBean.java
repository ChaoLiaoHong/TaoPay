package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class HomeFragmenBannerBean {

    /**
     * data : [{"adverKeyId":"http://gank.io/2017/09/05","adverName":"这是一个广告","adverUrl":"https://ws1.sinaimg.cn/large/610dc034ly1fj78mpyvubj20u011idjg.jpg","adverValue":"","clickCount":0,"contentType":2,"createTime":null,"endTime":null,"placeId":0,"proAdverId":25286791755776,"startTime":null}]
     * code : 200
     * msg : ok
     */

    public int code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * adverKeyId : http://gank.io/2017/09/05
         * adverName : 这是一个广告
         * adverUrl : https://ws1.sinaimg.cn/large/610dc034ly1fj78mpyvubj20u011idjg.jpg
         * adverValue :
         * clickCount : 0
         * contentType : 2
         * createTime : null
         * endTime : null
         * placeId : 0
         * proAdverId : 25286791755776
         * startTime : null
         */

        public String adverKeyId;
        public String adverName;
        public String adverUrl;
        public String adverValue;
        public int clickCount;
        public int contentType;
        public Object createTime;
        public Object endTime;
        public int placeId;
        public long proAdverId;
        public Object startTime;
    }
}
