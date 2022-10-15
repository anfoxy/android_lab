package com.example.lab_lb.l5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.lab_lb.R;

public class Lab54 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab54);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.L6ViewPager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);


    }

    public static class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            SlideFragment sl = new SlideFragment();
            switch (i) {
                case 0:
                    sl.setBody("Первая задача на неделю");
                    break;
                case 1:
                    sl.setBody("Вторая задача на неделю");
                    break;
                case 2:
                    sl.setBody("Третья задача на неделю");
                    break;
                case 3:
                    sl.setBody("Четвертая задача на неделю");
                    break;
                default:
                    sl.setBody("NULL");
                    break;
            }
            return sl;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
