package ec.lang;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.junit.jupiter.api.Test;

import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDefBase;
import ec.lang.defs.StatementDef;
import ec.lang.model.ecLexer;

@SuppressWarnings( "deprecation" )
public class ArrayTest {

    @Test
    public void testArrayIndexVar() throws IOException {
        String code = "void testArrayIndexVar() {i8[10] numbers;numbers[1] = `t`;?ii = numbers[ii];numbers[1];}";

        BaseTest.preLoad();
        BaseTest.lex(new ecLexer(new ANTLRInputStream(code)));

        for (FunctionDefBase fd : DefFactory.FUNCT_DEFS) {
            if (fd.name.equals("testArrayIndexVar")) {
                fd.resolve_01();

                for (StatementDef statementDef : fd.getBlockDef().statementDefs) {
                    System.out.println("st " + statementDef + " - " + statementDef.asCode());    
                }

                String res= fd.asCode();
                System.out.println(res);
            }
        }
    }
}