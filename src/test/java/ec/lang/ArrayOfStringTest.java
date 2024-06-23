package ec.lang;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDefBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings( "deprecation" )
public class ArrayOfStringTest extends BaseTest{
    static String res = null;

    @BeforeAll
    public static void setupCode() {
        BaseTest.lex(
"""
        void ArrayOfStringTest() {
            String[2] names;
            names[0] = "Some name";
            names[1] = "Another name";
            
            External.core.testStrEqual(`names[0]`, `Some name`, names[0].asStr());
            External.core.testStrEqual(`names[1]`, `Another name`, names[1].asStr());
        }
""");

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            if (fd.name.equals("ArrayOfStringTest")) {
                fd.resolve_01();
                res= stripWhiteSpace(stripComments(fd.asCode()));
                break;
            }
        }
        assertNotNull(res);
        assertThat(res).contains("void ArrayOfStringTest()");
        assertThat(res).contains("u64 entry__ = __onEnter()");
        assertThat(res).contains("return __exitReturn_void_un(entry__);}");
    }

    @Test
    public void testNamesAsArray() {
        assertThat(res).contains("((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(names, 0))");
        assertThat(res).contains("((num *)((c_2106303_RefArray_cm*)getc_2106303_RefArray_cm())->get(names, 1))");
    }
}