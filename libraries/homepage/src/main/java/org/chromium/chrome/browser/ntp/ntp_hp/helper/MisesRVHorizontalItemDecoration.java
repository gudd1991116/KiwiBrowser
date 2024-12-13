package org.chromium.chrome.browser.ntp.ntp_hp.helper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesDensityUtil;

/**
 * Created by gudd on 2024/12/2.
 */
public class MisesRVHorizontalItemDecoration extends RecyclerView.ItemDecoration {

    private int mTopSpacing, mBottomSpacing, mStartSpacing, mEndSpacing;
    private int mFirstStartSpacing, mLastEndSpacing;

    /**
     * 构造器
     *
     * @param startSpacing      左边边距
     * @param topSpacing        上边边距
     * @param endSpacing        右边边距
     * @param bottomSpacing     下边边距
     * @param firstStartSpacing 第一条左边边距
     * @param lastEndSpacing    最后一条右边边距
     */
    public MisesRVHorizontalItemDecoration(Context context, int startSpacing, int topSpacing, int endSpacing, int bottomSpacing, int firstStartSpacing, int lastEndSpacing) {
        mTopSpacing = MisesDensityUtil.dip2px(context, topSpacing);
        mBottomSpacing = MisesDensityUtil.dip2px(context, bottomSpacing);
        mStartSpacing = MisesDensityUtil.dip2px(context, startSpacing);
        mEndSpacing = MisesDensityUtil.dip2px(context, endSpacing);
        mFirstStartSpacing = MisesDensityUtil.dip2px(context, firstStartSpacing);
        mLastEndSpacing = MisesDensityUtil.dip2px(context, lastEndSpacing);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        int totalCount = state.getItemCount();
        if (position == 0) {
            if (mFirstStartSpacing >= 0) {
                outRect.left = mFirstStartSpacing;
            } else {
                outRect.left = mStartSpacing;
            }
            outRect.right = mEndSpacing;
        } else if (position == totalCount -1) {
            outRect.left = mStartSpacing;
            if (mLastEndSpacing >= 0) {
                outRect.right = mLastEndSpacing;
            } else {
                outRect.right = mEndSpacing;
            }
        } else {
            outRect.left = mStartSpacing;
            outRect.right = mEndSpacing;
        }

        outRect.top = mTopSpacing;
        outRect.bottom = mBottomSpacing;

    }
}
