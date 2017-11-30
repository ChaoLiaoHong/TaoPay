package com.hmkj.taozhifu.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/**
 * 输入小数位的控制及输入的最大长度
 * Created by LiaoDuanHong  on 2017/10/12
 */

public class NumberDecimalUtils {
    /**
     * 输入框小数的位数
     */
    private static final int DECIMAL_DIGITS = 2;

    /**
     * 需要一个editText
     *
     * @param edtMoney
     */
    public static void editText(EditText edtMoney) {
        /**
         *  设置小数位数控制
         */
        InputFilter lengthfilter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // 删除等特殊字符，直接返回
                if ("".equals(source.toString())) {
                    return null;
                }
                String dValue = dest.toString();
                String[] splitArray = dValue.split("\\.");
                if (splitArray.length > 1) {
                    String dotValue = splitArray[1];
                    int diff = dotValue.length() + 1 - DECIMAL_DIGITS;
                    if (diff > 0) {
                        return source.subSequence(start, end - diff);
                    }
                }
                return null;
            }
        };
        // 控制输入框的小数位和长度,这里长度暂时设置为9
        edtMoney.setFilters(new InputFilter[]{lengthfilter, new InputFilter.LengthFilter(9)});
    }
}
