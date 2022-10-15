package com.example.lab_lb.l7;

import android.graphics.Color;

public class MsgButton {

    private String text;
    private int color;

    public MsgButton(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public MsgButton() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


}
