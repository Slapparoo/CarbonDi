package ec.lang.defs.expressions;

import ec.lang.defs.ClassDef;
import ec.lang.defs.ExprDef;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;

public class TypeExpr extends ExprDef implements MultiTypeId {
    public ExprDef arrayIndex = null;
    protected boolean isGet = true;
    public boolean resolved = false;
    public String resolvedExpr = "";
    public VariableDef variableDef = null;
    public ClassDef memberOf = null;
    public boolean is_static = false;
    public boolean directAccess = false;


    @Override
    public void resolve_02(String red_id) {
        super.resolve_01();
    }

    @Override
    public void resolve_01() {
        super.resolve_01();
    }

    @Override
    public void prepare_03() {
        if (variableDef == null) {
            if (expr.startsWith("$")) {
                // FIXME
                variableDef = new VariableDef();
                variableDef.type = new TypeIdDef("i64");
                thisType= variableDef.type;
            }
        }
        if (variableDef != null && variableDef.is_static) {
            prepare_03("");
        }

        if (memberOf != null && containedInBlock.directAccess.contains(expr)) {
            // System.out.println("@@direct access " + expr);
            directAccess = true;
        }

        super.prepare_03();
    }

    public void prepare_03(String ref_id) {
        if (variableDef == null) {
            throw new RuntimeException("variableDef == null " + expr + " " + isResolved() + " " + getLine()  );
        }

        if (arrayIndex != null) {
            boolean isStatic = (variableDef != null ? variableDef.is_static : false);

            if (thisType.isPrimative()) {
                resolvedExpr = "/*te3*/*(" + thisType.asCode() + "*)"
                        + SnippetFactory.classModelStatement("Array", super.asCode(), isStatic) + "->get("
                        + super.asCode() + ", " + arrayIndex.asCode() + ")";
            } else {
                if (isGet) {
                    resolvedExpr = "/*te4*/*(" + thisType.asCode() + "*)"
                            + SnippetFactory.classModelStatement("RefArray", super.asCode(), isStatic) + "->get("
                            + super.asCode() + ", " + arrayIndex.asCode() + ")";
                } else {
                    resolvedExpr = "/*te5*/" + SnippetFactory.classModelStatement("RefArray", super.asCode(), isStatic)
                            + "->setObject(" + super.asCode() + ", " + arrayIndex.asCode() + ",";
                }
            }
            return;
        }        
        // array

        if (memberOf != null && containedInBlock.directAccess.contains(expr)) {
            // System.out.println("@@direct access " + expr);
            directAccess = true;
        }

        if (variableDef.is_static) {
            is_static = true;
            // isProperty = true;
            if (directAccess) {
                if (isGet) {
                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te14da*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr ;
                    } else {
                        resolvedExpr = "/*te141da*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr + "()";
                    }
                } else {
                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te14cda*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr ;
                    } else {
                        resolvedExpr = "/*te14c1da*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr + "(";
                    }
                }
            } else {
                if (isGet) {

                    // System.out.println(variableDef);

                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te14*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->get_" + expr + "()";
                    } else {
                        resolvedExpr = "/*te141*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr + "()";
                    }
                } else {
                    if (variableDef.functionDef == null) { 
                        resolvedExpr = "/*te14c*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->set_" + expr + "(";
                    } else {
                        resolvedExpr = "/*te14c1*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), expr, true) 
                        + "->" + expr + "(";
                    }
                }
            }
        } else {
            if (memberOf == null) {
                if (ref_id != null) {
                    throw new RuntimeException("ref_id != null - " + expr + ", " + ref_id);
                }

                resolvedExpr = "/*te14e*/"
                + expr;

                return;
            }

            // Direct static Access?
            if (memberOf.getShortname().equals(variableDef.getName())) {
                resolvedExpr = "/*te14f*/"
                + expr;

                return;
            }


            if (directAccess) {
                // directly access through the data model, rather than through the acessors
                if (isGet) {
                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te15a*/"
                        + SnippetFactory.dataModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr;
                    } else {
                        resolvedExpr = "/*te15a1*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr + "("
                        + ref_id + ")";
                    }
                } else {
                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te15b*/"
                        + SnippetFactory.dataModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr ;
                    } else {
                        resolvedExpr = "/*te15b1*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr + "(" + ref_id + ", ";
                    }
                }

            } else {
                if (isGet) {

                    /** @TODO 
                     * make a function "class model" variable, then use the variable, navigate backwards to find the function 
                     * statement block
                     */


                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te14a*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->get_" + expr + "("
                        + ref_id + ")";
                    } else {
                        resolvedExpr = "/*te14a1*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr + "("
                        + ref_id + ")";

                    }
                } else {
                    if (variableDef.functionDef == null) {
                        resolvedExpr = "/*te14b*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->set_" + expr + "(" + ref_id + ", ";
                    } else {
                        resolvedExpr = "/*te14b1*/"
                        + SnippetFactory.classModelStatement(memberOf.getCName(), ref_id, false) 
                        + "->" + expr + "(" + ref_id + ", ";
                    }
                }
            }
        }
    }

    @Override
    public String asCode() {
        if (resolvedExpr.length() > 0) {
            return resolvedExpr;
        }

        return "/*te8*/" + super.asCode();
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
        if (indexValue.matches("[0-9_]*")) {
            arrayIndex = new ConstExpr(indexValue);
        } else {
            arrayIndex = new TypeExpr(indexValue);
        }
    }

    @Override
    public String toString() {
        return expr;
    }

    @Override
    public void setIsGet(boolean isGet) {
        this.isGet = isGet;
    }
}