package ec.lang.defs.expressions;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.VariableDef;

public class TypeExpr extends ExprDef {
    public boolean isGet = false;
    public ExprDef arrayIndex = null;


    @Override
    public void resolve_01() {
        if (expr.contains(".")) {
            // System.out.println("@@TypeExpr.resolve " + expr + ", classvar isget=" + isGet);
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
                    // System.out.println("@@TypeExpr.resolve set" + expr + ", classvar isget=" + isGet);

                    // expr = "get" + var.type.name + "ClassModel(" + tokens[0] + ")->get_" + tokens[1] + "()";
                }

            }
            


        } else {
            if (containedInBlock == null) {
                System.out.println("\033[1;33m" + "[warning] containedInBlock == null " + this + "\033[0m");
            } else {
                VariableDef var = containedInBlock.resolveVariable(expr);
                if (var != null) {
                    System.out.println("\033[1;33m" + "resolve  " + expr + "\033[0m");
                    thisType = var.type;
                }
            }
        }

        if (arrayIndex != null) {
            arrayIndex.resolve_01();;
        }
        super.resolve_01();

        System.out.println("@@TypeExpr.resolve " + expr + ", " + containedInBlock + ", isget=" + isGet + ", " + printType());
    }

    @Override
    public String asCode() {
        if (arrayIndex != null) {
            arrayIndex.resolve_01();
            if (thisType == null) {
                return "/* thisType == null  " + arrayIndex.asCode() + " */" +super.asCode();
            }

            if (thisType.isPrimative()) {
                return  "*("+thisType.asCode()+"*)_arrayClassModel->get("+super.asCode()+", " + arrayIndex.asCode() + ")";
            } else {
                if (isGet) {
                    return  "*("+thisType.asCode()+"*)_refArrayClassModel->get("+super.asCode()+", " + arrayIndex.asCode() + ")";
                } else {
                    return "_refArrayClassModel->setObject("+super.asCode()+", " + arrayIndex.asCode() + ",";
                }
            }


        }
        
        return super.asCode();
    }


    public TypeExpr(String value) {
        expr = value;
    }

    public TypeExpr(String value, ExprDef exprDef) {
        expr = value;
        arrayIndex = exprDef;
    }


    public TypeExpr(String value, String indexValue) {
        expr = value;
        if (indexValue.matches("[0-9_]")) {
            arrayIndex = new ConstExpr(indexValue);
        } else {
            arrayIndex = new TypeExpr(indexValue);
        }
        // System.out.println("@@TypeExpr array");
    }

    @Override
    public String toString() {
        return "TypeExpr [arrayIndex=" + arrayIndex + ", isGet=" + isGet + "]" + super.toString();
    }

}