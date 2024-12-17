package org.chromium.chrome.browser.ntp.ntp_hp.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBitCoinModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnItemClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesNumberUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.view.MisesCryptoSortView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gudd on 2024/11/11.
 */
public class MisesCryptoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MisesBitCoinModel.CryptoModel> mData = new ArrayList<>();
    private MisesOnItemClickListener<Integer> mOnItemClickListener;
    private OnSortCurrencyListener mSortCurrencyListener;

    public final static int TYPE_FAVORITE_TITLE = 0;
    public final static int TYPE_FAVORITE_COIN = 1;
    public final static int TYPE_ALL_CURRENCY_TITLE = 2;
    public final static int TYPE_ALL_CURRENCY_COIN = 3;

    public final static int GROUP_ID_FAVORITE = 0;
    public final static int GROUP_ID_ALL = 1;

    // 保存HeaderHolder的引用
    private HeaderViewHolder mHeaderViewHolder;


    public void setNewData(List<MisesBitCoinModel.CryptoModel> list) {
        mData.clear();
        /*mData.addAll(list);
        notifyDataSetChanged();*/
        addData(list);
    }

    public List<MisesBitCoinModel.CryptoModel> getData() {
        return mData;
    }

    public MisesBitCoinModel.CryptoModel getItemData(int position) {
        if (position < mData.size()) {
            return mData.get(position);
        }
        return null;
    }

    public void addData(MisesBitCoinModel.CryptoModel currencyModel) {
        mData.add(0, currencyModel);
        notifyItemInserted(0);
    }

    public void addData(List<MisesBitCoinModel.CryptoModel> list) {
        int positionStart = mData.size();
        mData.addAll(list);
        notifyItemRangeInserted(positionStart, mData.size());
    }

    public void addData(int position, List<MisesBitCoinModel.CryptoModel> list) {
        mData.addAll(position, list);
        notifyItemRangeInserted(position, list.size());
    }

    public void setOnItemClickListener(MisesOnItemClickListener<Integer> listener) {
        this.mOnItemClickListener = listener;
    }

    public void setSortCurrencyListener(OnSortCurrencyListener listener) {
        this.mSortCurrencyListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        MisesMultiItemEntity misesMultiItemEntity = mData.get(position);
        return misesMultiItemEntity.getItemType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_FAVORITE_TITLE || viewType == TYPE_ALL_CURRENCY_TITLE) {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_crypto_header_item, parent, false);
            HeaderViewHolder viewHolder = new HeaderViewHolder(root);
            if (viewType == TYPE_ALL_CURRENCY_TITLE) {
                mHeaderViewHolder = viewHolder;
            }
            return viewHolder;
        } else /*if (viewType == TYPE_FAVORITE_COIN || viewType == TYPE_ALL_CURRENCY_COIN)*/ {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.mises_crypto_item, parent, false);
            return new CryptoViewHolder(root, mOnItemClickListener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MisesBitCoinModel.CryptoModel misesMultiItemEntity = mData.get(position);
        if (misesMultiItemEntity != null) {
            if (holder instanceof CryptoViewHolder) {
                ((CryptoViewHolder) holder).setData(misesMultiItemEntity);
            } else if (holder instanceof HeaderViewHolder) {
                ((HeaderViewHolder) holder).bindData(misesMultiItemEntity);
                ((HeaderViewHolder) holder).showMenu(misesMultiItemEntity.getItemType() == TYPE_ALL_CURRENCY_TITLE);
                ((HeaderViewHolder) holder).setSortCurrencyListener(mSortCurrencyListener);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateGroup(int groupId, List<MisesBitCoinModel.CryptoModel> newGroupItems) {
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < mData.size(); i++) {
            MisesBitCoinModel.CryptoModel misesMultiItemEntity = mData.get(i);
            if (misesMultiItemEntity != null) {
                if (misesMultiItemEntity.getGroupId() == groupId) {
                    if (misesMultiItemEntity.getItemType() == TYPE_FAVORITE_TITLE && startIndex == -1) {
                        startIndex = i;
                    }
                }else if (misesMultiItemEntity.getItemType() == TYPE_ALL_CURRENCY_TITLE && endIndex == -1) {
                    endIndex = i ;
                }
            }
        }

        if (startIndex < 0
                || endIndex < 0
                || startIndex > mData.size()
                || endIndex > mData.size()
                || startIndex == endIndex) {
            return;
        }

        // 移除旧分组数据
        int deleteCount = endIndex - startIndex -1;
        if (deleteCount > 0 ) {
            mData.subList(startIndex + 1, endIndex).clear();
        }
        notifyItemRangeRemoved(startIndex + 1, deleteCount);
        if (!newGroupItems.isEmpty()) {
            Log.i("mises_log","addData startIndex : "+ startIndex+1+", newGroupItems : "+ newGroupItems.size());
            addData(startIndex + 1,newGroupItems);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private boolean mShowMenu = false;
        private final MisesCryptoSortView mByPrice;
        private final MisesCryptoSortView mBy24H;
        private final AppCompatTextView mHeaderName;

        public MisesCryptoSortView getByPrice() {
            return mByPrice;
        }

        public MisesCryptoSortView getBy24H() {
            return mBy24H;
        }

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeaderName = itemView.findViewById(R.id.headerTitle);
            mByPrice = itemView.findViewById(R.id.bySort);
            mBy24H = itemView.findViewById(R.id.byRate24);
            showMenu(mShowMenu);
        }

        public void bindData(MisesBitCoinModel.CryptoModel item) {
            String name = item.getName();
            mHeaderName.setText(name);
        }

        public void showMenu(boolean showMenu) {
            this.mShowMenu = showMenu;
            if (mShowMenu) {
                mByPrice.setVisibility(View.VISIBLE);
                mBy24H.setVisibility(View.VISIBLE);
            } else {
                mByPrice.setVisibility(View.GONE);
                mBy24H.setVisibility(View.GONE);
            }
        }

        public void setSortCurrencyListener(OnSortCurrencyListener listener) {
            mByPrice.setOnClickListener(v -> {
                mBy24H.setSortType(MisesCryptoSortView.SortType.DEFAULT);
                int sortType = mByPrice.getSortType();
                int finalSortType;
                if (sortType == MisesCryptoSortView.SortType.DEFAULT || sortType == MisesCryptoSortView.SortType.ASC) {
                    mByPrice.setSortType(MisesCryptoSortView.SortType.DESC);
                    finalSortType = MisesCryptoSortView.SortType.DESC;
                } else {
                    mByPrice.setSortType(MisesCryptoSortView.SortType.ASC);
                    finalSortType = MisesCryptoSortView.SortType.ASC;
                }
                if (listener != null) {
                    listener.onPriceSort(getBindingAdapterPosition(), finalSortType);
                }
            });

            mBy24H.setOnClickListener(v -> {
                mByPrice.setSortType(MisesCryptoSortView.SortType.DEFAULT);
                int sortType = mBy24H.getSortType();
                int finalSortType;
                if (sortType == MisesCryptoSortView.SortType.DEFAULT || sortType == MisesCryptoSortView.SortType.ASC) {
                    mBy24H.setSortType(MisesCryptoSortView.SortType.DESC);
                    finalSortType = MisesCryptoSortView.SortType.DESC;
                } else {
                    mBy24H.setSortType(MisesCryptoSortView.SortType.ASC);
                    finalSortType = MisesCryptoSortView.SortType.ASC;
                }
                if (listener != null) {
                    listener.onTwentyFourHour(getBindingAdapterPosition(), finalSortType);
                }
            });
        }
    }

    public static class CryptoViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView icon;
        AppCompatTextView name;
        AppCompatTextView price;
        AppCompatTextView symbol;
        AppCompatTextView rate;

        public CryptoViewHolder(@NonNull View itemView, MisesOnItemClickListener<Integer> listener) {
            super(itemView);
            icon = itemView.findViewById(R.id.coin_icon);
            name = itemView.findViewById(R.id.coin_name);
            price = itemView.findViewById(R.id.price);
            symbol = itemView.findViewById(R.id.coin_symbol);
            rate = itemView.findViewById(R.id.price_rate);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(getBindingAdapterPosition());
                }
            });
        }

        public void setData(MisesBitCoinModel.CryptoModel data) {
//            String bitCoinImg = "https://service.bosebrowser.com/img/" + data.getSymbol() + ".png";
            name.setText(data.getSymbol().toUpperCase());
            String coinPrice = data.getPrice();
            if (!TextUtils.isEmpty(coinPrice)) {
                try {
                    double dPrice = Double.parseDouble(coinPrice);
                    Log.i("mises_log", "需要转的值：" + coinPrice);
                    String priceStr = "$" + MisesNumberUtil.retainTwoDecimalPlaces(coinPrice);
                    Log.i("mises_log", "转完后的值：" + priceStr);
                    price.setText(priceStr);
                } catch (NumberFormatException e) {
                    Log.e("mises_log", "Coin price convert failed. Error message : " + e.getMessage());
                }
            }
            symbol.setText(data.getName());
            String twentyRate = MisesNumberUtil.formatToPercentage(data.getTwentyFourHour(), true);
            if (!twentyRate.startsWith("-")) {
                twentyRate = "+" + twentyRate;
            }
            rate.setText(twentyRate);
            int rateTextColor;
            if (data.getTwentyFourHour() > 0) {
                rateTextColor = Color.parseColor("#1BBB31");
            } else {
                rateTextColor = Color.parseColor("#F94D4D");
            }
            rate.setTextColor(rateTextColor);

            Glide.with(icon)
                    .load(data.getImage())
                    .fitCenter()
                    .into(icon);
        }
    }

    /**
     * 获取当前货币应当如何排序的配置
     * isByPrice ：是否按价格排序，按价格时为1，否则为24小时排序.
     * sortType  ：排序类型，1:desc 降序 ；2：asc 升序.
     *
     * @return 一个长度为2的数组列表。index=0：是否是按价格排序;index=1:降序或升序.
     */
    public int getSortType() {
        int sortType = MisesSortTypeEnum.UNSORTED;// 默认是按当前价格降序排列

        if (mHeaderViewHolder != null) {
            MisesCryptoSortView byPrice = mHeaderViewHolder.getByPrice();
            MisesCryptoSortView by24H = mHeaderViewHolder.getBy24H();
            if (byPrice != null && by24H != null) {
                int sortTypeWithPrice = byPrice.getSortType();
                int sortTypeWith24H = by24H.getSortType();
                if (sortTypeWithPrice != MisesCryptoSortView.SortType.DEFAULT) {
                    if (sortTypeWithPrice == MisesCryptoSortView.SortType.DESC) {
                        sortType = MisesSortTypeEnum.PRICE_DESC;
                    } else {
                        sortType = MisesSortTypeEnum.PRICE_ASC;
                    }
                } else if (sortTypeWith24H != MisesCryptoSortView.SortType.DEFAULT) {
                    if (sortTypeWith24H == MisesCryptoSortView.SortType.DESC) {
                        sortType = MisesSortTypeEnum.RATE_DESC;
                    } else {
                        sortType = MisesSortTypeEnum.RATE_ASC;
                    }
                }
            }
        }

        return sortType;
    }

    public interface OnSortCurrencyListener {
        void onPriceSort(int position, @MisesCryptoSortView.SortType int type);

        void onTwentyFourHour(int position, @MisesCryptoSortView.SortType int type);
    }
}
