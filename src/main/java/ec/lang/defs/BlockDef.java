package ec.lang.defs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.lang.compiler.Messages;
import lombok.Getter;

public class BlockDef extends StatementDef implements ContainerDef {
    public List<StatementDef> statementDefs = new ArrayList<>();
    // tracked for validation
    @Getter private List<VariableDef> variableDefs = new ArrayList<>();

    private char currentAnnoymous = 'a';
    private int internalUnique = 0;

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
        for (StatementDef statementDef : statementDefs) {
            statementDef.setContainedInBlock(this);
            statementDef.resolve_01();
        }
        super.resolve_01();
    }

    public String statementsAsCode() {
        String res = "";

        for (StatementDef exprDef : statementDefs) {
            if (exprDef.getContainedInBlock() == null) {
                exprDef.setContainedInBlock(this);
                exprDef.resolve_01();
            }

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
        boolean onExit = false;
        
        if (includeEntryExit) {
            if (functionBlock) { 
                onExit = true;
                res += "\nu64 entry__ = __onEnter();";
            }
        }

        res += statementsAsCode();
        
        if (!hasReturn && onExit) {
            res += "\nreturn __exitReturn_void_un(entry__);";
        }
        
        return res + "}\n";
    }

    public void addVariable(VariableDef variableDef) {
        VariableDef existingVar = resolveVariable(variableDef.getName());
        if (existingVar != null) {
            // replace this -- error on other redines don't add ==
            if (existingVar.getName().equals("this")) {
                // redefine
                Messages.MESSAGES.addInfo("no Redefine this " + variableDef.type + " " + existingVar.type);
                return;
            } else {
                if (!existingVar.type.getName().equals(variableDef.type.getName()) ) {
                    if (existingVar.type.getName().equals("?")) {
                        existingVar.type = variableDef.type;
                        return;
                    }

                    // just check this block don't mine
                    boolean found = false;
                    for (VariableDef localvars : variableDefs) {
                        if (localvars.getName().equals(variableDef.getName())) {
                            found = true;
                        }
                    }

                    if (found) {
                        throw new RuntimeException("Redefinition of existing variable " + variableDef.getName() + " " + existingVar.type + " " + variableDef.type);
                    }
                }

                Messages.MESSAGES.addInfo("Variable with the same name already exists in block " + variableDef.getName() + " " + variableDef.type + " " + existingVar.type);
            }
        }

        if (variableDef.getName().length() == 0) {
            variableDef.setName("$" + getNextAnnoymous());
        }

        variableDefs.add(variableDef);
    }


    public VariableDef addAnnoymous(TypeIdDef typeIdDef) {
        VariableDef variableDef = new VariableDef();
        variableDef.setName("$" + getNextAnnoymous());
        variableDef.type = typeIdDef;

        variableDefs.add(variableDef);
        return variableDef;
    }

    public BlockDef getBlockDef() {
        return this;
    }

    public void setBlockDef(BlockDef blockDef) {
        throw new RuntimeException("Cant set BlockDef of Blockdef");
    }

	public VariableDef resolveVariable(String name) {
        for (VariableDef variableDef : variableDefs) {
            if (name.matches("\\$[a-z]")) {
                if (variableDef.getName().equals("a__" +name.charAt(1) )) {
                    return variableDef;
                }
            }
    
            if (variableDef.getName().equals(name)) {
                return variableDef;
            }
        }

        if (statementDefs != null) {
            for (StatementDef sd : statementDefs) {
                if (sd instanceof VariableDef vd) {
                    if (name.equals(vd.getName())) {
                        return vd;
                    }
                }
            }
        }

        if (getContainedInBlock() != null) {
            if (getContainedInBlock() != this) {
                VariableDef res = getContainedInBlock().resolveVariable(name);
                if (res != null) {
                    return res;
                }
            }
        }

		return DefFactory.resolveVariable(name);
	}

	public char getNextAnnoymous() {
        if (getContainedInBlock() != null && currentAnnoymous == 'a') {
            currentAnnoymous = getContainedInBlock().currentAnnoymous;
        }

        if (currentAnnoymous == 'z') {
            throw new RuntimeException("used up all anonymous values");
        }
        return currentAnnoymous++;
    }
    
	public int getNextinternalUnique() {
        if (getContainedInBlock() != null && internalUnique == 0)  {
            internalUnique = getContainedInBlock().getNextinternalUnique();
        }

        return internalUnique++;
    }
}