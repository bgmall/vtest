package camphor.game;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

/**
 * Created by 37 on 2016/9/30.
 */
public class NetServerVerticle extends AbstractVerticle {

    private static final String NETCONFIG = "netConfig";

    private NetServer server;

    @Override
    public void start() throws Exception {
        super.start();
        if (config().containsKey(NETCONFIG)) {
            JsonObject netConfig = config().getJsonObject(NETCONFIG);
            NetServerOptions netServerOptions = new NetServerOptions(netConfig);
            server = vertx.createNetServer(netServerOptions);
        } else {
            server = vertx.createNetServer();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (server != null) {
            server.close();
        }
    }
}
