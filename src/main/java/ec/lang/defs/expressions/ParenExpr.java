package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ParenExpr extends ExprDef {
    public ExprDef enclosed;

    public ParenExpr(ExprDef enclosed) {
        super();
        this.enclosed = enclosed;
    }

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
        if (enclosed != null) {
            enclosed.setContainedInBlock(getContainedInBlock());
            enclosed.resolve_01();
        }
    }
}