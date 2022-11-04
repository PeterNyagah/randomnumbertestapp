package com.nyagah.randomnumbertestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.nyagah.randomnumbertestapp.entity.WinnerEntity;
import com.nyagah.randomnumbertestapp.model.WinnerModel;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtRandomNo;
    EditText edUserInput;
    Button btnPlay;
    int upperBound = 50;
    int lowerBound = 1;
    int randomNo;

    // upperBound 50 will also be included
    int range = (upperBound - lowerBound) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNo = generateRandomNo();
        txtRandomNo = findViewById(R.id.txtRandomNo);
        edUserInput = findViewById(R.id.edUserInput);
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = edUserInput.getText().toString();

                if (userInput.isEmpty()) {
                    edUserInput.setError("Please guess a number!");
                } else {
                    Log.i("User Input", String.valueOf(userInput));
                    Log.i("Random No", String.valueOf(randomNo));

                    if (randomNo == Integer.valueOf(userInput)) {
                        Toast.makeText(MainActivity.this, "Correct: You got it right!", Toast.LENGTH_LONG).show();
                        Log.i("Random No", "Correct");

                        Date date = new Date();
                        long timeMilli = date.getTime();

                        saveGameDetails(randomNo, userInput, timeMilli);
                        randomNo = generateRandomNo();
                    } else {
                        Log.i("Random No", "Wrong");
                        Toast.makeText(MainActivity.this, "Wrong guess: Try again! ", Toast.LENGTH_LONG).show();
//
                    }
                }
            }
        });

    }

    private void saveGameDetails(int randomNo, String userInput, long timeMilli) {

        WinnerEntity winnerModel = new WinnerEntity();

        winnerModel.setRandomNo(randomNo);
        winnerModel.setUserInput(userInput);
        winnerModel.setTimestamp(timeMilli);

        long previousTimestamp = DatabaseClass.getDatabase(getApplicationContext()).getDao().getTimestamps();

        Date date1 = new Date(previousTimestamp);
        Date date2 = new Date(timeMilli);

        long timeDiff = date2.getTime() - date1.getTime();

        if (previousTimestamp > 0) {
            winnerModel.setTimeDifference(timeDiff);
        }


        DatabaseClass.getDatabase(getApplicationContext()).getDao().insertWinnerData(winnerModel);
        Log.i("Success", "Data stored successfully");
    }

    //Generate the random number
    private int generateRandomNo() {
        return (int) (Math.random() * range) + lowerBound;
    }


}