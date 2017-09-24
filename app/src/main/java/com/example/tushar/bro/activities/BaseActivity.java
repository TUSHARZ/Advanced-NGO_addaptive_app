package com.example.tushar.bro.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Bus;


public class BaseActivity extends AppCompatActivity {
    protected BroApplication broApplication;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        broApplication=(BroApplication)getApplication();
        bus=broApplication.getBus();
        bus.register(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}



