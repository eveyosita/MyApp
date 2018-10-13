package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);


        Button stratbut = findViewById(R.id.start_button);
        stratbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hello";
                Toast t = Toast.makeText(MainApp.this, message, Toast.LENGTH_SHORT);
                t.show();
                Intent i = new Intent(MainApp.this, MainApp2.class);
                startActivity(i);
            }
        });

        Button exitBut = findViewById(R.id.exit_button);
        exitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Goodbye";
                Toast t = Toast.makeText(MainApp.this, message, Toast.LENGTH_SHORT);
                t.show();
                finish();
            }
        });

    }
}
