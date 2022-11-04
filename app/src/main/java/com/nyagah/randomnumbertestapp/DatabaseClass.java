package com.nyagah.randomnumbertestapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nyagah.randomnumbertestapp.dao.WinnerDao;
import com.nyagah.randomnumbertestapp.entity.WinnerEntity;

@Database(entities = {WinnerEntity.class}, version = 1, exportSchema = false)
public abstract class DatabaseClass extends RoomDatabase {

    public abstract WinnerDao getDao();

    private static DatabaseClass instance;

    static DatabaseClass getDatabase(final Context context) {

        if (instance == null) {

            synchronized (DatabaseClass.class) {
                instance = Room.databaseBuilder(context, DatabaseClass.class, "DATABASE").allowMainThreadQueries().build();
            }
        }

        return instance;
    }
}
