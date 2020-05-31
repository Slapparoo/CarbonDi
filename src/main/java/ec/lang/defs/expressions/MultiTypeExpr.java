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

    public String g4Type;

    public List<ExprDef> type_id_list = new ArrayList<>();
    private boolean isGet = true;
    private boolean resolved = false;
    private VariableDef variableDef = null;
    public ExprDef arrayIndex = null;
    public boolean directAccess = false;
    public boolean isExternal = false;
    public boolean isFunction = false; // used to help determine if it is an array index for an array

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
    public String asHeader() {
        if (isExternal) {
            String headerName = "";
            boolean first = true;
    
            for (ExprDef exprDef : type_id_list) {
                if (exprDef instanceof FunctionCallExpr) {
                    break;
                }
    
                if (first) {
                    first = false;
                    continue;
                } 
    
                if (headerName.length() != 0) {
                    headerName += "/";
                }
    
                headerName += exprDef.expr;
            }

            return "/*MT1*/\n#include \"" + headerName + ".h\"";
        }
        return super.asHeader();
    }

    @Override
    public String asCode() {
        prepare_03();
        String last = "";

        if (isExternal || type_id_list.get(0).toString().equals("External")) {
            String res = "";
            // @todo fix this the external should be able to allow depth ? ->

            ExprDef exprDef = type_id_list.get(type_id_list.size() -1);

            if (exprDef instanceof FunctionCallExpr) {
                ((FunctionCallExpr)exprDef).isExternal = true;
                exprDef.prepare_03();
            } else {
                ((TypeExpr)exprDef).memberOf = null;
            }
            

            res = exprDef.asCode();
            return hasNot +  res;

        }

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
                    // if (tx.isGet && tx.thisType.isPrimative()) {
                    //     tx.directAccess = true;
                    // }
                    tx.prepare_03(last);
                    if (tx.directAccess) {
                        // System.out.println("@@directaccess " + tx.expr + " " + this + " " + tx.directAccess);
                        directAccess = true;
                    }
                } else if (exprDef instanceof ArrayIndexExpr) {
                    exprDef.prepare_03();
                }
                last = exprDef.asCode();
            }
        }

        return hasNot +  last;
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
                if (isExternal) {
                    System.out.println("[warn] external function signature not defined \'" +this + " "  + sig + "\'");
                    fcd.resolve_01();
                    return;
                }

                throw new RuntimeException("function not found in class \'" + sig + "\', " + fcd + ", " + classDef + " " + this);
            }

            // check signature
            if (!resolvedTo.getSignature().equals(sig)) {
                System.out.println("[warn] function signatures do not match \'" + sig + "\', \'" + resolvedTo.getSignature() + "\'");
            }

            fcd.setFunctionDef(resolvedTo);
            fcd.resolve_01();
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
            // FunctionDefBase resolvedTo = classDef.resolveConstructor(fcd.getSignature());
            FunctionDefBase resolvedTo = classDef.resolveConstructor(fcd);

            if (resolvedTo == null) {
                for (ConstructorDef cd : classDef.getConstructorDefs()) {
                    System.out.println("" + cd.asSignature() + ", " + cd.getExpandedSignature());
                }

                throw new RuntimeException("No matching function found " + fcd.getSignature() + " " + classDef.getFqn());
            }

            // fcd.returnPrimative = false;
            thisType = new TypeIdDef(fcd.getName());

            fcd.setFunctionDef(resolvedTo);
            fcd.resolve_01();
            fcd.thisType = thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            return;
        }

        if (containedInBlock == null) {
            throw new RuntimeException("containedInBlock == null");
        }
        FunctionDef resolvedTo = (FunctionDef)DefFactory.resolveFunction(fcd.getName());
        if (resolvedTo != null) {
            if (!resolvedTo.isResolved()) {
                System.out.println("@@resolveFunction not resolved");
                resolvedTo.resolve_01();
            }

            // TODO signature check
            thisType = resolvedTo.returnType;

            fcd.setFunctionDef(resolvedTo);
            fcd.resolve_01();
            fcd.thisType = thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            return;
        } 


        VariableDef cd = containedInBlock.resolveVariable("this");
        resolvedTo = DefFactory.resolveFunction(cd, fcd.getName());
        if (resolvedTo != null) {
            thisType = resolvedTo.returnType;


            fcd.setFunctionDef(resolvedTo);
            fcd.resolve_01();
            fcd.thisType = thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            fcd.classMethod = true;
            return;
        }

        if (isExternal) {
            System.out.println("[warn] External function not resolved - check it is prototyped " + fcd.getName() + " " + fcd.getSignature());
            // System.out.println("function External.<header_name>." + fcd.getName() + " := " + fcd.getSignature());
            fcd.resolve_01();
        } else {
            System.out.println("[warn] function not resolved " + fcd.getName() + " " + fcd.getSignature());
        }

    }

    void resolveExpr(TypeExpr tx, VariableDef lastVar) {
        // if thistype != null it can't be this.tx
        arrayIndex = tx.arrayIndex;
        if (lastVar != null) {
            // tx is a property of thistype

            ClassDef classDef;
            if (lastVar.type.isIs_array()) {
                classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                // System.out.println("@@resolve class 1 " + lastVar.type.getObjectType() + " " + classDef);
                if (classDef == null) {
                    classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                    // System.out.println("@@resolve class 2 " + "Core." + lastVar.type.getObjectType() + " " + classDef);
                }
            } else {
                classDef = DefFactory.resolveClass(lastVar.type);
                // System.out.println("@@resolve class 3 " + lastVar.type + " " + classDef);
                if (classDef == null) {
                    classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                    // System.out.println("@@resolve class 4 " + lastVar.type.getObjectType() + " " + classDef);
                    if (classDef == null) {
                        classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                        // System.out.println("@@resolve class 4 " + "Core." + lastVar.type.getObjectType() + " " + classDef);
                    }
                }
            }

            if (classDef == null) {
                if (isExternal) {
                    classDef = new ClassDef();
                    classDef.setName("Core.External");

                    DefFactory.CLASS_DEFS.add(classDef);
                } else {
                    throw new RuntimeException("Class not resolved \'" + tx.expr + "\' " + this + " " + lastVar.type + " " + isExternal);
                }
            }
            tx.variableDef = classDef.resolveProperty(tx.expr);
            if (tx.variableDef == null) {
                FunctionDef fd = classDef.resolveFunctionAsProperty(tx.expr);
                if (fd != null) {
                    tx.variableDef = new VariableDef(fd);

                    tx.memberOf = classDef;
                    tx.thisType = tx.variableDef.type;
                    lastVar = tx.variableDef;

                    return;
                }
            }

            if (tx.variableDef == null) {

                if (isExternal) {
                    tx.variableDef = new VariableDef(tx.expr, "External");
                    tx.variableDef.is_static = true;

                    classDef.properties.add(tx.variableDef);

                    tx.memberOf = classDef;
                    tx.thisType = tx.variableDef.type;
                    lastVar = tx.variableDef;
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

        // if (tx.expr.equals("External")) {
        //     isExternal = true;
        //     return;
        // }

        tx.variableDef = containedInBlock.resolveVariable(tx.expr);

        // System.out.println(" 6 " + this + " " + tx.expr + " " + tx.variableDef);
        if (tx.variableDef != null) {
            tx.memberOf = tx.variableDef.classDef;
            lastVar = tx.variableDef;
            tx.thisType = lastVar.type;
            return;
        }

        // check if it is and internal class property
        // System.out.println("@@resolve class 7 ");
        if (!isExternal) {
            VariableDef var = containedInBlock.resolveVariable("this");
            if (var != null) {
                // add this in
                // tx.
                // System.out.println("@@resolve class 7.1 ");
                TypeExpr thisExpr = new TypeExpr("this");
                thisExpr.variableDef = var;
                type_id_list.add(0, thisExpr);

                resolveExpr(tx, var);
                return;
            }
        }

        // if (tx.expr.equals("External")) {
        //     isExternal = true;
        // }

        // static class?

        if (containedInBlock.classDef != null) {
            tx.variableDef = containedInBlock.classDef.resolveProperty(tx.expr);
            if (tx.variableDef != null) {
                // tx.memberOf = tx.variableDef.classDef;
                tx.memberOf = containedInBlock.classDef;
                tx.is_static = tx.variableDef.is_static;
                lastVar = tx.variableDef;
                tx.thisType = lastVar.type;
                return;
            }
        }

        // System.out.println(" 8 " + containedInBlock.variableDefs());
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

        if (!isExternal) { 
            throw new RuntimeException("cannot resolve type " + this + ", " + tx.expr + " " + tx.getLine());
        } else {
            // do something here to prototype the external function
            lastVar = new VariableDef();
            lastVar.type = new TypeIdDef("int");
            tx.thisType= lastVar.type;
            tx.variableDef = lastVar;
        }
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
            // } else {
            //     if (exprDef.expr != null && exprDef.expr.equals("External")) {
            //         System.out.println("@@found External " + this);
            //     }
            }

            ((MultiTypeId) exprDef).setIsGet(isGet);
            if (exprDef instanceof FunctionCallExpr) {
                resolveExpr((FunctionCallExpr) exprDef, variableDef);
                isFunction = true;
            } else if (exprDef instanceof TypeExpr) {
                TypeExpr typeExpr = (TypeExpr) exprDef;

                if (exprDef.expr.equals("External")) {
                    isExternal = true;
                }
                resolveExpr(typeExpr, variableDef);
                thisType = typeExpr.thisType;
                variableDef = typeExpr.variableDef;
                isFunction = false;
                // System.out.println("@@multi " + this + " " + typeExpr.expr + " " + variableDef.getName() + " " + variableDef.type.getName() + " " + variableDef.getLine());
            } else if (exprDef instanceof ArrayIndexExpr) {
                TypeExpr typeExpr = (TypeExpr) exprDef;

                if (exprDef.expr.equals("External")) {
                    isExternal = true;
                }

                resolveExpr(typeExpr, variableDef);
                thisType = typeExpr.thisType;
                variableDef = typeExpr.variableDef;
                isFunction = false;
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
        return "Multi (" + res + ") ";// + getLine();
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