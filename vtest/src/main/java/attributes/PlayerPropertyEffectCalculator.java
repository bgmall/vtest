package attributes;

/**
 * Created by msg on 2016/11/24.
 */
public class PlayerPropertyEffectCalculator implements PropertyEffectCalculator {

    @Override
    public void calculate(PropertyEffect effect) {
        System.out.println(effect.getAttributes().get(AttributeSymbol.PHYSICS_ATTK.getId()));
    }
}
