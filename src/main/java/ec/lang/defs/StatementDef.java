package ec.lang.defs;

import ec.lang.defs.expressions.FunctionCallExpr;

public class StatementDef extends BaseDef {
    public ExprDef statement;
    
    // public String asHeader() {
    //     return "";
    // }

    @Override
    public void resolve_01() {
        System.out.println("@@StatementDef.resolve, " + this.getClass().getName() + ", " + containedInBlock);
        if (statement != null) {
            statement.containedInBlock = containedInBlock;
            statement.resolve_01();
        }
        super.resolve_01();
    }

    public String asCode() {
        if (statement != null) {
            return "/**(Statement)*/ " + statement.asCode() + ";";
        }
        return "(Undefined Statement) ";
    }
}