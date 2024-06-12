package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")
public class ExternalTest {
    @Test
    public void testExternal() {
        String ecCode = "" + "int External.stdio.strlen(pointer);" + "?length = External.stdio.strlen(`the string`);";

        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        // System.out.println(DefFactory.getCurrentBlock().statementDefs.size());
        // System.out.println(DefFactory.getCurrentBlock().asCode());
        // System.out.println(DefFactory.getCurrentBlock().asHeader());
    }

    @Test
    public void testExternalInClass() throws IOException {
        String ecCode = ""
        + "class Default.AsExternal {"
        + "void getSomeLength1(pointer p) { External.stdio.strlen(p);}"
        + "public int getSomeLength2() { pointer p; return  External.stdio.strlen(p);}"
        + "}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef classDef = DefFactory.resolveClass("AsExternal");

        FunctionDef getSomeLength1 = classDef.resolveFunction("getSomeLength1");
        String expected = BaseTest.stripWhiteSpace(getSomeLength1.asCode());
        assertEquals(expected, "voidgetSomeLength1(numthispointerp){u64entry__=__onEnter();strlen(p);return__exitReturn_void_un(entry__);}", "void getSomeLength1(pointer p) { External.stdio.strlen(p);}");

        FunctionDef getSomeLength2 = classDef.resolveFunction("getSomeLength2");

        expected = BaseTest.stripWhiteSpace(getSomeLength2.asCode());
        assertEquals(expected, "intgetSomeLength2(numthis){u64entry__=__onEnter();pointerp;return__exitReturn_int_un(strlen(p)entry__);}", "void getSomeLength1(pointer p) { External.stdio.strlen(p);}");

    }

    
}