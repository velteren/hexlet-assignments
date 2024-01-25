package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static final boolean scrabble(String letters, String word) {
        var letterList = new ArrayList<>(Arrays.asList(letters.toLowerCase().split("")));
        var wordList = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        for (var item: wordList) {
            if (!letterList.remove(item)) {
                return false;
            }
        }
        return true;
    }
}
//END
