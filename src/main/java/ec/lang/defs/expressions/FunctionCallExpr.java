package ec.lang.defs.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ec.lang.defs.ConstructorDef;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.SnippetFactory;
import ec.lang.defs.VariableDef;
import lombok.Getter;
import lombok.Setter;

public class FunctionCallExpr extends ExprDef implements MultiTypeId {
    public List<ExprDef> params = new ArrayList<>();
    @Getter
    @Setter
    private String name;
    private FunctionDefBase resolvedTo;
    public boolean classMethod = false;
    private String resolve02 = "";
    public boolean isExternal = false;

    public static String FUNCTION_SIG_FORMAT = "%s (*%s)(%s)";

    private String sigReturnType() {
        if (getThisType() == null) {
            return "num";
        }
        return (getThisType().getName().equals("void") ? "void" : getThisType().asCode())
                + (getThisType().isIs_array() ? "*" : "");
    }

    public String getSignature() {
        return String.format(FUNCTION_SIG_FORMAT, sigReturnType(), name, getParamsSignature());
    }

    public String getParamsSignature() {
        return params.stream()
                .map(p -> p.getThisType() == null ? "<unknown>" : p.getThisType().getName())
                .collect(Collectors.joining(", "));
    }

    public FunctionCallExpr() {
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
        if (resolvedTo != null && !isExternal) {
            if (resolvedTo instanceof ConstructorDef) {
                return hasNot + "/*cd1*/ create_" + resolvedTo.getExpandedName() + "(" + paramsAsCode("") + ")";
            } else {
                if (resolvedTo.is_static) {
                    return hasNot + "/*fc4*/ "
                            + SnippetFactory.classModelStatement(resolvedTo.classDef.getCName(), "", true) + "->"
                            + resolvedTo.getExpandedName() + "(" + paramsAsCode("") + ")";
                } else if (classMethod) {
                    // ((MyStringClassModel *)useObject(this)->classmodel
                    VariableDef cd = getContainedInBlock().resolveVariable("this");
                    return hasNot + "/*fc3*/" + SnippetFactory.classModelStatement(cd.type.getName(), "this", false)
                            + "->" + resolvedTo.getExpandedName() + "(" + paramsAsCode("this") + ")";
                } else if (resolvedTo.classDef != null) {

                    // @todo, create a local var for resolve02

                    if (resolve02.length() == 0) {
                        resolve02 = "this";
                    }

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
            exprDef.setContainedInBlock(getContainedInBlock());
            if (!exprDef.isResolved()) {
                exprDef.resolve_01();
            }
        }
    }

    @Override
    public void resolve_01() {
        if (getContainedInBlock() == null) {
            throw new NullPointerException("FunctionCallExpr containedInBlock == null" + name);
        }

        for (ExprDef exprDef : params) {
            if (exprDef instanceof TypeExpr) {
                ((TypeExpr) exprDef).setIsGet(true);
            }
            exprDef.setContainedInBlock(getContainedInBlock());
            if (!exprDef.isResolved()) {

                if (exprDef.getContainedInBlock() == null) {
                    throw new NullPointerException(
                            "FunctionCallExpr exprDef.containedInBlock == null" + name + " " + exprDef);
                }
                exprDef.resolve_01();
            }
        }

        super.resolve_01();
    }

    @Override
    public void resolve_02(String red_id) {
        resolve02 = red_id;
        resolve_01();
    }

    @Override
    public void setIsGet(boolean isGet) {
        // a bit wierd
    }
}