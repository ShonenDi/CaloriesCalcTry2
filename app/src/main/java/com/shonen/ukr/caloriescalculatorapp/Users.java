package com.shonen.ukr.caloriescalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

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
    }

    @Override
    public void onClick(View v) {

    }
}
