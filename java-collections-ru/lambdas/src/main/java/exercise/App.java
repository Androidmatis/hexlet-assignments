package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public  static String[][] enlargeArrayImage(String[][] image) {

        return Arrays.stream(image)
                .map(item -> duplicateValues(item))
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .toArray(String[][]::new);
    }

    public static String[] duplicateValues(String[] items) {
        return Arrays.stream(items)
                .flatMap(item -> Arrays.stream(new String[] {item, item}))
                .toArray(String[]::new);
    }
}
// END
