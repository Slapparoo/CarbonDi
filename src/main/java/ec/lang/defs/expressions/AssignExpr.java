package ec.lang.defs.expressions;

import ec.lang.defs.ExprDef;
import ec.lang.defs.StatementDef;

public class AssignExpr extends StatementDef {
    
    public ExprDef assignLeft;
    // = += ...
    public ExprDef assignOperator;
    public ExprDef assignRight;

    private boolean classVar = false;

    // private String classModelStatement(String className, String varname) {

    //     if (TypeIdDef.isPrimative(className) ) {
    //         throw new RuntimeException("Not a class type " + className + ", " + varname);
    //     }

    //     return "(("+className+"ClassModel*)useObject("+varname+")->classmodel)";
    // }

    @Override
    public void resolve_01() {
        if (assignRight instanceof MultiTypeId) {
            ((MultiTypeId)assignRight).setIsGet(true);;
        }

        assignRight.containedInBlock = containedInBlock;
        assignRight.resolve_01();

        if (assignOperator.expr.equals("=")) {
            if (assignLeft instanceof MultiTypeId) {
                ((MultiTypeId)assignLeft).setIsGet(false);;
            }
        
            assignLeft.containedInBlock = containedInBlock;
            assignLeft.resolve_01();
        } else {
            if (assignLeft instanceof MultiTypeId) {
                ((MultiTypeId)assignLeft).setIsGet(true);;
            }
        
            assignLeft.containedInBlock = containedInBlock;
            assignLeft.resolve_01();

            // throw new RuntimeException("Some assign types aren't implemented yet like " + assignOperator.expr);
        }



        
        super.resolve_01();
    }


    public AssignExpr(ExprDef assignLeft, String assignOperator, ExprDef assignRight) {
        this.assignLeft = assignLeft;
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;

        // System.out.println("@@Assign " + this.assignLeft + " " + this.assignOperator + " " + this.assignRight);
    }

    public AssignExpr(String assignLeft, String indexValue, String assignOperator, ExprDef assignRight) {
        this.assignLeft = new TypeExpr(assignLeft, indexValue);
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }


    // @Override
    public String asCode() {
        if (classVar) {
            return "/*Ax1*/" + assignLeft.asCode() + ";";
        }

        // TODO +=, -= ...
        if (!assignOperator.expr.equals("=")) {
            return "/*Ax7*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
        }


        if (assignLeft instanceof MultiTypeExpr) {
            MultiTypeExpr al = (MultiTypeExpr)assignLeft;
            if (al.isProperty) {
                return "/*Ax2*/" + al.asCode() + assignRight.asCode() + ");";
            }

            if (!assignLeft.thisType.isPrimative()) {
                return "/*Ax3*/" + al.asCode() + assignRight.asCode() + ");";
            }

            // local var
            if (al.type_id_list.size() == 1) {
                return "/*Ax6*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
            }

            if (!al.getIsGet() && !ArrayIndexExpr.ARRAY_TYPES.contains(al.thisType.getObjectType())   ) {
                
                // prepare_03 not called yet
                al.asCode();
                // System.out.println("@@al " + al + " " + al.directAccess);
                if (!al.directAccess) {
                    return "/*Ax5*/" + al.asCode() + assignRight.asCode() + ");";
                }
            }
        }

        // System.out.println("@@assignLeft " + assignLeft.getClass() + " " + assignLeft.expr);

        return "/*Ax4*/" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
    }
}