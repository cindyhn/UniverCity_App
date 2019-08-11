package com.example.univercityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyWamActivity extends AppCompatActivity {

    TextView textviewWam;
    TextView tvWamGrade;
    TextView tvUnits;
    TextView textviewUnits;
    TextView textviewWamGrade;
    Button btRemoveExistingWam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wam);
        setContentView(R.layout.activity_my_wam);

        textviewWam = findViewById(R.id.textviewWam);
        tvWamGrade = findViewById(R.id.tvWamGrade);
        tvUnits = findViewById(R.id.tvUnits);
        textviewUnits = findViewById(R.id.textviewUnits);
        textviewWamGrade = findViewById(R.id.textviewWamGrade);

        textviewWam.setText(Global.previousWam);
        tvWamGrade.setText("Grade: " + Global.grade);
        textviewWamGrade.setText("Grade: " + Global.grade);
        tvUnits.setText("Units: " + (Global.totalCourses * 6));
        textviewUnits.setText("UOC: " + (Global.totalCourses * 6));

        btRemoveExistingWam = (Button) findViewById(R.id.btRemoveExistingWam);

        btRemoveExistingWam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Global.previousWam = "0.0";
                Global.grade = "--";
                Global.totalMarks = 0;
                Global.totalCourses = 0;

                double wam = Double.parseDouble(Global.previousWam);

                System.out.println(wam);
                System.out.println(Global.grade);

                textviewWam.setText(Global.previousWam);
                tvWamGrade.setText("Grade: " + Global.grade);
                textviewWamGrade.setText("Grade: " + Global.grade);
                tvUnits.setText("Units: " + (Global.totalCourses * 6));
                textviewUnits.setText("UOC: " + (Global.totalCourses * 6));
            }
        });}

    public void launchUseExistingWamScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), UseExistingWamActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchCreateNewCourseScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), CreateNewCourseActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchGoalWamScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), GoalWamActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void launchHomeScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}