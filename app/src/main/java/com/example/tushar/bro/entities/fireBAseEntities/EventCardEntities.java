package com.example.tushar.bro.entities.fireBAseEntities;

/**
 * Created by TUSHAR on 29-07-2017.
 */

public class EventCardEntities {

    private String eventName;
    private String desc;
    private String image;
    private String youtube;
    private Boolean isvideo;
    private EventCardEntities(){


    }

    public String getEventName() {
        return eventName;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public String getYoutube() {
        return youtube;
    }

    public Boolean getIsvideo() {
        return isvideo;
    }
}
