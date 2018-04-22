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

        final ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        //String name, String address, String phone, String[] type, String program, Double mLat, Double mLong
        restaurants.add(new Restaurant("Indigo", "10-12 Piezisa Street", "+40364142306", new String[]{"Indian", "Punjab region", "Tandoori & Curry"}, "Mon-Sun: 12:00 - 22:30", 46.764392, 23.576002));
        restaurants.add(new Restaurant("Da Pino", "8 Universitatii Street, 400091", "+40734881010", new String[]{"Italian", "Mediterranean", "European"}, "Mon-Sun: 8:00 - 23:00", 46.768147, 23.590250));
        restaurants.add(new Restaurant("Tokyo Japanese Restaurant", "5 Gh Marinescu Street", "+40759020024", new String[]{"Japanese", "Sushi", "Asian"}, "Mon-Sun: 12:00 - 23:00", 46.763201, 23.583913));
        restaurants.add(new Restaurant("Samsara Foodhouse", "5 Stephan Ludwig Roth Street", "+40799073073", new String[]{"European", "International", "Vegetarian Friendly"}, "Mon-Sun: 11:00 - 23:00", 46.775043, 23.586344));
        restaurants.add(new Restaurant("Cabinet du Vin & Cocotte", "5 Eroilor Blvd", "+40264590200", new String[]{"International", "European", "Vegetarian Friendly"}, "Mon-Sun: 12:00 - 23:00", 46.769817, 23.591758));
        restaurants.add(new Restaurant("O'Peter's Irish Pub & Grill", "4 Goldis Vasile Street", "+40726738377", new String[]{"Irish", "Bar", "Pub"}, "Mon-Sun: 10:00 - 02:00", 46.771390, 23.587856));
        restaurants.add(new Restaurant("A Camponeza", "2 Emile Zola Street", "+40734047713", new String[]{"Seafood", "Mediterranean", "Barbecue"}, "Mon-Sat: 19:00 - 23:00", 46.772296, 23.589035));
        restaurants.add(new Restaurant("Jaxx", "Isac Emil Street", "+40756136953", new String[]{"American", "Mexican", "Bar"}, "Mon-Fri: 08:00 - 24:00\nSat-Sun: 12:00 - 24:00", 46.771363, 23.584608));
        restaurants.add(new Restaurant("Sax Speakeasy Wine Bar", "1 Piata Muzeului", "+40736095750", new String[]{"Wine Bar", "European"}, "Tuesday: 18:00 - 23:45\nWed-Sat: 18:00 - 01:00", 46.771834, 23.587257));
        restaurants.add(new Restaurant("Matei Corvin", "3 Matei Corvin Street", "+40264597496", new String[]{"European", "Eastern European", "Central European"}, "Mon-Sat: 12:00 - 23:00", 46.771001, 23.587780));

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
