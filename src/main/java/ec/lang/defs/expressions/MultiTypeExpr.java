package ec.lang.defs.expressions;

import java.util.ArrayList;
import java.util.List;

import ec.lang.defs.ClassDef;
import ec.lang.defs.ConstructorDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;

public class MultiTypeExpr extends ExprDef implements MultiTypeId {
    public List<ExprDef> type_id_list = new ArrayList<>();
    private boolean isGet = true;
    private boolean resolved = false;
    private VariableDef variableDef = null;
    public ExprDef arrayIndex = null;
    public boolean directAccess = false;

    public void addExpr(ExprDef exprDef, String line) {
        if (getLine().length() == 0) {
            setLine(line);
        }

        exprDef.setLine(line);
        type_id_list.add(exprDef);
    }

    @Override
    public String asSignature() {
        String res = "";

        for (ExprDef exprDef : type_id_list) {
            if (res.length() > 0) {
                res += ".";
            }
            res += exprDef.asSignature();
        }

        return res;
    }

    @Override
    public void prepare_03() {
        // for (ExprDef exprDef : type_id_list) {
        //     System.out.println("@@Prepare " + this + ", " + exprDef);
        //     if (exprDef instanceof FunctionCallExpr) {
        //         exprDef.prepare_03();
        //     } else if (exprDef instanceof TypeExpr) {
        //         ((TypeExpr)exprDef).prepare_03("");
        //     } else if (exprDef instanceof ArrayIndexExpr) {
        //         exprDef.prepare_03();
        //     }
        // }

        // super.prepare_03();
    }

    @Override
    public String asCode() {
        prepare_03();
        String last = "";
        for (ExprDef exprDef : type_id_list) {
            if (last.length() == 0) {
                exprDef.prepare_03();
                last = exprDef.asCode();
                
            } else {
                ((MultiTypeId) exprDef).resolve_02(last);

                if (exprDef instanceof FunctionCallExpr) {
                    ((FunctionCallExpr)exprDef).prepare_03();
                } else if (exprDef instanceof TypeExpr) {
                    TypeExpr tx = (TypeExpr)exprDef;
                    tx.directAccess = directAccess;
                    if (tx.isGet && tx.thisType.isPrimative()) {
                        tx.directAccess = true;
                    }
                    
                    tx.prepare_03(last);
                } else if (exprDef instanceof ArrayIndexExpr) {
                    exprDef.prepare_03();
                }
                last = exprDef.asCode();
            }
        }

        return last;
    }

    void resolveExpr(FunctionCallExpr fcd, VariableDef lastVar) {

        if (lastVar != null) {
            // tx is a property of thistype
            ClassDef classDef = DefFactory.resolveClass(lastVar.type);

            String sig = fcd.getSignature();

            if (classDef == null ) {
                throw new RuntimeException("class cannot be resolved \'" + lastVar.type.getName() + ", " + this + ", " + fcd.getName());
            }
            FunctionDef resolvedTo = classDef.resolveFunction(fcd.getName());

            if (resolvedTo == null) {
                throw new RuntimeException("function not found in class \'" + sig + "\', " + fcd + ", " + classDef + " " + this);
            }

            // check signature
            if (!resolvedTo.getSignature().equals(sig)) {
                System.out.println("[warn] function signatures do not match \'" + sig + "\', \'" + resolvedTo.getSignature() + "\'");
            }

            fcd.setFunctionDef(resolvedTo);
            // fcd.resolve_01();
            fcd.thisType = resolvedTo.returnType;
            thisType = fcd.thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            return;

        } 

        if (containedInBlock == null) {
            new NullPointerException("FunctionCallExpr containedInBlock == null" + fcd.getName());
        }

        for (ExprDef exprDef : fcd.params) {
            if (exprDef instanceof TypeExpr) {
                ((TypeExpr) exprDef).setIsGet(true);
            }
            exprDef.containedInBlock = containedInBlock;
            exprDef.resolve_01();
        }

        // resolve constructors
        ClassDef classDef = DefFactory.resolveClass(fcd.getName());
        if (classDef != null) {
            FunctionDefBase resolvedTo = classDef.resolveConstructor(fcd.getSignature());

            if (resolvedTo == null) {
                for (ConstructorDef cd : classDef.getConstructorDefs()) {
                    System.out.println("" + cd.asSignature() + ", " + cd.getExpandedSignature());
                }

                throw new RuntimeException("No matching function found " + fcd.getSignature() + " " + classDef.getFqn());
            }

            // fcd.returnPrimative = false;
            thisType = new TypeIdDef(fcd.getName());

            fcd.setFunctionDef(resolvedTo);
            // fcd.resolve_01();
            fcd.thisType = thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            return;
        }

        if (containedInBlock == null) {
            throw new RuntimeException("containedInBlock == null");
        }

        VariableDef cd = containedInBlock.resolveVariable("this");
        FunctionDef resolvedTo = DefFactory.resolveFunction(cd, fcd.getName());
        if (resolvedTo != null) {
            thisType = resolvedTo.returnType;


            fcd.setFunctionDef(resolvedTo);
            // fcd.resolve_01();
            fcd.thisType = thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            fcd.classMethod = true;
        }

        System.out.println("[warn] function not resolved " + fcd.getName() + " " + fcd.getSignature());

    }

