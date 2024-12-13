package org.chromium.chrome.browser.ntp.ntp_hp.helper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesDensityUtil;

/**
 * Created by gudd on 2024/11/12.
 */
public class MisesTopSiteItemDecoration extends RecyclerView.ItemDecoration {
    int topSpacing ,bottomSpacing;
    int firstLeftSpacing;
    int middleSpacingLeft,middleSpacingRight;
    public MisesTopSiteItemDecoration(Context context) {
        topSpacing = MisesDensityUtil.dip2px(context, 20);
        bottomSpacing = MisesDensityUtil.dip2px(context, 0);
        firstLeftSpacing = MisesDensityUtil.dip2px(context, 20);
        middleSpacingLeft = middleSpacingRight = MisesDensityUtil.dip2px(context, 10);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int totalItemCount = state.getItemCount();
        if (position == 0){
            outRect.left = firstLeftSpacing;
            outRect.right = middleSpacingRight;
        }else if (position == totalItemCount){
            outRect.left = middleSpacingLeft;
            outRect.right = firstLeftSpacing;
        }else{
            outRect.left = middleSpacingLeft;
            outRect.right = middleSpacingLeft;
        }
        outRect.top = topSpacing;
        outRect.bottom = bottomSpacing;
    }


}
