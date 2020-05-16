package com.shonen.ukr.caloriescalculatorapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class AddNewUserFragment extends Fragment {
   private EditText edtNewUseName;

    public AddNewUserFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_add_new_user, container, false);
        edtNewUseName=view.findViewById(R.id.edtNewUserName);
        return view;
    }
}
