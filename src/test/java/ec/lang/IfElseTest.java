package ec.lang;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")
public class IfElseTest {

    @Test
    public void testIfElse() throws IOException {
        String code = "if (!true) { 1;} else if (false) {2;} else {3;}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(code)));

        System.out.println(DefFactory.currentBlock.get(1).getBlockDef().asCode());
    }
}