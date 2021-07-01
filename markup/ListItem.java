package markup;

import java.util.List;

public class ListItem extends AbstractContainer {
    public ListItem(List<InList> list){
        super(list);
    }

    @Override
    public void toBBCode(StringBuilder s) {
        super.toBBCode(s, "[*]", "");
    }

    @Override
    public void toMarkdown(StringBuilder s) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("ListItem doesn't support markdown");
    }
}
