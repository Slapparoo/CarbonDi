package ec.lang;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecLexer;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.Class_definitionContext;
import ec.lang.model.ecParser.ProgramContext;

@SuppressWarnings("deprecation")

public class BaseTest {

    @BeforeEach
    public void preLoader() throws IOException {
        lex(new ecLexer(new ANTLRInputStream(new FileInputStream("core/Core.signature.ec"))));

        ClassDef classDef = DefFactory.resolveClass("Object");
        assertNotNull(classDef, "Core.Object not found?");
    }

    @BeforeAll
    public static void preLoad() throws IOException {
        // if (DefFactory.CLASS_DEFS.contains("Core.Object")) {
        // return;
        // }

        lex(new ecLexer(new ANTLRInputStream(new FileInputStream("core/Core.signature.ec"))));

        ClassDef classDef = DefFactory.resolveClass("Object");
        assertNotNull(classDef, "Core.Object not found?");
    }

    /**
     * Utility method to strip whitespace and comments
     */
    public static String stripWhiteSpace(String string) {
        return string.replaceAll("[\t\n\r]", "").replaceAll(" +", " ");
    }

    /**
     * Utility method to strip whitespace and comments
     */
    public static String stripComments(String string) {
        return string.replaceAll("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/", "$1");
    }

    protected static void lex(String ecCode) {
        lex(new ecLexer(new ANTLRInputStream(ecCode)));
    }

    protected static void lex(ecLexer lexer) {
        // try {
        ecParser parser = new ecParser(new CommonTokenStream(lexer));
        // adjust the line number
        // lexer.setLine(-110);

        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();

        ecBaseListener ecbl = new ecBaseListener() {
            @Override
            public void exitClass_definition(Class_definitionContext ctx) {
                super.exitClass_definition(ctx);
                ctx.cd.resolve_01();
                ctx.cd.validate_02();
                ctx.cd.prepare_03();
            }

            public void exitProgram(ProgramContext ctx) {
                super.exitProgram(ctx);
                ctx.ff.resolve_01();
                ctx.ff.validate_02();
                ctx.ff.prepare_03();
            }
        };
        walker.walk(ecbl, tree);
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // e.printStackTrace();
        // }

    }

    public static void assertContains(String compiledCode, String expectedString) {
        assertTrue(compiledCode.indexOf(expectedString) > -1,
                String.format("expecting: \"%s\" not found in compiledCode: \"%s\"", expectedString, compiledCode));
    }
}