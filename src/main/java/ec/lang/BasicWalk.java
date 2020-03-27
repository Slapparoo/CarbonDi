package ec.lang;

import ec.lang.model.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class BasicWalk {
  public static void main( String[] args) throws Exception 
  {
    ecLexer lexer = new ecLexer(new ANTLRFileStream(args[0]));
    ecParser parser = new ecParser(new CommonTokenStream(lexer));
    ParseTree tree = parser.program();
    ParseTreeWalker walker = new ParseTreeWalker();

    String dirname = ".";
    if (args.length == 2) {
      dirname = args[1];
    }
    CWalker cWalker = new CWalker(args[0], dirname);
    walker.walk( cWalker, tree );

    // cWalker


  }
}