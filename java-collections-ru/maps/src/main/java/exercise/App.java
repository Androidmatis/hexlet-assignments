package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence.isEmpty()) {
            return wordsCount;
        }
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        var result = "{\n";
        for (Map.Entry<String, Integer> map : wordsCount.entrySet()) {
            result += "  " + map.getKey() + ": " + map.getValue() + "\n";
        }
        result += "}";
        return result;
    }
}
//END
