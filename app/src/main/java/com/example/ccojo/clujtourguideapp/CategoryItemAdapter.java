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

public class CategoryItemAdapter extends ArrayAdapter<CategoryItem> {

    //TODO DELETE THIS FILE

    public CategoryItemAdapter(@NonNull Context context, @NonNull ArrayList<CategoryItem> CategoryItems) {
        super(context, 0, CategoryItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CategoryItem currentCategoryItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_list_item, parent, false);
        }

        TextView nameTV = convertView.findViewById(R.id.category_item_name);
        TextView addressTV = convertView.findViewById(R.id.category_item_address);
        TextView phoneTV = convertView.findViewById(R.id.category_item_phone);
        TextView webTV = convertView.findViewById(R.id.category_item_web);
        TextView emailTV = convertView.findViewById(R.id.category_item_mail);
        TextView visitingTV = convertView.findViewById(R.id.category_item_visiting_hours);
        ImageView imgIV = convertView.findViewById(R.id.category_item_image);

        nameTV.setText(currentCategoryItem.getmName());
        addressTV.setText(currentCategoryItem.getmAddress());
        if(!currentCategoryItem.getmPhone().equals("")){
            phoneTV.setText(currentCategoryItem.getmPhone());
        }
        if(!currentCategoryItem.getmWeb().equals("")){
            webTV.setText(currentCategoryItem.getmWeb());
        }
        if(!currentCategoryItem.getmEmail().equals("")){
            emailTV.setText(currentCategoryItem.getmEmail());
        }
        if(!currentCategoryItem.getmHours().equals("")){
            visitingTV.setText(currentCategoryItem.getmHours());
        }
        if (currentCategoryItem.hasImage()) {
            imgIV.setImageResource(currentCategoryItem.getmImageResourceId());
        } else {
            imgIV.setImageResource(R.drawable.default_image_thumb);
        }

        return convertView;
    }
}
