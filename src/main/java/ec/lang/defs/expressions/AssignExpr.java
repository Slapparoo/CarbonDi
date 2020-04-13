package ec.lang.defs.expressions;

import ec.lang.defs.*;

public class AssignExpr extends StatementDef {
    
    public ExprDef assignLeft;
    // = += ...
    public ExprDef assignOperator;
    public ExprDef assignRight;

    private boolean classVar = false;

    private String classModelStatement(String className, String varname) {

        if (TypeIdDef.isPrimative(className) ) {
            throw new RuntimeException("Not a class type " + className + ", " + varname);
        }

        return "(("+className+"ClassModel*)useObject("+varname+")->classmodel)";
    }

    @Override
    public void resolve_01() {
        if (assignRight instanceof TypeExpr) {
            ((TypeExpr)assignRight).isGet = true;
        }

        assignRight.containedInBlock = containedInBlock;
        assignRight.resolve_01();

        // System.out.println("@@AssignExpr.resolve " + assignLeft.expr);

        assignLeft.containedInBlock = containedInBlock;
        assignLeft.resolve_01();

        // if (assignLeft.expr.contains(".")) {
        //     classVar = true;
        //     // resolve the class
        //     String[] tokens = assignLeft.expr.split("\\.");

        //     if (tokens.length == 2) {
        //         // resolve object 
        //         VariableDef var = containedInBlock.resolveVariable(tokens[0]);

                
        //         if (var == null) {
        //             // static reference?
        //             ClassDef cd = DefFactory.resolveClass(tokens[0]);
        //             if (cd != null) {
        //                 // "(("+getClassVar()+"ClassModel*)get"+getClassVar()+"ClassModel())->"
        //                 assignLeft.expr = "(("+tokens[0]+"ClassModel*)get" + tokens[0] + "ClassModel())->set_" + tokens[1] + "("+assignRight.asCode()+")";
        //             }
                    
        //             for (VariableDef def : cd.properties) {
        //                 if (def.getName().equals(tokens[1])) {
        //                     assignLeft.thisType = def.type;
        //                     break;
        //                 }
        //             }  
        //         } else {

        //             //  ((SimpleObject1ClassModel *)useObject(_refId)->classmodel)->set_count1(_refId, count1);
        //             assignLeft.expr = classModelStatement(var.type.getName(), tokens[0])+"->set_" + tokens[1] + "(" + tokens[0] + ", "+assignRight.asCode()+")";

        //             // assignLeft.expr = "((" + var.type.getName() + "ClassModel*)useObject(" + tokens[0] + ")->classmodel)->set_" + tokens[1] + "(" + tokens[0] + ", "+assignRight.asCode()+")";
        //             // type
        //             ClassDef classDef = DefFactory.resolveClass(var.type.getName());
        //             for (VariableDef def : classDef.properties) {
        //                 if (def.getName().equals(tokens[1])) {
        //                     assignLeft.thisType = def.type;
        //                     break;
        //                 }
        //             }  
        //         }
        //     }


            // String[] tokens = assignLeft.expr.split("\\.");
/*
            int i = 0;
            if (tokens.length > 1) {
                VariableDef var = null;
                while (i < tokens.length -1) {
                    System.out.println("@@resolving token " + tokens[i]);
                    var = containedInBlock.resolveVariable(tokens[i]);

                    if (var != null && var.type != null ) {
                        System.out.println("@@resolving token " + tokens[i] + ", " + var.type.name);
                    } else {
                        System.out.println("@@resolving token " + tokens[i] + " not found.");
                    }
                    i++;
                }

                ClassDef classDef = DefFactory.resolveClass(var.type.name);
                for (VariableDef def : classDef.properties) {
                    System.out.println("@@resolving token " + tokens[i] + " " + def.getName());
                    if (def.getName().equals(tokens[i])) {
                        System.out.println("@@resolving token " + tokens[i] + " " + def.type);
                        break;
                    }
                }  

            }
            */

        // }
        super.resolve_01();
    }


    public AssignExpr(String assignLeft, String assignOperator, ExprDef assignRight) {
        this.assignLeft = new TypeExpr(assignLeft);
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }

    public AssignExpr(String assignLeft, String indexValue, String assignOperator, ExprDef assignRight) {
        this.assignLeft = new TypeExpr(assignLeft, indexValue);
        this.assignOperator = new TypeExpr(assignOperator);
        this.assignRight = assignRight;
    }


    // @Override
    public String asCode() {
        if (classVar) {
            return "/* AssignExpr */" + assignLeft.asCode() + ";";
        }

        if (assignLeft instanceof TypeExpr) {
            if (((TypeExpr)assignLeft).arrayIndex != null && !assignLeft.thisType.isPrimative()) {
                return "/* AssignExpr array */" + assignLeft.asCode() + assignRight.asCode() + ");";
            }

            if (((TypeExpr)assignLeft).isProperty) {
                return "/* AssignExpr array */" + assignLeft.asCode() + assignRight.asCode() + ");";
            }
        }


        return "/* AssignExpr */" + assignLeft.asCode() + assignOperator.asCode() + assignRight.asCode() + ";";
    }
}