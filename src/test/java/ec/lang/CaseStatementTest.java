package ec.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ec.lang.defs.CaseStatement;
import ec.lang.defs.expressions.ConstExpr;
import ec.lang.defs.expressions.RangeExpr;

public class CaseStatementTest extends BaseTest {

    @Test
    public void basicTestConst() {
        CaseStatement caseStatement = new CaseStatement();
        caseStatement.setExprDef(new ConstExpr("10", "i64"));

        caseStatement.resolve_01();
        caseStatement.prepare_03();

        assertEquals("\ncase 10 :", caseStatement.asCode(), "test const 10");
    }

    @Test
    public void basicTestRange() {
        CaseStatement caseStatement = new CaseStatement();
        caseStatement.setExprDef(new RangeExpr("1..10"));

        caseStatement.resolve_01();
        caseStatement.prepare_03();

        String res = "\ncase 1 :\ncase 2 :\ncase 3 :\ncase 4 :\ncase 5 :\ncase 6 :\ncase 7 :\ncase 8 :\ncase 9 :\ncase 10 :";
        assertEquals(res, caseStatement.asCode(), "test range 1..10");
    }

}