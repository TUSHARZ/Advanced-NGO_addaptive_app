package com.example.tushar.bro.views.RushViews;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tushar.bro.R;
import com.example.tushar.bro.activities.BaseActivity;
import com.example.tushar.bro.entities.RushEvent;

import java.util.ArrayList;


public class RushAdapter extends RecyclerView.Adapter {
   public static final int VIEW_TYPE_LIST_HEADER=1;
    public  static final int VIEW_TYPE_EXPANDABLE_LIST_HEADER=2;
    public  static final int VIEW_TYPE_EXPANDABLE_LIST_CHILD=3;
    public static final int VIEW_TYPE_FOOTER=4;

    private ArrayList<item> data;
    private LayoutInflater inflater;
    private BaseActivity activity;
    RushListener listener;

    public RushAdapter(BaseActivity activity, RushListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater=activity.getLayoutInflater();
        data=new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listheaderview=inflater.inflate(R.layout.header_fragment_rush,parent,false);
        View expandablelistheaderview=inflater.inflate(R.layout.list_expandable_header,parent,false);
        View expandablelistchild=inflater.inflate(R.layout.list_rush_event,parent,false);
        View rushfooter=inflater.inflate(R.layout.footer_rush_fragment,parent,false);

        switch (viewType){

            case VIEW_TYPE_LIST_HEADER:
                return new Rush_Header_Holder(listheaderview);

            case VIEW_TYPE_EXPANDABLE_LIST_HEADER:
           return new RushExpandableHeaderHolder(expandablelistheaderview);

            case VIEW_TYPE_EXPANDABLE_LIST_CHILD:
                final Rush_eventHolder holder=new Rush_eventHolder(expandablelistchild);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent event=(RushEvent)holder.itemView.getTag();
                        listener.onRushEventClicked(event);
                    }
                });

                return holder;


            case  VIEW_TYPE_FOOTER:
                return new RushFooterHolder(rushfooter);


        }
        throw new IllegalArgumentException("What You Are looking for is not here");
    }


    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return VIEW_TYPE_LIST_HEADER;
        }
        position--;
        if(position<data.size()){
            return data.get(position).type;
        }
        position-=data.size();

        if(position<data.size()){
            return VIEW_TYPE_FOOTER;
        }
        position--;
        throw new IllegalArgumentException("What You Are looking for is not here at"+position);


    }

    public ArrayList<item> getData() {
        return data;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof RushExpandableHeaderHolder){
            position--;
            final item item=data.get(position);

            final RushExpandableHeaderHolder itemController=(RushExpandableHeaderHolder)holder;
            itemController.name.setText(item.header);
            itemController.referallitem=item;

            if(item.invisibleChildren==null){
                itemController.plus.setImageResource(R.mipmap.minus);

            }
            else {
                itemController.plus.setImageResource(R.mipmap.plus);
            }

            itemController.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item.invisibleChildren == null) {


                        item.invisibleChildren = new ArrayList<>();
                        int pos = data.indexOf(itemController.referallitem);
                        int count = 0;

                        while(data.size() > pos +1 && data.get(pos+1).type==VIEW_TYPE_EXPANDABLE_LIST_CHILD) {

                            item.invisibleChildren.add(data.remove(pos+1));
                            count++;




                        }
                        notifyItemRangeRemoved(pos+1,count);
                        itemController.plus.setImageResource(R.mipmap.plus);
                    }
                    else{
                        int position=data.indexOf(itemController.referallitem);
                        int count=position+1;

                        for(item item1:item.invisibleChildren) {
                            data.add(count,item1);
                            count++;


                        }

                        notifyItemRangeInserted(position+1,count-position-1);
                        itemController.plus.setImageResource(R.mipmap.minus);
                        item.invisibleChildren=null;
                    }
                }
            });





            }
            else if(holder instanceof Rush_eventHolder){
            position--;

            Rush_eventHolder rush_eventHolder=(Rush_eventHolder)holder;
            rush_eventHolder.populate(data.get(position).rushEvent);
        }
        else if(holder instanceof RushFooterHolder){
            ((RushFooterHolder)holder).populate(activity);
        }
        else if(holder instanceof Rush_Header_Holder){
            Rush_Header_Holder rush_header_holder=(Rush_Header_Holder)holder;
        }






        }



    @Override
    public int getItemCount() {
        int count =2;
        if(data.size()>0){
            count+=data.size();
        }
        return count;
    }

    public interface RushListener{
        void onRushEventClicked(RushEvent rushEvent);
    }
}
