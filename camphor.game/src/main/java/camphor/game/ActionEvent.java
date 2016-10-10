package camphor.game;

/**
 * Created by msg on 2016/10/9.
 */
public class ActionEvent<T> {

    private int id;
    private T data;

    public ActionEvent(int id, T data) {
        this.id = id;
        this.data = data;
    }
}
