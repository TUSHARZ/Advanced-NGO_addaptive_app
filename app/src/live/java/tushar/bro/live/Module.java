package tushar.bro.live;

import com.example.tushar.bro.infrastructure.BroApplication;

/**
 * Created by TUSHAR on 29-07-2017.
 */

public class Module {

    public static void Register(BroApplication application){

        new LiveBrotherService(application);
        new LiveCardService(application);
        new LivePictureService(application);
        new LiveRush(application);


    }


}
