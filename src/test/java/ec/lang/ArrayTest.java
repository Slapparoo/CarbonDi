package ec.lang;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDefBase;

@SuppressWarnings( "deprecation" )
public class ArrayTest extends BaseTest{
    static String res = null;

    @BeforeAll
    public static void setupCode() {
        BaseTest.lex("void testArrayIndexVar() {i8[10] numbers;numbers[1] = `t`;?ii = numbers[ii];numbers[1];}");

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            if (fd.name.equals("testArrayIndexVar")) {
                fd.resolve_01();
                res= stripWhiteSpace(stripComments(fd.asCode()));
                break;
            }
        }
        assertNotNull(res);
        assertContains(res, "void testArrayIndexVar()");
        assertContains(res, "u64 entry__ = __onEnter()");
        assertContains(res, "return __exitReturn_void_un(entry__);}");
    }


    @Test
    public void testArrayIndexCreate() throws IOException {
        assertContains(res, "num numbers = create_c_2106303_Array_1(10, ((c_2106303_Boxing_cm*) getc_2106303_Boxing_cm())->i8_, sizeof(i8));");
    }

    @Test
    public void testArrayIndexVarSet() throws IOException {
        assertContains(res, "(i8*)((c_2106303_Array_cm*)useObject(numbers)->classmodel)->get(numbers, 1)='t';");
    }

    @Test
    public void testArrayIndexVarGet() throws IOException {
        assertContains(res, "void testArrayIndexVar()");
        assertContains(res, "(i8*)((c_2106303_Array_cm*)useObject(numbers)->classmodel)->get(numbers, 1);");
    }
}