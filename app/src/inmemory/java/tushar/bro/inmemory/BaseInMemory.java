package tushar.bro.inmemory;

import com.example.tushar.bro.infrastructure.BroApplication;
import com.squareup.otto.Bus;

/**
 * Created by TUSHAR on 04-07-2017.
 */

public class BaseInMemory {
    protected final Bus bus;
    protected final BroApplication application;


    public BaseInMemory(BroApplication application) {
        this.application = application;
        this.bus=application.getBus();
        bus.register(this);
    }
}
