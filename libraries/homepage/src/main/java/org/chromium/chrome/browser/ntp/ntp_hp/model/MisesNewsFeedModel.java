package org.chromium.chrome.browser.ntp.ntp_hp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesMultiItemEntity;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesNewsFeedAdapter;

import java.util.List;

/**
 * Created by gudd on 2024/11/8.
 */
public class MisesNewsFeedModel {

    private List<AdsModel> ads;

    public List<AdsModel> getAds() {
        return ads;
    }

    public void setAds(List<AdsModel> ads) {
        this.ads = ads;
    }

    public static class AdsModel implements Parcelable , MisesMultiItemEntity {
        @SerializedName("_id")
        private String id;
        private String language;
        private String type;
        private String content;
        private String link;
        private String title;
        private String description;
        private List<String> images;
        private EventModel events;
        private AdditionalModel additional;

        // 下面这些在获取详情页信息时才返回，列表中不返回
        private String channel_name;
        private String channel_image;
        private String summary;
        private long updated;
        private List<String> channel_categories;
        private List<String> keywords;
        private String author;
        private String channel_id;
        private float score;
        private int views;


        protected AdsModel(Parcel in) {
            id = in.readString();
            language = in.readString();
            type = in.readString();
            content = in.readString();
            link = in.readString();
            title = in.readString();
            description = in.readString();
            images = in.createStringArrayList();
            events = in.readParcelable(EventModel.class.getClassLoader());
            additional = in.readParcelable(AdditionalModel.class.getClassLoader());
            channel_name = in.readString();
            channel_image = in.readString();
            summary = in.readString();
            updated = in.readLong();
            channel_categories = in.createStringArrayList();
            keywords = in.createStringArrayList();
            author = in.readString();
            channel_id = in.readString();
            score = in.readFloat();
            views = in.readInt();
        }

        public static final Creator<AdsModel> CREATOR = new Creator<AdsModel>() {
            @Override
            public AdsModel createFromParcel(Parcel in) {
                return new AdsModel(in);
            }

            @Override
            public AdsModel[] newArray(int size) {
                return new AdsModel[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public EventModel getEvents() {
            return events;
        }

        public void setEvents(EventModel events) {
            this.events = events;
        }

        public AdditionalModel getAdditional() {
            return additional;
        }

        public void setAdditional(AdditionalModel additional) {
            this.additional = additional;
        }

        public String getChannel_name() {
            return channel_name;
        }

        public void setChannel_name(String channel_name) {
            this.channel_name = channel_name;
        }

        public String getChannel_image() {
            return channel_image;
        }

        public void setChannel_image(String channel_image) {
            this.channel_image = channel_image;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }

        public List<String> getChannel_categories() {
            return channel_categories;
        }

        public void setChannel_categories(List<String> channel_categories) {
            this.channel_categories = channel_categories;
        }

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {

            dest.writeString(id);
            dest.writeString(language);
            dest.writeString(type);
            dest.writeString(content);
            dest.writeString(link);
            dest.writeString(title);
            dest.writeString(description);
            dest.writeStringList(images);
            dest.writeParcelable(events, flags);
            dest.writeParcelable(additional, flags);
            dest.writeString(channel_name);
            dest.writeString(channel_image);
            dest.writeString(summary);
            dest.writeLong(updated);
            dest.writeStringList(channel_categories);
            dest.writeStringList(keywords);
            dest.writeString(author);
            dest.writeString(channel_id);
            dest.writeFloat(score);
            dest.writeInt(views);
        }

        @Override
        public int getItemType() {
            return MisesNewsFeedAdapter.VIEW_TYPE_ITEM;
        }
    }

    public static class EventModel implements Parcelable{
        private String available;
        private String visible;

        protected EventModel(Parcel in) {
            available = in.readString();
            visible = in.readString();
        }

        public static final Creator<EventModel> CREATOR = new Creator<EventModel>() {
            @Override
            public EventModel createFromParcel(Parcel in) {
                return new EventModel(in);
            }

            @Override
            public EventModel[] newArray(int size) {
                return new EventModel[size];
            }
        };

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getVisible() {
            return visible;
        }

        public void setVisible(String visible) {
            this.visible = visible;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(available);
            dest.writeString(visible);
        }
    }

    public static class AdditionalModel implements Parcelable{
        private long publishedAt;
        private String contentSourceDisplay;
        private String contentSourceLogo;

        protected AdditionalModel(Parcel in) {
            publishedAt = in.readLong();
            contentSourceDisplay = in.readString();
            contentSourceLogo = in.readString();
        }

        public static final Creator<AdditionalModel> CREATOR = new Creator<AdditionalModel>() {
            @Override
            public AdditionalModel createFromParcel(Parcel in) {
                return new AdditionalModel(in);
            }

            @Override
            public AdditionalModel[] newArray(int size) {
                return new AdditionalModel[size];
            }
        };

        public long getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(long publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getContentSourceDisplay() {
            return contentSourceDisplay;
        }

        public void setContentSourceDisplay(String contentSourceDisplay) {
            this.contentSourceDisplay = contentSourceDisplay;
        }

        public String getContentSourceLogo() {
            return contentSourceLogo;
        }

        public void setContentSourceLogo(String contentSourceLogo) {
            this.contentSourceLogo = contentSourceLogo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeLong(publishedAt);
            dest.writeString(contentSourceDisplay);
            dest.writeString(contentSourceLogo);
        }
    }
}
