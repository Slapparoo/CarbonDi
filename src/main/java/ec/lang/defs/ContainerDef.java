package ec.lang.defs;

import java.util.List;

public interface ContainerDef {
    public List<VariableDef> variableDefs();
    public BlockDef getBlockDef();
    public void setBlockDef(BlockDef blockDef);
}