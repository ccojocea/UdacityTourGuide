package com.example.ccojo.clujtourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ccojo on 4/21/2018.
 */

class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_2);
        } else if (position == 1) {
            return mContext.getString(R.string.category_1);
        } else if (position == 2) {
            return mContext.getString(R.string.category_3);
        } else {
            return mContext.getString(R.string.category_4);
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new TourFragment();
            case 3:
                return new ParkFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
