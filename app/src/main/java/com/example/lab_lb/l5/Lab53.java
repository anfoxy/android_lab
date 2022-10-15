package com.example.lab_lb.l5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab_lb.R;

import java.util.ArrayList;

public class Lab53 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab53);
        Week tasks = new Week();
        tasks.addTask(2022, 9, 18, "План 8");
        tasks.addTask(2022, 9, 11, "План 1");
        tasks.addTask(2022, 9, 15, "План 5");
        tasks.addTask(2022, 9, 13, "План 3");
        tasks.addTask(2022, 9, 14, "План 4");
        tasks.addTask(2022, 9, 12, "План 2");
        tasks.addTask(2022, 9, 16, "План 6");
        tasks.addTask(2022, 9, 17, "План 7");

        ArrayList<Pair<Boolean, String>> list = tasks.toList();

        LinearLayout tasksView = findViewById(R.id.L4tasksList);
        for (Pair<Boolean, String> pair : list) {
            TextView tv = new TextView(Lab53.this);
            tv.setText((CharSequence) pair.second);
            tv.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            tv.setTextSize(30);
            if (pair.first) {
                tv.setGravity(Gravity.RIGHT);
                tv.setTextColor(Color.BLUE);
            }
            tasksView.addView(tv);
        }


    }

}

