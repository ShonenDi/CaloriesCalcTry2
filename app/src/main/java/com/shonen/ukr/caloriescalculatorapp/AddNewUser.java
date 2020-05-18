package com.shonen.ukr.caloriescalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AddNewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        getSupportFragmentManager().beginTransaction().replace(R.id.add_user_layout,new AddNewUserFragment()).commit();
    }
}
