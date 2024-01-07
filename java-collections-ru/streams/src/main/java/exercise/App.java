package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails (List<String> emails) {
        var count = emails.stream()
                .filter(email -> !email.endsWith("@gmail.com"))
                .filter(email -> !email.endsWith("@yandex.ru"))
                .filter(email -> !email.endsWith("@hotmail.com"))
                .count();
        return emails.size() - count;
    }
}
// END
