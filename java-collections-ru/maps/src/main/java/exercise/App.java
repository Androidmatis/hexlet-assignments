package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        if (sentence.equals("")) {
            return words;
        }
        var arrayWords = sentence.split(" ");
        int countRepetition;
        for (var i = 0; i < arrayWords.length; i++) {
            countRepetition = 0;
            for (var i2 = 0; i2 < arrayWords.length; i2++) {
                if (arrayWords[i].equals(arrayWords[i2])) {
                    countRepetition += 1;
                }
            }
            words.put(arrayWords[i], countRepetition);
        }
        return words;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        String result = "";
        for (Map.Entry<String, Integer> entry: wordsCount.entrySet()) {
            result = result + "  " + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        result = "{\n" + result + "}";
        return result;
    }
}
//END
