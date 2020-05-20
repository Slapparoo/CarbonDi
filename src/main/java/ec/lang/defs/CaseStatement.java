package ec.lang.defs;

import java.util.List;

import ec.lang.defs.expressions.RangeExpr;

public class CaseStatement extends StatementDef implements ContainerDef {

    private BlockDef blockDef = new BlockDef();
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
    public List<VariableDef> variableDefs() {
        if (blockDef != null) {
            return blockDef.variableDefs();
        }
        return null;
    }

    @Override
    public BlockDef getBlockDef() {
        return blockDef;
    }

    @Override
    public void setBlockDef(BlockDef blockDef) {
        this.blockDef = blockDef;
    }

    @Override
    public void resolve_01() {
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
        return "\ncase " + expr.asCode() + " :" + getBlockDef().statementsAsCode();
    }
}