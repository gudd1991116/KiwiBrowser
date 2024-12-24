package org.chromium.chrome.browser.ntp.ntp_hp.behavior;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import org.chromium.chrome.browser.BuildConfig;

import java.lang.ref.WeakReference;


/**
 * Created by jun xu on 19-3-4
 */
public class MisesHeaderBehavior extends MisesViewOffsetBehavior {

    public static final int DURATION_SHORT = 300;
    public static final int DURATION_LONG = 600;

    private WeakReference<CoordinatorLayout> mParent;
    private WeakReference<View> mChild;

    private OnPagerStateListener mPagerStateListener;
    MisesHeaderFlingRunnable.OnHeaderFlingListener mOnHeaderFlingListener;

    private float mLastY;
    private int mOffestY;
    private long mDownTime;
    private boolean mIsUp;
    private int mHeaderOffsetRange;
    private Context mContext;
    private int mTouchSlop;
    private MisesHeaderFlingRunnable mFlingRunnableHeader;

    private boolean mIsFling;
    private int mMinimumFlingVelocity;
    private boolean mCouldScroollOpen = true;
    private int mLastTranlationY;
    private boolean mLastStopIsClose;
    private int mLastScrollY = 0;
    private boolean mScrollFling = false;

    public MisesHeaderBehavior() {
        init();
    }

    public MisesHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public void setCouldScrollOpen(boolean couldScrollOpen) {
        mCouldScroollOpen = couldScrollOpen;
    }

    public void setOnHeaderFlingListener(MisesHeaderFlingRunnable.OnHeaderFlingListener onHeaderFlingListener) {
        mOnHeaderFlingListener = onHeaderFlingListener;
    }

    public void setPagerStateListener(OnPagerStateListener pagerStateListener) {
        mPagerStateListener = pagerStateListener;
    }

    /**
     * 定义该头部视图的滑动范围，定义滑动的最小值（负值）和最大值（通常是0）。
     * @param offsetRange
     */
    public void setHeaderOffsetRange(int offsetRange) {
        mHeaderOffsetRange = offsetRange;
    }

    private void init() {
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
    }

    @Override
    protected void layoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        super.layoutChild(parent, child, layoutDirection);
        mParent = new WeakReference<CoordinatorLayout>(parent);
        mChild = new WeakReference<View>(child);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        boolean isVertical = (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        return isVertical && !mIsFling;
    }

