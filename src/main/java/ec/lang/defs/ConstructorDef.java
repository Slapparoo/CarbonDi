package ec.lang.defs;

import java.util.List;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.FunctionCallExpr;

public class ConstructorDef extends FunctionDefBase implements Cloneable {
    public ConstructorDef() {
        accessor = Accessor.PUBLIC;
    }

    public ConstructorDef(String name) {
        this.name = name;
        accessor = Accessor.PUBLIC;
    }

    public String getExpandedSignature() {
        return String.format(FunctionCallExpr.FUNCTION_SIG_FORMAT,"num", getExpandedName(), getParamsSignatureAsCode());
    }

    public String getSignature() {
        return String.format(FunctionCallExpr.FUNCTION_SIG_FORMAT,"num", name, getParamsSignature());
    }
    
    private String paramsAsHeader() {
        String res = "/* param */";
        boolean first = true;

        for(VariableDef param : getParameters()) {
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

        for(VariableDef param : getParameters()) {
            if (!first) {
                res += ", ";
            }
            res += param.asParameterSignature();
            first = false;
        }
        return res;
    }


    public String asHeader() {
        if (name == null || getParameters().size() == 0) {
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
        if (getParameters().size() == 0) {
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
        for (VariableDef def : getParameters()) {
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
            def_this.classDef = classDef;

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
        
        for (VariableDef  param : getParameters()) {
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

    // private String paramsAsCode() {
    //     String res = "/* param */";
    //     boolean first = true;

    //     // the first param is the class object
    //     for(VariableDef param : getParameters()) {
    //         if (!first) {
    //             res += ", ";
    //         }
    //         res += param.asCode();
    //         first = false;
    //     }
    //     return res;
    // }

    // private String contentAsCode() {

    //     if (classDef == null) {
    //         return (getBlockDef() == null ? "" : getBlockDef().asCode()) +"\n" ;
    //     } else {
    //         if (classDef.classType == Enums.ClassType.PLAN) {
    //             return "";
    //         } else {
    //             // this. will need to be added
    //             return (getBlockDef() == null ? "" : getBlockDef().asCode()) +"\n" ;
    //         }
    //     }
    //     // return "";
    // }

    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return getParameters();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        return super.clone();
    }

    @Override
    public String asEcSignature() {
        return null;
    }
}
