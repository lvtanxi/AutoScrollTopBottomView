package com.xf.autoscrolltopbottomview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * User: 吕勇
 * Date: 2016-07-24
 * Time: 07:14
 * Description:侧滑删除
 */
public class SlideMenuView extends FrameLayout {
    private final int ANI_TIME = 800;
    private float mLastActionDownX;
    private View mMenuView;
    private ViewGroup mContentView;
    private Scroller mScroller;
    private MotionEvent mLastMoveEvent;

    public SlideMenuView(Context context) {
        this(context, null);
    }

    public SlideMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 2)
            throw new IllegalStateException("only and should contain two child view");
        mMenuView = getChildAt(0);
        FrameLayout.LayoutParams params = (LayoutParams) mMenuView.getLayoutParams();
        params.gravity = Gravity.END;
        mMenuView.setLayoutParams(params);
        if (!(getChildAt(1) instanceof ViewGroup))
            throw new IllegalStateException("top view should be contained by a viewgroup");
        mContentView = (ViewGroup) getChildAt(1);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = null;
        if (mContentView.getChildCount() > 0)
            view = mContentView.getChildAt(0);
        if (view == null)
            return super.dispatchTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastActionDownX = ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                float distance = ev.getRawX() - mLastActionDownX;
                mLastActionDownX = ev.getRawX();
                mLastMoveEvent = ev;
                if (!mScroller.computeScrollOffset()) {
                    Log.d("SlideMenuView", "distance:" + distance);
                    if (distance > 0) {
                        if (Math.abs(mContentView.getMeasuredWidth() - distance) > mMenuView.getMeasuredWidth()) {
                            mContentView.scrollBy(-mContentView.getScrollX() - mMenuView.getMeasuredWidth(), 0);
                        } else {
                            mContentView.scrollBy(-(int) distance, 0);
                        }
                        sendCancelEvent();
                        return true;
                    } else {

                    }
                } else {

                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
    private void sendCancelEvent() {
        if (mLastMoveEvent == null) {
            return;
        }
        MotionEvent last = mLastMoveEvent;
        MotionEvent e = MotionEvent.obtain(last.getDownTime(), last.getEventTime() + ViewConfiguration.getLongPressTimeout(), MotionEvent.ACTION_CANCEL, last.getX(), last.getY(), last.getMetaState());
        super.dispatchTouchEvent(e);
    }

}
