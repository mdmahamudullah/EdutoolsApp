package com.example.edutools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculator(View view) {
        Intent intent=new Intent(this,Calculator.class);
        startActivity(intent);
    }

    public void CGPACalculator(View view) {
        Intent intent=new Intent(this,CGPA_Calculator.class);
        startActivity(intent);
    }

    public void converter(View view) {
        Intent intent=new Intent(this,Converter.class);
        startActivity(intent);
    }

    public void QuizGame(View view) {
        Intent intent=new Intent(this,QuizzGame.class);
        startActivity(intent);
    }
}