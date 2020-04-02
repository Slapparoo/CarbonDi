package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ParenExpr extends ExprDef {
    public ExprDef enclosed;
    @Override
    public String asCode() {
        if (enclosed == null) {
            return "(Null ParenExpr)";
        }

        return "(" + enclosed.asCode() + ")"; 
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
        enclosed.containedInBlock = containedInBlock;
        enclosed.resolve_01();
    }
}