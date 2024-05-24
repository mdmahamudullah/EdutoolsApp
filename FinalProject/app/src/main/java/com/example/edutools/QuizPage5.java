package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class QuizPage5 extends AppCompatActivity {
    RadioGroup q5RadioGroup;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page5);

        q5RadioGroup=findViewById(R.id.q5radiogroupID);
        Intent myGetIntent = getIntent();
        mark = myGetIntent.getIntExtra("Q4_mark",0);


    }

    public void gobackquestion4(View view) {
        Intent intent = new Intent(this,QuizPage4.class);
        startActivity(intent);
    }

    public void Gores(View view) {
        if(q5RadioGroup.getCheckedRadioButtonId()==R.id.q5radiobtn2)
        {
            mark=mark+1;
        }
        else
        {
            mark = mark+0;
        }
        Intent myIntent = new Intent(this,ResultShowPage.class);
        myIntent.putExtra("Q5_mark",mark);
        startActivity(myIntent);
    }
}