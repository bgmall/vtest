package scene.map.grid;

/**
 * Created by msg on 2016/12/1.
 */
public class Grid {

    private final short row;

    private final short column;

    private final byte code;

    public Grid(short row, short column, byte code) {
        this.row = row;
        this.column = column;
        this.code = code;
    }
}
