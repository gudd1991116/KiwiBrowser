package org.chromium.chrome.browser.ntp.ntp_hp.view.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.common.MisesConstants;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNtpListener;

/**
 * Created by gudd on 2024/12/20.
 */
public class MisesToolbarView extends ConstraintLayout implements View.OnClickListener {
    private AppCompatImageView mAdPlace;
    private ImageButton mSwitchButton;
    private ImageButton mMenuBtn;
    private MisesOnNtpListener mOnNtpListener;
    private MisesOnNewsClickListener mNewsClickListener;

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
        mSwitchButton = findViewById(R.id.mises_tab_switcher_button);
        mSwitchButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == mAdPlace){
            if (mNewsClickListener != null) {
                mNewsClickListener.onClick(MisesConstants.MISES_AIR_DROP);
            }
        }else if(v == mMenuBtn){
            if (mOnNtpListener != null) {
                mOnNtpListener.openAppMenu();
            }
        } else if (v == mSwitchButton) {
            if (mOnNtpListener != null) {
                mOnNtpListener.openMultiWindows();
            }
        }

        /*if (mToggleTabStackButton == v) {
            if (ChromeFeatureList.isInitialized()
                    && ChromeFeatureList.isEnabled(ChromeFeatureList.CHROME_MEMEX)) {
                openMemexUI();
                return;
            }
            handleToggleTabStack();
        }*/
    }

    public void setOnMisesNtpListener(MisesOnNtpListener listener) {
        mOnNtpListener = listener;
    }

    public void setOnNewsClickListener(MisesOnNewsClickListener listener) {
        mNewsClickListener = listener;
    }

    public void updateTabCountVisuals(int numberOfTabs) {
        if (mToggleTabStackButton == null) return;
        mToggleTabStackButton.setEnabled(numberOfTabs >= 1);
        mTabSwitcherButtonDrawableLight.updateForTabCount(numberOfTabs, false);
    }
}
