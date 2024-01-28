package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static final void save(Path path, Car car) {
        try {
            String str = car.serialize();
            Files.writeString(path, str, StandardOpenOption.WRITE);
        } catch (Exception e) {

        }
    }
    public static final Car extract(Path path) {
        try {
            String content = Files.readString(path);
            return Car.unserialize(content);
        } catch (Exception e) {
            return null;
        }
    }
}

// END
