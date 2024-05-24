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

public class LengthFragment extends Fragment {

    Spinner fromSpinner, toSpinner;
    EditText input;
    Button convertButton;
    TextView answer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);
        fromSpinner = view.findViewById(R.id.from_spinner);
        toSpinner = view.findViewById(R.id.to_spinner);
        input = view.findViewById(R.id.input);
        convertButton = view.findViewById(R.id.convert_button);
        answer = view.findViewById(R.id.answer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = fromSpinner.getSelectedItem().toString();
                String to = toSpinner.getSelectedItem().toString();
                double inputVal = Double.parseDouble(input.getText().toString());
                answer.setText(convertLength(from, to, inputVal));
            }
        });
        return view;
    }

    private String convertLength(String from, String to, double inputVal){
        double ans = 0;
        if(from.equals("Kilometer") && to.equals("Meter")){
            ans = inputVal * 1000;
        }
        else if(from.equals("Kilometer") && to.equals("Centimeter")){
            ans = inputVal * 100000;
        }
        else if(from.equals("Kilometer") && to.equals("Feet")){
            ans = inputVal * 3280.84;
        }
        else if(from.equals("Meter") && to.equals("Kilometer")){
            ans = inputVal / 1000;
        }
        else if(from.equals("Meter") && to.equals("Centimeter")){
            ans = inputVal * 100;
        }
        else if(from.equals("Meter") && to.equals("Feet")){
            ans = inputVal * 3.28084;
        }
        else if(from.equals("Centimeter") && to.equals("Kilometer")){
            ans = inputVal / 100000;
        }
        else if(from.equals("Centimeter") && to.equals("Meter")){
            ans = inputVal / 100;
        }
        else if(from.equals("Centimeter") && to.equals("Feet")){
            ans = inputVal / 30.48;
        }
        else if(from.equals("Feet") && to.equals("Centimeter")){
            ans = inputVal / 3280.84;
        }
        else if(from.equals("Feet") && to.equals("Meter")){
            ans = inputVal / 3.28084;
        }
        else if(from.equals("Feet") && to.equals("Centimeter")){
            ans = inputVal * 30.48;
        }
         else if(from.equals("Feet") && to.equals("Feet")){
            ans = inputVal;
        }
         else if(from.equals("Centimeter") && to.equals("Centimeter")){
            ans = inputVal;
        }
         else if(from.equals("Meter") && to.equals("Meter")){
            ans = inputVal;
        }
         else if(from.equals("Kilometer") && to.equals("Kilometer")){
            ans = inputVal;
        }

        return String.valueOf(ans);
    }

}