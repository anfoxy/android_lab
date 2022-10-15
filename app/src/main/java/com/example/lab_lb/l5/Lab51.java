package com.example.lab_lb.l5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab_lb.R;

public class Lab51 extends AppCompatActivity {
    private int stackSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab51);


        Button back = findViewById(R.id.b);
        Button forward = findViewById(R.id.g);
        TextView stackSizeField = findViewById(R.id.text);


        this.stackSize = getIntent().getIntExtra("stackSize", 0);
        String s = stackSizeField.getText().toString();
        s += Integer.toString(stackSize);
        stackSizeField.setText((CharSequence) s);

        forward.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Lab51.class);
            i.putExtra("stackSize", stackSize + 1);
            startActivity(i);
        });

        back.setOnClickListener(view -> {
            finish();
        });



    }
}