package ec.lang;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")

public class ReturnDefTest {

    @Test
    public void testReturnDef() {
        // String ecCode = "int returnFunction() { Pointer p; return External.stdio.strlen(p); }";
        String ecCode = "int returnFunction() { Pointer p = null; return External.stdio.strlen(p); }";

        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        FunctionDef fd = (FunctionDef)DefFactory.resolveFunction("returnFunction");
        assertNotNull(fd);
        fd.containedInBlock = DefFactory.getCurrentBlock();
        fd.resolve_01();
        fd.validate_02();
        fd.prepare_03();
        // fd.containedInBlock = DefFactory.getCurrentBlock();
        System.out.println(fd.asCode());

        System.out.println(DefFactory.getCurrentBlock().asCode());
    }
    
}