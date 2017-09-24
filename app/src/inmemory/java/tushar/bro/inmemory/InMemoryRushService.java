package tushar.bro.inmemory;

import com.example.tushar.bro.Services.RushEventService;
import com.example.tushar.bro.entities.RushEvent;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 10-07-2017.
 */

public class InMemoryRushService extends BaseInMemory {
    public InMemoryRushService(BroApplication application) {
        super(application);
    }

    @Subscribe
    public void getRushCommunityResponse(RushEventService.SearchRushCommunityEventsRequest request){
        RushEventService.SearchRushCommunityResponse response=new RushEventService.SearchRushCommunityResponse();
        response.communityResponse=new ArrayList<>();
        response.communityResponse.add(new RushEvent(
                1,
                "Community Event 1",
                "02/02/2050",
                "09:00",
                "Building 1",
                28.629843, 77.079301,
                true,
                "Description"


        ));

        bus.post(response);


    }

    @Subscribe
    public void getRushSocialResponse(RushEventService.SearchRushSocialEventsRequest request){
        RushEventService.SearchRushSocialResponse response=new RushEventService.SearchRushSocialResponse();
        response.socialResponse=new ArrayList<>();
        response.socialResponse.add(new RushEvent(
                2,
                "Social Event 1",
                "05/02/2050",
                "20:00",
                "Building 007",
                28.639359, 77.086141,
                false,
                "Description"


        ));

        bus.post(response);


    }






}
