package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class ShopDiscointListBean {

    /**
     * data : [{"discountName":"9.5折","discountValue":95,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":1},{"discountName":"9折","discountValue":90,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":2},{"discountName":"8.5折","discountValue":85,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":3},{"discountName":"8折","discountValue":80,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":4},{"discountName":"7.5折","discountValue":75,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":5},{"discountName":"7折","discountValue":70,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":6},{"discountName":"6.5折","discountValue":65,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":7},{"discountName":"6折","discountValue":60,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":8},{"discountName":"5.5折","discountValue":55,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":9},{"discountName":"5折","discountValue":50,"rebateCondition":0,"rebateIntegralMember":8,"rebateIntegralMerchant":2,"shopDiscountId":10}]
     * code : 200
     * msg : ok
     */

    public int code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * discountName : 9.5折
         * discountValue : 95
         * rebateCondition : 0
         * rebateIntegralMember : 8
         * rebateIntegralMerchant : 2
         * shopDiscountId : 1
         */

        public String discountName;
        public int discountValue;
        public int rebateCondition;
        public int rebateIntegralMember;
        public int rebateIntegralMerchant;
        public int shopDiscountId;
    }
}
