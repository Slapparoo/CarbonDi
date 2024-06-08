package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.model.ecLexer;

@SuppressWarnings("deprecation")
public class IfElseTest {

    @Test
    public void testIfElse() throws IOException {
        String code = "if (!true) { 1;} else if (false) {2;} else {3;}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(code)));

        // System.out.println(DefFactory.currentBlock.get(1).getBlockDef().asCode());
        // System.out.println(DefFactory.currentBlock.get(1).getBlockDef().asCode().replaceAll("[' ',\n,\r,\t]", ""));

        // assertEquals("{__onEnter();if(true){__onEnter();/*st*/1;__onExit();}elseif(false){__onEnter();/*st*/2;__onExit();}/*else?*/else{__onEnter();/*st*/3;__onExit();}__onExit();}".replaceAll("[' ',\n,\r,\t]", ""), 
        //                 DefFactory.currentBlock.get(1).getBlockDef().asCode()
        //                     .replaceAll("[' ',\n,\r,\t]", ""));
    }
}