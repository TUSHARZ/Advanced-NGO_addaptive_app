package com.example.tushar.bro.views.MeetABroViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tushar.bro.R;
import com.example.tushar.bro.activities.BaseActivity;
import com.example.tushar.bro.entities.Brother;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 03-07-2017.
 */

public class MeetABro_recycler_adapter extends RecyclerView.Adapter<MeetABro_View_Holder> implements View.OnClickListener {
   private BaseActivity activity;
    private ArrayList<Brother> brothers;
    private LayoutInflater inflater;
   private OnBrotherClicked listener;
    public MeetABro_recycler_adapter(OnBrotherClicked listener, BaseActivity activity) {
        this.activity = activity;
        this.listener=listener;
        inflater=activity.getLayoutInflater();
        brothers=new ArrayList<>();

    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }

    @Override

    public MeetABro_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View list=inflater.inflate(R.layout.meet_a_bro_list,parent,false);
        list.setOnClickListener(this);
        return new MeetABro_View_Holder(list);
    }

    @Override
    public void onBindViewHolder(MeetABro_View_Holder holder, int position) {
          holder.populate(activity,brothers.get(position));
    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag()instanceof Brother){
            Brother brother=(Brother)view.getTag();
           listener.onBrotherClicked(brother);
        }

    }
    public interface OnBrotherClicked{
        void onBrotherClicked(Brother brother);
    }


}
