package com.rajsabari.simplebmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText) findViewById(R.id.two);
        weight=(EditText) findViewById(R.id.one);
        result=(TextView) findViewById(R.id.result);
        Button calculateBMI = findViewById(R.id.btnCalc);
        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

    }




    public void calculateBMI(){
        String h=height.getText().toString();
        String w=weight.getText().toString();
        if (!"".equals(h) && !"".equals(w)){
            float hf=Float.parseFloat(h);
            float wf=Float.parseFloat(w);
            float bmi=(wf/(hf*hf))*10000;
            String lbl="";
            if(bmi<=18.5)
            {
                lbl=getString(R.string.undeer);
            }
            else if(bmi>=18.55 && bmi<=24.99)
            {
                lbl=getString(R.string.normal);
            }
            else if(bmi>=25 && bmi<=24.99)
            {
                lbl=getString(R.string.over);
            }
            else
            {
                lbl=getString(R.string.obesity);
            }
            Toast.makeText(getApplicationContext(),"YOUR BMI"+lbl,Toast.LENGTH_SHORT).show();
            result.setText(bmi+"\n\n"+lbl);
        }
        else{
            Toast.makeText(getApplicationContext(),"Enter the Values",Toast.LENGTH_SHORT).show();
        }
    }}
