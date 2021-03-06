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
 * Created by ccojo on 4/21/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
class MuseumAdapter extends ArrayAdapter<Museum> {

    public MuseumAdapter(@NonNull Context context, @NonNull ArrayList<Museum> museums) {
        super(context, 0, museums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Museum currentMuseum = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.museum_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.museum_name);
        TextView addressTV = convertView.findViewById(R.id.museum_address);
        TextView phoneTV = convertView.findViewById(R.id.museum_phone);
        TextView webTV = convertView.findViewById(R.id.museum_web);
        TextView emailTV = convertView.findViewById(R.id.museum_mail);
        TextView visitingTV = convertView.findViewById(R.id.museum_visiting_hours);
        ImageView imgIV = convertView.findViewById(R.id.museum_image);

        nameTV.setText(currentMuseum != null ? currentMuseum.getmName() : getContext().getString(R.string.unknown_name));
        addressTV.setText(currentMuseum != null ? currentMuseum.getmAddress() : getContext().getString(R.string.no_address));
        phoneTV.setText(currentMuseum != null ? currentMuseum.getmPhone() : getContext().getString(R.string.no_phone));
        if(!currentMuseum.getmWeb().equals("")){
            webTV.setText(currentMuseum.getmWeb());
        } else {
            webTV.setText(getContext().getString(R.string.no_web));
        }
        if(!currentMuseum.getmEMail().equals("")){
            emailTV.setText(currentMuseum.getmEMail());
        } else {
            emailTV.setText(getContext().getString(R.string.no_mail));
        }
        visitingTV.setText(currentMuseum.getmVisitingHours());
        if (currentMuseum.hasImage()) {
            //imgIV.setVisibility(View.VISIBLE);
            imgIV.setImageResource(currentMuseum.getmImageId());
        } else {
            //imgIV.setVisibility(View.GONE);
            imgIV.setImageResource(R.drawable.default_image_thumb);
        }

        return convertView;
    }
}
