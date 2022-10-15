package com.example.lab_lb.l7;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lab_lb.R;
import com.example.lab_lb.l5.Lab53;

public class Lab71 extends Activity {

    private ImageView r, y, g;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab71);
        r = findViewById(R.id.r);
        y = findViewById(R.id.y);
        g = findViewById(R.id.g);
        setColor(r,android.R.color.darker_gray);
        setColor(y,android.R.color.darker_gray);
        setColor(g,android.R.color.darker_gray);

        new Thread((Runnable) () -> {

            try {
                while (true) {
                    setColor(g,android.R.color.darker_gray);
                    setColor(r,android.R.color.holo_red_dark);
                    Thread.sleep(5000);
                    setColor(r,android.R.color.darker_gray);
                    setColor(y, android.R.color.holo_orange_light);
                    Thread.sleep(5000);
                    setColor(y,android.R.color.darker_gray);
                    setColor(g, android.R.color.holo_green_dark);
                    ImageView animationView = findViewById(R.id.m);
                    animationView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m_anim));
                    Thread.sleep(5000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void setColor(ImageView im,@ColorRes int id){
        im.setColorFilter(ContextCompat.getColor(getApplicationContext(), id),
                PorterDuff.Mode.MULTIPLY);
    }
}


