package ec.lang.defs;

import java.util.Arrays;
import java.util.List;

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
public class LoopDef extends ExprDef implements ContainerDef {
    public BlockDef content;
    public TypeIdDef returnType;
    public ExprDef loopOver;
    public VariableDef variable;

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }

    @Override
    public List<VariableDef> variableDefs() {
        return (List<VariableDef>)Arrays.asList(variable);
    }

}