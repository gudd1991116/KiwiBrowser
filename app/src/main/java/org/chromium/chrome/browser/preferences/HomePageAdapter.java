package org.chromium.chrome.browser.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import org.chromium.base.ContextUtils;

import java.util.ArrayList;
import java.util.List;

import static org.chromium.chrome.browser.partnercustomizations.HomepageManager.PREF_HOMEPAGE_SELECTION;

public class HomePageAdapter extends BaseAdapter implements View.OnClickListener {
    private static final String TAG = "cr_HomePageSelector";
    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_DIVIDER = 1;
    private static final int VIEW_TYPE_COUNT = 2;
    private List<String> mHomePageSelector = new ArrayList<>();
    private List<String> mHomePageDescriptions = new ArrayList<>();
    private int mSelectedHomePagePosition = -1;

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public void start() {
        refreshData();
    }
    public void stop() {
    }
    public HomePageAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    private void refreshData() {
        mHomePageSelector = new ArrayList<>();
        mHomePageDescriptions = new ArrayList<>();
        mHomePageSelector.add("Web3");
        mHomePageDescriptions.add("Use Meta Web3 HomePage");
        mHomePageSelector.add("Web2");
        mHomePageDescriptions.add("Use Meta Web2 HomePage");
        mHomePageSelector.add("Ntp");
        mHomePageDescriptions.add("Use Chrome Default HomePage");
        mSelectedHomePagePosition = 0;
        String activeTheme = ContextUtils.getAppSharedPreferences().getString(PREF_HOMEPAGE_SELECTION, "NTP");
        for (int i = 0; i < mHomePageSelector.size(); ++i) {
            if (mHomePageSelector.get(i).equals(activeTheme)) {
                mSelectedHomePagePosition = i;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mHomePageSelector.size();
    }

    @Override
    public Object getItem(int pos) {
        return mHomePageSelector.get(pos);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        int itemViewType = getItemViewType(position);
        if (convertView == null) {
            view = mLayoutInflater.inflate(org.chromium.chrome.R.layout.search_engine, null);
        }
        if (itemViewType == VIEW_TYPE_DIVIDER) {
            return view;
        }

        view.setOnClickListener(this);
        view.setTag(position);
        TextView url = (TextView) view.findViewById(org.chromium.chrome.R.id.url);
        url.setText(mHomePageDescriptions.get(position));
        RadioButton radioButton = (RadioButton) view.findViewById(org.chromium.chrome.R.id.radiobutton);

        final boolean selected = position == mSelectedHomePagePosition;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            radioButton.setBackgroundResource(0);
        }
        radioButton.setChecked(selected);

        TextView description = (TextView) view.findViewById(org.chromium.chrome.R.id.name);
        Resources resources = mContext.getResources();

        if (description != null) {
            if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false)
             || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
                description.setTextColor(Color.WHITE);
            }
        }
        String pageName = (String) getItem(position);
        description.setText(pageName);

        radioButton.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        description.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                super.onInitializeAccessibilityEvent(host, event);
                event.setChecked(selected);
            }
            @Override
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setCheckable(true);
                info.setChecked(selected);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        HomePageSelected((int) view.getTag());
    }

    private String HomePageSelected(int position) {
        // Record the change in search engine.
        mSelectedHomePagePosition = position;
        SharedPreferences.Editor sharedPreferencesEditor = ContextUtils.getAppSharedPreferences().edit();
        sharedPreferencesEditor.putString(PREF_HOMEPAGE_SELECTION, mHomePageSelector.get(position));
        sharedPreferencesEditor.apply();
        notifyDataSetChanged();
        return mHomePageSelector.get(position);
    }

}
