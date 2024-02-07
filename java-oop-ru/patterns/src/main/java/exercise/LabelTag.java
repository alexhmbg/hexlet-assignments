package exercise;

// BEGIN
class LabelTag implements TagInterface {
    String label;
    TagInterface tag;

    LabelTag(String label, TagInterface tag) {
        this.label = label;
        this.tag = tag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", label, tag.render());
    }
}
// END
