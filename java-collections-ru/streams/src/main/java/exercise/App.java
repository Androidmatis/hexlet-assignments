package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {

    public static int getCountOfFreeEmails(List<String> emails) {
        long numberEmailsWithDomainGoogle = emails.stream()
            .filter(email -> email.endsWith("gmail.com"))
            .count();
        long numberEmailsWithDomainYandex = emails.stream()
                .filter(email -> email.endsWith("yandex.ru"))
                .count();
        long numberEmailsWithDomainHotmail = emails.stream()
                .filter(email -> email.endsWith("hotmail.com"))
                .count();
        var result = (numberEmailsWithDomainGoogle + numberEmailsWithDomainYandex + numberEmailsWithDomainHotmail);
        return (int) result;
    }
}
// END
