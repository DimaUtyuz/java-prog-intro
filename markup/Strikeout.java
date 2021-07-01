package markup;

import java.util.List;

public class Strikeout extends AbstractContainer implements InParagraph {
    public Strikeout(List<InParagraph> list) {
        super(list);
    }

	@Override
    public void toMarkdown(StringBuilder s) {
        super.toMarkdown(s, "~", "~");
    }

	@Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[s]", "[/s]");
    }
}