package ec.lang.defs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class FunctionDefTest {
    @Test
    void testAsCode() {

        DirectStatement body = new DirectStatement("this.no.value;");
        FunctionDef functionDef = SnippetFactory.addFunction(
                "functionName",
                body,
                new TypeIdDef("void"),
                false, false, false);

        String code = functionDef.asCode();

        assertNotNull(code);
    }
}
