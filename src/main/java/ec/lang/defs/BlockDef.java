package ec.lang.defs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockDef extends StatementDef implements ContainerDef {
    public List<StatementDef> statementDefs = new ArrayList<>();
    // tracked for validation
    private List<VariableDef> variableDefs = new ArrayList<>();

    // private List<FunctionDef> functionDefs = new ArrayList<>();

    public boolean includeEntryExit = true;
    public boolean hasReturn = false;
    public boolean isClass = false;
    public ClassDef classDef = null;
    public boolean functionBlock = false;

    public Set<String> directAccess = new HashSet<>();

    public String asHeader() {
        String res = "";
        for (StatementDef exprDef : statementDefs) {
            res += exprDef.asHeader();
        }
        return res;
    }

    @Override
    public void prepare_03() {
        for (StatementDef exprDef : statementDefs) {
            if (exprDef instanceof ContainerDef) {
                ((ContainerDef)exprDef).getBlockDef().directAccess.addAll(directAccess);
            }
        }
    }

    @Override
    public void resolve_01() {

        // for (StatementDef statementDef : statementDefs) {
        //     statementDef.containedInBlock = this;
        //     // System.out.println(this.containedInBlock);
        //     System.out.println("@@statementDef.getClass() " + statementDef.getClass());
        //     if (statementDef instanceof FunctionDef) {
        //         System.out.println("@@function");
        //         functionDefs.add((FunctionDef) statementDef);
        //         statementDef.resolve_01();
        //     }
        // }


        for (StatementDef statementDef : statementDefs) {
            statementDef.containedInBlock = this;
            // System.out.println(this.containedInBlock);
            statementDef.resolve_01();
        }
        super.resolve_01();
    }

    public String statementsAsCode() {
        String res = "";

        for (StatementDef exprDef : statementDefs) {
            // exprDef.containedInBlock = this;
            // exprDef.resolve_01();

            if (exprDef instanceof ContainerDef) {
                ((ContainerDef)exprDef).getBlockDef().includeEntryExit = includeEntryExit;
                ((ContainerDef)exprDef).getBlockDef().directAccess.addAll(directAccess);
            }

            if (exprDef instanceof VariableDef) {
                res +=  exprDef.asCode() +";\n";
            } else {
                res +=  exprDef.asCode() +"\n";
            }
        }

        return res;
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

        res += statementsAsCode();
        
        if (includeEntryExit && !hasReturn) {
            res += "\n__onExit();";
        }
        
        return res + "}\n";
    }


    // public FunctionDef resolveFunction(String name) {
    //     for (FunctionDef fd : functionDefs) {
    //         if (fd.name.equals(name)) {
    //             return fd;
    //         }
    //     }
    //     if (containedInBlock != null) {
    //         return containedInBlock.resolveFunction(name);
    //     } 

    //     return null;
    // }

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
                    if (existingVar.type.getName().equals("?")) {
                        System.out.println("Redefine this " + variableDef.type + " " + existingVar.type);                        
                        existingVar.type = variableDef.type;
                        return;
                    }

                    throw new RuntimeException("Redefinition of existing variable " + variableDef.getName() + " " + existingVar.type + " " + variableDef.type);
                }

                System.out.println("Variable with the same name already exists in block " + variableDef.getName() + " " + variableDef.type + " " + existingVar.type);
            }
        }

        if (variableDef.getName().length() == 0) {
            variableDef.setName("$" + getNextAnnoymous());
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

            if (name.equals("$a")) {
                if (variableDef.getName().equals("a__" +name )) {
                    return variableDef;
                }
            }
    
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

    private char currentAnnoymous = 'a';

	public char getNextAnnoymous() {
        if (containedInBlock != null && currentAnnoymous == 'a') {
            currentAnnoymous = containedInBlock.currentAnnoymous;
        }

        if (currentAnnoymous == 'z') {
            throw new RuntimeException("used up all anonymous values");
        }
        return currentAnnoymous++;
	}
}