package ec.lang.defs.expressions;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;

public class FunctionCallExpr extends ExprDef {
    public List<ExprDef> params = new ArrayList<>();
    private String name;
    private boolean returnPrimative = true;
    // public BlockDef containedInBlock;


    @Override
    public void resolve_01() {
        System.out.println("@@FunctionCallExpr.resolve " + name);

        if (containedInBlock == null) {
            new NullPointerException("FunctionCallExpr containedInBlock == null" + name);
        }

        for (ExprDef exprDef : params) {
            if (exprDef instanceof TypeExpr) {
                ((TypeExpr)exprDef).isGet = true;
            }
            exprDef.containedInBlock = containedInBlock;
            exprDef.resolve_01();
        }

        if (name.contains(".")) {

            // class accessor method
            // s1.printTo(stdout); -> getStringClassModel()->printTo(s1, stdout);
            String tokens[] = name.split("\\.");

            // easy
            if (tokens.length == 2) {
                String varName = tokens[0];
                String methodName = tokens[1];

                // how to get the class model name
                // the variable needs to be resolved
                thisType = new TypeIdDef(getClassModelName(varName));
                thisType.resolve_01();
                name = "get" + thisType.name + "ClassModel()->"+methodName;
                params.add(0, new ExprDef(varName));
            }
        } else {
            // resolve constructors
            for (ClassDef classDef : DefFactory.CLASS_DEFS) {
                if (classDef.name.equals(name)) {
                    name = name + "_create";                    
                    System.out.println("@@function resolve Constructor " + name);
                    // name = name + "_create";  
                    returnPrimative = false; 
                    thisType = new TypeIdDef(name);                 
                }
            }

            // resolve the return type
            for (FunctionDef funct : DefFactory.FUNCT_DEFS) {
                if (funct.name.equals(name)) {
                    System.out.println("@@function return type " + name + ", " + funct);
                    thisType = funct.returnType;

                    if (name.equals("String")) {
                        name = "String_create";
                    }

                    break;
                }
            }
        }

        super.resolve_01();
    }

    private String getClassModelName(String varName) {
        // DefFactory lookup to return the Type by name
        for (VariableDef var : containedInBlock.variableDefs) {
            if (var.getName().equals(varName)) {
                return var.type.name;
            }
        }

        for (VariableDef var : DefFactory.VAR_DEFS) {
            if (var.getName().equals(varName)) {
                return var.type.name;
            }
        }

        throw new RuntimeException("Class not resolved " + varName);
    }

    public FunctionCallExpr() {
        System.out.println("@@FunctionCallExpr()");
    }

    public void setName(String name) {
        System.out.println("@@FunctionCallExpr.setname " + name);
        this.name = name;
    }

    private String paramsAsCode() {
        String res = "";

        for (ExprDef exprDef : params) {
            if (res.length() > 0) {
                res += ", ";
            }
            res += exprDef.asCode();
        }
        return res;
    }

    @Override
    public String asCode() {
        return "/* functioncall*/"+  name + "("+ paramsAsCode() + ")" ; 
    }
}