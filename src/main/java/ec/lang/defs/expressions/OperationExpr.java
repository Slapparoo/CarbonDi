package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class OperationExpr extends ExprDef {
    public ExprDef left;
    public ExprDef right;

    @Override
    public void resolve_01() {
        super.resolve_01();
        left.setContainedInBlock(getContainedInBlock());
        if (left instanceof MultiTypeExpr) {
            ((MultiTypeExpr) left).setIsGet(true);
        }
        left.resolve_01();

        right.setContainedInBlock(getContainedInBlock());
        if (right instanceof MultiTypeExpr) {
            ((MultiTypeExpr) right).setIsGet(true);
        }
        right.resolve_01();

        if (OperatorTypes.COMPARATORS.contains(expr)) {
            this.setThisType(new TypeIdDef("b8"));
        } else {
            this.setThisType(left.getThisType());
        }
    }

    @Override
    public String asCode() {
        return (left == null ? "(left)" : "/*oxa*/" + left.asCode()) + " " + expr + " "
                + (right == null ? "" : "/*oxb*/" + right.asCode());
    }
}