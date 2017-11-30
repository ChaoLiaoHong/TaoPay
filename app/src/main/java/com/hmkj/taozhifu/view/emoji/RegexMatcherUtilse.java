package com.hmkj.taozhifu.view.emoji;

/**
 * Created by Administrator on 2016/12/27.
 */

public class RegexMatcherUtilse {
    /**
     * 中文
     */
    public static final String ZHONGWEN = "^[\u4e00-\u9fa5]+$";
    /**
     * 非特殊字符
     */
    public static final String NOT_SPECIAL_CHARACTER = "[`~!@#$%^&*()\\s+-=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    /**
     * 数字或英文
     */
    public static final String CHAR_OR_NUMBER = "[a-zA-Z]*[\\d]*";
    /**
     * 中英文混输
     */
    public static final String CHAR_OR_ZHONGWEN = "^[\u4E00-\u9FA5A-Za-z0-9_]+$";

    public static boolean isNotSpecialChar(String str) {
        str = str == null ? "" : str;
        return str.matches(NOT_SPECIAL_CHARACTER) || str.matches(ZHONGWEN) || str.matches(CHAR_OR_NUMBER)
                || str.equals("……") || str.equals("～") || str.matches(CHAR_OR_ZHONGWEN);
    }
}
