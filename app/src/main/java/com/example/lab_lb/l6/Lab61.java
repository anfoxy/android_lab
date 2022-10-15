package com.example.lab_lb.l6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab_lb.R;

public class Lab61 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab61);


        LinearLayout dataLayout = findViewById(R.id.L1DataLayout);
        View v1 = createView(255, 255, 255, 0, 0, 0, "Белый");
        View v2 = createView(0, 0, 0, 255, 255, 255, "Черный");
        View v3 = createView(0, 0, 255, 255, 255, 0, "Синий");
        dataLayout.addView(v1);
        dataLayout.addView(v2);
        dataLayout.addView(v3);




        LinearLayout dataLayout2 = findViewById(R.id.L3DataLayout);
        View v11 = createView2(255, 255, 255, 0, 0, 0, "Белый");
        View v12 = createView2(0, 0, 0, 255, 255, 255, "Черный");
        View v13 = createView2(0, 0, 255, 255, 255, 0, "Синий");
        dataLayout2.addView(v11);
        dataLayout2.addView(v12);
        dataLayout2.addView(v13);


        Button saveBttn = findViewById(R.id.L6SaveBttn);
        CheckBox checkBox = findViewById(R.id.L6CheckBox);
        EditText editText = findViewById(R.id.L6EditText);

        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        String text = sp.getString("text", "");
        Boolean check = sp.getBoolean("bool", false);
        checkBox.setChecked(check);
        editText.setText((CharSequence) text);

        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Boolean check = checkBox.isChecked();
                SharedPreferences.Editor ed = sp.edit();
                ed.putBoolean("bool", check);
                ed.putString("text", text);
                ed.apply();
            }
        });



    }

    private View createView(int br, int bg, int bb, int tr, int tg, int tb, String text) {
        View v = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.lab61_1, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 100);
        lp.setMargins(0, 0, 0, 20);
        v.setLayoutParams(lp);

        LinearLayout background = v.findViewById(R.id.layout);
        TextView textView = v.findViewById(R.id.textView);
        background.setBackgroundColor(Color.argb(255, br, bg, bb));
        textView.setTextColor(Color.argb(255, tr, tg, tb));
        textView.setText(text);
        return v;
    }


    private View createView2(int br, int bg, int bb, int tr, int tg, int tb, String text) {
        LinearLayout l = new LinearLayout(getApplicationContext());
        l.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 100);
        lp.setMargins(0, 0, 0, 20);
        l.setLayoutParams(lp);
        l.setBackgroundColor(Color.argb(255, br, bg, bb));

        TextView textView = new TextView(getApplicationContext());
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp2.setMargins(0, 20, 0, 20);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(lp2);
        textView.setTextColor(Color.argb(255, tr, tg, tb));
        textView.setText(text);

        l.addView(textView);
        return l;
    }

}
