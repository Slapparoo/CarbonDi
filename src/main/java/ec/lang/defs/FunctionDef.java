package ec.lang.defs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.expressions.ReturnExpr;

public class FunctionDef extends FunctionDefBase implements ContainerDef, Cloneable {
    public TypeIdDef returnType;
    public boolean is_static = false;
    public boolean is_property = false;
    public boolean is_parent = false;

    private static Set<String> STD_OBJECT_METHODS = new HashSet<>();

    static {
        STD_OBJECT_METHODS.addAll(Arrays.asList(new String[] {"asStr", "printTo", "asString", "hashCode", "equals", "release"}));
    }


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

        if (classDef == null && (accessor != null && accessor == Accessor.PUBLIC)) {
            return (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ");";
        }
        return "";
    }

    public String asSignature() {
        if (is_property) {
            return "";
        }

        // if (is_override) {
        //     return "";
        // }

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
            return "\n  " + accessor + " " 
            + (is_static ? "static " : "")
            + (is_final ? "final " : "")
            + (returnType.getName().equals("void") ? "void" : returnType.asSignature()) + " " +name+"("+ paramsAsSignature() +") "+ex+";";
        }
        return "\n  " + accessor + " " 
        + (is_static ? "static " : "")
        + (is_final ? "final " : "")
        + (returnType.getName().equals("void") ? "void" : returnType.asSignature()) + " " +name+"("+ paramsAsSignature() +");";
    }


    @Override
    public void resolve_01() {
        super.resolve_01();

        if (classDef != null) {

            String initSignature = getSignature();

            if (!is_static) {
                VariableDef param = new VariableDef();
                param.setName("this");
                param.type = new TypeIdDef(classDef.name);
                parameters.add(0, param);
            }

            ClassDef cp = classDef.parent;

            String thisSignature = getSignature();

            if (STD_OBJECT_METHODS.contains(name)) {
                // @TODO can remove once Object has a class signature
                is_override = true;
            } else {

                while (cp != null) {
                    
                    for (FunctionDef functionDef : classDef.parent.functionDefs) {
                        if (functionDef.name.equals(name) && !is_parent) {
                            // System.out.println("@@Function override " + name + " " + thisSignature + " == " + functionDef.getSignature());
                            if (thisSignature.equals(functionDef.getSignature()) || initSignature.equals(functionDef.getSignature())) {
                                is_override = true;
                                break;
                            } else {
                                // System.err.println(thisSignature + ", " + is_parent + " != " + functionDef.getSignature()  + ", " + functionDef.is_parent);
                                throw new RuntimeException("method signature overloads are not currently supported, a method with the name " + name + " already exists " + functionDef.getParamsSignature());
                            }
                        }
                    }
                    if (is_override) {
                        break;
                    }
                    cp = cp.parent;
                }
            }
        }
        
        for (VariableDef  param : parameters) {
            if (getBlockDef() != null) {
                getBlockDef().variableDefs.add(param);
            }
        }

        if (getBlockDef() != null) {
            getBlockDef().resolve_01();

            for (StatementDef def : getBlockDef().statementDefs) {
                if (def instanceof ReturnExpr) {
                    if (def.statement.thisType == null) {
                        // System.out.println("@@FunctionDef adjusting return type " + returnType);
                        def.statement.thisType = returnType;
                    } else if (!def.statement.thisType.getName().equals(returnType.getName())) {
                        // System.out.println("@@FunctionDef adjusting return type " + returnType);
                        def.statement.thisType = returnType;
                    }
                }
                // @TODO mine into all the blocks looking for return statements
            }
        }
    }

    // @Override
    // public void prepare_03() {
    //     // System.out.println("*function prepare");
    // }

    private String paramsAsCode() {
        String res = "";
        boolean first = true;

        for(VariableDef param : parameters) {
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

    public String asCode() {
        if (name == null) {
            return "";
        }

        // the function is implemented in the parent class
        if (is_parent) {
            return "";
        }

        // System.out.println("*function asCode " + name );
        return (returnType.getName().equals("void") ? "void" : returnType.asCode()) + (returnType.isIs_array() ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ")" + contentAsCode() ;
    }

    private String paramsAsSignature() {
        String res = "";
        boolean first = true;
        boolean thisParam = true;

        for(VariableDef param : parameters) {
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

    public String getExpandedSignature() {
        return (returnType.getName().equals("void") ? "void" : returnType.asCode())  
        + (returnType.isIs_array() ? "*" : "")  
        + " (*"+ getExpandedName() + ")(" + getParamsSignatureAsCode() + ")";
    }


    public String getSignature() {
        return (returnType.getName().equals("void") ? "void" : returnType.asCode())  
        + (returnType.isIs_array() ? "*" : "")  
        + " (*"+ name + ")(" + getParamsSignature() + ")";
    }

    public String getSignatureAsCode() {
        return (returnType.getName().equals("void") ? "void" : returnType.asCode())  
        + (returnType.isIs_array() ? "*" : "")  
        + " (*"+ name + ")(" + getParamsSignatureAsCode() + ")";
    }


    @Override
    public String toString() {
        return "FunctionDef [accessor=" + accessor + ", blockDef=" + getBlockDef() + ", classDef=" + classDef
                + ", exceptions=" + exceptions + ", fileDef=" + fileDef + ", is_final=" + is_final + ", is_static="
                + is_static + ", name=" + name + ", parameters=" + parameters
                + ", returnType=" + returnType + "]";
    }

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
