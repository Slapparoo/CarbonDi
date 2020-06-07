package ec.lang.defs;

import java.util.List;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.FunctionCallExpr;
import ec.lang.defs.expressions.ReturnExpr;

public class FunctionDef extends FunctionDefBase implements Cloneable {
    public TypeIdDef returnType;
    public boolean is_property = false;
    public boolean is_parent = false;
    public boolean is_builtin = false;

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
        // old function x := void(int, int, int)
        // return "function " + name + ":=" + (returnType.getName().equals("void") ? "void" : returnType.asCode())
        //     + "(" + getParamsSignature() + ")";
        return  (returnType.getName().equals("void") ? "void" : returnType.asCode())
        + " " + name
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
            return "\n /*fns1*/" + accessor + " " 
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
            // throw new RuntimeException("Already resolved..");
            System.out.println("Already resolved.. " + name);
            return;
        }
        super.resolve_01();

        if (classDef != null) {
            if (!is_static) {
                insertThis();
            }

            ClassDef cp = classDef.parent;

            while (cp != null) {
                FunctionDef functionDef = cp.resolveFunction(name);

                if (functionDef != null && !is_parent) {
                    if (functionDef.isCallableVar(returnType, getParameters())) {
                        is_override = true;
                    // } else {
                    } else if (!is_override) {
                        System.out.println(getLine());   
                        System.out.println("method signature overloads are not currently supported, a method with the name " + name + " already exists " + functionDef.getParamsSignature() + " " + classDef.getShortname() );   
                        // throw new RuntimeException("method signature overloads are not currently supported, a method with the name " + name + " already exists " + functionDef.getParamsSignature());
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
                param.containedInBlock = containedInBlock;
                param.resolve_01();
            }
        }

        if (getBlockDef() != null) {

            // System.out.println("@@block " + name +" " + getBlockDef().classDef);

            getBlockDef().resolve_01();

            for (StatementDef def : getBlockDef().statementDefs) {
                if (def instanceof ReturnExpr) {
                    if (def.statement.thisType == null) {
                        def.statement.thisType = returnType;
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
        // boolean thisParam = classDef != null && !is_static && is_override;

        for(VariableDef param : getParameters()) {
            if (param.getName().equals("this")) {
                continue;
            }

            // if (thisParam) {
            //     thisParam = false;
            //     continue;
            // } 
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
        FunctionDef fd = (FunctionDef) super.clone();

        fd.resetResolved();
        fd.is_parent = true;

        return fd;
    }

    @Override
    public String asDoc() {
        String res = "\n`" 
        + (is_override ? "(override) " : "")
        + accessor + " "
        + (is_static ? "static " : "" )
        + (is_final ? "final " : "" )
        + returnType.getName() + " "
        + getExpandedName()+ "("
        + getParamsDoc() + ")"
        + "`\n";
        return res + super.asDoc();
    }

}
