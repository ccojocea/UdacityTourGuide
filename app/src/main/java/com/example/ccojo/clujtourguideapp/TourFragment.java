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

public class TourFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        final ArrayList<Tour> tours = new ArrayList<>();
        //SString mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, String description, String departurePoint, String departureTime, int duration, String[] highlights, int mImageResourceId, double mLat, double mLong
        tours.add(new Tour("", "", "", "", "", "", "", "", "", 0, new String[]{""}, 0, 0.0, 0.0));
        tours.add(new Tour("", "", "", "", "", "", "", "", "", 0, new String[]{""}, 0, 0.0, 0.0));
        tours.add(new Tour("", "", "", "", "", "", "", "", "", 0, new String[]{""}, 0, 0.0, 0.0));
        //tours.add(new Tour("", "", "", "", "", "", "", "", "", 0, new String[]{""}, 0, 0.0, 0.0));

        TourAdapter adapter = new TourAdapter(getContext(), tours);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mTitle = tours.get(position).getmName();
                String mLat = String.valueOf(tours.get(position).getmLat());
                String mLong = String.valueOf(tours.get(position).getmLong());
                String geoUri = "http://maps.google.com/maps?q=loc:" + mLat + "," + mLong + " (" + mTitle + ")";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
