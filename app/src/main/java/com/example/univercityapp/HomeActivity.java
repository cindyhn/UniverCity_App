package com.example.univercityapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Boolean exit = false;

    public ImageView ivCorgi, ivCorgiBone, ivCorgiMedal, ivCorgiGrad, ivCorgiDouble, profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setNotifBarTrans();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AvatarProfilePage.class);
                startActivity(intent);
            }
        });


        ivCorgi = findViewById(R.id.ivCorgi);
        ivCorgiBone = findViewById(R.id.ivCorgiBone);
        ivCorgiMedal = findViewById(R.id.ivCorgiMedal);
        ivCorgiGrad = findViewById(R.id.ivCorgiGrad);
        ivCorgiDouble = findViewById(R.id.ivCorgiDouble2);


        ivCorgi.setVisibility(View.INVISIBLE);
        ivCorgiBone.setVisibility(View.INVISIBLE);
        ivCorgiMedal.setVisibility(View.INVISIBLE);
        ivCorgiGrad.setVisibility(View.INVISIBLE);
        ivCorgiDouble.setVisibility(View.INVISIBLE);


        if(Global.totalCourses <  8) {
            ivCorgi.setVisibility(View.VISIBLE);
            ivCorgiBone.setVisibility(View.INVISIBLE);
            ivCorgiMedal.setVisibility(View.INVISIBLE);
            ivCorgiGrad.setVisibility(View.INVISIBLE);
            ivCorgiDouble.setVisibility(View.INVISIBLE);
        }

        if(Global.totalCourses >= 8 && Global.totalCourses<16) {
            ivCorgi.setVisibility(View.INVISIBLE);
            ivCorgiBone.setVisibility(View.VISIBLE);
            ivCorgiMedal.setVisibility(View.INVISIBLE);
            ivCorgiGrad.setVisibility(View.INVISIBLE);
            ivCorgiDouble.setVisibility(View.INVISIBLE);
        }

        if(Global.totalCourses >=16 && Global.totalCourses <24) {
            ivCorgi.setVisibility(View.INVISIBLE);
            ivCorgiBone.setVisibility(View.INVISIBLE);
            ivCorgiMedal.setVisibility(View.VISIBLE);
            ivCorgiGrad.setVisibility(View.INVISIBLE);
            ivCorgiDouble.setVisibility(View.INVISIBLE);
        }

        if(Global.totalCourses >=24 && Global.totalCourses <32) {
            ivCorgi.setVisibility(View.INVISIBLE);
            ivCorgiBone.setVisibility(View.INVISIBLE);
            ivCorgiMedal.setVisibility(View.INVISIBLE);
            ivCorgiGrad.setVisibility(View.VISIBLE);
            ivCorgiDouble.setVisibility(View.INVISIBLE);
        }

        if(Global.totalCourses >=32) {
            ivCorgi.setVisibility(View.INVISIBLE);
            ivCorgiBone.setVisibility(View.INVISIBLE);
            ivCorgiMedal.setVisibility(View.INVISIBLE);
            ivCorgiGrad.setVisibility(View.INVISIBLE);
            ivCorgiDouble.setVisibility(View.VISIBLE);
        }






    }

    public void launchMyWamScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), MyWamActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchMajorMapsScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), MajorMapsActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchQuizScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchHelpScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), HelpActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchExplorationScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), ExplorationActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchProgressionScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), ProgressionActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchProfileScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), AvatarProfilePage.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
    private void setNotifBarTrans() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
