package com.example.myapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainApp2 extends AppCompatActivity {

    private static final String TAG = MainApp2.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main2);

        Button calbut = findViewById(R.id.cal_button);
        calbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEt = findViewById(R.id.height_editText);
                EditText weightEt = findViewById(R.id.weight_editText);

                int hei = Integer.parseInt(heightEt.getText().toString());
                int wei = Integer.parseInt(weightEt.getText().toString());

                float bmi = calculateBmi(hei,wei);


                String resultT = null;
                if (bmi < 18.5)
                    resultT = "ผอมเกินไป";
                else if(bmi <25)
                    resultT = "น้ำหนักปกติ";
                else if(bmi <30)
                    resultT ="อ้วน";
                else
                    resultT = "อ้วนมาก";


//                String msg = "Value BMI is "+String.format(Locale.US,"%.2f",bmi)
                String msg = "เกณฑ์น้ำหนักของคุณ: "+resultT;


                AlertDialog.Builder dialog = new AlertDialog.Builder(MainApp2.this);
                dialog.setTitle("Result");
                dialog.setMessage(msg);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                dialog.show();

            }
        });
    }
    private float calculateBmi(int heightIncm,int weightKg){
        //bmi = kg /m^2

        float height = heightIncm / 100f;
        Log.i(TAG,"height is "+String.valueOf(height));
        float bmi = weightKg / (height * height);
        return bmi;

    }


}
