package jackson;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by msg on 2017/3/16.
 */
public class SimpleClass {

    private int value;

    private AtomicInteger integer = new AtomicInteger(0);

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AtomicInteger getInteger() {
        return integer;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "value=" + value +
                ", integer=" + integer +
                '}';
    }
}
