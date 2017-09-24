package com.example.tushar.bro.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.RushEventService;
import com.example.tushar.bro.activities.BaseActivity;
import com.example.tushar.bro.activities.Maps_Activity;
import com.example.tushar.bro.activities.web_view_maps;
import com.example.tushar.bro.entities.RushEvent;
import com.example.tushar.bro.views.RushViews.RushAdapter;
import com.example.tushar.bro.views.RushViews.item;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class rush extends BaseFragment implements RushAdapter.RushListener{
    public ArrayList<RushEvent> CommunityEvents;
    public ArrayList<RushEvent> SocialEvents;

    public item social;
    public item community;

    @BindView(R.id.rush_recycler)
    RecyclerView recyclerView;
    RushAdapter adapter;

    public static rush newInstance(){
        return new rush();
    }


    public rush() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v= inflater.inflate(R.layout.fragment_rush, container, false);
        ButterKnife.bind(this,v);

        adapter=new RushAdapter((BaseActivity)getActivity(),this);

        CommunityEvents=new ArrayList<>();
        SocialEvents=new ArrayList<>();
        ArrayList<item> data=adapter.getData();

        community=new item(RushAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Community");
        community.invisibleChildren=new ArrayList<>();
        social=new item(RushAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Social");
        social.invisibleChildren=new ArrayList<>();

        bus.post(new RushEventService.SearchRushCommunityEventsRequest("Hello"));
        bus.post(new RushEventService.SearchRushSocialEventsRequest("Hello"));

        data.add(community);
        data.add(social);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();

        return v;
    }

    @Override
    public void onRushEventClicked(RushEvent rushEvent) {
        if(!rushEvent.getOnCampus()){
            Intent intent= web_view_maps.newIntent(getActivity(),rushEvent);
            startActivity(intent);
        }
        else {
            Intent intent = Maps_Activity.getIntent(getActivity(), rushEvent);
            startActivity(intent);
        }
    }

    public void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }


    @Subscribe
    public void getCommunityRushEvents(RushEventService.SearchRushCommunityResponse response){

        CommunityEvents.clear();

        CommunityEvents.addAll(response.communityResponse);

    for (RushEvent rushEvent : CommunityEvents) {
        community.invisibleChildren.add(new item(RushAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));

    }


    }

    @Subscribe
    public void getSocialServiceEvents(RushEventService.SearchRushSocialResponse response){

        SocialEvents.clear();


        SocialEvents.addAll(response.socialResponse);
        for(RushEvent rushEvent:SocialEvents){
            social.invisibleChildren.add(new item(RushAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvent));
        }

    }
}
