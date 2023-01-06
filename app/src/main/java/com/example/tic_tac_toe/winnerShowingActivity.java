package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class winnerShowingActivity extends AppCompatActivity {
    TextView winnerNameShow;
    Button replayButton;
    String player1;
    String player2;
    String winner;
    Intent getValuesFromMainActivity;
    Intent sendNamesAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_showing);
        getSupportActionBar().setTitle("");
        getValuesFromMainActivity = getIntent();
        winnerNameShow = findViewById(R.id.winnerView);
        replayButton = findViewById(R.id.playAgainButton);

        player1 = getValuesFromMainActivity.getStringExtra("player1Name");
        player2 = getValuesFromMainActivity.getStringExtra("player2Name");
        winner = getValuesFromMainActivity.getStringExtra("winnerName");

         sendNamesAgain = new Intent(this, MainActivity.class);

        winnerNameShow.setText("Congrats! " + winner + " has won the game.");
    }

    public void restartGame(View view) {
        sendNamesAgain.putExtra("player1Name", player1);
        sendNamesAgain.putExtra("player2Name", player2);


        startActivity(sendNamesAgain);
        finish();
    }
}