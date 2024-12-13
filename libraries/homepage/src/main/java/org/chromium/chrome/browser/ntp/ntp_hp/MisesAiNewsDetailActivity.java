package org.chromium.chrome.browser.ntp.ntp_hp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;

import com.bumptech.glide.Glide;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesNewsFeedAdapter;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesNewsDetailModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesTimeUtil;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gudd on 2024/11/11.
 */
public class MisesAiNewsDetailActivity extends AppCompatActivity {

    private AppCompatImageView mBack;
    private AppCompatImageView mCover;
    private AppCompatTextView mNewsTitle;
    private AppCompatTextView mNewsContent;

    private AppCompatTextView mSource,mUpdateTime;
    private AppCompatTextView mKeywordsTips, mKeywords;

    private MisesNewsFeedModel.AdsModel mModel;

    public static void startActivity(Context context, MisesNewsFeedModel.AdsModel model) {
        Intent intent = new Intent(context, MisesAiNewsDetailActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra("news_model", model);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mises_ai_news_detail_activity);

        initData();
        initView();
        initListener();
        fetchNewsDetail(mModel);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mModel = intent.getParcelableExtra("news_model");
        }
        if (mModel == null) {
            finish();
        }
    }

    private void initView() {
        mBack = findViewById(R.id.back);
        mCover = findViewById(R.id.cover);
        mNewsTitle = findViewById(R.id.newsTitle);
        mNewsContent = findViewById(R.id.newsContent);

        mSource = findViewById(R.id.source);
        mUpdateTime = findViewById(R.id.updateTime);
        mKeywordsTips = findViewById(R.id.keywords);
        mKeywords = findViewById(R.id.keywordsValue);

        if (mModel.getImages() != null && !mModel.getImages().isEmpty()) {
            Glide.with(this)
                    .load(mModel.getImages().get(0))
                    .fitCenter()
                    .into(mCover);
        }
        if (!TextUtils.isEmpty(mModel.getTitle())) {
            mNewsTitle.setText(mModel.getTitle());
        }

        if (!TextUtils.isEmpty(mModel.getContent())) {
            Parser build = new Parser.Builder().build();
            Node document = build.parse(mModel.getContent());
            HtmlRenderer renderer = new HtmlRenderer.Builder().build();
            String html = renderer.render(document);
            mNewsContent.setText(HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT));
        }
    }

    private void fetchNewsDetail(MisesNewsFeedModel.AdsModel model) {
        if (model != null) {
            String id = model.getId();
            String lang = model.getLanguage();
            Call<MisesNewsDetailModel> newsDetail = MisesNetworkHelper.getInstance().getBaseApiInterface().getNewsDetail(lang, id);
            newsDetail.enqueue(new Callback<MisesNewsDetailModel>() {
                @Override
                public void onResponse(@NonNull Call<MisesNewsDetailModel> call, @NonNull Response<MisesNewsDetailModel> response) {
                    if (response.isSuccessful()) {
                        MisesNewsDetailModel body = response.body();
                        if (body != null) {
                            MisesNewsFeedModel.AdsModel result = body.getResult();
                            refreshParamsOfPart(result);
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<MisesNewsDetailModel> call, @NonNull Throwable t) {

                }
            });
        }
    }

    // 这里只刷新部分参数，如作者、关键词
    private void refreshParamsOfPart(MisesNewsFeedModel.AdsModel model) {
        String author = model.getAuthor();
        long updated = model.getUpdated();
        List<String> keywords = model.getKeywords();

        mSource.setText(author);
        mUpdateTime.setText(MisesTimeUtil.convertTsToTime(updated));
        if (keywords != null && !keywords.isEmpty()) {
            StringBuilder kw = new StringBuilder();
            for (String key : keywords) {
                if (TextUtils.isEmpty(kw)) {
                    kw.append("   ").append(key);
                }else{
                    kw.append(key);
                }
            }
            if (TextUtils.isEmpty(kw.toString())) {
                mKeywordsTips.setVisibility(View.GONE);
                mKeywords.setVisibility(View.GONE);
            } else {
                mKeywords.setText(kw.toString());
            }
        }
    }

    private void initListener() {
        mBack.setOnClickListener(v -> finish());
    }

}
