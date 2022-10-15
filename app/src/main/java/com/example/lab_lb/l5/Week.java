package com.example.lab_lb.l5;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import android.os.Build;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

public class Week {
    private final TreeMap<GregorianCalendar, ArrayList<String>> tasks = new TreeMap<>();

    public Week() {
    }

    public void addTask(int year, int month, int day, String body) {
        GregorianCalendar d = new GregorianCalendar(year, month, day);
        if (!tasks.containsKey(d)) {
            tasks.put(d, new ArrayList<>());
            tasks.get(d).add(body);
        } else {
            if (tasks.get(d) != null)
                tasks.get(d).add(body);
            else
                Log.d("LOG", "CAN'T GET KALMLKMWD");
        }
    }


    public ArrayList<Pair<Boolean, String>> toList() {
        ArrayList<Pair<Boolean,String>> list = new ArrayList<>();
        Iterator<GregorianCalendar> i = tasks.descendingKeySet().stream().iterator();
        while (i.hasNext()) {
            GregorianCalendar d = i.next();
            String dateString = Integer.toString(d.get(Calendar.DAY_OF_MONTH)) + "." +
                    Integer.toString(d.get(Calendar.MONTH)) + "." +
                    Integer.toString(d.get(Calendar.YEAR));
            Pair<Boolean, String> datePair = new Pair<>(true, dateString);
            list.add(datePair);
            ArrayList<String> taskList = tasks.get(d);
            for (String task : taskList)
                list.add(new Pair<>(false, task));
        }
        return list;
    }



    @Override
    public String toString() {
        String ans = "";
        Iterator<GregorianCalendar> i = tasks.descendingKeySet().stream().iterator();
        while (i.hasNext()) {
            GregorianCalendar d = i.next();
            String dateString = Integer.toString(d.get(Calendar.YEAR)) + "/" +
                    Integer.toString(d.get(Calendar.MONTH)) + "/" +
                    Integer.toString(d.get(Calendar.DAY_OF_MONTH));
            ans += dateString + ": ";
            ArrayList<String> taskList = tasks.get(d);
            for (String task : taskList)
                ans += task + " ";
            ans += "; ";
        }
        return ans;
    }
}
