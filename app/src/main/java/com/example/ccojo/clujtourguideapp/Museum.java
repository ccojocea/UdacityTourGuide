package com.example.ccojo.clujtourguideapp;

/**
 * Created by ccojo on 4/21/2018.
 */

class Museum {
    private String mName;
    private String mAddress;
    private String mPhone;
    private String mWeb;
    private String mEMail;
    private String mVisitingHours;
    private int mImageId = NOIMAGE;
    private double mLat;
    private double mLong;
    private static final int NOIMAGE = -1;

    public Museum(String name, String address, String phone, String web, String email, String mVisitingHours, int image, double lat, double lon) {
        this.mName = name;
        this.mAddress = address;
        this.mPhone = phone;
        this.mWeb = web;
        this.mEMail = email;
        this.mVisitingHours = mVisitingHours;
        this.mImageId = image;
        this.mLat = lat;
        this.mLong = lon;
    }

    public Museum(String name, String address, String phone, String web, String email, String mVisitingHours, double lat, double lon) {
        this.mName = name;
        this.mAddress = address;
        this.mPhone = phone;
        this.mWeb = web;
        this.mEMail = email;
        this.mVisitingHours = mVisitingHours;
        this.mLat = lat;
        this.mLong = lon;
    }

    public boolean hasImage() {
        return mImageId != NOIMAGE;
    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmWeb() {
        return mWeb;
    }

    public String getmEMail() {
        return mEMail;
    }

    public String getmVisitingHours() {
        return mVisitingHours;
    }

    public int getmImageId() {
        return mImageId;
    }

    public double getmLat() {
        return mLat;
    }

    public double getmLong() {
        return mLong;
    }
}
