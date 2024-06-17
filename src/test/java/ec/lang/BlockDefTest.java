package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.TypeIdDef;
import ec.lang.defs.VariableDef;

public class BlockDefTest {
    @Test
    public void testBasicAnnonymous() {
        BlockDef blockDef = new BlockDef();

        char annoy = blockDef.getNextAnnoymous();

        assertEquals('a', annoy, "first annoymous");

        BlockDef blockDef2 = new BlockDef();
        blockDef2.setContainedInBlock(blockDef);

        annoy = blockDef2.getNextAnnoymous();
        assertEquals('b', annoy, "second annoymous");

        annoy = blockDef.getNextAnnoymous();
        assertEquals('b', annoy, "third annoymous");
    }

    @Test
    public void testAddAnnonymousVar() {
        BlockDef blockDef = new BlockDef();

        VariableDef variableDef = new VariableDef();
        variableDef.type = new TypeIdDef("num");

        blockDef.addVariable(variableDef);

        assertEquals("$a", variableDef.getName(), "annonymousname");

    }

    
}