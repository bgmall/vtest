package servicefactories;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Created by 37 on 2016/9/29.
 */
public class DynamicServiceVerticle extends AbstractVerticle {

    BasicServiceImpl basicService;
    MessageConsumer<JsonObject> consumer;

    @Override
    public void start() throws Exception {
        super.start();
        basicService = new BasicServiceImpl();
        consumer = ProxyHelper.registerService(BasicService.class, vertx, basicService, "service");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ProxyHelper.unregisterService(consumer);
    }
}
