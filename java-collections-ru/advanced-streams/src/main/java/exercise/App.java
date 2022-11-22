package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String config) {
//        String content = Files.readString("s.conf");
        String result = "";
        String prefix = "X_FORWARDED_";
        String[] spritEnvironment = config.split("environment=\"");
        for (var n = 0; n < spritEnvironment.length - 1; n++) {
            String[] variablesAll = spritEnvironment[n + 1].split("\"");
            String[] variables = variablesAll[0].split(",");
            for (var i = 0; i < variables.length; i++) {
                if (variables[i].startsWith(prefix)) {
                    if (i == 0 && n == 0) {
                        result = result + variables[i];
                    } else {
                        result = result + "," + variables[i];
                    }
                }
            }
        }
        result = result.replaceAll(prefix, "");
        return result;
    }


}
//END
