package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.Enums.ClassType;
import ec.lang.model.ecLexer;

public class ClassDefTest extends BaseTest {

    @Test
    public void testMethodOverride() throws IOException {
        String ecCode = ""
        + "class Default.MyClass1 {\n int number() {\nreturn 1;\n}\n void number2(int aa) "
        + "{\n number();\n}\n }"
        + "class MyClass2 (Default.MyClass1) {\n properties {\n int n1; \n}\n int number() {\nreturn number2(n1);\n}"
        + "public final pointer myrealloc(pointer ptr, u64 size) {return External.core.Object_realloc(this, ptr, size); }\n} ";

        // BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef myClass1 = DefFactory.resolveClass("MyClass1");
        ClassDef myClass2 = DefFactory.resolveClass("MyClass2");

        // System.out.println(myClass1.asHeader());
        // System.out.println(myClass2.asCode());

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            // System.out.println(fd.name + " " + fd.classDef);
        }

        myClass1.asCode();
        myClass2.asCode();

        // FunctionDef fd = myClass1.resolveFunction("number2");
        // System.out.println(fd.asCode());

        FunctionDef fd2 = myClass2.resolveFunction("number");
        // System.out.println(fd2.asCode());

        // FunctionDef fd3 = myClass2.resolveFunction("myrealloc");
        // System.out.println(fd3.asCode());

        // System.out.println(myClass1.asCode());
        // System.out.println(myClass2.asCode());
        // System.out.println(myClass2.asHeader());
        // cd.

    }

    @Test
    public void testPropertyAccess() throws IOException {
        String ecCode = ""
        + "class Default.MyClass2p{\n  properties {\nint nl = 10;\n}\nint number() {\nreturn nl;\n}}";

        // BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef myClass1 = DefFactory.resolveClass("MyClass2p");

        FunctionDef fd2 = myClass1.resolveFunction("number");

        assertNotNull(fd2);
        String code = BaseTest.stripComments(fd2.asCode());
        assertNotNull(code);
        // System.out.println(code);
        assertTrue(code.indexOf("((c_1085510111_MyClass2p_cm*)useObject(this)->classmodel)->get_nl(this)") > -1);
    }

    @Test
    public void testThisPropertyAccess() throws IOException {
        String ecCode = ""
        + "class Default.MyClass1p(Core.Object){\n  properties {\nint nl = 10;\n}\npointer number() {\nreturn this.asStr();\n}}";

        // BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef myClass1 = DefFactory.resolveClass("MyClass1p");

        myClass1.asCode();

        assertNotNull(myClass1);
        assertEquals(null, myClass1.classType);
        assertNotNull(myClass1.parent);

        FunctionDef fd2 = myClass1.resolveFunction("number");
        assertNotNull(fd2);
        String code = BaseTest.stripComments(fd2.asCode());
        assertNotNull(code);
        assertTrue(code.indexOf("((c_1085510111_MyClass1p_cm*)useObject(this)->classmodel)->asStr(this)") > -1);
    }

    
    @Test
    public void testClassNoExtends() throws IOException {
        String ecCode = ""
        + "class Default.MyClass3p{\n  properties {\nint nl = 10;\n}\nint number() {\nreturn this.nl;\n}}";

        // BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(ecCode)));

        ClassDef myClass1 = DefFactory.resolveClass("MyClass3p");

        assertNotNull(myClass1);
        assertEquals(null, myClass1.classType);
        assertEquals(null, myClass1.parent);
   }

}