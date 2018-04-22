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
import java.util.List;

/**
 * Created by ccojo on 4/22/2018.
 */

public class TourAdapter extends ArrayAdapter<Tour> {
    public TourAdapter(@NonNull Context context, @NonNull ArrayList<Tour> tours) {
        super(context, 0, tours);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Tour currentTour = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tour_list_item, parent,false);
        }

        TextView nameTV = convertView.findViewById(R.id.tour_name);
        TextView addressTV = convertView.findViewById(R.id.tour_address);
        TextView phoneTV = convertView.findViewById(R.id.tour_phone);
        TextView webTV = convertView.findViewById(R.id.tour_web);
        TextView emailTV = convertView.findViewById(R.id.tour_mail);
        TextView visitingTV = convertView.findViewById(R.id.tour_visiting_hours);
        ImageView imgIV = convertView.findViewById(R.id.tour_image);

        nameTV.setText(currentTour.getmName());
        addressTV.setText(currentTour.getmAddress());
        if(!currentTour.getmPhone().equals("")){
            phoneTV.setText(currentTour.getmPhone());
        }
        if(!currentTour.getmWeb().equals("")){
            webTV.setText(currentTour.getmWeb());
        }
        if(!currentTour.getmEmail().equals("")){
            emailTV.setText(currentTour.getmEmail());
        }
        if(!currentTour.getmHours().equals("")){
            visitingTV.setText(currentTour.getmHours());
        }
        if (currentTour.hasImage()) {
            imgIV.setImageResource(currentTour.getmImageResourceId());
        } else {
            imgIV.setImageResource(R.drawable.default_image_thumb);
        }

        return convertView;
    }
}
