package com.example.tushar.bro.views.MeetABroViews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 03-07-2017.
 */

public class MeetABro_View_Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.bro_image)
    ImageView image;
    @BindView(R.id.bro_progress)
    ProgressBar bro_progress_bar;




    public MeetABro_View_Holder(View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);

    }

    public void populate(Context ctx, Brother brother){
        itemView.setTag(brother);

        Picasso.with(ctx).load(brother.getBrotherPicture()).into(image, new Callback() {
            @Override
            public void onSuccess() {
                bro_progress_bar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });


    }


}


