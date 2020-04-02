package ec.lang.defs.expressions;

import ec.lang.defs.*;

/**
 * General purpose used for num, float, bool
 */
public class ConstExpr extends ExprDef {
    String type;

    public ConstExpr (String value) {
        expr = value;
    }

    public ConstExpr (String value, String type) {
        expr = value;
        this.type = type;
    }

    @Override
    public void resolve_01() {
        System.out.println("@@ConstExpr.resolve " + expr + ", " + type);
        if (type != null) {
            thisType = new TypeIdDef(type);
        } else {
            thisType = new TypeIdDef("num");
            type = "num";
        }

        if (expr.startsWith("$")) {
            // annonymous var
            expr = "a__" + expr.replaceAll("\\$", "");
        }
        super.resolve_01();
    }

    @Override
    public String asCode() {
        if (type == null) {
            return "/* undefined */ " + expr;
        }
        if (expr.startsWith("0x") || type.equals("float")) {
            return expr.replaceAll("_", "");
        }

        if (expr.startsWith("0b")) {
            return Integer.toString((Integer.parseInt(expr.substring(2).replaceAll("_", ""), 2))) + "L";
        }

        return expr;
    }

    @Override
    public String toString() {
        return expr;
    }
}