package tushar.bro.inmemory;

import com.example.tushar.bro.infrastructure.BroApplication;

/**
 * Created by TUSHAR on 04-07-2017.
 */

public class Module {

    public static void register(BroApplication application){
        new InMemoryBrotherService(application);
        new InMemoryEventCardService(application);
        new InMemoryEventPictureService(application);
        new InMemoryRushService(application);
    }
}
