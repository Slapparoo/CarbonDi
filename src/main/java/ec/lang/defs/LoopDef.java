package ec.lang.defs;

import java.util.Arrays;
import java.util.List;

import ec.lang.defs.expressions.ConstExpr;
import ec.lang.defs.expressions.ParenExpr;
import ec.lang.defs.expressions.RangeExpr;
import ec.lang.defs.expressions.TypeExpr;

/**
 * 4 types of loop
 * <li>boolean conditional <b>loop(true)</b>
 * <li>incremental/decremental <b>loop(100) / loop(-100)</b>
 * <li>range <b>loop(10..20) / loop(20..10)</b>
 * <li>over an array <b>loop(itemsArray)</b>
 * 
 * loops can also have a return type based on a cast i.e
 * <p>
 * @hasItem = (boolean)loop(items)
 * </p>
 * <p>
 * @countStatus = (num.u)loop(items)
 * </p>
 * <p>
 * @subList = (Items[])loop(items)
 * </p>
 * 
 * the return value is set with either <b>return value</b>; or
 * <b>return.add(value);</b>
 */
public class LoopDef extends StatementDef implements ContainerDef {
    public BlockDef blockDef;
    public TypeIdDef returnType;
    public ExprDef loopOver;
    public VariableDef variable;


    @Override
    public void resolve_01() {
        System.out.println("@@LoopDef.resolve ");
        loopOver.resolve_01();
        blockDef.resolve_01();
        super.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        System.out.println("@@loop.asCode " + loopOver.getClass());

//****************** seperate boolean */


        if (loopOver instanceof ParenExpr) {
            ParenExpr p = (ParenExpr) loopOver;
            System.out.println("@@loop.asCode " + p.enclosed.getClass());
            if (p.enclosed instanceof TypeExpr || p.enclosed instanceof ConstExpr) {
                String ex = p.enclosed.asCode();
                // do nothing for 0
                return "if ("+ex+" > 0) {"
                 + "\nfor (num a__a = 0; a__a < "+ex+"; a__a++)"
                + blockDef.asCode()
                + "\n} else if ("+ex+" < 0) {"
                + "\nnum a__a = "+ex+" *-1 -1;"
                + "\nfor (; a__a >= 0; a__a--)"
                + blockDef.asCode()
                + "\n}";
            }
        }

        if (loopOver instanceof RangeExpr) {
            System.out.println("@@loop.asCode RangeExpr " + blockDef.asCode());
            RangeExpr rangeExpr = (RangeExpr) loopOver;
            return "if ("+rangeExpr.start+" < "+rangeExpr.end+") {"
            + "\nfor (num a__a = "+rangeExpr.start+"; a__a <= "+rangeExpr.end+"; a__a++)"
            + blockDef.asCode()
            + "\n } else if ("+rangeExpr.start+" > "+rangeExpr.end+") {"
            + "\nfor (num a__a = "+rangeExpr.start+"; a__a >= "+rangeExpr.end+"; a__a--)"
            + blockDef.asCode()
            + "\n}";
        }

        System.out.println("@@loop " + loopOver.getClass());
        return "";
    }

    @Override
    public List<VariableDef> variableDefs() {
        return (List<VariableDef>)Arrays.asList(variable);
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        this.blockDef = blockDef;
    }

}