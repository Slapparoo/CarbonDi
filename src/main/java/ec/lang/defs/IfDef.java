package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class IfDef extends StatementDef implements ContainerDef {
    public ExprDef condition;
    public BlockDef blockDef;
    public BlockDef elseblockDef;
    public IfDef elseDef;
    public List<IfDef> elseIfs = new ArrayList<>();

    @Override
    public void resolve_01() {
        condition.resolve_01();
        super.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "if ("+condition.asCode()+") " + blockDef.asCode();
    }

	public BlockDef getBlockDef() {
		return blockDef;
	}

	public void setBlockDef(BlockDef blockDef) {
        System.out.println("(setIfBlock)");
		this.blockDef = blockDef;
	}

    @Override
    public List<VariableDef> variableDefs() {
        return null;
    }
    
}