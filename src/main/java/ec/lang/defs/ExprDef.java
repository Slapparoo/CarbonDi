package ec.lang.defs;

public class ExprDef extends BaseDef {
    public String expr;
    public TypeIdDef thisType;

    public String printType() {
        return "thisType " + (thisType == null ? "(undefined)" : thisType.toString());
    }

    @Override
    public void resolve_01() {
        System.out.println("@@ExprDef.resolve " + this.getClass().getName());
        super.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        if (expr == null) {
            return "(incomplete expr)";
        }

        if (expr.contains("$")) {
            return expr.replaceAll("\\$", "") + "__a";
        }

        return expr;
    }

    public ExprDef() {
    }

    public ExprDef(String expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "ExprDef [expr=" + expr + ", thisType=" + thisType + "] " + super.toString();
    }
}