package com.example.lab_lb.l8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab_lb.R;

public class Lab8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8);


        TextView textView = findViewById(R.id.L1TextView);
        Button incBttn = findViewById(R.id.L1IncBttn);
        Button resetBttn = findViewById(R.id.L1ResetBttn);

        Counter c = new Counter();

        incBttn.setOnClickListener(view -> {
            c.increase();
            textView.setText((CharSequence) Long.toString(c.getCount()));
        });

        resetBttn.setOnClickListener(view -> {
            c.reset();
            textView.setText((CharSequence) Long.toString(c.getCount()));
        });

        EditText editText = findViewById(R.id.L1EditText);
        Button addBttn = findViewById(R.id.L1AddWord);
        Button rmBttn = findViewById(R.id.L1RmWord);
        TextView listTV = findViewById(R.id.L1ListTextView);

        StringList sl = new StringList();

        addBttn.setOnClickListener(view -> {
            String addStr = editText.getText().toString();
            sl.add(addStr);
            listTV.setText(sl.toString());
        });

        rmBttn.setOnClickListener(view -> {
            sl.removeLast();
            listTV.setText(sl.toString());
        });
    }
}
