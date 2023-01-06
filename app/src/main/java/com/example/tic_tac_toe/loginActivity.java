package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {
    EditText player1Input;
    EditText player2Input;
    Intent startGame;
    Button startGameButton;
    Bundle playerNames = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("");
        player1Input = findViewById(R.id.player1NameInput);
        player2Input = findViewById(R.id.player2NameInput);
        startGameButton = findViewById(R.id.startGameButton);
        startGame = new Intent(this, MainActivity.class);
    }

    public void startGame(View view) {
        String player1 = player1Input.getText().toString();
        String player2 = player2Input.getText().toString();
//        playerNames.putString("player1Name", player1);
//        playerNames.putString("player2Name", player2);

        startGame.putExtra("player1Name", player1);
        startGame.putExtra("player2Name", player2);
        startActivity(startGame);
        finish();
    }
}