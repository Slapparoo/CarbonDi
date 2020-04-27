package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class BlockDef extends StatementDef implements ContainerDef {
    public List<StatementDef> statementDefs = new ArrayList<>();
    // tracked for validation
    private List<VariableDef> variableDefs = new ArrayList<>();

    public boolean includeEntryExit = true;
    public boolean hasReturn = false;
    public boolean isClass = false;
    public ClassDef classDef = null;
    public boolean functionBlock = false;

    public String asHeader() {
        return "";
    }

    @Override
    public void resolve_01() {
        for (StatementDef statementDef : statementDefs) {
            statementDef.containedInBlock = this;
            // System.out.println(this.containedInBlock);
            statementDef.resolve_01();
        }
        super.resolve_01();
    }

    public String asCode() {
        String res = "{\n";
        
        if (includeEntryExit) {
            if (functionBlock) { 
                res += "\nu64 entry$ = __onEnter();";
            } else {
                res += "\n__onEnter();";
            }
        }

        for (StatementDef exprDef : statementDefs) {
            if (exprDef instanceof ContainerDef) {
                ((ContainerDef)exprDef).getBlockDef().includeEntryExit = includeEntryExit;
            }

            if (exprDef instanceof VariableDef) {
                res +=  exprDef.asCode() +";\n";
            } else {
                res +=  exprDef.asCode() +"\n";
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

    

    public void addVariable(VariableDef variableDef) {
        VariableDef existingVar = resolveVariable(variableDef.getName());
        if (existingVar != null) {
            // replace this -- error on other redines don't add ==
            if (existingVar.getName().equals("this")) {
                // redefine
                System.out.println("Redefine this " + variableDef.type + " " + existingVar.type);
            } else {

                if (existingVar.type.getName().equals(variableDef.type.getName()) ) {

                } else {
                    if (VariableDef.VAR_CHARS.contains(existingVar.type.getName())) {
                        System.out.println("Redefine this " + variableDef.type + " " + existingVar.type);                        
                        existingVar.type = variableDef.type;
                        return;
                    }

                    throw new RuntimeException("Redefinition of existing variable " + variableDef.getName() + " " + existingVar.type + " " + variableDef.type);
                }

                System.out.println("Variable with the same name already exists in block " + variableDef.getName() + " " + variableDef.type + " " + existingVar.type);
            }
        }
        variableDefs.add(variableDef);
    }


    public BlockDef getBlockDef() {
        return this;
    }

    public void setBlockDef(BlockDef blockDef) {
        throw new RuntimeException("Cant set BlockDef of Blockdef");
        // this.blockDef = blockDef;
    }

	public VariableDef resolveVariable(String name) {
        for (VariableDef variableDef : variableDefs) {
            if (variableDef.getName().equals(name)) {
                return variableDef;
            }
        }

        if (containedInBlock != null) {
            VariableDef res = containedInBlock.resolveVariable(name);
            if (res != null) {
                return res;
            }
        }

		return DefFactory.resolveVariable(name);
	}


}