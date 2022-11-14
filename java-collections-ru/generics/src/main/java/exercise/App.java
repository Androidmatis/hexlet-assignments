package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for (var i = 0; i < books.size(); i++) {
            var coincidence = true;
            Map<String, String> selectedBook = books.get(i);
            for (Map.Entry<String, String> book: where.entrySet()) {
                if (!selectedBook.containsValue(book.getValue())) {
                    coincidence = false;
                }
            }
            if (coincidence) {
                result.add(selectedBook);
            }
        }
        return result;
    }
}
//END
