package ec.lang.defs.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ec.lang.compiler.Messages;
import ec.lang.defs.ClassDef;
import ec.lang.defs.ConstructorDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;
import lombok.Getter;

public class MultiTypeExpr extends ExprDef implements MultiTypeId {

    public String g4Type;
    public List<ExprDef> type_id_list = new ArrayList<>();
    private boolean isGet = true;
    private boolean resolved = false;
    @Getter private VariableDef variableDef = null;
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

        if (containedInBlock == null) {
            throw new NullPointerException("MultiTypeExpr containedInBlock == null" + this);
        }


        if (isExternal || type_id_list.get(0).toString().equals("External")) {
            String res = "";
            // @todo fix this the external should be able to allow depth ? ->

            ExprDef exprDef = type_id_list.get(type_id_list.size() - 1);

            if (exprDef instanceof FunctionCallExpr) {
                ((FunctionCallExpr) exprDef).isExternal = true;
                exprDef.prepare_03();
            } else {
                ((TypeExpr) exprDef).memberOf = null;
            }

            res = exprDef.asCode();
            return hasNot + res;
        }

        for (ExprDef exprDef : type_id_list) {
            if (last.length() == 0) {
                exprDef.prepare_03();
                last = exprDef.asCode();

            } else {
                exprDef.containedInBlock = containedInBlock;

                if (containedInBlock == null) {
                    throw new NullPointerException("MultiTypeExpr containedInBlock == null" + this);
                }
        
                ((MultiTypeId) exprDef).resolve_02(last);

                if (exprDef instanceof FunctionCallExpr) {
                    ((FunctionCallExpr) exprDef).prepare_03();
                } else if (exprDef instanceof TypeExpr) {
                    TypeExpr tx = (TypeExpr) exprDef;
                    tx.directAccess = directAccess;
                    tx.containedInBlock = containedInBlock;
                    tx.prepare_03(last);
                    if (tx.directAccess) {
                        directAccess = true;
                    }

                    if (containedInBlock.directAccess.contains(variableDef.getName())) {
                        directAccess = true;
                    }
                } else if (exprDef instanceof ArrayIndexExpr) {
                    exprDef.prepare_03();
                }
                last = exprDef.asCode();
            }
        }

