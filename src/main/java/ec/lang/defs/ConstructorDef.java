package ec.lang.defs;

import java.util.List;

import ec.lang.defs.Enums.Accessor;

public class ConstructorDef extends FunctionDefBase implements ContainerDef, Cloneable {
    public ConstructorDef() {
        accessor = Accessor.PUBLIC;
    }

    public ConstructorDef(String name) {
        this.name = name;
        accessor = Accessor.PUBLIC;
    }


    public String getExpandedSignature() {
        return "num" + " (*"+ getExpandedName() + ")(" + getParamsSignatureAsCode() + ")";
    }


    public String getSignature() {
        return "num" + " (*"+ name + ")(" + getParamsSignature() + ")";
    }

    
    private String paramsAsHeader() {
        String res = "/* param */";
        boolean first = true;

        for(VariableDef param : parameters) {
            if (!first) {
                res += ", ";
            }
            res += param.asCode();
            first = false;
        }
        return res;
    }


    private String paramsAsSignature() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
            if (!first) {
                res += ", ";
            }
            res += param.asParameterSignature();
            first = false;
        }
        return res;
    }


    public String asHeader() {
        if (name == null || parameters.size() == 0) {
            // System.out.println("@@ConstructorDef.asHeader name == null");
            return "";
        }

        return "num create_"+getExpandedName()+"("+ paramsAsHeader() +");";
    }

    String getBlockasCode() {
        // System.out.println(getSignature());
        if (getBlockDef() == null || getBlockDef().statementDefs == null) {
            return "";
        }
        if (getBlockDef().statementDefs.isEmpty()) {
            return "";
        }
        return getBlockDef().asCode();
    }

    public String asCode() {
        if (parameters.size() == 0) {
            return "";
        }

        return "num create_"+getExpandedName()+"("+ paramsAsHeader() +") {"
        + "\nnum this =  create_"+ classDef.getCName()+ "();"
        + "\n" +getSetValuesAsCode()
        + "\n" +getBlockasCode()
        + "\nreturn this;\n}";
    }

    public String asSignature() {
        if (exceptions.size() > 0) {
            String ex = "throws ";
            boolean first = true;
            for (String string : exceptions) {
              ex += string;  
              if (!first) {
                  ex += ",";
              }
              first = false;
            } 
            return accessor + " " +name+"("+ paramsAsSignature() +") "+ex+";";
        }

        return accessor + " " +name+"("+ paramsAsSignature() +");";
    }


    private String getSetValuesAsCode() {
        String res = "";
        for (VariableDef def : parameters) {
            if (def.classDef != null) {
                res += "\n"+SnippetFactory.classModelStatement(name, "this", false)+"->set_"+def.getName()+"(this, "+def.getName()+");";
            }
        }
        return res;
    }

    @Override
    public void resolve_01() {
        super.resolve_01();

        if (classDef == null) {
            throw new RuntimeException("Constructor must have a class " + name);
        }

        if (getBlockDef() != null) {
            VariableDef def_this = new VariableDef();
            def_this.setName("this");
            def_this.type = new TypeIdDef(name);

            getBlockDef().addVariable(def_this);
        }

        ClassDef cp = classDef.parent;

        // String thisSignature = asClassModelDef();
        String thisSignature = "name";

        while (cp != null) {
            FunctionDef functionDef = cp.resolveFunction(name);

            if (functionDef != null) {
                System.out.println("@@Function override " + name + " " + thisSignature + " == " + functionDef.getParamsSignature());
                if (thisSignature.equals(functionDef.getParamsSignature())) {
                    is_override = true;
                } else {
                    throw new RuntimeException("method signature overrides are not currently supported, a method with the name " + name + " already exists " + functionDef.getParamsSignature());
                }
            }

            if (is_override) {
                break;
            }
            cp = cp.parent;
        }
        
        for (VariableDef  param : parameters) {
            param.isParam = true;
            // System.out.println("@@Constructor param type resolving " + param.getName() +" "+ param.type + " "+ param.is_property);
            
            if (param.equalsParam) {
                VariableDef def =  classDef.resolveProperty(param.getName());
                if (def != null) {
                    param.type = def.type;
                    param.classDef = classDef;
                }
            }

            param.containedInBlock = containedInBlock;
            param.resolve_01();
            if (getBlockDef() != null) {
                getBlockDef().addVariable(param);
            }
        }


        if (getBlockDef() != null) {
            getBlockDef().resolve_01();
        }
    }


    @Override
    public void prepare_03() {
    }

    private String paramsAsCode() {
        String res = "/* param */";
        boolean first = true;

        // the first param is the class object
        for(VariableDef param : parameters) {
            if (!first) {
                res += ", ";
            }
            res += param.asCode();
            first = false;
        }
        return res;
    }

    private String contentAsCode() {

        if (classDef == null) {
            return (getBlockDef() == null ? "" : getBlockDef().asCode()) +"\n" ;
        } else {
            if (classDef.classType == Enums.ClassType.PLAN) {
                return "";
            } else {
                // this. will need to be added
                return (getBlockDef() == null ? "" : getBlockDef().asCode()) +"\n" ;
            }
        }
        // return "";
    }

    // private String paramsAsClassModelDef() {
    //     String res = "";
    //     boolean first = true;

    //     // the first param is the class object

    //     for(VariableDef param : parameters) {
    //         if (!first) {
    //             res += ", ";
    //         }
    //         res += param.type.asCode();
    //         first = false;
    //     }
    //     return res;
    // }

    // public String asClassModelDef() {
    //     // @TODO correct this elsewhere
    //     if (org_name == null) {
    //         org_name = name;
    //     }

    //     // i64* (*toLower)(i64 ref);
    //     return (returnType.name.equals("void") ? "void" : returnType.asCode())  + (returnType.is_array ? "*" : "")  + " (*"+ org_name + ")(" + paramsAsClassModelDef() + ")";
    // }
    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return parameters;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }
}
