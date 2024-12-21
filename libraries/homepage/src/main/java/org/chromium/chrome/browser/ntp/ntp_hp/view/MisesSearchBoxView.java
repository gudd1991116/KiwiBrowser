package org.chromium.chrome.browser.ntp.ntp_hp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.chromium.chrome.browser.R;

/**
 * Created by gudd on 2024/12/17.
 */
public class MisesSearchBoxView extends FrameLayout {
    public MisesSearchBoxView(@NonNull Context context) {
        this(context,null);
    }

    public MisesSearchBoxView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MisesSearchBoxView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.mises_search_box,this,true);
    }


}
