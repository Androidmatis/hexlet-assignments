package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static Integer getCountOfFreeEmails(List<String> emailsList) {
        var domains = List.of("gmail.com", "yandex.ru", "hotmail.com");
        return emailsList.stream()
                .map(email -> email.split("@"))
                .map(email -> email[1])
                .filter(domain -> domains.contains(domain))
                .toList().size();
    }
}
// END
