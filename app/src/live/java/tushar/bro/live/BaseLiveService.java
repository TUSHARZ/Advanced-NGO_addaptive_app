package tushar.bro.live;

import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Bus;

/**
 * Created by TUSHAR on 29-07-2017.
 */

public class BaseLiveService {
    protected Bus bus;
    protected BroApplication application;

    public BaseLiveService(BroApplication application){
        this.application=application;
        bus=application.getBus();
        bus.register(this);

    }
}
