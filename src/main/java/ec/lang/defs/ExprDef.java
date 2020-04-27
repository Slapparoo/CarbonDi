package ec.lang.defs;

public class ExprDef extends BaseDef {
    public String expr;
    public TypeIdDef thisType;
    public boolean isProperty = false;

    public String printType() {
        return "thisType " + (thisType == null ? "(undefined)" : thisType.toString());
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        if (expr == null) {
            return "(incomplete expr)";
        }


        if (expr.matches("\\$[a-z]")) {
            
            if (thisType.isIs_array()) {
                if (thisType.getObjectType().equals("RefArray")) {
                    // TODO add RefArray
                    System.out.println("@@ExprDef (RefArray not implemented) " + this.getClass() + " " + expr);
                    return hasNot + "*a__" + expr;
                }
                
                return hasNot + "*a__" + expr;
            } else {
                return hasNot + "a__" + expr;
            }
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
        return "["+this.getClass().getSimpleName()+"] " + expr;
    }
}