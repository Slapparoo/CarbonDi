package ec.lang.defs.expressions;

import ec.lang.defs.ExprDef;

public class IncDecDef extends TypeExpr {
    public IncDecDef(String value) {
        super(value);
    }

    public String prefix = null;
    public String suffix = null;
    public ExprDef expression = null;

    @Override
    public void resolve_01() {
        expression.setContainedInBlock(getContainedInBlock());

        if (expression instanceof MultiTypeExpr) {
            ((MultiTypeExpr)expression).directAccess = true;
        }
        expression.resolve_01();


        super.resolve_01();
    }

    public String asCode() {
        return (prefix == null ? "" : prefix) +expression.asCode()+(suffix == null ? "" : suffix);
    }
}