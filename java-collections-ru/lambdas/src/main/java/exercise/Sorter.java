package exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static int compareDateString(String str1, String str2) {
        var f = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
        Date d2;
        try {
            d1 = f.parse(str1);
            d2 = f.parse(str2);
            return d1.compareTo(d2);
        } catch (ParseException e) {

        }
        return 0;
    }
    public static final List<String> takeOldestMans(List<Map<String,String>> users) {
        return users.stream()
                .filter(u -> u.get("gender").equals("male"))
                .sorted((s,a) -> compareDateString(s.get("birthday"), a.get("birthday")))
                .map(item -> item.get("name"))
                .toList();
    }
}
// END
