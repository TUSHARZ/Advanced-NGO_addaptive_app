package tushar.bro.inmemory;

import com.example.tushar.bro.Services.BrotherServices;
import com.example.tushar.bro.entities.Brother;
import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by TUSHAR on 04-07-2017.
 */

public class InMemoryBrotherService extends BaseInMemory {
    public InMemoryBrotherService(BroApplication application) {
        super(application);
    }

    @Subscribe
    public void getBrother(BrotherServices.searchBrotherRequest request){
        BrotherServices.searchBrotherResponse response=new BrotherServices.searchBrotherResponse();
        response.brothers=new ArrayList<>();

            for(int i=0;i<33;i++){
            response.brothers.add(new Brother(i,"Name"+i,"Joined","http://gravatar.com/avatar/"+i+"?d=identicon","M","okk","done"));
            }

        bus.post(response);

    }
}
