package com.example.tushar.bro.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.EventCardService;
import com.example.tushar.bro.activities.BaseActivity;
import com.example.tushar.bro.activities.YoutubeActivity;
import com.example.tushar.bro.activities.photo_pager_activity;
import com.example.tushar.bro.entities.EventCard;
import com.example.tushar.bro.views.AboutUsViews.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class about_us extends BaseFragment implements AboutUsAdapter.Listener {
  @BindView(R.id.about_us_recyclerView)
  RecyclerView recyclerView;
    public AboutUsAdapter aboutUsAdapter;

    private ArrayList<EventCard> CommunityCards;

    private ArrayList<EventCard> BrotherHoodCards;

    private ArrayList<EventCard> SocialServiceCards;







    public static about_us newInstance(){
        return new about_us();
    }


    public about_us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this,v);

        aboutUsAdapter=new AboutUsAdapter((BaseActivity)getActivity(),this);
        BrotherHoodCards=aboutUsAdapter.getBrotherHoodEventCards();
        CommunityCards=aboutUsAdapter.getCommunityServiceEventCards();
        SocialServiceCards=aboutUsAdapter.getSocialEventCards();
        setAdapter();
        bus.post(new EventCardService.searchCommunityEventCardRequest("Hello"));
        bus.post(new EventCardService.searchBrotherhoodEventCardRequest("Hello"));
        bus.post(new EventCardService.searchSocialEventCardRequest("Hello"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
public void setAdapter(){

    if(isAdded()){
        recyclerView.setAdapter(aboutUsAdapter);
    }
}

    @Override
    public void oneventClicked(EventCard eventCard) {
        if(eventCard.getIsVideo()){
       Intent intent= YoutubeActivity.newIntent(getActivity(),eventCard);
            startActivity(intent);
        }
       else {
          Intent intent= photo_pager_activity.getIntent(getActivity(),eventCard);
            startActivity(intent);


        }
    }

    @Subscribe
    public void getCommunityCards(EventCardService.searchCommunityEventCardResponse response){
        int oldsize=CommunityCards.size();
        if(oldsize==0) {
            CommunityCards.clear();
            aboutUsAdapter.notifyItemRangeRemoved(0, oldsize);
            CommunityCards.addAll(response.communityeventResponse);
            aboutUsAdapter.notifyItemRangeInserted(0, CommunityCards.size());
        }

    }

    @Subscribe
    public void getBrotherHoodCards(EventCardService.searchBrotherhoodEventCardResponse response){
        int oldsize=BrotherHoodCards.size();
        if(oldsize==0) {
            BrotherHoodCards.clear();
            aboutUsAdapter.notifyItemRangeRemoved(0, oldsize);
            BrotherHoodCards.addAll(response.brotherHoodeventRespnse);
            aboutUsAdapter.notifyItemRangeInserted(0, BrotherHoodCards.size());
        }
    }

    @Subscribe
    public void getSocialCards(EventCardService.searchSocialEventCardResponse response){
        int oldsize=SocialServiceCards.size();
        if(oldsize==0) {
            SocialServiceCards.clear();
            aboutUsAdapter.notifyItemRangeRemoved(0, oldsize);
            SocialServiceCards.addAll(response.SocialeventRespnse);
            aboutUsAdapter.notifyItemRangeInserted(0,SocialServiceCards.size());
        }
}}

