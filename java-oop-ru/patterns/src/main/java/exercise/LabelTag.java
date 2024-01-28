package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface someTage;

    public LabelTag(String text, TagInterface someTage) {
        this.text = text;
        this.someTage = someTage;
    }

    @Override
    public String render() {
        return "<label>" + text + someTage.render() + "</label>";
    }
}
// END
