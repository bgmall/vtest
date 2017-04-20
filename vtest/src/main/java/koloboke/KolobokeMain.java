package koloboke;

import com.koloboke.collect.map.hash.HashIntObjMap;
import com.koloboke.collect.map.hash.HashIntObjMaps;

/**
 * Created by msg on 2017/4/20.
 */
public class KolobokeMain {

    public static void main(String[] args) {
        HashIntObjMap<String> map = HashIntObjMaps.newMutableMap();
        map.put(1, "1");

    }
}
