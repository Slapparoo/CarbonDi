package ec.lang.defs;

import java.util.List;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.FunctionCallExpr;
import ec.lang.defs.expressions.ReturnExpr;

public class FunctionDef extends FunctionDefBase implements Cloneable {
    public TypeIdDef returnType;
    public boolean is_property = false;
    public boolean is_parent = false;

    public FunctionDef() {
        accessor = Accessor.PUBLIC;
    }

    public FunctionDef(String returns, String name) {
        this.name = name;
        this.returnType = new TypeIdDef(returns);
        accessor = Accessor.PUBLIC;
    }

    public String asHeader() {
        if (name == null) {
            return "";
        }

        // if (classDef == null && (accessor != null && accessor == Accessor.PUBLIC)) {
        //     return (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ");";
        // }
        if (classDef == null && (accessor != null && accessor == Accessor.PUBLIC)) {
            return (returnType.getName().equals("void") ? "void" : returnType.asCode()) 
            + " "+ name + "(" + paramsAsCode() + ");";
        }
        return "";
    }

    public String asEcSignature() {
        // function x := void(int, int, int)
        return "function " + name + ":=" + (returnType.getName().equals("void") ? "void" : returnType.asCode())
            + "(" + getParamsSignature() + ")";
    }


    public String asSignature() {
        if (is_property) {
            return "";
        }

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
            return "\n" + accessor + " " 
            + (is_static ? "static " : "")
            + (is_final ? "final " : "")
            + (returnType.getName().equals("void") ? "void" : returnType.asSignature()) + " " +name+"("+ paramsAsSignature() +") "+ex+";";
        }
        return "\n" + accessor + " " 
        + (is_static ? "static " : "")
        + (is_final ? "final " : "")
        + (returnType.getName().equals("void") ? "void" : returnType.asSignature()) + " " +name+"("+ paramsAsSignature() +");";
    }


    @Override
    public void resolve_01() {
        if (isResolved()) {
            throw new RuntimeException("Already resolved..");
        }
        super.resolve_01();

        if (classDef != null) {
            String initSignature = getSignature();

            if (!is_static) {
                insertThis();
            }

            ClassDef cp = classDef.parent;

            String thisSignature = getSignature();

            while (cp != null) {
                FunctionDef functionDef = cp.resolveFunction(name);

                if (functionDef != null && !is_parent) {
                    if (thisSignature.equals(functionDef.getSignature()) || initSignature.equals(functionDef.getSignature())) {
                        is_override = true;
                    } else {
                        throw new RuntimeException("method signature overloads are not currently supported, a method with the name " + name + " already exists " + functionDef.getParamsSignature());
                    }
                }

                if (is_override) {
                    break;
                }
                cp = cp.parent;
            }
        }
        
        for (VariableDef  param : getParameters()) {
            if (getBlockDef() != null) {
                getBlockDef().addVariable(param);
            }
        }

        if (getBlockDef() != null) {
            getBlockDef().resolve_01();

            for (StatementDef def : getBlockDef().statementDefs) {
                if (def instanceof ReturnExpr) {
                    // don't select return null
                    if (def.statement.thisType == null) {
                        def.statement.thisType = returnType;
                    } else if (!def.statement.thisType.getName().equals(returnType.getName())) {
                        // def.statement.thisType = returnType;
                        returnType = def.statement.thisType;
                    // } else {
                    //     if (returnType.getName().equals("null")) {

                    //     } else {
                    //         returnType = def.statement.thisType;                         
                    //     }
                    }
                }
            }
        }
    }


    private String paramsAsCode() {
        String res = "";
        boolean first = true;

        for(VariableDef param : getParameters()) {
            if (!first) {
                res += ", ";
            }
            // code will insert an assigned value
            res += param.asHeader();
            first = false;
        }
        return res;
    }

    private String contentAsCode() {
        if (getBlockDef() != null) {
            getBlockDef().functionBlock = true;
        }
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
    }

    public String asCode() {
        if (name == null) {
            return "";
        }

        // the function is implemented in the parent class
        if (is_parent) {
            return "";
        }

        // return (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "[]" : "")  
        //     + " "+ name + "(" + paramsAsCode() + ")" 
        //     + contentAsCode() ;

        return "/*fd1*/" + (returnType.getName().equals("void") ? "void" : returnType.asCode()) 
            + " "+ name + "(" + paramsAsCode() + ")" 
            + contentAsCode() ;

    }

    private String paramsAsSignature() {
        String res = "";
        boolean first = true;
        boolean thisParam = classDef != null && !is_static;

        for(VariableDef param : getParameters()) {
            if (thisParam) {
                thisParam = false;
                continue;
            } 
            if (!first) {
                res += ", ";
            }
            res += param.asParameterSignature();
            first = false;
        }
        return res;
    }

    private String sigReturnType() {
        if (returnType == null) {
            return "num";
        }
        return (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "*" : "");
    }


    public String getExpandedSignature() {
        return String.format(FunctionCallExpr.FUNCTION_SIG_FORMAT,sigReturnType(), getExpandedName(), getParamsSignatureAsCode());
    }


    public String getSignature() {
        return String.format(FunctionCallExpr.FUNCTION_SIG_FORMAT,sigReturnType(), name, getParamsSignature());
    }

    public String getSignatureAsCode() {
        return String.format(FunctionCallExpr.FUNCTION_SIG_FORMAT,sigReturnType(), name, getParamsSignatureAsCode());
    }

    @Override
    public String toString() {
        return "FunctionDef [accessor=" + accessor + ", blockDef=" + getBlockDef() + ", classDef=" + classDef
                + ", exceptions=" + exceptions + ", fileDef=" + fileDef + ", is_final=" + is_final + ", is_static="
                + is_static + ", name=" + name + ", parameters=" + getParameters()
                + ", returnType=" + returnType + "]";
    }

    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return getParameters();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
