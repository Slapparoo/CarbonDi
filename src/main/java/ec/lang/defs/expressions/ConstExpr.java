package ec.lang.defs.expressions;

import ec.lang.defs.*;

/**
 * General purpose used for num, float, bool
 */
public class ConstExpr extends ExprDef {
    String type;

    public ConstExpr (String value) {
        expr = value;
        if (value.equals("true") || value.equals("false")) {
            this.type = "boolean";
        }
    }

    public ConstExpr (String value, String type) {
        expr = value;
        this.type = type;

        if (type != null) {
            if (type.equals("builtin")) {
                if (value.equals("true") || value.equals("false")) {
                    this.type = "boolean";
                } else {
                    this.type = "num";
                }
            } else if (type.equals("float")) {
                this.type = "f64";
            }
        }
    }

    @Override
    public void resolve_01() {
        if (type != null) {
            thisType = new TypeIdDef(type);
        } else {
            thisType = new TypeIdDef("i64");
            type = "i64";
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
            // throw new RuntimeException("/* undefined */ " + expr);
            return "/* undefined */ " + expr;
        }
        if (expr.startsWith("0x") || type.equals("float")) {
            return "/* csf */" + expr.replaceAll("_", "");
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