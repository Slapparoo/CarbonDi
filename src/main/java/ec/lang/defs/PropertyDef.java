package ec.lang.defs;

public class PropertyDef extends BaseDef {
    public String name;
    public String type;
    public FunctionDef getter;
    public FunctionDef setter;

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }
}