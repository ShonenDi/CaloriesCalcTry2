package com.shonen.ukr.caloriescalculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;

public class Users extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<User> listOfUsers = new ArrayList<>();
    private ListView viewListOfUsers;
    private Button btnAddNewUser;
    private UserInfoAdapter userInfoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        setTitle(R.string.user_screen_title);
        userInfoAdapter = new UserInfoAdapter(Users.this,listOfUsers);
        viewListOfUsers = findViewById(R.id.userListView);
        viewListOfUsers.setAdapter(userInfoAdapter);

        btnAddNewUser = findViewById(R.id.btnAddNewUser);
        btnAddNewUser.setOnClickListener(this);

        try {
            Bundle arguments = getIntent().getExtras();
            final User newUser;
            newUser = (User) arguments.getSerializable(User.class.getSimpleName());
            listOfUsers.add(new User(newUser.getUserName(),newUser.getUserAge(),newUser.getUserHeight(),newUser.getUserWeight(),
                    newUser.getUserActivityCoef(),newUser.getCaloriesPerDay()));
            userInfoAdapter.notifyDataSetChanged();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("users",listOfUsers);
    }
    //    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        outState.putSerializable("users",listOfUsers);
//            super.onSaveInstanceState(outState, outPersistentState);
//    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle state) {
        super.onRestoreInstanceState(state);
        this.listOfUsers.clear();
        this.listOfUsers.addAll((ArrayList<User>) state.getSerializable("users"));
        this.userInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnAddNewUser){
            Intent intent = new Intent(this,AddNewUser.class);
            startActivity(intent);
        }
    }
}
