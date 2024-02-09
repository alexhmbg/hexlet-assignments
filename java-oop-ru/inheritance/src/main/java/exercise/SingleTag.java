package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }
    public String toString() {
        var isAttributesEmpty = attributes.isEmpty() ? "" : " " + attributes;
        return String.format("<%s%s>", name, isAttributesEmpty);
    }
}
// END
