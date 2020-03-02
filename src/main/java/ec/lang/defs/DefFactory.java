package ec.lang.defs;

import java.util.ArrayList;
import java.util.List;

public class DefFactory {

    public static final List<FileDef> FILE_DEFS = new ArrayList<>();
    public static final List<ClassDef> CLASS_DEFS = new ArrayList<>();
    public static final List<FunctionDef> FUNCT_DEFS = new ArrayList<>();
    public static final List<VariableDef> VAR_DEFS = new ArrayList<>();

    public static ClassDef in_class = null;
    public static FileDef in_file = null;
    public static FunctionDef in_funct = null;
    public static FunctionDef in_funct_def = null;
    private static FunctionDef last_in_funct_def = null;

    public static void endFunctionDef() {
        last_in_funct_def = in_funct_def;
        in_funct_def = null;
    }

    public static void startFunctImpl() {
        in_funct = last_in_funct_def;
    }

    public static ClassDef newClassDef() {
        ClassDef def = new ClassDef();
        CLASS_DEFS.add(def);
        in_class = def;

        if (in_file != null) {
            in_file.classes.add(def);
        }
        return def;
    }

    public static FileDef newFileDef() {
        FileDef def = new FileDef();
        FILE_DEFS.add(def);
        in_file = def;

        return def;
    }

    public static FunctionDef newFunctDef() {
        FunctionDef def = new FunctionDef();
        FUNCT_DEFS.add(def);
        in_funct_def = def;

        if (in_class != null) {
            in_class.functionDefs.add(def); 
        } else {
            in_file.functionDefs.add(def);
        }

        return def;
    }

    public static VariableDef newVarDef() {
        VariableDef def = new VariableDef();
        VAR_DEFS.add(def);

        if (in_funct_def != null) {
            in_funct_def.parameters.add(def);  
        } else {
            if (in_funct != null) {
                in_funct.content.variableDefs.add(def);
            } else if (in_class != null) {
                in_class.variableDefs.add(def);
            } else {
                in_file.variableDefs.add(def);
            }   
        }

        return def;
    }
}