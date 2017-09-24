package com.example.tushar.bro.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tushar.bro.R;
import com.example.tushar.bro.activities.BaseActivity;
import com.example.tushar.bro.entities.Brother;
import com.example.tushar.bro.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class AboutUsAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_MAIN_HEADER=1;
    private final int VIEW_TYPE_LIST_HEADER=5;
    private final int VIEW_TYPE_BROTHER_HOOD=3;
    private final int VIEW_TYPE_SOCIAL_LIST=4;
    private final int VIEW_TYPE_SERVICE_LIST=2;


    //Header//
    //List Header//
    //Community Service//

    //List Header//
    //BrotherHoodList//

    //List Header//
    //Social List//

    private ArrayList<EventCard> socialEventCards;
    private ArrayList<EventCard> brotherHoodEventCards;



    private ArrayList<EventCard> communityServiceEventCards;
    private LayoutInflater inflater;
    private BaseActivity baseActivity;
    Listener listener;




    public AboutUsAdapter(BaseActivity baseActivity, Listener listener) {
        this.baseActivity=baseActivity;
        this.listener=listener;

        inflater=baseActivity.getLayoutInflater();
        socialEventCards=new ArrayList<>();
        brotherHoodEventCards=new ArrayList<>();
        communityServiceEventCards=new ArrayList<>();

    }

    public ArrayList<EventCard> getSocialEventCards() {
        return socialEventCards;
    }

    public ArrayList<EventCard> getBrotherHoodEventCards() {
        return brotherHoodEventCards;
    }

    public ArrayList<EventCard> getCommunityServiceEventCards() {
        return communityServiceEventCards;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      final View eventCardView=inflater.inflate(R.layout.list_event_card,parent,false);
        final View listHeader=inflater.inflate(R.layout.simple_header,parent,false);
        if(viewType==VIEW_TYPE_MAIN_HEADER){
            AboutUsMainHeaderViewHolder mainHeaderViewHolder=new AboutUsMainHeaderViewHolder(inflater,parent);
            return mainHeaderViewHolder;
        }
        else if(viewType==VIEW_TYPE_LIST_HEADER){
            AboutUsListHeaderViewHolder listHeaderViewHolder=new AboutUsListHeaderViewHolder(listHeader);
            return listHeaderViewHolder;
        }
        else if(viewType==VIEW_TYPE_SOCIAL_LIST){
            final SocialViewHolder socialViewHolder=new SocialViewHolder(eventCardView);
            socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard=(EventCard) socialViewHolder.itemView.getTag();
                    listener.oneventClicked(eventCard);


                }
            });

            return socialViewHolder;
        }
        else if(viewType==VIEW_TYPE_BROTHER_HOOD){
            final BrotherHoodViewHolder brotherHoodViewHolder=new BrotherHoodViewHolder(eventCardView);
            brotherHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard=(EventCard)brotherHoodViewHolder.itemView.getTag();
                    listener.oneventClicked(eventCard);
                }
            });
            return brotherHoodViewHolder;
        }
        else if(viewType==VIEW_TYPE_SERVICE_LIST){
            final CommunityServiceViewHolder communityServiceViewHolder=new CommunityServiceViewHolder(eventCardView);
            communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard=(EventCard)communityServiceViewHolder.itemView.getTag();
                    listener.oneventClicked(eventCard);
                }
            });
            return communityServiceViewHolder;
        }

        throw new IllegalArgumentException("What You Are looking for is not here");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AboutUsMainHeaderViewHolder){
            AboutUsMainHeaderViewHolder aboutUsMainHeaderViewHolder=(AboutUsMainHeaderViewHolder)holder;
        }

    if(holder instanceof CommunityServiceViewHolder ) {
        position--;
        if (communityServiceEventCards.size() > 0) {
            position--;}
            EventCard eventCard = communityServiceEventCards.get(position);
            ((CommunityServiceViewHolder) holder).populate(baseActivity, eventCard);


    }
    if(holder instanceof BrotherHoodViewHolder){
        position--;
        if(communityServiceEventCards.size()>0) {
            position--;
            position -= communityServiceEventCards.size();
        }
        if(brotherHoodEventCards.size()>0){
            position--;}
            EventCard eventCard=brotherHoodEventCards.get(position);
            ((BrotherHoodViewHolder)holder).populate(baseActivity,eventCard);




    }
    if(holder instanceof SocialViewHolder){
        position--;
        if(communityServiceEventCards.size()>0){
            position--;
            position-=communityServiceEventCards.size();}

        if(brotherHoodEventCards.size()>0) {
            position--;
            position -= brotherHoodEventCards.size();
        }

        if(socialEventCards.size()>0){
            position--;}
                    EventCard eventCard=socialEventCards.get(position);
            ((SocialViewHolder)holder).populate(baseActivity,eventCard);

    }
    if(holder instanceof AboutUsListHeaderViewHolder){

        int Service=1;
        int Brotherpos=Service+communityServiceEventCards.size()+1;
        int Socialpos=Brotherpos+brotherHoodEventCards.size()+1;
        AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder=(AboutUsListHeaderViewHolder)holder;

        if(position==Service){
            aboutUsListHeaderViewHolder.populate("Community Service");
        }
        if(position==Brotherpos){
            aboutUsListHeaderViewHolder.populate("BrotherHood Services");
        }
        if(position==Socialpos){
            aboutUsListHeaderViewHolder.populate("Social Services");

        }

    }





    }
    //Header//
    //List Header//
    //Community Service//

    //List Header//
    //BrotherHoodList//

    //List Header//
    //Social List//


    @Override
    public int getItemCount() {
       int count=1;
        if(communityServiceEventCards.size()>0){
            count+=1+communityServiceEventCards.size();
        }
        if(brotherHoodEventCards.size()>0){
            count+=1+brotherHoodEventCards.size();
        }
        if(socialEventCards.size()>0){
            count+=1+socialEventCards.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return VIEW_TYPE_MAIN_HEADER;

        }
        position--;
        if(communityServiceEventCards.size()>0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
        }
            if(position<communityServiceEventCards.size()){
            return VIEW_TYPE_SERVICE_LIST;}
            position-=communityServiceEventCards.size();


        if(brotherHoodEventCards.size()>0) {

            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }

            position--;
        }
            if(position<brotherHoodEventCards.size()){
                return VIEW_TYPE_BROTHER_HOOD;

            }
            position-=brotherHoodEventCards.size();

        if(socialEventCards.size()>0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
        }
            if(position<socialEventCards.size()){
                return VIEW_TYPE_SOCIAL_LIST;
            }
            position-=socialEventCards.size();
        throw new IllegalArgumentException("We are being asked for a viewtype at position : "+position+" but is not found");


    }

    public interface Listener{
        void oneventClicked(EventCard eventCard);
    }
}
