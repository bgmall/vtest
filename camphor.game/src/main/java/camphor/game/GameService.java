package camphor.game;

/**
 * Created by 37 on 2016/9/30.
 */
public interface GameService {

    GameObjectManager getObjectManager();

    GameEventManager getEventManager();

    void init();

    void destroy();
}
