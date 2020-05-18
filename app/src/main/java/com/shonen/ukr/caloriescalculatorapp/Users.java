package com.shonen.ukr.caloriescalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Users extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<User> listOfUsers;
    private ListView viewListOfUsers;
    private Button btnAddNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        setTitle(R.string.user_screen_title);

        btnAddNewUser = findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAddNewUser){
            Intent intent = new Intent(this,AddNewUser.class);
            startActivity(intent);
        }
    }
}
