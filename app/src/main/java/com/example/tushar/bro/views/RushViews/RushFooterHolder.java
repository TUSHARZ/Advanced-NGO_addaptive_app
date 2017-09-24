package com.example.tushar.bro.views.RushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tushar.bro.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushFooterHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.footer_rush_fragment_facebook)
    ImageView facebook;
    @BindView(R.id.footer_rush_fragment_instagram)
    ImageView instagram;
    @BindView(R.id.footer_rush_fragment_snapchat)
    ImageView snapchat;
    @BindView(R.id.footer_rush_fragment_twitter)
    ImageView twitter;
    public RushFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                try {
                    view.getContext().getPackageManager().getPackageInfo("com.facebook.katana",0);
                    intent=new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/154213784747095"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/robertdowneyjr/"));

                }

                view.getContext().startActivity(intent);
            }


        });


        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                try {
                    view.getContext().getPackageManager().getPackageInfo("com.twitter.android",0);
                    intent=new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=47786101"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/RobertDowneyJr"));

                }

                view.getContext().startActivity(intent);
            }


        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                try {
                    view.getContext().getPackageManager().getPackageInfo("com.instagram.android",0);
                    intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/robertdowneyjr"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/robertdowneyjr/?hl=en"));

                }

                view.getContext().startActivity(intent);
            }


        });

        snapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                try {
                    view.getContext().getPackageManager().getPackageInfo("com.snapchat.android",0);
                    intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/"+"djkhaled"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://snapchat.com/"+"djkhaled"));

                }

                view.getContext().startActivity(intent);
            }


        });
    }

    public void populate(Context context){
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/faceBookLogo_zps5ehpqnng.png").into(facebook);

        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/insta_logo_zpshg6xmz7g.jpg").into(instagram);

        Picasso.with(context).load("https://dl.dropboxusercontent.com/s/jbtx0tbvi2t3v67/twitter%20logo.jpg?dl=0").into(twitter);

        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/snapChat_logo_zpsjzwi8hpr.png").into(snapchat);






    }



}
