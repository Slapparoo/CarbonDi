package ec.lang;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FileDef;

@SuppressWarnings( "deprecation" )
public class TryCatchTest extends BaseTest{
    static String res = null;

    @BeforeAll
    public static void setupCode() throws IOException {
        BaseTest.preLoad();

        ClassDef cd = DefFactory.newClassDef();
        cd.setName("res");

        BaseTest.lex(
            "void throw(num ex);" +
            "num realloc(num a, num b);" +
            // "num printf(pointer);" +
            "class MyException (Core.Exception) {}" +
            // "int i = 3;\r\n" + //
            "try {\r\n" + //
                        // "    printf(`Hello 3 throw Exception -> finally\\n`);\r\n" + //
                        "    throw(Exception(\"Exception message\"));\r\n" + //
                        "} catch (Exception) {\r\n" + //
                        // "    printf(`catch %s\\n$a`);\r\n" + //
                        // "} catch (MyException) {\r\n" + //
                        // "    printf(`catch %s\\n$a`);\r\n" + //
                        "} finally {\r\n" + //
                        // "    printf(`3 %s finally`);\r\n" + //
                        "}\r\n" + //
                        "");

        // find last
        for (FileDef fd : DefFactory.FILE_DEFS) {
            res = fd.asCode();
        }

        assertNotNull(res);
        // System.out.println(res);
    }


    @Test
    public void testTry() throws IOException {
        // contains function
        assertTrue(res.indexOf("try") > -1);
        assertTrue(res.indexOf("create_c_2106303_Exception_2") > -1);
        assertTrue(res.indexOf("getExceptionIndex()") > -1);
    }

}