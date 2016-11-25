package servicefactories;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Created by 37 on 2016/9/29.
 */
public class StaticServiceVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        int count = 1;
        BasicService basicService = ProxyHelper.createProxy(BasicService.class, vertx, "service");
//        JsonObject document = new JsonObject().put("name", "vertx");
//        basicService.find(document, r -> {
//            if (r.succeeded()) {
//                System.out.println(r.result().encodePrettily());
//            } else {
//                System.out.println(r.cause());
//            }
//        });
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            String hi = "hi";
            basicService.hello(hi, r -> {
                if (r.succeeded()) {
//                    System.out.println(r.result());
                }
            });
        }

        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        BasicService basicService1 = new BasicServiceImpl();
        for (int i = 0; i < count; i++) {
            String hi = "hi";
            basicService1.call(hi);
        }
        System.out.println(System.currentTimeMillis() - start);

        vertx.eventBus().consumer("hello", res -> {
        });


        vertx.eventBus().send("hello", "hello, world", res -> {
            if (res.succeeded()) {

            }
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
