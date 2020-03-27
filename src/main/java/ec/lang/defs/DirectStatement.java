package ec.lang.defs;

/**
 * Allows the direct defintion of c code
 */
public class DirectStatement extends StatementDef {
    public String value;

    public DirectStatement(String value) {
        this.value = value;
    }

    @Override
    public String asCode() {
        return value;
    }

}