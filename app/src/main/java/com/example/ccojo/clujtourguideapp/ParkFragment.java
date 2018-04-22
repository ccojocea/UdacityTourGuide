package com.example.ccojo.clujtourguideapp;

import android.content.Context;
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
 * Created by ccojo on 4/22/2018.
 */

public class ParkFragment extends Fragment {
    static ArrayList<Park> parks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        parks = new ArrayList<>();
        parks.add(new Park("Central Park", "Simion Bărnuțiu Central Park", "Cardinal Hossu Iuliu Street", "+40720425741", "http://www.primariaclujnapoca.ro/", "", "Open 24 hours", R.drawable.park_central_thumb, R.drawable.park_central,46.768578, 23.578762));
        parks.add(new Park("Botanical Garden", "Alexandru Borza Botanical Garden", "42 Republicii Street", "+40264592152", "", "gradina.botanica@ubbcluj.ro", "09:00 - 20:00\nGlass Houses: 09:00 - 18:00", R.drawable.park_botanical_thumb, R.drawable.park_botanical, 46.762585, 23.588517));
        parks.add(new Park("Turda Gorge", "Turda Gorge National Reserve", "DJ 107l - 6 Km west of Turda", "", "", "", "Mon-Sun: 09:00 - 20:00", R.drawable.park_turda_thumb, R.drawable.park_turda, 46.561955, 23.689140));
        //parks.add(new Park("", "", "", "", "", "", "", Park.NOIMAGE, Park.NOIMAGE, 0.0, 0.0));

        ParkAdapter adapter = new ParkAdapter(getContext(), parks);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra("PARK", parks.get(position));
                context.startActivity(intent);
            }
        });

        return rootView;
    }
}
