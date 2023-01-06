package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 = X
    // 1 = O

    int activePlayer = 0;
    int []gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int [][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                 {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                 {0, 4, 8}, {2, 4, 6}};

    boolean gameIsActive = true;
    String player1;
    String player2;
    TextView status;
    String winner;
    Intent getValuesFromLogin;
    Intent playerAndWinnerNamesSender;
    Intent getValuesFromWinnerShowingActivity;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Tic-Tac-Toe");
        getValuesFromLogin = getIntent();
        getValuesFromWinnerShowingActivity = getIntent();

        status = findViewById(R.id.gameStatus);

        if (getValuesFromWinnerShowingActivity == null) {
            player1 = getValuesFromLogin.getStringExtra("player1Name");
            player2 = getValuesFromLogin.getStringExtra("player2Name");

            status.setText(player1 + "'s turn - Tap to Play!");
        } else {
            player1 = getValuesFromWinnerShowingActivity.getStringExtra("player1Name");
            player2 = getValuesFromWinnerShowingActivity.getStringExtra("player2Name");
            status.setText(player1 + "'s turn - Tap to Play!");
        }
    }

    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {

        ImageView img = (ImageView) view;
        int tappedImageTag = Integer.parseInt(img.getTag().toString());

        if (!gameIsActive) {
            resetGame(view);
        }

        if (gameState[tappedImageTag] == 2) {
            gameState[tappedImageTag] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xre);
                activePlayer = 1;
                status.setText(player2 + "'s turn - Tap to play!");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText(player1 + "'s turn - Tap to play!");
            }
            img.animate().translationYBy(1000f).setDuration(400);
        }

        for (int []winPosition: winningPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                gameIsActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winner = player1;
                } else {
                    winner = player2;
                }

                status.setText("");

                playerAndWinnerNamesSender = new Intent(this, winnerShowingActivity.class);
                playerAndWinnerNamesSender.putExtra("player1Name", player1);
                playerAndWinnerNamesSender.putExtra("player2Name", player2);
                playerAndWinnerNamesSender.putExtra("winnerName", winner);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        resetGame(view);

                        startActivity(playerAndWinnerNamesSender);
//                        finish();
                    }
                }, 400);
            }
        }
    }



    @SuppressLint("SetTextI18n")
    public void resetGame(View view) {
        gameIsActive = true;
        activePlayer = 0;
        status.setText(player1 + "'s turn - Tap to play!");

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
}