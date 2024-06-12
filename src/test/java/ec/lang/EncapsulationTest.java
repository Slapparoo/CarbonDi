package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;

public class EncapsulationTest {

    @Test
    public void testResolveProperty() throws IOException {
        BaseTest.preLoad();
        BaseTest.lex("class Encaps1 (Core.Object) { properties { int count2;} count2.set {count2 = $a + 10;} } ");


        ClassDef encaps1 = DefFactory.resolveClass("Encaps1");
        assertNotNull(encaps1);

        // System.out.println(encaps1.asCode());

        FunctionDef functionDef = encaps1.resolveFunction("set_count2");

        String code = functionDef.asCode();
        // System.out.println(code);
        String actual = BaseTest.stripWhiteSpace(code);

        String expected = "voidset_count2(numthisinta__a){u64entry__=__onEnter();((c_1085510111_Encaps1*)useObject(this)->data)->count2=a__a+10;return__exitReturn_void_un(entry__);}";
        assertEquals(expected, actual);
    }

}