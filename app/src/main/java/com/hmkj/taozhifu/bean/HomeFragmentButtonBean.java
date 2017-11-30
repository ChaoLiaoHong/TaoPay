package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */

public class HomeFragmentButtonBean {

    /**
     * data : [{"buttonConfigId":24558003601408,"buttonImg":"123","buttonName":"代金券","buttonPlace":1,"buttonType":1,"buttonValue":"2","classLevel":2,"createBy":0,"createTime":1504148891000,"updateBy":0,"updateTime":null},{"buttonConfigId":24558099790848,"buttonImg":"1234","buttonName":"甜点饮品","buttonPlace":2,"buttonType":1,"buttonValue":"3","classLevel":2,"createBy":0,"createTime":1504148985000,"updateBy":0,"updateTime":null},{"buttonConfigId":25280194566144,"buttonImg":"http://st.cdn1.yestone.com/thumbs/1930953/image/3615/36151895/api_thumb_450.jpg","buttonName":"按钮","buttonPlace":3,"buttonType":1,"buttonValue":"2","classLevel":2,"createBy":0,"createTime":1504854156000,"updateBy":0,"updateTime":null}]
     * code : 200
     * msg : ok
     */

    public int code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * buttonConfigId : 24558003601408
         * buttonImg : 123
         * buttonName : 代金券
         * buttonPlace : 1
         * buttonType : 1
         * buttonValue : 2
         * classLevel : 2
         * createBy : 0
         * createTime : 1504148891000
         * updateBy : 0
         * updateTime : null
         */

        public long buttonConfigId;
        public String buttonImg;
        public String buttonName;
        public int buttonPlace;
        public int buttonType;
        public String buttonValue;
        public int classLevel;
        public int createBy;
        public long createTime;
        public int updateBy;
        public long updateTime;
    }
}
