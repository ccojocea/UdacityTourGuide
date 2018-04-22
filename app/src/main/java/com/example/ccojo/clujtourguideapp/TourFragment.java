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
        //String mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, String description, String departurePoint, String departureTime, int duration, String[] highlights, int price, int mImageResourceId, int mFullImageResourceId, double mLat, double mLong
        tours.add(new Tour("Day-trip to Turda Salt Mine and Alba Carolina Fortress from Cluj-Napoca", "Turda Salt Mine", "+40317800236", "https://rolandia.eu/", "", "", "Delve into the coolest underground theme park in the world and visit the star-shaped Alba Carolina Fortress in a one-day trip from Cluj-Napoca.", "We will pick you up from your hotel, or from your requested location", "9:00 AM", 10, new String[]{"Pickup from a centrally located meeting point", "Family friendly", "Day trip(destination A to B)", "Perfect for all ages and skill level", "Informative, friendly and professional guide", "Comprehensive tour of the city"}, 262, R.drawable.tour_salina_thumb, R.drawable.tour_salina, 46.587744, 23.787251));
        tours.add(new Tour("Maramures 2-Day Cultural Experience", "Maramures", "+40317800236", "https://rolandia.eu/", "", "", "Discover a land of unspoiled forests, warm hospitality, and ancient family traditions on an overnight tour of Maramures, a region where old Romanian ways of life still thrive. Combine the best of northern Romania’s nature and culture as you visit distinctive hand-carved wooden churches and old cemeteries, pass through pristine woodlands where brown bears roam, and join in local craft and social customs. Try regional cuisine with several included meals, and spend the night in a typical inn for an authentic, immersive experience.", "Cluj-Napoca", "9:00 AM", 48, new String[]{"2-day tour of the Maramures region from Cluj-Napoca", "Learn about the history and traditions of one of Romania's best-preserved regions", "Visit the carved wooden churches of Breb", "Watch local artisans practice wood carving and other crafts", "See natural whirlpools and untouched forests", "Enjoy a breakfast, lunch and dinner of typical regional cuisine", "Includes overnight accommodation"}, 684, R.drawable.tour_maramures_thumb, R.drawable.tour_maramures, 47.673320, 23.743921));
        tours.add(new Tour("", "", "", "", "", "", "", "", "", -1, new String[]{""}, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));
        tours.add(new Tour("", "", "", "", "", "", "", "", "", -1, new String[]{""}, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));
        tours.add(new Tour("", "", "", "", "", "", "", "", "", -1, new String[]{""}, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));
        //tours.add(new Tour("", "", "", "", "", "", "", "", "", -1, new String[]{""}, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));

        TourAdapter adapter = new TourAdapter(getContext(), tours);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String mTitle = tours.get(position).getmName();
//                String mLat = String.valueOf(tours.get(position).getmLat());
//                String mLong = String.valueOf(tours.get(position).getmLong());
//                String geoUri = "http://maps.google.com/maps?q=loc:" + mLat + "," + mLong + " (" + mTitle + ")";
//
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
//                getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}
