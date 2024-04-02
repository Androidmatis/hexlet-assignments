package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int n) {
        if (list.isEmpty()) {
            return List.of();
        }
        if (n > list.size()) {
            n = list.size();
        }
        return list.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .map(element -> element.toString())
                .collect(Collectors.toList())
                .subList(0, n);
    }
}
// END
