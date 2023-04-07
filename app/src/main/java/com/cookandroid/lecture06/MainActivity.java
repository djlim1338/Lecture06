package com.cookandroid.lecture06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLec6_1, btnLec6_1change, btnLec6Prac1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLec6_1 = (Button) findViewById(R.id.btnLec6_1);
        btnLec6_1change = (Button) findViewById(R.id.btnLec6_1change);

        btnLec6Prac1 = (Button) findViewById(R.id.btnLec6Prac1);

        btnLec6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lec6_1.class);
                startActivity(intent);
            }
        });

        btnLec6_1change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lec6_1Change.class);
                startActivity(intent);
            }
        });

        btnLec6Prac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Lec6_prac1.class);
                startActivity(intent);
            }
        });
    }
}