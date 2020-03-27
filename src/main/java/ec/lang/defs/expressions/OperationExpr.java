package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class OperationExpr extends ExprDef {
    public ExprDef left;
    public ExprDef right;

    @Override
    public String asCode() {
        // return " (operator) ";
        return  (left == null ? "(left)" : left.asCode()) + " " + expr + " " + (right == null ? "" : right.asCode());
    }
}