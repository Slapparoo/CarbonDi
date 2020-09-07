package ec.lang;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")

public class PropertiesTest {

    @Test
    public void testProperties() throws Exception {
        String ecCode = "class testProperties1 {properties { RefArrayList options = RefArrayList(); Array numbers = Array(20, Boxing.i8_, 1);}}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef classDef = DefFactory.resolveClass("testProperties1");

        System.out.println(classDef);

        classDef.resolve_01();
        classDef.validate_02();

        System.out.println(classDef.asCode());
    }
}
