package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.expressions.AssignExpr;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.StringExpr;
import ec.lang.defs.expressions.TypeExpr;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecLexer;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.Class_definitionContext;
import ec.lang.model.ecParser.ProgramContext;

@SuppressWarnings( "deprecation" )
public class MultiTypeExprTest extends BaseTest {

    @Test
    public void testResolve() throws IOException {
        MultiTypeExpr multiTypeExpr = new MultiTypeExpr();
        multiTypeExpr.containedInBlock = new BlockDef();

        multiTypeExpr.addExpr(new TypeExpr("Object"), "");
        multiTypeExpr.addExpr(new TypeExpr("getClassShortName"), "");

        multiTypeExpr.resolve_01();
        // System.out.println(multiTypeExpr);
        // System.out.println(multiTypeExpr.asCode());

        assertEquals("/*te141*/((c_2106303_Object_cm*)getc_2106303_Object_cm())->getClassShortName()", 
        multiTypeExpr.asCode(), "Object.getClassShortName asCode");
    }

    /**
     * Test accessing a setter function a variable
     * myFunctionAsProperty.setName = "the name";
     */
    @Test
    public void testProperties() {
        String ecCode = 
        "class Default.MyFunctionAsProperty (Core.Object) {"
        +"    properties {"
        +"        String name;"
        +"    }"
        +"    void setName(String name) {"
        +"        this.name = name;"
        +"    }"
        +"    String getName() {"
        +"        return this.name;"
        +"    }"
        +"}"
        +"?myFunctionAsProperty = MyFunctionAsProperty();";

        lex(new ecLexer(new ANTLRInputStream(ecCode)));

        // myFunctionAsProperty.setName = "the name";
        MultiTypeExpr multiTypeExpr = new MultiTypeExpr();
        multiTypeExpr.addExpr(new TypeExpr("myFunctionAsProperty"), "line:1");
        multiTypeExpr.addExpr(new TypeExpr("setName"), "line:1");

        DefFactory.addExpression(multiTypeExpr);
        DefFactory.addExpression(new StringExpr("\"the name\""));

        AssignExpr ax = DefFactory.newAssignExpr("=");
        ax.containedInBlock = DefFactory.getCurrentBlock();

        ax.resolve_01();

        assertEquals("/*Ax2*//*te14b1*/((c_1085510111_MyFunctionAsProperty_cm*)useObject(/*te8*/myFunctionAsProperty)->classmodel)->setName(/*te8*/myFunctionAsProperty, /*se*/ create_c_2106303_String$2(\"the name\", true));", 
        ax.asCode(), "myFunctionAsProperty.setName = \"the name\";.asCode()");
    }


    /**
     * Functions that return an array
     */
    @Test
    public void testArrayFunction() {

        String ecCode = 
        "i8[] arrayFunction() {"
        +"  ?arrayResult i8[10];"
        +"  return arrayResult;"
        +"}"
        +"?myArray = arrayFunction();"
        +"myArray.length;";

        lex(new ecLexer(new ANTLRInputStream(ecCode)));

        FunctionDef functionDef = (FunctionDef) DefFactory.resolveFunction("arrayFunction");

        System.out.println(functionDef.asCode());

        // // myFunctionAsProperty.setName = "the name";
        // MultiTypeExpr multiTypeExpr = new MultiTypeExpr();
        // multiTypeExpr.addExpr(new TypeExpr("myFunctionAsProperty"), "line:1");
        // multiTypeExpr.addExpr(new TypeExpr("setName"), "line:1");

        // DefFactory.addExpression(multiTypeExpr);
        // DefFactory.addExpression(new StringExpr("\"the name\""));

        // AssignExpr ax = DefFactory.newAssignExpr("=");
        // ax.containedInBlock = DefFactory.getCurrentBlock();

        // ax.resolve_01();

        // assertEquals("/*Ax2*//*te14b1*/((c_1085510111_MyFunctionAsProperty_cm*)useObject(/*te8*/myFunctionAsProperty)->classmodel)->setName(/*te8*/myFunctionAsProperty, /*se*/ create_c_2106303_String$2(\"the name\", true));", 
        // ax.asCode(), "myFunctionAsProperty.setName = \"the name\";.asCode()");        
        BlockDef blockDef = DefFactory.getCurrentBlock();
        blockDef.resolve_01();
        blockDef.validate_02();
        blockDef.prepare_03();

        System.out.println(blockDef.asCode());
    }

    // @BeforeAll
    // private static void preLoad() throws IOException {
    //     lex(new ecLexer(new ANTLRInputStream(new FileInputStream("c-bin/Core.signature.ec"))));

    //     ClassDef classDef = DefFactory.resolveClass("Object");
    //     assertNotNull(classDef, "Core.Object not found?");
    // }


    // private static void lex(ecLexer lexer) {
    //     try {
    //         ecParser parser = new ecParser(new CommonTokenStream(lexer));
    //         // adjust the line number
    //         // lexer.setLine(-110);
        
    //         ParseTree tree = parser.program();
    //         ParseTreeWalker walker = new ParseTreeWalker();
        
        
    //         ecBaseListener ecbl = new ecBaseListener() {
    //             @Override
    //             public void exitClass_definition(Class_definitionContext ctx) {
    //                 super.exitClass_definition(ctx);
    //                 ctx.cd.resolve_01();
    //                 ctx.cd.validate_02();
    //                 ctx.cd.prepare_03();
    //             }

    //             public void exitProgram(ProgramContext ctx) {
    //                 super.exitProgram(ctx);
    //                 ctx.ff.resolve_01();
    //                 ctx.ff.validate_02();
    //                 ctx.ff.prepare_03();
    //             }
    //         };
    //         walker.walk( ecbl, tree );
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         e.printStackTrace();
    //     }
    
    // }
}