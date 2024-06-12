package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;

@SuppressWarnings("deprecation")
public class PropertiesTest {

    static ClassDef classDef = null;

    @BeforeAll
    public static void setup() throws IOException {
        BaseTest.preLoad();
        BaseTest.lex("class testProperties1 {properties { RefArrayList options = RefArrayList(); Array numbers = Array(20, Boxing.i8_, 1);}}");

        classDef = DefFactory.resolveClass("testProperties1");
        assertNotNull(classDef);

        classDef.resolve_01();
        classDef.validate_02();
    }


    @Test
    public void testProperties() throws Exception {
        assertNotNull(classDef);
        String code = BaseTest.stripComments(classDef.asHeader());
        assertNotNull(code);

        assertNotNull(classDef.resolveVariable("options"));
        assertNotNull(classDef.resolveVariable("numbers"));

        assertTrue(code.indexOf("num options;") > -1);
        assertTrue(code.indexOf("num numbers;") > -1);
    }

    @Test
    public void testPropertyDefinitions() throws Exception {
        assertNotNull(classDef);
        String code = BaseTest.stripComments(classDef.asHeader());
        assertNotNull(code);

        assertTrue(code.indexOf("num (*get_options)(num);") > -1);
        assertTrue(code.indexOf("void (*set_options)(num,num);") > -1);
        assertTrue(code.indexOf("num (*get_numbers)(num);") > -1);
        assertTrue(code.indexOf("void (*set_numbers)(num,num);") > -1);
    }

    @Test
    public void testConstructors() throws Exception {
        assertNotNull(classDef);
        
        assertTrue(1 == classDef.getConstructorDefs().size());
        String code = BaseTest.stripComments(classDef.getConstructorDefs().get(0).asCode());
        assertNotNull(code);
        assertEquals("", code);
    }

    
    @Test
    public void testPropertyIntialisation() throws Exception {
        assertNotNull(classDef);
        String code = BaseTest.stripComments(classDef.asCode());

        // classDef.getFunctionDefs().stream()
        // .forEach(e -> System.out.println(e.name));
        assertNotNull(code);
        // System.out.println(code);
    }


    @Test
    public void testPropertieGetter() throws Exception {

        FunctionDef get_options = classDef.resolveFunction("get_options");
        assertNotNull(get_options);

        FunctionDef get_numbers = classDef.resolveFunction("get_numbers");
        assertNotNull(get_numbers);

        String code = BaseTest.stripComments(get_numbers.asCode());
        assertNotNull(code);
        // System.out.println(code);
    }

    @Test
    public void testPropertieSetter() throws Exception {

        FunctionDef set_options = classDef.resolveFunction("set_options");
        assertNotNull(set_options);

        FunctionDef set_numbers = classDef.resolveFunction("set_numbers");
        assertNotNull(set_numbers);


        String code = BaseTest.stripComments(classDef.asCode());
        assertNotNull(code);
        // assertTrue(code.indexOf("((c_1085510111_MyClass2p_cm*)useObject(this)->classmodel)->get_nl(this)") > -1);
    }

    @Test
    public void testPropertieEnterExit() throws Exception {

        String b8 = "public final class Core.B88 (Core.BaseBoxing) {" 
        + "(public, public) properties {"
        +  "b8 value; "
        +"}"
      
        +"private B88();"
      
        +"public static int datatype() {"
        +  "return Boxing.b8_;"
        +"}"
      
        +"public static pointer typename() {"
        +    "return `b8`;"
        +"}"
      
        +"public B88(=value);"
      
        +"public pointer asStr() {"
        +  "if (value) {"
        +    "return `true`;"
        +  "}"
        +  "return `false`;"
        +"}"
        +"}";

        // BaseTest.preLoad();
        BaseTest.lex(b8);

        ClassDef b8classDef = DefFactory.resolveClass("B88");
        assertNotNull(b8classDef);

        b8classDef.resolve_01();
        b8classDef.validate_02();

        FunctionDef get_value = b8classDef.resolveFunction("asStr");
        assertNotNull(get_value);

        String code = BaseTest.stripComments(get_value.asCode());
        assertNotNull(code);


        assertTrue(code.indexOf("pointer asStr(num this)") > -1);
        assertTrue(code.indexOf("entry__ = __onEnter();") > -1);
        assertTrue(code.indexOf("__exitReturn_pointer_un(\"true\", entry__);") > -1);
        assertTrue(code.indexOf("__exitReturn_pointer_un(\"false\", entry__);") > -1);

        assertTrue(code.indexOf("return __exitReturn_void_un(entry__);") < 0);
    }
}
