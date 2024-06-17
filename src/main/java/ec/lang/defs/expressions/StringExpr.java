package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class StringExpr extends ExprDef {
    boolean cstring = false;
    boolean resolved = false;

    @Override
    public void resolve_01() {
        resolved = true;

        if (expr.startsWith("`")) {
            cstring = true;
            setThisType(new TypeIdDef("pointer")); // also want pChar for printf
        } else {
            if (expr.startsWith("'''")) {
                // replace lf and cr with \n
                String tmp = expr.substring(3, expr.length() - 3);
                expr = "\"";
                for (byte ch : tmp.getBytes()) {
                    if (ch == 13) {
                        expr += "\\r";
                    } else if (ch == 10) {
                        expr += "\\n";
                    } else if ((char) ch == '\"') {
                        expr += "\\\"";
                    } else {
                        expr += (char) ch;
                    }

                }
                expr += "\"";

            } else if (expr.startsWith("'")) {
                String tmp = expr.substring(1, expr.length() - 1);
                expr = "\"";
                for (byte ch : tmp.getBytes()) {
                    if ((char) ch == '\"') {
                        expr += "\\\"";
                    } else {
                        expr += (char) ch;
                    }
                }
                expr += "\"";
            }

            setThisType(new TypeIdDef("String"));
        }
        super.resolve_01();
    }

    @Override
    public String asCode() {
        if (!resolved) {
            resolve_01();
        }

        if (expr.length() == 3) {
            return expr.replace('`', '\'');
        }

        if (cstring) {
            if (expr.length() == 3) {
                return expr.replace('`', '\'');
            } else if (expr.equals("`\\n`") || expr.equals("`\\r`") || expr.equals("`\\t`")) {
                return expr.replace('`', '\'');
            }
            return expr.replace('`', '"').replaceAll("'", "");
        }

        return "/*se*/ create_c_2106303_String_2(" + expr + ", true)";
    }

    public StringExpr(String value) {
        expr = value;
    }
}