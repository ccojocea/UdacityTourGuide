package com.example.ccojo.clujtourguideapp;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * An activity representing a single Book detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemDetailActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {
    private Item mItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);



        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Bundle arguments = new Bundle();
            arguments.putAll(getIntent().getExtras());
            //arguments.putString(ItemDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.item_detail_container, fragment).commit();
        }

        //noinspection ConstantConditions
        if(getIntent().getExtras().containsKey(Item.TOUR)){
            mItem = (Tour) getIntent().getExtras().getSerializable(Item.TOUR);
        }
        if(getIntent().getExtras().containsKey(Item.PARK)){
            mItem = (Park) getIntent().getExtras().getSerializable(Item.PARK);
        }



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.open_map), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.map), new MyMapListener()).show();
            }
        });

    }

    public class MyMapListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String mTitle = String.valueOf(mItem.getmName());
            String mLat = String.valueOf(mItem.getmLat());
            String mLong = String.valueOf(mItem.getmLong());
            String geoUri = getString(R.string.maps_google_com) + mLat + "," + mLong + " (" + mTitle + ")";
            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            getApplicationContext().startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, CategoryActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
