package service;

/**
 * Created by 37 on 2016/9/23.
 */
public class GameEvent<T> {

    private final String id;
    private final T data;

    private GameEvent(String id, T data) {
        this.data = data;
        assert (id != null && id.trim().length() > 0);
        this.id = id.intern();
    }

    private GameEvent(String id) {
        this(id, null);
    }

    public static GameEvent<?> getInstance(String id) {
        return new GameEvent(id);
    }

    public boolean isId(String id) {
        assert (id != null);
        return this.id == id.intern();
    }

    public String getId() {
        return id;
    }

    public T getData() {
        return data;
    }
}
