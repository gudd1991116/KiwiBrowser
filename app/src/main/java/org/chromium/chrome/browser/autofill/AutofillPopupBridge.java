// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.autofill;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import androidx.appcompat.app.AlertDialog;
import android.view.View;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.ChromeActivity;
import org.chromium.chrome.browser.ResourceId;
import org.chromium.components.autofill.AutofillDelegate;
import org.chromium.components.autofill.AutofillPopup;
import org.chromium.components.autofill.AutofillSuggestion;
import org.chromium.content_public.browser.WebContentsAccessibility;
import org.chromium.ui.DropdownItem;
import org.chromium.ui.base.WindowAndroid;

/**
* JNI call glue for AutofillExternalDelagate C++ and Java objects.
*/
@JNINamespace("autofill")
public class AutofillPopupBridge implements AutofillDelegate, DialogInterface.OnClickListener {
    private final long mNativeAutofillPopup;
    private final AutofillPopup mAutofillPopup;
    private AlertDialog mDeletionDialog;
    private final Context mContext;
    private WebContentsAccessibility mWebContentsAccessibility;

    public AutofillPopupBridge(View anchorView, long nativeAutofillPopupViewAndroid,
            WindowAndroid windowAndroid) {
        mNativeAutofillPopup = nativeAutofillPopupViewAndroid;
        Activity activity = windowAndroid.getActivity().get();
        if (activity == null) {
            mAutofillPopup = null;
            mContext = null;
            // Clean up the native counterpart.  This is posted to allow the native counterpart
            // to fully finish the construction of this glue object before we attempt to delete it.
            new Handler().post(() -> dismissed());
        } else {
            mAutofillPopup = new AutofillPopup(activity, anchorView, this);
            mContext = activity;
            mWebContentsAccessibility = WebContentsAccessibility.fromWebContents(
                    ((ChromeActivity) activity).getCurrentWebContents());
        }
    }

    @CalledByNative
    private static AutofillPopupBridge create(View anchorView, long nativeAutofillPopupViewAndroid,
            WindowAndroid windowAndroid) {
        return new AutofillPopupBridge(anchorView, nativeAutofillPopupViewAndroid, windowAndroid);
    }

    @Override
    public void dismissed() {
        nativePopupDismissed(mNativeAutofillPopup);
    }

    @Override
    public void suggestionSelected(int listIndex) {
        nativeSuggestionSelected(mNativeAutofillPopup, listIndex);
    }

    @Override
    public void deleteSuggestion(int listIndex) {
        nativeDeletionRequested(mNativeAutofillPopup, listIndex);
    }

    @Override
    public void accessibilityFocusCleared() {
        mWebContentsAccessibility.onAutofillPopupAccessibilityFocusCleared();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        assert which == DialogInterface.BUTTON_POSITIVE;
        nativeDeletionConfirmed(mNativeAutofillPopup);
    }

    /**
     * Hides the Autofill Popup and removes its anchor from the ContainerView.
     */
    @CalledByNative
    private void dismiss() {
        if (mAutofillPopup != null) mAutofillPopup.dismiss();
        if (mDeletionDialog != null) mDeletionDialog.dismiss();
        mWebContentsAccessibility.onAutofillPopupDismissed();
    }

    /**
     * Shows an Autofill popup with specified suggestions.
     * @param suggestions Autofill suggestions to be displayed.
     * @param isRtl @code true if right-to-left text.
     * @param backgroundColor popup background color, or {@code Color.TRANSPARENT} if not specified
     * in experiment.
     * @param dividerColor color for divider between popup items, or {@code Color.TRANSPARENT} if
     * not specified in experiment.
     * @param dropdownItemHeight height of each dropdown item in dimension independent pixel units,
     * 0 if not specified in experiment.
     * @param margin Margin for icon, label and between icon and label in dimension independent
     * pixel units, 0 if not specified in experiment.
     */
    @CalledByNative
    private void show(AutofillSuggestion[] suggestions, boolean isRtl, int backgroundColor,
            int dividerColor, int dropdownItemHeight, int margin) {
        if (mAutofillPopup != null) {
            mAutofillPopup.filterAndShow(
                    suggestions, isRtl, backgroundColor, dividerColor, dropdownItemHeight, margin);
            mWebContentsAccessibility.onAutofillPopupDisplayed(mAutofillPopup.getListView());
        }
    }

    @CalledByNative
    private void confirmDeletion(String title, String body) {
        mDeletionDialog = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                .setTitle(title)
                .setMessage(body)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(R.string.ok, this)
                .create();
        mDeletionDialog.show();
    }

    // Helper methods for AutofillSuggestion

    @CalledByNative
    private static AutofillSuggestion[] createAutofillSuggestionArray(int size) {
        return new AutofillSuggestion[size];
    }

    /**
     * @param array AutofillSuggestion array that should get a new suggestion added.
     * @param index Index in the array where to place a new suggestion.
     * @param label First line of the suggestion.
     * @param sublabel Second line of the suggestion.
     * @param iconId The resource ID for the icon associated with the suggestion, or 0 for no icon.
     * @param isIconAtStart {@code true} if {@param iconId} is displayed before {@param label}.
     * @param suggestionId Identifier for the suggestion type.
     * @param isDeletable Whether the item can be deleted by the user.
     * @param isLabelMultiline Whether the label should be should over multiple lines.
     * @param isLabelBold true if {@param label} should be displayed in {@code Typeface.BOLD},
     * false if {@param label} should be displayed in {@code Typeface.NORMAL}.
     */
    @CalledByNative
    private static void addToAutofillSuggestionArray(AutofillSuggestion[] array, int index,
            String label, String sublabel, int iconId, boolean isIconAtStart,
            int suggestionId, boolean isDeletable, boolean isLabelMultiline, boolean isLabelBold) {
        int drawableId = iconId == 0 ? DropdownItem.NO_ICON : ResourceId.mapToDrawableId(iconId);
        array[index] = new AutofillSuggestion(label, sublabel, drawableId, isIconAtStart,
                suggestionId, isDeletable, isLabelMultiline, isLabelBold);
    }

    private native void nativeSuggestionSelected(long nativeAutofillPopupViewAndroid,
            int listIndex);
    private native void nativeDeletionRequested(long nativeAutofillPopupViewAndroid,
            int listIndex);
    private native void nativeDeletionConfirmed(long nativeAutofillPopupViewAndroid);
    private native void nativePopupDismissed(long nativeAutofillPopupViewAndroid);
}
