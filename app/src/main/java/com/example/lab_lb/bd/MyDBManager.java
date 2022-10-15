package com.example.lab_lb.bd;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyDBManager {
    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;
    public MyDBManager(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }
    public void openDB() {
        db = myDBHelper.getWritableDatabase();
    }

    public Cursor getYourTableContents() {
        openDB();
        Cursor data = db.rawQuery("SELECT * FROM " + "name_sub", null);
        return data;
    }
    @SuppressLint("Range")
    public ArrayList<String> set() {
        openDB();
        ArrayList<String> pl = new ArrayList<>();

        String queryID_que = "SELECT " + MyConstants._ID + ", " + MyConstants.SUBJECT  + " FROM " + MyConstants.TABLE_NAME_QUESTIONS;
        Cursor cursor2 = db.rawQuery(queryID_que, null);
        cursor2.moveToFirst();
        int ff = 0;

        while (cursor2.moveToNext()) {
            ff += 1;
        }

        if(ff > 0) {
            cursor2.moveToFirst();
            do {
                pl.add(cursor2.getString(cursor2.getColumnIndex(MyConstants.SUBJECT)));
            }
            while (cursor2.moveToNext());


            cursor2.close();
        }
        return pl;
    }
    public void insert_TABLE_QUE(String name) {
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.SUBJECT,  name);

        db.insert(MyConstants.TABLE_NAME_QUESTIONS, null, cv);
    }

    @SuppressLint("Range")
    public void delete_plantoday(String name) {
        String queryID_que = "SELECT " + MyConstants._ID + ", " + MyConstants.SUBJECT  + " FROM " + MyConstants.TABLE_NAME_QUESTIONS;
        Cursor cursor = db.rawQuery(queryID_que, null);
        cursor.moveToFirst();
        do {
             String n = cursor.getString(cursor.getColumnIndex(MyConstants.SUBJECT));
            if (name.equals(n)) {
                 int ind = cursor.getInt(cursor.getColumnIndex(MyConstants._ID));
                db.delete(MyConstants.TABLE_NAME_QUESTIONS, MyConstants._ID + " = ?", new String[]{String.valueOf(ind)});
            }
        } while (cursor.moveToNext());
        cursor.close();
    }

    public void closeDB() {
        myDBHelper.close();
    }
}

