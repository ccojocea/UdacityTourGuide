package com.example.ccojo.clujtourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.text.util.Linkify.PHONE_NUMBERS;

/**
 * Created by ccojo on 4/21/2018.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{
    private static final String TAG = "RestaurantAdapter";

    public RestaurantAdapter(@NonNull Context context, @NonNull ArrayList<Restaurant> restaurants){
        super(context, 0, restaurants);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant currentRestaurant = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.restaurant_name);
        TextView addressTV = convertView.findViewById(R.id.restaurant_address);
        TextView phoneTV = convertView.findViewById(R.id.restaurant_phone);
        TextView typeTV = convertView.findViewById(R.id.restaurant_type);
        TextView programTV = convertView.findViewById(R.id.restaurant_program);

        nameTV.setText(currentRestaurant.getmName());
        addressTV.setText(currentRestaurant.getmAddress());
        phoneTV.setText(currentRestaurant.getmPhone());
        Log.d(TAG, "getPhone: " + currentRestaurant.getmPhone());
        //phoneTV.setAutoLinkMask(PHONE_NUMBERS);
        String type = "";
        for(String str : currentRestaurant.getmType()){
            if(type.equals("")){
                type += str;
            } else {
                type += ", " + str;
            }
        }
        typeTV.setText(type);
        programTV.setText(currentRestaurant.getmProgram());

        return convertView;
    }
}
