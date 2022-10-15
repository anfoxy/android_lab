package com.example.lab_lb.l3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.lab_lb.R;

public class Lab32 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(new DrawView(this));
        }

        static class DrawView extends View {

            Paint p;

            public DrawView(Context context) {
                super(context);
                p = new Paint();
            }

            @Override
            protected void onDraw(Canvas canvas) {
                canvas.drawARGB(80, 102, 204, 255);
                p.setColor(Color.RED);
                canvas.drawRect(50, 50, 350, 350, p);
                p.setColor(Color.GREEN);
                canvas.drawRect(350, 200, 650, 500, p);
                p.setColor(Color.BLUE);
                canvas.drawRect(488, 50, 788, 350, p);

                p.setColor(Color.RED);
                canvas.drawRect(50, 600, 350, 900, p);

                p.setColor(Color.GREEN);
                canvas.drawRect(400, 600, 700, 900, p);

                p.setColor(Color.BLUE);
                canvas.drawRect(750, 600, 1050, 900, p);

                p.setColor(Color.YELLOW);
                canvas.drawRect(50, 950, 350, 1250, p);

                p.setColor(Color.BLACK);
                canvas.drawRect(750, 950, 1050, 1250, p);

                p.setTextSize(60);
                p.setColor(Color.WHITE);
                p.setTextAlign(Paint.Align.CENTER);
                canvas.drawText("Квадрат", 635, 210, p);

                p.setColor(Color.BLACK);
                canvas.drawRect(50, 1300, 400, 1650, p);

                p.setColor(Color.BLACK);
                p.setStrokeWidth(240);
                canvas.drawLine(700,1650,950,1400,p);
            }

        }
    }