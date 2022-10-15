package com.example.lab_lb.l6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab_lb.MainActivity;
import com.example.lab_lb.R;
import com.example.lab_lb.bd.MyDBManager;

import java.util.ArrayList;
import java.util.List;

public class Lab64 extends AppCompatActivity {

    private Adapter62.OnStateClickListener stateClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab64);


        List<String> list = new ArrayList<>(MainActivity.myDBManager.set());

        EditText editText = findViewById(R.id.editText2);

        final RecyclerView recyclerView = findViewById(R.id.list1);

        Button l2 = findViewById(R.id.button);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( !list.contains(editText.getText().toString())) {
                   list.add(editText.getText().toString());
                   MainActivity.myDBManager.insert_TABLE_QUE(editText.getText().toString());
                   Adapter62 adapter = new Adapter62(Lab64.this, list, stateClickListener);
                   recyclerView.setAdapter(adapter);
               }else {
                   Toast toast = Toast.makeText(Lab64.this,
                           "такая заметка существует", Toast.LENGTH_SHORT);
                   toast.show();
               }
            }
        });



        stateClickListener = new Adapter62.OnStateClickListener() {
            @Override
            public void onStateClick(int position) {
                MainActivity.myDBManager.delete_plantoday(list.get(position));
                list.remove(position);
                Adapter62 adapter = new Adapter62(getApplicationContext(),list,stateClickListener);
                recyclerView.setAdapter(adapter);


            }
        };
        Adapter62 adapter = new Adapter62(this, list,stateClickListener);
        recyclerView.setAdapter(adapter);
    }
}