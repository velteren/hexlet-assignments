package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (var f: fields) {
                f.setAccessible(true);
                Object value = f.get(obj);
                var ann = f.getAnnotation(NotNull.class);
                if (ann != null && value == null) {
                    result.add(f.getName());
                }
            }
        } catch (Exception e) {

        }
        return result;
    }
}
// END
