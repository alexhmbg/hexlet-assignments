package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> tags;

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> tags) {
        super(name, attributes);
        this.body = body;
        this.tags = tags;
    }

    public String toString() {
        var isAttributesEmpty = attributes.isEmpty() ? "" : " " + attributes;
        var stringTag = tags.stream().map(Object::toString).collect(Collectors.joining());
        return String.format("<%s%s>%s%s</%s>", name, isAttributesEmpty, body, stringTag, name);
    }
}
// END