package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class TypeExpr extends ExprDef {
    public boolean isGet = false;

    @Override
    public void resolve_01() {
        System.out.println("@@TypeExpr.resolve " + expr + ", " + containedInBlock);
        if (expr.contains(".")) {
            System.out.println("@@TypeExpr.resolve " + expr + ", classvar isget=" + isGet);
            // resolve the class
            String[] tokens = expr.split("\\.");
            if (tokens.length == 2) {
                // resolve object 
                if (containedInBlock == null) {
                    throw new NullPointerException("containedInBlock == null " + expr);
                }

                VariableDef var = containedInBlock.resolveVariable(tokens[0]);

                // VariableDef var = DefFactory.resolveVariable(tokens[0]);

                if (isGet) {
                    expr = "get" + var.type.name + "ClassModel()->get_" + tokens[1] + "(" + tokens[0] + ")";
                    // type
                    ClassDef classDef = DefFactory.resolveClass(var.type.name);
                    for (VariableDef def : classDef.properties) {
                        if (def.getName().equals(tokens[1])) {
                            thisType = def.type;
                            break;
                        }
                    }  

                } else {
                    System.out.println("@@TypeExpr.resolve set" + expr + ", classvar isget=" + isGet);

                    // expr = "get" + var.type.name + "ClassModel(" + tokens[0] + ")->get_" + tokens[1] + "()";
                }

            }
            


        }
        super.resolve_01();
    }




    public TypeExpr(String value) {
        expr = value;
    }
}