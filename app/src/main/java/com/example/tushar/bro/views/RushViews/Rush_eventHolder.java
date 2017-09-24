package com.example.tushar.bro.views.RushViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tushar.bro.R;
import com.example.tushar.bro.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Rush_eventHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_rush_event_name)
    TextView name;
    @BindView(R.id.list_rush_event_date)
    TextView date;
    @BindView(R.id.list_rush_event_location)
    TextView location;
    @BindView(R.id.list_rush_event_time)
    TextView time;
    public Rush_eventHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(RushEvent event){

        itemView.setTag(event);
        name.setText(event.getEventName());
        date.setText(event.getEventDate());
        location.setText(event.getEventLocation());
        time.setText(event.getEventTime());



    }
}
