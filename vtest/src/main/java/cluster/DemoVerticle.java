package cluster;

import io.vertx.core.AbstractVerticle;

public class DemoVerticle extends AbstractVerticle {

    public static final String ALL_PRODUCTS_ADDRESS = "example.all.products";

    @Override
    public void start() throws Exception {
        super.start();
        vertx.eventBus().<String>consumer(ALL_PRODUCTS_ADDRESS).handler(msg -> {
            System.out.println(msg);
        });
    }
}
