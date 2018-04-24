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

public class MuseumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        String[] museumNames = getResources().getStringArray(R.array.museum_names);
        String[] museumAddresses = getResources().getStringArray(R.array.museum_addresses);
        String[] museumPhones = getResources().getStringArray(R.array.museum_phones);
        String[] museumWebs = getResources().getStringArray(R.array.museum_webs);
        String[] museumEmails = getResources().getStringArray(R.array.museum_emails);
        String[] museumHours = getResources().getStringArray(R.array.museum_hours);

        final ArrayList<Museum> museums = new ArrayList<>();
        //String name, String address, String phone, String web, String email, String mVisitingHours, int image, double lat, double lon
        //museums.add(new Museum("", "", "", "", "", "", -1, 0.0, 0.0));
        museums.add(new Museum(museumNames[0], museumAddresses[0], museumPhones[0], museumWebs[0], museumEmails[0], museumHours[0], R.drawable.museum_transylvanian_thumb, 46.769537, 23.586629));
        museums.add(new Museum(museumNames[1], museumAddresses[1], museumPhones[1], museumWebs[1], museumEmails[1], museumHours[1], R.drawable.museum_park_thumb, 46.778325, 23.553656));
        museums.add(new Museum(museumNames[2], museumAddresses[2], museumPhones[2], museumWebs[2], museumEmails[2], museumHours[2], R.drawable.museum_art_thumb, 46.770914, 23.590900));
        museums.add(new Museum(museumNames[3], museumAddresses[3], museumPhones[3], museumWebs[3], museumEmails[3], museumHours[3], R.drawable.museum_astro_thumb, 46.758123, 23.586617));
        museums.add(new Museum(museumNames[4], museumAddresses[4], museumPhones[4], museumWebs[4], museumEmails[4], museumHours[4], R.drawable.museum_poarta_thumb, 46.753002, 23.662265));
        museums.add(new Museum(museumNames[5], museumAddresses[5], museumPhones[5], museumWebs[5], museumEmails[5], museumHours[5], R.drawable.museum_pharmacy_thumb, 46.771100, 23.589800));

        MuseumAdapter adapter = new MuseumAdapter(getContext(), museums);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mTitle = museums.get(position).getmName();
                String mLat = String.valueOf(museums.get(position).getmLat());
                String mLong = String.valueOf(museums.get(position).getmLong());
                String geoUri = "http://maps.google.com/maps?q=loc:" + mLat + "," + mLong + " (" + mTitle + ")";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
