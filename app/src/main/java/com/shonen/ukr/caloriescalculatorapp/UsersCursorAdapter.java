package com.shonen.ukr.caloriescalculatorapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class UsersCursorAdapter extends CursorAdapter {
    public UsersCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.user_info_list,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView userName = view.findViewById(R.id.txtUserNameInfo);
        userName.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        TextView userActivityCoef = view.findViewById(R.id.txtUserInfoCoef);
        userActivityCoef.setText(String.valueOf(cursor.getDouble(cursor.getColumnIndexOrThrow("activity"))));
        TextView userWeight = view.findViewById(R.id.txtUserInfoWeight);
        userWeight.setText(String.valueOf(cursor.getDouble(cursor.getColumnIndexOrThrow("weight"))));
        TextView userHeight = view.findViewById(R.id.txtUserInfoHeight);
        userHeight.setText(String.valueOf(cursor.getDouble(cursor.getColumnIndexOrThrow("height"))));
        TextView userCaloriesPerDay = view.findViewById(R.id.txtUserInfoCalPerDay);
        userCaloriesPerDay.setText(String.valueOf(cursor.getDouble(cursor.getColumnIndexOrThrow("caloriesperday"))));
    }
}
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_AGE = "age";
//    public static final String COLUMN_GENDER= "gender";
//    public static final String COLUMN_HEIGHT = "height";
//    public static final String COLUMN_WEIGHT = "weight";
//    public static final String COLUMN_ACTIVITY = "activity";
//    public static final String COLUMN_CALORIES_PER_DAY = "caloriesperday";