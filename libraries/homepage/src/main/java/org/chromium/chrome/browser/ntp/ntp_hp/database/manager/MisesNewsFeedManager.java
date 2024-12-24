package org.chromium.chrome.browser.ntp.ntp_hp.database.manager;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

import org.chromium.chrome.browser.ntp.ntp_hp.database.MisesResultCallback;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.database.repository.MisesNewsFeedRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gudd on 2024/12/24.
 */
public class MisesNewsFeedManager {
    private final MisesNewsFeedRepository newsFeedRepository;

    public MisesNewsFeedManager(Context context) {
        this.newsFeedRepository = new MisesNewsFeedRepository(context);
    }

    public void insertNewsList(List<MisesNewsFeedModel> list , LifecycleOwner lifecycleOwner, MisesResultCallback<Void> callback){
        newsFeedRepository.insertNewsList(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(new CompletableTransformer() {
                    @Override
                    public CompletableSource apply(Completable upstream) {
                        return null;
                    }
                })
                .subscribe(()->callback.onSuccess(null),callback::onError );
    }


}
