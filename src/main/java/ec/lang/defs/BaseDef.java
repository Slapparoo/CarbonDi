package ec.lang.defs;

public class BaseDef {
    public BlockDef containedInBlock;

    public String hasNot = "";

    private String line;
    
    private int resolveCount = 0;

    public boolean isResolved() {
        return resolveCount > 0;
    }

    public BaseDef() {
        line = "";      
    }


    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }

    // public String asLlvm() {
    //     return "";
    // }

    public String asSignature() {
        return "";
    }


    public String asDebug() {
        return line;
    }

    /**
     * 
     */
    public void resolve_01() {
        resolveCount++;
    }

    /**
     * gets called after loadin and before validate();
     * used to create properties accessors and mutators
     * resolve annonyous names
     * point to properties methods etc.
     */
    public void prepare_03() {

    }

    public void optimise_04() {

    }


    /**
     * verify variables, functions, types exsit etc
     * @return
     */

    public boolean validate_02() {
        return true;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}