package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
public class App {

    public static boolean scrabble(String symbols, String word) {
        ArrayList<String> coll = new ArrayList<>(Arrays.asList(symbols.split("")));
        for (int i = 0; i < word.length(); i++) {
            String current = word.substring(i, i + 1).toLowerCase();
            if (!coll.contains(current)) {
                return false;
            }
            coll.remove(current);
        }
        return true;
    }
}
//END
