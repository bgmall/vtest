package cluster;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager;

public class ClusterMain {

    public static void main(String[] args) {
        //Config hazelcastConfig = new Config();
        //hazelcastConfig.getNetworkConfig().getJoin().getTcpIpConfig().addMember("127.0.0.1").setEnabled(true);
        //hazelcastConfig.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);

        JsonObject zkConfig = new JsonObject();
        zkConfig.put("zookeeperHosts", "127.0.0.1");
        zkConfig.put("rootPath", "io.vertx");
        zkConfig.put("retry", new JsonObject()
                .put("initialSleepTime", 3000)
                .put("maxTimes", 3));

        ZookeeperClusterManager mgr = new ZookeeperClusterManager(zkConfig);
        VertxOptions options = new VertxOptions().setClusterManager(mgr);
        Vertx.clusteredVertx(options, res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                vertx.deployVerticle(new DemoVerticle());
                vertx.deployVerticle(new ServerVerticle(4000));
            } else {
            }
        });
    }
}
