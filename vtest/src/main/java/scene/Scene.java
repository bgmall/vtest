package scene;

import java.util.Collection;
import java.util.Map;

import service.GameObject;

/**
 * Created by msg on 2016/11/24.
 */
public interface Scene {

    GameObject getSprite(Long spriteId);

    Collection<GameObject> getSprites(byte spriteType);

    Collection<GameObject> getAroundSprites(Grid grid, int radius);

    void changePosition(GameObject sprite, Grid grid);

    void enterScene(GameObject sprite);

    void leaveScene(GameObject sprite);
}
