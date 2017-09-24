package com.example.tushar.bro.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.BrotherServices;
import com.example.tushar.bro.activities.BaseActivity;

import com.example.tushar.bro.activities.BrotherPagerActivity;
import com.example.tushar.bro.entities.Brother;
import com.example.tushar.bro.views.MeetABroViews.MeetABro_recycler_adapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Meet_a_bro extends BaseFragment implements MeetABro_recycler_adapter.OnBrotherClicked {
    private ArrayList<Brother> brothers;
    private MeetABro_recycler_adapter adapter;


    @BindView(R.id.meet_a_bro_recycler)
    RecyclerView recyclerView;
    public static Meet_a_bro newInstance(){
        return new Meet_a_bro();
    }


    public Meet_a_bro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_meet_a_bro, container, false);
        ButterKnife.bind(this,v);
        brothers=new ArrayList<>();
        adapter=new MeetABro_recycler_adapter(this,(BaseActivity) getActivity());
        brothers=adapter.getBrothers();


        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        setUpAdapter();
        bus.post(new BrotherServices.searchBrotherRequest("Hello"));
        return v;
    }
    public void setUpAdapter(){

        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }
    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent= BrotherPagerActivity.getIntent(getActivity(),brother);
        startActivity(intent);
    }
    @Subscribe
    public void getBrothers(BrotherServices.searchBrotherResponse response){
        int oldsize=brothers.size();
        if(oldsize==0) {
            brothers.clear();
            adapter.notifyItemRangeRemoved(0, oldsize);
            brothers.addAll(response.brothers);
            adapter.notifyItemRangeChanged(0, brothers.size());
        }


    }


}
