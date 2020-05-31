package ec.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")

public class FunctionAspropertytest extends BaseTest {
    
    @Test
    public void testBasicFunctionAsproperty() {
        String ecCode = "?testBasicFunctionAspropertyString = \"String\";"
        +"?testBasicFunctionAspropertyStringV1 = testBasicFunctionAspropertyString.getClassPackage;"
        ;

        lex(new ecLexer(new ANTLRInputStream(ecCode)));

        // FunctionDef functionDef = (FunctionDef) DefFactory.resolveFunction("arrayFunction");

        // DefFactory.getCurrentBlock().resolve_01();
        

        System.out.println(DefFactory.getCurrentBlock().asCode());
    }

}