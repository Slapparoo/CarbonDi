package ec.lang.defs.expressions;

import ec.lang.defs.ExprDef;
import ec.lang.defs.OperatorTypes;
import ec.lang.defs.StatementDef;

public class AssignExpr extends StatementDef {

    public ExprDef assignLeft;
    // = += ...
    public ExprDef assignOperator;
    public ExprDef assignRight;

    private boolean classVar = false;

    @Override
    public void resolve_01() {
        if (assignRight instanceof MultiTypeId) {
            ((MultiTypeId) assignRight).setIsGet(true);
            ;
        }

        assignRight.setContainedInBlock(getContainedInBlock());
        assignRight.resolve_01();

        if (assignOperator.expr.equals("=")) {
            if (assignLeft instanceof MultiTypeId) {
                ((MultiTypeId) assignLeft).setIsGet(false);
                ;
            }

            assignLeft.setContainedInBlock(getContainedInBlock());
            assignLeft.resolve_01();
        } else {
            if (assignLeft instanceof MultiTypeId) {
                ((MultiTypeId) assignLeft).setIsGet(true);
                ;
            }

            assignLeft.setContainedInBlock(getContainedInBlock());
            assignLeft.resolve_01();
        }
        super.resolve_01();
    }

    public AssignExpr(ExprDef assignLeft, String assignOperator, ExprDef assignRight) {
        this.assignLeft = assignLeft;
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }

    public AssignExpr(String assignLeft, String indexValue, String assignOperator, ExprDef assignRight) {
        this.assignLeft = new TypeExpr(assignLeft, indexValue);
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }

    public String asCode() {
        if (classVar) {
            return "/*Ax1*/" + assignLeft.asCode() + ";";
        }

        // TODO +=, -= ...
        if (OperatorTypes.ASSIGNEQUALS.contains(assignOperator.expr)) {
            if (assignLeft instanceof MultiTypeExpr) {
                MultiTypeExpr al = (MultiTypeExpr) assignLeft;
                al.directAccess = true;
            }

            return "/*Ax7*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
        }

        if (assignLeft instanceof MultiTypeExpr) {
            MultiTypeExpr al = (MultiTypeExpr) assignLeft;
            if (al.isProperty) {
                if (al.getContainedInBlock().directAccess.contains(al.getVariableDef().getName())) {
                    al.directAccess = true;
                }

                if (al.directAccess) {
                    return "/*Ax2a*/" + al.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
                } else {
                    return "/*Ax2*/" + al.asCode() + assignRight.asCode() + ");";
                }
            }

            if (assignLeft.getThisType() != null && !assignLeft.getThisType().isPrimative()) {
                return "/*Ax3*/" + al.asCode() + assignRight.asCode() + ");";
            }

            // local var
            if (al.type_id_list.size() == 1) {
                assignLeft.setContainedInBlock(getContainedInBlock());
                assignOperator.setContainedInBlock(getContainedInBlock());
                assignRight.setContainedInBlock(getContainedInBlock());
                return "/*Ax6*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
            }

            if (al.getThisType() == null) {
                resolve_01();
                if (al.getThisType() == null) {
                    throw new RuntimeException("al.getThisType() " + asDebug() + al);
                }
            }

            if (!al.getIsGet() && (al.getThisType().getObjectType() == null
                    || !ArrayIndexExpr.ARRAY_TYPES.contains(al.getThisType().getObjectType()))) {

                // prepare_03 not called yet
                al.asCode();
                if (!al.directAccess) {
                    return "/*Ax5*/" + al.asCode() + assignRight.asCode() + ");";
                }
            }
        }

        return "/*Ax4*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
    }
}