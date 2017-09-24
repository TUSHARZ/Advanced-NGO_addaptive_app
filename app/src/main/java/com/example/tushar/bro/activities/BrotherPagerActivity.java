package com.example.tushar.bro.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.tushar.bro.Fragments.Brother_details;
import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.BrotherServices;
import com.example.tushar.bro.entities.Brother;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class BrotherPagerActivity extends BaseActivity {
    public ArrayList<Brother> brothers;
    @BindView(R.id.brother_view_pager)
    ViewPager brother_view_pager;
    public static final String BrotherClicked="Clicked";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        ButterKnife.bind(this);
        brothers=new ArrayList<>();
        bus.post(new BrotherServices.searchBrotherRequest("Hello"));

        brother_view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother=brothers.get(position);
                return Brother_details.newInstance(brother);

            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });


    }

    @Subscribe
    public  void getbrother(BrotherServices.searchBrotherResponse response){
        brothers.clear();
        brothers.addAll(response.brothers);
        brother_view_pager.getAdapter().notifyDataSetChanged();
        Brother brother=getIntent().getParcelableExtra(BrotherClicked);
        Integer BrotherId=brother.getBrotherId();
        for(int i=0;i<brothers.size();i++) {

            if ( brothers.get(i).getBrotherId()==BrotherId){
                brother_view_pager.setCurrentItem(i);
                break;

            }


        }
    }
    public static Intent getIntent(Context context, Brother brother){

        Intent intent=new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BrotherClicked,brother);
        return intent;


    }
}
