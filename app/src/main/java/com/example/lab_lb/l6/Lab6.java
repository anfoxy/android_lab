package com.example.lab_lb.l6;

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
import com.example.lab_lb.l5.Lab54;
import com.example.lab_lb.l5.Lab55;
import com.example.lab_lb.l5.Lab56;
import com.example.lab_lb.l5.Lab57;

public class Lab6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        Button l1 = findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab6.this, Lab61.class);
                startActivity(i);
            }
        });
        Button l2 = findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab6.this, Lab62.class);
                startActivity(i);
            }
        });
        Button l3 = findViewById(R.id.l3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab6.this, Lab63.class);
                startActivity(i);
            }
        });
        Button l4 = findViewById(R.id.l4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lab6.this, Lab64.class);
                startActivity(i);
            }
        });

    }
}