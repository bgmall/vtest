package camphor.game;

/**
 * Created by msg on 2016/10/8.
 */
public abstract class AbstractComponent implements Component {

    @Override
    public void init() {

    }

    @Override
    public void ready() {

    }

    @Override
    public void suspend() {

    }

    @Override
    public void destroy() {

    }

    public void fireGameEvent(GameEvent<?> event) {

    }

    public void sendGameEvent(GameEvent<?> event) {

    }

    public void sendGameEvent(GameEvent<?> event, long receiverId) {

    }

    public void sendGameEvent(String eventId, long receiverId) {
        GameEvent<?> instance = GameEvent.getInstance(eventId, null, null);
        sendGameEvent(instance, receiverId);
    }

    public void sendGameEvent(String eventId, Object data, long receiverId) {
        GameEvent<?> instance = GameEvent.getInstance(eventId, data, null);
        sendGameEvent(instance, receiverId);
    }

    public void sendGameEvent(String eventId, long receiverId, ReplyHandler<?> handler) {
        GameEvent<?> instance = GameEvent.getInstance(eventId, null, null);
        sendGameEvent(instance, receiverId);
    }

    public void sendGameEvent(String eventId, Object data, long receiverId, ReplyHandler<?> handler) {
        GameEvent<?> instance = GameEvent.getInstance(eventId, data, handler);
        sendGameEvent(instance, receiverId);
    }

    @Override
    public void setParent(GameObject parent) {

    }

    @Override
    public void handleActionEvent(ActionEvent<?> event) {

    }
}
