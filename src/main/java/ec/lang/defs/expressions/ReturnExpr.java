package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ReturnExpr extends StatementDef {
    boolean resolved = false;
    public TypeIdDef functionReturn = null;

    @Override
    public void resolve_01() {
        resolved = true;

        if (statement != null) {
            statement.setContainedInBlock(getContainedInBlock());
            statement.resolve_01();

            if (statement instanceof TypeExpr) {
                ((TypeExpr) statement).setIsGet(true);
            }
        }

        getContainedInBlock().hasReturn = true;
    }

    public String mapReturnName(String type) {
        if (type.equals("b8")) {
            return "i8";
        }
        return type;

    }

    // @Override
    public String asCode() {
        if (!resolved) {
            resolve_01();
        }

        if (statement == null) {
            return "return __exitReturn_void_un(entry__);";
        }

        if (statement.asCode().equals("null")) {
            return "/*rx3*/__unWindTo(entry__);  return null;";
        }

        if (statement.getThisType().isVoid()) {
            return statement.asCode() + "; return __exitReturn_void_un(entry__);";
        }

        if (statement.getThisType() == null) {
            return "return __exitReturn_num_un(" + statement.asCode() + ", entry__);";
        }

        if (statement.getThisType().isIs_array()) {
            return "/*rx1*/ return __exitReturn_ref_un(" + statement.asCode() + ", entry__);";
        }

        if (statement.getThisType().isPrimative()) {
            return "return __exitReturn_" + mapReturnName(statement.getThisType().getName()) + "_un("
                    + statement.asCode() + ", entry__);";
        } else {
            // Make the assumption that Clib generally returns int
            if (statement.getThisType().getName().equals("External")) {
                return "/*rx2*/ return __exitReturn_" + mapReturnName(functionReturn.getName()) + "_un("
                        + statement.asCode() + ", entry__);";
            }
            return "/*rx4*/ return __exitReturn_ref_un(" + statement.asCode() + ", entry__);";
        }
    }
}