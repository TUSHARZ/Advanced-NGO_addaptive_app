package com.example.tushar.bro.entities;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class EventCard {
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    private String youtubeEnding;
    private Boolean isVideo;

    public EventCard(int eventId, String eventName, String eventDescription, String eventImage, String youtubeEnding, Boolean isVideo) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventImage = eventImage;
        this.youtubeEnding = youtubeEnding;
        this.isVideo = isVideo;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventImage() {
        return eventImage;
    }

    public String getYoutubeEnding() {
        return youtubeEnding;
    }

    public Boolean getIsVideo() {
        return isVideo;
    }





}
