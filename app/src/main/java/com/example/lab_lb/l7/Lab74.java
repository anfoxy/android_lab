package com.example.lab_lb.l7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab_lb.R;
import com.example.lab_lb.l6.Adapter62;
import com.example.lab_lb.l6.Lab62;

import java.util.ArrayList;
import java.util.List;

public class Lab74 extends AppCompatActivity {
    private Adapter62.OnStateClickListener stateClickListener;
    private Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab74);

        Date d = new Date();
        EditText text = findViewById(R.id.L4TimeText);
        String t = Integer.toString(d.hour) + ":" +
                Integer.toString(d.min) + ":" + Integer.toString(d.sec);
        text.setText(t);
        Handler.Callback hc = new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                d.addSecond();
                String time = Integer.toString(d.hour) + ":" +
                        Integer.toString(d.min) + ":" + Integer.toString(d.sec);
                text.setText(time);
                h.sendEmptyMessageDelayed(0, 1000);
                return true;
            }
        };
        h = new Handler(hc);


        Button timer = findViewById(R.id.L4Bttn);
        timer.setOnClickListener(view -> {
            if (h.hasMessages(0))
                h.removeMessages(0);
            else
                h.sendEmptyMessageDelayed(0, 1000);
        });


        List<String> list = new ArrayList<>();

        final RecyclerView recyclerView = findViewById(R.id.list1);
        Button l2 = findViewById(R.id.L4FixBttn);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String time = Integer.toString(d.hour) + ":" +
                        Integer.toString(d.min) + ":" + Integer.toString(d.sec);
                list.add(time);
                Adapter62 adapter = new Adapter62(Lab74.this, list,stateClickListener);
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

    public static class Date {
        public int hour;
        public int min;
        public int sec;
        public Date() {
            hour = min = sec = 0;
        }
        public Date(Date c) {
            hour = c.hour;
            min = c.min;
            sec = c.sec;
        }
        public Date(int _hour, int _min, int _sec) {
            this.setTime(_hour, _min, _sec);
        }
        public void setTime(int _hour, int _min, int _sec) {
            hour = _hour % 24;
            min = _min % 60;
            sec = _sec % 60;
        }
        public void addSecond() {
            sec += 1;
            min = min + sec / 60;
            hour = hour + min / 60;
            sec = sec % 60;
            min = min % 60;
            hour = hour % 24;
        }
        public void rmSecond() {
            sec -= 1;
            if (sec < 0) {
                sec = 59;
                min -= 1;
            }
            if (min < 0) {
                min = 59;
                hour -= 1;
            }
            if (hour < 0) {
                hour = 23;
            }
        }

        @Override
        public String toString() {
            return "Hour: " + hour + "| Min: " + min + "| Sec: " + sec;
        }
    }

}
