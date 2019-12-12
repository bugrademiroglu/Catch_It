package com.bugrademiroglu.example.cathmetin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    ImageView metin;
    int score = 0;
    int time = 10;
    int counter = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = (TextView) findViewById(R.id.timeId);
        scoreText = (TextView) findViewById(R.id.scoreId);
        metin = (ImageView) findViewById(R.id.metinId);
        increaseTime(timeText);
        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override

            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random R = new Random();
                        final float dx = (float) (R.nextFloat() * displaymetrics.widthPixels* 0.765);
                        final float dy = (float) (R.nextFloat() * displaymetrics.heightPixels* 0.60);
                        final Timer timer = new Timer();

                        metin.animate()
                                .x(dx)
                                .y(dy)
                                .setDuration(0)
                                .start();


                    }

                });

            }
        }, 0, 1500);







    }


    public void increaseScore(View view) {
        score++;
        scoreText.setText("Score: " + score);
        if (time == 0) {
            metin.setClickable(false);
        }
    }






    public void increaseTime(View view) {

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                timeText.setText("Left: "+String.valueOf(time));
                if(time != 0) {
                    time--;

                }

            }
            public  void onFinish(){
                timeText.setText("FINISH!!");
            }
        }

        .start();
    }
}