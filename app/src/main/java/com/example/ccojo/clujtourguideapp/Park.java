package com.example.ccojo.clujtourguideapp;

import java.io.Serializable;

/**
 * Created by ccojo on 4/22/2018.
 */

public class Park extends Item implements Serializable{
    private String mShortName;
    private String mName;
    private String mAddress;
    private String mWeb;
    private String mEmail;
    private String mPhone;
    private String mHours;
    private double mLat;
    private double mLong;
    private int mImageResourceId = NOIMAGE;
    private int mFullImageResourceId = NOIMAGE;
    public static final int NOIMAGE = -1;

    public Park(String shortName, String mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, int mImageResourceId, int mFullImageResourceId,double mLat, double mLong) {
        this.mShortName = shortName;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mWeb = mWeb;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
        this.mHours = mHours;
        this.mLat = mLat;
        this.mLong = mLong;
        this.mImageResourceId = mImageResourceId;
        this.mFullImageResourceId = mFullImageResourceId;
    }

    public String getmShortName() {
        return mShortName;
    }

    @Override
    public int getmFullImageResourceId() {
        return mFullImageResourceId;
    }

    public boolean hasFullSizeImage() {
        return mFullImageResourceId != NOIMAGE;
    }

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

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NOIMAGE;
    }
}
