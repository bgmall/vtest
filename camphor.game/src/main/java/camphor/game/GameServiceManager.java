package camphor.game;

import camphor.game.annotations.ComponentAnno;
import camphor.game.annotations.GameServiceAnno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msg on 2016/10/9.
 */
public class GameServiceManager {

    private final Map<Short, String> actionEventIdToComponentClassName = new HashMap<>();
    private final Map<String, List<String>> gameEventIdToComponentClassName = new HashMap<>();
    private final Map<String, List<Class<? extends Component>>> gameObjectNameToComponentClass = new HashMap<>();
    private final Map<String, List<String>> gameServiceNameToGameObjectName = new HashMap<>();

    public void addComponent(Component component) {
        ComponentAnno annotation = component.getClass().getAnnotation(ComponentAnno.class);
        for (String gameEventId : annotation.gameEventIds()) {

        }
    }

    private void addGameEventIdToComponent(String gameEventId, Component component) {
        List<String> gameEventIds = gameEventIdToComponentClassName.get(gameEventId);
        if (gameEventIds == null) {
            gameEventIds = new ArrayList<>();
            gameEventIdToComponentClassName.put(gameEventId, gameEventIds);
        }
        if (gameEventIds.contains(component.getClass().getName())) {

        }
    }
}
