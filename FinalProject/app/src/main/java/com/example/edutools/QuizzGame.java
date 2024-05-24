package com.example.edutools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class QuizzGame extends AppCompatActivity {
    RadioGroup q1RadioGroup ;
    int mark=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_game);
        q1RadioGroup = findViewById(R.id.q1radiogroupID);
    }

    public void NextQuestionButton(View view) {
        if (q1RadioGroup.getCheckedRadioButtonId()==R.id.q1radiobtn1)
        {
            mark =1;
        }

        else
        {
            mark=0;
        }
        Intent myIntent = new Intent(this,QuizPage2.class);
        myIntent.putExtra("Q1_mark",mark);
        startActivity(myIntent);

    }

}