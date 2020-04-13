package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ReturnExpr extends StatementDef {
    // // public ExprDef rExpr;
    // public BlockDef containedInblock;
    boolean resolved = false;

    @Override
    public void resolve_01() {
        resolved = true;
        statement.containedInBlock = containedInBlock;
        statement.resolve_01();

        if (statement instanceof TypeExpr) {
            ((TypeExpr)statement).isGet = true;
        }

        containedInBlock.hasReturn = true;
        super.resolve_01();
    }

    // @Override
    public String asCode() {
        if (!resolved) {
            resolve_01();
        }

        if (statement.thisType == null) {
            return "return __exitReturn_num(" + statement.asCode() + ");";
        }

        if (statement.thisType.isIs_array()) {
            return "return __exitReturn_ref(" + statement.asCode() + ");";
        }

        if (statement.thisType.isPrimative()) {
            return "return __exitReturn_" + statement.thisType.getName() + "(" + statement.asCode() + ");";
        } else {
            return "return __exitReturn_ref(" + statement.asCode() + ");";
        }
    }
}