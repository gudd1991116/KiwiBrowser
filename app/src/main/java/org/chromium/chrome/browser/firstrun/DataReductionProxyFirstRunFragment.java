// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.firstrun;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import org.chromium.chrome.R;
import org.chromium.chrome.browser.net.spdyproxy.DataReductionProxySettings;
import org.chromium.chrome.browser.preferences.datareduction.DataReductionPromoUtils;

/**
 * The First Run Experience fragment that allows the user to opt in to Data Saver.
 */
public class DataReductionProxyFirstRunFragment extends Fragment implements FirstRunFragment {
    /** FRE page that instantiates this fragment. */
    public static class Page implements FirstRunPage<DataReductionProxyFirstRunFragment> {
        @Override
        public DataReductionProxyFirstRunFragment instantiateFragment() {
            return new DataReductionProxyFirstRunFragment();
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fre_data_reduction_proxy, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SwitchCompat enableDataSaverSwitch = (SwitchCompat) view
                .findViewById(R.id.enable_data_saver_switch);
        Button nextButton = (Button) view.findViewById(R.id.next_button);

        enableDataSaverSwitch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DataReductionProxySettings.getInstance().setDataReductionProxyEnabled(
                        v.getContext(), enableDataSaverSwitch.isChecked());
                if (enableDataSaverSwitch.isChecked()) {
                    enableDataSaverSwitch.setText(R.string.data_reduction_enabled_switch);
                } else {
                    enableDataSaverSwitch.setText(R.string.data_reduction_disabled_switch);
                }
            }
        });

        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getPageDelegate().advanceToNextPage();
            }
        });

        enableDataSaverSwitch.setChecked(true);
        DataReductionProxySettings.getInstance().setDataReductionProxyEnabled(
                view.getContext(), enableDataSaverSwitch.isChecked());
    }

    @Override
    public void onStart() {
        super.onStart();
        DataReductionPromoUtils.saveFreOrSecondRunPromoDisplayed();
    }
}
