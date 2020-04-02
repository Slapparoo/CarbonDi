package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.Enums.Accessor;

public class FunctionDef extends StatementDef implements ContainerDef {
    public ClassDef classDef; // null or value
    public FileDef fileDef; // probably never null?
    public String name;
    public String org_name;
    public List<String> exceptions = new ArrayList<>();
    public List<VariableDef> parameters = new ArrayList<>();
    public TypeIdDef returnType;
    private BlockDef blockDef;
    public Enums.Accessor accessor;
    public boolean is_static;
    public boolean is_final;

    public FunctionDef() {
    }

    public FunctionDef(String returns, String name) {
        this.name = name;
        this.returnType = new TypeIdDef(returns);
    }

    public String asHeader() {
        // not required for class functions
        // only for public

        System.out.println(this);

        if (name == null) {
            return "";
        }

        if (classDef == null && (accessor != null && accessor == Accessor.PUBLIC)) {
            return (returnType.name.equals("void") ? "void" : returnType.asCode()) + (returnType.is_array ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ")";
        }
        return "";
    }

    @Override
    public void resolve_01() {
        // System.out.println("@@FunctionDef.resolve_01");
        super.resolve_01();

        if (classDef != null) {
            VariableDef param = new VariableDef();
            param.setName("this");
            param.type = new TypeIdDef(classDef.name);
            parameters.add(0, param);
            // System.out.println("@@FunctionDef.resolve add param " + param );
        }
        
        for (VariableDef  param : parameters) {
            // System.out.println("@@FunctionDef.resolve resolve param " + param );
            // param.resolve_01();
            if (blockDef != null) {
                blockDef.variableDefs.add(param);
            }
        }


        if (blockDef != null) {
            blockDef.resolve_01();
            System.out.println(blockDef.variableDefs);
        }
        System.out.println("@@FunctionDef.resolve " + this);
       
    }


    @Override
    public void prepare_03() {
        // System.out.println("*function prepare");
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
            return (blockDef == null ? "" : blockDef.asCode()) +"\n" ;
        } else {
            if (classDef.classType == Enums.ClassType.PLAN) {
                return "";
            } else {
                // this. will need to be added
                return (blockDef == null ? "" : blockDef.asCode()) +"\n" ;
            }
        }
        // return "";
    }

    public String asCode() {
        if (name == null) {
            return "";
        }

        System.out.println("*function asCode " + name );
        return (returnType.name.equals("void") ? "void" : returnType.asCode()) + (returnType.is_array ? "[]" : "")  + " "+ name + "(" + paramsAsCode() + ")" + contentAsCode() ;
    }


    private String paramsAsClassModelDef() {
        String res = "";
        boolean first = true;

        // the first param is the class object

        for(VariableDef param : parameters) {
            if (!first) {
                res += ", ";
            }
            res += param.type.asCode();
            first = false;
        }
        return res;
    }

    public String asClassModelDef() {
        // @TODO correct this elsewhere
        if (org_name == null) {
            org_name = name;
        }

        // i64* (*toLower)(i64 ref);
        return (returnType.name.equals("void") ? "void" : returnType.asCode())  + (returnType.is_array ? "*" : "")  + " (*"+ org_name + ")(" + paramsAsClassModelDef() + ")";
    }


    @Override
    public String toString() {
        return "FunctionDef [accessor=" + accessor + ", blockDef=" + blockDef + ", classDef=" + classDef
                + ", exceptions=" + exceptions + ", fileDef=" + fileDef + ", is_final=" + is_final + ", is_static="
                + is_static + ", name=" + name + ", org_name=" + org_name + ", parameters=" + parameters
                + ", returnType=" + returnType + "]";
    }

    @Override
    public List<VariableDef> variableDefs() {
        // make the parameters vars
        return parameters;
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        this.blockDef = blockDef;
    }


    
}
