package ec.lang;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDefBase;
import ec.lang.model.ecLexer;

public class LoopTest {

    @Test
    public void testArrayParam() throws IOException {
        String ecCode = "public void testArrayParam(i8[] arr) {arr.values;}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            // System.out.println(fd.name + " " + fd.classDef);

            if (fd.name.equals("testArrayParam")) {
                fd.resolve_01();
                fd.asCode();
            }
        }
    }
   
}