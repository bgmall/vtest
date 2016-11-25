package servicefactories;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by 37 on 2016/9/29.
 */
public class ServiceFactoriesMain {
    public static void main(String[] args) {
        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle("service:servicefactories/servicefactories.dynamicservice");
        vertx.deployVerticle("service:servicefactories/servicefactories.dynamicservice");
        DeploymentOptions deploymentOptions = new DeploymentOptions();
        vertx.deployVerticle("service:servicefactories/servicefactories.staticservice");
    }
}
