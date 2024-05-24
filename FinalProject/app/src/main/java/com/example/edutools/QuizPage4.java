package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage4 extends AppCompatActivity {
    RadioGroup q4RadioGroup;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page4);
        q4RadioGroup = findViewById(R.id.q4radiogroupID);

        Intent myGetIntent = getIntent();
        mark = myGetIntent.getIntExtra("Q3_mark",0);


    }

    public void GoQuestonpage5(View view) {
        if(q4RadioGroup.getCheckedRadioButtonId()==R.id.q4radiobtn4)
        {
            mark=mark+1;
        }
        else
        {
            mark = mark+0;
        }
        Intent myIntent = new Intent(this,QuizPage5.class);
        myIntent.putExtra("Q4_mark",mark);
        startActivity(myIntent);
    }

    public void gobackquestion3(View view) {
        Intent intent = new Intent(this,QuizPage3.class);
        startActivity(intent);
    }
}