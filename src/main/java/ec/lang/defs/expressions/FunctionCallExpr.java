package ec.lang.defs.expressions;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.ClassDef;
import ec.lang.defs.ConstructorDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;

public class FunctionCallExpr extends ExprDef implements MultiTypeId {
    public List<ExprDef> params = new ArrayList<>();
    private String name;
    private boolean returnPrimative = true;
    private FunctionDefBase resolvedTo;
    public boolean classMethod = false;
    private boolean staticMethod = false;
    private String resolve02 = "";

    public String getSignature() {
        if (thisType == null) {
            return "num (*" + name + ")(" + getParamsSignature() + ")";
        }

        return (thisType.getName().equals("void") ? "void" : thisType.asCode()) + (thisType.isIs_array() ? "*" : "")
                + " (*" + name + ")(" + getParamsSignature() + ")";
    }

    public String getParamsSignature() {
        String res = "";
        boolean first = true;

        for (ExprDef param : params) {
            if (!first) {
                res += ", ";
            }
            if (param.thisType == null) {
                res += '+' + name;
            } else {
                res += param.thisType.getName();
            }
            first = false;
        }
        return res;
    }

    // @Override
    // public void resolve_01() {

    //     if (containedInBlock == null) {
    //         new NullPointerException("FunctionCallExpr containedInBlock == null" + name);
    //     }

    //     for (ExprDef exprDef : params) {
    //         if (exprDef instanceof TypeExpr) {
    //             ((TypeExpr) exprDef).setIsGet(true);
    //         }
    //         exprDef.containedInBlock = containedInBlock;
    //         exprDef.resolve_01();
    //     }

    //     // resolve constructors
    //     for (ClassDef classDef : DefFactory.CLASS_DEFS) {
    //         if (classDef.getShortname().equals(name)) {
    //             resolvedTo = classDef.resolveConstructor(getSignature());

    //             if (resolvedTo == null) {
    //                 throw new RuntimeException("No matching function found " + getSignature() + " " + classDef.getFqn());
    //             }

    //             returnPrimative = false;
    //             thisType = new TypeIdDef(name);
    //         }
    //     }

    //     if (containedInBlock == null) {
    //         throw new RuntimeException("containedInBlock == null");
    //     }

    //     if (resolvedTo == null) {
    //         VariableDef cd = containedInBlock.resolveVariable("this");
    //         resolvedTo = DefFactory.resolveFunction(cd, name);
    //         if (resolvedTo != null) {
    //             thisType = ((FunctionDef) resolvedTo).returnType;
    //             classMethod = true;
    //         }
    //     }

    //     // resolve the return type
    //     for (FunctionDef funct : DefFactory.FUNCT_DEFS) {
    //         if (funct.name.equals(name)) {

    //             thisType = funct.returnType;

    //             if (name.equals("String")) {
    //                 name = "/* fce */  create_String$1";
    //             }

    //             if (name.equals("I64")) {
    //                 name = "Boxing_i64_create";
    //                 thisType.setIs_boxed(true);
    //             }

    //             break;
    //         }
    //     }
    //     // }

    //     super.resolve_01();

    //     if (resolvedTo == null || resolve02.length() == 0) {
    //         System.out.println("@@functioncall not resolved " + name  + " and why is resolve01 being called");
    //         throw new RuntimeException("@@functioncall not resolved " + name );
    //     }
    // }

    // private String getClassModelName(String varName) {
    //     // DefFactory lookup to return the Type by name
    //     for (VariableDef var : containedInBlock.variableDefs) {
    //         if (var.getName().equals(varName)) {
    //             return var.type.getName();
    //         }
    //     }

    //     for (VariableDef var : DefFactory.VAR_DEFS) {
    //         if (var.getName().equals(varName)) {
    //             return var.type.getName();
    //         }
    //     }

    //     // a static refence?
    //     ClassDef cd = DefFactory.resolveClass(varName);
    //     if (cd != null) {
    //         staticMethod = true;
    //         return varName;
    //     }

    //     throw new RuntimeException("Class not resolved " + varName);
    // }

    public FunctionCallExpr() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String paramsAsCode(String res) {
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
        if (resolvedTo != null) {
            if (resolvedTo instanceof ConstructorDef) {
                return hasNot + "/*cd1*/ create_" + resolvedTo.getExpandedName() + "(" + paramsAsCode("") + ")";
            } else {
                if (resolvedTo.is_static) {
                    return hasNot + "/*fc4*/ "
                            + SnippetFactory.classModelStatement(resolvedTo.classDef.getCName(), "", true) + "->"
                            + resolvedTo.getExpandedName() + "(" + paramsAsCode("") + ")";
                } else if (classMethod) {
                    // ((MyStringClassModel *)useObject(this)->classmodel
                    VariableDef cd = containedInBlock.resolveVariable("this");
                    return hasNot + "/*fc3*/" + SnippetFactory.classModelStatement(cd.type.getName(), "this", false)
                            + "->" + resolvedTo.getExpandedName() + "(" + paramsAsCode("this") + ")";
                } else if (resolvedTo.classDef != null) {

                    // @todo, create a local var for resolve02

                    return hasNot + "/* switch from fc5 to te4*/"
                    // if its an array use 
                            + SnippetFactory.classModelStatement(resolvedTo.classDef.getCName(), resolve02, false)
                            + "->" + resolvedTo.getExpandedName() + "(" + paramsAsCode(resolve02) + ")";
                } else {
                    return hasNot + "/*fc1*/" + resolvedTo.getExpandedName() + "(" + paramsAsCode("") + ")";
                }
            }
        }
        return hasNot + "/*fc2 " + expr + " */" + name + "(" + paramsAsCode("") + ")";
    }

    @Override
    public String toString() {
        return "[FunctionCallExpr] " + name + "(" + getParamsSignature() + ")";
    }

    public void setFunctionDef(FunctionDefBase fd) {
        resolvedTo = fd;

        for (ExprDef exprDef : params) {
            if (exprDef instanceof TypeExpr) {
                ((TypeExpr) exprDef).setIsGet(true);
            }
            exprDef.containedInBlock = containedInBlock;
            exprDef.resolve_01();
        }
    }

    @Override
    public void resolve_02(String red_id) {
        // TODO Auto-generated method stub
        resolve02 = red_id;

        if (containedInBlock == null) {
            new NullPointerException("FunctionCallExpr containedInBlock == null" + name);
        }

        for (ExprDef exprDef : params) {
            if (exprDef instanceof TypeExpr) {
                ((TypeExpr) exprDef).setIsGet(true);
            }
            exprDef.containedInBlock = containedInBlock;
            exprDef.resolve_01();
        }
    }

    @Override
    public void setIsGet(boolean isGet) {
        // TODO Auto-generated method stub

    }
}