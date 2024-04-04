package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage db) {
        var map = db.toMap();
        for(Entry entry : map.entrySet()) {
            var key = entry.getValue().toString();
            var value = entry.getKey().toString();
            db.unset(value);
            db.set(key, value);
        }
    }
}
// END
