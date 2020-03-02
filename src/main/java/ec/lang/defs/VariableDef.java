package ec.lang.defs;

public class VariableDef extends BaseDef {
    public Enums.Accessor accessor; 
    private String name;
    public TypeIdDef type;
    public ExprDef value;
    public TypeIdDef cast_to;
    public boolean is_reference;
    public boolean is_annoymous = false;
    public int indexSize = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            is_annoymous = true;
            name = "a" + FileDef.getNextValueNumber();
        }
        return name;
    }
       
    public String asHeader() {
        return "";
    }

    public String asCode() {
        return type.asCode() + " " + getName() + (type.is_array ? "[]" : "");
    }

    @Override
    public String toString() {
        return "VariableDef [accessor=" + accessor + ", cast_to=" + cast_to + ", is_reference=" + is_reference
                + ", name=" + getName() + ", type=" + type + ", value=" + value + "]";
    }

}