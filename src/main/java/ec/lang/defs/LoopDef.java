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
        // System.out.println("@@LoopDef.resolve ");
        super.resolve_01();

        loopOver.containedInBlock = this.containedInBlock;
        blockDef.containedInBlock = this.containedInBlock;
        if (loopOver.containedInBlock == null) {
            throw new NullPointerException("loopOver.containedInBlock == null");
        }

        loopOver.resolve_01();

        VariableDef counter = null;
        if (loopOver instanceof ParenExpr) {
            ParenExpr p = (ParenExpr) loopOver;

            if (p.enclosed.thisType.isIs_array()) {

                counter = new VariableDef();
                counter.setName("$a");
                counter.type = p.enclosed.thisType;
                counter.containedInBlock = blockDef;
                // counter.resolve_01();
                blockDef.addVariable(counter);
            } 
        }
            
        if (counter == null) {
            counter = new VariableDef();
            counter.setName("$a");
            counter.type = new TypeIdDef("i64");
            counter.containedInBlock = blockDef;
            counter.resolve_01();
            blockDef.addVariable(counter);
        }

        blockDef.resolve_01();
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        // System.out.println("@@loop.asCode " + loopOver.getClass());

//****************** seperate boolean */

// TODO correct name 
// TODO validate name
// FIX variable name
        if (loopOver instanceof ParenExpr) {
            ParenExpr p = (ParenExpr) loopOver;
            // System.out.println("@@loop.asCode " + p.enclosed.getClass() + ", " + p.enclosed.asCode());

            if (p.enclosed != null && p.enclosed.thisType != null &&  p.enclosed.thisType.isIs_array()) {
                // System.out.println("@@Loop array " + p.enclosed.getClass());

                // u64 al = ((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get_length(numbers);

                String laLen = "u64 al__ = ((c_2106303_Array_cm *)useObject("
                +p.enclosed.asCode()
                +")->classmodel)->get_length("
                +p.enclosed.asCode()
                +");";

                // *(i8 *)((c_2106303_Array_cm *)useObject(numbers)->classmodel)->get(numbers, 6)
                String itemType = p.enclosed.thisType.getName();
                String ayItem = itemType + "* a__a = ("+itemType+"*)((c_2106303_Array_cm *)useObject("
                +p.enclosed.asCode()
                +")->classmodel)->get("
                +p.enclosed.asCode()
                +", i__);";

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
                // "if ("+ex+" > 0) {"
                //  + "\nfor (num a__$a = 0; a__$a < "+ex+"; a__$a++)"
                // + blockDef.asCode()
                // + "\n} else if ("+ex+" < 0) {"
                // + "\nnum a__$a = "+ex+" *-1 -1;"
                // + "\nfor (; a__$a >= 0; a__$a--)"
                // + blockDef.asCode()
                // + "\n}";

                "\nfor (num a__a = 0; a__a < "+ex+"; a__a++)"
               + blockDef.asCode();

            } else if (p.enclosed instanceof OperationExpr) {
                // System.out.println("@@loopover " + p.enclosed);
                OperationExpr operationExpr = (OperationExpr) p.enclosed;
                if (OperatorTypes.COMPARATORS.contains(operationExpr.expr)) {
                    String ex = p.enclosed.asCode();
                    return 
                        "\nwhile ("+ex+")"
                        + blockDef.asCode();
                } else {
                    String ex = p.enclosed.asCode();
                    // do nothing for 0
                    return 
                    // "if ("+ex+" > 0) {"
                    //  + "\nfor (num a__$a = 0; a__$a < "+ex+"; a__$a++)"
                    // + blockDef.asCode()
                    // + "\n} else if ("+ex+" < 0) {"
                    // + "\nnum a__$a = "+ex+" *-1 -1;"
                    // + "\nfor (; a__$a >= 0; a__$a--)"
                    // + blockDef.asCode()
                    // + "\n}";
    
                    "\nfor (num a__a = 0; a__a < "+ex+"; a__a++)"
                   + blockDef.asCode();
    
                }
                
            } else {
                throw new RuntimeException("Loop type error " + p.enclosed);
            }

            

        }

        if (loopOver instanceof RangeExpr) {
            // System.out.println("@@loop.asCode RangeExpr " + blockDef.asCode());
            RangeExpr rangeExpr = (RangeExpr) loopOver;
            return "if ("+rangeExpr.start+" < "+rangeExpr.end+") {"
            + "\nfor (num a__a = "+rangeExpr.start+"; a__a <= "+rangeExpr.end+"; a__a++)"
            + blockDef.asCode()
            + "\n } else if ("+rangeExpr.start+" > "+rangeExpr.end+") {"
            + "\nfor (num a__a = "+rangeExpr.start+"; a__a >= "+rangeExpr.end+"; a__a--)"
            + blockDef.asCode()
            + "\n}";
        }

        // System.out.println("@@loop " + loopOver.getClass());
        // return "";
        throw new RuntimeException("Loop type error " + loopOver);

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