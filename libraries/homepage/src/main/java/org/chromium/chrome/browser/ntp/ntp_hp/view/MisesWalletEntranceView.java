package org.chromium.chrome.browser.ntp.ntp_hp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import org.chromium.chrome.browser.R;

/**
 * Created by gudd on 2024/12/17.
 * total height 84dp
 */
public class MisesWalletEntranceView extends LinearLayoutCompat {
    public MisesWalletEntranceView(@NonNull Context context) {
        this(context,null);
    }

    public MisesWalletEntranceView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MisesWalletEntranceView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.mises_homepage_wallet_entrance_btn,this,true);
    }
}
