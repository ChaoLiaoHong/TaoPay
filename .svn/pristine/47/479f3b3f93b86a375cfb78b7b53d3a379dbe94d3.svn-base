package com.hmkj.taozhifu.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

/**
 * Created by wxd on 2016/7/5.
 * 去除Emoji表情输入
 */
public class EmojiEditText extends AppCompatEditText implements TextWatcher {

    private Context context;
    private boolean isAllowInputEmoji;


    public EmojiEditText(Context context) {
        this(context, null);
    }

    public EmojiEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmojiEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        addTextChangedListener(this);
        setIsAllowInputEmoji(false);
    }

    public boolean isAllowInputEmoji() {
        return isAllowInputEmoji;
    }

    /**
     * 允许输入Emoji表情，默认不允许输入Emoji表情
     *
     * @param isAllowInputEmoji 是否允许
     */
    public void setIsAllowInputEmoji(boolean isAllowInputEmoji) {
        this.isAllowInputEmoji = isAllowInputEmoji;
    }

    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        if (!isAllowInputEmoji()) {
            if (count >= 2) {
                CharSequence input = charSequence.subSequence(start, start + count);
                if (containsEmoji(input.toString())) {
                    setIsAllowInputEmoji(true);
//                    AlertUtil.showToast(context, "暂不支持输入表情符号");
                    setText(inputAfterText);
                    CharSequence text = getText();
                    if (text != null) {
                        Spannable spanText = (Spannable) text;
                        Selection.setSelection(spanText, text.length());
                    }
                }
            }
        } else {
            setIsAllowInputEmoji(false);
        }
    }

    //输入表情前EditText中的文本
    private String inputAfterText;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (!isAllowInputEmoji()) {
            // 这里用s.toString()而不直接用s是因为如果用s，
            // 那么，inputAfterText和s在内存中指向的是同一个地址，s改变了，
            // inputAfterText也就改变了，那么表情过滤就失败了
            inputAfterText = s.toString();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }


    private boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmojiCharacter(char codePoint) {
        return TextUtils.isEmpty(String.valueOf(codePoint)) ?
                false :
                (codePoint == 0x0)
                        || (codePoint == 0x9)
                        || (codePoint == 0xA)
                        || (codePoint == 0xD)
                        || ((codePoint >= 0x20)
                        && (codePoint <= 0xD7FF))
                        || ((codePoint >= 0xE000)
                        && (codePoint <= 0xFFFD))
                        || ((codePoint >= 0x10000));
    }


}
