package com.example.tushar.bro.entities.fireBAseEntities;

/**
 * Created by TUSHAR on 29-07-2017.
 */

public class RushEntities {
    private String name;
    private String date;
    private String time;
    private String location;
    private double latitiude;
    private double longitude;
    private Boolean isOnCampus;
    private String desc;


    private RushEntities(){


    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public Double getlatitiude() {
        return latitiude;
    }

    public Double getlongitude() {
        return longitude;
    }

    public Boolean getOnCampus() {
        return isOnCampus;
    }

    public String getDesc() {
        return desc;
    }
}
