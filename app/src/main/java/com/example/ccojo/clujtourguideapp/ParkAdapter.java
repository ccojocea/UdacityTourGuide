package com.example.ccojo.clujtourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by ccojo on 4/22/2018.
 */

public class ParkAdapter extends ArrayAdapter<Park>{

    public ParkAdapter(@NonNull Context context, @NonNull ArrayList<Park> parks) {
        super(context, 0, parks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Park currentPark = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.park_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.park_name);
        TextView addressTV = convertView.findViewById(R.id.park_address);
        TextView phoneTV = convertView.findViewById(R.id.park_phone);
        TextView webTV = convertView.findViewById(R.id.park_web);
        TextView emailTV = convertView.findViewById(R.id.park_mail);
        TextView visitingTV = convertView.findViewById(R.id.park_visiting_hours);
        ImageView imgIV = convertView.findViewById(R.id.park_image);

        nameTV.setText(currentPark.getmName());
        addressTV.setText(currentPark.getmAddress());
        if(!currentPark.getmPhone().equals("")){
            phoneTV.setText(currentPark.getmPhone());
        } else {
            phoneTV.setText(getContext().getString(R.string.no_phone));
        }
        if(!currentPark.getmWeb().equals("")){
            webTV.setText(currentPark.getmWeb());
        } else {
            webTV.setText(getContext().getString(R.string.no_web));
        }
        if(!currentPark.getmEmail().equals("")){
            emailTV.setText(currentPark.getmEmail());
        } else {
            emailTV.setText(getContext().getString(R.string.no_mail));
        }
        if(!currentPark.getmHours().equals("")){
            visitingTV.setText(currentPark.getmHours());
        } else {
            visitingTV.setText(getContext().getString(R.string.no_hours));
        }
        if(currentPark.hasImage()){
            imgIV.setImageResource(currentPark.getmImageResourceId());
        } else {
            imgIV.setImageResource(R.drawable.default_image_thumb);
        }

        return convertView;
    }
}