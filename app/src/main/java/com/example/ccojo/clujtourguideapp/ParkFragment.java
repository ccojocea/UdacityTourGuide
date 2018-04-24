package com.example.ccojo.clujtourguideapp;

import android.content.Context;
import android.content.Intent;
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

@SuppressWarnings("DefaultFileTemplate")
public class ParkFragment extends Fragment {
    private static ArrayList<Park> parks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        String[] parkShortNames = getResources().getStringArray(R.array.park_short_names);
        String[] parkNames = getResources().getStringArray(R.array.park_names);
        String[] parkAddresses = getResources().getStringArray(R.array.park_addresses);
        String[] parkPhones = getResources().getStringArray(R.array.park_phones);
        String[] parkWebs = getResources().getStringArray(R.array.park_webs);
        String[] parkEmails = getResources().getStringArray(R.array.park_emails);
        String[] parkHours = getResources().getStringArray(R.array.park_hours);
        parks = new ArrayList<>();
        parks.add(new Park(parkShortNames[0], parkNames[0], parkAddresses[0], parkPhones[0], parkWebs[0], parkEmails[0], parkHours[0], R.drawable.park_central_thumb, R.drawable.park_central,46.768578, 23.578762));
        parks.add(new Park(parkShortNames[1], parkNames[1], parkAddresses[1], parkPhones[1], parkWebs[1], parkEmails[1], parkHours[1], R.drawable.park_botanical_thumb, R.drawable.park_botanical, 46.762585, 23.588517));
        parks.add(new Park(parkShortNames[2], parkNames[2], parkAddresses[2], parkPhones[2], parkWebs[2], parkEmails[2], parkHours[2], R.drawable.park_turda_thumb, R.drawable.park_turda, 46.561955, 23.689140));

        @SuppressWarnings("ConstantConditions") ParkAdapter adapter = new ParkAdapter(getContext(), parks);
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
