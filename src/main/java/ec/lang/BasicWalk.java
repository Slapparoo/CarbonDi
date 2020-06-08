package ec.lang;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ec.lang.model.ecBaseListener;
import ec.lang.model.ecLexer;
import ec.lang.model.ecParser;
import ec.lang.model.ecParser.Class_definitionContext;
import ec.lang.model.ecParser.ProgramContext;

@SuppressWarnings( "deprecation" )
public class BasicWalk {

  private static void preLoad() throws IOException {
    lex(new ecLexer(new ANTLRInputStream(new FileInputStream((ecCoreDir.length() == 0 ? "" : ecCoreDir) + "core/Core.signature.ec"))));
  }

  private static void lex(ecLexer lexer) {
    try {
      ecParser parser = new ecParser(new CommonTokenStream(lexer));

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
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

  }

  static String ecCoreDir = "";
  static String outputDir = "/tmp/ec";
  


  static void parseParams(String[] args) {
    for (String string : args) {
      if (string.startsWith("-CD")) {
        ecCoreDir = string.substring(3);

        ecCoreDir += (ecCoreDir.endsWith("/") ? "" : "/");
      }

      if (string.startsWith("-OD")) {
        outputDir = string.substring(3);
      }
      
    }
  }

  public static void main(String[] args) throws Exception {
    parseParams(args);
    Set<String> params = new HashSet<>(Arrays.asList(args));

    if (!params.contains("-nolib")) {
      preLoad();
    }

    ecLexer lexer = new ecLexer(new ANTLRFileStream(args[0]));
    ecParser parser = new ecParser(new CommonTokenStream(lexer));

    ParseTree tree = parser.program();
    ParseTreeWalker walker = new ParseTreeWalker();


    CWalker cWalker = new CWalker(Arrays.asList(args), outputDir, ecCoreDir);
    walker.walk(cWalker, tree);
  }
}