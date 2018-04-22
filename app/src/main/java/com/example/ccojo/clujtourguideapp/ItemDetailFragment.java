package com.example.ccojo.clujtourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is contained in a {@link CategoryActivity}
 */
public class ItemDetailFragment extends Fragment {
    private Item mItem;
    private CollapsingToolbarLayout appBarLayout;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey("PARK")){
            mItem = (Park) getArguments().getSerializable("PARK");
        }
        if(getArguments().containsKey("TOUR")){
            mItem = (Tour) getArguments().getSerializable("TOUR");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        appBarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);

        if (appBarLayout != null) {
            if(mItem.getClass() == Park.class){
                appBarLayout.setTitle(getString(R.string.park_detail));
            }
            if(mItem.getClass() == Tour.class){
                appBarLayout.setTitle(getString(R.string.tour_detail));
            }
        }

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail_text)).setText(mItem.getmName());
        }

        return rootView;
    }


}
