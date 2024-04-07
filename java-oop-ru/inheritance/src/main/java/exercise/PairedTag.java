package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> child;

    public PairedTag(String name, Map<String, String> attributes, String tagBody, List<Tag> child) {
        super(name, attributes);
        this.tagBody = tagBody;
        this.child = child;
    }

    public String getTagBody() {
        return tagBody;
    }

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    public List<Tag> getChild() {
        return child;
    }

    public void setChild(List<Tag> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        var singletag = new SingleTag(getName(), getAttributes());
        String result = singletag.toString();
        result += getTagBody();
        result += getChild().stream()
                .map(element -> element.toString())
                .collect(Collectors.joining());
        result += "</" + getName() + ">";
        return result;
    }
}
// END
