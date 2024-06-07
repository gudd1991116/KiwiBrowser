// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.preferences.password;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import androidx.appcompat.widget.SearchView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.ChromeFeatureList;
import org.chromium.chrome.browser.preferences.ChromeBaseCheckBoxPreference;
import org.chromium.chrome.browser.preferences.ChromeBasePreference;
import org.chromium.chrome.browser.preferences.ChromeSwitchPreference;
import org.chromium.chrome.browser.preferences.PrefServiceBridge;
import org.chromium.chrome.browser.preferences.Preferences;
import org.chromium.chrome.browser.preferences.PreferencesLauncher;
import org.chromium.chrome.browser.preferences.TextMessagePreference;
import org.chromium.ui.text.SpanApplier;

import java.util.Locale;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;
import org.chromium.base.ContextUtils;

/**
 * The "Save passwords" screen in Settings, which allows the user to enable or disable password
 * saving, to view saved passwords (just the username and URL), and to delete saved passwords.
 */
public class SavePasswordsPreferences
        extends PreferenceFragment implements PasswordManagerHandler.PasswordListObserver,
                                              Preference.OnPreferenceClickListener {
    // Keys for name/password dictionaries.
    public static final String PASSWORD_LIST_URL = "url";
    public static final String PASSWORD_LIST_NAME = "name";
    public static final String PASSWORD_LIST_PASSWORD = "password";

    // Used to pass the password id into a new activity.
    public static final String PASSWORD_LIST_ID = "id";

    // The key for saving |mSearchQuery| to instance bundle.
    private static final String SAVED_STATE_SEARCH_QUERY = "saved-state-search-query";

    public static final String PREF_SAVE_PASSWORDS_SWITCH = "save_passwords_switch";
    public static final String PREF_AUTOSIGNIN_SWITCH = "autosignin_switch";

    // A PasswordEntryEditor receives a boolean value with this key. If set true, the the entry was
    // part of a search result.
    public static final String EXTRA_FOUND_VIA_SEARCH = "found_via_search_args";

    private static final String PREF_KEY_CATEGORY_SAVED_PASSWORDS = "saved_passwords";
    private static final String PREF_KEY_CATEGORY_EXCEPTIONS = "exceptions";
    private static final String PREF_KEY_MANAGE_ACCOUNT_LINK = "manage_account_link";
    private static final String PREF_KEY_SAVED_PASSWORDS_NO_TEXT = "saved_passwords_no_text";

    private static final int ORDER_SWITCH = 0;
    private static final int ORDER_AUTO_SIGNIN_CHECKBOX = 1;
    private static final int ORDER_MANAGE_ACCOUNT_LINK = 2;
    private static final int ORDER_SAVED_PASSWORDS = 3;
    private static final int ORDER_EXCEPTIONS = 4;
    private static final int ORDER_SAVED_PASSWORDS_NO_TEXT = 5;

    private boolean mNoPasswords;
    private boolean mNoPasswordExceptions;

    private MenuItem mHelpItem;

    private String mSearchQuery;
    private Preference mLinkPref;
    private ChromeSwitchPreference mSavePasswordsSwitch;
    private ChromeBaseCheckBoxPreference mAutoSignInSwitch;
    private TextMessagePreference mEmptyView;
    private boolean mSearchRecorded;
    private Menu mMenuForTesting;

    /**
     * For controlling the UX flow of exporting passwords.
     */
    private ExportFlow mExportFlow = new ExportFlow();

    public ExportFlow getExportFlowForTesting() {
        return mExportFlow;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mExportFlow.onCreate(savedInstanceState, new ExportFlow.Delegate() {
            @Override
            public Activity getActivity() {
                return SavePasswordsPreferences.this.getActivity();
            }

            @Override
            public FragmentManager getFragmentManager() {
                return SavePasswordsPreferences.this.getFragmentManager();
            }

            @Override
            public int getViewId() {
                return getView().getId();
            }
        });
        getActivity().setTitle(R.string.prefs_saved_passwords_title);
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getActivity()));
        PasswordManagerHandlerProvider.getInstance().addObserver(this);

        setHasOptionsMenu(ExportFlow.providesPasswordExport() || providesPasswordSearch());

        if (savedInstanceState == null) return;

        if (savedInstanceState.containsKey(SAVED_STATE_SEARCH_QUERY)) {
            mSearchQuery = savedInstanceState.getString(SAVED_STATE_SEARCH_QUERY);
            mSearchRecorded = mSearchQuery != null; // We record a search when a query is set.
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        mMenuForTesting = menu;
        inflater.inflate(R.menu.save_password_preferences_action_bar_menu, menu);
        menu.findItem(R.id.export_passwords).setVisible(ExportFlow.providesPasswordExport());
        menu.findItem(R.id.export_passwords).setEnabled(false);
        MenuItem searchItem = menu.findItem(R.id.menu_id_search);
        searchItem.setVisible(providesPasswordSearch());
        if (providesPasswordSearch()) {
            mHelpItem = menu.findItem(R.id.menu_id_general_help);
            setUpSearchAction(searchItem);
        }
    }

    /**
     * Prepares the searchItem's icon and searchView. Sets up listeners to clicks and interactions
     * with the searchItem or its searchView.
     * @param searchItem the item containing the SearchView. Must not be null.
     */
    private void setUpSearchAction(MenuItem searchItem) {
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_FLAG_NO_FULLSCREEN);
        searchItem.setIcon(convertToPlainWhite(searchItem.getIcon()));
        if (mSearchQuery != null) { // If a query was recovered, restore the search view.
            searchItem.expandActionView();
            searchView.setIconified(false);
            searchView.setQuery(mSearchQuery, false);
        }
        searchItem.setOnMenuItemClickListener((MenuItem m) -> {
            filterPasswords("");
            return false; // Continue with the default action.
        });
        searchView.findViewById(R.id.search_close_btn).setOnClickListener((View v) -> {
            searchView.setQuery(null, false);
            searchView.setIconified(true);
            filterPasswords(null); // Reset filter to bring back all preferences.
        });
        searchView.setOnSearchClickListener(view -> filterPasswords(""));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true; // Continue with default action - nothing.
            }

            @Override
            public boolean onQueryTextChange(String query) {
                maybeRecordTriggeredPasswordSearch(true);
                return filterPasswords(query);
            }
        });
    }

    /**
     * Record the search only, if the feature is enabled and it hasn't been recorded for this
     * instance of the view.
     * @param searchTriggered Whether to log a triggered search or no triggered search.
     */
    private void maybeRecordTriggeredPasswordSearch(boolean searchTriggered) {
        if (providesPasswordSearch() && !mSearchRecorded) {
            mSearchRecorded = true;
            RecordHistogram.recordBooleanHistogram(
                    "PasswordManager.Android.PasswordSearchTriggered", searchTriggered);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.export_passwords).setEnabled(!mNoPasswords && !mExportFlow.isActive());
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.export_passwords) {
            mExportFlow.startExporting();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean filterPasswords(String query) {
        mSearchQuery = query;
        // Hide the help option. It's not useful during search but might be clicked by accident.
        mHelpItem.setShowAsAction(mSearchQuery != null ? MenuItem.SHOW_AS_ACTION_NEVER
                                                       : MenuItem.SHOW_AS_ACTION_IF_ROOM);
        rebuildPasswordLists();
        return false; // Query has been handled. Don't trigger default action of SearchView.
    }

    /**
     * Empty screen message when no passwords or exceptions are stored.
     */
    private void displayEmptyScreenMessage() {
        mEmptyView = new TextMessagePreference(getActivity(), null);
        mEmptyView.setSummary(R.string.saved_passwords_none_text);
        mEmptyView.setKey(PREF_KEY_SAVED_PASSWORDS_NO_TEXT);
        mEmptyView.setOrder(ORDER_SAVED_PASSWORDS_NO_TEXT);
        getPreferenceScreen().addPreference(mEmptyView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ReauthenticationManager.resetLastReauth();
    }

    void rebuildPasswordLists() {
        mNoPasswords = false;
        mNoPasswordExceptions = false;
        getPreferenceScreen().removeAll();
        createSavePasswordsSwitch();
        createAutoSignInCheckbox();
        PasswordManagerHandlerProvider.getInstance()
                .getPasswordManagerHandler()
                .updatePasswordLists();
    }

    /**
     * Removes the UI displaying the list of saved passwords or exceptions.
     * @param preferenceCategoryKey The key string identifying the PreferenceCategory to be removed.
     */
    private void resetList(String preferenceCategoryKey) {
        PreferenceCategory profileCategory =
                (PreferenceCategory) getPreferenceScreen().findPreference(preferenceCategoryKey);
        if (profileCategory != null) {
            profileCategory.removeAll();
            getPreferenceScreen().removePreference(profileCategory);
        }
    }

    /**
     * Removes the message informing the user that there are no saved entries to display.
     */
    private void resetNoEntriesTextMessage() {
        Preference message = getPreferenceScreen().findPreference(PREF_KEY_SAVED_PASSWORDS_NO_TEXT);
        if (message != null) {
            getPreferenceScreen().removePreference(message);
        }
    }

    @Override
    public void passwordListAvailable(int count) {
        resetList(PREF_KEY_CATEGORY_SAVED_PASSWORDS);
        resetNoEntriesTextMessage();

        mNoPasswords = count == 0;
        if (mNoPasswords) {
            if (mNoPasswordExceptions) displayEmptyScreenMessage();
            return;
        }

        displayManageAccountLink();

        PreferenceGroup passwordParent;
        if (mSearchQuery == null) {
            PreferenceCategory profileCategory = new PreferenceCategory(getActivity());
            profileCategory.setKey(PREF_KEY_CATEGORY_SAVED_PASSWORDS);
            profileCategory.setTitle(R.string.prefs_saved_passwords_title);
            profileCategory.setOrder(ORDER_SAVED_PASSWORDS);
            getPreferenceScreen().addPreference(profileCategory);
            passwordParent = profileCategory;
        } else {
            passwordParent = getPreferenceScreen();
        }
        for (int i = 0; i < count; i++) {
            SavedPasswordEntry saved = PasswordManagerHandlerProvider.getInstance()
                                               .getPasswordManagerHandler()
                                               .getSavedPasswordEntry(i);
            String url = saved.getUrl();
            String name = saved.getUserName();
            String password = saved.getPassword();
            if (shouldBeFiltered(url, name)) {
                continue; // The current password won't show with the active filter, try the next.
            }
            PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());
            if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false) || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
                Spannable title = new SpannableString(url);
                title.setSpan(new ForegroundColorSpan(Color.WHITE), 0, title.length(), 0);
                screen.setTitle(title);
                Spannable new_name = new SpannableString(name);
                new_name.setSpan(new ForegroundColorSpan(Color.GRAY), 0, new_name.length(), 0);
                screen.setSummary(new_name);
            } else {
                screen.setTitle(url);
                screen.setSummary(name);
            }
            screen.setOnPreferenceClickListener(this);
            Bundle args = screen.getExtras();
            args.putString(PASSWORD_LIST_NAME, name);
            args.putString(PASSWORD_LIST_URL, url);
            args.putString(PASSWORD_LIST_PASSWORD, password);
            args.putInt(PASSWORD_LIST_ID, i);
            passwordParent.addPreference(screen);
        }
        mNoPasswords = passwordParent.getPreferenceCount() == 0;
        if (mNoPasswords) {
            if (count == 0) displayEmptyScreenMessage(); // Show if the list was already empty.
            if (mSearchQuery == null) {
                // If not searching, the category needs to be removed again.
                getPreferenceScreen().removePreference(passwordParent);
            } else {
                getView().announceForAccessibility(
                        getResources().getText(R.string.accessible_find_in_page_no_results));
            }
        }
    }

    /**
     * Returns true if there is a search query that requires the exclusion of an entry based on
     * the passed url or name.
     * @param url the visible URL of the entry to check. May be empty but must not be null.
     * @param name the visible user name of the entry to check. May be empty but must not be null.
     * @return Returns whether the entry with the passed url and name should be filtered.
     */
    private boolean shouldBeFiltered(final String url, final String name) {
        if (mSearchQuery == null) {
            return false;
        }
        return !url.toLowerCase(Locale.ENGLISH).contains(mSearchQuery.toLowerCase(Locale.ENGLISH))
                && !name.toLowerCase(Locale.getDefault())
                            .contains(mSearchQuery.toLowerCase(Locale.getDefault()));
    }

    @Override
    public void passwordExceptionListAvailable(int count) {
        if (mSearchQuery != null) return; // Don't show exceptions if a search is ongoing.
        resetList(PREF_KEY_CATEGORY_EXCEPTIONS);
        resetNoEntriesTextMessage();

        mNoPasswordExceptions = count == 0;
        if (mNoPasswordExceptions) {
            if (mNoPasswords) displayEmptyScreenMessage();
            return;
        }

        displayManageAccountLink();

        PreferenceCategory profileCategory = new PreferenceCategory(getActivity());
        profileCategory.setKey(PREF_KEY_CATEGORY_EXCEPTIONS);
        profileCategory.setTitle(R.string.section_saved_passwords_exceptions);
        profileCategory.setOrder(ORDER_EXCEPTIONS);
        getPreferenceScreen().addPreference(profileCategory);
        for (int i = 0; i < count; i++) {
            String exception = PasswordManagerHandlerProvider.getInstance()
                                       .getPasswordManagerHandler()
                                       .getSavedPasswordException(i);
            PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());
            screen.setTitle(exception);
            screen.setOnPreferenceClickListener(this);
            Bundle args = screen.getExtras();
            args.putString(PASSWORD_LIST_URL, exception);
            args.putInt(PASSWORD_LIST_ID, i);
            profileCategory.addPreference(screen);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mExportFlow.onResume();
        rebuildPasswordLists();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mExportFlow.onSaveInstanceState(outState);
        if (mSearchQuery != null) {
            outState.putString(SAVED_STATE_SEARCH_QUERY, mSearchQuery);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        maybeRecordTriggeredPasswordSearch(false);
        PasswordManagerHandlerProvider.getInstance().removeObserver(this);
    }

    /**
     *  Preference was clicked. Either navigate to manage account site or launch the PasswordEditor
     *  depending on which preference it was.
     */
    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == mLinkPref) {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW, Uri.parse(PasswordUIView.getAccountDashboardURL()));
            intent.setPackage(getActivity().getPackageName());
            getActivity().startActivity(intent);
        } else {
            // Launch preference activity with PasswordEntryEditor fragment with
            // intent extras specifying the object.
            Intent intent = PreferencesLauncher.createIntentForSettingsPage(
                    getActivity(), PasswordEntryEditor.class.getName());
            intent.putExtra(Preferences.EXTRA_SHOW_FRAGMENT_ARGUMENTS, preference.getExtras());
            intent.putExtra(SavePasswordsPreferences.EXTRA_FOUND_VIA_SEARCH, mSearchQuery != null);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false) || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
            view.setBackgroundColor(Color.BLACK);
            ListView list = (ListView) view.findViewById(android.R.id.list);
            if (list != null)
                list.setDivider(new ColorDrawable(Color.GRAY));
                list.setDividerHeight((int) getResources().getDisplayMetrics().density);
        }
    }

    /**
     * Convert a given icon to a plain white version by applying the MATRIX_TRANSFORM_TO_WHITE color
     * filter. The resulting drawable will be brighter than a usual grayscale conversion.
     *
     * For grayscale conversion, use the function ColorMatrix#setSaturation(0) instead.
     * @param icon The drawable to be converted.
     * @return Returns the bright white version of the passed drawable.
     */
    private static Drawable convertToPlainWhite(Drawable icon) {
        icon.mutate().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        return icon;
    }

    private void createSavePasswordsSwitch() {
        if (mSearchQuery != null) {
            return; // Don't create this option when the preferences are filtered for passwords.
        }
        mSavePasswordsSwitch = new ChromeSwitchPreference(getActivity(), null);
        mSavePasswordsSwitch.setKey(PREF_SAVE_PASSWORDS_SWITCH);
        mSavePasswordsSwitch.setTitle(R.string.prefs_saved_passwords);
        mSavePasswordsSwitch.setOrder(ORDER_SWITCH);
        mSavePasswordsSwitch.setSummaryOn(R.string.text_on);
        mSavePasswordsSwitch.setSummaryOff(R.string.text_off);
        mSavePasswordsSwitch.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                PrefServiceBridge.getInstance().setRememberPasswordsEnabled((boolean) newValue);
                return true;
            }
        });
        mSavePasswordsSwitch.setManagedPreferenceDelegate(
                preference -> PrefServiceBridge.getInstance().isRememberPasswordsManaged());
        getPreferenceScreen().addPreference(mSavePasswordsSwitch);

        // Note: setting the switch state before the preference is added to the screen results in
        // some odd behavior where the switch state doesn't always match the internal enabled state
        // (e.g. the switch will say "On" when save passwords is really turned off), so
        // .setChecked() should be called after .addPreference()
        mSavePasswordsSwitch.setChecked(
                PrefServiceBridge.getInstance().isRememberPasswordsEnabled());
    }

    private void createAutoSignInCheckbox() {
        if (mSearchQuery != null) {
            return; // Don't create this option when the preferences are filtered for passwords.
        }
        mAutoSignInSwitch = new ChromeBaseCheckBoxPreference(getActivity(), null);
        mAutoSignInSwitch.setKey(PREF_AUTOSIGNIN_SWITCH);
        mAutoSignInSwitch.setTitle(R.string.passwords_auto_signin_title);
        mAutoSignInSwitch.setOrder(ORDER_AUTO_SIGNIN_CHECKBOX);
        mAutoSignInSwitch.setSummary(R.string.passwords_auto_signin_description);
        mAutoSignInSwitch.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                PrefServiceBridge.getInstance().setPasswordManagerAutoSigninEnabled(
                        (boolean) newValue);
                return true;
            }
        });
        mAutoSignInSwitch.setManagedPreferenceDelegate(
                preference -> PrefServiceBridge.getInstance().isPasswordManagerAutoSigninManaged());
        getPreferenceScreen().addPreference(mAutoSignInSwitch);
        mAutoSignInSwitch.setChecked(
                PrefServiceBridge.getInstance().isPasswordManagerAutoSigninEnabled());
    }

    private void displayManageAccountLink() {
        if (mSearchQuery != null && !mNoPasswords) {
            return; // Don't add the Manage Account link if there is a search going on.
        }
        if (getPreferenceScreen().findPreference(PREF_KEY_MANAGE_ACCOUNT_LINK) != null) {
            return; // Don't add the Manage Account link if it's present.
        }
        if (mLinkPref != null) {
            // If we created the link before, reuse it.
            getPreferenceScreen().addPreference(mLinkPref);
            return;
        }
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(
                ApiCompatibilityUtils.getColor(getResources(), R.color.google_blue_700));
        SpannableString title = SpanApplier.applySpans(getString(R.string.manage_passwords_text),
                new SpanApplier.SpanInfo("<link>", "</link>", colorSpan));
        mLinkPref = new ChromeBasePreference(getActivity());
        mLinkPref.setKey(PREF_KEY_MANAGE_ACCOUNT_LINK);
        mLinkPref.setTitle(title);
        mLinkPref.setOnPreferenceClickListener(this);
        mLinkPref.setOrder(ORDER_MANAGE_ACCOUNT_LINK);
        getPreferenceScreen().addPreference(mLinkPref);
    }

    /**
     * Returns whether the password search feature is ready to use.
     * @return Returns true if the flag is set.
     */
    private boolean providesPasswordSearch() {
        return ChromeFeatureList.isEnabled(ChromeFeatureList.PASSWORD_SEARCH);
    }

    @VisibleForTesting
    Menu getMenuForTesting() {
        return mMenuForTesting;
    }
}
