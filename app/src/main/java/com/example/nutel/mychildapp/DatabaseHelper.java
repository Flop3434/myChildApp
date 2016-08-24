package com.example.nutel.mychildapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DatabaseHelper
 *
 * This class is used to create the database and tables used for myChild and insert/retrieve data
 * from the database
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Name of SQLite database file
    public static final String DATABASE_NAME = "mychild.db";

    // Alerts table
    public static final String TABLE_ALERTS = "table_alerts";
    public static final String COL_ALERT_ID = "ID";
    public static final String COL_ALERT_TIME = "TIME";
    public static final String COL_ALERT_TYPE = "ALERT_TYPE";
    public static final String COL_ALERT_DAYS = "DAYS";


    // Events table
    public static final String TABLE_EVENTS = "table_events";
    public static final String COL_EVENT_ID = "ID";
    public static final String COL_EVENT_DATE = "DATE";
    public static final String COL_EVENT_TIME = "TIME";
    public static final String COL_EVENT_TYPE = "EVENT_TYPE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create the Alerts table
        db.execSQL("create table " + TABLE_ALERTS + " (" +
                COL_ALERT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_ALERT_TIME + " TEXT," +
                COL_ALERT_TYPE + " TEXT," +
                COL_ALERT_DAYS + " TEXT" +
                ")");

        // Create the Events table
        db.execSQL("create table " + TABLE_EVENTS + " (" +
                COL_EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_EVENT_DATE + " TEXT," +
                COL_EVENT_TIME + " TEXT," +
                COL_EVENT_TYPE + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        onCreate(db);
    }
}
