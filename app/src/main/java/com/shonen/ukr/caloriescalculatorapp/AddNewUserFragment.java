package com.shonen.ukr.caloriescalculatorapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class AddNewUserFragment extends Fragment {
   private EditText edtNewUseName,edtNewUserAge,edtNewUserHeight,edtNewUserWeight;
   private Spinner spinner;
   private Button btnSave,btnCancel;

    public AddNewUserFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_add_new_user, container, false);
        edtNewUseName=view.findViewById(R.id.edtNewUserName);
        edtNewUserAge = view.findViewById(R.id.edtNewUserAge);
        edtNewUserHeight = view.findViewById(R.id.edtNewUserHeight);
        edtNewUserWeight = view.findViewById(R.id.edtNewUserWeight);

        spinner =view.findViewById(R.id.spinner);

        btnSave = view.findViewById(R.id.add_new_user_save_btn);
        btnCancel = view.findViewById(R.id.add_new_user_calcel_btn);

        return view;
    }
}
