package com.example.lab_lb.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(@Nullable Context context) {
        super(context, MyConstants.DB_NAME,null, MyConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyConstants.TABLE_STRUCTURE_QUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyConstants.DROP_TABLE_QUE);
        onCreate(db);

    }
}