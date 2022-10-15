package com.example.lab_lb.l6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab_lb.R;

import java.util.ArrayList;
import java.util.List;

public class Lab62 extends AppCompatActivity {
    private Adapter62.OnStateClickListener stateClickListener;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab62);


        List<String> list = new ArrayList<>();


        final RecyclerView recyclerView = findViewById(R.id.list1);
        Button l2 = findViewById(R.id.button);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              list.add("позиция: " + String.valueOf(++i));
              Adapter62 adapter = new Adapter62(Lab62.this, list,stateClickListener);
              recyclerView.setAdapter(adapter);
            }
        });



        stateClickListener = new Adapter62.OnStateClickListener() {
            @Override
            public void onStateClick(int position) {

                list.remove(position);
                Adapter62 adapter = new Adapter62(getApplicationContext(),list,stateClickListener);
                recyclerView.setAdapter(adapter);


            }
        };
        Adapter62 adapter = new Adapter62(this, list,stateClickListener);
        recyclerView.setAdapter(adapter);
    }
}


