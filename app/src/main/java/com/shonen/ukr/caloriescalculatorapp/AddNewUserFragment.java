package com.shonen.ukr.caloriescalculatorapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class AddNewUserFragment extends Fragment {
    private EditText edtNewUseName, edtNewUserAge, edtNewUserHeight, edtNewUserWeight;
    private Spinner spinner;
    private Button btnSave, btnCancel;
    private boolean female = false;
    private boolean male = false;
    private Double actCoef;
    private ArrayList<User> addNewUser = new ArrayList<User>();
    int userAge;
    double userHeight;
    double userWeight;

    public AddNewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_user, container, false);
        edtNewUseName = view.findViewById(R.id.edtNewUserName);
        edtNewUserAge = view.findViewById(R.id.edtNewUserAge);
        edtNewUserHeight = view.findViewById(R.id.edtNewUserHeight);
        edtNewUserWeight = view.findViewById(R.id.edtNewUserWeight);
        spinner = view.findViewById(R.id.spinner);
        RadioGroup userGenderSelect = view.findViewById(R.id.addNewUserGender);
        userGenderSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chkFemaleGend:
                        female = true;
                        break;
                    case R.id.chkMaleGend:
                        male = true;
                        break;
                }
            }
        });

        btnSave = view.findViewById(R.id.add_new_user_save_btn);
        btnCancel = view.findViewById(R.id.add_new_user_calcel_btn);

        final UserDbHelper userDbHelper = new UserDbHelper(getContext());
        final SQLiteDatabase database = userDbHelper.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            try {
                final String username = edtNewUseName.getText().toString();
                actCoef = Double.valueOf(spinner.getSelectedItem().toString());
                userAge = Integer.parseInt(edtNewUserAge.getText().toString());
                userHeight = Double.valueOf(edtNewUserHeight.getText().toString());
                userWeight = Double.valueOf(edtNewUserWeight.getText().toString());

                contentValues.put(UserDbHelper.COLUMN_NAME, username);
                contentValues.put(UserDbHelper.COLUMN_AGE, userAge);
                if (female) {
                    contentValues.put(UserDbHelper.COLUMN_GENDER, "Female");
                } else if (male) {
                    contentValues.put(UserDbHelper.COLUMN_GENDER, "Male");
                }
                contentValues.put(UserDbHelper.COLUMN_HEIGHT, userHeight);
                contentValues.put(UserDbHelper.COLUMN_WEIGHT, userWeight);
                contentValues.put(UserDbHelper.COLUMN_ACTIVITY, actCoef);
                contentValues.put(UserDbHelper.COLUMN_CALORIES_PER_DAY, calcCaloriesPerDay());

                database.insert(UserDbHelper.TABLE_NAME, null, contentValues);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }

                Intent intent = new Intent(getContext(),Users.class);
                startActivity(intent);
            }
//
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Users.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public double calcCaloriesPerDay() {

        double userWeight = Double.valueOf(edtNewUserWeight.getText().toString());
        double userHeigh = Double.valueOf(edtNewUserHeight.getText().toString());
        int age = Integer.valueOf(edtNewUserAge.getText().toString());

        double caloriesPerDay = 0;
        if (male) {
            caloriesPerDay = (88.36 + (13.4 * userWeight) + (4.8 * userHeigh) + (5.7 * age)) * actCoef;
        } else if (female) {
            caloriesPerDay = (44.76 + (9.2 * userWeight) + (4.8 * userHeigh) + (3.1 * age)) * actCoef;
        }
        return caloriesPerDay;
    }
}
