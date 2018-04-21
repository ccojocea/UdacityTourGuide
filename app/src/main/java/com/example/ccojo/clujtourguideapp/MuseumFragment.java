package com.example.ccojo.clujtourguideapp;


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

        ArrayList<Museum> museums = new ArrayList<>();
        //String name, String address, String phone, String web, String email, String mVisitingHours, int image, double lat, double lon
        museums.add(new Museum("Ethnographic Museum of Transylvania", "21 Memorandumului Street", "+40264592344", "http://www.muzeul-etnografic.ro/en", "contact@muzeul-etnografic.ro", "Wed-Sun: 10:00 - 18:00", R.drawable.museum_transylvanian_thumb, 0.0, 0.0));
        museums.add(new Museum("Ethnographic Park Romulus Vuia", "Ethnographic Museum Alley", "+40264592344", "http://www.muzeul-etnografic.ro/en", "contact@muzeul-etnografic.ro", "Wed-Sun: 10:00 - 18:00", R.drawable.museum_park_thumb, 0.0, 0.0));
        museums.add(new Museum("Bánffy Palace Art Museum", "30 Piata Unirii", "+40753066791", "https://www.macluj.ro", "info.muzeu@macluj.ro", "Wed-Sun: 10:00 - 17:00", R.drawable.museum_art_thumb, 0.0, 0.0));
        museums.add(new Museum("Astronomic Observer", "19 Ciresilor Street", "+40264594592", "http://www.ubbcluj.ro/ro/structura/sport/observatorul_astronomic", "mirliviu@yahoo.com", "Friday Evening", R.drawable.museum_astro_thumb, 0.0, 0.0));
        museums.add(new Museum("Poarta de su' Feleac", "20 Soporului Street", "+40766529550", "http://poarta.weebly.com/", "ghita_capusan@gmail.com", "Mon-Sun: 09:00 - 18:00", R.drawable.museum_poarta_thumb, 0.0, 0.0));
        //museums.add(new Museum("", "", "", "", "", "", , 0.0, 0.0));

        MuseumAdapter adapter = new MuseumAdapter(getContext(), museums);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Not implemented", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}
