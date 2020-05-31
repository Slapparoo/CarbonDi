package ec.lang.defs.expressions;

import java.util.HashSet;
import java.util.Set;

import ec.lang.defs.ExprDef;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.VariableDef;

public class ArrayIndexExpr extends TypeExpr {
    // public ExprDef arrayIndex = null;
    public boolean resolved = false;
    private VariableDef variableDef = null;

    public static final Set<String> ARRAY_TYPES = new HashSet<>();

    static {
        ARRAY_TYPES.add("Array");
        ARRAY_TYPES.add("RefArray");
        ARRAY_TYPES.add("DynamicArray");
        ARRAY_TYPES.add("DynamicRefArray");
    }

    public void resolve_01() {
        super.resolve_01();
    }

    @Override
    public String asCode() {
        arrayIndex.resolve_01();
        if (thisType == null) {
            return "/* thisType == null  " + arrayIndex.asCode() + " */" + super.asCode();
        }

        boolean isStatic = (variableDef != null ? variableDef.is_static : false);

        
        // System.out.println("@@arayIndexExpr " + variableDef);
        // System.out.println("@@arayIndexExpr " + resolvedExpr);
        // System.out.println("@@arayIndexExpr " + thisType);


        if (thisType.isPrimative()) {
            isGet = true;
            return "/*at3*/*(" + thisType.getName() + "*)"
                    + SnippetFactory.classModelStatement("Array", super.expr, isStatic) + "->get(" + super.expr
                    + ", " + arrayIndex.asCode() + ")";
        } else {
            if (isGet) {
                return "/*te4*/ *((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get("+super.expr+", " + arrayIndex.asCode() + "))";
            } else {
                return "((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->setObject("+super.expr+", " + arrayIndex.asCode() + ",";
            }

        }
    }

    public ArrayIndexExpr(String value, ExprDef exprDef, String debug) {
        super(value, exprDef);
    }

    @Override
    public String toString() {
        return "aix " + expr +  "[" + arrayIndex + "]";
    }
}