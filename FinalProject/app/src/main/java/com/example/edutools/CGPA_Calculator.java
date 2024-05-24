package com.example.edutools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CGPA_Calculator extends AppCompatActivity {
    EditText subject, credit, grade;
    Button add, calculate;
    ListView subjects_list;
    TextView cgpa1;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    double totalCredit=0, totalGrade=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_calculator);

        subject = findViewById(R.id.subject);
        credit = findViewById(R.id.credit);
        grade = findViewById(R.id.grade);
        add = findViewById(R.id.add);
        calculate = findViewById(R.id.calculate_cgpa);
        subjects_list = findViewById(R.id.subjects_list);
        cgpa1 = findViewById(R.id.cgpa);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.simple_text,R.id.simple_text_id, list);
        subjects_list.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub = subject.getText().toString();
                String cre = credit.getText().toString();
                String gra = grade.getText().toString();

                list.add(sub+" : "+gra+" ("+cre+")");
                adapter.notifyDataSetChanged();

                totalCredit += Double.parseDouble(cre);
                totalGrade += Double.parseDouble(cre)*Double.parseDouble(gra);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cgpa = totalGrade/totalCredit;
                cgpa1.setText("Your CGPA is: "+cgpa);

            }
        });
    }
}
