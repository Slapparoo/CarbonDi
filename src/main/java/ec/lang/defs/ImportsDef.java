package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class ImportsDef extends BaseDef {

    public List<String> imports = new ArrayList<>();

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }
}