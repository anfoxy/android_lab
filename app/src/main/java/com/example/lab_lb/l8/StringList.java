package com.example.lab_lb.l8;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class StringList {
    private final ArrayList<String> list;
    public StringList() {
        list = new ArrayList<>();
    }

    public void add(String str) {
        list.add(str.toLowerCase());
    }

    public String removeLast() {
        if (list.size() == 0)
            return "";
        return list.remove(list.size() - 1);
    }

    @NonNull
    @Override
    public String toString() {
        if(list.size() == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i)).append(", ");
        }
        builder.append(list.get(list.size() - 1));
        builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
        return builder.toString();
    }
}
