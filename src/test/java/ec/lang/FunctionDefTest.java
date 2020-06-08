package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.DirectStatement;
import ec.lang.defs.ExprDef;
import ec.lang.defs.FunctionDef;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;
import ec.lang.defs.expressions.ReturnExpr;

public class FunctionDefTest {
    
    @Test
    public void testName() {
        FunctionDef functionDef = new FunctionDef("void", "name");
        assertEquals("name", functionDef.getExpandedName());
        assertEquals("void (*name)()", functionDef.getSignature());
        assertEquals("void (*name)()", functionDef.getSignatureAsCode());
        assertEquals("void (*name)()", functionDef.getExpandedSignature());
        assertEquals("void name()", functionDef.asEcSignature());
        assertEquals("\npublic void name();", functionDef.asSignature());
    }

    @Test
    public void testOneParameter() {
        FunctionDef functionDef = new FunctionDef("void", "name");

        VariableDef param = new VariableDef();
        param.setName("this");
        param.type = new TypeIdDef("num");
        functionDef.addParameter(param);

        functionDef.resolve_01();

        assertEquals("name", functionDef.getExpandedName(), "getExpandedName");
        assertEquals("void (*name)(num)", functionDef.getSignature(), "getSignature" );
        assertEquals("void (*name)(num)", functionDef.getSignatureAsCode(), "getSignatureAsCode");
        assertEquals("void (*name)(num)", functionDef.getExpandedSignature(), "getExpandedSignature" );
        assertEquals("void name(num)", functionDef.asEcSignature(), "asEcSignature");
        assertEquals("\npublic void name();", functionDef.asSignature(), "asSignature");
    }

    @Test
    public void testTwoParameters() {
        FunctionDef functionDef = new FunctionDef("void", "name");

        VariableDef param = new VariableDef();
        param.setName("this");
        param.type = new TypeIdDef("num");
        functionDef.addParameter(param);

        param = new VariableDef();
        param.setName("str");
        param.type = new TypeIdDef("pointer");
        functionDef.addParameter(param);

        functionDef.resolve_01();

        assertEquals("name", functionDef.getExpandedName());
        assertEquals("void (*name)(num,pointer)", functionDef.getSignature());
        assertEquals("void (*name)(num,pointer)", functionDef.getSignatureAsCode());
        assertEquals("void (*name)(num,pointer)", functionDef.getExpandedSignature());
        // assertEquals("function name:=void(num,pointer)", functionDef.asEcSignature());
        assertEquals("void name(num,pointer)", functionDef.asEcSignature());
        assertEquals("\npublic void name(pointer str);", functionDef.asSignature());
    }

    @Test
    public void testBlock() {
        FunctionDef functionDef = new FunctionDef("int", "name");

        VariableDef param = new VariableDef();
        param.setName("val");
        param.type = new TypeIdDef("int");
        functionDef.addParameter(param);

        functionDef.setBlockDef(new BlockDef());
        functionDef.getBlockDef().statementDefs.add(new DirectStatement("int x = val;"));
        ReturnExpr ret = new ReturnExpr();
        ret.statement = new ExprDef("x");
        functionDef.getBlockDef().statementDefs.add(ret);

        functionDef.resolve_01();

        assertEquals("name", functionDef.getExpandedName());
        assertEquals("int (*name)(int)", functionDef.getSignature());
        assertEquals("int (*name)(int)", functionDef.getSignatureAsCode());
        assertEquals("int (*name)(int)", functionDef.getExpandedSignature());
        assertEquals("int name(int)", functionDef.asEcSignature());
        assertEquals("\npublic int name(int val);", functionDef.asSignature());
        assertEquals("/*fd1*/int name(int val){\n\nu64 entry__ = __onEnter();int x = val;\nreturn __exitReturn_int_un(x, entry__);\n}\n\n",
            functionDef.asCode());
    }
}