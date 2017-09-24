package tushar.bro.live;

import com.example.tushar.bro.Services.BrotherServices;
import com.example.tushar.bro.entities.Brother;
import com.example.tushar.bro.entities.fireBAseEntities.BrotherEntities;
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

public class LiveBrotherService extends BaseLiveService {
    public LiveBrotherService(BroApplication application) {
        super(application);
    }
    @Subscribe
    public void getBrother(BrotherServices.searchBrotherRequest request){
        final BrotherServices.searchBrotherResponse response=new BrotherServices.searchBrotherResponse();
        response.brothers=new ArrayList<>();

                final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("data").child("brother");
      databaseReference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              int index =0;
              for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                  BrotherEntities brotherEntities=dataSnapshot1.getValue(BrotherEntities.class);

                  Brother brother=new Brother(
                          index,
                          brotherEntities.getName(),
                          brotherEntities.getWhy(),
                          brotherEntities.getPicture(),
                          brotherEntities.getMajor(),

                  brotherEntities.getCross(),
                  brotherEntities.getFact()
                  );


                  index++;
                  response.brothers.add(brother);

              }
              bus.post(response);
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });




    }
}
