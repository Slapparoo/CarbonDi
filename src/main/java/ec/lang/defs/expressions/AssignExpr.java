package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class AssignExpr extends StatementDef {
    
    public ExprDef assignLeft;
    // = += ...
    public ExprDef assignOperator;
    public ExprDef assignRight;

    private boolean classVar = false;


    @Override
    public void resolve_01() {
        if (assignRight instanceof TypeExpr) {
            ((TypeExpr)assignRight).isGet = true;
        }

        assignRight.resolve_01();

        System.out.println("@@AssignExpr.resolve " + assignLeft.expr);

        if (assignLeft.expr.contains(".")) {
            classVar = true;
            // resolve the class
            String[] tokens = assignLeft.expr.split("\\.");
            if (tokens.length == 2) {
                // resolve object 
                VariableDef var = DefFactory.resolveVariable(tokens[0]);

                assignLeft.expr = "get" + var.type.name + "ClassModel()->set_" + tokens[1] + "(" + tokens[0] + ", "+assignRight.asCode()+")";
                // type
                ClassDef classDef = DefFactory.resolveClass(var.type.name);
                for (VariableDef def : classDef.properties) {
                    if (def.getName().equals(tokens[1])) {
                        assignLeft.thisType = def.type;
                        break;
                    }
                }  
            }
        }
        super.resolve_01();
    }


    public AssignExpr(String assignLeft, String assignOperator, ExprDef assignRight) {
        this.assignLeft = new TypeExpr(assignLeft);
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }

    // @Override
    public String asCode() {
        if (classVar) {
            return "/* AssignExpr */" + assignLeft.asCode() + ";";
        }
        return "/* AssignExpr */" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
    }
}