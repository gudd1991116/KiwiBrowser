package org.chromium.chrome.browser.ntp.ntp_hp.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gudd on 2024/11/15.
 */
public class MisesUrlPropertyModel {
    private String host;// 例：www.baidu.com
    private String full_host; // 例：http://www.baidu.com/
    private String scheme;// 例：http
    private String path;// a/b/c
    private String full_path;// 例：a/b/c?d=1&e=f
    private String url;// 例：https://www.google.com/a/b/c?d=1&e=f

    public MisesUrlPropertyModel() {
    }

    /**
     * 构造器
     *
     * @param url        一个正确完整的url
     * @param keyExtract 需要剔除的参数key
     */
    public MisesUrlPropertyModel(String url, String[] keyExtract) {
        this.url = url;
        extractParams(keyExtract);
    }

    private void extractParams(String[] keyExtract) {
        try {
            URI uri = new URI(url);
            scheme = uri.getScheme();
            host = uri.getHost();
            path = uri.getPath();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(host)) {
                full_host = scheme + "://" + host;
            }
            Map<String, String> keepParams = getKeepParamsMap(keyExtract, uri);

            // 构建新的 URL 参数
            StringBuilder newQuery = new StringBuilder();
            keepParams.forEach((key, value) -> {
                if (newQuery.length() > 0) newQuery.append("&");
                newQuery.append(key).append("=").append(value);
            });
            // 拼接新的 URL
            if (!TextUtils.isEmpty(full_host)) {
                full_path = full_host + path + (newQuery.length() > 0 ? "?" + newQuery : "");
            }
        } catch (URISyntaxException ignore) {

        }
    }

    private static @NonNull Map<String, String> getKeepParamsMap(String[] keyExtract, URI uri) {
        String query = uri.getQuery();
        // 将 URL 参数解析为 Map
        Map<String, String> queryParams = new HashMap<>();
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                queryParams.put(pair[0], pair[1]);
            }
        }
        // 提取指定的 key 并移除它们
        if (keyExtract != null) {
            for (String key : keyExtract) {
                queryParams.remove(key);
            }
        }
        return queryParams;
    }

    public String getHost() {
        return host;
    }

    public String getFull_host() {
        return full_host;
    }

    public String getScheme() {
        return scheme;
    }

    public String getPath() {
        return path;
    }

    public String getFull_path() {
        return full_path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        extractParams(new String[]{});
    }
}
