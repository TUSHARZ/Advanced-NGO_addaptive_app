package com.example.tushar.bro.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.EventPictures;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 09-07-2017.
 */

public class EventPicturesfragment extends BaseFragment {
    @BindView(R.id.event_picture_image)
    ImageView image;
    @BindView(R.id.event_picture_progress)
    ProgressBar progressBar;
    public static final String EVENT_PIC="EVENT_PIC";
    public String photo;



    public static EventPicturesfragment newInstance(EventPictures picture){
        Bundle arguments =new Bundle();
        arguments.putString(EVENT_PIC,picture.getPictureUrl());
        EventPicturesfragment eventPicturesfragment=new EventPicturesfragment();
        eventPicturesfragment.setArguments(arguments);
        return eventPicturesfragment;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photo=getArguments().getString(EVENT_PIC);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_event_pictures, container, false);
        ButterKnife.bind(this, root);

        Picasso.with(EventPicturesfragment.this.getActivity()).load(photo).into(image, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
        return root;
    }

}
