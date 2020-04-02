package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class BlockDef extends StatementDef implements ContainerDef {
    public List<StatementDef> statementDefs = new ArrayList<>();
    // tracked for validation
    public List<VariableDef> variableDefs = new ArrayList<>();

    public boolean includeEntryExit = true;
	public boolean hasReturn = false;

    public String asHeader() {
        return "";
    }

    @Override
    public void resolve_01() {
        // System.out.println("@@BlockDef.resolve vars=" + variableDefs);
        for (StatementDef statementDef : statementDefs) {
            System.out.println("@@BlockDef.resolve " + statementDef.getClass() + ", " + statementDef);
            statementDef.containedInBlock = this;

            statementDef.resolve_01();
        }
        super.resolve_01();
    }

    public String asCode() {
        String res = "{\n";
        
        if (includeEntryExit) {
            res += "\n__onEnter();";
        }

        for (StatementDef exprDef : statementDefs) {
            if (exprDef instanceof VariableDef) {
                res +=  "/*"+exprDef.getClass()+"*/ " + exprDef.asCode() +";\n";
            } else {
                res +=  "/*"+exprDef.getClass()+"*/ " + exprDef.asCode() +"\n";
            }
        }
        
        if (includeEntryExit && !hasReturn) {
            res += "\n__onExit();";
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

	public VariableDef resolveVariable(String name) {
        // System.out.println("@@BlockDef.resolveVariable " + name + " : " + variableDefs);
        for (VariableDef variableDef : variableDefs) {
            if (variableDef.getName().equals(name)) {
                return variableDef;
            }
        }

        if (containedInBlock != null) {
            containedInBlock.resolveVariable(name);
        }

		return DefFactory.resolveVariable(name);
	}


}