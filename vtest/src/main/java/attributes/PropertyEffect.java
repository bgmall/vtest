package attributes;

import java.util.Map;

/**
 * Created by msg on 2016/11/23.
 */
public class PropertyEffect {

    private final String name;

    private final Map<Integer, Integer> attributes;

    public PropertyEffect(String name, Map<Integer, Integer> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    Map<Integer, Integer> getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEffect that = (PropertyEffect) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PropertyEffect{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