    private boolean canScroll(View child, float pendingDy) {
        int pendingTranslationY = (int) (child.getTranslationY() - pendingDy);
        int headerOffsetRange = getHeaderOffsetRange();
        if (pendingTranslationY >= headerOffsetRange && pendingTranslationY <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, final View child, MotionEvent ev) {
        if (mFlingRunnableHeader != null && mFlingRunnableHeader.isScrolling()){
            return true;// 如果动画还没结束，则拦截滑动r
        }

        boolean closed = isClosed();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownTime = SystemClock.currentThreadTimeMillis();
                mLastY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                mOffestY = (int) (ev.getRawY() - mLastY);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                long l = SystemClock.currentThreadTimeMillis() - mDownTime;


                if (l < 10) {
                    return false;
                }
        }

        mIsUp = mOffestY < 0;

        if (ev.getAction() == MotionEvent.ACTION_UP && Math.abs(mOffestY) > mTouchSlop) {
//            handleActionUp(parent, child);
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        //dy>0 scroll up;dy<0,scroll down
        if (mFlingRunnableHeader != null && mFlingRunnableHeader.isScrolling()){
            return ;// 如果动画还没结束，则拦截滑动r
        }
        if (dy < 0) {
            return;
        }

        float halfOfDis = dy;
        if (!canScroll(child, halfOfDis)) {
            int headerOffsetRange = getHeaderOffsetRange();
            if (child.getTranslationY() != headerOffsetRange) {
                child.setTranslationY(headerOffsetRange);
                onScrollChange(type, headerOffsetRange);
            }
        } else {
            float translationY = child.getTranslationY();
            float finalTraY = translationY - halfOfDis;
            child.setTranslationY(finalTraY);
            onScrollChange(type, (int) finalTraY);
            //consumed all scroll behavior after we started Nested Scrolling
            consumed[1] = dy;
        }
    }

    private void onScrollChange(int type, int translationY) {
        if (mPagerStateListener != null) {

            if (mLastTranlationY == translationY) {
                return;
            }

            if (translationY == 0) {
                mPagerStateListener.onPagerOpened();
            }

            mPagerStateListener.onScrollChange(mIsUp, translationY, type);
            mLastTranlationY = translationY;
            if (translationY <= mHeaderOffsetRange) {
                mPagerStateListener.onPagerClosed();
                mLastStopIsClose = true;
            }
        }
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (mFlingRunnableHeader != null && mFlingRunnableHeader.isScrolling()){
            return ;// 如果动画还没结束，则拦截滑动r
        }
        if (!mCouldScroollOpen) {
            if (isClosed(child)) {
                return;
            }
        }

        if (mIsFling || dyUnconsumed > 0) {
            return;
        }

        float translationY = child.getTranslationY() - dyUnconsumed;
        int maxHeadTranslateY = 0;
        if (translationY > maxHeadTranslateY) {
            translationY = maxHeadTranslateY;
        }

        if (child.getTranslationY() != translationY) {
            onScrollChange(type, (int) translationY);
            child.setTranslationY(translationY);
        }
    }

    @Override
    public boolean onNestedPreFling(@NonNull final CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY) {
        // consumed the flinging behavior until Closed
        mScrollFling = true;
        boolean b = !isClosed(child);
        if (mIsUp && Math.abs(velocityY) > mMinimumFlingVelocity && isHeaderFling(target)) {
//            handleActionUp(coordinatorLayout, child);
            tryToInitFlingRunnable(coordinatorLayout, child);
            mFlingRunnableHeader.setTarget(target);
            mFlingRunnableHeader.startFlingWithDelay((int) (getHeaderOffsetRange() - child.getTranslationY()), velocityX, velocityY);
            return true;
        }

        return false;

    }

    private void tryToInitFlingRunnable(@NonNull final CoordinatorLayout coordinatorLayout, @NonNull View child) {
        if (mFlingRunnableHeader == null) {
            mFlingRunnableHeader = new MisesHeaderFlingRunnable(coordinatorLayout, child);

            mFlingRunnableHeader.setOnScrollChangeListener(new MisesHeaderFlingRunnable.OnHeaderFlingListener() {

                @Override
                public void onFlingFinish() {
                    mIsFling = false;
                    if (mOnHeaderFlingListener != null) {
                        mOnHeaderFlingListener.onFlingFinish();
                    }


                }

                @Override
                public void onFlingStart(View child, View target, float velocityX, float velocityY) {
                    mIsFling = true;
                    if (mOnHeaderFlingListener != null) {
                        mOnHeaderFlingListener.onFlingStart(child, target, velocityX, velocityY);
                    }
                }

                @Override
                public void onHeaderClose() {

                    if (mOnHeaderFlingListener != null) {
                        mOnHeaderFlingListener.onHeaderClose();
                    }

                    if (mPagerStateListener != null) {
                        mPagerStateListener.onPagerClosed();
                    }
                }

                @Override
                public void onHeaderOpen() {

                    if (mOnHeaderFlingListener != null) {
                        mOnHeaderFlingListener.onHeaderOpen();
                    }

                    if (mPagerStateListener != null) {
                        mPagerStateListener.onPagerOpened();
                    }
                }
            });
        }
    }

    private boolean isHeaderFling(@NonNull View target) {
        return target instanceof MisesNestedLinearLayout;
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
      /*  if (type == ViewCompat.TYPE_TOUCH && Math.abs(mOffestY) > 5 && isClosed(child)) {
            logD(TAG, "onStopNestedScroll handleActionUp type = " + type);
            handleActionUp(coordinatorLayout, child);
        }*/
        onScrollChange(type, (int) child.getTranslationY());

        boolean closed = isClosed();
        if (!mLastStopIsClose && closed) {
            if (mPagerStateListener != null) {
                mPagerStateListener.onPagerClosed();
            }
        }
        mLastStopIsClose = closed;

        if (mPagerStateListener != null && mLastScrollY != child.getTranslationY()) {
            mPagerStateListener.onStopScroll((int) child.getTranslationY(), type, mScrollFling);
        }

        if (type == ViewCompat.TYPE_TOUCH) {
            mScrollFling = false;
        }

        mLastScrollY = (int) child.getTranslationY();
    }

    public void resetLastScrollY(int scrollY) {
        this.mLastScrollY = scrollY;
    }

    // Maximum offset, is a negative number
    public int getHeaderOffsetRange() {
        return (int) mHeaderOffsetRange;
    }

    private void logD(String tag, String s) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, s);
        }
    }

    public void openPager() {
        if (mParent != null && mChild != null) {
            tryToInitFlingRunnable(mParent.get(), mChild.get());
            mFlingRunnableHeader.setTarget(null);
            mFlingRunnableHeader.scrollToOpen();
        }
    }

    public void closePager() {
        if (mParent != null && mChild != null) {
            tryToInitFlingRunnable(mParent.get(), mChild.get());
            mFlingRunnableHeader.setTarget(null);
            mFlingRunnableHeader.scrollToClose(mHeaderOffsetRange);
        }
    }

    private boolean isClosed(View child) {
        return child.getTranslationY() <= getHeaderOffsetRange();
    }

    public boolean isClosed() {
        if (mChild != null) {
            return isClosed(mChild.get());
        }

        return false;
    }


    /**
     * callback for HeaderPager 's state
     */
    public interface OnPagerStateListener {
        /**
         * do callback when pager closed
         */
        void onPagerClosed();

        /**
         * when scrooll, it would call back
         *
         * @param isUp isScroollUp
         * @param dy   child.getTanslationY
         * @param type touch or not touch, TYPE_TOUCH, TYPE_NON_TOUCH
         */
        void onScrollChange(boolean isUp, int dy, @ViewCompat.NestedScrollType int type);

        /**
         * do callback when pager opened
         */
        void onPagerOpened();

        /**
         * callback when finger action up
         *
         * @param dy    child.getTanslationY
         * @param type  touch or not touch, TYPE_TOUCH, TYPE_NON_TOUCH
         * @param fling
         */
        void onStopScroll(int dy, @ViewCompat.NestedScrollType int type, boolean fling);
    }


}