package org.chromium.chrome.browser.ntp.ntp_hp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by gudd on 2024/12/2.
 * 水平滑动item的RecyclerView.
 * 当判断是左右滑动时，拦截父容器的滑动。
 */
public class MisesHorizontalRecyclerView extends RecyclerView {
    private float startX, startY;

    public MisesHorizontalRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MisesHorizontalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MisesHorizontalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录初始触摸位置
                startX = e.getX();
                startY = e.getY();
                // 允许父容器拦截触摸事件
                getParent().requestDisallowInterceptTouchEvent(false);
                break;

            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(e.getX() - startX);
                float dy = Math.abs(e.getY() - startY);

                // 判断是否为水平滑动
                if (dx > dy) {
                    // 水平滑动，禁止父容器拦截
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    // 垂直滑动，允许父容器拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.onInterceptTouchEvent(e);
    }
}
