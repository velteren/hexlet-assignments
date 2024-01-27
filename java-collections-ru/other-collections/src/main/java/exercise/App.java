package exercise;

import java.util.*;

// BEGIN
public class App {
    public static LinkedHashMap<String,String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        var result = new LinkedHashMap<String,String>();
        SortedSet<String > set = new TreeSet(Comparator.naturalOrder()) {};
        set.addAll(data1.keySet());
        set.addAll(data2.keySet());
        for (var setItem: set) {
            if (data1.containsKey(setItem) && data2.containsKey(setItem)) {
                if (data1.get(setItem) == data2.get(setItem)) {
                    result.put(setItem, "unchanged");
                } else {
                    result.put(setItem, "changed");
                }
            }
            if (!data1.containsKey(setItem) && data2.containsKey(setItem)) {
                result.put(setItem, "added");
            }
            if (data1.containsKey(setItem) && !data2.containsKey(setItem)) {
                result.put(setItem, "deleted");
            }

        }
        System.out.println(result);
        return result;
    }
}
//END
