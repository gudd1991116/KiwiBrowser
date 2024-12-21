package org.chromium.chrome.browser.ntp.ntp_hp.view.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.chromium.chrome.browser.R;

/**
 * Created by gudd on 2024/12/20.
 */
public class MisesToolbarView extends ConstraintLayout implements View.OnClickListener {
    private AppCompatImageView mAdPlace;
    private ImageButton mMenuBtn;
    private View.OnClickListener mOnClickListener;

    protected ImageView mToggleTabStackButton;
    protected MisesTabSwitcherDrawable mTabSwitcherButtonDrawableLight;

    public MisesToolbarView(@NonNull Context context) {
        this(context, null);
    }

    public MisesToolbarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MisesToolbarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.mises_toolbar_view,this,true);

        mAdPlace = findViewById(R.id.mises_air_drop);
        mAdPlace.setOnClickListener(this);
        mMenuBtn = findViewById(R.id.mises_menu_button);
        mMenuBtn.setOnClickListener(this);

        inflateTabSwitchingResources();
    }

    private void inflateTabSwitchingResources() {
        mToggleTabStackButton = (ImageView) findViewById(R.id.mises_tab_switcher_button);
        mToggleTabStackButton.setClickable(false);

        Resources resources = getResources();
        mTabSwitcherButtonDrawableLight =
                MisesTabSwitcherDrawable.createTabSwitcherDrawable(resources, true);
        mToggleTabStackButton.setImageDrawable(mTabSwitcherButtonDrawableLight);

        enableTabSwitchingResources();
    }

    private void enableTabSwitchingResources() {
        mToggleTabStackButton.setOnClickListener(this);
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        mOnClickListener.onClick(v);

        /*if (mToggleTabStackButton == v) {
            if (ChromeFeatureList.isInitialized()
                    && ChromeFeatureList.isEnabled(ChromeFeatureList.CHROME_MEMEX)) {
                openMemexUI();
                return;
            }
            handleToggleTabStack();
        }*/
    }

    public void updateTabCountVisuals(int numberOfTabs) {
        if (mToggleTabStackButton == null) return;
        mToggleTabStackButton.setEnabled(numberOfTabs >= 1);
        mTabSwitcherButtonDrawableLight.updateForTabCount(numberOfTabs, false);
    }
}
