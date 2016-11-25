package scene;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.GameObject;

/**
 * Created by msg on 2016/11/25.
 */
public class GeneralScene implements Scene {

    private Map<Long, GameObject> sprites = new HashMap<>();

    private Map<Byte, List<GameObject>> typeToSprites = new HashMap<>();

    @Override
    public GameObject getSprite(Long spriteId) {
        return sprites.get(spriteId);
    }

    @Override
    public Collection<GameObject> getSprites(byte spriteType) {
        return typeToSprites.get(spriteType);
    }

    @Override
    public Collection<GameObject> getAroundSprites(Grid grid, int radius) {
        return null;
    }

    @Override
    public void changePosition(GameObject sprite, Grid grid) {

    }

    @Override
    public void enterScene(GameObject sprite) {

    }

    @Override
    public void leaveScene(GameObject sprite) {

    }
}
