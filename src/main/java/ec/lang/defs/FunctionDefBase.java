package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.Enums.Accessor;

public abstract class FunctionDefBase extends StatementDef implements ContainerDef {
    public ClassDef classDef; // null or value
    public FileDef fileDef; // probably never null?
    public String name;
    public List<String> exceptions = new ArrayList<>();
    private List<VariableDef> parameters = new ArrayList<>();
    private BlockDef blockDef;
    public Enums.Accessor accessor = Accessor.PUBLIC;
    public boolean is_final = false;
    public boolean is_override = false;
    public boolean is_static = false;

    public void setIsStatic(boolean iss) {
        is_static = iss;
    }

    public int indexNumber = 0;

    public abstract String getSignature();

    public abstract String getExpandedSignature();

    public abstract String asEcSignature();

    public String getExpandedName() {
        if (this instanceof ConstructorDef) {
            if (indexNumber > 0) {
                return classDef.getCName() + "$" + indexNumber;
            }
            return classDef.getCName();                
        }

        if (classDef == null) {
            if (indexNumber > 0) {
                return name + "$" + indexNumber;
            }
            return name;
        } else {
            if (indexNumber > 0) {
                return name + "$" + indexNumber;
            }
            return name;
        }
    }

    public String getParamsSignature() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
            // System.out.println("@@FunctionDefBase " + param);
            if (!first) {
                res += ",";
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
            if (!first) {
                res += ",";
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

        for (VariableDef parameter : getParameters()) {
            if (parameter.getName().length() == 0) {
                if (getBlockDef() != null) {
                    parameter.setName("$" + getBlockDef().getNextAnnoymous());
                }
            }
        }

        super.resolve_01();
    }

    public List<VariableDef> getParameters() {
        return parameters;
    }

    public void insertThis() {
        VariableDef param = new VariableDef();
        param.setName("this");
        param.type = new TypeIdDef(classDef.getFqn());
        parameters.add(0, param);
   }

    public void addParameter(VariableDef parameter) {
        if (parameter.getName().length() == 0) {
            if (getBlockDef() == null && containedInBlock == null) {
                // well
                // System.out.println("Annonymous param with null block..");
            } 

            if (getBlockDef() != null) {
                parameter.setName("$" + getBlockDef().getNextAnnoymous());
            }
        }

        this.parameters.add(parameter);
    }
}
