package ec.lang.defs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopDefTest {
    @Test
    public void testResolve_01() {
        LoopDef loopDef = new LoopDef();
        loopDef.setContainedInBlock(new BlockDef());
        loopDef.blockDef = new BlockDef();
        loopDef.loopOver = new ExprDef();

        loopDef.resolve_01();

    }

}