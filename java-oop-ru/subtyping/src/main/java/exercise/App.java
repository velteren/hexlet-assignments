package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage map) {
        Map<String, String> tmp = new HashMap<>(map.toMap());
        System.out.println(tmp.entrySet());
        for (var item: tmp.keySet()) {
            map.unset(item);
            map.set(tmp.get(item), item);
        }
    }
}
// END
