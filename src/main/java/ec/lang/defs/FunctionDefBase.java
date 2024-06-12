package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.ConstExpr;

public abstract class FunctionDefBase extends StatementDef implements ContainerDef, Cloneable {
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
                return classDef.getCName() + "_" + indexNumber;
            }
            return classDef.getCName();                
        }

        if (classDef == null) {
            if (indexNumber > 0) {
                return name + "_" + indexNumber;
            }
            return name;
        } else {
            if (indexNumber > 0) {
                return name + "_" + indexNumber;
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

    public String getParamsDoc() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
            if (param.getName().equals("this")) {
                continue;
            }

            if (!first) {
                res += ",";
            }
            res += param.type.getName() + " ";
            res += param.getName();


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
        for (VariableDef p : parameters) {
            if (p.getName().equals("this")) {
                return;
            }
        }
        


        VariableDef param = new VariableDef();
        param.setName("this");
        param.type = new TypeIdDef(classDef.getFqn());
        param.classDef = classDef;
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

    public boolean isCallable(TypeIdDef returnType,  List<ExprDef> params) {
        if (params.size() != parameters.size()) {
            return false;
        }


        for (int i = 0; i < params.size(); i++) {
            if (!parameters.get(i).compatableWith(params.get(i))) {
                // this would be object / 32 / 64 / ...
                if (params.get(i) instanceof ConstExpr) {
                    // it may be ok
                    // @TODO - better checks
                    continue;
                }

                return false;
            }
        }

        return true;
    }

    public boolean isClassCallable(TypeIdDef returnType,  List<ExprDef> params) {
        if (params.size() + 1 != parameters.size()) {
            return false;
        }


        for (int i = 0; i < params.size(); i++) {
            if (!parameters.get(i + 1).compatableWith(params.get(i))) {
                // this would be object / 32 / 64 / ...
                if (params.get(i) instanceof ConstExpr) {
                    // it may be ok
                    // @TODO - better checks
                    continue;
                }

                return false;
            }
        }

        return true;
    }


    public boolean isCallableVar(TypeIdDef returnType,  List<VariableDef> params) {
        if (params.size() != parameters.size()) {
            return false;
        }


        for (int i = 0; i < params.size(); i++) {
            if (!parameters.get(i).compatableWith(params.get(i))) {
                // this would be object / 32 / 64 / ...
                // if (params.get(i) instanceof ConstExpr) {
                //     // it may be ok
                //     // @TODO - better checks
                //     continue;
                // }

                return false;
            }
        }

        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FunctionDefBase fd = (FunctionDefBase) super.clone();
        fd.parameters = new ArrayList<>(parameters);
        return fd;
    }

    @Override
    public String asDoc() {
        // TODO Auto-generated method stub
        return "<div style=\"margin:1em\">\n\n" + super.asDoc() + "</div>\n\n";
    }


}
