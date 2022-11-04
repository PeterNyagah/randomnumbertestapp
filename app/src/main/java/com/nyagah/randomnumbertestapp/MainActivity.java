package com.nyagah.randomnumbertestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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

                        randomNo = generateRandomNo();
                    } else {
                        Log.i("Random No", "Wrong");
                        Toast.makeText(MainActivity.this, "Wrong guess: Try again! ", Toast.LENGTH_LONG).show();
//                        https://www.geeksforgeeks.org/how-to-perform-crud-operations-in-room-database-in-android/
                    }
                }
            }
        });

    }

    //Generate the random number
    private int generateRandomNo() {
        return (int) (Math.random() * range) + lowerBound;
    }


}