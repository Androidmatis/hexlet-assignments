package exercise;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        var st1 = content.split("environment=\"");
        var listEnv = new ArrayList<String>();
        for (int i = 1; i < st1.length; i++) {
            listEnv.add(st1[i]);
        }
        var resultList = listEnv.stream()
                .map(str -> str.split("\"")[0])
                .map(str -> str.split(","))
                .flatMap(Stream::of)
                .filter(str -> str.startsWith("X_FORWARDED_"))
                .map(str -> str.replaceAll("X_FORWARDED_", ""))
                .toList();
        System.out.println(resultList);
        String result = "";
        for (int i = 0; i < resultList.size() - 1; i++) {
            result += resultList.get(i) + ",";
        }
        result += resultList.get(resultList.size() - 1);
        return result;
    }
}
//END
