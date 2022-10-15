package com.example.lab_lb.l5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab_lb.R;

import java.util.ArrayList;

public class Lab55 extends AppCompatActivity {

    private LinearLayout dataLayout;
    private  TextView t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab55);

        t = findViewById(R.id.t);
        Week tasks = new Week();
        tasks.addTask(2022, 9, 11, "Пункт 1");
        tasks.addTask(2022, 9, 12, "Пункт 2");
        tasks.addTask(2022, 9, 15, "Пункт 3");
        tasks.addTask(2022, 9, 22, "Пункт 4");
        ArrayList<Pair<Boolean, String>> list = tasks.toList();

        dataLayout = findViewById(R.id.L8DataLayout);
        for(Pair<Boolean, String> pair : list) {
            TextView tv = new TextView(Lab55.this);
            tv.setText((CharSequence) pair.second);
            tv.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            tv.setTextSize(30);
            dataLayout.addView(tv);
            registerForContextMenu(tv);
        }
    }


    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        t.setText("Индекс элемента списка: " + Integer.toString(dataLayout.indexOfChild(v)));
        menu.add(0, MENU_ITEM_1, 0, "Item_1");
        menu.add(0, MENU_ITEM_2, 0, "Item_2");
        menu.add(0, MENU_ITEM_3, 0, "Item_3");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        t.setText("Выбранный элемент меню: " + item.getTitle());
        return super.onContextItemSelected(item);
    }
}
