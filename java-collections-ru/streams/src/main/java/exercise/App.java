package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static final int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .map(item -> (item.split("@"))[1])
                .filter(item -> item.equals("gmail.com") || item.equals("yandex.ru") || item.equals("hotmail.com"))
                .count();
    }
}
// END
