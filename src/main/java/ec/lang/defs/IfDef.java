package ec.lang.defs;

public class IfDef extends ExprDef {
    public ExprDef condition;
    public BlockDef content;
    public BlockDef elseContent;
    public IfDef elseIf;

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }
}