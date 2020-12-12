package com.example.g_29guessgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class  MainActivity extends AppCompatActivity{
    int randomNumber;
    int tries=5;
    int score=5;

    private void generateNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(5) +1;

    }

    public  void playGame(View View) {
        Log.i("INFO", "PLAY GAME");
        EditText Number = (EditText) findViewById(R.id.Number);
        EditText Name = (EditText) findViewById(R.id.Name);
        String Username = Name.getText().toString();
        ((TextView) findViewById(R.id.Score)).setText("" + score);
        String message;
        if (Number.getText().toString().isEmpty()) {
            message = "Insert Number";

        } else {
            int userNumber = Integer.parseInt(Number.getText().toString());
            if (userNumber > randomNumber && tries > 0) {
                message = "try Lower";
                tries = tries - 1;
                score = score - 1;
            } else if (userNumber < randomNumber && tries > 0) {
                message = "Try Higher";
                tries = tries - 1;
                score = score - 1;
            } else if (userNumber == randomNumber && tries > 0) {
                message = "you won";
                score = score + tries;
            } else {
                message = "You Lose";
                generateNumber();
            }
        }

        Toast.makeText(this, message+ Username, Toast.LENGTH_SHORT).show();
    }

    public void NewGame(View View) {
        tries = 5;
        score = 5;
        generateNumber();
        String message;
        message = "Game is reseted";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }
}