package tushar.bro.live;

import com.example.tushar.bro.Services.RushEventService;
import com.example.tushar.bro.entities.RushEvent;
import com.example.tushar.bro.entities.fireBAseEntities.RushEntities;
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

public class LiveRush extends BaseLiveService {
    public LiveRush(BroApplication application) {
        super(application);
    }
    @Subscribe
    public void getRushCommunityResponse(RushEventService.SearchRushCommunityEventsRequest request){
        final RushEventService.SearchRushCommunityResponse response=new RushEventService.SearchRushCommunityResponse();
        response.communityResponse=new ArrayList<>();
        DatabaseReference dref= FirebaseDatabase.getInstance().getReference().child("data").child("rush").child("community");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index=0;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    RushEntities rushEntities=dataSnapshot1.getValue(RushEntities.class);

                    RushEvent rushEvent=new RushEvent(
                            index,
                            rushEntities.getName(),
                            rushEntities.getDate(),
                            rushEntities.getTime(),
                            rushEntities.getLocation(),
                          rushEntities.getlatitiude(),
                    rushEntities.getlongitude(),
                            rushEntities.getOnCampus(),
                            rushEntities.getDesc()
                    );
                    index++;
                    response.communityResponse.add(rushEvent);

                }
                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Subscribe
    public void getRushSocialResponse(final RushEventService.SearchRushSocialEventsRequest request){
        final RushEventService.SearchRushSocialResponse response=new RushEventService.SearchRushSocialResponse();
        response.socialResponse=new ArrayList<>();
        DatabaseReference dref= FirebaseDatabase.getInstance().getReference().child("data").child("rush").child("social");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index=0;
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    RushEntities rushEntities=dataSnapshot1.getValue(RushEntities.class);

                    RushEvent rushEvent=new RushEvent(
                            index,
                            rushEntities.getName(),
                    rushEntities.getDate(),
                    rushEntities.getTime(),
                    rushEntities.getLocation(),
                    rushEntities.getlatitiude(),
                    rushEntities.getlongitude(),
                    rushEntities.getOnCampus(),
                    rushEntities.getDesc()
                    );
                    index++;
                    response.socialResponse.add(rushEvent);

                }
                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }






}

