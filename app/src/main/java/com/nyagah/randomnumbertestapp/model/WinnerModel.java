package com.nyagah.randomnumbertestapp.model;

import java.io.Serializable;
import java.util.Date;

public class WinnerModel  {

    int randomNo;
    String userInput;
    long timestamp;
    long timeDifference;

    public WinnerModel() {
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
