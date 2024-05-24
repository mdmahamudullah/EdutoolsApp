package com.example.edutools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResultShowPage extends AppCompatActivity {
    TextView resultView;
    int mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_show_page);

        Intent myGetIntent = getIntent();
        resultView = findViewById(R.id.FinalResultShowID);
        mark = myGetIntent.getIntExtra("Q5_mark", 0);
        resultView.setText("You Get " + mark + " Out of 5");



        if(mark==20){
            Toast.makeText(this,"Congratulations "+mark,Toast.LENGTH_LONG).show();
        }
    }

        public void tryAgainButton (View view){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        }
    }