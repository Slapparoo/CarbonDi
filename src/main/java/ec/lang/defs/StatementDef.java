package ec.lang.defs;

public class StatementDef extends BaseDef {
    public ExprDef statement;
    // public String asHeader() {
    //     return "";
    // }

    @Override
    public void resolve_01() {
        System.out.println("@@StatementDef.resolve " + this.getClass().getName());
        if (statement != null) {
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