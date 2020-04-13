package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.Enums.Accessor;

public abstract class FunctionDefBase extends StatementDef implements ContainerDef {
    public ClassDef classDef; // null or value
    public FileDef fileDef; // probably never null?
    public String name;
    public List<String> exceptions = new ArrayList<>();
    public List<VariableDef> parameters = new ArrayList<>();
    private BlockDef blockDef;
    public Enums.Accessor accessor = Accessor.PUBLIC;
    public boolean is_final = false;
    public boolean is_override = false;
    public boolean is_static = false;

    public int indexNumber = 0;

    public abstract String getSignature();

    public abstract String getExpandedSignature();

    public String getExpandedName() {
        if (indexNumber > 0) {
            return name + "$" + indexNumber;
        }
        return name;
    }

    public String getParamsSignature() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
            // System.out.println("@@FunctionDefBase " + param);
            if (!first) {
                res += ", ";
            }
            // res += param.type.asCode();
            if (param.type == null) {
                res += "bugger";
            } else {
                res += param.type.getName();
            }

            first = false;
        }
        return res;
    }

    public String getParamsSignatureAsCode() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
            // System.out.println("@@FunctionDefBase " + param);
            if (!first) {
                res += ", ";
            }
            res += param.type.asCode();
            first = false;
        }
        return res;
    }


    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        this.blockDef = blockDef;
    }

    @Override
    public void resolve_01() {
        if (accessor == null) {
            accessor = Accessor.PUBLIC;
        }
        super.resolve_01();
    }
}
