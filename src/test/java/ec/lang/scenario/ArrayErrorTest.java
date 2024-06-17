package ec.lang.scenario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import ec.lang.BaseTest;
import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.Enums.Accessor;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.TypeIdDef;

public class ArrayErrorTest extends BaseTest {

    static String compiledCode = null;

    @Test
    public void checkU8() {
        ClassDef cd = DefFactory.resolveClass("U8");
        compiledCode = stripWhiteSpace(stripComments(cd.asCode()));

        assertNotNull(compiledCode);
        assertThat(compiledCode).contains("U8");
        assertThat(cd.properties.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList()).containsAll(List.of("value", "instanceName")));
    }

    @Test
    public void testAddMethod() {

        String code = """
                public class Parser.SequenceMatcher2 (Core.Object) {
                    properties {
                        U8 no = U8(7);
                    }

                    void add() {
                       no.value = 5;
                    }
                }
                """;

        BaseTest.lex(code);

        ClassDef cd = DefFactory.resolveClass("SequenceMatcher2");

        FunctionDef fDef = DefFactory.newFunctDef();

        fDef.is_property = true;
        fDef.name = "add";
        fDef.returnType = new TypeIdDef("void");
        fDef.accessor = Accessor.PUBLIC;
        cd.addFunction(fDef);

        compiledCode = cd.asCode();

        assertNotNull(compiledCode);
        assertThat(compiledCode).contains("SequenceMatcher2");
        assertThat(cd.properties.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList()).containsAll(List.of("no", "instanceName")));
    }
}
