package com.example.lab_lb.l7;

import android.app.Activity;

import android.os.Bundle;

import android.widget.LinearLayout;

import com.example.lab_lb.R;

public class Lab72 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab72);

        LinearLayout DataLayout = findViewById(R.id.L2DataLayout);
        T3View t3View = new T3View(getApplicationContext());
        DataLayout.addView(t3View);
    }
}

