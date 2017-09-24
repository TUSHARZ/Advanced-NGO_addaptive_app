package com.example.tushar.bro.Services;

import com.example.tushar.bro.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class EventCardService  {


    public EventCardService() {

    }

    public static class searchCommunityEventCardRequest {
        public String firebaseUrl;

        public searchCommunityEventCardRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }

        public static class searchCommunityEventCardResponse{
          public   ArrayList<EventCard> communityeventResponse;


        }

        public static class searchSocialEventCardRequest {
            public String firebaseUrl;

            public searchSocialEventCardRequest(String firebaseUrl) {
                this.firebaseUrl = firebaseUrl;
            }
        }
            public static class searchSocialEventCardResponse{
               public  ArrayList<EventCard> SocialeventRespnse;


            }


            public static class searchBrotherhoodEventCardRequest {
                public String firebaseUrl;

                public searchBrotherhoodEventCardRequest(String firebaseUrl) {
                    this.firebaseUrl = firebaseUrl;
                }
            }
                public static class searchBrotherhoodEventCardResponse{
                   public ArrayList<EventCard> brotherHoodeventRespnse;

                }

}








