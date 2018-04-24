package com.example.ccojo.clujtourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ccojo on 4/21/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(@NonNull Context context, @NonNull ArrayList<Restaurant> restaurants) {
        super(context, 0, restaurants);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant currentRestaurant = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.restaurant_name);
        TextView addressTV = convertView.findViewById(R.id.restaurant_address);
        TextView phoneTV = convertView.findViewById(R.id.restaurant_phone);
        TextView typeTV = convertView.findViewById(R.id.restaurant_type);
        TextView programTV = convertView.findViewById(R.id.restaurant_program);

        nameTV.setText(currentRestaurant != null ? currentRestaurant.getmName() : getContext().getString(R.string.unknown_name));
        addressTV.setText(currentRestaurant != null ? currentRestaurant.getmAddress() : getContext().getString(R.string.no_address));
        phoneTV.setText(currentRestaurant != null ? currentRestaurant.getmPhone() : getContext().getString(R.string.no_phone));
        StringBuilder type = new StringBuilder();
        for (String str : currentRestaurant.getmType()) {
            if (type.toString().equals("")) {
                type.append(str);
            } else {
                type.append(", ").append(str);
            }
        }
        typeTV.setText(type.toString());
        programTV.setText(currentRestaurant.getmProgram());

        return convertView;
    }
}
