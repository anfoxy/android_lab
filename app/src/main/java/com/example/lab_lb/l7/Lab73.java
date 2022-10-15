package com.example.lab_lb.l7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.lab_lb.MainActivity;
import com.example.lab_lb.R;
import com.example.lab_lb.l6.Adapter62;
import com.example.lab_lb.l6.Lab62;

import java.util.ArrayList;
import java.util.List;

public class Lab73 extends AppCompatActivity {
    private Adapter73.OnStateClickListener stateClickListener;
    private String[] countries = { "Красный", "Желтый", "Зеленный", "Голубой", "Черный"};
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab73);

        List<MsgButton> list = new ArrayList<>();



        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String) parent.getItemAtPosition(position);

                switch (item) {
                    case "Красный":
                        color = Color.RED;
                        break;

                    case "Желтый":
                        color = Color.YELLOW;
                        break;

                    case "Зеленный":
                        color = Color.GREEN;
                        break;
                    case "Голубой":
                        color = Color.BLUE;
                        break;

                    case "Черный":
                        color = Color.BLACK;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        EditText editText = findViewById(R.id.text);
        final RecyclerView recyclerView = findViewById(R.id.list1);
        Button l2 = findViewById(R.id.button2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgButton msgButton = new MsgButton();
                msgButton.setText(editText.getText().toString());
                msgButton.setColor(color);
                list.add(msgButton);
                Adapter73 adapter = new Adapter73(Lab73.this, list,stateClickListener);
                recyclerView.setAdapter(adapter);
            }
        });



        stateClickListener = new Adapter73.OnStateClickListener() {
            @Override
            public void onStateClick(int position) {

                list.remove(position);
                Adapter73 adapter = new Adapter73(getApplicationContext(),list,stateClickListener);
                recyclerView.setAdapter(adapter);


            }
        };
        Adapter73 adapter73 = new Adapter73(this, list,stateClickListener);
        recyclerView.setAdapter(adapter73);
    }
}