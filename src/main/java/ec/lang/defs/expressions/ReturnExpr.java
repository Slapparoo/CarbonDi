package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class ReturnExpr extends StatementDef {
    // // public ExprDef rExpr;
    // public BlockDef containedInblock;

    @Override
    public void resolve_01() {
        System.out.println("@@ReturnExpr.resolve");
        statement.containedInBlock = containedInBlock;
        statement.resolve_01();
        containedInBlock.hasReturn = true;
        super.resolve_01();
    }

    // @Override
    public String asCode() {
        // select the appropriate exti return
        // __exitReturn_i64....
        // __exitReturn_ref


        if (statement.thisType == null) {
            //
            System.out.println("\033[0;31m@@ReturnExpr.asCode return type unknown\033[0m" + statement);
            return "return __exitReturn_num(" + statement.asCode() + ");";
        }

        System.out.println("\033[0;31m@@ReturnExpr.asCode return type "+statement.thisType+" "+statement.thisType.name+" \033[0m");

        if (statement.thisType.isPrimative()) {
            return "return __exitReturn_" + statement.thisType.name + "(" + statement.asCode() + ");";
        } else {

            System.out.println("\033[0;31m@@ReturnExpr.asCode return ref "+statement.thisType.name+" \033[0m");
            return "return __exitReturn_ref(" + statement.asCode() + ");";
        }
    }
}