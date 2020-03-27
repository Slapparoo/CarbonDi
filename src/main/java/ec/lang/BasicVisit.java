package ec.lang;

import ec.lang.model.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class BasicVisit {
  public static void main( String[] args) throws Exception 
  {
    ecLexer lexer = new ecLexer( new ANTLRFileStream(args[0]));
    ecParser parser = new ecParser(new CommonTokenStream( lexer ));
    ParseTree tree = parser.program();
    new CVisit().visit(tree);
  }
}