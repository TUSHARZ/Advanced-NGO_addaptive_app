package com.example.tushar.bro.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.example.tushar.bro.Fragments.EventPicturesfragment;
import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.EventCardService;
import com.example.tushar.bro.Services.EventPicturesService;
import com.example.tushar.bro.entities.EventCard;
import com.example.tushar.bro.entities.EventPictures;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 09-07-2017.
 */

public class photo_pager_activity extends BaseActivity {
    @BindView(R.id.photo_view_pager)
    ViewPager viewPager;

    private ArrayList<EventPictures> eventPictures;

    public static final String EXTRA_INFO="EXTRA_INFO";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);
        ButterKnife.bind(this);
        eventPictures=new ArrayList<>();

        int photoid=getIntent().getExtras().getInt(EXTRA_INFO);
        switch (photoid){
            case 1:
                bus.post(new EventPicturesService.searchCommunityPictureRequest("Hello"));

                break;
            case 3:
                bus.post(new EventPicturesService.searchBrotherhoodPictureRequest("Hello"));

                break;
            case 5:
                bus.post(new EventPicturesService.searchSocialPictureRequest("Hello"));

                break;
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPictures eventpic=eventPictures.get(position);
                return EventPicturesfragment.newInstance(eventpic);

            }

            @Override
            public int getCount() {
                return eventPictures.size();
            }
        });
    }

    public static Intent getIntent(Context context, EventCard card){
        Intent intent=new Intent(context,photo_pager_activity.class);
       intent.putExtra(EXTRA_INFO,card.getEventId());
        return intent;


    }

    @Subscribe
    public void getCommunityphotos(EventPicturesService.searchCommunityPictureResponse response){

        eventPictures.clear();
        eventPictures.addAll(response.communityPicturerResponse);
        viewPager.getAdapter().notifyDataSetChanged();

    }
    @Subscribe
    public void getBrotherhoodphotos(EventPicturesService.searchBrotherhoodPictureResponse response){
        eventPictures.clear();
        eventPictures.addAll(response.brotherHoodPictureResponse);
        viewPager.getAdapter().notifyDataSetChanged();

    }
    @Subscribe
    public void getSocialphotos(EventPicturesService.searchSocialPictureResponse response){
        eventPictures.clear();
        eventPictures.addAll(response.socialPictureResponse);
        viewPager.getAdapter().notifyDataSetChanged();

    }
}
