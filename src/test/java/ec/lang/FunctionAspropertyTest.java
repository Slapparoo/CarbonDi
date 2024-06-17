package ec.lang;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionAspropertyTest extends BaseTest {
    
    @Test
    public void testBasicFunctionAsproperty() {
        String code = genStrippedCode("""
        ?testBasicFunctionAspropertyString = "String";
        ?testBasicFunctionAspropertyStringV1 = testBasicFunctionAspropertyString.classPackage;
        """);

        assertThat(code)
                .isNotNull()
                        .isNotBlank()
                                .contains("num testBasicFunctionAspropertyString = create_c_2106303_String_2")
                .contains("pointer testBasicFunctionAspropertyStringV1 = ((c_2106303_String_cm*)");
    }

}