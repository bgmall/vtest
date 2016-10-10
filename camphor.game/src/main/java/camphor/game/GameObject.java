package camphor.game;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 37 on 2016/9/30.
 */
public final class GameObject implements Component {

    private Long id;
    private GameService service;
    private ArrayList<Component> components;
    private Map<String, Component> tags;

    public GameObject() {

    }

    void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    void setService(GameService service) {
        this.service = service;
    }

    public GameService getService() {
        return this.service;
    }

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

    @Override
    public void setParent(GameObject parent) {

    }

    @Override
    public void handleGameEvent(GameEvent<?> event) {

    }

    @Override
    public void handleActionEvent(ActionEvent<?> event) {

    }
}
