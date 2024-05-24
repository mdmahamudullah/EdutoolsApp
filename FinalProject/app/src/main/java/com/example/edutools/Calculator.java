package com.example.edutools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {
    TextView primaryView, secondaryView;
    double number1, number2, result, sign1;
    int pointCount=0,operatorCount=0;

    String operator="0",dld,secondaryValue="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        primaryView = findViewById(R.id.primaryTextViewId);
        secondaryView = findViewById(R.id.secondaryTextViewId);
    }

    public void numberFunction(View view) {

        String primaryValue = primaryView.getText().toString();
        if (primaryValue.length()<26){

            if (primaryValue.equals("0")) {
                if (view.getId() == R.id.zeroBtnId) {
                    primaryView.setText("0");
                } else if (view.getId() == R.id.oneBtnId) {
                    primaryView.setText("1");
                } else if (view.getId() == R.id.twoBtnId) {
                    primaryView.setText("2");
                } else if (view.getId() == R.id.threeBtnId) {
                    primaryView.setText("3");
                } else if (view.getId() == R.id.fourBtnId) {
                    primaryView.setText("4");
                } else if (view.getId() == R.id.fiveBtnId) {
                    primaryView.setText("5");
                } else if (view.getId() == R.id.sixBtnId) {
                    primaryView.setText("6");
                } else if (view.getId() == R.id.sevenBtnId) {
                    primaryView.setText("7");
                } else if (view.getId() == R.id.eightBtnId) {
                    primaryView.setText("8");
                }  else if (view.getId() == R.id.pointBtnId) {
                    primaryView.setText(".");
                    pointCount++;

                }else {
                    primaryView.setText("9");
                }
            } else {
                if (view.getId() == R.id.zeroBtnId) {
                    primaryView.setText(primaryValue + "0");
                } else if (view.getId() == R.id.oneBtnId) {
                    primaryView.setText(primaryValue + "1");
                } else if (view.getId() == R.id.twoBtnId) {
                    primaryView.setText(primaryValue + "2");
                } else if (view.getId() == R.id.threeBtnId) {
                    primaryView.setText(primaryValue + "3");
                } else if (view.getId() == R.id.fourBtnId) {
                    primaryView.setText(primaryValue + "4");
                } else if (view.getId() == R.id.fiveBtnId) {
                    primaryView.setText(primaryValue + "5");
                } else if (view.getId() == R.id.sixBtnId) {
                    primaryView.setText(primaryValue + "6");
                } else if (view.getId() == R.id.sevenBtnId) {
                    primaryView.setText(primaryValue + "7");
                } else if (view.getId() == R.id.eightBtnId) {
                    primaryView.setText(primaryValue + "8");
                } else if (view.getId() == R.id.pointBtnId) {
                    if (pointCount==0){
                        primaryView.setText(primaryValue + ".");
                        pointCount++;
                    }
                    else{
                        primaryView.setText(primaryValue);

                    }
                } else {
                    primaryView.setText(primaryValue + "9");
                }

            }
        }
        else {

        }
    }


    public void operatorFunction(View view) {
        pointCount=0;
        if (primaryView.getText()=="."){
            primaryView.setText(".0");
        }else{

        }
        if(operatorCount==0){

            String primaryValue = primaryView.getText().toString();
            if (view.getId() == R.id.addBtnId) {
                operator = "+";
                operatorCount++;
            } else if (view.getId() == R.id.subBtnId) {
                operator = "-";
                operatorCount++;

            } else if (view.getId() == R.id.mulBtnId) {
                operator = "*";
                operatorCount++;

            } else if (view.getId() == R.id.divBtnId) {
                operator = "/";
                operatorCount++;

            }
            number1 = Double.parseDouble(primaryValue);
            secondaryView.setText(primaryValue + " " + operator);
            secondaryValue=primaryValue;
            primaryView.setText("0");
        }
        else{
            if (view.getId() == R.id.addBtnId) {
                operator = "+";
                operatorCount++;
            } else if (view.getId() == R.id.subBtnId) {
                operator = "-";
                operatorCount++;

            } else if (view.getId() == R.id.mulBtnId) {
                operator = "*";
                operatorCount++;

            } else if (view.getId() == R.id.divBtnId) {
                operator = "/";
                operatorCount++;

            }
            secondaryView.setText(secondaryValue + " " + operator);

        }

    }

    public void specialFunction(View view) {
        if (view.getId() == R.id.ceBtnId) {
            primaryView.setText("0");
            pointCount=0;
        } else if (view.getId() == R.id.cBtnId) {
            primaryView.setText("0");
            secondaryView.setText("");
            number1 = 0;
            number2 = 0;
            operator = "0";
            pointCount=0;
        } else if (view.getId() == R.id.signBtnId) {
            if (primaryView.getText()=="."){
                primaryView.setText("0");

            }
            else {

            }
            sign1 = Double.parseDouble(primaryView.getText().toString());
            sign1 = sign1 * (-1);
            primaryView.setText("" + sign1);
            pointCount=1;
        }
        else{
            dld = primaryView.getText().toString();
            if (dld=="."){
                pointCount=0;
            }
            else{

            }
            if (dld.length()==1){
                primaryView.setText("0");

            }else {
                dld = dld.substring(0, dld.length() - 1);
                primaryView.setText(dld);
            }

        }

    }

    public void resultFunction(View view) {
        operatorCount=0;
        if (secondaryView.getText()==""){
            pointCount=0;

        }
        else {
            pointCount=1;

        }

        if (primaryView.getText()=="."){
            primaryView.setText(".0");
        }else{

        }

        if (primaryView.getText()=="."){
            primaryView.setText(".");

        }
        else{
            number2 = Double.parseDouble(primaryView.getText().toString());
            if (operator.equals("0")) {
                primaryView.setText("0");
            }

            else{
                if (operator.equals("+")) {
                    result = number1 + number2;
                } else if (operator.equals("-")) {
                    result = number1 - number2;
                } else if (operator.equals("*")) {
                    result = number1 * number2;
                }
                else if (operator.equals("/")) {
                    result = number1 / number2;
                }
                else {

                }
                DecimalFormat df = new DecimalFormat("#.########");
                result = Double.parseDouble((df.format(result)));
                secondaryView.setText(number1 + " " + operator + " " + number2 + " =");
                primaryView.setText("" + result);
            }
        }
    }
}