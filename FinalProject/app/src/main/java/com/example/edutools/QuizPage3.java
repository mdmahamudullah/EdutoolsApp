package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage3 extends AppCompatActivity {
    RadioGroup q3RadioGroup;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page3);
        q3RadioGroup = findViewById(R.id.q3radiogroupID);

        Intent myGetIntent = getIntent();
        mark = myGetIntent.getIntExtra("Q2_mark",0);


    }

    public void GoQuestonpage4(View view) {
        if(q3RadioGroup.getCheckedRadioButtonId()==R.id.q3radiobtn2)
        {
            mark=mark+1;
        }
        else
        {
            mark = mark+0;
        }
        Intent myIntent = new Intent(this,QuizPage4.class);
        myIntent.putExtra("Q3_mark",mark);
        startActivity(myIntent);
    }

    public void gobackquestion2(View view) {
        Intent intent = new Intent(this,QuizPage2.class);
        startActivity(intent);
    }
}