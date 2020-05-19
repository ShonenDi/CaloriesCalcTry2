package com.shonen.ukr.caloriescalculatorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserInfoAdapter extends ArrayAdapter<User> {
    public UserInfoAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
            if(listItem==null){
                listItem = LayoutInflater.from(getContext()).inflate(R.layout.user_info_list,parent,false);
            }
            User customUser = getItem(position);
        ImageView gendImage = listItem.findViewById(R.id.genderIMG);
        TextView userName = listItem.findViewById(R.id.txtUserNameInfo);
        userName.setText(customUser.getUserName());
        TextView userActivityCoef = listItem.findViewById(R.id.txtUserInfoCoef);
        userActivityCoef.setText(String.valueOf(customUser.getUserActivityCoef()));
        TextView userWeight = listItem.findViewById(R.id.txtUserInfoWeight);
        userActivityCoef.setText(String.valueOf(customUser.getUserWeight()));
        TextView userHeight = listItem.findViewById(R.id.txtUserInfoHeight);
        userActivityCoef.setText(String.valueOf(customUser.getUserHeight()));
        TextView userCaloriesPerDay = listItem.findViewById(R.id.txtUserInfoCalPerDay);
        userActivityCoef.setText(String.valueOf(customUser.getCaloriesPerDay()));
        return listItem;
    }
}
