package com.example.tushar.bro.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.EventCard;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 09-07-2017.
 */

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String Youtube="Youtube";
    public String video;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_us_youtube_video);

        video=getIntent().getExtras().getString(Youtube);
        YouTubePlayerView player=(YouTubePlayerView)findViewById(R.id.about_us_video);

        player.initialize(BroApplication.YOUTUBE_KEY,this);




    }

    public static Intent newIntent(Context context, EventCard eventCard){
        Intent intent=new Intent(context,YoutubeActivity.class);
        intent.putExtra(Youtube,eventCard.getYoutubeEnding());
        return intent;

    }





    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        youTubePlayer.loadVideo(video);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