        return hasNot + last;
    }

    void resolveExpr(FunctionCallExpr fcd, VariableDef lastVar) {
        if (containedInBlock == null) {
            new NullPointerException("FunctionCallExpr containedInBlock == null" + fcd.getName());
        }

        if (lastVar != null) {
            String sig = fcd.getSignature();
            ClassDef classDef = lastVar.classDef;

            if (classDef == null) {
                throw new RuntimeException(
                        "class cannot be resolved \'" + lastVar.type.getName() + ", " + this + ", " + fcd.getName() + " " + fcd.getLine());
            }
            FunctionDef resolvedTo = classDef.resolveFunction(fcd.getName());

            if (resolvedTo == null) {
                if (isExternal) {
                    Messages.MESSAGES.addWarning("external function signature not defined \'" + this + " " + sig + "\'");
                    fcd.resolve_01();
                    return;
                }

                throw new RuntimeException(
                        "function not found in class \'" + sig + "\', " + fcd + ", " + classDef + " " + this);
            }

            // check signature
            if (!resolvedTo.getSignature().equals(sig)) {
                if (!resolvedTo.isCallable(null, fcd.params)) {

                    if (!resolvedTo.isClassCallable(null, fcd.params)) {
                        Messages.MESSAGES.addWarning("function signatures do not match \'" + sig + "\', \'"
                        + resolvedTo.getSignature() + "\' " + resolvedTo.getParameters().size() + ", " + fcd.params.size());
                    }
                }
            }

            fcd.setFunctionDef(resolvedTo);
            fcd.resolve_01();
            fcd.thisType = resolvedTo.returnType;
            thisType = fcd.thisType;
            lastVar = new VariableDef();
            lastVar.type = thisType;
            return;

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
            FunctionDefBase resolvedTo = classDef.resolveConstructor(fcd);

            if (resolvedTo == null) {
                for (ConstructorDef cd : classDef.getConstructorDefs()) {
                    System.out.println("" + cd.asSignature() + ", " + cd.getExpandedSignature());
                }

                throw new RuntimeException(
                        "No matching function found " + fcd.getSignature() + " " + classDef.getFqn());
            }

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

        if (fcd.containedInBlock.classDef != null) {
            FunctionDef resolvedTo = (FunctionDef) fcd.containedInBlock.classDef.resolveFunction(fcd.getName());
            if (resolvedTo != null) {
                if (!resolvedTo.isResolved()) {
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
        }

        FunctionDef resolvedTo = (FunctionDef) DefFactory.resolveFunction(fcd.getName());
        if (resolvedTo != null) {
            if (!resolvedTo.isResolved()) {
                Messages.MESSAGES.addInfo("found unresolved function. " + fcd.getName() + " class=" + resolvedTo.classDef);
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
            Messages.MESSAGES.addWarning("External function not resolved - check it is prototyped " + fcd.getName() + " "
                    + fcd.getSignature());
            fcd.resolve_01();
        } else {
            throw new RuntimeException("[warn] function not resolved " + fcd.getName() + " " + fcd.getSignature() + " " + fcd.getLine());
        }

    }

    VariableDef resolveExpr(String tx) {
        VariableDef var = containedInBlock.resolveVariable(tx);

        if (var != null) {
            return var;
        }

        ClassDef classDef = DefFactory.resolveClass(tx);
        if (classDef != null) {
            TypeIdDef thisId = new TypeIdDef(tx);
            var = new VariableDef();

            var.is_static = true;
            var.type = thisId;
            var.classDef = classDef;

            return var;
        }

        if (!isExternal) {
            return null;
        } else {
            // do something here to prototype the external function
            var = new VariableDef();
            var.type = new TypeIdDef("i64");
            return var;
        }
    }

    void resolveExpr(TypeExpr tx, VariableDef lastVar) {

        if (containedInBlock == null) {
            throw new RuntimeException("containedInBlock == null " + this + " " + tx.expr);
        }

        if (lastVar == null) {
            throw new RuntimeException("lastvar == null " + this + " " + tx.expr);
        }

        // if thistype != null it can't be this.tx
        arrayIndex = tx.arrayIndex;
        // tx is a property of thistype

        ClassDef classDef = lastVar.classDef;
        if (classDef == null) {
            if (lastVar.type.isIs_array()) {
                classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                if (classDef == null) {
                    classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                }
            } else {
                classDef = DefFactory.resolveClass(lastVar.type);
                if (classDef == null) {
                    classDef = DefFactory.resolveClass(lastVar.type.getObjectType());
                    if (classDef == null) {
                        classDef = DefFactory.resolveClass("Core." + lastVar.type.getObjectType());
                    }
                }
            }
        }

        if (classDef == null) {
            if (isExternal) {
                classDef = new ClassDef();
                classDef.setName("Core.External");

                // DefFactory.CLASS_DEFS.add(classDef);
            } else {
                throw new RuntimeException(
                        "Class not resolved \'" + tx.expr + "\' " + this + " " + lastVar.type + " " + isExternal);
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
                variableDef = lastVar;
                setType(tx);
                return;
            }

            throw new RuntimeException(
                    "Property not found " + this + " " + tx.expr + " " + classDef.getShortname() + " " + tx.getLine());
        }
        tx.memberOf = classDef;
        tx.thisType = tx.variableDef.type;
        lastVar = tx.variableDef;
        return;
    }

    private void setType(TypeExpr typeExpr) {
        typeExpr.variableDef = variableDef;
        typeExpr.memberOf = variableDef.classDef;
        typeExpr.thisType = variableDef.type;
        typeExpr.is_static = variableDef.is_static;

        thisType = typeExpr.thisType;
    }

    @Override
    public void resolve_01() {
        if (resolved) {
            return;
        }

        if (containedInBlock == null) {
            throw new NullPointerException("containedInBlock == null " + this);
        }

        MultiTypeId last = null;

        // type_id_list can get modified to include this.
        for (ExprDef exprDef : new ArrayList<>(type_id_list)) {
            exprDef.containedInBlock = containedInBlock;

            if (exprDef.containedInBlock == null) {
                throw new RuntimeException("exprDef.containedInBlock == null " + exprDef);
            }

            if (last != null) {
                last.setIsGet(true);
                isProperty = true;
            }

            ((MultiTypeId) exprDef).setIsGet(isGet);
            if (exprDef instanceof FunctionCallExpr) {
                resolveExpr((FunctionCallExpr) exprDef, variableDef);
                isFunction = true;
            } else if (exprDef instanceof TypeExpr) {
                TypeExpr typeExpr = (TypeExpr) exprDef;

                if (exprDef.expr.equals("External")) {
                    isExternal = true;
                
                    variableDef = new VariableDef(typeExpr.expr, "External");
                    variableDef.is_static = true;
                    variableDef.classDef = new ClassDef();
                    variableDef.classDef.setName("Core.External");
                    variableDef.classDef.properties.add(variableDef);
                    setType(typeExpr);
                } else if (last == null) {
                    variableDef = resolveExpr(typeExpr.expr);

                    if (variableDef != null) {
                        setType(typeExpr);
                    } else {
                        variableDef = resolveExpr("this");

                        if (variableDef == null) {
                            if (containedInBlock.classDef != null) {
                                variableDef = containedInBlock.classDef.resolveProperty(typeExpr.expr);
                                variableDef.classDef = containedInBlock.classDef;
                                setType(typeExpr);
                            }
                        } else {
                            ExprDef t = new TypeExpr("this");
                            t.containedInBlock = this.containedInBlock;
                            t.thisType = variableDef.type;
                            type_id_list.add(0, t);

                            resolveExpr(typeExpr, variableDef);
                        }

                        if (variableDef == null) {
                            throw new RuntimeException("cannot resolve" + this + " " + this.getLine());
                        }

                        thisType = typeExpr.thisType;
                        variableDef = typeExpr.variableDef;
                        isFunction = false;
                    }
                } else {
                    resolveExpr(typeExpr, variableDef);
                    thisType = typeExpr.thisType;
                    variableDef = typeExpr.variableDef;
                    isFunction = false;
                }
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
        String res = type_id_list.stream()
            .map(exprDef -> {
                if (exprDef instanceof FunctionCallExpr) {
                    return ((FunctionCallExpr) exprDef).getName() + "()";
                } else if (exprDef instanceof TypeExpr || exprDef instanceof ArrayIndexExpr) {
                    return exprDef.expr;
                } else return null;})
            .filter(str -> str != null)    
            .collect(Collectors.joining("."));

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