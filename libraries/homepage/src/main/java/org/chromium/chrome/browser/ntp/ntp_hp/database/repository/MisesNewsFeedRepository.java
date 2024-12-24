package org.chromium.chrome.browser.ntp.ntp_hp.database.repository;

import android.content.Context;

import org.chromium.chrome.browser.ntp.ntp_hp.database.MisesAppDatabase;
import org.chromium.chrome.browser.ntp.ntp_hp.database.dao.MisesNewsFeedDao;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;

import java.util.List;

import io.reactivex.Completable;

/**
 * Created by gudd on 2024/12/24.
 */
public class MisesNewsFeedRepository {

    private final MisesNewsFeedDao newsFeedDao;

    public MisesNewsFeedRepository(
            Context context
    ){
        MisesAppDatabase database = MisesAppDatabase.getInstance(context);
        this.newsFeedDao = database.newsFeedDao();
    }

    public Completable insertNewsList(List<MisesNewsFeedModel> newsFeedModels){
        if (newsFeedModels != null && newsFeedModels.isEmpty()){

        }
        return null;
    }
}
