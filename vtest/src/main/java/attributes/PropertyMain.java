package attributes;

import java.util.HashMap;
import java.util.Map;

import genericTree.GenericTree;
import genericTree.GenericTreeNode;

/**
 * Created by msg on 2016/11/23.
 */
public class PropertyMain {

    public static void main(String[] args) {
//        GenericTree<PropertyEffect> propertyTree = new GenericTree<>();
//        GenericTreeNode<PropertyEffect> propertyNode = new GenericTreeNode<>();
//        propertyNode.setData(new PropertyEffect("Equip", new HashMap<>()));
//        propertyTree.setRoot(propertyNode);
//
//        GenericTreeNode<PropertyEffect> propertyChildNode = new GenericTreeNode<>();
//        propertyChildNode.setData(new PropertyEffect("EquipStrength", new HashMap<Integer, Integer>(){{
//            put(AttributeSymbol.PHYSICS_ATTK.getId(), 1000);
//        }}));
//        propertyNode.addChild(propertyChildNode);
        PropertyEffectMgr playerPropertyEffectMgr = new PropertyEffectMgr("Player", 2, new PlayerPropertyEffectCalculator());
        PropertyEffectMgr equipPropertyEffectMgr = new PropertyEffectMgr("Equip", 1, null);
        playerPropertyEffectMgr.add(equipPropertyEffectMgr);
        Map<Integer, Integer> equipAttk = new HashMap<Integer, Integer>() {{
            put(AttributeSymbol.PHYSICS_ATTK.getId(), 1000);
        }};
        PropertyEffect equipStrengthEffect = new PropertyEffect("EquipStrength", equipAttk);
        equipPropertyEffectMgr.addPropertyEffect(equipStrengthEffect);


    }
}
