package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static final List<String> buildApartmentsList(List<Home> homes, int len) {
        if (homes.isEmpty()) {
            return new ArrayList<String>();
        }
        var sorted = homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(Object::toString)
                .toList();
        return sorted.subList(0, len);
    }
}
// END
