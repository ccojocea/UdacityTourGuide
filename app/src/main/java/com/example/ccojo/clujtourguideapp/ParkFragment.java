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
 * Created by ccojo on 4/22/2018.
 */

public class ParkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        final ArrayList<Park> parks = new ArrayList<>();
        //String mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, int mImageResourceId, double mLat, double mLong
        parks.add(new Park("Simion Bărnuțiu Central Park", "Cardinal Hossu Iuliu Street", "+40720425741", "http://www.primariaclujnapoca.ro/", "", "Open 24 hours", R.drawable.park_central_thumb, 46.768578, 23.578762));
        parks.add(new Park("", "", "", "", "", "", Park.NOIMAGE, 0.0, 0.0));
        parks.add(new Park("", "", "", "", "", "", Park.NOIMAGE, 0.0, 0.0));
        parks.add(new Park("", "", "", "", "", "", Park.NOIMAGE, 0.0, 0.0));
        parks.add(new Park("", "", "", "", "", "", Park.NOIMAGE, 0.0, 0.0));
        //parks.add(new Park("", "", "", "", "", "", 0, 0.0, 0.0));

        ParkAdapter adapter = new ParkAdapter(getContext(), parks);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String mTitle = parks.get(position).getmName();
//                String mLat = String.valueOf(parks.get(position).getmLat());
//                String mLong = String.valueOf(parks.get(position).getmLong());
//                String geoUri = "http://maps.google.com/maps?q=loc:" + mLat + "," + mLong + " (" + mTitle + ")";
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
//                getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
