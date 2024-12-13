package org.chromium.chrome.browser.ntp.ntp_hp.helper;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import org.chromium.chrome.browser.R;

/**
 * Created by gudd on 2024/11/12.
 */
public class MisesAddTopSiteDialog {
    private final Context mContext;
    private AlertDialog mDialog = null;

    private AppCompatEditText mInputName, mInputAddress;
    private AppCompatTextView mCancel, mConfirm;

    private OnAddResultListener mListener;

    public MisesAddTopSiteDialog(Context context) {
        this.mContext = context;

        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.mises_dialog_add_topsite, null);

        mInputName = dialogView.findViewById(R.id.input_web_name);
        mInputAddress = dialogView.findViewById(R.id.input_web_address);
        mCancel = dialogView.findViewById(R.id.cancel);
        mConfirm = dialogView.findViewById(R.id.ok);

        mCancel.setOnClickListener(v -> {
            if (mDialog != null) {
                mDialog.dismiss();
            }
        });

        mConfirm.setOnClickListener(v -> {
            if (mListener != null) {
                String name = "", address = "";
                Editable text = mInputName.getText();
                Editable url = mInputAddress.getText();
                if (text != null) {
                    name = text.toString();
                }
                if (url != null) {
                    address = url.toString();
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, "Please enter the website name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address) || !address.startsWith("https://") || (address.startsWith("https://") && address.length() < 9)) {
                    Toast.makeText(context, "Please enter the correct website address", Toast.LENGTH_SHORT).show();
                    return;
                }

                mListener.onConfirm(name, address);
                if (mDialog != null) {
                    mDialog.dismiss();
                }
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.dialogStyle);
        builder.setView(dialogView);
        mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(true);

        Window window = mDialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
//            int margin = DensityUtils.dip2px(mContext, 50);
            window.getDecorView().setPadding(0, 0, 0, 0);
//            window.setWindowAnimations(R.style.dialogAnimStyle);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }
    }

    public MisesAddTopSiteDialog setOnAddResult(OnAddResultListener listener) {
        this.mListener = listener;
        return this;
    }

    public void showDialog() {
        if (mContext != null && mContext instanceof Activity) {
            Activity activity = (Activity) mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        if (mContext == null) {
            return;
        }
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public interface OnAddResultListener {
        void onConfirm(String name, String url);
    }
}
