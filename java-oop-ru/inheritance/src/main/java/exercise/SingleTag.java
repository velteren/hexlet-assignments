package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        var str = "<" + tagName;
        for (var every: attributes.entrySet()) {
            str += " " + every.getKey() + "=\"" + every.getValue() + "\"";
        }
        str += ">";
        return str;
    }
}
// END
