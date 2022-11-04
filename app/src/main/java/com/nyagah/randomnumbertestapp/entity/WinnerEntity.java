package com.nyagah.randomnumbertestapp.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "winners")
public class WinnerEntity {

    //Primary key
    @PrimaryKey(autoGenerate = true)
    @NonNull
    protected int id;

    @ColumnInfo(name = "randomNo")
    int randomNo;

    @ColumnInfo(name = "userInput")
    String userInput;

    @ColumnInfo(name = "timestamp")
    long timestamp;

    @ColumnInfo(name = "timeDifference")
    long timeDifference;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRandomNo() {
        return randomNo;
    }

    public void setRandomNo(int randomNo) {
        this.randomNo = randomNo;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(long timeDifference) {
        this.timeDifference = timeDifference;
    }
}
