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

public class FunctionCallExpr extends ExprDef {
    public List<ExprDef> params = new ArrayList<>();
    private String name;
    private boolean returnPrimative = true;
    private FunctionDefBase resolvedTo;
    private boolean classMethod = false;
    private boolean staticMethod = false;

    public String getSignature() {
        if (thisType == null) {
            return "num (*"+ name + ")(" + getParamsSignature() + ")";
        }

        return (thisType.getName().equals("void") ? "void" : thisType.asCode())  
        + (thisType.isIs_array() ? "*" : "")  
        + " (*"+ name + ")(" + getParamsSignature() + ")";
    }

    public String getParamsSignature() {
        String res = "";
        boolean first = true;

        for(ExprDef param : params) {
            if (!first) {
                res += ", ";
            }
            res += param.thisType.getName();
            first = false;
        }
        return res;
    }

    @Override
    public void resolve_01() {

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
            String tokens[] = name.split("\\.");

            // easy
            if (tokens.length == 2) {
                String varName = tokens[0];
                String methodName = tokens[1];

                // how to get the class model name
                // the variable needs to be resolved
                String prependThis = "";

                VariableDef variableDef = containedInBlock.resolveVariable(varName);

                if (!varName.equals("this") && variableDef == null) {
                    VariableDef thisVar = containedInBlock.resolveVariable("this");
                    if (thisVar != null) {
                        prependThis = SnippetFactory.classModelStatement(thisVar.type.getName(), "this", thisVar.is_static)+"->get_" + tokens[0] + "(this)";

                        ClassDef classDef = DefFactory.resolveClass(thisVar.type.getName());
                        if (classDef == null) {
                            throw new RuntimeException("Can't resolve class " + thisVar.type.getName());
                        }
                        // find the property
                        for (VariableDef cp : classDef.properties) {
                            if (cp.getName().equals(tokens[0])) {
                                thisType = cp.type;
                            }
                        }
                        // serach parents
                        while (thisType == null) {
                            classDef = classDef.parent;
                            if (classDef == null) {
                                throw new RuntimeException("Can't resolve class variable " + thisVar.type.getName() + " " + tokens[0]);
                            }
                            for (VariableDef cp : classDef.properties) {
                                if (cp.getName().equals(tokens[0])) {
                                    thisType = cp.type;
                                }
                            }
                        }
                    } 
                }
                if (prependThis.length() == 0) {
                    ClassDef cd = DefFactory.resolveClass(varName);
                    if (cd != null) {
                        FunctionDef fd = cd.resolveFunction(methodName);
                        if (fd != null) {
                            if (!fd.is_static) {
                                throw new RuntimeException("method is not static " + name);
                            }
                            resolvedTo = fd;
                            staticMethod = true;
                            name = varName;
                        }
                    } else {
                        variableDef = containedInBlock.resolveVariable(varName);
                        if (variableDef != null) {
                            thisType = variableDef.type; 
                            if (thisType.isIs_boxed()) {
                                thisType = new TypeIdDef(thisType.getName().toLowerCase());
                                thisType.setIs_array(variableDef.type.isIs_array());
                            }
                        } else {
                            thisType = new TypeIdDef(getClassModelName(varName));
                            thisType.resolve_01();
                        }
                    }
                }

                if (resolvedTo == null) {
                    if (prependThis.length() > 0) {
                        name = SnippetFactory.classModelStatement(thisType.getName(), prependThis, false) + "->"+methodName;
                        params.add(0, new ExprDef(prependThis));
                        
                    } else {
                        if (thisType.isIs_array()) {
                            name = "("+thisType.getName()+"*)"+SnippetFactory.classModelStatement("Array", varName, false) +"->"+methodName;
                            params.add(0, new ExprDef(varName));
                        } else {
                            name = SnippetFactory.classModelStatement(thisType.getName(), varName, false) +"->"+methodName;
                            params.add(0, new ExprDef(varName));
                        }
                    }
                }
            }
        } else {
            // resolve constructors
            for (ClassDef classDef : DefFactory.CLASS_DEFS) {
                if (classDef.name.equals(name)) {
                    String sig = getSignature();
                    for (ConstructorDef def : classDef.constructorDefs) {
                        if (sig.equals(def.getSignature())) {
                            resolvedTo = def;
                        }
                    }

                    if (resolvedTo == null) {
                        throw new RuntimeException("No matching function found " + sig + " " + classDef.name);
                    }

                    returnPrimative = false; 
                    thisType = new TypeIdDef(name);  
                }
            }

            if (containedInBlock == null) {
                throw new RuntimeException("containedInBlock == null");
            }

            if (resolvedTo == null) {
                VariableDef cd = containedInBlock.resolveVariable("this");
                resolvedTo = DefFactory.resolveFunction(cd, name);
                if (resolvedTo != null) {
                    thisType = ((FunctionDef)resolvedTo).returnType;
                    classMethod = true;
                }
            }

            // resolve the return type
            for (FunctionDef funct : DefFactory.FUNCT_DEFS) {
                if (funct.name.equals(name)) {
                    
                    thisType = funct.returnType;

                    if (name.equals("String")) {
                        name = "/* fce */  create_String$1";
                    }

                    if (name.equals("I64")) {
                        name = "Boxing_i64_create";
                        thisType.setIs_boxed(true);
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
                return var.type.getName();
            }
        }

        for (VariableDef var : DefFactory.VAR_DEFS) {
            if (var.getName().equals(varName)) {
                return var.type.getName();
            }
        }

        // a static refence?
        ClassDef cd = DefFactory.resolveClass(varName);
        if (cd != null) {
            staticMethod = true;
            return varName;
        }

        throw new RuntimeException("Class not resolved " + varName);
    }

    public FunctionCallExpr() {
    }

    public void setName(String name) {
        this.name = name;
    }

    private String paramsAsCode(String res) {
        // String res = "";

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
                return hasNot + "create_"+resolvedTo.getExpandedName() + "("+ paramsAsCode("") + ")" ; 
            } else {
                if (staticMethod) {
                    return hasNot +"/* functioncall 4 */ "
                        + SnippetFactory.classModelStatement(name,"",true)
                        +"->" + resolvedTo.getExpandedName()  + "("+ paramsAsCode("") + ")" ; 
                } else  if (classMethod) {
                    // ((MyStringClassModel *)useObject(this)->classmodel
                    VariableDef cd = containedInBlock.resolveVariable("this");                    
                    return hasNot +"/* functioncall 3 */"+ SnippetFactory.classModelStatement(cd.type.getName(), "this", false) 
                        +"->" + resolvedTo.getExpandedName()  + "("+ paramsAsCode("this") + ")" ; 
                } else {
                    return hasNot + "/* functioncall 1 */"+  resolvedTo.getExpandedName() + "("+ paramsAsCode("") + ")" ; 
                }
            }
        }
        return hasNot + "/* functioncall 2 "+expr+" */"+  name + "("+ paramsAsCode("") + ")" ; 
    }

    @Override
    public String toString() {
        return "FunctionCallExpr [name=" + name + ", params=" + params + ", returnPrimative=" + returnPrimative + "]";
    }
}