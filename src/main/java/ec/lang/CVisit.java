package ec.lang;

import ec.lang.gen.*;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class CVisit extends ecBaseVisitor {

    @Override
    public Object visitStatement(ecParser.StatementContext ctx) {
        // TODO Auto-generated method stub
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
    public Object visitFunction_call(ecParser.Function_callContext ctx) {
        System.out.println("function:" +ctx.getText());
        System.out.println("chidren:" +ctx.getChildCount());
        return super.visitFunction_call(ctx);
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
