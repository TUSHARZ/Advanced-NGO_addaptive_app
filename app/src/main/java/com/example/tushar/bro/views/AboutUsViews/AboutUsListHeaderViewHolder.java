package com.example.tushar.bro.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.EventCard;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class AboutUsListHeaderViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.simple_header_text)
    TextView header;

    public AboutUsListHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(String string){
        header.setText(string);


    }
}
