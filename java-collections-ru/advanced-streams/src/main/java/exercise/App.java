package exercise;

import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String conf) {
        var confLinesArray = conf.split("\n");
        var splitEnvironmentLines = Arrays.stream(confLinesArray)
                .filter(n -> n.startsWith("environment"))
                .map(n -> n.replaceAll("\"", " ")
                        .replaceAll(",", " ")
                        .split(" "))
                .flatMap(Arrays::stream)
                .toList();

        var finalString = splitEnvironmentLines.stream()
                .filter(n -> n.startsWith("X_FORWARDED_"))
                .map(n -> n.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return finalString;
    }
}
//END
