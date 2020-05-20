package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class AnonymousExpr extends ExprDef {
    public AnonymousExpr(String value) {
        expr = value;
    }

    @Override
    public String asCode() {
        return "a__" + expr;
    }
}