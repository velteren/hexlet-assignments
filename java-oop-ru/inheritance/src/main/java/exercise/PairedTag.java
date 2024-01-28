package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    protected String bodyOfTag;
    protected List<Tag> children;
    public PairedTag(String tagName, Map<String, String> attributes, String bodyOfTag, List<Tag> children) {
        super(tagName, attributes);
        this.bodyOfTag = bodyOfTag;
        this.children = children;
    }

    @Override
    public String toString() {
        var str = "<" + tagName;
        for (var every: attributes.entrySet()) {
            str += " " + every.getKey() + "=\"" + every.getValue() + "\"";
        }
        str += ">";
        str += bodyOfTag;
        for (var item: children) {
            str += item.toString();
        }
        str += "</" + tagName + ">";
        return str;
    }
}
// END
