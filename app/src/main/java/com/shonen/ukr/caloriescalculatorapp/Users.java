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
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(Users.this,listOfUsers);
        viewListOfUsers = findViewById(R.id.userListView);
        viewListOfUsers.setAdapter(userInfoAdapter);
        btnAddNewUser = findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(this);

        try {
            Bundle arguments = getIntent().getExtras();
            final User newUser;
            newUser = (User) arguments.getSerializable(User.class.getSimpleName());
            userInfoAdapter.add(new User(newUser.getUserName(),newUser.getUserAge(),newUser.getUserHeight(),newUser.getUserWeight(),
                    newUser.getUserActivityCoef(),newUser.getCaloriesPerDay()));
            userInfoAdapter.notifyDataSetChanged();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAddNewUser){
            Intent intent = new Intent(this,AddNewUser.class);
            startActivity(intent);
        }
    }
}
