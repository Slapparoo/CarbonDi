package ec.lang;

import org.antlr.v4.runtime.tree.ParseTree;

import ec.lang.model.ecBaseVisitor;
import ec.lang.model.ecParser;

public class CVisit extends ecBaseVisitor<Object> {

    @Override
    public Object visitStatement(ecParser.StatementContext ctx) {
        System.out.println("ctx:" +ecParser.ruleNames[ctx.getRuleIndex()] + " " + ctx.getRuleIndex());
        System.out.println("ctx:" +ctx.getText());
        return super.visitStatement(ctx);
    }


    @Override
    public Object visitJson_obj(ecParser.Json_objContext ctx) {
        System.out.println("json_object:" +ctx.getText());
        return super.visitJson_obj(ctx);
    }

    @Override
    public Object visitFunction_definition(ecParser.Function_definitionContext ctx) {
        System.out.println("function def:" +ctx.getText());
        System.out.println("chidren:" +ctx.getChildCount());

        return super.visitFunction_definition(ctx);
    }

    @Override
    public Object visitFunction_implementation(ecParser.Function_implementationContext ctx) {
        System.out.println("function impl:" +ctx.getText());
        System.out.println("chidren:" +ctx.getChildCount());

        return super.visitFunction_implementation(ctx);
    }
    

    @Override
    public Object visit(ParseTree tree) {
        System.out.println("visit : " + tree);
        return super.visit(tree);
    }

}
