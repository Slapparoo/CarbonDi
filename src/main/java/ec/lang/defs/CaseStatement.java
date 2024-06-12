package ec.lang.defs;

import java.util.List;

import ec.lang.defs.expressions.RangeExpr;
import ec.lang.defs.expressions.StringExpr;
import lombok.Getter;
import lombok.Setter;

public class CaseStatement extends StatementDef implements ContainerDef {
    @Getter @Setter private BlockDef blockDef = new BlockDef();
    private boolean defaultStatement = false;
    private ExprDef expr;

    public void setExprDef(ExprDef exprDef) {
        this.expr = exprDef;
        defaultStatement = expr.asCode().equals("default");
    }

    public void addStatement(StatementDef statementDef) {
        blockDef.statementDefs.add(statementDef);
    }

    @Override
    public List<VariableDef> getVariableDefs() {
        if (blockDef != null) {
            return blockDef.getVariableDefs();
        }
        return null;
    }

    @Override
    public void resolve_01() {
        if (blockDef != null) {
            blockDef.containedInBlock = containedInBlock;
        }
        
        super.resolve_01();
        expr.resolve_01();
    }

    @Override
    public String asCode() {
        if (defaultStatement) {
            return "\ndefault :" + getBlockDef().statementsAsCode();
        }

        if (expr instanceof RangeExpr) {
            String res = "";
            RangeExpr rx = (RangeExpr)expr;
            for (long i = rx.startRange(); i <= rx.endRange(); i++) {
                res += "\ncase " + i + " :";
            }
            return res + getBlockDef().statementsAsCode();
        }

        if (expr instanceof StringExpr) {
            String val = expr.asCode();
            if (val.startsWith("\"") || val.startsWith("'")) {
                if (val.length() > 3) {
                    throw new RuntimeException("Invalid case String value, expecting one char " + val);
                }
            } else {
                // \n, \r ....
                if (expr.expr.equals("\"\\n\"")) {
                    return "\ncase 13 :" + getBlockDef().statementsAsCode();    
                } else if (expr.expr.equals("\"\\r\"")) {
                    return "\ncase 10 :" + getBlockDef().statementsAsCode();    
                } else if (expr.expr.equals("\"\\t\"")) {
                    return "\ncase 09 :" + getBlockDef().statementsAsCode();    
                } else if (expr.expr.equals("\"\\b\"")) {
                    return "\ncase 08 :" + getBlockDef().statementsAsCode();    
                }
            }
            return "\ncase " + (int)val.charAt(1) + " :" + getBlockDef().statementsAsCode();
        }

        return "\ncase " + expr.asCode() + " :" + getBlockDef().statementsAsCode();
    }
}