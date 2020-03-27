package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class BlockDef extends StatementDef implements ContainerDef {
    public List<StatementDef> statementDefs = new ArrayList<>();
    // tracked for validation
    public List<VariableDef> variableDefs = new ArrayList<>();

    public String asHeader() {
        return "";
    }

    @Override
    public void resolve_01() {
        System.out.println("@@BlockDef.resolve ");
        for (StatementDef statementDef : statementDefs) {
            statementDef.resolve_01();
        }
        super.resolve_01();
    }

    public String asCode() {
        String res = "{\n";
        
        for (StatementDef exprDef : statementDefs) {
            if (exprDef instanceof VariableDef) {
                res +=  "/*"+exprDef.getClass()+"*/ " + exprDef.asCode() +";\n";
            } else {
                res +=  "/*"+exprDef.getClass()+"*/ " + exprDef.asCode() +"\n";
            }
        }
        
        return res + "}\n";
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }

    public BlockDef getBlockDef() {
        return this;
    }

    public void setBlockDef(BlockDef blockDef) {
        throw new RuntimeException("Cant set BlockDef of Blockdef");
        // this.blockDef = blockDef;
    }


}