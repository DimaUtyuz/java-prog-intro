package markup;

import java.util.List;

public class Emphasis extends AbstractContainer implements InParagraph {
    public Emphasis(List<InParagraph> list) {
        super(list);
    }

	@Override
    public void toMarkdown(StringBuilder s) {
        super.toMarkdown(s, "*", "*");
    }

	@Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[i]", "[/i]");
    }
}