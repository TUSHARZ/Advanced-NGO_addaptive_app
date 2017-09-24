package tushar.bro.inmemory;

import com.example.tushar.bro.Services.EventPicturesService;
import com.example.tushar.bro.entities.EventPictures;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 09-07-2017.
 */

public class InMemoryEventPictureService extends BaseInMemory {
    public InMemoryEventPictureService(BroApplication application) {
        super(application);
    }


    @Subscribe
    public void searchCommunityPictures(EventPicturesService.searchCommunityPictureRequest request){

        EventPicturesService.searchCommunityPictureResponse response=new EventPicturesService.searchCommunityPictureResponse();
        response.communityPicturerResponse=new ArrayList<>();
        response.communityPicturerResponse.add(new EventPictures("http://gravatar.com/avatar/"+50+"?d=identicon"));
        response.communityPicturerResponse.add(new EventPictures("http://gravatar.com/avatar/"+51+"?d=identicon"));

        response.communityPicturerResponse.add(new EventPictures("http://gravatar.com/avatar/"+52+"?d=identicon"));
        bus.post(response);


    }
    @Subscribe
    public void searchBrotherHoodPictures(EventPicturesService.searchBrotherhoodPictureRequest request){
        EventPicturesService.searchBrotherhoodPictureResponse response=new EventPicturesService.searchBrotherhoodPictureResponse();
        response.brotherHoodPictureResponse=new ArrayList<>();
        response.brotherHoodPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+53+"?d=identicon"));

        response.brotherHoodPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+54+"?d=identicon"));
        response.brotherHoodPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+55+"?d=identicon"));
        bus.post(response);
    }


    @Subscribe
    public void searchSocialPictures(EventPicturesService.searchSocialPictureRequest request){

      EventPicturesService.searchSocialPictureResponse response=new EventPicturesService.searchSocialPictureResponse();
        response.socialPictureResponse=new ArrayList<>();
        response.socialPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+56+"?d=identicon"));
        response.socialPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+57+"?d=identicon"));
        response.socialPictureResponse.add(new EventPictures("http://gravatar.com/avatar/"+60+"?d=identicon"));

        bus.post(response);
    }


}
