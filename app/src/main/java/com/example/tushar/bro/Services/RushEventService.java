package com.example.tushar.bro.Services;


import com.example.tushar.bro.entities.RushEvent;

import java.util.ArrayList;

public class RushEventService {

    public static class SearchRushCommunityEventsRequest{
        public String fireBaseUrl;

        public SearchRushCommunityEventsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushCommunityResponse{
        public ArrayList<RushEvent> communityResponse;
    }


    public static class SearchRushSocialEventsRequest{
        public String fireBaseUrl;

        public SearchRushSocialEventsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushSocialResponse{
        public ArrayList<RushEvent> socialResponse;
    }


}
