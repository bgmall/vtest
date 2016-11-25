package attributes;

/**
 * Created by msg on 2016/11/23.
 */
public enum AttributeSymbol {

    PHYSICS_ATTK(100, "phy_atk");

    private Integer id;
    private String name;

    AttributeSymbol(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
