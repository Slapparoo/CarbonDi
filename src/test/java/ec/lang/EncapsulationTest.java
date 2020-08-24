package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.model.ecLexer;

public class EncapsulationTest {

    // count2.set {
    // count2 = $a + count1;
    // }

    @Test
    public void testResolveProperty() throws IOException {
        String ecCode = "class Encaps1 { properties { int count2;} count2.set {count2 = $a + 10;} } ";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));


        ClassDef encaps1 = DefFactory.resolveClass("Encaps1");

        FunctionDef functionDef = encaps1.resolveFunction("set_count2");

        String code = functionDef.asCode();
        // System.out.println(code);
        String actual = BaseTest.stripWhiteSpace(code);

        String expected = "voidset_count2(numthisinta__a){u64entry__=__onEnter();((c_1085510111_Encaps1*)useObject(this)->data)->count2=a__a+10;__onExit();}";
        assertEquals(expected, actual);
    }

}