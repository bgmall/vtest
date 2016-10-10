package camphor.game;

/**
 * Created by msg on 2016/10/9.
 */
public interface GameEventListener {

    void handleGameEvent(GameEvent<?> event);
}
