package com.hmkj.taozhifu.bean;

import java.util.List;

/**
 * Created by LiaoDuanHong  on 2017/8/18
 */

public class ShopClassifyEntity {

    /**
     * data : [{"imgUrl":"","pId":0,"level":1,"classId":2,"className":"超市","underClass":[{"imgUrl":"","pId":2,"level":2,"classId":11,"className":"代金券"},{"imgUrl":"","pId":2,"level":2,"classId":12,"className":"甜点饮品"},{"imgUrl":"","pId":2,"level":2,"classId":13,"className":"生日蛋糕"},{"imgUrl":"","pId":2,"level":2,"classId":14,"className":"火锅"},{"imgUrl":"","pId":2,"level":2,"classId":15,"className":"自助餐"},{"imgUrl":"","pId":2,"level":2,"classId":16,"className":"小吃快餐"},{"imgUrl":"","pId":2,"level":2,"classId":21,"className":"便利店"},{"imgUrl":"","pId":2,"level":2,"classId":22,"className":"连锁超市"}]},{"imgUrl":"112","pId":0,"level":1,"classId":1,"className":"夏继芬2","underClass":[]},{"imgUrl":"","pId":0,"level":1,"classId":4,"className":"美食","underClass":[]},{"imgUrl":"14234","pId":0,"level":1,"classId":898419518127366144,"className":"1234","underClass":[]},{"imgUrl":"胜多负少的","pId":0,"level":1,"classId":898420965699117056,"className":"似懂非懂","underClass":[]}]
     * code : 200
     * msg : ok
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imgUrl :
         * pId : 0
         * level : 1
         * classId : 2
         * className : 超市
         * underClass : [{"imgUrl":"","pId":2,"level":2,"classId":11,"className":"代金券"},{"imgUrl":"","pId":2,"level":2,"classId":12,"className":"甜点饮品"},{"imgUrl":"","pId":2,"level":2,"classId":13,"className":"生日蛋糕"},{"imgUrl":"","pId":2,"level":2,"classId":14,"className":"火锅"},{"imgUrl":"","pId":2,"level":2,"classId":15,"className":"自助餐"},{"imgUrl":"","pId":2,"level":2,"classId":16,"className":"小吃快餐"},{"imgUrl":"","pId":2,"level":2,"classId":21,"className":"便利店"},{"imgUrl":"","pId":2,"level":2,"classId":22,"className":"连锁超市"}]
         */

        private String imgUrl;
        private long pId;
        private int level;
        private long classId;
        private String className;
        private List<UnderClassBean> underClass;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public long getPId() {
            return pId;
        }

        public void setPId(long pId) {
            this.pId = pId;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public long getClassId() {
            return classId;
        }

        public void setClassId(long classId) {
            this.classId = classId;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public List<UnderClassBean> getUnderClass() {
            return underClass;
        }

        public void setUnderClass(List<UnderClassBean> underClass) {
            this.underClass = underClass;
        }

        public static class UnderClassBean {
            /**
             * imgUrl :
             * pId : 2
             * level : 2
             * classId : 11
             * className : 代金券
             */

            private String imgUrl;
            private long pId;
            private int level;
            private long classId;
            private String className;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public long getPId() {
                return pId;
            }

            public void setPId(long pId) {
                this.pId = pId;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public long getClassId() {
                return classId;
            }

            public void setClassId(long classId) {
                this.classId = classId;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }
        }
    }
}
