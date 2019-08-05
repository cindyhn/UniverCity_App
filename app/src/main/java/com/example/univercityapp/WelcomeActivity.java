package com.example.univercityapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startActivity = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(startActivity);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();
            }
        }, 4000);


    }
}
