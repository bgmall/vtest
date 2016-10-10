package camphor.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msg on 2016/10/9.
 */
public class GameObjectManager {

    private Map<Long, GameObject> objects;

    public GameObjectManager() {
        objects = new HashMap<>();
    }

    public GameObject getObjectById(Long id) {
        return objects.get(id);
    }
}
