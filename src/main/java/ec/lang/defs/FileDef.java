package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

/**
 * most probably more ComilationUnit.jar
 * 
 * 
 */
public class FileDef extends BaseDef implements ContainerDef {
    public String name;
    public String namespace;

    public List<ClassDef> classes = new ArrayList<>();
    public List<BlockDef> blocks = new ArrayList<>();
    public List<VariableDef> variableDefs = new ArrayList<>();
    public List<FunctionDef> functionDefs = new ArrayList<>();

    public ImportsDef importsDef;

    private static int valueNumber = 0;

    public static int getNextValueNumber() {
        return valueNumber++;
    }

    public String asHeader() {
        return "";
    }

    public String asCode() {
        return "";
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }
}