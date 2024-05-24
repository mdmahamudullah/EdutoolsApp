package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage2 extends AppCompatActivity {
    RadioGroup q2Radiogroup;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);
        q2Radiogroup = findViewById(R.id.q2radiogroupID);
        Intent myGetIntent = getIntent();
        mark = myGetIntent.getIntExtra("Q1_mark", 0);
    }

    public void GoQuestonpage3(View view) {
        if (q2Radiogroup.getCheckedRadioButtonId() == R.id.q2radiobtn3)
        {
            mark = mark + 1;
        }
        else
        {
            mark = mark + 0;
        }
        Intent myIntent = new Intent(this, QuizPage3.class);
        myIntent.putExtra("Q2_mark", mark);
        startActivity(myIntent);
    }

    public void gobackquestion1(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}