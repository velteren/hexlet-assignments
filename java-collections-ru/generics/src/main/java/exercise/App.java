package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String,String>> findWhere(List<Map<String,String>> books, Map<String,String> dictionary) {
        var list = new ArrayList<Map<String,String>> ();
        for (var book: books) {
            boolean isCorrectBook = true;
            for (var item: dictionary.entrySet()) {
                if (!(book.containsKey(item.getKey()) && book.get(item.getKey()).equals(item.getValue()))) {
                    isCorrectBook = false;
                }
            }
            if (isCorrectBook) {
                list.add(book);
            }
        }
        System.out.println("list: " + list);
        return list;
    }
}
//END
