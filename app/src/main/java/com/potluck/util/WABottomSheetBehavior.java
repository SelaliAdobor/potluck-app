package com.potluck.util;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/***
 * @author Ray W (StackOverflow)
 * Source: https://stackoverflow.com/a/36775907/3808828
 */
public class WABottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    private boolean mAllowUserDragging = false;
    /**
     * Default constructor for instantiating BottomSheetBehaviors.
     */
    public WABottomSheetBehavior() {
        super();
    }

    /**
     * Default constructor for inflating BottomSheetBehaviors from layout.
     *
     * @param context The {@link Context}.
     * @param attrs   The {@link AttributeSet}.
     */
    public WABottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAllowUserDragging(boolean allowUserDragging) {
        mAllowUserDragging = allowUserDragging;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!mAllowUserDragging) {
            return false;
        }
        return super.onInterceptTouchEvent(parent, child, event);
    }
}
