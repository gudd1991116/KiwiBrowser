package org.chromium.chrome.browser.ntp.ntp_hp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnItemClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesTopSiteModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudd on 2024/11/8.
 */
public class MisesTopSiteAdapter extends RecyclerView.Adapter<MisesTopSiteAdapter.ItemViewHolder> {
    private MisesOnItemClickListener<Integer> mListener;
    public final List<MisesTopSiteModel> data = new ArrayList<>();

    public void setNewData(List<MisesTopSiteModel> list) {
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void addManualData(MisesTopSiteModel model) {
        if (!data.isEmpty()) {
            int insertPosition = data.size() - 1;
            data.add(insertPosition, model);
            notifyItemInserted(insertPosition);
        }
    }

    public List<MisesTopSiteModel> getData() {
        return data;
    }

    public void setOnItemClickListener(MisesOnItemClickListener<Integer> listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_topsite_item_view, parent,false);
        return new ItemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView mIcon;
        private final AppCompatTextView mText;

        public ItemViewHolder(@NonNull View itemView, MisesOnItemClickListener<Integer> listener) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon);
            mText = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getBindingAdapterPosition());
                }
            });

            /*// 设置item的宽度为屏幕减去左右margin的五分之一
            // 屏幕宽度
            int screenWidth = MisesDensityUtil.screenWidth(itemView.getContext());
            int lrPadding = MisesDensityUtil.dip2px(itemView.getContext(),20);
            int itemWidth = (screenWidth - lrPadding) / 5;
            RecyclerView.LayoutParams rlParams = new RecyclerView.LayoutParams(itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(rlParams);*/
        }

        public void setData(MisesTopSiteModel model) {
            String name = model.getText();
            if (!TextUtils.isEmpty(name)) {
                mText.setText(name);
            }

            String imgUrl = model.getImgUrl();
            if (!TextUtils.isEmpty(imgUrl)) {
                Glide.with(mIcon)
                        .load(imgUrl)
                        .apply(new RequestOptions().transform(new CenterCrop(), new RoundedCorners(100)))
                        .into(mIcon);
            }
        }
    }
}
