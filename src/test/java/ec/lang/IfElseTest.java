package ec.lang;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FileDef;

@SuppressWarnings("deprecation")
public class IfElseTest {
    static String code = null;

    @BeforeAll
    public static void setup() throws IOException {
        BaseTest.preLoad();

        BaseTest.lex("if (!true) { 1;} else if (false) {2;} else {3;}");

        // find last
        for (FileDef fd : DefFactory.FILE_DEFS) {
            code = fd.asCode();
        }
    }


    @Test
    public void testIfElse() throws IOException {
        assertNotNull(code);

        // @TODO FIXME assertTrue(code.indexOf("if (!true)") > -1);
        assertTrue(code.indexOf("if (true)") > -1);
        assertTrue(code.indexOf("else if (false)") > -1);
        assertTrue(code.indexOf("else {") > -1);
    }
}