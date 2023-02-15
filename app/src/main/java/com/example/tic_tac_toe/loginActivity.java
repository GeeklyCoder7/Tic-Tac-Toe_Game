package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {
    EditText player1Input;
    EditText player2Input;
    Intent startGame;
    Button startGameButton;
    Bundle playerNames = new Bundle();
    String player1;
    String player2;
    boolean namesEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        player1Input = findViewById(R.id.player1NameInput);
        player2Input = findViewById(R.id.player2NameInput);
        startGameButton = findViewById(R.id.startGameButton);
        startGame = new Intent(this, MainActivity.class);
        final MediaPlayer gameLoaded = MediaPlayer.create(this, R.raw.gameloaded);
        gameLoaded.start();
    }

    public void startGame(View view) {
        if (player1Input.getText().toString().length() == 0 || player2Input.getText().toString().length() == 0) {
            player1Input.setError("Player name is required");
            player2Input.setError("Player name is required");
            namesEntered = false;
        } else {
            player1 = player1Input.getText().toString();
            player2 = player2Input.getText().toString();
            namesEntered = true;
        }

        if (namesEntered) {
            final MediaPlayer buttonClickSound = MediaPlayer.create(this, R.raw.popbuttonclick);
            buttonClickSound.start();
        } else {
            final MediaPlayer errorSound = MediaPlayer.create(this, R.raw.error);
            errorSound.start();
        }


        if (namesEntered) {
            startGame.putExtra("player1Name", player1);
            startGame.putExtra("player2Name", player2);
            startActivity(startGame);
        }
    }
}