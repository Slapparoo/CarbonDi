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

    public long startRange() {
        return Long.parseLong(start);
    }

    public long endRange() {
        return Long.parseLong(end);
    }

    @Override
    public void resolve_01() {
        String[] tokens = expr.split("\\.\\.");
        start = tokens[0];
        end = tokens[1];
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