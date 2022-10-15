package com.example.lab_lb.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lab_lb.R;

public class Lab31 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31);

        View rotationSquare = findViewById(R.id.Rotate_SQ);

        Button rotateBttn = findViewById(R.id.rotBtn);
        rotateBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(280, 140);
                lp.setMargins(40, 80, 40, 40);
                rotationSquare.setLayoutParams(lp);
                rotationSquare.setPivotX(100);
                rotationSquare.setPivotY(50);
                rotationSquare.setRotation(145);
            }
        });
        Button anim = findViewById(R.id.animBtn);
        anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View animationView = findViewById(R.id.animView);
                animationView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.square_anim));
            }
        });
    }

}