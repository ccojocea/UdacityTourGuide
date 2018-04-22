package com.example.ccojo.clujtourguideapp;

/**
 * Created by ccojo on 4/22/2018.
 */

public class Tour {
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

    public Tour(String mName, String mAddress, String mPhone, String mWeb, String mEmail, String mHours, String description, String departurePoint, String departureTime, int duration, String[] highlights, int price, int mImageResourceId, int mFullImageResourceId, double mLat, double mLong) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mWeb = mWeb;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
        this.mHours = mHours;
        this.mLat = mLat;
        this.mLong = mLong;
        this.mImageResourceId = mImageResourceId;
        this.mDeparturePoint = departurePoint;
        this.mDescription = description;
        this.mDepartureTime = departureTime;
        this.mDuration = duration;
        this.mHighlights = highlights;
        this.mPrice = price;
        this.mFullImageResourceId = mFullImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NOIMAGE;
    }

    public boolean hasFullSizeImage(){
        return mFullImageResourceId != NOIMAGE;
    }

    public int getmPrice() {
        return mPrice;
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

    public String[] getmHighlights() {
        return mHighlights;
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
}
