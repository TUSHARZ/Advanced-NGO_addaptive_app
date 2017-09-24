package com.example.tushar.bro.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tushar.bro.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TUSHAR on 10-07-2017.
 */

public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.list_expandable_name)
    TextView name;
    @BindView(R.id.list_expandable_plus)
    ImageView plus;
 //Check this
  @BindView(R.id.list_expandable_layout)
    View view;
    public item referallitem;
    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
