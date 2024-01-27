package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String config) {
        var tmpArr = Arrays.stream(config.split("\n"))
                .filter(s -> s.startsWith("environment"))
                .map(s -> s.replaceAll("environment=", ""))
                .map(s -> s.replaceAll("\"", ""))
                .toArray(String[]::new);
        var arrOfArr = Arrays.stream(tmpArr)
                .map(s -> s.split(","))
                .map(s -> Arrays.stream(s).filter(i -> i.startsWith("X_FORWARDED_")).toArray(String[]::new))
                .filter(arr -> arr.length > 0)
                .map(s -> Arrays.stream(s).map(i -> i.replaceAll("X_FORWARDED_", "")).toArray(String[]::new))
                .toArray(String[][]::new);
        var flatArr = Stream.of(arrOfArr)
                .flatMap(item -> Stream.of(item))
                .toArray(String[]::new);
        return String.join(",",flatArr);
    }
}
//END
