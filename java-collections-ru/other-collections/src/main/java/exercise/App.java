package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> map1: data1.entrySet()) {
            if (!data2.containsKey(map1.getKey())) {
                result.put(map1.getKey(), "deleted");
            }
            for (Map.Entry<String, Object> map2: data2.entrySet()) {
                String key1 = map1.getKey();
                String key2 = map2.getKey();
                String value1 = map1.getValue().toString();
                String value2 = map2.getValue().toString();
                if (key1.equals(key2)) {
                    if (value1.equals(value2)) {
                        result.put(map1.getKey(), "unchanged");
                    } else {
                        result.put(map1.getKey(), "changed");
                    }
                }
            }
        }
        for (Map.Entry<String, Object> map2: data2.entrySet()) {
            if (!data1.containsKey(map2.getKey())) {
                result.put(map2.getKey(), "added");
            }
        }
        return result;

    }
}
//END
