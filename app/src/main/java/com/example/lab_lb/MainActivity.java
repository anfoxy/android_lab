package com.example.lab_lb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab_lb.bd.MyDBManager;
import com.example.lab_lb.l2.Lab2;
import com.example.lab_lb.l3.Lab3;
import com.example.lab_lb.l4.Lab4;
import com.example.lab_lb.l5.Lab5;
import com.example.lab_lb.l6.Lab6;
import com.example.lab_lb.l7.Lab7;
import com.example.lab_lb.l8.Lab8;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MyDBManager myDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBManager = new MyDBManager(this);

        Button l2 = (Button)this.findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab2.class);
                startActivity(i);

            }
        });
        Button l3 = (Button)this.findViewById(R.id.l3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, Lab3.class);
                startActivity(i);

            }
        });

        Button l4 = (Button)this.findViewById(R.id.l4);
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab4.class);
                startActivity(i);
            }
        });

        Button l5 = (Button)this.findViewById(R.id.l5);
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab5.class);
                startActivity(i);
            }
        });

        Button l6 = (Button)this.findViewById(R.id.l6);
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab6.class);
                startActivity(i);
            }
        });
        Button l7 = (Button)this.findViewById(R.id.l7);
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab7.class);
                startActivity(i);
            }
        });
        Button l8 = (Button)this.findViewById(R.id.l8);
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Lab8.class);
                startActivity(i);
            }
        });
    }
}