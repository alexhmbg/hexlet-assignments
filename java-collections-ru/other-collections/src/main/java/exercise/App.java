package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();
        Set<String> setOfKeys = new TreeSet<>();
        setOfKeys.addAll(map1.keySet());
        setOfKeys.addAll(map2.keySet());

        for (var key : setOfKeys) {
            var key1 = map1.get(key);
            var key2 = map2.get(key);

            if (key1 != null && key1.equals(key2)) {
                resultMap.put(key, "unchanged");
            } else if (key1 != null && key2 != null) {
                resultMap.put(key, "changed");
            } else if (key1 == null) {
                resultMap.put(key, "added");
            } else {
                resultMap.put(key, "deleted");
            }
        }

        return resultMap;
    }
}
//END
