package org.chromium.chrome.browser.ntp.ntp_hp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudd on 2024/12/2.
 */
public class MisesNewsCategoriesAdapter extends RecyclerView.Adapter<MisesNewsCategoriesAdapter.NewsCategoriesViewHolder> {

    private final ArrayList<MisesCategoryModel> mData = new ArrayList<>();

    private MisesOnItemClickListener<Integer> mMisesOnItemClickListener;
    private int selectedPosition = 0;

    public void setNewData(ArrayList<MisesCategoryModel> newData) {
        mData.clear();
        mData.addAll(newData);
        notifyDataSetChanged();
    }

    public void addData(ArrayList<MisesCategoryModel> data) {
        int positionStart = mData.size();
        mData.addAll(data);
        notifyItemRangeChanged(positionStart, mData.size());
    }

    public List<MisesCategoryModel> getData() {
        return mData;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public MisesCategoryModel getSelectedItem() {
        if (getData() != null && getSelectedPosition() < getData().size()) {
            return getData().get(getSelectedPosition());
        } else {
            return null;
        }
    }

    @NonNull
    @Override
    public NewsCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_news_category_item, parent, false);
        return new NewsCategoriesViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCategoriesViewHolder holder, int position) {
        holder.setData(mData.get(position));

        holder.mItemView.setSelected(selectedPosition == position);
        holder.mTextView.setTextColor(
                ContextCompat.getColor(holder.mItemView.getContext(),
                        selectedPosition == position
                                ? R.color.mises_tab_selected
                                : R.color.mises_tab_unselected)
        );
        holder.mItemView.setOnClickListener(v -> {
            int previousPosition = selectedPosition;
            selectedPosition = holder.getBindingAdapterPosition();

            notifyItemChanged(previousPosition);
            notifyItemChanged(selectedPosition);

            if (mMisesOnItemClickListener != null) {
                mMisesOnItemClickListener.onItemClick(holder.getBindingAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(MisesOnItemClickListener<Integer> listener) {
        this.mMisesOnItemClickListener = listener;
    }

    public static class NewsCategoriesViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout mItemView;
        AppCompatTextView mTextView;

        public NewsCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView.findViewById(R.id.itemView);
            mTextView = itemView.findViewById(R.id.category);
        }

        public void setData(MisesCategoryModel model) {
            String title = model.getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (TextUtils.equals(title.toLowerCase(), "Headline".toLowerCase())) {
                    title = "All";
                }
                mTextView.setText(title);
            }
        }
    }
}
