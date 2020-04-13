package ec.lang.defs.expressions;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.ExprDef;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.VariableDef;

public class TypeExpr extends ExprDef {
    public boolean isGet = false;
    public ExprDef arrayIndex = null;
    public boolean resolved = false;
    private String resolvedExpr = "";
    private VariableDef variableDef = null;

    @Override
    public void resolve_01() {
        resolved = true;
        if (expr.contains(".")) {
            String[] tokens = expr.split("\\.");
            if (tokens.length == 2) {
                // resolve object
                if (containedInBlock == null) {
                    throw new NullPointerException("containedInBlock == null " + expr);
                }

                VariableDef var = containedInBlock.resolveVariable(tokens[0]);
                if (var != null && var.type != null) {
                    if (var.type.isIs_array()) {
                        resolvedExpr = "/*te7*/"+ "(" + var.type.asCode() + "*)" 
                        + SnippetFactory.classModelStatement("Array", tokens[0], var.is_static) 
                        + "->get_" + tokens[1] + "(" + tokens[0] + ")";
                    } else {
                        ClassDef cd = DefFactory.resolveClass(var.type.getName());
                        if (cd == null) {
                            throw new RuntimeException("Cannot resolve class " + var.type.getName() + " for variable " + var.getName());
                        } 

                        VariableDef pr = cd.resolveProperty(tokens[1]);
                        if (pr == null) {
                            throw new RuntimeException("Cannot resolve property for class " + var.type.getName() + " for variable " + var.getName());
                        }
                        if (pr.is_static) {
                            isProperty = true;
                            resolvedExpr = "/*te6*/"
                            + SnippetFactory.classModelStatement(var.type.getName(), tokens[0], pr.is_static) 
                            + "->get_" + tokens[1] + "()";
                        } else {
                            isProperty = true;
                            if (isGet) {
                                resolvedExpr = "/*te6a*/"
                                + SnippetFactory.classModelStatement(var.type.getName(), tokens[0], pr.is_static) 
                                + "->get_" + tokens[1] + "("
                                + tokens[0] + ")";
                            } else {
                                resolvedExpr = "/*te6b*/"
                                + SnippetFactory.classModelStatement(var.type.getName(), tokens[0], pr.is_static) 
                                + "->set_" + tokens[1] + "(" + tokens[0] + ", ";
                                
                            }
                        }
                    }
                    // type
                    if (var.type.isPrimative()) {
                        thisType = var.type;
                        variableDef = var;
                    } else {
                        ClassDef classDef = DefFactory.resolveClass(var.type.getName());
                        for (VariableDef def : classDef.properties) {
                            if (def.getName().equals(tokens[1])) {
                                thisType = def.type;
                                variableDef = def;
                                break;
                            }
                        }
                    }
                } else {
                    ClassDef cd = DefFactory.resolveClass(tokens[0]);
                    if (cd == null) {
                        throw new RuntimeException("Cannot resolve class " + tokens[0] + " for variable " + tokens[1]);
                    } 

                    VariableDef pr = cd.resolveProperty(tokens[1]);
                    if (pr == null) {
                        throw new RuntimeException("Cannot resolve property for class " +tokens[0] + " for variable " + tokens[1]);
                    }
                    if (pr.is_static) {
                        isProperty = true;
                        if (isGet) {
                            resolvedExpr = "/*te12*/"
                            + SnippetFactory.classModelStatement(tokens[0], "", pr.is_static) 
                            + "->get_" + tokens[1] + "()";
                        } else {
                            resolvedExpr = "/*te13*/"
                            + SnippetFactory.classModelStatement(tokens[0], "", pr.is_static) 
                            + "->set_" + tokens[1] + "(";
                        }
                    }
                }
            }
        } else {
            if (containedInBlock == null) {
                System.out.println("\033[1;33m" + "[warning] containedInBlock == null " + this + "\033[0m");
            } else {
                VariableDef var = containedInBlock.resolveVariable(expr);

                if (var != null) {
                    thisType = var.type;
                    variableDef = var;
                } else if (containedInBlock.isClass)  {
                    VariableDef cd = containedInBlock.resolveVariable("this");
                    var = DefFactory.resolveProperty(cd, expr);
                    if (var != null) {
                        // ok
                        isProperty = true;
                        thisType = var.type;
                        variableDef = var;
                        if (isGet) {
                            resolvedExpr = "/*te1*/"+ SnippetFactory.classModelStatement(cd.type.getName(), "this", var.is_static) + "->get_" + expr + "(this)";
                        } else {
                            resolvedExpr = "/*te2*/"+ SnippetFactory.classModelStatement(cd.type.getName(), "this", var.is_static) + "->set_" + expr + "(this,";
                        }
                    } else {
                        // static?
                        if (containedInBlock.classDef == null) {
                            throw new RuntimeException("Contained in class is null" + expr);
                        }
                        variableDef = containedInBlock.classDef.resolveProperty(expr);
                        if (variableDef != null) {

                            if (isGet) {
                                resolvedExpr = "/*te9*/"+ SnippetFactory.classModelStatement(containedInBlock.classDef.name, "", true) + "->get_" + expr + "()";
                            } else {
                                resolvedExpr = "/*te10*/"+ SnippetFactory.classModelStatement(containedInBlock.classDef.name, "", true) + "->set_" + expr + "(,";
                            }
                        }


                    }
                }
                if (variableDef == null) {
                    throw new RuntimeException(getLine() +  " variable cannot be resolved " + expr);
                }

            }
        }

        if (arrayIndex != null) {
            arrayIndex.resolve_01();
            ;
        }
        super.resolve_01();
    }

    @Override
    public String asCode() {
        if (arrayIndex != null) {
            arrayIndex.resolve_01();
            if (thisType == null) {
                return "/* thisType == null  " + arrayIndex.asCode() + " */" + super.asCode();
            }

            boolean isStatic = (variableDef != null ? variableDef.is_static: false);

            if (thisType.isPrimative()) {
                return "/*te3*/*(" + thisType.asCode() + "*)" + SnippetFactory.classModelStatement("Array", super.asCode(), isStatic) + "->get("
                        + super.asCode() + ", " + arrayIndex.asCode() + ")";
            } else {
                if (isGet) {
                    return "/*te4*/*(" + thisType.asCode() + "*)" + SnippetFactory.classModelStatement("RefArray", super.asCode(), isStatic) + "->get("
                            + super.asCode() + ", " + arrayIndex.asCode() + ")";
                } else {
                    return "/*te5*/"+SnippetFactory.classModelStatement("RefArray", super.asCode(), isStatic) + "->setObject(" + super.asCode() + ", "
                            + arrayIndex.asCode() + ",";
                }
            }
        }

        if (resolvedExpr.length() > 0) {
            return resolvedExpr;
        } 

        return "/*te8*/"+ super.asCode();
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
    }

    @Override
    public String toString() {
        return "TypeExpr [arrayIndex=" + arrayIndex + ", isGet=" + isGet + "]" + super.toString();
    }
}