package com.nyagah.randomnumbertestapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nyagah.randomnumbertestapp.entity.WinnerEntity;

@Dao
public interface WinnerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWinnerData(WinnerEntity entity);

  /*  //Select all winner data
    @Query("select * from winners")
    List<WinnerModel> getAllData();*/

    @Query("select timestamp from winners order by id desc limit 1")
    long getTimestamps();

}
