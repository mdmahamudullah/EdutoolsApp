package com.example.edutools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TemperatureFragment extends Fragment {

    Spinner fromSpinner, toSpinner;
    EditText input;
    Button convertButton;
    TextView answer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);
        fromSpinner = view.findViewById(R.id.from_spinner);
        toSpinner = view.findViewById(R.id.to_spinner);
        input = view.findViewById(R.id.input);
        convertButton = view.findViewById(R.id.convert_button);
        answer = view.findViewById(R.id.answer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.temperature_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = fromSpinner.getSelectedItem().toString();
                String to = toSpinner.getSelectedItem().toString();
                double inputVal = Double.parseDouble(input.getText().toString());
                answer.setText(convertTemperature(from, to, inputVal));
            }
        });
        return view;
    }

    private String convertTemperature(String from, String to, double inputVal){
        double ans = 0;
        if(from.equals("Fahrenheit") && to.equals("Celsius")){
            ans = (inputVal - 32) * (5.0/9.0);
        }
        else if(from.equals("Celsius") && to.equals("Fahrenheit")){
            ans = (inputVal * (9.0/5.0)) + 32;
        }
        else if(from.equals("Celsius") && to.equals("Celsius")){
            ans = inputVal;
        } else if(from.equals("Fahrenheit") && to.equals("Fahrenheit")){
            ans = inputVal;
        }

        return String.valueOf(ans);
    }

}