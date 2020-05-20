package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ReturnExpr extends StatementDef {
    // // public ExprDef rExpr;
    // public BlockDef containedInblock;
    boolean resolved = false;

    @Override
    public void resolve_01() {
        resolved = true;

        if (statement != null) {
            statement.containedInBlock = containedInBlock;
            statement.resolve_01();

            if (statement instanceof TypeExpr) {
                ((TypeExpr)statement).setIsGet(true);
            }
        }

        containedInBlock.hasReturn = true;
        super.resolve_01();
    }

    // @Override
    public String asCode() {
        if (!resolved) {
            resolve_01();
        }

        if (statement == null) {
            return "return __exitReturn_void_un(entry$);";
        }

        if (statement.thisType.isVoid()) {
            return statement.asCode()+"; return __exitReturn_void_un(entry$);";
        }

        if (statement.thisType == null) {
            return "return __exitReturn_num_un(" + statement.asCode() + ", entry$);";
        }


        if (statement.thisType.isIs_array()) {
            return "/*rx1*/ return __exitReturn_ref_un(" + statement.asCode() + ", entry$);";
        }

        if (statement.thisType.isPrimative()) {
            return "return __exitReturn_" + statement.thisType.getName() + "_un(" + statement.asCode() + ", entry$);";
        } else {
            return "/*rx2*/ return __exitReturn_ref_un(" + statement.asCode() + ", entry$);";
        }
    }
}