package com.example.tushar.bro.Services;


import com.example.tushar.bro.entities.Brother;
import com.example.tushar.bro.infrastructure.BroApplication;

import java.util.List;

public class BrotherServices  {

    public BrotherServices(){

    }
    public static class searchBrotherRequest{
        public String fireBaseUrl;

        public searchBrotherRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    public static class searchBrotherResponse{
        public List<Brother> brothers;
    }
}
