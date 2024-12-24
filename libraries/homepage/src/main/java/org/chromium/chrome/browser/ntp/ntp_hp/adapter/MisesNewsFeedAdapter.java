package org.chromium.chrome.browser.ntp.ntp_hp.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.helper.MisesRVHorizontalItemDecoration;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnItemClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesTimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by gudd on 2024/11/11.
 */
public class MisesNewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final static String AI_NEWS = "boseai-news";

    public static final int VIEW_TYPE_ITEM = 0;    // 正常项
    public static final int VIEW_TYPE_FOOTER = 1;  // 底部加载更多
    public static final int VIEW_TYPE_HEADER = 2;  // 头部
    public boolean isLoadingFooter = false; // 用于控制FooterView的显示
    public boolean isLoadFinished = false;

    public ArrayList<MisesCategoryModel> categoryModels = new ArrayList<>();// header 频道列表
    public List<MisesNewsFeedModel.AdsModel> data = new ArrayList<>();
    private MisesOnItemClickListener<Integer> mOnItemClickListener;
    private MisesOnItemClickListener<MisesCategoryModel> mOnHeaderItemClickListener;
    private HeaderViewHolder mHeaderView;

    public void setNewData(List<MisesNewsFeedModel.AdsModel> list) {
        isLoadFinished = false;
        int startPosition = 0;
        int endPosition = data.size();
        if (!categoryModels.isEmpty()) {
            startPosition++;
            endPosition++;
        }
        data.clear();
        notifyItemRangeRemoved(startPosition, endPosition);
        addData(list);
    }

    public void setHeaderList(ArrayList<MisesCategoryModel> categories) {
        categoryModels.clear();
        categoryModels.addAll(categories);
        notifyItemChanged(0);
    }

    public void addData(List<MisesNewsFeedModel.AdsModel> list) {
        int startPosition = data.size();
        if (!categoryModels.isEmpty()) startPosition++;
        data.addAll(list);
        int endPosition = data.size();
        if (!categoryModels.isEmpty()) endPosition++;
        notifyItemRangeInserted(startPosition, endPosition);
    }

    public List<MisesNewsFeedModel.AdsModel> getData(){
        return data;
    }

    public HeaderViewHolder getHeaderView() {
        return mHeaderView;
    }

    public void setOnItemClickListener(MisesOnItemClickListener<Integer> listener) {
        this.mOnItemClickListener = listener;
    }

    // 头部recyclerview中item的点击事件
    public void setOnHeaderItemClickListener(MisesOnItemClickListener<MisesCategoryModel> listener) {
        this.mOnHeaderItemClickListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && !categoryModels.isEmpty()) {
            return VIEW_TYPE_HEADER;
        }
        return (position == data.size() + (categoryModels.isEmpty() ? 0 : 1)) ? VIEW_TYPE_FOOTER : VIEW_TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_news_feed_header_item, parent, false);
            mHeaderView = new HeaderViewHolder(root);
            return mHeaderView;
        } else if (viewType == VIEW_TYPE_ITEM) {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_news_feed_item, parent, false);
            return new BaseViewHolder(root, mOnItemClickListener);
        } else {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_item_footer_view, parent, false);
            return new FooterViewHolder(root);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).bindData(categoryModels);
            ((HeaderViewHolder) holder).setOnHeaderItemClickListener(mOnHeaderItemClickListener);
        } else if (holder instanceof BaseViewHolder) {
            if (position < data.size()) {
                if (mHeaderView != null) {
                    ((BaseViewHolder) holder).setCurChannel(mHeaderView.getSelectedChannelName());
                } else { // 目前else部分展示的是crypto新闻，所以这里手动设置为crypto
                    ((BaseViewHolder) holder).setCurChannel("crypto");
                }
                ((BaseViewHolder) holder).bindData(data.get(position));
            }
        } else if (holder instanceof FooterViewHolder) {
//            ((FooterViewHolder) holder).bind();
            ((FooterViewHolder) holder).setLoadFinished(isLoadFinished);
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = data.size();
        if (!categoryModels.isEmpty()) itemCount++;
        if (isLoadingFooter) itemCount++;
        return itemCount;
//        return data.size() + (isLoadingFooter ? 1 : 0);
    }

    // 添加FooterView
    public void showFooter() {
        Log.i("mises_log", "guddd showFooter()");
        isLoadingFooter = true;
        int lastPosition = data.size();
        notifyItemInserted(lastPosition);
    }

    // 移除FooterView，在隐藏前需要先调用showFooter()
    public void hideFooter() {
        if (isLoadingFooter) {
            Log.i("mises_log", "guddd hideFooter()");
            isLoadingFooter = false;
            int lastPosition = data.size();
            notifyItemRemoved(lastPosition);
        }
    }

    // 数据加载完成，不能加载更多了,调用这个方法前需要先调用hideFooter(),先隐藏才能添加底部footer
    public void loadFinish() {
        isLoadFinished = true;
        isLoadingFooter = true;
        int startPosition = data.size();
        notifyItemInserted(startPosition);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView mTitle;
        AppCompatTextView mSubTitle;
        AppCompatImageView mNewsImg;

        private String curChannel = "";

        public BaseViewHolder(@NonNull View itemView, MisesOnItemClickListener<Integer> listener) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mSubTitle = itemView.findViewById(R.id.subTitle);
            mNewsImg = itemView.findViewById(R.id.newsImg);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getBindingAdapterPosition());
                }
            });
        }

        public void setCurChannel(String channel) {
            curChannel = channel.toLowerCase(Locale.US);
        }

        public void bindData(MisesNewsFeedModel.AdsModel model) {
            if (model != null) {
                mTitle.setText(model.getTitle());

                String source;
                if (TextUtils.equals(curChannel, "crypto") ||
                        TextUtils.equals(curChannel, "travel") ||
                        TextUtils.equals(curChannel, "health") ||
                        TextUtils.equals(curChannel, "sports") ||
                        TextUtils.equals(curChannel, "food")) {

                    if (model.getType().equals("boseai-news")) {
                        source = "Powered By Boser";
                    } else {
                        if (model.getAdditional() != null) {
                            String contentSourceDisplay = model.getAdditional().getContentSourceDisplay();
                            if (!TextUtils.isEmpty(contentSourceDisplay)) {
                                source = contentSourceDisplay;
                            } else {
                                source = model.getType();
                            }
                        } else {
                            source = model.getType();
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(model.getChannel_name())) {
                        source = model.getChannel_name();
                    } else {
                        if (model.getAdditional() != null) {
                            String contentSourceDisplay = model.getAdditional().getContentSourceDisplay();
                            if (!TextUtils.isEmpty(contentSourceDisplay)) {
                                source = contentSourceDisplay;
                            } else {
                                source = model.getType();
                            }
                        } else {
                            source = model.getType();
                        }
                    }
                }
                String time = "";
                if (model.getAdditional() != null) {
                    long publishAt = model.getAdditional().getPublishedAt();
                    time = MisesTimeUtil.convertTsToTime(publishAt);
                }
                mSubTitle.setText(source + "·" + time);

                List<String> images = model.getImages();
                if (images != null && !images.isEmpty()) {
//                    mNewsImg.setVisibility(View.VISIBLE);
                    String imageUrl = images.get(0);
                    Glide.with(mNewsImg)
                            .load(imageUrl)
                            .apply(new RequestOptions().transform(new CenterCrop(), new RoundedCorners(16)))
                            .into(mNewsImg);

                } else {
//                    mNewsImg.setVisibility(View.GONE);
                }
            }
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private MisesOnItemClickListener<MisesCategoryModel> mHeaderItemClickListener;
        RecyclerView categoryRv;
        private final MisesNewsCategoriesAdapter mCategoryAdapter;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryRv = itemView.findViewById(R.id.category_rv);
            Context context = categoryRv.getContext();
            categoryRv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            categoryRv.setHasFixedSize(true);
            categoryRv.addItemDecoration(
                    new MisesRVHorizontalItemDecoration(
                            context,
                            7,
                            12,
                            7,
                            0,
                            0,
                            0)
            );
            mCategoryAdapter = new MisesNewsCategoriesAdapter();
            categoryRv.setAdapter(mCategoryAdapter);
        }

        public void setOnHeaderItemClickListener(MisesOnItemClickListener<MisesCategoryModel> listener) {
            this.mHeaderItemClickListener = listener;
        }

        public String getSelectedChannelName() {
            if (mCategoryAdapter != null && mCategoryAdapter.getSelectedItem() != null) {
                return mCategoryAdapter.getSelectedItem().getTitle();
            } else {
                return "";
            }
        }

        public void bindData(ArrayList<MisesCategoryModel> models) {
            mCategoryAdapter.setNewData(models);
            mCategoryAdapter.setOnItemClickListener(position -> {
                List<MisesCategoryModel> data = mCategoryAdapter.getData();
                if (data != null && !data.isEmpty()) {
                    MisesCategoryModel misesCategoryModel = data.get(position);
                    if (mHeaderItemClickListener != null) {
                        mHeaderItemClickListener.onItemClick(misesCategoryModel);
                    }
                }
            });
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView loadingText;
        private final AppCompatImageView loadingProgress;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            loadingText = itemView.findViewById(R.id.loadingText);
            loadingProgress = itemView.findViewById(R.id.loadingProgress);
        }

        public void setLoadFinished(boolean isFinish) {
            String text = "Loading";
            if (isFinish) {
                loadingProgress.setVisibility(View.GONE);
                text = "No more data";
            } else {
                loadingProgress.setVisibility(View.VISIBLE);
                Glide.with(loadingProgress.getContext())
                        .asGif()
                        .load(R.drawable.icon_loading)
                        .into(loadingProgress);
            }
            loadingText.setText(text);
        }
    }


}
