package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> all = new TreeSet<>();
        for (var map : data1.entrySet()) {
            all.add(map.getKey());
        }
        for (var map : data2.entrySet()) {
            all.add(map.getKey());
        }
        for (var key : all) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (data1.containsKey(key)) {
                result.put(key, "deleted");
            } else if (data2.containsKey(key)) {
                result.put(key, "added");
            }
        }
        return result;
    }
}
//END
