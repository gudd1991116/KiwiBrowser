package org.chromium.chrome.browser.ntp.ntp_hp.fragment.currency.model;

/**
 * Created by gudd on 2024/12/4.
 */
public class MisesCurrencyBasicModel {

    private String uid;
    private String price;
    private String price_change_24h;
    private long last_updated;
    private String name;
    private String code;
    private String coingecko_id;
    private String market_cap_rank;
    private String image;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_change_24h() {
        return price_change_24h;
    }

    public void setPrice_change_24h(String price_change_24h) {
        this.price_change_24h = price_change_24h;
    }

    public long getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(long last_updated) {
        this.last_updated = last_updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoingecko_id() {
        return coingecko_id;
    }

    public void setCoingecko_id(String coingecko_id) {
        this.coingecko_id = coingecko_id;
    }

    public String getMarket_cap_rank() {
        return market_cap_rank;
    }

    public void setMarket_cap_rank(String market_cap_rank) {
        this.market_cap_rank = market_cap_rank;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
