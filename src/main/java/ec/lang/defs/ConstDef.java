package ec.lang.defs;

public class ConstDef extends ExprDef {
    public String value;

    @Override
    public String asHeader() {
        return value;
    }

    @Override
    public String asCode() {
        return value;
    }
}