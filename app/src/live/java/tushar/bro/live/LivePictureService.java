package tushar.bro.live;

import com.example.tushar.bro.Services.EventPicturesService;
import com.example.tushar.bro.entities.EventPictures;
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

public class LivePictureService extends BaseLiveService {
    public LivePictureService(BroApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityPictures(EventPicturesService.searchCommunityPictureRequest request) {

        final EventPicturesService.searchCommunityPictureResponse response = new EventPicturesService.searchCommunityPictureResponse();
        response.communityPicturerResponse = new ArrayList<>();


        DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("data").child("eventPics").child("community");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPictureEntities eventPictureEntities = dataSnapshot1.getValue(EventPictureEntities.class);

                    EventPictures eventPictures = new EventPictures(
                            eventPictureEntities.getUrl()
                    );
                    response.communityPicturerResponse.add(eventPictures);
                    index++;
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    @Subscribe
    public void searchBrotherHoodPictures(EventPicturesService.searchBrotherhoodPictureRequest request) {
        final EventPicturesService.searchBrotherhoodPictureResponse response = new EventPicturesService.searchBrotherhoodPictureResponse();
        response.brotherHoodPictureResponse = new ArrayList<>();
        DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("data").child("eventPics").child("brotherHood");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPictureEntities eventPictureEntities = dataSnapshot1.getValue(EventPictureEntities.class);

                    EventPictures eventPictures = new EventPictures(
                            eventPictureEntities.getUrl()
                    );
                    response.brotherHoodPictureResponse.add(eventPictures);
                    index++;
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    @Subscribe
    public void searchSocialPictures(EventPicturesService.searchSocialPictureRequest request) {

        final EventPicturesService.searchSocialPictureResponse response = new EventPicturesService.searchSocialPictureResponse();
        response.socialPictureResponse = new ArrayList<>();
        DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("data").child("eventPics").child("social");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    EventPictureEntities eventPictureEntities = dataSnapshot1.getValue(EventPictureEntities.class);

                    EventPictures eventPictures = new EventPictures(
                            eventPictureEntities.getUrl()
                    );
                    response.socialPictureResponse.add(eventPictures);
                    index++;
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
