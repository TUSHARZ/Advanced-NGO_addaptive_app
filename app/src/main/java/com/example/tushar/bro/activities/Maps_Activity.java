package com.example.tushar.bro.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 11-07-2017.
 */

public class Maps_Activity extends BaseActivity {
    private GoogleMap map;
    private GoogleApiClient api;
    private RushEvent event;
    private static final String RUSH_MAP_INFO="RUSH_MAP_INFO";
    @BindView(R.id.map_name)
    TextView name;
    @BindView(R.id.mapdate)
    TextView date;
    @BindView(R.id.map_location)
    TextView location;
    @BindView(R.id.map_description)
    TextView descrition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        ButterKnife.bind(this);
        event=getIntent().getParcelableExtra(RUSH_MAP_INFO);
        name.setText(event.getEventName());
        date.setText(event.getEventDate());
        location.setText(event.getEventDate());
        descrition.setText(event.getEventDescription());
        api=new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
            @Override
            public void onConnected(@Nullable Bundle bundle) {
                getloc();
            }

            @Override
            public void onConnectionSuspended(int i) {

            }
        }).build();

        SupportMapFragment supportMapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.activity_maps);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        api.connect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(api.isConnected()){
            getloc();
        }
    }

    public void getloc(){
        LatLng rushpoint=new LatLng(event.getEventLatitude(),event.getEventLongitude());
        MarkerOptions rushmarker=new MarkerOptions().position(rushpoint).
                title("EVENT").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        map.clear();
        map.addMarker(rushmarker);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(rushpoint,15));






    }

    public static Intent getIntent(Context context,RushEvent event){
        Intent intent=new Intent(context,Maps_Activity.class);
        intent.putExtra(RUSH_MAP_INFO,event);
        return intent;
    }
}
