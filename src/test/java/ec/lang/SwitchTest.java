package ec.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.CaseStatement;
import ec.lang.defs.DefFactory;
import ec.lang.defs.DirectStatement;
import ec.lang.defs.SwitchDef;
import ec.lang.defs.expressions.ArrayIndexExpr;
import ec.lang.defs.expressions.AssignExpr;
import ec.lang.defs.expressions.ConstExpr;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.TypeExpr;
import ec.lang.model.ecLexer;
@SuppressWarnings("deprecation")
public class SwitchTest extends BaseTest {

    @Test
    void testSwitchBlock() {
        String ecCode = "?mySwitchTestVar = 10;?swary1 i8[8];swary1[0] = 10;";

        lex(new ecLexer(new ANTLRInputStream(ecCode)));

        BlockDef blockDef = DefFactory.getCurrentBlock();
        TypeExpr expr = new TypeExpr("mySwitchTestVar");

        SwitchDef switchDef = new SwitchDef(expr);

        System.out.println(switchDef.getBlockDef());
        System.out.println(blockDef);

        blockDef.statementDefs.add(switchDef);
        CaseStatement caseStatement = new CaseStatement();
        switchDef.addCaseStatement(caseStatement);


        caseStatement.setExprDef(new ConstExpr("10", "i64"));
        AssignExpr assignExpr = new AssignExpr(expr, "=", new ConstExpr("15"));
        caseStatement.addStatement(assignExpr);

        MultiTypeExpr expr2 = new MultiTypeExpr();
        expr2.addExpr(new ArrayIndexExpr("swary1", new ConstExpr("11"), ""), "line:4"); 


        DefFactory.addExpression(expr2);
        DefFactory.addExpression(new ConstExpr("15"));

        AssignExpr ax = DefFactory.newAssignExpr("=");

        // switchDef.resolve_01();
        // switchDef.validate_02();
        // switchDef.prepare_03();
        // System.out.println(switchDef.asCode());
        
        blockDef.resolve_01();
        blockDef.validate_02();
        blockDef.prepare_03();
        System.out.println(blockDef.asCode());


        System.out.println("caseStatement.getBlockDef() " + caseStatement.getBlockDef() + " " + caseStatement.containedInBlock);
        System.out.println("switchDef.getBlockDef() " + switchDef.getBlockDef() + " " + switchDef.containedInBlock);
        System.out.println("blockDef " + blockDef);

    }


}