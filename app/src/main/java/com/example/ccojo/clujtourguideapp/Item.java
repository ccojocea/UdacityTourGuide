package com.example.ccojo.clujtourguideapp;

import java.io.Serializable;

/**
 * Created by ccojo on 4/22/2018.
 */

public class Item implements Serializable{
    private String mShortName;
    private String mName;
    private String mAddress;
    private String mWeb;
    private String mEmail;
    private String mPhone;
    private String mHours;
    private double mLat;
    private double mLong;
    private String mDescription;
    private String mDeparturePoint;
    private String mDepartureTime;
    private int mDuration;
    private int mImageResourceId = NOIMAGE;
    public int mFullImageResourceId = NOIMAGE;
    private int mPrice;
    private String[] mHighlights;

    public static final int NOIMAGE = -1;

    public String getmShortName() {
        return mShortName;
    }

    public boolean hasImage(){return false;}
    public boolean hasFullSizeImage(){return false;}

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmWeb() {
        return mWeb;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmHours() {
        return mHours;
    }

    public double getmLat() {
        return mLat;
    }

    public double getmLong() {
        return mLong;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmDeparturePoint() {
        return mDeparturePoint;
    }

    public String getmDepartureTime() {
        return mDepartureTime;
    }

    public int getmDuration() {
        return mDuration;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmFullImageResourceId() {
        return mFullImageResourceId;
    }

    public int getmPrice() {
        return mPrice;
    }

    public String[] getmHighlights() {
        return mHighlights;
    }
}
