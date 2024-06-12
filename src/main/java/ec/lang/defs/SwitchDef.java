package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class SwitchDef extends StatementDef implements ContainerDef {
    private ExprDef exprDef;
    private BlockDef blockDef = new BlockDef();

    public SwitchDef(ExprDef exprDef) {
        this.exprDef = exprDef;
    }

    List<CaseStatement> caseStatements = new ArrayList<>();

    public void addCaseStatement(CaseStatement caseStatement) {
        caseStatements.add(caseStatement);
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
        
        exprDef.containedInBlock = containedInBlock;
        getBlockDef().containedInBlock = containedInBlock;
        getBlockDef().resolve_01();
        exprDef.resolve_01();

        for (CaseStatement caseStatement : caseStatements) {
            caseStatement.containedInBlock = getBlockDef();
            caseStatement.resolve_01();
        }
    }

    public String asHeader() {
        return "";
    }

    public String caseStatementsAsCode() {
        String res = "";

        for (CaseStatement caseStatement : caseStatements) {
            res += "\n" + caseStatement.asCode();    
        }

        return res;
    }

    public String asCode() {
        return "\nswitch (" + exprDef.asCode() + ") {"
        + caseStatementsAsCode()
        + "\n}";
    }

    @Override
    public List<VariableDef> getVariableDefs() {
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
}