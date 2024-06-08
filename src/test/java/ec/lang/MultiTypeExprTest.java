package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.expressions.AssignExpr;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.StringExpr;
import ec.lang.defs.expressions.TypeExpr;
import ec.lang.model.ecLexer;

@SuppressWarnings( "deprecation" )
public class MultiTypeExprTest extends BaseTest {

    @Test
    public void testResolve() throws IOException {
        MultiTypeExpr multiTypeExpr = new MultiTypeExpr();
        multiTypeExpr.containedInBlock = new BlockDef();

        multiTypeExpr.addExpr(new TypeExpr("Object"), "");
        multiTypeExpr.addExpr(new TypeExpr("classShortName"), "");

        multiTypeExpr.resolve_01();

        String actual = BaseTest.stripWhiteSpace(multiTypeExpr.asCode());
        String expected = "((c_2106303_Object_cm*)getc_2106303_Object_cm())->classShortName()";

        assertEquals(expected, actual, "Object.classShortName asCode");
    }

    // @Test
    public void testResolveProperty() throws IOException {
        String ecCode = "?numbers = \"s1\";?numbers1 = numbers;External.stdio.printf(numbers1.asStr);";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        String code = DefFactory.getCurrentBlock().asCode();

        String res = "{__onEnter();numnumbers=create_c_2106303_String_2(\"s1\"true);numnumbers1=numbers;printf(((c_2106303_String_cm*)useObject(numbers1)->classmodel)->asStr(numbers1));__onExit();}";
        assertEquals(res, BaseTest.stripWhiteSpace(code));

    }

    // count2.set {
    //     count2 = $a + count1;
    // }

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

        assertEquals("/*Ax2*//*te14b1*/((c_1085510111_MyFunctionAsProperty_cm*)useObject(/*te8*/myFunctionAsProperty)->classmodel)->setName(/*te8*/myFunctionAsProperty, /*se*/ create_c_2106303_String_2(\"the name\", true));", 
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

        String actual = BaseTest.stripWhiteSpace(functionDef.asCode());
        String expected = "numarrayFunction(){u64entry__=__onEnter();numarrayResult=create_c_2106303_Array_1(10((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->i8_sizeof(i8));return__exitReturn_ref_un(arrayResultentry__);}";
        assertEquals(expected, actual);


        BlockDef blockDef = DefFactory.getCurrentBlock();
        blockDef.resolve_01();
        blockDef.validate_02();
        blockDef.prepare_03();

        actual = BaseTest.stripWhiteSpace(blockDef.asCode());
        expected = "{nummyArray=arrayFunction();((c_2106303_Array_cm*)useObject(myArray)->classmodel)->get_length(myArray);}";
        // expected = "{__onEnter();nummyArray=arrayFunction();((c_2106303_Array_cm*)useObject(myArray)->classmodel)->get_length(myArray);__onExit();}";
        assertEquals(expected, actual);
    }

}