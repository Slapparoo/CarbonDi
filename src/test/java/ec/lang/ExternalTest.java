package ec.lang;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")
public class ExternalTest {
    @Test
    public void testExternal() {
        String ecCode = "" + "int External.stdio.strlen(pointer);" + "?length = External.stdio.strlen(`the string`);";

        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        System.out.println(DefFactory.getCurrentBlock().statementDefs.size());
        System.out.println(DefFactory.getCurrentBlock().asCode());
        System.out.println(DefFactory.getCurrentBlock().asHeader());
    }

    @Test
    public void testExternalInClass() throws IOException {
        String ecCode = ""
        + "public class Default.AsExternal {"
        + "public void getSomeLength1() { External.stdio.strlen(p);}"
        + "public int getSomeLength2() { pointer p; return  External.stdio.strlen(p);}"
        + "}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef classDef = DefFactory.resolveClass("AsExternal");
        System.out.println(classDef.asCode());

        System.out.println(DefFactory.getCurrentBlock().statementDefs.size());
        System.out.println(DefFactory.getCurrentBlock().asCode());
    }

    
}