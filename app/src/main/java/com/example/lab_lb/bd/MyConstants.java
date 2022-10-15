package com.example.lab_lb.bd;

public class MyConstants {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "DBaseV.db";


    public static final String TABLE_NAME_QUESTIONS = "name_que";


    // Общий id для Subject, Question и Date
    public static final String _ID = "_id";
    // Таблица предметов
    public static final String SUBJECT = "subject";


       public static final String TABLE_STRUCTURE_QUE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME_QUESTIONS + " (" + _ID + " INTEGER PRIMARY KEY," + SUBJECT + " TEXT)";


    public static final String DROP_TABLE_QUE = "DROP TABLE IF EXISTS " + TABLE_NAME_QUESTIONS;

}