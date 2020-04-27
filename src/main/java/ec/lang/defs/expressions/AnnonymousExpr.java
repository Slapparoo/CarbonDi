package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class AnnonymousExpr extends ExprDef {
    public AnnonymousExpr(String value) {
        expr = value;
    }

    @Override
    public String asCode() {
        return "a__" + expr;
    }
}