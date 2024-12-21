package org.chromium.chrome.browser.ntp.ntp_hp.behavior;

import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import org.chromium.chrome.browser.R;

/**
 * Created by jun xu on 19-3-7.
 */
public class MisesHeaderFlingRunnable implements Runnable {

    private final View mChild;
    private final CoordinatorLayout mParent;
    private View mTarget;

    OverScroller mOverScroller;
    OnHeaderFlingListener mOnScrollChangeListener;
    private boolean mIsScroollClose;// 当前目标状态，true 表示即将关闭
    private boolean isScrolling = false; // 动画状态标志位

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
        // 边界检查，避免超出滚动范围
        if ((dy > 0 && mChild.getTranslationY() <= getHeaderOffsetRange()) ||
                (dy < 0 && mChild.getTranslationY() >= 0)) {
            return;
        }
        // 平滑过渡速度，衔接前一次 fling
        int adjustedDy = Math.min(Math.abs(dy), Math.abs((int) mOverScroller.getCurrVelocity()));
        adjustedDy = dy > 0 ? adjustedDy : -adjustedDy;

        mIsScroollClose = dy > 0;// 更新目标状态

        mOverScroller.abortAnimation();// 中止当前动画
        mOverScroller.startScroll(0, (int) mChild.getTranslationY(), 0, adjustedDy, 150);
        ViewCompat.postOnAnimation(mChild, this);
        if (mOnScrollChangeListener != null) {
            mOnScrollChangeListener.onFlingStart(mChild, mTarget, velocityX, velocityY);
        }
    }

    /**
     * 延迟触发 fling 动画，避免冲突
     */
    public void startFlingWithDelay(final int dy, final float velocityX, final float velocityY) {
        if (mOverScroller.computeScrollOffset()) {
            mOverScroller.abortAnimation(); // 中止当前动画
        }

        // 延迟触发新的 fling 动画
        mChild.postDelayed(() -> startFling(dy, velocityX, velocityY), 50);
    }

    /**
     * 滚动到关闭状态
     */
    public void scrollToClose(int headerOffset) {
        isScrolling = true;
        mIsScroollClose = true;
        mOverScroller.abortAnimation();
        mOverScroller.startScroll(0, (int) mChild.getTranslationY(), 0, (int) (headerOffset - mChild.getTranslationY()), 650);
        ViewCompat.postOnAnimation(mChild, this);
        animateClose(() -> isScrolling = false); // 动画结束时重置状态
    }

    /**
     * 滚动到打开状态
     */
    public void scrollToOpen() {
        isScrolling = true;
        mIsScroollClose = false;
        float curTranslationY = mChild.getTranslationY();
        mOverScroller.abortAnimation();
        mOverScroller.startScroll(0, (int) curTranslationY, 0, (int) -curTranslationY,
                450);// 缓慢打开动画
        ViewCompat.postOnAnimation(mChild, this);
        animateOpen(() -> isScrolling = false); // 动画结束时重置状态
    }

    public boolean isScrolling() {
        return isScrolling;
    }

    // 动画回调示例
    private void animateClose(Runnable onComplete) {
        // 动画逻辑
        new Handler().postDelayed(onComplete, 650); // 假设动画持续300ms
    }

    private void animateOpen(Runnable onComplete) {
        // 动画逻辑
        new Handler().postDelayed(onComplete, 450); // 假设动画持续300ms
    }

    /**
     * 获取当前视图滚动的最大范围
     */
    public int getHeaderOffsetRange() {
        int mStatusBarHeight = 0;
        int toolbarOffsetHeight = mParent.getContext().getResources().getDimensionPixelOffset(R.dimen.mises_tool_bar_height) + mStatusBarHeight;
        return -mChild.getHeight() + toolbarOffsetHeight; // 负值表示完全关闭的位置
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
