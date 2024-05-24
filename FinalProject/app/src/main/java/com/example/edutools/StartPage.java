package com.example.edutools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class StartPage extends AppCompatActivity {
    ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //Hide bar
        progressBar=findViewById(R.id.ProgressBerID);
        Thread thread = new Thread(new Runnable() {
            @Override

            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();

    }
    //Progress bar value change
//    Do work Method
    public void doWork(){
        for(progress=20;progress<=100;progress=progress+10){
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //After Progressbar Go Home page activity
    public void startApp() {
        Intent myIntent = new Intent(this, Login.class);
        startActivity(myIntent);
        finish();
    }


}