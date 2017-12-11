package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rrs27 on 2017-12-07.
 */

class Earthquake {

    public double magnitude;
    public String location;
    public long unixTime;
    public String url;

    private final String DEV = "RRS";
    private final String TAG = QueryUtils.class.getSimpleName() + " by " + DEV;
    private final String DATE_PATTERN_FOR_USER = "dd/MMM/yy";
    private final String TIME_PATTERN_FOR_USER = "hh:mm:ss aa";
    private static final String MAGNITUDE_PATTERN_FOR_USERS = "0.0";

    /**
     * Constructor of {@link Earthquake} class.
     *
     * @param magnitude - Size or how strong was the {@link Earthquake}
     * @param location -
     * @param unixTime
     * @param URL
     */
    public Earthquake(double magnitude, String location, long unixTime, String URL) {
        this.magnitude = magnitude;
        this.location = location;
        this.unixTime = unixTime;
        this.url = URL;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "magnitude=" + magnitude +
                ", location='" + location + '\'' +
                ", unixTime=" + unixTime +
                '}';
    }

    public String getDateTime() {
        return getDate() + " " + getTime();
    }

    public String getDate() {
        Date date = new Date(this.unixTime);
        SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN_FOR_USER);
        return df.format(date);
    }

    public String getTime() {
        Date date = new Date(this.unixTime);
        SimpleDateFormat df = new SimpleDateFormat(TIME_PATTERN_FOR_USER);
        return df.format(date);
    }

    public String getLocation(){
        int returnIndex = 0;
        String[] parts = this.location.split(",");
        if (parts.length>1){
            returnIndex = 1;
        }
        return parts[returnIndex].trim();
    }

    public String getLocationOffset(){
        String[] parts = this.location.split(",");
        String returnMe = (parts.length>1) ? parts[0]:"Near the";
        return returnMe.trim();
    }

    public String getMagnitude(){
        DecimalFormat df = new DecimalFormat(MAGNITUDE_PATTERN_FOR_USERS);
        return df.format(magnitude);
    }

}

