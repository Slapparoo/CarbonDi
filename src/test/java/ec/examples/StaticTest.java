package ec.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ec.lang.defs.BlockDef;
import ec.lang.defs.DefFactory;

public class StaticTest extends BaseExamples {

    @Test
    void testValues() {
        BlockDef blockDef = DefFactory.getCurrentBlock();

        blockDef.resolve_01();
    }

    @BeforeAll
    static void loadStaticEc() {
        loadExample("static.ec");
    }
    
}