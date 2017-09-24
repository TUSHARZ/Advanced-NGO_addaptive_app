package com.example.tushar.bro.Services;

import com.example.tushar.bro.entities.EventPictures;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 09-07-2017.
 */

public class EventPicturesService {
    public EventPicturesService() {


    }

    public static class searchCommunityPictureRequest{
        public String fireBaseUrl;

        public searchCommunityPictureRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class searchCommunityPictureResponse{
        public ArrayList<EventPictures> communityPicturerResponse;
    }

    public static class searchBrotherhoodPictureRequest{
        public String fireBaseUrl;

        public searchBrotherhoodPictureRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class searchBrotherhoodPictureResponse{
        public ArrayList<EventPictures> brotherHoodPictureResponse;
    }


    public static class searchSocialPictureRequest{
       public  String fireBaseUrl;

        public searchSocialPictureRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class searchSocialPictureResponse{
        public ArrayList<EventPictures> socialPictureResponse;
    }





}
