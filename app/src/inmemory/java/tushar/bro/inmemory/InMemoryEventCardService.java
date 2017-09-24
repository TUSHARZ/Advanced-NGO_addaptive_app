package tushar.bro.inmemory;

import com.example.tushar.bro.Services.EventCardService;
import com.example.tushar.bro.entities.EventCard;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 08-07-2017.
 */

public class InMemoryEventCardService extends BaseInMemory {
    public InMemoryEventCardService(BroApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.searchCommunityEventCardRequest request){
       EventCardService.searchCommunityEventCardResponse response=new EventCardService.searchCommunityEventCardResponse();
        response.communityeventResponse=new ArrayList<>();
        response.communityeventResponse.add(new EventCard(
                1,
                "Community Event 1",
                "Description 1",
                "http://gravatar.com/avatar/"+1+"?d=identicon",
                null,
                false

        ));
        response.communityeventResponse.add(new EventCard(
                2,
                "Community Event 2",
                "Description 2",
                "http://gravatar.com/avatar/"+2+"?d=identicon",
                "q0ov2ZIgC88",
                true

        ));
        bus.post(response);
    }



    @Subscribe
    public void searchbrotherhoodCards(EventCardService.searchBrotherhoodEventCardRequest request){
        EventCardService.searchBrotherhoodEventCardResponse response=new EventCardService.searchBrotherhoodEventCardResponse();
        response.brotherHoodeventRespnse=new ArrayList<>();
        response.brotherHoodeventRespnse.add(new EventCard(
                3,
                "Brotherhood Event 1",
                "Description 1",
                "http://gravatar.com/avatar/"+3+"?d=identicon",
                null,
                false

        ));
        response.brotherHoodeventRespnse.add(new EventCard(
                4,
                "Brotehr Event 2",
                "Description 2",
                "http://gravatar.com/avatar/"+4+"?d=identicon",
                "a5elivsTUKg",
                true

        ));
        bus.post(response);
    }



    @Subscribe
    public void searchSocialCards(EventCardService.searchSocialEventCardRequest request){
        EventCardService.searchSocialEventCardResponse response=new EventCardService.searchSocialEventCardResponse();
        response.SocialeventRespnse=new ArrayList<>();
        response.SocialeventRespnse.add(new EventCard(
                5,
                "Social Event 1",
                "Description 1",
                "http://gravatar.com/avatar/"+5+"?d=identicon",
                null,
                false

        ));
        response.SocialeventRespnse.add(new EventCard(
                6,
                "Social Event 2",
                "Description 2",
                "http://gravatar.com/avatar/"+6+"?d=identicon",
                "5svxuS3L9_s",
                true

        ));
        bus.post(response);
    }
}