    void resolveExpr(TypeExpr tx, VariableDef lastVar) {
        // if thistype != null it can't be this.tx
        arrayIndex = tx.arrayIndex;
        if (lastVar != null) {
            // tx is a property of thistype

            ClassDef classDef;
            if (lastVar.type.isIs_array()) {
                classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                // System.out.println("@@resolve class " + lastVar.type.getObjectType() + " " + classDef);
                if (classDef == null) {
                    classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                    // System.out.println("@@resolve class " + "Core." + lastVar.type.getObjectType() + " " + classDef);
                }
            } else {
                classDef = DefFactory.resolveClass(lastVar.type);
                // System.out.println("@@resolve class " + lastVar.type + " " + classDef);
                if (classDef == null) {
                    classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                    // System.out.println("@@resolve class " + lastVar.type.getObjectType() + " " + classDef);
                    if (classDef == null) {
                        classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                        // System.out.println("@@resolve class " + "Core." + lastVar.type.getObjectType() + " " + classDef);
                    }
                }
            }

            if (classDef == null) {
                throw new RuntimeException("Class not resolved " + this + " " + tx.expr + " " + lastVar.type);
            }
            tx.variableDef = classDef.resolveProperty(tx.expr);
            if (tx.variableDef == null) {
                FunctionDef fd = classDef.resolveFunctionAsProperty(tx.expr);
                if (fd != null) {
                    VariableDef var = new VariableDef(); 
                    var.functionDef = fd;
                    var.type = fd.returnType;
                    var.is_static = fd.is_static;
                    tx.variableDef = var;
                }
            }

            if (tx.variableDef == null) {


                if (containedInBlock.resolveVariable(tx.expr) != null) {
                    System.out.println("ec.g4 has an error getting multi types and this is a work around " + tx.expr );
                    type_id_list.remove(0);
                    resolve_01();
                    return;
                }
                throw new RuntimeException(
                    "Property not found " + this + " " + tx.expr + " " + classDef.getShortname() + " " + tx.getLine());
            }


            tx.memberOf = classDef;
            tx.thisType = tx.variableDef.type;
            lastVar = tx.variableDef;
            // arrayIndex = tx.arrayIndex;
            return;
        }

        if (containedInBlock == null) {
            throw new RuntimeException("containedInBlock == null " + this + " " + tx.expr);
        }

        tx.variableDef = containedInBlock.resolveVariable(tx.expr);

        if (tx.variableDef != null) {
            tx.memberOf = tx.variableDef.classDef;
            lastVar = tx.variableDef;
            tx.thisType = lastVar.type;
            return;
        }

        // check if it is and internal class property
        VariableDef var = containedInBlock.resolveVariable("this");
        if (var != null) {
            // add this in
            // tx.
            TypeExpr thisExpr = new TypeExpr("this");
            thisExpr.variableDef = var;
            type_id_list.add(0, thisExpr);

            resolveExpr(tx, var);
            return;
        }

        // static class?
        ClassDef classDef = DefFactory.resolveClass(tx.expr);
        if (classDef != null) {
            tx.is_static = true;
            tx.memberOf = classDef;
            TypeIdDef thisId = new TypeIdDef(tx.expr);
            
            lastVar = new VariableDef();

            lastVar.is_static = true;
            lastVar.type = thisId;
            tx.thisType = thisType;
            tx.variableDef = lastVar;

            return;
        }

        throw new RuntimeException("cannot resolve type " + this + ", " + tx.expr + " " + tx.getLine());
    }

    @Override
    public void resolve_01() {
        if (resolved) {
            System.out.println("already resolved why are you resolving again? " + type_id_list + ", " + asSignature());
            return;
        }

        // containedInBlock.isClass
        MultiTypeId last = null;

        // type_id_list can get modified to include this.
        for (ExprDef exprDef : new ArrayList<>(type_id_list)) {
            exprDef.containedInBlock = containedInBlock;

            // System.out.println("@@resolving " + exprDef + ", " + this + ", " + variableDef);

            if (last != null) {
                last.setIsGet(true);
                isProperty = true;
            }

            ((MultiTypeId) exprDef).setIsGet(isGet);
            if (exprDef instanceof FunctionCallExpr) {
                resolveExpr((FunctionCallExpr) exprDef, variableDef);
            } else if (exprDef instanceof TypeExpr) {
                TypeExpr typeExpr = (TypeExpr) exprDef;
                resolveExpr(typeExpr, variableDef);
                thisType = typeExpr.thisType;
                variableDef = typeExpr.variableDef;
                // System.out.println("@@multi " + this + " " + typeExpr.expr + " " + variableDef.getName() + " " + variableDef.type.getName() + " " + variableDef.getLine());
            } else if (exprDef instanceof ArrayIndexExpr) {
                TypeExpr typeExpr = (TypeExpr) exprDef;
                resolveExpr(typeExpr, variableDef);
                thisType = typeExpr.thisType;
                variableDef = typeExpr.variableDef;
            } else {
                if (exprDef instanceof MultiTypeExpr) {
                    throw new RuntimeException("Unexpected MultiTypeExpr type " + exprDef + ", " + exprDef.thisType);
                }
                throw new RuntimeException("Unexpected type " + exprDef + "  " + exprDef.getClass());
            }
            last = (MultiTypeId) exprDef;
        }

        super.resolve_01();
        resolved = true;
    }

    @Override
    public String asDebug() {
        return super.asDebug() + " " + type_id_list;
    }

    @Override
    public String toString() {
        String res = "";
        for (ExprDef exprDef : type_id_list) {
            if (res.length() > 0) {
                res += ".";
            }

            if (exprDef instanceof FunctionCallExpr) {
                res += ((FunctionCallExpr)exprDef).getName()+ "()" ;
            } else if (exprDef instanceof TypeExpr) {
                res += exprDef.expr;
            } else if (exprDef instanceof ArrayIndexExpr) {
                res += exprDef.expr;
            }            
            
            // res += exprDef.asDebug();
        }
        return "Multi (" + res + ") " + getLine();
    }

    @Override
    public void resolve_02(String red_id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setIsGet(boolean isGet) {
        this.isGet = isGet;
    }

    public boolean getIsGet() {
        return this.isGet;
    }

}