package ec.lang;

import ec.lang.gen.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class BasicWalk {
  public static void main( String[] args) throws Exception 
  {
    ecLexer lexer = new ecLexer(new ANTLRFileStream(args[0]));
    ecParser parser = new ecParser(new CommonTokenStream(lexer));
    ParseTree tree = parser.program();
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk( new CWalker(), tree );
  }
}