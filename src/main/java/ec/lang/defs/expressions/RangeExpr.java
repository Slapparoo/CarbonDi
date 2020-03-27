package ec.lang.defs.expressions;

import ec.lang.defs.*;

/**
 * General purpose used for num, float, bool
 */
public class RangeExpr extends ExprDef {
    public String start;
    public String end;

    public RangeExpr (String range) {
        expr = range;
    }

    @Override
    public void resolve_01() {
        System.out.println("@@RangeExpr.resolve " + expr);

        String[] tokens = expr.split("\\.\\.");
        start = tokens[0];
        end = tokens[1];

        System.out.println("@@RangeExpr.resolve " + tokens.length + ", " + start + ", " + end);

        super.resolve_01();
    }

    @Override
    public String asCode() {
        return start + " " + end;
    }

    @Override
    public String toString() {
        return expr;
    }
}