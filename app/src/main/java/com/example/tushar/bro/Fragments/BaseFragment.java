package com.example.tushar.bro.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Bus;

/**
 * Created by TUSHAR on 04-07-2017.
 */

public class BaseFragment extends Fragment {
    protected BroApplication broApplication;
    protected Bus bus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        broApplication=(BroApplication)getActivity().getApplication();
        bus=broApplication.getBus();
        bus.register(BaseFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(BaseFragment.this);
    }
}
