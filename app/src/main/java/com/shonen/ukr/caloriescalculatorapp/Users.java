package com.shonen.ukr.caloriescalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class Users extends AppCompatActivity implements View.OnClickListener {
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor userCursor;
    UsersCursorAdapter cursorAdapter;
    private ListView viewListOfUsers;
    private Button btnAddNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        viewListOfUsers = findViewById(R.id.userListView);

        userDbHelper = new UserDbHelper(this);

        btnAddNewUser = findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();

        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userCursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ UserDbHelper.TABLE_NAME,null);
        cursorAdapter = new UsersCursorAdapter(this,userCursor,0);
        viewListOfUsers.setAdapter(cursorAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAddNewUser){
            Intent intent = new Intent(this,AddNewUser.class);
            startActivity(intent);
        }
    }

    @Override
    public void onDestroy() {
        sqLiteDatabase.close();
        userCursor.close();
        super.onDestroy();
    }
}
