package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> book) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> bk : books) {
            var find = true;
            for (Map.Entry<String, String> mp : book.entrySet()) {
                if (!(bk.containsKey(mp.getKey()) && (bk.get(mp.getKey())).equals(mp.getValue()))) {
                    find = false;
                    break;
                }
            }
            if (find) {
                result.add(bk);
            }
        }
        return result;
    }
}
//END
