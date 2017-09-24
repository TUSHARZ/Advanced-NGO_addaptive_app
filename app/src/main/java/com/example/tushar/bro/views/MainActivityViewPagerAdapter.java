package com.example.tushar.bro.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tushar.bro.Fragments.Meet_a_bro;
import com.example.tushar.bro.Fragments.about_us;
import com.example.tushar.bro.Fragments.rush;

/**
 * Created by TUSHAR on 03-07-2017.
 */

public class MainActivityViewPagerAdapter extends FragmentPagerAdapter {
    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment temp;
        switch (position){
            case 0: temp= about_us.newInstance();
                break;
            case 1: temp= Meet_a_bro.newInstance();
                break;
            case 2:
               temp= rush.newInstance();
                break;
            default: return null;

        }

        return temp;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       CharSequence Fragment_Title;
        switch (position){
            case 0: Fragment_Title="About Us";
                break;
            case 1:Fragment_Title="Meet A Bro";
                break;
            case 2:
                Fragment_Title= "Rush";
                break;
            default: return null;

        }

        return Fragment_Title;
    }
}
