package org.chromium.chrome.browser.ntp.ntp_hp.model;

import com.google.gson.annotations.SerializedName;

import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesMultiItemEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by gudd on 2024/11/8.
 */
public class MisesBitCoinModel {
    private int code;
    private List<CryptoModel> result;

    public static class CryptoModel implements MisesMultiItemEntity,Cloneable {
        private int itemType = 0;
        private int groupId;

        private String uid;
        @SerializedName("Id")
        private int id;
        private String name;
        private String symbol;
        private String slug;
        private String price;
        @SerializedName("1h")
        private double oneHour;
        @SerializedName("24h")
        private double twentyFourHour;
        @SerializedName("7d")
        private double sevenDay;
        private Date date;
        private String image;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public double getOneHour() {
            return oneHour;
        }

        public void setOneHour(double oneHour) {
            this.oneHour = oneHour;
        }

        public double getTwentyFourHour() {
            return twentyFourHour;
        }

        public void setTwentyFourHour(double twentyFourHour) {
            this.twentyFourHour = twentyFourHour;
        }

        public double getSevenDay() {
            return sevenDay;
        }

        public void setSevenDay(double sevenDay) {
            this.sevenDay = sevenDay;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Override
        public CryptoModel clone() {
            try {
                CryptoModel clone = (CryptoModel) super.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
                return clone;
            } catch (CloneNotSupportedException e) {
                return this;
            }
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CryptoModel> getResult() {
        return result;
    }

    public void setResult(List<CryptoModel> result) {
        this.result = result;
    }
}
