package ec.lang.defs;

public class StatementDef extends BaseDef {
    public ExprDef statement;
    
    public String asHeader() {
        if (statement != null) {
            return statement.asHeader();
        }
        return "";
    }

    @Override
    public void resolve_01() {
        // System.out.println("@@StatementDef.resolve, " + this.getClass().getName() + ", " + containedInBlock);
        if (statement != null) {
            statement.containedInBlock = containedInBlock;
            if (!statement.isResolved()) {
                statement.resolve_01();
            }
        }
        super.resolve_01();
    }

    public String asCode() {
        if (statement != null) {
            statement.containedInBlock = containedInBlock;
            return "/*st*/ " + statement.asCode() + ";";
        }
        return "(Undefined Statement) ";
    }
}