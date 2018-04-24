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
 * Created by ccojo on 4/21/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class TourFragment extends Fragment {
    private static ArrayList<Tour> tours;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        String[] tourShortNames = getResources().getStringArray(R.array.tour_short_names);
        String[] tourNames = getResources().getStringArray(R.array.tour_names);
        String[] tourAddresses = getResources().getStringArray(R.array.tour_addresses);
        String[] tourPhones = getResources().getStringArray(R.array.tour_phones);
        String[] tourWebs = getResources().getStringArray(R.array.tour_webs);
        String[] tourEmails = getResources().getStringArray(R.array.tour_emails);
        String[] tourDescriptions = getResources().getStringArray(R.array.tour_descriptions);
        String[] tourDepPoints = getResources().getStringArray(R.array.tour_departure_points);
        String[] tourDepTimes = getResources().getStringArray(R.array.tour_departure_times);
        String[] tourHighlights1 = getResources().getStringArray(R.array.tour_highlights_1);
        String[] tourHighlights2 = getResources().getStringArray(R.array.tour_highlights_2);
        String[] tourHighlights3 = getResources().getStringArray(R.array.tour_highlights_3);
        String[] tourHighlights4 = getResources().getStringArray(R.array.tour_highlights_4);

        tours = new ArrayList<>();
        //String shortName, String mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, String description, String departurePoint, String departureTime, int duration, String[] highlights, int price, int mImageResourceId, int mFullImageResourceId, double mLat, double mLong
        //tours.add(new Tour("", "", "", "", "", "", "", "", "", "", -1, null, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));
        tours.add(new Tour(tourShortNames[0], tourNames[0], tourAddresses[0], tourPhones[0], tourWebs[0], tourEmails[0], "", tourDescriptions[0], tourDepPoints[0], tourDepTimes[0], 10, tourHighlights1, 262, R.drawable.tour_salina_thumb, R.drawable.tour_salina, 46.587744, 23.787251));
        tours.add(new Tour(tourShortNames[1], tourNames[1], tourAddresses[1], tourPhones[1], tourWebs[1], tourEmails[1], "", tourDescriptions[1], tourDepPoints[1], tourDepTimes[1], 48, tourHighlights2, 684, R.drawable.tour_maramures_thumb, R.drawable.tour_maramures, 47.673320, 23.743921));
        tours.add(new Tour(tourShortNames[2], tourNames[2], tourAddresses[2], tourPhones[2], tourWebs[2], tourEmails[2], "", tourDescriptions[2], tourDepPoints[2], tourDepTimes[2], 5, tourHighlights3, 72, R.drawable.tour_cluj_thumb, R.drawable.tour_cluj, 46.7712, 23.6236));
        tours.add(new Tour(tourShortNames[3], tourNames[3], tourAddresses[3], tourPhones[3], tourWebs[3], tourEmails[3], "", tourDescriptions[3], tourDepPoints[3], tourDepTimes[3], 4, tourHighlights4, -1, R.drawable.tour_active_weekends_thumb, Tour.NOIMAGE, 0.0, 0.0));
        tours.add(new Tour(tourShortNames[4], tourNames[4], tourAddresses[4], tourPhones[4], tourWebs[4], tourEmails[4], "", tourDescriptions[4], tourDepPoints[4], tourDepTimes[4], 3, null, -1, Tour.NOIMAGE, Tour.NOIMAGE, 0.0, 0.0));

        @SuppressWarnings("ConstantConditions") TourAdapter adapter = new TourAdapter(getContext(), tours);
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra("TOUR", tours.get(position));
                context.startActivity(intent);
            }
        });

        return rootView;
    }
}
