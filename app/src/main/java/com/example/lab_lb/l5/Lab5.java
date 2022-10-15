package com.example.lab_lb.l5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab_lb.R;

public class Lab5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);


        Button l1 = findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab51.class);
                startActivity(i);
            }
        });
        Button l2 = findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab52.class);
                startActivity(i);
            }
        });
        Button l3 = findViewById(R.id.l3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab53.class);
                startActivity(i);
            }
        });
        Button l4 = findViewById(R.id.l4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab54.class);
                startActivity(i);
            }
        });

        Button l5 = findViewById(R.id.l5);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab55.class);
                startActivity(i);
            }
        });

        Button l6 = findViewById(R.id.l6);
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab56.class);
                startActivity(i);
            }
        });

        Button l7 = findViewById(R.id.l7);
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab5.this, Lab57.class);
                startActivity(i);
            }
        });
    }
}