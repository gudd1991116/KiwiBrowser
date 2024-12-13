package org.chromium.chrome.browser.ntp.ntp_hp.net;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gudd on 2024/11/8.
 */
public class MisesNetworkHelper {
    private final static String BASE_API = "https://innews.infohubnews.app/";
    private final static String BASE_API2 = "https://192.168.1.128:7803/";
    private final static String BASE_API3 = "https://service.bosebrowser.com/";
    public final String API2_KEY = "meta_browser_sign_20241111";

    private static volatile MisesNetworkHelper instance;

    private MisesNetworkHelper(){}

    public static MisesNetworkHelper getInstance(){
        if (instance == null){
            synchronized (MisesNetworkHelper.class){
                if (instance == null){
                    instance = new MisesNetworkHelper();
                }
            }
        }
        return instance;
    }

    public MisesRestInterface getBaseApiInterface(){
        return createApiInterface(BASE_API, MisesRestInterface.class, GsonConverterFactory.create(),null);
    }

    public MisesRestInterface getBaseApi2Interface() {
        return createApiInterface(BASE_API3, MisesRestInterface.class, GsonConverterFactory.create(),null);
    }

    public MisesRestInterface getInterface(String api){
        return createApiInterface(api, MisesRestInterface.class, GsonConverterFactory.create(), null);
    }


    public static <T> T createApiInterface(String url,
                                           Class<T> apiInterface,
                                           Converter.Factory factory,
                                           Interceptor interceptor){
        // 日志拦截器
        HttpLoggingInterceptor httpLogInterceptor = new HttpLoggingInterceptor();
        httpLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 配置OkHttpClient
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(httpLogInterceptor);
        try {
            httpClientBuilder.sslSocketFactory(MisesSSLSocketClient.getSSLSocketFactory(), (X509TrustManager) MisesSSLSocketClient.getTrustManager()[0]);
            httpClientBuilder.hostnameVerifier(MisesSSLSocketClient.getHostnameVerifier());
            // 如果提供了额外的拦截器，则添加到 OkHttpClient 中
            if (interceptor != null){
                httpClientBuilder.addInterceptor(interceptor);
//                httpClientBuilder.addInterceptor(new AddHeaderInterceptor());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        OkHttpClient httpClient = httpClientBuilder.build();

        // 配置 Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(factory)
                .build();
        return retrofit.create(apiInterface);
    }

    private static class AddHeaderInterceptor implements Interceptor {

        @NonNull
        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            ResponseBody responseBody = response.peekBody(1024 * 1024);
            return response;
        }
    }
}
