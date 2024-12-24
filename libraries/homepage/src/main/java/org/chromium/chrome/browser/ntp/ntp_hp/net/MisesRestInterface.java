package org.chromium.chrome.browser.ntp.ntp_hp.net;

import org.chromium.chrome.browser.ntp.ntp_hp.fragment.currency.model.MisesCurrencyBasicModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBaseModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBitCoinModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesNewsDetailModel;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesTopSiteModel;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by gudd on 2024/11/8.
 */
public interface MisesRestInterface {

    @GET("ad/crypto")
    Call<MisesBitCoinModel> getCryptoList(@Query("ts") String ts);

    @GET("ad/mixnews")
    Call<MisesNewsFeedModel> getNewsList(
            @Query("cty") String cty,
            @Query("lang") String lang,
            @Query("session") String session,
            @Query("platform") String platform,
            @Query("c") String category,
            @Query("cc") String cc,
            @Query("offset") String offset,
            @Query("limit") String limit,
            @Query("ts") String secondTs);// @Query("only_ai_news") String onlyAiNewsState

    @GET
    Call<MisesNewsFeedModel> getNewsList(
            @Url String url,
            @QueryMap Map<String,String> queries);

    @GET
    Call<List<MisesCurrencyBasicModel>> getCurrencyList(
            @Url String url,
            @QueryMap Map<String,String> queries
    );

    @GET("v1/news/{language}/{id}")
    Call<MisesNewsDetailModel> getNewsDetail(@Path("language") String language, @Path("id") String newsId);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("ab/api/news/v3/categories")
    Call<MisesBaseModel<MisesCategoryModel>> getCategories(@Header("sign") String sign, @Body RequestBody body);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("ab/api/site/v3")
    Call<MisesBaseModel<MisesTopSiteModel>> getTopSites(@Header("sign") String sign, @Body RequestBody body);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("ab/api/currency/v3/list")
    Call<MisesBaseModel<MisesCurrencyBasicModel>> getCurrencyList(@Header("sign") String sign,@Body RequestBody body);


}
