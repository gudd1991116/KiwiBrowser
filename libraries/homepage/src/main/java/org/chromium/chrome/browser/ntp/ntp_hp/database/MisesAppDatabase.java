package org.chromium.chrome.browser.ntp.ntp_hp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import org.chromium.chrome.browser.ntp.ntp_hp.database.dao.MisesNewsFeedDao;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;

/**
 * Created by gudd on 2024/12/24.
 */
//@Database(entities = {MisesNewsFeedModel.AdsModel.class},version = 1)
public abstract class MisesAppDatabase extends RoomDatabase {
    public abstract MisesNewsFeedDao newsFeedDao();

    private static volatile MisesAppDatabase INSTANCE;

    public static MisesAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MisesAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MisesAppDatabase.class,"mises_app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
