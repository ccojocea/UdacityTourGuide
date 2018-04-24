package com.example.ccojo.clujtourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ccojo on 4/21/2018.
 */

public class RestaurantFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        String[] restaurantNames = getResources().getStringArray(R.array.restaurant_names);
        String[] restaurantAddresses = getResources().getStringArray(R.array.restaurant_addresses);
        String[] restaurantPhones = getResources().getStringArray(R.array.restaurant_phones);
        String[] restaurantHours = getResources().getStringArray(R.array.restaurant_hours);
        String[] restaurantType1 = getResources().getStringArray(R.array.restaurant_details_1);
        String[] restaurantType2 = getResources().getStringArray(R.array.restaurant_details_2);
        String[] restaurantType3 = getResources().getStringArray(R.array.restaurant_details_3);
        String[] restaurantType4 = getResources().getStringArray(R.array.restaurant_details_4);
        String[] restaurantType5 = getResources().getStringArray(R.array.restaurant_details_5);
        String[] restaurantType6 = getResources().getStringArray(R.array.restaurant_details_6);
        String[] restaurantType7 = getResources().getStringArray(R.array.restaurant_details_7);
        String[] restaurantType8 = getResources().getStringArray(R.array.restaurant_details_8);
        String[] restaurantType9 = getResources().getStringArray(R.array.restaurant_details_9);
        String[] restaurantType10 = getResources().getStringArray(R.array.restaurant_details_10);

        final ArrayList<Restaurant> restaurants = new ArrayList<>();
        //String name, String address, String phone, String[] type, String program, Double mLat, Double mLong
        restaurants.add(new Restaurant(restaurantNames[0], restaurantAddresses[0], restaurantPhones[0], restaurantType1, restaurantHours[0], 46.764392, 23.576002));
        restaurants.add(new Restaurant(restaurantNames[1], restaurantAddresses[1], restaurantPhones[1], restaurantType2, restaurantHours[1], 46.768147, 23.590250));
        restaurants.add(new Restaurant(restaurantNames[2], restaurantAddresses[2], restaurantPhones[2], restaurantType3, restaurantHours[2], 46.763201, 23.583913));
        restaurants.add(new Restaurant(restaurantNames[3], restaurantAddresses[3], restaurantPhones[3], restaurantType4, restaurantHours[3], 46.775043, 23.586344));
        restaurants.add(new Restaurant(restaurantNames[4], restaurantAddresses[4], restaurantPhones[4], restaurantType5, restaurantHours[4], 46.769817, 23.591758));
        restaurants.add(new Restaurant(restaurantNames[5], restaurantAddresses[5], restaurantPhones[5], restaurantType6, restaurantHours[5], 46.771390, 23.587856));
        restaurants.add(new Restaurant(restaurantNames[6], restaurantAddresses[6], restaurantPhones[6], restaurantType7, restaurantHours[6], 46.772296, 23.589035));
        restaurants.add(new Restaurant(restaurantNames[7], restaurantAddresses[7], restaurantPhones[7], restaurantType8, restaurantHours[7], 46.771363, 23.584608));
        restaurants.add(new Restaurant(restaurantNames[8], restaurantAddresses[8], restaurantPhones[8], restaurantType9, restaurantHours[8], 46.771834, 23.587257));
        restaurants.add(new Restaurant(restaurantNames[9], restaurantAddresses[9], restaurantPhones[9], restaurantType10, restaurantHours[9], 46.771001, 23.587780));

        RestaurantAdapter adapter = new RestaurantAdapter(getActivity(), restaurants);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mTitle = restaurants.get(position).getmName();
                String mLat = restaurants.get(position).getmLat();
                String mLong = restaurants.get(position).getmLong();
                String geoUri = "http://maps.google.com/maps?q=loc:" + mLat + "," + mLong + " (" + mTitle + ")";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
