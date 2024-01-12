package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        return people.stream()
                .filter(human -> human.get("gender").equals("male"))
                .sorted(Comparator.comparing(m -> LocalDate.parse(m.get("birthday"))))
                .map(map -> map.get("name"))
                .collect(Collectors.toList());
    }
}
// END
