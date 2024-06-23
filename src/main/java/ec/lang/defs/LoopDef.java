package ec.lang.defs;

import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import ec.lang.defs.expressions.ConstExpr;
import ec.lang.defs.expressions.FunctionCallExpr;
import ec.lang.defs.expressions.MultiTypeExpr;
import ec.lang.defs.expressions.OperationExpr;
import ec.lang.defs.expressions.ParenExpr;
import ec.lang.defs.expressions.RangeExpr;
import ec.lang.defs.expressions.TypeExpr;
import lombok.NonNull;

/**
 * 4 types of loop
 * <li>boolean conditional <b>loop(true)</b>
 * <li>incremental/decremental <b>loop(100) / loop(-100)</b>
 * <li>range <b>loop(10..20) / loop(20..10)</b>
 * <li>over an array <b>loop(itemsArray)</b>
 * 
 * loops can also have a return type based on a cast i.e
 * <p>
 * 
 * @hasItem = (boolean)loop(items)
 *          </p>
 *          <p>
 * @countStatus = (num.u)loop(items)
 *              </p>
 *              <p>
 * @subList = (Items[])loop(items)
 *          </p>
 * 
 *          the return value is set with either <b>return value</b>; or
 *          <b>return.add(value);</b>
 */
public class LoopDef extends StatementDef implements ContainerDef {
    @NonNull
    public BlockDef blockDef;
    public TypeIdDef returnType;
    @NonNull
    public ExprDef loopOver;

    @Override
    public void resolve_01() {
        super.resolve_01();

        loopOver.setContainedInBlock(getContainedInBlock());
        blockDef.setContainedInBlock(getContainedInBlock());
        if (loopOver.getContainedInBlock() == null) {
            throw new NullPointerException("loopOver.containedInBlock == null");
        }

        loopOver.resolve_01();

        VariableDef counter = null;
        if (loopOver instanceof ParenExpr) {
            ParenExpr p = (ParenExpr) loopOver;

            if (p.enclosed.getThisType().isIs_array()) {

                counter = new VariableDef();
                counter.setName("$a");
                counter.type = p.enclosed.getThisType();
                counter.setContainedInBlock(blockDef);
                // counter.resolve_01();
                blockDef.addVariable(counter);
            }
        }

        if (counter == null) {
            counter = new VariableDef();
            counter.setName("$a");
            counter.type = new TypeIdDef("i64");
            counter.setContainedInBlock(blockDef);
            counter.resolve_01();
            blockDef.addVariable(counter);
        }

        blockDef.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        // TODO correct name
        // TODO validate name
        // FIX variable name
        if (loopOver instanceof ParenExpr) {
            ParenExpr p = (ParenExpr) loopOver;

            if (p.enclosed != null && p.enclosed.getThisType() != null && p.enclosed.getThisType().isIs_array()) {
                String laLen = "u64 al__ = ((c_2106303_Array_cm *)useObject("
                        + p.enclosed.asCode()
                        + ")->classmodel)->get_length("
                        + p.enclosed.asCode()
                        + ");";

                String itemType = p.enclosed.getThisType().getName();
                String ayItem = itemType + "* a__a = (" + itemType + "*)((c_2106303_Array_cm *)useObject("
                        + p.enclosed.asCode()
                        + ")->classmodel)->get("
                        + p.enclosed.asCode()
                        + ", i__);";

                return "/*la1*/"
                        + laLen
                        + "\nfor (u64 i__ = 0; i__ < al__; i__++) {"
                        + ayItem
                        + blockDef.asCode()
                        + "\n}";

            } else if (p.enclosed instanceof TypeExpr
                    || p.enclosed instanceof ConstExpr
                    || p.enclosed instanceof MultiTypeExpr
                    || p.enclosed instanceof FunctionCallExpr) {
                String ex = p.enclosed.asCode();
                // do nothing for 0
                return
                "\nfor (num a__a = 0; a__a < " + ex + "; a__a++)"
                        + blockDef.asCode();

            } else if (p.enclosed instanceof OperationExpr) {
                OperationExpr operationExpr = (OperationExpr) p.enclosed;
                if (OperatorTypes.COMPARATORS.contains(operationExpr.expr)) {
                    String ex = p.enclosed.asCode();
                    return "\nwhile (" + ex + ")"
                            + blockDef.asCode();
                } else {
                    String ex = p.enclosed.asCode();
                    // do nothing for 0
                    return
                    "\nfor (num a__a = 0; a__a < " + ex + "; a__a++)"
                            + blockDef.asCode();
                }

            } else {
                throw new RuntimeException("Loop type error " + p.enclosed);
            }
        }

        if (loopOver instanceof RangeExpr) {
            RangeExpr rangeExpr = (RangeExpr) loopOver;
            return "if (" + rangeExpr.start + " < " + rangeExpr.end + ") {"
                    + "\nfor (num a__a = " + rangeExpr.start + "; a__a <= " + rangeExpr.end + "; a__a++)"
                    + blockDef.asCode()
                    + "\n } else if (" + rangeExpr.start + " > " + rangeExpr.end + ") {"
                    + "\nfor (num a__a = " + rangeExpr.start + "; a__a >= " + rangeExpr.end + "; a__a--)"
                    + blockDef.asCode()
                    + "\n}";
        }
        throw new RuntimeException("Loop type error " + loopOver);

    }

    @Override
    public List<VariableDef> getVariableDefs() {
        return List.of();
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        this.blockDef = blockDef;
    }

}