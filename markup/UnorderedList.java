package markup;

import java.util.List;

public class UnorderedList extends AbstractContainer implements InList {
    public UnorderedList(List<ListItem> list) {
        super(list);
    }

    @Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[list]", "[/list]");
    }

    @Override
    public void toMarkdown(StringBuilder s) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("UnorderedList doesn't support markdown");
    }
}
