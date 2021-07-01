package markup;

import java.util.List;

public class Paragraph extends AbstractContainer implements InList {
    public Paragraph(List<InParagraph> list) {
        super(list);
    }
	
	@Override
    public void toMarkdown(StringBuilder s) {
        super.toMarkdown(s, "", "");
    }
	
	@Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "", "");
    }
}