package markup;

import java.util.List;

public abstract class AbstractContainer implements Element {
    private final List<? extends Element> list;

    public AbstractContainer(List<? extends Element> list) {
        this.list = list;
    }

    protected void toBBCode(StringBuilder s, String left, String right) {
        s.append(left);
        for (Element element : list) {
            element.toBBCode(s);
        }
        s.append(right);
    }

    protected void toMarkdown(StringBuilder s, String left, String right) {
        s.append(left);
        for (Element element : list) {
            element.toMarkdown(s);
        }
        s.append(right);
    }
}
