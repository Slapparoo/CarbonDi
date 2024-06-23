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
        arrayIndex.setContainedInBlock(getContainedInBlock());
        super.resolve_01();
    }

    @Override
    public String asCode() {
        arrayIndex.setContainedInBlock(getContainedInBlock());
        arrayIndex.resolve_01();
        if (getThisType() == null) {
            return "/* getThisType() == null  " + arrayIndex.asCode() + " */" + super.asCode();
        }

        boolean isStatic = (variableDef != null ? variableDef.is_static : false);

        if (getThisType().isPrimative()) {
            isGet = true;
            return "/*at3*/*(" + getThisType().getName() + "*)"
                    + SnippetFactory.classModelStatement("Array", super.expr, isStatic) + "->get(" + super.expr
                    + ", " + arrayIndex.asCode() + ")";
        } else {
            String type = thisType.getObjectType() != null ? thisType.getObjectType() : thisType.getName();
            if (isGet) {
                if (type.equals("DynamicArray")) {
                    return "*((c_2106303_%s_cm*)getc_2106303_%s_cm())->getValue(".formatted(type, type)
                            + super.expr + ", "
                            + arrayIndex.asCode() + ")";
                }

                return "/*te4*/ *((num *)((c_2106303_%s_cm*)getc_2106303_%s_cm())->get(".formatted(type, type)
                        + super.expr + ", "
                        + arrayIndex.asCode() + "))";
            } else {
                if (type.equals("RefArray")) {
                    // by ref
                    return "((c_2106303_%s_cm*)getc_2106303_%s_cm())->setObject(".formatted(type, type)
                            + super.expr + ", "
                            + arrayIndex.asCode() + ",";
                } else if (type.equals("DynamicArray")) {
                    return "((c_2106303_%s_cm*)getc_2106303_%s_cm())->setValue(".formatted(type, type)
                            + super.expr + ", "
                            + arrayIndex.asCode() + ", &";
                } else {
                    // by value pointer
                    return "((c_2106303_%s_cm*)getc_2106303_%s_cm())->set(".formatted(type, type)
                            + super.expr + ", "
                            + arrayIndex.asCode() + ", &";
                }
            }
        }
    }

    public ArrayIndexExpr(String value, ExprDef exprDef, String debug) {
        super(value, exprDef);
    }

    @Override
    public String toString() {
        return "aix " + expr + "[" + arrayIndex + "]";
    }
}