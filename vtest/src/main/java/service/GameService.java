package service;

/**
 * Created by 37 on 2016/9/23.
 */
public interface GameService {

    String getId();

    void addGameEventListener(String eventId, GameEventListener eventListener);

    void removeGameEventListener(String eventId, GameEventListener eventListener);

    void pollGameEvent();

    void fireGameEvent();

    void sendGameEvent();

    void sendSyncGameEvent();

    void addActionEventListener();

    void removeActionEventListener();
}
