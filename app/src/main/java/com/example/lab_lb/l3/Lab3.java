package com.example.lab_lb.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab_lb.R;
import com.example.lab_lb.l5.Lab5;
import com.example.lab_lb.l5.Lab51;
import com.example.lab_lb.l5.Lab52;
import com.example.lab_lb.l5.Lab53;

public class Lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        Button l1 = findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab3.this, Lab31.class);
                startActivity(i);
            }
        });
        Button l2 = findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab3.this, Lab32.class);
                startActivity(i);
            }
        });

    }
}