package com.example.lab_lb.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab_lb.R;
import com.example.lab_lb.l3.Lab3;
import com.example.lab_lb.l3.Lab31;

public class Lab2 extends AppCompatActivity {

    private int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        TextView text = findViewById(R.id.text);
        Button p = findViewById(R.id.p);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            text.setText(""+ (++i));
            }
        });

        Button m = findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(""+ (--i));
            }
        });

        Button n = findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                text.setText(""+i);
            }
        });
    }
}