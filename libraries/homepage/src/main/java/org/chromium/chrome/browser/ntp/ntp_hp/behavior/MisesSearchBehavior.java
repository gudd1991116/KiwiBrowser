
package org.chromium.chrome.browser.ntp.ntp_hp.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import org.chromium.chrome.browser.R;

import java.lang.ref.WeakReference;


/**
 * 主要是通过 transY 来控制位置的
 */
public class MisesSearchBehavior extends CoordinatorLayout.Behavior<View> {

    private WeakReference<View> dependentView;
    private long mLastTime;
    private boolean first = true;

    private Context mContext;
    private int mStatusBarHeight = 0;
    private int mSearchViewMarginTop;

    public MisesSearchBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
//        mStatusBarHeight = MisesDensityUtil.statusBarHeight(context);
        mSearchViewMarginTop = mContext.getResources().getDimensionPixelOffset(R.dimen.mises_tool_bar_height) + mStatusBarHeight;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child,
                                   View dependency) {
        if (dependency != null && dependency.getId() == R.id.headerPart) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child,
                                          View dependency) {
        float dependencyTranslationY = dependency.getTranslationY();
        int translationY = (int) (mSearchViewMarginTop + dependencyTranslationY);
        child.setTranslationY(Math.max(translationY, mStatusBarHeight));

        return false;
    }

//    private View getDependentView() {
//        return dependentView.get();
//    }
//
//    private float getSearchViewMarginTop() {
//        return mContext.getResources().getDimension(R.dimen.search_margin_top);
//    }
//
//
//    private int getMaxTranslationY() {
//        return (-(int) (mContext.getResources()
//                .getDimension(R.dimen.search_margin_top) + 0.5f));
//    }
//
//    private void offsetChildAsNeeded(CoordinatorLayout parent, View child, View dependency) {
//        int headerOffsetRange = getHeaderOffsetRange();
//        int titleOffsetRange = getSearchOffest();
//        if (dependency.getTranslationY() == headerOffsetRange) {
//            child.setTranslationY(titleOffsetRange);
//        } else if (dependency.getTranslationY() == 0) {
//            child.setTranslationY(0);
//        } else {
//            child.setTranslationY((int) (dependency.getTranslationY() / (headerOffsetRange * 1.0f) * titleOffsetRange));
//        }
//    }
//
//    private int getHeaderOffsetRange() {
//        return mContext.getResources().getDimensionPixelOffset(R.dimen.header_pager_offset);
//    }
//
//    private int getSearchOffest() {
//        return mContext.getResources().getDimensionPixelOffset(R.dimen.search_margin_top);
//    }

}
