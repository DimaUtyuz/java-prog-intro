package markup;

import java.util.List;

public class Strong extends AbstractContainer implements InParagraph {
    public Strong(List<InParagraph> list) {
        super(list);
    }

	@Override
    public void toMarkdown(StringBuilder s) {
        super.toMarkdown(s, "__", "__");
    }

	@Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[b]", "[/b]");
    }
}