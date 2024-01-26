package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        var el = List.of(1,2,3,4,5,6);
        var actual = App.take(el,3);
        var expexted = List.of(1,2,3);
        assertThat(actual).isEqualTo(expexted);
        // END
    }
}
