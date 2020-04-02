package ec.lang.defs;

public class BaseDef {
    public BlockDef containedInBlock;

    public String line;
    
    private int resolveCount = 0;

    public boolean isResolved() {
        return resolveCount > 0;
    }

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
        resolveCount++;
        if (resolveCount > 0) {
            System.out.println("@@@rescount " + resolveCount + " " + this.getClass().getName());
        } 
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