package com.shonen.ukr.caloriescalculatorapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "appusers.db";
    private static final int SCHEMA = 1;
    static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER= "gender";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_ACTIVITY = "activity";
    public static final String COLUMN_CALORIES_PER_DAY = "caloriesperday";


    public UserDbHelper(@Nullable Context context) {
        super(context, DB_NAME,null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + "  INTEGER PRIMARY KEY,"
                        + COLUMN_NAME + " TEXT," + COLUMN_AGE + " INTEGER," +
                COLUMN_GENDER + " TEXT," + COLUMN_HEIGHT + " REAL," +
                COLUMN_WEIGHT + " REAL," + COLUMN_ACTIVITY + " REAL," +
                COLUMN_CALORIES_PER_DAY + " REAL )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
