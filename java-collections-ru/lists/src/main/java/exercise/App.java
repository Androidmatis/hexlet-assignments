package exercise;

import java.util.ArrayList;

// BEGIN
class App {

    public static boolean scrabble(String chars, String word) {
        ArrayList<String> arrayChars = new ArrayList<>();
        chars = chars.toLowerCase();
        word = word.toLowerCase();
        for (var i = 0; i < chars.length(); i++) {
            arrayChars.add(Character.toString(chars.charAt(i)));
        }
        if (arrayChars.isEmpty()) {
            return false;
        }
        String charWord = "";
        for (var i2 = 0; i2 < word.length(); i2++) {
            charWord = Character.toString(word.charAt(i2));
            for (var i3 = 0; i3 < arrayChars.size(); i3++) {
                if (charWord.equals(arrayChars.get(i3))) {
                    arrayChars.remove(i3);
                    break;
                }
                if (i3 + 1 == arrayChars.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}
//END
