package tushar.bro.live;

import com.example.tushar.bro.Services.EventCardService;
import com.example.tushar.bro.entities.EventCard;
import com.example.tushar.bro.entities.fireBAseEntities.EventCardEntities;
import com.example.tushar.bro.entities.fireBAseEntities.EventPictureEntities;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 29-07-2017.
 */

public class LiveCardService extends BaseLiveService {
    public LiveCardService(BroApplication application) {
        super(application);
    }
    @Subscribe
    public void searchCommunityCards(EventCardService.searchCommunityEventCardRequest request){
        final EventCardService.searchCommunityEventCardResponse response=new EventCardService.searchCommunityEventCardResponse();
        response.communityeventResponse=new ArrayList<>();


        DatabaseReference dref=FirebaseDatabase.getInstance().getReference().child("data").child("eventCards").child("community");
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index=1;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    EventCardEntities eventCardEntities=dataSnapshot1.getValue(EventCardEntities.class);

                    EventCard eventCard=new EventCard(
                            index,
                            eventCardEntities.getEventName(),
                            eventCardEntities.getDesc(),
                    eventCardEntities.getImage(),
                    eventCardEntities.getYoutube(),
                    eventCardEntities.getIsvideo());
                    index++;
                    response.communityeventResponse.add(eventCard);
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }



    @Subscribe
    public void searchbrotherhoodCards(EventCardService.searchBrotherhoodEventCardRequest request){
        final EventCardService.searchBrotherhoodEventCardResponse response=new EventCardService.searchBrotherhoodEventCardResponse();
        response.brotherHoodeventRespnse=new ArrayList<>();
        DatabaseReference dref=FirebaseDatabase.getInstance().getReference().child("data").child("eventCards").child("brotherHood");
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index=3;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    EventCardEntities eventCardEntities=dataSnapshot1.getValue(EventCardEntities.class);

                    EventCard eventCard=new EventCard(
                            index,
                            eventCardEntities.getEventName(),
                            eventCardEntities.getDesc(),
                            eventCardEntities.getImage(),
                            eventCardEntities.getYoutube(),
                            eventCardEntities.getIsvideo());
                     index++;
                    response.brotherHoodeventRespnse.add(eventCard);
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }



    @Subscribe
    public void searchSocialCards(EventCardService.searchSocialEventCardRequest request){
        final EventCardService.searchSocialEventCardResponse response=new EventCardService.searchSocialEventCardResponse();
        response.SocialeventRespnse=new ArrayList<>();
        DatabaseReference dref=FirebaseDatabase.getInstance().getReference().child("data").child("eventCards").child("Socials");
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index=5;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){

                    EventCardEntities eventCardEntities=dataSnapshot1.getValue(EventCardEntities.class);

                    EventCard eventCard=new EventCard(
                            index,
                            eventCardEntities.getEventName(),
                            eventCardEntities.getDesc(),
                            eventCardEntities.getImage(),
                            eventCardEntities.getYoutube(),
                            eventCardEntities.getIsvideo());
                     index++;
                    response.SocialeventRespnse.add(eventCard);
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }}

