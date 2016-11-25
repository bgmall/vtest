package attributes;

import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;
import tree.multinode.ArrayMultiTreeNode;

/**
 * Created by msg on 2016/11/23.
 */
public class PropertyEffectMgr extends ArrayMultiTreeNode<PropertyEffect> {

    private final PropertyEffectCalculator calculator;

    public PropertyEffectMgr(String name, PropertyEffectCalculator calculator) {
        super(new PropertyEffect(name, new HashMap<>()));
        this.calculator = calculator;
    }

    public PropertyEffectMgr(String name, int subTreeCount, PropertyEffectCalculator calculator) {
        super(new PropertyEffect(name, new HashMap<>()), subTreeCount);
        this.calculator = calculator;
    }

    private void onPropertyChange(String name) {
        calculate();
        PropertyEffectMgr parent = (PropertyEffectMgr) parent();
        if (parent != null) {
            parent.onPropertyChange(name);
        }
    }

    private Map<Integer, Integer> addTo(Map<Integer, Integer> target, Map<Integer, Integer> plus) {
        Object[] os = plus.keySet().toArray();
        Integer key;
        for (int i = 0; i < os.length; i++) {
            key = (Integer) os[i];
            if (target.containsKey(key)) {
                target.put(key, target.get(key) + plus.get(key));
            } else {
                target.put(key, plus.get(key));
            }
        }
        return target;
    }

    private void calculate() {
        this.data().getAttributes().clear();
        for (TreeNode<PropertyEffect> node : subtrees()) {
            PropertyEffect data = node.data();
            addTo(this.data().getAttributes(), data.getAttributes());
        }
        if (calculator != null) {
            calculator.calculate(this.data());
        }
    }

    public void addPropertyEffect(PropertyEffect effect) {
        TreeNode<PropertyEffect> propertyEffectTreeNode = find(effect);
        if (propertyEffectTreeNode != null) {
            propertyEffectTreeNode.setData(effect);
        } else {
            propertyEffectTreeNode = new ArrayMultiTreeNode<>(effect, 0);
            add(propertyEffectTreeNode);
        }
        onPropertyChange(effect.getName());
    }

    public void removePropertyEffect(PropertyEffect effect) {
        TreeNode<PropertyEffect> propertyEffectTreeNode = find(effect);
        if (propertyEffectTreeNode != null) {
            remove(propertyEffectTreeNode);
        }
        onPropertyChange(effect.getName());
    }
}
