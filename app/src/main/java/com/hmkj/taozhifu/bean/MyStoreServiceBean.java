package com.hmkj.taozhifu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class MyStoreServiceBean {
    public MyStoreServiceBean() {
        for (String s : dataBean()) {
            DataBean dataBean = new DataBean();
            dataBean.name = s;
            data.add(dataBean);
        }
    }

    public List<DataBean> data = new ArrayList<>();

    public static class DataBean implements Serializable {
        public String name;
        /**
         * 不能动这个
         */
        public Boolean isCheck = false;
    }

    public ArrayList<String> dataBean() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("免费WiFi");
        strings.add("免费停车");
        strings.add("免费茶水");
        strings.add("免费糕点");
        strings.add("免费聚会");
        strings.add("其它");
        return strings;
    }
}
