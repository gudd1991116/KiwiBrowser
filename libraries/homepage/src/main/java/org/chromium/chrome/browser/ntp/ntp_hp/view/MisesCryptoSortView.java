package org.chromium.chrome.browser.ntp.ntp_hp.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import org.chromium.chrome.browser.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by gudd on 2024/12/3.
 */
public class MisesCryptoSortView extends ConstraintLayout {

    private AppCompatTextView mTypeName;
    private AppCompatImageView mArrowUp, mArrowDown;

    private String typeName;
    private int selectedColor;
    private int defaultColor;
    private int defaultSort;

    public MisesCryptoSortView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MisesCryptoSortView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.mises_crypto_sort_view, this, true);

        initView();
    }

    private void init(Context context, AttributeSet attrs) {
        // 使用 TypedArray 解析自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MisesCryptoSortView);
        typeName = typedArray.getString(R.styleable.MisesCryptoSortView_mises_type_name);
        selectedColor = typedArray.getColor(R.styleable.MisesCryptoSortView_mises_selected_color, ContextCompat.getColor(context, R.color.mises_tab_selected));
        defaultColor = typedArray.getColor(R.styleable.MisesCryptoSortView_mises_default_color, ContextCompat.getColor(context, R.color.mises_tab_unselected));
        defaultSort = typedArray.getInt(R.styleable.MisesCryptoSortView_mises_default_sort, 0);

        typedArray.recycle();
    }

    private void initView() {
        mTypeName = findViewById(R.id.sortTypeName);
        mArrowUp = findViewById(R.id.arrow_up);
        mArrowDown = findViewById(R.id.arrow_down);

        if (!TextUtils.isEmpty(typeName)) {
            mTypeName.setText(typeName);
        }
        setData();
    }

    public void setTypeName(String typeName){
        if (!TextUtils.isEmpty(typeName)){
            mTypeName.setText(typeName);
        }
    }

    public void setSortType(@SortType int sortType){
        defaultSort = sortType;
        setData();
    }

    public int getSortType() {
        return defaultSort;
    }

    private void setData(){
        mArrowUp.setImageTintList(ColorStateList.valueOf(defaultColor));
        mArrowDown.setImageTintList(ColorStateList.valueOf(defaultColor));
        mTypeName.setTextColor(selectedColor);
        if (defaultSort == SortType.DESC) {
            mArrowDown.setImageTintList(ColorStateList.valueOf(selectedColor));
        } else if (defaultSort == SortType.ASC) {
            mArrowUp.setImageTintList(ColorStateList.valueOf(selectedColor));
        }else {
            mTypeName.setTextColor(defaultColor);
        }
    }

    @IntDef({SortType.DEFAULT, SortType.DESC, SortType.ASC})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SortType {
        int DEFAULT = 0;
        int DESC = 1;
        int ASC = 2;
    }
}
