package ec.lang.defs.expressions;

// import ec.lang.defs.*;

public class IncDecDef extends TypeExpr {
    public IncDecDef(String value) {
        super(value);
    }

    public String prefix = null;
    public String suffix = null;

    public String asCode() {
        return (prefix == null ? "" : prefix) +expr+(suffix == null ? "" : suffix);
    }
}