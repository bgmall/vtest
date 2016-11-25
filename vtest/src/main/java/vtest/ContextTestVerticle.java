package vtest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;

/**
 * Created by 37 on 2016/9/23.
 */
public class ContextTestVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        super.start();
        Context context = vertx.getOrCreateContext();
        System.out.println("start " + context);
        if (context.isEventLoopContext()) {
            System.out.println("Context attached to Event Loop");
        } else if (context.isWorkerContext()) {
            System.out.println("Context attached to Worker Thread");
        } else if (context.isMultiThreadedWorkerContext()) {
            System.out.println("Context attached to Worker Thread - multi threaded worker");
        } else if (! Context.isOnVertxThread()) {
            System.out.println("Context not attached to a thread managed by vert.x");
        }

        vertx.setTimer(1000, id -> {
            Context context1 = vertx.getOrCreateContext();
            System.out.println("setTimer " + context1);
        });

        vertx.executeBlocking(future -> {
            String hello = "hello";
            future.complete(hello);
        }, res -> {
            Context context1 = vertx.getOrCreateContext();
            System.out.println("executeBlocking " + context1);
        });

        for (int i = 0; i < 1000000; i++) {
             System.out.println("for print " + i);
        }
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        ContextTestVerticle contextTestVerticle = new ContextTestVerticle();
        vertx.deployVerticle(contextTestVerticle);
        vertx.deploymentIDs();
    }
}
