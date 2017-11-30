package com.hmkj.taozhifu.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by LiaoDuanHong  on 2017/3/14
 */

public class NoScrollGridView extends GridView {
    private OnTouchInvalidPositionListener onTouchInvalidPositionListener;
    public NoScrollGridView(Context context) {
        this(context,null);
    }

    public NoScrollGridView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NoScrollGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //先创建一个监听接口，一旦点击了无效区域，便实现onTouchInvalidPosition方法，返回true or false来确认是否消费了这个事件
        if(onTouchInvalidPositionListener!=null){
            if(!isEnabled()){
                return isClickable()||isLongClickable();
            }
            int motionPosition = pointToPosition((int)ev.getX(), (int)ev.getY());
            if(ev.getAction()==MotionEvent.ACTION_UP&&motionPosition == INVALID_POSITION){
                super.onTouchEvent(ev);
                return onTouchInvalidPositionListener.onTouchInvalidPosition(motionPosition);
            }
        }
        return super.onTouchEvent(ev);
    }

    public void setOnTouchInvalidPositionListener(
            OnTouchInvalidPositionListener onTouchInvalidPositionListener) {
        this.onTouchInvalidPositionListener = onTouchInvalidPositionListener;
    }

    public interface OnTouchInvalidPositionListener{
        public boolean onTouchInvalidPosition(int motionEvent);
    }

}
