package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class OperationExpr extends ExprDef {
    public ExprDef left;
    public ExprDef right;

    @Override
    public void resolve_01() {
        super.resolve_01();
        left.containedInBlock = containedInBlock;
        if (left instanceof TypeExpr) {
            ((TypeExpr)left).isGet = true;
        }
        left.resolve_01();
        
        right.containedInBlock = containedInBlock;
        if (right instanceof TypeExpr) {
            ((TypeExpr)right).isGet = true;
        }
        right.resolve_01();


        this.thisType = left.thisType;
    }

    @Override
    public String asCode() {
        // return " (operator) ";
        return  (left == null ? "(left)" : left.asCode()) + " " + expr + " " + (right == null ? "" : right.asCode());
    }
}