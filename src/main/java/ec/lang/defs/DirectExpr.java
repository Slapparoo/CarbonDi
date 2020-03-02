package ec.lang.defs;

/**
 * Allows the direct defintion of c code
 */
public class DirectExpr extends ExprDef {
    public String value;

    public DirectExpr(String value) {
        this.value = value;
    }

    @Override
    public String asCode() {
        return value;
    }

}