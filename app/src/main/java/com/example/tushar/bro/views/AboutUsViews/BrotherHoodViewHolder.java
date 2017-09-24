package com.example.tushar.bro.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class BrotherHoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_event_card_name)
    TextView name;
    @BindView(R.id.list_event_card_description)
    TextView description;
    @BindView(R.id.list_event_card_image)
    ImageView eventImage;
    @BindView(R.id.isVideoimage)
    ImageView isVideoimage;
    @BindView(R.id.list_event_card_progress)
    ProgressBar progressBar;
    public BrotherHoodViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);
    }



    public void populate(Context context, EventCard eventCard){
        itemView.setTag(eventCard);

        name.setText(eventCard.getEventName());
        description.setText(eventCard.getEventDescription());
        isVideoimage.setImageResource(R.mipmap.camera);
        if(eventCard.getIsVideo()){
            isVideoimage.setImageResource(R.mipmap.video);


        }
        else {isVideoimage.setImageResource(R.mipmap.camera);}


        Picasso.with(context).load(eventCard.getEventImage()).into(eventImage, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });





    }
}
