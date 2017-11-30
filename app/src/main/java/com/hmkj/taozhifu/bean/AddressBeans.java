package com.hmkj.taozhifu.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class AddressBeans {

    public List<AddressBean> address;

    public static class AddressBean {
        /**
         * city : [{"area":["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"],"name":"北京"}]
         * name : 北京
         */

        public String name;
        public List<CityBean> city;

        public static class CityBean {
            /**
             * area : ["东城区","西城区","崇文区","宣武区","朝阳区","丰台区","石景山区","海淀区","门头沟区","房山区","通州区","顺义区","昌平区","大兴区","平谷区","怀柔区","密云县","延庆县"]
             * name : 北京
             */

            public String name;
            public ArrayList<String> area;
        }
    }
}
