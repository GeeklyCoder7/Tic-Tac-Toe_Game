package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toolbar;

public class loadingactivity extends AppCompatActivity {
    Intent goToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingactivity);
        getSupportActionBar().setTitle("");
        goToLogin = new Intent(this, loginActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(goToLogin);
                finish();
            }
        }, 2900);
    }
}