package ec.lang.defs;

import java.util.List;

public interface ContainerDef {
    public List<VariableDef> getVariableDefs();
    public BlockDef getBlockDef();
    public void setBlockDef(BlockDef blockDef);
}