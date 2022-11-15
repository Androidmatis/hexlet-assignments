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
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int requiredListLength1 = 2;
        int sizeNumbers1 = numbers1.size();
        List<Integer> actual1 = App.take(numbers1, requiredListLength1);
        int sizeActual1 = actual1.size();
        numbers1.remove(3);
        numbers1.remove(2);
        assertThat(sizeNumbers1).isGreaterThan(sizeActual1);
        assertThat(sizeActual1).isEqualTo(2);


        List<Integer> numbers2 = new ArrayList<>(Arrays.asList());
        int requiredListLength2 = 2;
        List<Integer> actual2 = App.take(numbers2, requiredListLength2);
        int sizeActual2 = actual2.size();
        assertThat(sizeActual2).isEqualTo(0);


        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(1));
        int requiredListLength3 = 2;
        List<Integer> actual3 = App.take(numbers3, requiredListLength3);
        int sizeActual3 = actual3.size();
        assertThat(sizeActual3).isEqualTo(1);




        //assertThat(sizeActual1).isEqualTo(requiredListLength1);
        // END
    }
}
