package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class IfDef extends StatementDef implements ContainerDef {
    public ExprDef condition;
    public BlockDef blockDef;
    // public IfDef elseIfDef;
    public IfDef elseDef;
    private boolean isElse = false;
    private List<IfDef> elseIfs = new ArrayList<>();

    private boolean resolved = false;

    public void addElseIf(IfDef elseDef) {
        elseDef.isElse = true;
        // System.out.println("addElseIf");
        elseIfs.add(elseDef);
    }

    @Override
    public void resolve_01() {
        resolved = true;

        if (getContainedInBlock() == null) {
            throw new RuntimeException("containedInBlock == null");
        }

        if (condition != null) { 
            condition.setContainedInBlock(getContainedInBlock());
            condition.resolve_01();
        }

        blockDef.setContainedInBlock(getContainedInBlock());
        blockDef.resolve_01();

        for (IfDef ifDef : elseIfs) {
            ifDef.setContainedInBlock(getContainedInBlock());
            ifDef.resolve_01();
        }

        super.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        if (!resolved) {
            // System.out.println("if Not resolved.");
            resolve_01();
        }

        if (condition == null) {
            return "/* else? */ else "  + blockDef.asCode();
        }

        return (isElse ? " else " : "") + "if "+condition.asCode()+" " + blockDef.asCode();
    }

	public BlockDef getBlockDef() {
		return blockDef;
	}

	public void setBlockDef(BlockDef blockDef) {
		this.blockDef = blockDef;
	}

    @Override
    public List<VariableDef> getVariableDefs() {
        return null;
    }
    
}