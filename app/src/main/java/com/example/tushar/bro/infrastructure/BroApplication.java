package com.example.tushar.bro.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

import tushar.bro.live.Module;


public class BroApplication extends Application {
    private Bus bus;
    public static final String YOUTUBE_KEY="AIzaSyB84bSCfFtLOJV7YICDn3bqKpUhWjwCkRk";


    public BroApplication() {
        bus=new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
