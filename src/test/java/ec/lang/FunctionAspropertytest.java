package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")

public class FunctionAspropertytest extends BaseTest {
    
    @Test
    public void testBasicFunctionAsproperty() {
        String ecCode = "?testBasicFunctionAspropertyString = \"String\";"
        +"?testBasicFunctionAspropertyStringV1 = testBasicFunctionAspropertyString.classPackage;"
        ;

        lex(new ecLexer(new ANTLRInputStream(ecCode)));

        String actual = BaseTest.stripWhiteSpace(DefFactory.getCurrentBlock().asCode());
        String expected = "{__onEnter();numtestBasicFunctionAspropertyString=create_c_2106303_String_2(\"String\"true);pointertestBasicFunctionAspropertyStringV1=((c_2106303_String_cm*)getc_2106303_String_cm())->classPackage();__onExit();}";

        assertEquals(expected, actual, "testBasicFunctionAspropertyString");
    }

}