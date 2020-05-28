package com.shonen.ukr.caloriescalculatorapp;

import android.content.Intent;
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


public class AddNewUserFragment extends Fragment  {
    private EditText edtNewUseName, edtNewUserAge, edtNewUserHeight, edtNewUserWeight;
    private Spinner spinner;
    private Button btnSave, btnCancel;
    private boolean female = false;
    private boolean male = false;
    private Double actCoef;
    private ArrayList<User> addNewUser = new ArrayList<User>();

    public AddNewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_user, container, false);
        edtNewUseName = view.findViewById(R.id.edtNewUserName);
        edtNewUserAge = view.findViewById(R.id.edtNewUserAge);
        edtNewUserHeight = view.findViewById(R.id.edtNewUserHeight);
        edtNewUserWeight = view.findViewById(R.id.edtNewUserWeight);
        spinner = view.findViewById(R.id.spinner);
        try {
            actCoef = Double.valueOf(spinner.getSelectedItem().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User newUser = new User(edtNewUseName.getText().toString(), Integer.valueOf(edtNewUserAge.getText().toString()),
                            Double.valueOf(edtNewUserHeight.getText().toString()), Double.valueOf(edtNewUserWeight.getText().toString()), actCoef, calcCaloriesPerDay());

                    Toast.makeText(getContext(),newUser.getUserName().toString() + " \n" + newUser.getUserActivityCoef() + "\n" + newUser.getUserWeight()
                            + " \n" + newUser.getUserHeight()+ " \n" + newUser.getCaloriesPerDay(),Toast.LENGTH_LONG).show();
                    if (male) {
                        newUser.setGenderMale(true);
                    } else if (female) {
                        newUser.setGenderFemale(true);
                    }
                    newUser.setUserActivityCoef(actCoef);
                    Intent intent = new Intent(getContext(),Users.class);
                    intent.putExtra(User.class.getSimpleName(),newUser);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                } catch (IllegalArgumentException e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Users.class);
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
