package org.chromium.chrome.browser.ntp.ntp_hp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesMultiItemEntity;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesNewsFeedAdapter;

/**
 * Created by gudd on 2024/11/11.
 */
public class MisesCategoryModel implements Parcelable , MisesMultiItemEntity {

    int sort;
    String title;
    String url;

    public MisesCategoryModel(int sort, String title, String url) {
        this.sort = sort;
        this.title = title;
        this.url = url;
    }

    protected MisesCategoryModel(Parcel in) {
        sort = in.readInt();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<MisesCategoryModel> CREATOR = new Creator<MisesCategoryModel>() {
        @Override
        public MisesCategoryModel createFromParcel(Parcel in) {
            return new MisesCategoryModel(in);
        }

        @Override
        public MisesCategoryModel[] newArray(int size) {
            return new MisesCategoryModel[size];
        }
    };

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(sort);
        dest.writeString(title);
        dest.writeString(url);
    }

    @Override
    public int getItemType() {
        return MisesNewsFeedAdapter.VIEW_TYPE_HEADER;
    }
}
