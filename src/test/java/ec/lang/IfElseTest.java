package ec.lang;

import java.io.IOException;

import ec.lang.model.ecLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FileDef;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
public class IfElseTest {
    static String code = null;

    @BeforeAll
    public static void setup() throws IOException {
        BaseTest.preLoad();

        BaseTest.lex("if (!true) { 1;} else if (false) {2;} else {3;}");

        code = BaseTest.stripWhiteSpace(DefFactory.getCurrentBlock().asCode());
    }


    @Test
    public void testIfElse() throws IOException {
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertThat(code)
                .contains("if (true)")
                .contains("else if (false)")
                .contains("else {");
    }
}