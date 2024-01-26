package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static final Map<String, Integer> getWordCount(String sentence) {
        if (sentence.isEmpty()) {
            return new HashMap<>();
        }
        var words = Arrays.asList(sentence.split(" "));
        var map = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) return "{}";
        String result = "{\n";
        for (var item: map.keySet()) {
            result += "  " + item + ": " + map.get(item) + "\n";
        }
        result += "}";
        return result;
    }
}
//END
