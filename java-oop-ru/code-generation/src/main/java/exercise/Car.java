package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
public class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return null;
        }
    }
    public static Car unserialize(String str) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(str, Car.class);
        } catch (Exception e) {
            return null;
        }
    }
    // END
}
