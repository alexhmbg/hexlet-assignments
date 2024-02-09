package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    String name;
    String attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + "\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
// END
