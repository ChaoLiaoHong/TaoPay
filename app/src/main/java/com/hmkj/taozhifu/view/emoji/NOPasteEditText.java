package com.hmkj.taozhifu.view.emoji;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;


/**
 * @author fanj
 * @ClassName: NOPasteEditText
 * @Description: 禁用粘贴功能的EditText
 * @date 2015年10月13日 上午10:06:02
 */
public class NOPasteEditText extends AppCompatEditText {

    public NOPasteEditText(Context context) {
        super(context);
        setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        setLongClickable(false);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        setTextIsSelectable(false);
        setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }
        });
    }

    public NOPasteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NOPasteEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return new MyInputConnectionWrapper(super.onCreateInputConnection(outAttrs), false);
    }

    class MyInputConnectionWrapper extends InputConnectionWrapper {

        public MyInputConnectionWrapper(InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        @Override
        public boolean commitText(CharSequence text, int newCursorPosition) {
            if (text== null)
                return false;
            String tex = text.toString();
            if (RegexMatcherUtilse.isNotSpecialChar(tex)) {
                return super.commitText(text, newCursorPosition);
            } else {
                return false;
            }
        }

        @Override
        public boolean sendKeyEvent(KeyEvent event) {
            return super.sendKeyEvent(event);
        }
    }

}
