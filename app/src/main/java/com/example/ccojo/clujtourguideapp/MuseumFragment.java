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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ccojo on 4/21/2018.
 */

public class MuseumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        final ArrayList<Museum> museums = new ArrayList<>();
        //String name, String address, String phone, String web, String email, String mVisitingHours, int image, double lat, double lon
        museums.add(new Museum("Ethnographic Museum of Transylvania", "21 Memorandumului Street", "+40264592344", "http://www.muzeul-etnografic.ro/en", "contact@muzeul-etnografic.ro", "Wed-Sun: 10:00 - 18:00", R.drawable.museum_transylvanian_thumb, 46.769537, 23.586629));
        museums.add(new Museum("Ethnographic Park Romulus Vuia", "Ethnographic Museum Alley", "+40264592344", "http://www.muzeul-etnografic.ro/en", "contact@muzeul-etnografic.ro", "Wed-Sun: 10:00 - 18:00", R.drawable.museum_park_thumb, 46.778325, 23.553656));
        museums.add(new Museum("Bánffy Palace Art Museum", "30 Piata Unirii", "+40753066791", "https://www.macluj.ro", "info.muzeu@macluj.ro", "Wed-Sun: 10:00 - 17:00", R.drawable.museum_art_thumb, 46.770914, 23.590900));
        museums.add(new Museum("Astronomical Observatory", "19 Ciresilor Street", "+40264594592", "http://www.ubbcluj.ro/ro/structura/sport/observatorul_astronomic", "mirliviu@yahoo.com", "Friday Evening", R.drawable.museum_astro_thumb, 46.758123, 23.586617));
        museums.add(new Museum("Poarta de su' Feleac", "20 Soporului Street", "+40766529550", "http://poarta.weebly.com/", "ghita_capusan@gmail.com", "Mon-Sun: 09:00 - 18:00", R.drawable.museum_poarta_thumb, 46.753002, 23.662265));
        //museums.add(new Museum("", "", "", "", "", "", , 0.0, 0.0));

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
