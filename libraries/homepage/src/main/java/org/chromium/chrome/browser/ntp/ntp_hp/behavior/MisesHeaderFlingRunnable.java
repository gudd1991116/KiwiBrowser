package org.chromium.chrome.browser.ntp.ntp_hp.behavior;

import android.view.View;
import android.widget.OverScroller;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/**
 * Created by jun xu on 19-3-7.
 */
public class MisesHeaderFlingRunnable implements Runnable {

    private final View mChild;
    private final CoordinatorLayout mParent;
    private View mTarget;

    OverScroller mOverScroller;
    OnHeaderFlingListener mOnScrollChangeListener;
    private boolean mIsScroollClose;

    public MisesHeaderFlingRunnable(CoordinatorLayout parent, View child) {
        mParent = parent;
        mChild = child;
        mOverScroller = new OverScroller(mChild.getContext());
    }

    public void setTarget(View target) {
        mTarget = target;
    }

    @Override
    public void run() {
        try {
            if (mOverScroller.computeScrollOffset()) {

                mChild.setTranslationY(mOverScroller.getCurrY());
                ViewCompat.postOnAnimation(mChild, this);

            } else {

                mOverScroller.abortAnimation();

                if (mOnScrollChangeListener != null) {
                    mOnScrollChangeListener.onFlingFinish();
                    if (mIsScroollClose) {
                        mOnScrollChangeListener.onHeaderClose();
                    } else {
                        mOnScrollChangeListener.onHeaderOpen();
                    }

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startFling(int dy, float velocityX, float velocityY) {
        mIsScroollClose = true;
        mOverScroller.abortAnimation();
        mOverScroller.startScroll(0, (int) mChild.getTranslationY(), 0, dy, 100);
        ViewCompat.postOnAnimation(mChild, this);
        if (mOnScrollChangeListener != null) {
            mOnScrollChangeListener.onFlingStart(mChild, mTarget, velocityX, velocityY);
        }
    }

    public void scrollToClose(int headerOffset) {
        mIsScroollClose = true;
        mOverScroller.abortAnimation();
        mOverScroller.startScroll(0, (int) mChild.getTranslationY(), 0, (int) (headerOffset - mChild.getTranslationY()), 650);
        ViewCompat.postOnAnimation(mChild, this);
    }

    public void scrollToOpen() {
        mIsScroollClose = false;
        float curTranslationY = mChild.getTranslationY();
        mOverScroller.abortAnimation();
        mOverScroller.startScroll(0, (int) curTranslationY, 0, (int) -curTranslationY,
                450);
        ViewCompat.postOnAnimation(mChild, this);
    }

    public interface OnHeaderFlingListener {
        void onFlingFinish();

        void onFlingStart(View child, View target, float velocityX, float velocityY);

        void onHeaderClose();

        void onHeaderOpen();
    }

    public void setOnScrollChangeListener(OnHeaderFlingListener onScrollChangeListener) {
        mOnScrollChangeListener = onScrollChangeListener;
    }
}
