package ec.examples;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeAll;

import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.model.ecBaseListener;
import ec.lang.model.ecLexer;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.Class_definitionContext;
import ec.lang.model.ecParser.ProgramContext;

/**
 * basic wiring to readin the example files
 */
@SuppressWarnings( "deprecation" )
public class BaseExamples {

    static void loadExample(String name)  {

        File f = new File("examples/" + name);
        assertTrue(f.exists(), "file not found " + f.getAbsolutePath());
        try {
            lexLoadOnly(new ANTLRInputStream(new FileInputStream(f)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assertNull(e);
        } 
    }

    private static void lexLoadOnly(ANTLRInputStream antlrInputStream) throws IOException {
        try {
            ecLexer lexer = new ecLexer(antlrInputStream);
            ecParser parser = new ecParser(new CommonTokenStream(lexer));
            // adjust the line number
            // lexer.setLine(-110);
        
            ParseTree tree = parser.program();
            ParseTreeWalker walker = new ParseTreeWalker();
        
        
            ecBaseListener ecbl = new ecBaseListener() {
                // @Override
                // public void exitClass_definition(Class_definitionContext ctx) {
                //     super.exitClass_definition(ctx);
                //     ctx.cd.resolve_01();
                //     ctx.cd.validate_02();
                //     ctx.cd.prepare_03();
                // }

                // public void exitProgram(ProgramContext ctx) {
                //     super.exitProgram(ctx);
                //     ctx.ff.resolve_01();
                //     ctx.ff.validate_02();
                //     ctx.ff.prepare_03();
                // }
            };
            walker.walk( ecbl, tree );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    
    }    

    @BeforeAll
    private static void preLoad() throws IOException {
        lex(new ANTLRInputStream(new FileInputStream("core/Core.signature.ec")));

        ClassDef classDef = DefFactory.resolveClass("Object");
        assertNotNull(classDef, "Core.Object not found?");
    }


    private static void lex(ANTLRInputStream antlrInputStream) {
        try {
            ecLexer lexer = new ecLexer(antlrInputStream);
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
            walker.walk( ecbl, tree );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    
    }    
}