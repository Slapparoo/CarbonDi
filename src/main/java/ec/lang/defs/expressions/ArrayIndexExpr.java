package ec.lang.defs.expressions;

import java.util.Set;

import ec.lang.defs.ExprDef;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.VariableDef;

public class ArrayIndexExpr extends TypeExpr {
    public boolean resolved = false;
    private VariableDef variableDef = null;

    public static final Set<String> ARRAY_TYPES = Set.of("Array", "RefArray", "DynamicArray", "DynamicRefArray");

    public void resolve_01() {
        arrayIndex.containedInBlock = containedInBlock;
        super.resolve_01();
    }

    @Override
    public String asCode() {
        arrayIndex.containedInBlock = containedInBlock;
        arrayIndex.resolve_01();
        if (thisType == null) {
            return "/* thisType == null  " + arrayIndex.asCode() + " */" + super.asCode();
        }

        boolean isStatic = (variableDef != null ? variableDef.is_static : false);

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