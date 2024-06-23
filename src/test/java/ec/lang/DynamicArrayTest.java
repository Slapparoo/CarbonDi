package ec.lang;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDefBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings( "deprecation" )
public class DynamicArrayTest extends BaseTest{
    static String res = null;

    @BeforeAll
    public static void setupCode() {
        BaseTest.lex("void testArrayIndexVar() {i8[10] numbers;numbers[1] = `t`;?ii = numbers[ii];numbers[1];}");
        BaseTest.lex("void testDynamicArrayTest() {?numbers = DynamicArray(20, Boxing.u8_, 1);numbers[0] = 5;?ii = numbers;ii[0]=6;?aab=ii[0];}");

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            if (fd.name.equals("testDynamicArrayTest")) {
                fd.resolve_01();
                res= stripWhiteSpace(stripComments(fd.asCode()));
                break;
            }
        }
        assertNotNull(res);
        assertThat(res).contains("void testDynamicArrayTest()");
        assertThat(res).contains("u64 entry__ = __onEnter()");
        assertThat(res).contains("return __exitReturn_void_un(entry__);}");
    }

    @Test
    public void testArrayIndexCreate() {
        assertThat(res).contains("create_c_2106303_DynamicArray_3(20, ((c_2106303_Boxing_cm*)getc_2106303_Boxing_cm())->get_u8_(), 1);");
    }

    @Test
    public void testDynamicArraySet() {
        assertThat(res).contains("((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->setValue(numbers, 0, &5);");
        assertThat(res).contains("((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->setValue(ii, 0, &6);");
    }

    @Test
    public void testArrayGet() {
        assertThat(res).contains("*((c_2106303_DynamicArray_cm*)getc_2106303_DynamicArray_cm())->getValue(ii, 0);");
    }
}