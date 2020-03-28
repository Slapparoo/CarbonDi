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
    public String filename;
    public String namespace;

    private List<ClassDef> classes = new ArrayList<>();
    public List<VariableDef> variableDefs = new ArrayList<>();
    public List<FunctionDef> functionDefs = new ArrayList<>();

    private BlockDef blockDef;
    // private BlockDef mainBlock = new BlockDef();

    public ImportsDef importsDef = new ImportsDef();

    private static int valueNumber = 0;


    public void addClass(ClassDef classDef) {
        classes.add(classDef);
        classDef.namespace = namespace;
    }

    public List<ClassDef> getClasses() {
        return classes;
    }


    public void resolve_01() {
        // move everything which is not a function or variable declaration into the main block
        // System.out.println("**resolve**");
        System.out.println("\033[1;33m@@FileDef.resolve \033[0m");

        for (ClassDef classDef : classes) {
            // classDef.resolve_01();
            // System.out.println("(Filelclass) " + classDef.name);
        }


        for (StatementDef statementDef : blockDef.statementDefs) {
            if (statementDef.getClass().equals(FunctionDef.class)) {
                // System.out.println("*function " + statementDef);
                functionDefs.add((FunctionDef)statementDef);
            }   
            if (statementDef.getClass().equals(ClassDef.class)) {
                // System.out.println("*class " + statementDef);
                classes.add((ClassDef)statementDef);
            }   
        }

        // remove functions and variables from main block
        blockDef.statementDefs.removeAll(functionDefs);
        blockDef.statementDefs.removeAll(variableDefs);
        blockDef.statementDefs.removeAll(classes);

        // resolve
        blockDef.resolve_01();

        for (StatementDef statementDef : blockDef.statementDefs) {
            System.out.println("@@FileDef.resolve " + statementDef.getClass().getName());
            statementDef.resolve_01();
        }

        for (VariableDef variableDef : variableDefs) {
            System.out.println("@@FileDef.resolve " + variableDef.getClass().getName());
            variableDef.resolve_01();
        }

        for (FunctionDef functionDef : functionDefs) {
            System.out.println("@@FileDef.resolve " + functionDef.getClass().getName());
            functionDef.resolve_01();
        }
        


        super.resolve_01();
    }

    @Override
    public boolean validate_02() {
        for (ClassDef classDef : classes) {
            // classDef.validate_02();
        }

        return super.validate_02();
    }

    @Override
    public void prepare_03() {
        for (ClassDef classDef : classes) {
            // classDef.prepare_03();
        }
       
        super.prepare_03();
    }

    public static int getNextValueNumber() {
        return valueNumber++;
    }

    public String getFqn() {
        namespace = (namespace == null ? "Default" : namespace);
        return name +"_"+ Math.abs((namespace + '.' + name).hashCode());
    }

    private String getMethodsAsHeader() {
        String res = "";
        for (FunctionDef functionDef : functionDefs) {
            res += "\n"+functionDef.asHeader();
        }

        return res
        + "\nvoid "+mainName()+";";
    }

    public String asHeader() {
        return ""
        + "#ifndef __" + getFqn() +"_"  
        + "\n#define __" + getFqn() +"_"
        + "\n#define __" + name.trim() + "_" + namespace.trim().replace('.', '_') + "__"
        + "\n#include \"types.h\""
        + getContainedClasses()
        + getMethodsAsHeader()
        + "\n#endif";
        
    }

    private String getMethodsAsCode() {
        // potential ordering issues
        String res = "";
        for (VariableDef variableDef : variableDefs) {
            res += "\n"+variableDef.asCode() + ";";
        }

        res += "\n";

        for (FunctionDef functionDef : functionDefs) {
            res += "\n"+functionDef.asCode();
        }

        return res;
    }

    private String getContainedClasses() {
        String res = "";
        for (ClassDef classDef : classes) {
            res += "\n#include \"" + classDef.filename + ".h\""; 
        }

        return res;
    }

    public String mainName() {
        return getFqn()+"_main()";
    }

    public String asCode() {
        return "#include \""+ filename + ".h\""
            + getMethodsAsCode()
            + "\nvoid "+mainName() +" " + (blockDef == null ? "" : blockDef.asCode());
    }

    @Override
    public List<VariableDef> variableDefs() {
        return variableDefs;
    }

    public BlockDef getBlockDef() {
        return blockDef;
    }

    public void setBlockDef(BlockDef blockDef) {
        // System.out.println("(FileDef setBlock)");
        this.blockDef = blockDef;
    }
}