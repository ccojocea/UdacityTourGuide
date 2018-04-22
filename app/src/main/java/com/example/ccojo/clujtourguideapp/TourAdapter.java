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
import java.util.Currency;
import java.util.Locale;

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

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tour_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.tour_name);
        TextView addressTV = convertView.findViewById(R.id.tour_address);
        TextView phoneTV = convertView.findViewById(R.id.tour_phone);
        TextView webTV = convertView.findViewById(R.id.tour_web);
        TextView emailTV = convertView.findViewById(R.id.tour_mail);
        TextView visitingTV = convertView.findViewById(R.id.tour_visiting_hours);
        ImageView imgIV = convertView.findViewById(R.id.tour_image);
        TextView priceTV = convertView.findViewById(R.id.tour_price);

        nameTV.setText(currentTour.getmName());

        if(!currentTour.getmAddress().equals("")){
            addressTV.setText(currentTour.getmAddress());
        } else {
            addressTV.setText(getContext().getString(R.string.no_address));
        }
        if (!currentTour.getmPhone().equals("")) {
            phoneTV.setText(currentTour.getmPhone());
        } else {
            phoneTV.setText(getContext().getString(R.string.no_phone));
        }
        if (!currentTour.getmWeb().equals("")) {
            webTV.setText(currentTour.getmWeb());
        } else {
            webTV.setText(getContext().getString(R.string.no_web));
        }
        if (!currentTour.getmEmail().equals("")) {
            emailTV.setText(currentTour.getmEmail());
        } else {
            emailTV.setText(getContext().getString(R.string.no_mail));
        }
        if (!currentTour.getmHours().equals("")) {
            visitingTV.setText(currentTour.getmHours());
        } else {
            visitingTV.setText(getContext().getString(R.string.no_hours));
        }
        if (currentTour.hasImage()) {
            imgIV.setImageResource(currentTour.getmImageResourceId());
        } else {
            imgIV.setImageResource(R.drawable.default_image_thumb);
        }
        //TODO: REFINE THIS FOR CURRENCY SYMBOL AND CONVERSION
        if (currentTour.getmPrice() != -1) {
            priceTV.setText(currentTour.getmPrice() + " " + Currency.getInstance(Locale.getDefault()).getSymbol());
        } else {
            priceTV.setText(getContext().getString(R.string.no_price));
        }

        return convertView;
    }
}
