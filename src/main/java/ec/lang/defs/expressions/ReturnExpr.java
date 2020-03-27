package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ReturnExpr extends StatementDef {
    // // public ExprDef rExpr;

    // @Override
    public String asCode() {
        return "return " + statement.asCode() + ";";
    }
}