package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class winnerShowingActivity extends AppCompatActivity {
    TextView winnerNameShow;
    Button replayButton;
    String player1;
    String player2;
    String winner;
    Intent getValuesFromMainActivity;
    Intent sendNamesAgain;
    int player1Score;
    int player2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_showing);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getValuesFromMainActivity = getIntent();
        winnerNameShow = findViewById(R.id.winnerView);
        replayButton = findViewById(R.id.playAgainButton);

        player1 = getValuesFromMainActivity.getStringExtra("player1Name");
        player2 = getValuesFromMainActivity.getStringExtra("player2Name");
        winner = getValuesFromMainActivity.getStringExtra("winnerName");
        player1Score = getValuesFromMainActivity.getIntExtra("player1Score", 0);
        player2Score = getValuesFromMainActivity.getIntExtra("player2Score", 0);


        sendNamesAgain = new Intent(this, MainActivity.class);

        winnerNameShow.setText("Congrats! " + winner + " has won the game.");
        playWinnerBG();
    }

    private void playWinnerBG() {
        final MediaPlayer bgSoundPlayer = MediaPlayer.create(this, R.raw.winnerbg);
        bgSoundPlayer.start();
    }

    public void restartGame(View view) {
        sendNamesAgain.putExtra("player1Name", player1);
        sendNamesAgain.putExtra("player2Name", player2);
        sendNamesAgain.putExtra("player1Score", player1Score);
        sendNamesAgain.putExtra("player2Score", player2Score);

        final MediaPlayer buttonClickSound = MediaPlayer.create(this, R.raw.popbuttonclick);
        buttonClickSound.start();

        startActivity(sendNamesAgain);
        finish();
    }
}