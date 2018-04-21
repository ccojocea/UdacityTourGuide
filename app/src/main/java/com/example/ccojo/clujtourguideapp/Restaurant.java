package com.example.ccojo.clujtourguideapp;

/**
 * Created by ccojo on 4/21/2018.
 */

public class Restaurant {
    //TODO: ADD GEOLOCATION INFO TO OPEN GOOGLE MAPS TO RESTAURANT LOCATION

    private String mName;
    private String mAddress;
    private String mPhone;
    private String[] mType;
    private String mProgram;
    private Double mLat;
    private Double mLong;

    public Restaurant(String name, String address, String phone, String[] type, String program, Double mLat, Double mLong){
        this.mName = name;
        this.mAddress = address;
        this.mPhone = phone;
        this.mType = type;
        this.mProgram = program;
        this.mLat = mLat;
        this.mLong = mLong;
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

    public String[] getmType() {
        return mType;
    }

    public String getmProgram() {
        return mProgram;
    }

    public String getmLat() {
        return String.valueOf(mLat);
    }

    public String getmLong() {
        return String.valueOf(mLong);
    }
}