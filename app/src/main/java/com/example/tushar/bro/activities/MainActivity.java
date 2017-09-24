package com.example.tushar.bro.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.tushar.bro.R;
import com.example.tushar.bro.Services.BrotherServices;
import com.example.tushar.bro.views.MainActivityViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_tabs)
    TabLayout tabs;
    @BindView(R.id.main_viewpager)
    ViewPager pager;
    @BindView(R.id.tool)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pager.setAdapter(new MainActivityViewPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(pager);
    }
}
