package ec.lang.defs;

public class BaseDef {
    public BlockDef containedInBlock;

    public String line;
    

    public BaseDef() {}

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }

    public String asLlvm() {
        return "";
    }

    /**
     * 
     */
    public void resolve_01() {

    }

    /**
     * gets called after loadin and before validate();
     * used to create properties accessors and mutators
     * resolve annonyous names
     * point to properties methods etc.
     */
    public void prepare_03() {

    }

    /**
     * verify variables, functions, types exsit etc
     * @return
     */

    public boolean validate_02() {
        return true;
    }
}