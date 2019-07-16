package com.example.univercityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    public QuestionLibrary questionLibrary = new QuestionLibrary();

    //    public int financeScore = 0;
//    public int economicsScore = 0;
//    public int marketingScore = 0;
    public int realEstateScore = 0;
    public int managementScore = 0;
    public int infoSysScore = 0;
    public int accountingScore = 0;
    public int humanResourcesScore = 0;




    public TextView tvEconomicsScore;
    public TextView tvMarketingScore;
    public TextView tvfinanceScore;
    public TextView tvQuizQuestion;
    public Button btQuizAnswer1;
    public Button btQuizAnswer2;
    public Button btQuizAnswer3;
    public Button btQuizAnswer4;


    public String financeAnswer;
    public String economicsAnswer;
    public String marketingAnswer;
    public int questionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuizQuestion = findViewById(R.id.tvQuizQuestion);
        btQuizAnswer1 = findViewById(R.id.btQuizAnswer1);
        btQuizAnswer2 = findViewById(R.id.btQuizAnswer2);
        btQuizAnswer3 = findViewById(R.id.btQuizAnswer3);
        btQuizAnswer4 = findViewById(R.id.btQuizAnswer4);
        tvfinanceScore = findViewById(R.id.tvQuizFinanceScore);
        tvEconomicsScore = findViewById(R.id.tvQuizEconomicsScore);
        tvMarketingScore = findViewById(R.id.tvQuizMarketingScore);

        updateQuestion();

        btQuizAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btQuizAnswer1.getText() == financeAnswer) {
                    Global.financeScore = Global.financeScore + 1;
                    updateScore(Global.financeScore);

                }

                if(btQuizAnswer1.getText() == marketingAnswer){
                    Global.marketingScore = Global.marketingScore + 1;
                    updateScore(Global.marketingScore);

                }

                if(btQuizAnswer1.getText() == economicsAnswer) {
                    Global.economicsScore = Global.economicsScore + 1;
                    updateScore(Global.economicsScore);

                }

                updateQuestion();


            }



        });


        btQuizAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btQuizAnswer2.getText() == financeAnswer) {
                    Global.financeScore = Global.financeScore + 1;
                    updateScore(Global.financeScore);

                }

                if(btQuizAnswer2.getText() == economicsAnswer) {
                    Global.economicsScore = Global.economicsScore + 1;
                    updateScore(Global.economicsScore);
                }

                if(btQuizAnswer2.getText() == marketingAnswer) {
                    Global.marketingScore = Global.marketingScore + 1;
                    updateScore(Global.marketingScore);

                }

                updateQuestion();

            }
        });


        btQuizAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btQuizAnswer3.getText() == financeAnswer) {
                    Global.financeScore = Global.financeScore + 1;
                    updateScore(Global.financeScore);



                }

                if(btQuizAnswer3.getText() == economicsAnswer) {
                    Global.economicsScore = Global.economicsScore + 1;
                    updateScore(Global.economicsScore);

                }

                if(btQuizAnswer3.getText() == marketingAnswer) {
                    Global.marketingScore = Global.marketingScore + 1;
                    updateScore(Global.marketingScore);

                }

                updateQuestion();

            }
        });


        btQuizAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btQuizAnswer4.getText() == financeAnswer) {
                    Global.financeScore = Global.financeScore + 1;
                    updateScore(Global.financeScore);



                }

                if(btQuizAnswer4.getText() == economicsAnswer) {
                    Global.economicsScore = Global.economicsScore + 1;
                    updateScore(Global.economicsScore);

                }

                if(btQuizAnswer4.getText() == marketingAnswer) {
                    Global.marketingScore = Global.marketingScore + 1;
                    updateScore(Global.marketingScore);

                }

                updateQuestion();

            }
        });


    }



    public void updateQuestion() {
        tvQuizQuestion.setText(questionLibrary.getQuestion(questionNumber));
        btQuizAnswer1.setText(questionLibrary.getChoice1(questionNumber));
        btQuizAnswer2.setText(questionLibrary.getChoice2(questionNumber));
        btQuizAnswer3.setText(questionLibrary.getChoice3(questionNumber));
        btQuizAnswer4.setText(questionLibrary.getChoice4(questionNumber));
        financeAnswer = questionLibrary.getFinanceAnswers(questionNumber);
        marketingAnswer = questionLibrary.getMarketingAnswers(questionNumber);
        economicsAnswer = questionLibrary.getEconomicsAnswers(questionNumber);


        questionNumber++;

    }

    public void updateScore(int point) {
        tvfinanceScore.setText(" " + Global.financeScore);
        tvMarketingScore.setText((" " + Global.marketingScore));
        tvEconomicsScore.setText(" " + Global.economicsScore);

    }

    public void launchPostQuizScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), PostQuizActivity.class);
        startActivity(myIntent);
    }

}