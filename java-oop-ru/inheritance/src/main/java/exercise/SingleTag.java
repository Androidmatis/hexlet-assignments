package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        result.append(getName());
        for(Map.Entry entry : getAttributes().entrySet()) {
            result.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
