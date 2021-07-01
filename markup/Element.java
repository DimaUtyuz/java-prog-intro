package markup;

public interface Element {
    void toBBCode(StringBuilder s);
    void toMarkdown(StringBuilder s);
}