package com.sabrinajahan.spicymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashActivity extends AppCompatActivity {
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
    }

    private void startTimer() {

        countDownTimer = new CountDownTimer(2500, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                gotoNextPage();
            }

        }.start();
    }

    private void gotoNextPage(){
        Intent intent = new Intent(SplashActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    }
}