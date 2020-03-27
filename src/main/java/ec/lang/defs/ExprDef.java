package ec.lang.defs;

public class ExprDef extends BaseDef {
    public String expr;
    public TypeIdDef thisType;

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
        return expr;
    }

    public ExprDef() {
    }

    public ExprDef(String expr) {
        this.expr = expr;
    }
}