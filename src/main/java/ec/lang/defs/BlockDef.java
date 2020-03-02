package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class BlockDef extends BaseDef implements ContainerDef {
    List<ExprDef> exprDefs = new ArrayList<>();
    // tracked for validation
    List<VariableDef> variableDefs = new ArrayList<>();

    public String asHeader() {
        return "";
    }

    public String asCode() {
        String res = "";
        
        for (ExprDef exprDef : exprDefs) {
            res += exprDef.asCode() + "\n";
        }
        
        return res;
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }

}