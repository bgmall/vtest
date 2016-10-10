package camphor.game;

import io.vertx.core.AbstractVerticle;

/**
 * Created by msg on 2016/10/9.
 */
public abstract class AbstractGameService extends AbstractVerticle implements GameService {

    @Override
    public void start() throws Exception {
        super.start();
        init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        destroy();
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }


}
