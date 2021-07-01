package markup;

import java.util.List;

public class OrderedList extends AbstractContainer implements InList {
    public OrderedList(List<ListItem> list) {
        super(list);
    }

    @Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[list=1]", "[/list]");
    }

    @Override
    public void toMarkdown(StringBuilder s) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("OrderedList doesn't support markdown");
    }
}
