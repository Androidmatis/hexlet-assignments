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
        List<Integer> actual1 = App.take(List.of(1, 2, 3, 4, 5), 2);
        assertThat(actual1).isEqualTo(List.of(1, 2));

        List<Integer> actual2 = App.take(List.of(1, 2, 3, 4, 5), 9);
        assertThat(actual2).isEqualTo(List.of(1, 2, 3, 4, 5));

        List<Integer> actual3 = App.take(new ArrayList<>(), 2);
        assertThat(actual3).isEqualTo(new ArrayList<>());
        // END
    }
}
