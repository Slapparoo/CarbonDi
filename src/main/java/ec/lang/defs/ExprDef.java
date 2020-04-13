package ec.lang.defs;

public class ExprDef extends BaseDef {
    public String expr;
    public TypeIdDef thisType;
    public boolean isProperty = false;

    public String printType() {
        return "thisType " + (thisType == null ? "(undefined)" : thisType.toString());
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        if (expr == null) {
            return "(incomplete expr)";
        }

        // @TODO this needs to improve

        if (expr.matches("\\$[a-z]")) {
            return expr.replaceAll("(\\$)([a-z])", "$2__a") ;
        }

        return hasNot + expr;
    }

    public ExprDef() {
    }

    public ExprDef(String expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "ExprDef ln="+getLine()+" [expr=" + expr + ", thisType=" + thisType + "] " + super.toString();
    }
}