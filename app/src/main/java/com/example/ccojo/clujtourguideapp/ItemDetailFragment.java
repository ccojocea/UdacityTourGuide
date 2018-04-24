package com.example.ccojo.clujtourguideapp;

import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

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

        appBarLayout = getActivity().findViewById(R.id.toolbar_layout);

        if (appBarLayout != null) {
            appBarLayout.setTitle(mItem.getmShortName());
        }

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_name_textview)).setText(mItem.getmName());
            if(!mItem.getmAddress().equals("")){
                ((TextView) rootView.findViewById(R.id.item_address)).setText(mItem.getmAddress());
            }
            if(!mItem.getmWeb().equals("")){
                ((TextView) rootView.findViewById(R.id.item_web)).setText(mItem.getmWeb());
            }
            if(!mItem.getmEmail().equals("")){
                ((TextView) rootView.findViewById(R.id.item_mail)).setText(mItem.getmEmail());
            }
            if(!mItem.getmPhone().equals("")){
                ((TextView) rootView.findViewById(R.id.item_phone)).setText(mItem.getmPhone());
            }
            if(!mItem.getmHours().equals("")){
                ((TextView) rootView.findViewById(R.id.item_visiting_hours)).setText(mItem.getmHours());
            }

            if(mItem.getClass() == Tour.class){
                RelativeLayout containerRL = rootView.findViewById(R.id.container_relative);
                containerRL.setVisibility(View.VISIBLE);

                if(!mItem.getmDescription().equals("")){
                    TextView descriptionTV = rootView.findViewById(R.id.item_description);
                    descriptionTV.setText(mItem.getmDescription());
                }
                if(mItem.getmPrice() != -1){
                    ((TextView) rootView.findViewById(R.id.item_price)).setText(String.valueOf(mItem.getmPrice()) + " " + Currency.getInstance(Locale.getDefault()).getSymbol());
                }
                if(!mItem.getmDeparturePoint().equals("")){
                    ((TextView) rootView.findViewById(R.id.item_depart_point)).setText(mItem.getmDeparturePoint());
                }
                if(!mItem.getmDepartureTime().equals("")){
                    ((TextView) rootView.findViewById(R.id.item_depart_time)).setText(mItem.getmDepartureTime());
                }
                if(mItem.getmDuration() != -1){
                    ((TextView) rootView.findViewById(R.id.item_duration)).setText(String.valueOf(mItem.getmDuration()) + " hours");
                }
                if(mItem.getmHighlights() != null){
                    String displayTXT = "";
                    for(String str : mItem.getmHighlights()){
                        displayTXT += str + "\n";
                    }
                    ((TextView) rootView.findViewById(R.id.item_highlights)).setText(displayTXT);
                }
            }

            //((TextView) rootView.findViewById(R.id.)).setText(mItem.);
            if(mItem.hasFullSizeImage()){
                ((ImageView) rootView.findViewById(R.id.image_view)).setImageResource(mItem.getmFullImageResourceId());
            } else {
                rootView.findViewById(R.id.image_view).setVisibility(View.GONE);
            }
        }

        return rootView;
    }


}
